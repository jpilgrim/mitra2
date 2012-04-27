package de.jevopi.mitra2;

import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EcoreFactory;

public class MitraPostProcessorHelper {
	public static void addNullValue(org.eclipse.emf.ecore.EEnum e) {
		for (EEnumLiteral literal : e.getELiterals()) {
			literal.setValue(literal.getValue() + 1);
		}
		EEnumLiteral nullLiteral = EcoreFactory.eINSTANCE.createEEnumLiteral();
		nullLiteral.setName("NULL");
		nullLiteral.setLiteral("NULL");
		nullLiteral.setValue(0);
		e.getELiterals().add(0, nullLiteral);
	}
}
