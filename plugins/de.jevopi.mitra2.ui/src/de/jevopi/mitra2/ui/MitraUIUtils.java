package de.jevopi.mitra2.ui;

import de.jevopi.mitra2.MitraUtils;
import de.jevopi.mitra2.mitra.PrimitiveType;
import de.jevopi.mitra2.mitra.Type;
import de.jevopi.utils.StringUtils;

public class MitraUIUtils {
	/**
	 * @param type
	 * @return
	 */
	public static String computeVariablenameFromType(Type type) {
		String nameProposal;
		if (type instanceof PrimitiveType) {
			nameProposal =
				((PrimitiveType) type).getPrimitiveType().getName()
					.substring(0, 1).toLowerCase();
		} else {
			String simpleTypeName = MitraUtils.getSimpleTypeName(type);
			nameProposal = StringUtils.firstToLower(simpleTypeName);
			if (nameProposal==null) return null;
			if (nameProposal.equals(simpleTypeName)) {
				nameProposal = "a" + StringUtils.firstToUpper(simpleTypeName);
			}
		}
		return nameProposal;
	}

}
