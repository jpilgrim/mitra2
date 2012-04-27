/*******************************************************************************
 * Copyright (c) 2012 Jens von Pilgrim
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Jens von Pilgrim - initial API and implementation
 ******************************************************************************/

package de.jevopi.mitra2.exec;

import static java.util.Collections.emptyMap;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.Vector;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;

import de.jevopi.mitra2.MitraUtils;
import de.jevopi.mitra2.context.PathHandler.ResourceType;
import de.jevopi.mitra2.context.ProjectContext;
import de.jevopi.mitra2.engine.RuleResolver;
import de.jevopi.mitra2.engine.debug.DebugEventType;
import de.jevopi.mitra2.engine.debug.DebugableInterpreter;
import de.jevopi.mitra2.engine.debug.IDebugableListener;
import de.jevopi.mitra2.engine.debug.IDebuggable;
import de.jevopi.mitra2.engine.debug.TransactionalDebugableInterpreter;
import de.jevopi.mitra2.engine.interpreter.ExecutionContext;
import de.jevopi.mitra2.engine.interpreter.SessionContext;
import de.jevopi.mitra2.engine.interpreter.TraceToRuleDeclarationMapper;
import de.jevopi.mitra2.exec.IResultProcessor.Result;
import de.jevopi.mitra2.message.AbstractMessenger;
import de.jevopi.mitra2.message.IMessageAcceptor;
import de.jevopi.mitra2.message.MessageFormatter;
import de.jevopi.mitra2.metamodel.IMetamodel;
import de.jevopi.mitra2.metamodel.MObject;
import de.jevopi.mitra2.metamodel.MetamodelManager;
import de.jevopi.mitra2.mitra.FormalParameter;
import de.jevopi.mitra2.mitra.MetamodelDeclaration;
import de.jevopi.mitra2.mitra.MitraPackage;
import de.jevopi.mitra2.mitra.Module;
import de.jevopi.mitra2.mitra.ParameterModifier;
import de.jevopi.mitra2.mitra.RuleDeclaration;
import de.jevopi.mitra2.traces.Model;
import de.jevopi.mitra2.traces.Trace;
import de.jevopi.mitra2.traces.TraceRecord;
import de.jevopi.mitra2.traces.TraceValidationError;
import de.jevopi.mitra2.traces.TraceValidator;
import de.jevopi.mitra2.traces.TracesFactory;
import de.jevopi.utils.ComposedIterable;

/**
 * The executor is a facade for the Mitra interpreter
 * 
 * @author Jens von Pilgrim
 */
public class StandaloneExecutor extends AbstractMessenger implements
		IDebugableListener {

	private final Map<String, Object> arguments;

	private final String fqnRuleToExecute;

	private DebugableInterpreter interpreter;

	protected Map<String, String> outputFilenames;

	protected final Vector<IDebugableListener> preparedListeners;

	private final ProjectContext projectContext;

	private Map<String, Object> result;

	private IResultProcessor resultProcessor;

	private SessionContext sessionContext;

	IMitraConfig mitraConfig;

	/**
	 * 
	 */
	public StandaloneExecutor(String fqnRule, Map<String, Object> arguments,
			Map<String, String> outputFilenames, IMitraConfig configuration) {

		mitraConfig = configuration;

		fqnRuleToExecute = fqnRule;
		this.arguments = arguments;
		this.outputFilenames = outputFilenames;
		interpreter = null;
		preparedListeners = new Vector<IDebugableListener>(2);
		result = Collections.emptyMap();
		sessionContext = null;

		projectContext = createProjectContext();
		projectContext.getPathHandler().setPaths(configuration);
	}

	@Override
	protected IMessageAcceptor getMessageAcceptor() {
		return projectContext.getMessageAcceptor();
	}

	protected ProjectContext createProjectContext() {
		return new ProjectContext();
	}

	public ProjectContext getProjectContext() {
		return projectContext;
	}

	/**
	 * Remove all listener from the interpreter. Note that this method has no
	 * effect on an actually running interpreter.
	 * 
	 * @see java.util.Vector#clear()
	 */
	public void clearPreparedDebugableListener() {
		preparedListeners.clear();
	}

	/**
	 * @return
	 */
	protected ExecutionContext createExecutionContext() {
		RuleResolver ruleResolver = new RuleResolver(projectContext);
		Map<String, MObject> wrappedArguments = wrapArguments();
		RuleDeclaration invokedRule =
			ruleResolver.findBestMatchingRule(fqnRuleToExecute,
					wrappedArguments);

		if (invokedRule == null) {
			throw new IllegalStateException("No rule " + fqnRuleToExecute
				+ " found.");
		}

		List<MObject> orderedArguments =
			orderArguments(invokedRule, wrappedArguments);

		ExecutionContext executionContext =
			new ExecutionContext(invokedRule, orderedArguments);
		return executionContext;
	}

	/**
	 * Sub-method of {@link #createExecutionContext()}
	 * 
	 * @param rule
	 * @param argumentsByName names must match names of formal parameters
	 * @return
	 */
	private List<MObject> orderArguments(RuleDeclaration rule,
			Map<String, MObject> argumentsByName) {

		List<MObject> orderedArguments =
			new ArrayList<MObject>(argumentsByName.size());
		for (FormalParameter fpar : rule.getFormalParameters()) {
			orderedArguments.add(argumentsByName.get(fpar.getVardecl()
				.getName()));
		}
		return orderedArguments;
	}

	public IDebuggable getDebugable() {
		return interpreter;
	}

	/**
	 * @return
	 */
	public String getDescription() {
		return fqnRuleToExecute;
	}

	public boolean isTerminated() {
		return (interpreter != null && interpreter.isTerminated());
	}

	<T extends EObject> T loadModel(ResourceSet resourceSet, URI uriModule)
			throws IOException {
		Resource resource = resourceSet.createResource(uriModule);

		if (!resource.isLoaded()) {
			resource.load(null);
		}
		@SuppressWarnings("unchecked")
		T content = (T) resource.getContents().get(0);
		return content;
	}

	/**
	 * Adds a listener to the interpreter. Note that this method only prepares
	 * the listener, as the interpreter is only created when the execution
	 * actually takes place.
	 * 
	 * @param i_debugableListener
	 * @return
	 * @see java.util.Vector#add(java.lang.Object)
	 */
	public void
			prepareDebugableListener(IDebugableListener i_debugableListener) {
		if (i_debugableListener != null) {
			preparedListeners.add(i_debugableListener);
		}
	}

	public synchronized Runnable prepareInterpreter() throws Exception {
		if (interpreter != null && interpreter.isActive()) {
			throw new IllegalStateException("Interpreter is still active.");
		}

		ResourceSet resourceSet = projectContext.getResourceSet();

		// load rule's module
		String moduleName = MitraUtils.getFQModuleName(fqnRuleToExecute);
		String moduleFileName = MitraUtils.convertFQNToPathName(moduleName);
		URI uriModule =
			projectContext.getPathHandler().resolve(ResourceType.MODULE,
					moduleFileName);
		Module module = loadModel(resourceSet, uriModule);
		resolveAll(module);

		TraceRecord traceRecord = loadOrCreateTraceRecord();

		sessionContext = new SessionContext(projectContext, traceRecord);

		ExecutionContext executionContext = createExecutionContext();

		interpreter =
			new TransactionalDebugableInterpreter(sessionContext,
				executionContext);
		result = Collections.emptyMap();

		// add executor in order to collect results
		interpreter.addInterpreterListener(this);

		for (IDebugableListener listener : preparedListeners) {
			interpreter.addInterpreterListener(listener);
		}
		clearPreparedDebugableListener(); // only for one run, executor is
		// reused

		return interpreter;
	}

	/**
	 * @return
	 * @throws IOException
	 */
	private TraceRecord loadOrCreateTraceRecord() throws IOException {
		TraceRecord traceRecord;
		if (!mitraConfig.getTraceModelFilename().isEmpty()
			&& new File(mitraConfig.getTraceModelFilename()).exists()) {
			URI uriTraceModel =
				URI.createFileURI(mitraConfig.getTraceModelFilename());
			traceRecord =
				loadModel(projectContext.getResourceSet(), uriTraceModel);

			// and load referenced models:
			ResourceSet resourceSet = projectContext.getResourceSet();
			for (Model model : traceRecord.getModels()) {
				Resource resource =
					resourceSet.createResource(URI.createURI(model
						.getUriModel()));
				resource.load(emptyMap());
			}

		} else {
			traceRecord = TracesFactory.eINSTANCE.createTraceRecord();
		}
		return traceRecord;
	}

	private void resolveAll(Module module) {
		EcoreUtil.resolveAll(projectContext.getResourceSet());

		MetamodelManager metamodelManager =
			projectContext.getMetamodelManager();
		for (MetamodelDeclaration metamodelDeclaration : module
			.getMetamodelDeclarations()) {
			IMetamodel metamodel =
				metamodelManager.getMetamodel(metamodelDeclaration);
			if (metamodel == null) {
				throw new IllegalStateException(
					"Could not load metamodel "
						+ MessageFormatter
							.stackTraceLikeLocation(metamodelDeclaration));
			}
		}

		EcoreUtil.resolveAll(projectContext.getResourceSet());
	}

	/**
	 * {@inheritDoc} Does nothing since we're only interested in termination
	 * 
	 * @see de.feu.mitra.engine.debugapi.IDebugableListener#processDebugableEvent(de.feu.mitra.engine.debugapi.DebugEventType)
	 */
	@Override
	public void processDebugableEvent(DebugEventType i_eventType) {
		// not processed
	}

	/**
	 * Removes a listener from the interpreter.
	 * 
	 * @param i_o
	 * @return
	 * @see java.util.Vector#remove(java.lang.Object)
	 */
	public void removeDebugableListener(IDebugableListener i_debugableListener) {
		if (i_debugableListener != null) {
			preparedListeners.remove(i_debugableListener);
			if (interpreter != null) {
				interpreter.removeInterpreterListener(i_debugableListener);
			}
		}
	}

	/**
	 * @param i_resultProcessor the resultProcessor to set
	 */
	public void setResultProcessor(IResultProcessor i_resultProcessor) {
		resultProcessor = i_resultProcessor;
	}

	/**
	 * {@inheritDoc} Does nothing since we're only interested in termination
	 * 
	 * @see de.feu.mitra.engine.debugapi.IDebugableListener#suspended()
	 */
	@Override
	public void suspended() {
		// not processed
	}

	/**
	 * @see de.feu.mitra.engine.debugapi.IDebugableListener#terminated()
	 */
	@Override
	public void terminated() {
		ExecutionContext executionContext = interpreter.getExecutionContext();
		Map<String, MObject> mitraResult = executionContext.getResults();

		result = new HashMap<String, Object>();

		for (Entry<String, MObject> entry : mitraResult.entrySet()) {
			result.put(entry.getKey(), entry.getValue().getValue());
		}

		saveOutput();
		saveTraces();

		if (resultProcessor != null) {
			resultProcessor.resultArrived(new Result(result));
		}
	}

	private void saveTraces() {
		if (!mitraConfig.isSaveTraces()) return;

		if (!mitraConfig.isOverwriteTraces()
			&& new File(mitraConfig.getTraceModelFilename()).exists()) {
			warning("Traces file already exists, do not overwrite", null, null,
					-1);
			return;
		}

		TraceRecord traceRecord = sessionContext.getTraceRecord();
		// do not save empty records
		if (traceRecord.getTraces().isEmpty()) {
			warning("No traces found in trace record, do not save empty model",
					null, null, -1);
			return;
		}

		updateTraceRecordModels(traceRecord, arguments, result);

		TraceValidator traceValidator = new TraceValidator();
		TraceToRuleDeclarationMapper mapper =
			new TraceToRuleDeclarationMapper(projectContext);

		List<TraceValidationError> traceValidationErrors =
			traceValidator.validate(traceRecord);
		for (int i = 0; i < 4 && i < traceValidationErrors.size(); i++) {
			TraceValidationError error = traceValidationErrors.get(i);
			Trace trace = error.getTrace();
			RuleDeclaration rule =
				mapper.findRuleDeclarationForTrace(error.getTrace());
			if (rule == null) {
				warning(error.getMesssage() + ". Rule " + trace.getRuleName()
					+ " not found.", null, null, -1);
			} else {
				warning(error.getMesssage(),
						rule,
						rule.eClass().getEStructuralFeature(
								MitraPackage.RULE_DECLARATION__TRACED), -1);
			}
		}

		boolean volatileTracesRemoved =
			traceValidator.removeVolatileTraces(traceRecord);
		if (volatileTracesRemoved) {
			warning("Removed traces with dangling references from trace record (hint: use stealth modifier to avoid this problem).",
					null, null, -1);
		}

		URI uri = URI.createFileURI(mitraConfig.getTraceModelFilename());
		Resource resource = projectContext.getResourceSet().createResource(uri);
		resource.getContents().add(traceRecord);
		try {
			resource.save(emptyMap());
		} catch (Throwable ex) {
			error("Error saving trace model to " + uri + ":\n"
				+ ex.getMessage(), null, null, -1);
			ex.printStackTrace();
		}
	}

	/**
	 * 
	 */
	private void saveOutput() {
		ResourceSet resourceSet = projectContext.getResourceSet();
		for (Entry<String, Object> entry : result.entrySet()) {
			String argName = entry.getKey();
			Object rawValue = entry.getValue();

			String fileName = outputFilenames.get(argName);
			URI uri = URI.createFileURI(fileName);

			Resource resource = resourceSet.createResource(uri);
			// TODO support other output types, e.g., String
			resource.getContents().add((EObject) rawValue);
			try {
				resource.save(emptyMap());
			} catch (Throwable ex) {
				error("Error saving model " + argName + " to " + uri + ":\n"
					+ ex.getMessage(), null, null, -1);
				ex.printStackTrace();
			}
		}
		RuleDeclaration invokedRule =
			interpreter.getExecutionContext().getInvokedRule();
		for (int i = 0; i < invokedRule.getFormalParameters().size(); i++) {
			FormalParameter fpar = invokedRule.getFormalParameters().get(i);
			if (fpar.getModifier() == ParameterModifier.INTO
				|| fpar.getModifier() == ParameterModifier.USE) {
				MObject mobject =
					interpreter.getExecutionContext().getArguments().get(i);
				if (mobject.getValue() instanceof EObject) {
					EObject rawArg = (EObject) mobject.getValue();
					Resource res = rawArg.eResource();
					try {
						if (res != null) res.save(emptyMap());
					} catch (Throwable ex) {
						String uriString =
							res != null ? res.getURI().toString()
								: "unknown location";
						error("Error saving used model "
							+ fpar.getVardecl().getName() + " to " + uriString
							+ ":\n" + ex.getMessage(), null, null, -1);
						ex.printStackTrace();
					}
				}
			}
		}
	}

	/**
	 * @return
	 */
	private Map<String, MObject> wrapArguments() {
		Map<String, MObject> wrappedArguments = new HashMap<String, MObject>();
		MetamodelManager metamodelManager =
			projectContext.getMetamodelManager();
		for (Map.Entry<String, Object> rawArg : arguments.entrySet()) {
			Object rawValue = rawArg.getValue();
			if (rawValue instanceof EObject) {
				EObject eobj = (EObject) rawValue;
				if (eobj.eIsProxy()) {
					EcoreUtil.resolveAll(eobj);
				}
			}

			MObject wrappedValue = metamodelManager.wrap(rawValue);
			if (wrappedValue == null) {
				throw new IllegalArgumentException("Cannot wrap argument "
					+ rawArg.getKey());
			}
			wrappedArguments.put(rawArg.getKey(), wrappedValue);
		}

		return wrappedArguments;
	}

	/**
	 * Update model settings in trace record. This cannot be done before saving
	 * the output models, as we need their resources.
	 */
	@SuppressWarnings("unchecked")
	public void updateTraceRecordModels(TraceRecord io_traceRecord,
			Map<String, Object> arguments, Map<String, Object> result) {
		Map<EObject, Resource> roots = new HashMap<EObject, Resource>();
		for (Object arg : ComposedIterable.compose(arguments.values(),
				result.values())) {
			if (arg instanceof EObject) {
				EObject eObject = (EObject) arg;
				Resource resource = eObject.eResource();
				if (resource != null) {
					while (eObject.eContainer() != null)
						eObject = eObject.eContainer();
					roots.put(eObject, resource);
				}

			}
		}

		Set<EObject> knownRoots = new HashSet<EObject>();
		for (Model models : io_traceRecord.getModels()) {
			knownRoots.add(models.getModelRoot());
		}

		for (Map.Entry<EObject, Resource> e : roots.entrySet()) {
			if (!knownRoots.contains(e.getKey())) {
				Model model = TracesFactory.eINSTANCE.createModel();
				model.setModelRoot(e.getKey());
				model.setUriModel(e.getValue().getURI().toString());
				io_traceRecord.getModels().add(model);
			}
		}

	}

}
