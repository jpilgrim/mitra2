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

package de.jevopi.utils;

/**
 * @author Jens von Pilgrim (developer@jevopi.de)
 * @since Jan 28, 2012
 */
public class StringUtils {

	public static String firstToLower(String s) {
		if (s != null && s.length() > 0) {
			s = s.substring(0, 1).toLowerCase() + s.substring(1);
		}
		return s;
	}

	public static String firstToUpper(String s) {
		if (s != null && s.length() > 0) {
			s = s.substring(0, 1).toUpperCase() + s.substring(1);
		}
		return s;
	}

	public static int getLevenshteinDistanceWithMinLength(String s, String t) {
		if (s == null || t == null) {
			throw new IllegalArgumentException("Strings must not be null");
		}
		int length = Math.min(s.length(), t.length());
		return getLevenshteinDistance(s.substring(0, length),
				t.substring(0, length));
	}

	/**
	 * 
	 * This code is copied from the apache commons project, (C) Apache License.
	 * 
	 * @param s
	 * @param t
	 * @return
	 * @see http://www.merriampark.com/ldjava.htm
	 * @see http 
	 *      ://commons.apache.org/lang/api-2.4/org/apache/commons/lang/StringUtils
	 *      .html#getLevenshteinDistance(java.lang.String,%20java.lang.String)
	 */
	public static int getLevenshteinDistance(String s, String t) {
		if (s == null || t == null) {
			throw new IllegalArgumentException("Strings must not be null");
		}

		/*
		  The difference between this impl. and the previous is that, rather 
		   than creating and retaining a matrix of size s.length()+1 by t.length()+1, 
		   we maintain two single-dimensional arrays of length s.length()+1.  The first, d,
		   is the 'current working' distance array that maintains the newest distance cost
		   counts as we iterate through the characters of String s.  Each time we increment
		   the index of String t we are comparing, d is copied to p, the second int[].  Doing so
		   allows us to retain the previous cost counts as required by the algorithm (taking 
		   the minimum of the cost count to the left, up one, and diagonally up and to the left
		   of the current cost count being calculated).  (Note that the arrays aren't really 
		   copied anymore, just switched...this is clearly much better than cloning an array 
		   or doing a System.arraycopy() each time  through the outer loop.)

		   Effectively, the difference between the two implementations is this one does not 
		   cause an out of memory condition when calculating the LD over two very large strings.  		
		*/

		int n = s.length(); // length of s
		int m = t.length(); // length of t

		if (n == 0) {
			return m;
		} else if (m == 0) {
			return n;
		}

		int p[] = new int[n + 1]; //'previous' cost array, horizontally
		int d[] = new int[n + 1]; // cost array, horizontally
		int _d[]; //placeholder to assist in swapping p and d

		// indexes into strings s and t
		int i; // iterates through s
		int j; // iterates through t

		char t_j; // jth character of t

		int cost; // cost

		for (i = 0; i <= n; i++) {
			p[i] = i;
		}

		for (j = 1; j <= m; j++) {
			t_j = t.charAt(j - 1);
			d[0] = j;

			for (i = 1; i <= n; i++) {
				cost = s.charAt(i - 1) == t_j ? 0 : 1;
				// minimum of cell to the left+1, to the top+1, diagonally left and up +cost				
				d[i] =
					Math.min(Math.min(d[i - 1] + 1, p[i] + 1), p[i - 1] + cost);
			}

			// copy current distance counts to 'previous row' distance counts
			_d = p;
			p = d;
			d = _d;
		}

		// our last action in the above loop was to switch d and p, so p now 
		// actually has the most recent cost counts
		return p[n];
	}

	public static String wrapByWord(String originalString, int lineLength,
			int tabSize, String listBullets) {
		if (originalString==null) return "";
		StringBuilder strb = new StringBuilder();
		int currentLineLength = 0;
		StringBuilder indentString = new StringBuilder();
		boolean indentSealed = false;
		for (int i = 0; i < originalString.length(); i++) {
			char c = originalString.charAt(i);
			strb.append(c);
			if (c == '\n') {
				currentLineLength = 0;
				indentSealed = false;
				indentString.setLength(0);
			} else {
				if (c == '\t')
					currentLineLength += tabSize;
				else
					currentLineLength++;
				if (currentLineLength >= lineLength) {
					int w = strb.length() - 1;
					while (w > 0) {
						w--;
						if (strb.charAt(w) == '\n') {
							w = -1;
							break;
						} else if (Character.isWhitespace(strb.charAt(w))) {
							break;
						}
					}
					if (w > 0) {
						strb.setCharAt(w, '\n');
						strb.insert(w + 1, indentString);
						currentLineLength = 0;
					}
				} else {
					if (!indentSealed) {
						if (Character.isWhitespace(c)) {
							indentString.append(c);
						} else if (listBullets.indexOf(c)>=0) {
							indentString.append(' ');
						} else {
							indentSealed = true;
						}
					}
				}
			}
		}
		return strb.toString();

	}
}