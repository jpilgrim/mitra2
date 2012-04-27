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
package de.jevopi.mitra2.context;

import static de.jevopi.mitra2.context.PathHandler.ResourceType.METAMODEL;
import static de.jevopi.mitra2.context.PathHandler.ResourceType.MODULE;
import static java.util.Collections.emptyMap;
import static java.util.Collections.emptySet;

import java.io.IOException;
import java.io.PrintStream;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.logging.Logger;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;

import de.jevopi.mitra2.MitraUtils;
import de.jevopi.mitra2.context.PathHandler.ResourceType;
import de.jevopi.mitra2.engine.RuleResolver;
import de.jevopi.mitra2.engine.TypeResolver;
import de.jevopi.mitra2.engine.interpreter.Interpreter;
import de.jevopi.mitra2.message.AbstractMessenger;
import de.jevopi.mitra2.message.IMessageAcceptor;
import de.jevopi.mitra2.metamodel.MetamodelManager;
import de.jevopi.mitra2.mitra.Module;
import de.jevopi.mitra2.mitra.ModuleReference;
import de.jevopi.mitra2.mitra.QualifiedRuleReference;
import de.jevopi.mitra2.mitra.RuleDeclaration;
import de.jevopi.mitra2.nativeoperations.NativeOperationResolver;

/**
 * Base class for {@link BuildContext} and {@link ExecutionContext}. There
 * should really be more documentation here.
 * 
 * @author Jens von Pilgrim (developer@jevopi.de)
 * @since Feb 8, 2012
 */
public class ProjectContext extends AbstractMessenger {
	/**
	 * Logger for this class
	 */
	// @SuppressWarnings("unused") //$NON-NLS-1$
	private static final Logger logger = Logger.getLogger(ProjectContext.class
		.getName());

	public static boolean hasContext(EObject eobj) {
		if (eobj == null) return false;
		Resource resource = eobj.eResource();
		if (resource == null) return false;
		ResourceSet resourceSet = resource.getResourceSet();
		if (resourceSet == null) return false;

		IProjectContextProvider projectContextProvider = null;
		if (!(resourceSet instanceof IProjectContextProvider)) {
			for (Adapter adapter : resourceSet.eAdapters()) {
				if (adapter instanceof IProjectContextProvider) {
					projectContextProvider = (IProjectContextProvider) adapter;
					break;
				}
			}
		} else {
			projectContextProvider = (IProjectContextProvider) resourceSet;
		}
		if (projectContextProvider == null) return false;
		return projectContextProvider.getProjectContext() != null;
	}

	public static ProjectContext getProjectContext(EObject eobj) {
		Resource resource = eobj.eResource();
		if (resource == null) {
			throw new IllegalArgumentException(
				"Cannot retrieve context from non-peristed object");
		}
		return getProjectContext(resource);
	}

	public static ProjectContext getProjectContext(Resource resource) {
		ResourceSet resourceSet = resource.getResourceSet();
		if (resourceSet == null) {
			throw new IllegalArgumentException(
				"Cannot retrieve context, resource " + resource
					+ " is not in a resoure set.");
		}
		return getProjectContext(resourceSet);
	}

	public static ProjectContext getProjectContext(ResourceSet resourceSet) {

		IProjectContextProvider projectContextProvider = null;
		if (!(resourceSet instanceof IProjectContextProvider)) {
			for (Adapter adapter : resourceSet.eAdapters()) {
				if (adapter instanceof IProjectContextProvider) {
					projectContextProvider = (IProjectContextProvider) adapter;
					break;
				}
			}
			if (projectContextProvider == null) {
				throw new IllegalArgumentException(
					"Cannot retrieve context, no context provider registered to resource set.");
			}
		} else {
			projectContextProvider = (IProjectContextProvider) resourceSet;
		}
		return projectContextProvider.getProjectContext();
	}

	protected MetamodelManager metamodelManager;

	protected Map<RuleDeclaration, Set<RuleDeclaration>> overridingRulesCache;

	protected Map<String, Set<RuleDeclaration>> rulesByNameCache;

	protected Collection<RuleDeclaration> rulesCache;

	protected Map<String, Module> modulesByNameCache;

	protected Map<RuleDeclaration, Set<RuleDeclaration>> triggedRulesCache;

	protected IMessageAcceptor messageAcceptor = IMessageAcceptor.EMPTY;

	public PrintStream out = System.out;
	public PrintStream err = System.err;
	public PrintStream log = System.out;

	/**
	 * The resource set for load modules, metamodels, and models. There is only
	 * one resource set, as modules need to cross reference to metamodels, and
	 * of course models need to cross reference to their metamodel and to other
	 * models (in case of inter-model references, such as traces).
	 */
	protected ResourceSet resourceSet;

	/**
	 * Lazily created in {@link #getTypeResolver()}
	 */
	private TypeResolver typeResolver = null;

	/**
	 * Lazily created in {@link #getRuleResolver()}
	 */
	private RuleResolver ruleResolver = null;

	/**
	 * Lazily created in {@link #getNativeOperationResolver()}
	 */
	private NativeOperationResolver nativeOperationResolver = null;

	private Interpreter interpreter = null;

	PathHandler pathHandler;

	
	WeakReference<EObject> currentInterpreterLocationRef;
	public EObject getCurrentInterpreterLocation() {
		if (currentInterpreterLocationRef==null) return null;
		return currentInterpreterLocationRef.get();
	}
	public void setCurrentInterpreterLocation(EObject location) {
		currentInterpreterLocationRef=new WeakReference<EObject>(location);
	}
	
	
	/**
	 * 
	 */
	public ProjectContext() {
		pathHandler = new PathHandler();
		init();

	}

	public PathHandler getPathHandler() {
		return pathHandler;
	}

	@Override
	public IMessageAcceptor getMessageAcceptor() {
		return messageAcceptor;
	}

	public void setMessageAcceptor(IMessageAcceptor messageAcceptor) {
		if (messageAcceptor == null) {
			this.messageAcceptor = IMessageAcceptor.EMPTY;
		} else {
			this.messageAcceptor = messageAcceptor;
		}
	}

	/**
	 * Sets a resource set which is used for loading and storing modules,
	 * metamodels, and input, output, and trace model. The resource set can only
	 * be set after creating the project context but before execution. That is,
	 * the resoure set can only be set if the current set has not been used yet
	 * (that is it must be empty).
	 * 
	 * @param i_resourceSet the modelResourceSet to set, must not be null and
	 *            old resource set must be empty
	 */
	public void setResourceSet(ResourceSet i_resourceSet) {
		if (!resourceSet.getResources().isEmpty()) {
			throw new IllegalStateException(
				"Cannot set new model resource set, old resource set is not empty: "
					+ resourceSet.getResources());
		}
		/* i_modelResourceSet must not be null */
		if (i_resourceSet == null) {
			throw new NullPointerException(
				"Argument i_modelResourceSet must not be null");
		}

		if (i_resourceSet instanceof IProjectContextProvider) {
			if (((IProjectContextProvider) i_resourceSet).getProjectContext() != this) {
				throw new IllegalArgumentException(
					"wrong context in resource set");
			}
			resourceSet = i_resourceSet;
		} else {
			resourceSet = new DelegatingMitraResourceSet(this, i_resourceSet);
		}
	}

	/**
	 * Returns the interpreter, this must have been set before and may be null.
	 * 
	 * @return the interpreter
	 */
	public Interpreter getInterpreter() {
		return interpreter;
	}

	/**
	 * Sets the interpreter.
	 * 
	 * @param i_interpreter the interpreter to set
	 */
	public void setInterpreter(Interpreter i_interpreter) {
		interpreter = i_interpreter;
	}

	protected final void init() { // final, because called in constructor
		metamodelManager = createMetamodelManager();
		overridingRulesCache =
			new HashMap<RuleDeclaration, Set<RuleDeclaration>>();
		rulesByNameCache = null;
		rulesCache = null;
		triggedRulesCache = null;
		modulesByNameCache = null;

		// TODO move to constructor, listen for changes
		initResourceSet();
	}

	private void initResourceSet() {
		resourceSet = new MitraResourceSet(this);
		resourceSet.setURIConverter(pathHandler.getConverter());
	}

	public synchronized TypeResolver getTypeResolver() {
		if (typeResolver == null) {
			typeResolver = new TypeResolver(this);
		}
		return typeResolver;
	}

	public synchronized RuleResolver getRuleResolver() {
		if (ruleResolver == null) {
			ruleResolver = new RuleResolver(this);
		}
		return ruleResolver;
	}

	public synchronized NativeOperationResolver getNativeOperationResolver() {
		if (nativeOperationResolver == null) {
			nativeOperationResolver = new NativeOperationResolver(this);

		}
		return nativeOperationResolver;
	}

	/**
	 * 
	 */
	public void reset() {
		init();
	}

	protected MetamodelManager createMetamodelManager() {
		return new MetamodelManager(this);
	}

	/**
	 * @return
	 */
	public MetamodelManager getMetamodelManager() {
		return metamodelManager;
	}

	public synchronized Set<RuleDeclaration> getAllRulesByName(String fqn) {
		if (rulesByNameCache == null) {
			createRuleCaches();
		}
		Set<RuleDeclaration> result = rulesByNameCache.get(fqn);
		if (result == null) result = emptySet();
		return result;
	}

	/**
	 * Returns all rules, the result should no be cached.
	 * 
	 * @return
	 */
	public synchronized Collection<RuleDeclaration> getAllRules() {
		if (rulesCache == null) {
			createRuleCaches();
		}
		return rulesCache;
	}

	/**
	 * 
	 */
	private synchronized void createRuleCaches() {
		if (rulesCache == null) {
			Set<Module> modules = retrieveAllModules();
			rulesCache =
				Collections.unmodifiableCollection(retrieveAllRules(modules));

			Map<String, Set<RuleDeclaration>> fqnToRules =
				new HashMap<String, Set<RuleDeclaration>>();
			for (RuleDeclaration rule : rulesCache) {
				String fqn = MitraUtils.fqn(rule);
				Set<RuleDeclaration> overloadedRules = fqnToRules.get(fqn);
				if (overloadedRules == null) {
					overloadedRules = new HashSet<RuleDeclaration>();
					fqnToRules.put(fqn, overloadedRules);
				}
				overloadedRules.add(rule);
			}
			rulesByNameCache = Collections.unmodifiableMap(fqnToRules);
		}
	}

	private Set<Module> retrieveAllModules() {
		try {
			Set<Module> result = new HashSet<Module>();
			for (URI uri : pathHandler.listAllModuleURIs()) {
				Resource resource = resourceSet.createResource(uri);
				resource.load(emptyMap());
				Module module = (Module) resource.getContents().get(0);
				result.add(module);
			}
			return result;
		} catch (IOException ex) {
			throw new IllegalStateException(ex);
		}
	}

	/**
	 * Retrieves all rules defined in given root module or in any other module
	 * directly or indirectly imported by that module. The result should be
	 * cached.
	 * 
	 * @param modules
	 * @return
	 */
	public static Collection<RuleDeclaration> retrieveAllRules(
			Set<Module> modules) {

		Set<Module> processedModules = new HashSet<Module>();
		Set<Module> pendingModules = new HashSet<Module>(modules);

		Collection<RuleDeclaration> allRules = new ArrayList<RuleDeclaration>();

		while (!pendingModules.isEmpty()) {
			Module module = pendingModules.iterator().next();
			pendingModules.remove(module);
			if (processedModules.add(module)) {
				allRules.addAll(module.getRuleDeclarations());
				for (ModuleReference moduleReference : module.getImports()) {
					pendingModules.add(moduleReference.getModule());
				}
			}
		}
		return allRules;
	}

	/**
	 * Returns the reflexive, transitive closure of all rules overriding a given
	 * rule.
	 * 
	 * @param rule
	 * @return
	 */
	public synchronized Set<RuleDeclaration> getOverridingRules(
			RuleDeclaration decl) {
		if (!decl.isVirtual()) {
			return emptySet(); // non-virtual rules cannot be overridden!
		}

		Set<RuleDeclaration> overridingRules = overridingRulesCache.get(decl);
		if (overridingRules == null) {
			overridingRules = new HashSet<RuleDeclaration>();
			// reflexive:
			overridingRules.add(decl);
			// transitive:
			for (RuleDeclaration rule : getAllRules()) {
				if (rule.getOverriddenRule() != null
					&& rule.getOverriddenRule().getRuleDeclaration() == decl) {
					if (rule == decl) {
						runtimeWarning(
								"Cycle in rule overridings detected, rule must not override itself: "
									+ rule, rule);
					} else {
						overridingRules.add(rule);
						overridingRules.addAll(getOverridingRules(rule));
					}
				}
			}
			overridingRulesCache.put(decl, overridingRules);

		}
		return overridingRules;
	}

	public synchronized Set<RuleDeclaration> getTriggeredRules(
			RuleDeclaration triggeringRule) {
		if (triggedRulesCache == null) {
			createTriggeredRulesCache();
		}
		Set<RuleDeclaration> triggeredRules =
			triggedRulesCache.get(triggeringRule);
		if (triggeredRules == null) {
			triggeredRules = Collections.emptySet();
		}
		return triggeredRules;
	}

	protected void createTriggeredRulesCache() {
		triggedRulesCache =
			new HashMap<RuleDeclaration, Set<RuleDeclaration>>();
		for (RuleDeclaration rule : getAllRules()) {
			if (rule.getTrigger() != null) {
				for (QualifiedRuleReference triggeredRuleRefs : rule
					.getTrigger().getTriggerRules()) {
					RuleDeclaration triggeringRule =
						triggeredRuleRefs.getRuleDeclaration();
					Set<RuleDeclaration> triggeredRules =
						triggedRulesCache.get(triggeringRule);
					if (triggeredRules == null) {
						triggeredRules = new HashSet<RuleDeclaration>();
						triggedRulesCache.put(triggeringRule, triggeredRules);
					}
					triggeredRules.add(triggeringRule);
				}
			}
		}
	}

	/**
	 * The resource set used for loading (and storing) modules, metamodels, and
	 * models.
	 * 
	 * @return
	 */
	public ResourceSet getResourceSet() {
		return resourceSet;
	}

	public Resource getMetamodelResource(String fileName, boolean loadOnDemand) {
		return getResource(METAMODEL, fileName, loadOnDemand);
	}

	protected Resource getResource(ResourceType type, String fileName,
			boolean loadOnDemand) {
		URI resolvedURI = getPathHandler().resolve(type, fileName);
		return resourceSet.getResource(resolvedURI, loadOnDemand);
	}

	@Override
	public String toString() {
		return "ProjectContext, modulepath "
			+ pathHandler.basePaths.get(MODULE);
	}

	public synchronized Map<String, Module> getAllModules() {
		if (modulesByNameCache == null) {
			modulesByNameCache = new HashMap<String, Module>();

			for (URI uri : getPathHandler().listAllModuleURIs()) {
				try {
					Resource res = resourceSet.createResource(uri);
					res.load(emptyMap());
					Module m = (Module) res.getContents().get(0);
					modulesByNameCache.put(MitraUtils.fqn(m), m);
				} catch (Exception ex) {
					logger.warning(ex.toString());
				}

			}
		}
		return modulesByNameCache;
	}

}