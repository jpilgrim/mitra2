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

import java.text.MessageFormat;
import java.util.StringTokenizer;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

/**
 * Simple query language for dynamic EMF models.
 * Grammar:
 * <pre><code>
 * query    := feature ( "." feature )*
 * feature  := &lt;name> ( "[" &lt;index> "]" )? 
 * </code></pre>
 * Example: <code>Object street = eval(eobj, "person.address[0].street");</code>
 * 
 * @author Jens von Pilgrim
 * @see http://jevopisdeveloperblog.blogspot.com/2008/09/simple-query-language-for-dynamic-emf.html
 */
public class DynEcoreUtil {

	/**
	 * Returns value of specified feature path. For specifying the feature path,
	 * a dot notation is used, if a list is to be parsed, square brakets with
	 * index are used.
	 * 
	 * @param obj
	 * @param featurePath
	 * @return
	 */
	public static Object eval(Object obj, String featurePath) {
		StringTokenizer st = new StringTokenizer(featurePath, ".");
		String feature = "";
		Object value = obj;
		
		try {
			while (st.hasMoreTokens()) {
				obj = value;
		
				feature = st.nextToken();
				if (feature.endsWith("]")) {
					int splitPos = feature.lastIndexOf("[");
					int index = Integer.parseInt(feature.substring(
							splitPos + 1, feature.length() - 1));
					feature = feature.substring(0, splitPos);
					value = fvl((EObject) obj, feature, index);
				} else {
					value = fv((EObject) obj, feature);
				}
			}
			return value;

		} catch (IndexOutOfBoundsException ex) {
			throw new IllegalArgumentException("Can't resolve " + featurePath + ", index out of bounds at feature " + feature, ex);
		} catch (Exception ex) {
			if (feature == null || !(obj instanceof EObject)) {
				
				String containerFeatures = "";
				if (obj != null) {
					if (obj instanceof EObject) {
						EObject ec = (EObject) obj;
						StringBuilder strb = new StringBuilder();
						for (EStructuralFeature esf: ec.eClass().getEAllStructuralFeatures()) {
							if (strb.length()>0) strb.append(", ");
							strb.append(esf.getName());
						}
						containerFeatures = strb.toString();
					} else {
						containerFeatures = "no features";
					}
				}
				
				String lastType = (obj==null)? "null" : obj.getClass().getSimpleName();
				
				throw new IllegalArgumentException(
					MessageFormat.format(
						"Cannot resolve {0}, feature {1} not found. Possible features: {2}. Last type: {3}. {4}",
						featurePath, feature, containerFeatures, lastType, ex),
						ex);
			} else {
				EObject eobj = (EObject) obj;
				EClass eclass = eobj.eClass();
				StringBuffer strb = new StringBuffer("Can't resolve "
						+ featurePath + ", feature " + feature + " not found.");
				strb.append(" Possible features of type " + eclass.getName());
				strb.append(": ");
				boolean bFirst = true;
				for (EStructuralFeature sf: eclass.getEStructuralFeatures()) {
					if (!bFirst) strb.append(", "); else bFirst = false;
					strb.append(sf.getName());
				}
				for (EClass superType: eclass.getESuperTypes()) {
					if ("EObject".equals(superType.getName())) break;
					for (EStructuralFeature sf: superType.getEStructuralFeatures()) {
						if (!bFirst) strb.append(", "); else bFirst = false;
						strb.append(sf.getName());
					}	
				}
				throw new IllegalArgumentException(strb.toString(), ex);
			}
		}
	}

	static Object fv(EObject obj, String name) {
		EStructuralFeature feature = obj.eClass().getEStructuralFeature(name);
		return obj.eGet(feature);
	}

	static Object fvl(EObject obj, String name, int index) {
		@SuppressWarnings("unchecked")
		EList<Object> list = (EList<Object>) fv(obj, name);
		return list.get(index);
	}

	/**
	 * Recognizes some mitra types and converts these types to string values.
	 * 
	 * @param obj
	 * @param featurePath
	 * @return
	 */
	public static Object xeval(Object obj, String featurePath) {
		Object value = eval(obj, featurePath);
		if (value instanceof EObject) {
			if ("FQN".equals(((EObject) value).eClass().getName())) {
				return toString((EObject) value);
			}
		}
		if (value instanceof EEnumLiteral) {
			return ((EEnumLiteral) value).getName();
		}
		if (value instanceof Enumerator) {
			return ((Enumerator) value).getName();
		}
		return value;
	}

	static String toString(EObject fqn) {
		@SuppressWarnings("unchecked")
		EList<String> parts = (EList<String>) fv(fqn, "parts");
		StringBuffer strb = new StringBuffer();
		for (String part : parts) {
			if (strb.length() > 0)
				strb.append(':');
			strb.append(part);
		}
		return strb.toString();
	}

}
