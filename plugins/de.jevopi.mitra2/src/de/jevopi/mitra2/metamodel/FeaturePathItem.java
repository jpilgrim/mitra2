/*******************************************************************************
 * Copyright (c) 2012 Jens von Pilgrim
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Jens von Pilgrim - initial API and implementation
 **************************************************************************** */
package de.jevopi.mitra2.metamodel;

import java.util.Collections;
import java.util.List;

import de.jevopi.mitra2.mitra.Feature;
import de.jevopi.mitra2.mitra.IteratorExpression;

/**
 * Describes a feature access path. There are two types of feature accesses:
 * variable access (see {@link VariableAccessPath}) and static access (see
 * {@link StaticAccessPath}). In both cases, the feature path contains the path
 * <em>after</em> the first "dot", e.g., a statement <code><pre>
 * a.b.c
 * </pre></code> contains the feature path <code>b.c</code>. <code>a</code> is
 * the variable access (or, in case of <code>$a.b.c</code> the static access).
 * path item within a {@link VariableAccessPath}.
 * <p>
 * There are four types of feature accesses:
 * <dl>
 * <dt>field</dt>
 * <dd>This simply is an access to a (static) field, e.g., <code>a.field</code></dd>
 * <dt>item</dt>
 * <dd>An item access is a selection of an item of a collection, e.g.,
 * <code>a.field[index]</code>. This is stored separately here, that is
 * <code>a.field[index]</code> would result in a feature path with two items:
 * the field access <em>and</em> the index. Actually, item access os a short
 * version of <code>a.field.item->get(index)</code>. Note that a static access
 * must not start with an index access.</dd>
 * <dt>method</dt>
 * <dd>Access of an elements operation, e.g., <code>a.foo(args)</code></dd>
 * <dt>nativeOperation</dt>
 * <dd>Access of a native operation, e.g., <code>a->foo(args)</code></dd>
 * </dl>
 * </p>
 * 
 * @author Jens von Pilgrim
 */
public class FeaturePathItem<T> {

	/**
	 * Placeholder for name used in case of reflection, that is in that case
	 * name is null but an expression is specified.
	 */
	public static String REFLECTION = "?";

	// public final static String GETSET = "";

	private List<T> arguments;

	private IteratorExpression iteratorExpression;

	private FeatureDescription featureDescription;

	/**
	 * Basically used for location retrieval
	 */
	private Feature feature;
	
	

	@SuppressWarnings("unchecked")
	public FeaturePathItem(Feature feature, FeatureFieldDescription featureFieldDescription) {
		this(feature, featureFieldDescription, (List<T>) Collections.emptyList(), null);
	}

	public FeaturePathItem(Feature feature, FeatureDescription featureDescription,
			List<T> i_list, IteratorExpression i_expression) {
		if (i_list == null) {
			throw new NullPointerException("arguments must not be null");
		}
		if (featureDescription == null) {
			throw new NullPointerException(
					"featureDescription must not be null");
		}
		
		this.feature = feature;

		this.featureDescription = featureDescription;
		this.arguments = i_list;
		iteratorExpression = i_expression;

		if (featureDescription.isField() && i_list.size() > 0) {
			throw new IllegalArgumentException("Fields cannot have arguments");
		}
	}
	
	/**
	 * Basically used for location retrieval in case of errors.
	 * @return
	 */
	public Feature getFeature() {
		return feature;
	}

	/**
	 * @return the iteratorExpression, may be null
	 */
	public IteratorExpression getIteratorExpression() {
		return iteratorExpression;
	}

	/**
	 * @return the featureDescription
	 */
	public FeatureDescription getFeatureDescription() {
		return featureDescription;
	}

	public boolean hasArguments() {
		return !arguments.isEmpty();
	}

	/**
	 * @return the arguments
	 */
	public List<T> getArguments() {
		return arguments;
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder strb = new StringBuilder();
		strb.append(featureDescription.getName());

		if (!featureDescription.isField()) {
			strb.append('(');
		}

		boolean bFirst = true;
		for (T arg : arguments) {
			if (!bFirst) {
				strb.append(", ");
			} else {
				bFirst = false;
			}
			strb.append(arg.toString());
		}
		if (!featureDescription.isField()) {
			strb.append(')');
		}

		return strb.toString();
	}

}