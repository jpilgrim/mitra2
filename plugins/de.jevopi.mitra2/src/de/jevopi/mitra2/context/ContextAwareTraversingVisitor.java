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

import java.util.Collection;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.resource.ResourceSet;

import de.jevopi.mitra2.engine.RuleResolver;
import de.jevopi.mitra2.engine.TypeResolver;
import de.jevopi.mitra2.engine.debug.IDebuggable;
import de.jevopi.mitra2.message.IMessageAcceptor;
import de.jevopi.mitra2.metamodel.MetamodelManager;
import de.jevopi.mitra2.mitra.Module;
import de.jevopi.mitra2.mitra.RuleDeclaration;
import de.jevopi.mitra2.nativeoperations.NativeOperationResolver;
import de.jevopi.mitra2.visitors.TraversingVisitor;

/**
 * Visitor with a project context, including some delegation methods to
 * {@link ProjectContext} getters for convenience. The delegation methods
 * defined in this visitor are declared final to avoid bugs introduced by
 * accidentally overriding these methods and not using the project context. Most
 * getters are declared public in order to be usable by policies and helpers
 * attached to subclasses.
 * 
 * @author Jens von Pilgrim (developer@jevopi.de)
 * @since Feb, 2012
 */
public abstract class ContextAwareTraversingVisitor<T> extends
		TraversingVisitor<T> {

	private final ProjectContext projectContext;

	public ContextAwareTraversingVisitor(ProjectContext projectContext,
			T i_defaultReturnValue) {
		super(i_defaultReturnValue);
		this.projectContext = projectContext;
	}

	public final ProjectContext getProjectContext() {
		return projectContext;
	}

	@Override
	public final IMessageAcceptor getMessageAcceptor() {
		return projectContext.getMessageAcceptor();
	}

	/**
	 * Convenience method, returns {@link ProjectContext the project context's}
	 * {@link ProjectContext#getMetamodelManager() metamodel manager}. Declared
	 * final because no other metamodel manager must be used.
	 * 
	 * @return
	 * @see ProjectContext#getMetamodelManager()
	 * @see IDebuggable#getMetamodelManager()
	 */
	public final MetamodelManager getMetamodelManager() {
		return projectContext.getMetamodelManager();
	}

	/**
	 * Convenience method, returns {@link ProjectContext the project context's}
	 * {@link ProjectContext#getTypeResolver() type resolver}. Declared final
	 * because no other type resolver must be used.
	 * 
	 * @return
	 * @see de.jevopi.mitra2.context.ProjectContext#getTypeResolver()
	 */
	public final TypeResolver getTypeResolver() {
		return projectContext.getTypeResolver();
	}

	/**
	 * Convenience method, returns {@link ProjectContext the project context's}
	 * {@link ProjectContext#getRuleResolver() rule resolver}. Declared final
	 * because no other rule resolver must be used.
	 * 
	 * @return
	 * @see de.jevopi.mitra2.context.ProjectContext#getRuleResolver()
	 */
	public final RuleResolver getRuleResolver() {
		return projectContext.getRuleResolver();
	}

	/**
	 * Convenience method, returns {@link ProjectContext the project context's}
	 * {@link ProjectContext#getResourceSet() resource set}. Declared final
	 * because no other resource set must be used in order to avoid multiple
	 * loading of the same resources and to enable cross-links.
	 * 
	 * @return
	 * @see de.jevopi.mitra2.context.ProjectContext#getResourceSet()
	 */
	public final ResourceSet getResourceSet() {
		return projectContext.getResourceSet();
	}

	/**
	 * Convenience method, returns {@link ProjectContext the project context's}
	 * {@link ProjectContext#getPathHandler() path handler}. Declared final
	 * because no other path handler must be used to avoid weird bugs caused by
	 * different path settings.
	 * 
	 * @return
	 * @see de.jevopi.mitra2.context.ProjectContext#getPathHandler()
	 */
	public final PathHandler getPathHandler() {
		return projectContext.getPathHandler();
	}

	/**
	 * Convenience method, returns {@link ProjectContext the project context's}
	 * {@link ProjectContext#getNativeOperationResolver() native operation
	 * resolver}. Declared final because no other native operation resolver must
	 * be used.
	 * 
	 * @return
	 * @see de.jevopi.mitra2.context.ProjectContext#getNativeOperationResolver()
	 */
	public final NativeOperationResolver getNativeOperationResolver() {
		return projectContext.getNativeOperationResolver();
	}

	/**
	 * Convenience method, returns all rules known in the {@link ProjectContext
	 * the project context} filtered by name. Declared final because the rules
	 * are cached in the project context, and it would be inefficient to use
	 * more than one cache.
	 * 
	 * @param fqn
	 * @return
	 * @see de.jevopi.mitra2.context.ProjectContext#getAllRulesByName(java.lang.String)
	 */
	public final Set<RuleDeclaration> getAllRulesByName(String fqn) {
		return projectContext.getAllRulesByName(fqn);
	}

	/**
	 * Convenience method, returns all rules known in the {@link ProjectContext
	 * the project context}. Declared final because the rules are cached in the
	 * project context, and it would be inefficient to use more than one cache.
	 * 
	 * @return
	 * @see de.jevopi.mitra2.context.ProjectContext#getAllRules()
	 */
	public final Collection<RuleDeclaration> getAllRules() {
		return projectContext.getAllRules();
	}

	/**
	 * Convenience method, returns all rules known in the {@link ProjectContext
	 * the project context} overriding a given rule. Declared final because the
	 * rules are cached in the project context, and it would be inefficient to
	 * use more than one cache.
	 * 
	 * @param decl
	 * @return
	 * @see de.jevopi.mitra2.context.ProjectContext#getOverridingRules(de.jevopi.mitra2.mitra.RuleDeclaration)
	 */
	public final Set<RuleDeclaration> getOverridingRules(RuleDeclaration decl) {
		return projectContext.getOverridingRules(decl);
	}

	/**
	 * Convenience method, returns all rules known in the {@link ProjectContext
	 * the project context} triggered by a given rule. Declared final because
	 * the rules are cached in the project context, and it would be inefficient
	 * to use more than one cache.
	 * 
	 * @param triggeringRule
	 * @return
	 * @see de.jevopi.mitra2.context.ProjectContext#getTriggeredRules(de.jevopi.mitra2.mitra.RuleDeclaration)
	 */
	public final Set<RuleDeclaration> getTriggeredRules(
			RuleDeclaration triggeringRule) {
		return projectContext.getTriggeredRules(triggeringRule);
	}

	/**
	 * Convenience method, returns all modules known in the
	 * {@link ProjectContext the project context}. Declared final because the
	 * modules are cached in the project context, and it would be inefficient to
	 * use more than one cache.
	 * 
	 * @return
	 * @see de.jevopi.mitra2.context.ProjectContext#getAllModules()
	 */
	public final Map<String, Module> getAllModules() {
		return projectContext.getAllModules();
	}

}
