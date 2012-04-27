package de.jevopi.mitra2.learningEMF;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.junit.Test;
import static org.junit.Assert.*;

public class EObjectContainmentsAndFeatures {

	@Test
	public void test() {

		// build a structure:
		EClass c = EcoreFactory.eINSTANCE.createEClass();
		EAttribute a = EcoreFactory.eINSTANCE.createEAttribute();
		EAttribute b = EcoreFactory.eINSTANCE.createEAttribute();
		c.setName("Class_Container");
		a.setName("A");
		b.setName("B");

		// container not set yet:
		EStructuralFeature containingFeatureA = a.eContainingFeature();
		assertNull(containingFeatureA);
		EStructuralFeature containmentFeatureA = a.eContainmentFeature();
		assertNull(containmentFeatureA);

		// set container:	
		c.getEAttributes().add(a);
		c.getEAttributes().add(b);

		// feature of a's container:
		containingFeatureA = a.eContainingFeature();
		assertNotNull(containingFeatureA);
		containmentFeatureA = a.eContainmentFeature();
		assertNotNull(containmentFeatureA);
		// feature of b's container:
		EStructuralFeature containingFeatureB = b.eContainingFeature();
		assertNotNull(containingFeatureA);
		EReference containmentFeatureB = b.eContainmentFeature();
		assertNotNull(containmentFeatureA);

		assertSame(containingFeatureA, containmentFeatureA);
		assertSame(containingFeatureB, containmentFeatureB);

		// feature is a meta information, not object specific?!
		assertSame(containingFeatureA, containingFeatureB);
		EStructuralFeature featureByClass =
			EcorePackage.eINSTANCE.getEClass_EAttributes().eContainingFeature();
		EReference featureC =
			EcorePackage.eINSTANCE.getEClass_EAttributes()
				.eContainmentFeature();
		assertNotNull(featureByClass);
		assertNotNull(featureC);
		assertSame(featureByClass, featureC);
		assertSame(containingFeatureA, featureByClass);

		// Xtext proposes using the literal class when creating 
		// warnings or errors in validation:
		EStructuralFeature  featureByLiteral = EcorePackage.Literals.ECLASS__EATTRIBUTES.eContainingFeature();
		assertNotNull(featureByLiteral);
		assertSame(featureByClass, featureByLiteral); // and again the same thing
		
		
		Object attributesByLiteral = c.eGet(EcorePackage.Literals.ECLASS__EATTRIBUTES);
		int id = EcorePackage.ECLASS__EATTRIBUTES;
		Object attributesByID = c.eGet(c.eClass().getEStructuralFeature(id));
		assertNotNull(attributesByLiteral);
		assertSame(attributesByLiteral, attributesByID);
		Object attributesByContainmentFeature = c.eGet(featureByLiteral);
		
		// this is interesting:
		assertNotSame(attributesByLiteral, attributesByContainmentFeature);
		assertEquals(attributesByLiteral, attributesByContainmentFeature);
		
		// what is the differenced between 
		// EcorePackage.Literals.ECLASS__EATTRIBUTES
		// and
		// EcorePackage.Literals.ECLASS__EATTRIBUTES.eContainingFeature()?
 
		EReference literal = EcorePackage.Literals.ECLASS__EATTRIBUTES;
		assertNotSame(literal, featureByLiteral);
		assertFalse(literal.equals(featureByLiteral));
		
	}

}
