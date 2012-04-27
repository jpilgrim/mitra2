package de.jevopi.utils;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Jens von Pilgrim (developer@jevopi.de)
 * @since Mar 10, 2012
 */
public class JavaUtils {

	public static Method findBestMatchingJavaMethod(Class<?> c, String name,
			Class<?>... argTypes) throws NoSuchMethodException {

		List<Method> matchingMethods = new ArrayList<Method>();
		Method[] methods = c.getMethods();
		for (Method m : methods) {
			if (m.getName().equals(name)
				&& m.getParameterTypes().length == argTypes.length) {
				int i = 0;
				for (; i < m.getParameterTypes().length; i++) {
					if (! m.getParameterTypes()[i].isAssignableFrom(argTypes[i]))
						break;
				}
				if (i==m.getParameterTypes().length) {
					matchingMethods.add(m);
				}
			}
		}
		if (matchingMethods.isEmpty()) {
			throw new NoSuchMethodException("Found no method " + c.getName()
				+ "#" + name + Arrays.toString(argTypes));
		}
		if (matchingMethods.size() == 1) return matchingMethods.get(0);

		float max = -1;
		Method bestMatch = null;
		for (Method m : matchingMethods) {
			float fResult = 0;
			for (int i = 0; i < m.getParameterTypes().length; i++) {
				int iDist = typeDistance(argTypes[i], m.getParameterTypes()[i]);
				if (iDist < 0) {
					fResult = 0;
					break;
				}
				fResult += 1 / ((float) (iDist + 1));

			}
			if (fResult > max) {
				max = fResult;
				bestMatch = m;
			}
		}
		return bestMatch;
	}

	private static int typeDistance(Class<?> sub, Class<?> sup) {
		if (sub == null || sup == null || !sup.isAssignableFrom(sub))
			return -1;
		if (sub == sup) return 0;
		int dist = typeDistance(sub.getSuperclass(), sup);
		if (sup.isInterface()) {
			for (Class<?> interf : sub.getInterfaces()) {
				int d = typeDistance(interf, sup);
				if (d<dist || dist==-1) {
					dist = d;
				}
			}
		}
		return dist;
	}
}
