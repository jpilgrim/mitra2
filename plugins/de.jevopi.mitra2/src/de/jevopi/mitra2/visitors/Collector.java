/*******************************************************************************
 * Copyright (c) 2012 Jens von Pilgrim and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Jens von Pilgrim - initial API and implementation
 ******************************************************************************/
package de.jevopi.mitra2.visitors;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;

/**
 * Collector
 * 
 * @author Jens von Pilgrim (developer@jevopi.de)
 * @since Feb 7, 2012
 */
public abstract class Collector<T extends EObject> extends
		TraversingVisitor<Boolean> {

	public static abstract class Condition<CT extends EObject> {
		public abstract boolean accept(CT element);
	}

	public final static Condition<EObject> NO_CONDITION = new Condition<EObject>() {
		@Override
		public boolean accept(EObject i_element) {
			return true;
		}
	};

	public static <ET extends EObject> List<? extends ET> collectByType(
			final EObject root, final Class<ET> type,
			final Condition<ET> condition) {
		Collector<ET> collector = new Collector<ET>() {
			@SuppressWarnings("unchecked")
			@Override
			protected void add(EObject i_element) {
				if (type.isInstance(i_element)) {
					ET et = (ET) i_element;
					if (condition.accept(et)) {
						resultList.add(et);
					}
				}
			}
		};
		collector.visit(root);
		return collector.resultList;
	}

	public static <ET extends EObject> List<? extends ET> collectByTypeBeforeMarker(
			final EObject root, final EObject marker, final Class<ET> type,
			final Condition<ET> condition) {
		Collector<ET> collector = new Collector<ET>() {
			@SuppressWarnings("unchecked")
			@Override
			protected void add(EObject i_element) {
				if (type.isInstance(i_element)) {
					ET et = (ET) i_element;
					if (condition.accept(et)) {
						resultList.add(et);
					}
				}
				if (i_element == marker) {
					stopped = true;
				}
			}
		};
		collector.visit(root);
		return collector.resultList;
	}

	public static <ET extends EObject> List<? extends ET> collectByTypeAfterMarker(
			final EObject root, final EObject marker, final Class<ET> type,
			final Condition<ET> condition) {
		Collector<ET> collector = new Collector<ET>() {
			@Override
			protected void init() {
				skip = true;
			}

			@SuppressWarnings("unchecked")
			@Override
			protected void add(EObject i_element) {
				if (i_element == marker) {
					skip = false;
				}
				if (!skip && type.isInstance(i_element)) {
					ET et = (ET) i_element;
					if (condition.accept(et)) {
						resultList.add(et);
					}
				}

			}
		};
		collector.visit(root);
		return collector.resultList;
	}

	protected List<T> resultList;

	protected boolean stopped;

	protected boolean skip;

	/**
	 * @param i_defaultReturnValue
	 */
	protected Collector() {
		super(Boolean.TRUE);
		resultList = new ArrayList<T>();
		stopped = false;
		skip = false;
		init();
	}

	protected void init() {
	}

	protected abstract void add(EObject element);

	/**
	 * @see de.jevopi.mitra2.visitors.TraversingVisitor#visit(org.eclipse.emf.ecore.EObject)
	 */
	@Override
	public Boolean visit(EObject i_element) {
		add(i_element);
		if (stopped)
			return false;
		super.visit(i_element);
		return true;
	}

}
