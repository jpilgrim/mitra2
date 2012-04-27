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
package de.jevopi.ecore.utils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

/**
 * DynEcoreDump There should really be more documentation here.
 * 
 * @author Jens von Pilgrim
 */
public class DynEcoreDump {

	public static String dump(Object obj) {
		DynEcoreDump dumper = new DynEcoreDump();
		return dumper.doDump(obj);
	}

	public static String dumpNotNull(Object obj) {
		DynEcoreDump dumper = new DynEcoreDump();
		dumper.setFilterNullValues(true);
		return dumper.doDump(obj);
	}

	StringBuffer strb = new StringBuffer();

	int iOffset = 0;

	HashSet<Object> dumpedObjects = new HashSet<Object>();

	boolean bfilterNullValues = false;

	/**
	 * @return the bfilterNullValues
	 */
	public boolean isFilterNullValues() {
		return bfilterNullValues;
	}

	/**
	 * @param i_bfilterNullValues the bfilterNullValues to set
	 */
	public void setFilterNullValues(boolean i_bfilterNullValues) {
		bfilterNullValues = i_bfilterNullValues;
	}

	public String doDump(Object obj) {
		doSwitch(obj);
		String str = strb.toString();
		iOffset = 0;
		strb.setLength(0);
		dumpedObjects.clear();
		return str;
	}

	private void println(String str) {
		print(str);
		strb.append("\n");
	}

	private void println() {
		strb.append("\n");
	}

	private void print(String str) {
		strb.append(str);
	}

	private void print(int i) {
		strb.append(i);
	}

	private static class FeatureValuePair {
		EStructuralFeature feature;

		Object value;

		/**
		 * @param feature
		 * @param value
		 */
		public FeatureValuePair(EStructuralFeature feature, Object value) {
			this.feature = feature;
			this.value = value;
		}

	}

	/**
	 * @param i_eobj
	 * @param i_i
	 * @param i_strb
	 */
	private void dumpEObject(EObject eobj) {
		dumpedObjects.add(eobj);

		print(eobj.eClass().getName());
		print(" (");
		print(Integer.toHexString(eobj.hashCode()));
		println("): ");
		iOffset++;

		ArrayList<FeatureValuePair> queue = new ArrayList<FeatureValuePair>();

		for (EStructuralFeature feature : eobj.eClass()
				.getEAllStructuralFeatures()) {
			Object val = eobj.eGet(feature);
			if (val != null || !bfilterNullValues) {
				if (val instanceof EObject) {
					queue.add(new FeatureValuePair(feature, val));
				} else {
					indent();
					print(feature.getName());
					print(": ");
					doSwitch(val);
				}
			}
		}

		for (FeatureValuePair pair : queue) {
			indent();

			// Xtext 2.3:
			/*
			INode node = NodeModelUtils.getNode(eobj);
			if (node != null) { 
				print("#");
				print(node.getStartLine());
				print(": ");
				
			}
			*/
			
			// Xtext 1.x:
			/*
			NodeAdapter adapter = NodeUtil.getNodeAdapter(eobj);
			if (adapter != null) {
				AbstractNode node = adapter.getParserNode();

				if (node != null) {
					print("#");
					print(node.getLine());
					print(": ");
				}
			}
			*/

			print(pair.feature.getName());
			print(": ");
			doSwitch(pair.value);
		}

		iOffset--;

	}

	/**
	 * @param val
	 */
	private void dumpList(List<?> list) {

		iOffset++;
		if (list.size() > 0) {
			dumpedObjects.add(list);
			print(list.getClass().getSimpleName());
			print(" (");
			print(Integer.toHexString(list.hashCode()));
			println("): ");
			for (int i = 0; i < list.size(); i++) {
				Object item = list.get(i);
				if (item != null || !bfilterNullValues) {
					indent();
					print("[");
					print(i);
					print("] ");

					doSwitch(item);
				}

			}

		} else {
			println("<empty list>");
		}

		iOffset--;
	}

	/**
	 * @param i_obj
	 */
	private void dumpSimple(Object obj) {
		if (obj == null)
			print("NULL");
		else if (obj instanceof String) {
			print("\"");
			print(obj.toString());
			print("\"");
		} else {
			dumpedObjects.add(obj);

			print(obj.getClass().getSimpleName());
			print(": ");
			print(obj.toString());
		}
		println();
	}

	private void dumpEnumLiteral(EEnumLiteral enumlit) {
		println(enumlit.getName());
	}

	/**
	 * @param i_item
	 */
	private void doSwitch(Object obj) {
		if (dumpedObjects.contains(obj)) {
			print(" --> ");
			print(obj.getClass().getSimpleName());
			print(" (");
			print(Integer.toHexString(obj.hashCode()));
			println(")");

		} else {
			if (obj instanceof EEnumLiteral)
				dumpEnumLiteral((EEnumLiteral) obj);
			else if (obj instanceof List)
				dumpList((List<?>) obj);
			else if (obj instanceof EObject)
				dumpEObject((EObject) obj);

			else
				dumpSimple(obj);
		}

	}

	private void indent() {
		for (int i = 0; i < iOffset; i++) {
			print("  ");
		}
	}
}
