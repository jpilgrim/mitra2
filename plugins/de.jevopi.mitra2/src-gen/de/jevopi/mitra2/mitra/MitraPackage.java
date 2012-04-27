/**
 */
package de.jevopi.mitra2.mitra;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see de.jevopi.mitra2.mitra.MitraFactory
 * @model kind="package"
 * @generated
 */
public interface MitraPackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "mitra";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://www.jevopi.de/Mitra";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "mitra";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  MitraPackage eINSTANCE = de.jevopi.mitra2.mitra.impl.MitraPackageImpl.init();

  /**
   * The meta object id for the '{@link de.jevopi.mitra2.mitra.impl.ModuleImpl <em>Module</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.jevopi.mitra2.mitra.impl.ModuleImpl
   * @see de.jevopi.mitra2.mitra.impl.MitraPackageImpl#getModule()
   * @generated
   */
  int MODULE = 0;

  /**
   * The feature id for the '<em><b>Package Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODULE__PACKAGE_NAME = 0;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODULE__NAME = 1;

  /**
   * The feature id for the '<em><b>Imports</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODULE__IMPORTS = 2;

  /**
   * The feature id for the '<em><b>Metamodel Declarations</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODULE__METAMODEL_DECLARATIONS = 3;

  /**
   * The feature id for the '<em><b>Annotation Definitions</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODULE__ANNOTATION_DEFINITIONS = 4;

  /**
   * The feature id for the '<em><b>Rule Declarations</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODULE__RULE_DECLARATIONS = 5;

  /**
   * The number of structural features of the '<em>Module</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODULE_FEATURE_COUNT = 6;

  /**
   * The meta object id for the '{@link de.jevopi.mitra2.mitra.impl.ModuleReferenceImpl <em>Module Reference</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.jevopi.mitra2.mitra.impl.ModuleReferenceImpl
   * @see de.jevopi.mitra2.mitra.impl.MitraPackageImpl#getModuleReference()
   * @generated
   */
  int MODULE_REFERENCE = 1;

  /**
   * The feature id for the '<em><b>Module</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODULE_REFERENCE__MODULE = 0;

  /**
   * The number of structural features of the '<em>Module Reference</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODULE_REFERENCE_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link de.jevopi.mitra2.mitra.impl.MetamodelDeclarationImpl <em>Metamodel Declaration</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.jevopi.mitra2.mitra.impl.MetamodelDeclarationImpl
   * @see de.jevopi.mitra2.mitra.impl.MitraPackageImpl#getMetamodelDeclaration()
   * @generated
   */
  int METAMODEL_DECLARATION = 2;

  /**
   * The feature id for the '<em><b>Type</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int METAMODEL_DECLARATION__TYPE = 0;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int METAMODEL_DECLARATION__NAME = 1;

  /**
   * The feature id for the '<em><b>Properties</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int METAMODEL_DECLARATION__PROPERTIES = 2;

  /**
   * The feature id for the '<em><b>Replaces</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int METAMODEL_DECLARATION__REPLACES = 3;

  /**
   * The number of structural features of the '<em>Metamodel Declaration</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int METAMODEL_DECLARATION_FEATURE_COUNT = 4;

  /**
   * The meta object id for the '{@link de.jevopi.mitra2.mitra.impl.PropertyImpl <em>Property</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.jevopi.mitra2.mitra.impl.PropertyImpl
   * @see de.jevopi.mitra2.mitra.impl.MitraPackageImpl#getProperty()
   * @generated
   */
  int PROPERTY = 3;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROPERTY__NAME = 0;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROPERTY__VALUE = 1;

  /**
   * The number of structural features of the '<em>Property</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROPERTY_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link de.jevopi.mitra2.mitra.impl.RuleDeclarationImpl <em>Rule Declaration</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.jevopi.mitra2.mitra.impl.RuleDeclarationImpl
   * @see de.jevopi.mitra2.mitra.impl.MitraPackageImpl#getRuleDeclaration()
   * @generated
   */
  int RULE_DECLARATION = 4;

  /**
   * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RULE_DECLARATION__ANNOTATIONS = 0;

  /**
   * The feature id for the '<em><b>Visibility</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RULE_DECLARATION__VISIBILITY = 1;

  /**
   * The feature id for the '<em><b>Exec</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RULE_DECLARATION__EXEC = 2;

  /**
   * The feature id for the '<em><b>Traced</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RULE_DECLARATION__TRACED = 3;

  /**
   * The feature id for the '<em><b>Stealth</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RULE_DECLARATION__STEALTH = 4;

  /**
   * The feature id for the '<em><b>Virtual</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RULE_DECLARATION__VIRTUAL = 5;

  /**
   * The feature id for the '<em><b>Multi</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RULE_DECLARATION__MULTI = 6;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RULE_DECLARATION__NAME = 7;

  /**
   * The feature id for the '<em><b>Formal Parameters</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RULE_DECLARATION__FORMAL_PARAMETERS = 8;

  /**
   * The feature id for the '<em><b>Return Parameters</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RULE_DECLARATION__RETURN_PARAMETERS = 9;

  /**
   * The feature id for the '<em><b>Implemented Rules</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RULE_DECLARATION__IMPLEMENTED_RULES = 10;

  /**
   * The feature id for the '<em><b>Overridden Rule</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RULE_DECLARATION__OVERRIDDEN_RULE = 11;

  /**
   * The feature id for the '<em><b>Excluding Rules</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RULE_DECLARATION__EXCLUDING_RULES = 12;

  /**
   * The feature id for the '<em><b>Trigger</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RULE_DECLARATION__TRIGGER = 13;

  /**
   * The feature id for the '<em><b>Java Spec</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RULE_DECLARATION__JAVA_SPEC = 14;

  /**
   * The feature id for the '<em><b>Body</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RULE_DECLARATION__BODY = 15;

  /**
   * The number of structural features of the '<em>Rule Declaration</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RULE_DECLARATION_FEATURE_COUNT = 16;

  /**
   * The meta object id for the '{@link de.jevopi.mitra2.mitra.impl.RuleReferenceImpl <em>Rule Reference</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.jevopi.mitra2.mitra.impl.RuleReferenceImpl
   * @see de.jevopi.mitra2.mitra.impl.MitraPackageImpl#getRuleReference()
   * @generated
   */
  int RULE_REFERENCE = 5;

  /**
   * The feature id for the '<em><b>Rule Declaration</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RULE_REFERENCE__RULE_DECLARATION = 0;

  /**
   * The number of structural features of the '<em>Rule Reference</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RULE_REFERENCE_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link de.jevopi.mitra2.mitra.impl.SimpleRuleReferenceImpl <em>Simple Rule Reference</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.jevopi.mitra2.mitra.impl.SimpleRuleReferenceImpl
   * @see de.jevopi.mitra2.mitra.impl.MitraPackageImpl#getSimpleRuleReference()
   * @generated
   */
  int SIMPLE_RULE_REFERENCE = 6;

  /**
   * The feature id for the '<em><b>Rule Declaration</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SIMPLE_RULE_REFERENCE__RULE_DECLARATION = RULE_REFERENCE__RULE_DECLARATION;

  /**
   * The feature id for the '<em><b>Parameter References</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SIMPLE_RULE_REFERENCE__PARAMETER_REFERENCES = RULE_REFERENCE_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Return References</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SIMPLE_RULE_REFERENCE__RETURN_REFERENCES = RULE_REFERENCE_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Simple Rule Reference</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SIMPLE_RULE_REFERENCE_FEATURE_COUNT = RULE_REFERENCE_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link de.jevopi.mitra2.mitra.impl.QualifiedRuleReferenceImpl <em>Qualified Rule Reference</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.jevopi.mitra2.mitra.impl.QualifiedRuleReferenceImpl
   * @see de.jevopi.mitra2.mitra.impl.MitraPackageImpl#getQualifiedRuleReference()
   * @generated
   */
  int QUALIFIED_RULE_REFERENCE = 7;

  /**
   * The feature id for the '<em><b>Rule Declaration</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int QUALIFIED_RULE_REFERENCE__RULE_DECLARATION = RULE_REFERENCE__RULE_DECLARATION;

  /**
   * The feature id for the '<em><b>Parameter References</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int QUALIFIED_RULE_REFERENCE__PARAMETER_REFERENCES = RULE_REFERENCE_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Return References</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int QUALIFIED_RULE_REFERENCE__RETURN_REFERENCES = RULE_REFERENCE_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Qualified Rule Reference</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int QUALIFIED_RULE_REFERENCE_FEATURE_COUNT = RULE_REFERENCE_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link de.jevopi.mitra2.mitra.impl.ParameterReferenceImpl <em>Parameter Reference</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.jevopi.mitra2.mitra.impl.ParameterReferenceImpl
   * @see de.jevopi.mitra2.mitra.impl.MitraPackageImpl#getParameterReference()
   * @generated
   */
  int PARAMETER_REFERENCE = 8;

  /**
   * The number of structural features of the '<em>Parameter Reference</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PARAMETER_REFERENCE_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link de.jevopi.mitra2.mitra.impl.SimpleParameterReferenceImpl <em>Simple Parameter Reference</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.jevopi.mitra2.mitra.impl.SimpleParameterReferenceImpl
   * @see de.jevopi.mitra2.mitra.impl.MitraPackageImpl#getSimpleParameterReference()
   * @generated
   */
  int SIMPLE_PARAMETER_REFERENCE = 9;

  /**
   * The feature id for the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SIMPLE_PARAMETER_REFERENCE__TYPE = PARAMETER_REFERENCE_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SIMPLE_PARAMETER_REFERENCE__NAME = PARAMETER_REFERENCE_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Simple Parameter Reference</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SIMPLE_PARAMETER_REFERENCE_FEATURE_COUNT = PARAMETER_REFERENCE_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link de.jevopi.mitra2.mitra.impl.QualifiedParameterReferenceImpl <em>Qualified Parameter Reference</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.jevopi.mitra2.mitra.impl.QualifiedParameterReferenceImpl
   * @see de.jevopi.mitra2.mitra.impl.MitraPackageImpl#getQualifiedParameterReference()
   * @generated
   */
  int QUALIFIED_PARAMETER_REFERENCE = 10;

  /**
   * The feature id for the '<em><b>Vardecl</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int QUALIFIED_PARAMETER_REFERENCE__VARDECL = PARAMETER_REFERENCE_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Qualified Parameter Reference</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int QUALIFIED_PARAMETER_REFERENCE_FEATURE_COUNT = PARAMETER_REFERENCE_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link de.jevopi.mitra2.mitra.impl.TriggerImpl <em>Trigger</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.jevopi.mitra2.mitra.impl.TriggerImpl
   * @see de.jevopi.mitra2.mitra.impl.MitraPackageImpl#getTrigger()
   * @generated
   */
  int TRIGGER = 11;

  /**
   * The feature id for the '<em><b>Trigger Rules</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRIGGER__TRIGGER_RULES = 0;

  /**
   * The feature id for the '<em><b>With</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRIGGER__WITH = 1;

  /**
   * The feature id for the '<em><b>When</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRIGGER__WHEN = 2;

  /**
   * The number of structural features of the '<em>Trigger</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRIGGER_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link de.jevopi.mitra2.mitra.impl.JavaSpecImpl <em>Java Spec</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.jevopi.mitra2.mitra.impl.JavaSpecImpl
   * @see de.jevopi.mitra2.mitra.impl.MitraPackageImpl#getJavaSpec()
   * @generated
   */
  int JAVA_SPEC = 12;

  /**
   * The feature id for the '<em><b>Properties</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int JAVA_SPEC__PROPERTIES = 0;

  /**
   * The number of structural features of the '<em>Java Spec</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int JAVA_SPEC_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link de.jevopi.mitra2.mitra.impl.ParameterImpl <em>Parameter</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.jevopi.mitra2.mitra.impl.ParameterImpl
   * @see de.jevopi.mitra2.mitra.impl.MitraPackageImpl#getParameter()
   * @generated
   */
  int PARAMETER = 13;

  /**
   * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PARAMETER__ANNOTATIONS = 0;

  /**
   * The feature id for the '<em><b>Modifier</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PARAMETER__MODIFIER = 1;

  /**
   * The feature id for the '<em><b>Vardecl</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PARAMETER__VARDECL = 2;

  /**
   * The number of structural features of the '<em>Parameter</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PARAMETER_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link de.jevopi.mitra2.mitra.impl.FormalParameterImpl <em>Formal Parameter</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.jevopi.mitra2.mitra.impl.FormalParameterImpl
   * @see de.jevopi.mitra2.mitra.impl.MitraPackageImpl#getFormalParameter()
   * @generated
   */
  int FORMAL_PARAMETER = 14;

  /**
   * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FORMAL_PARAMETER__ANNOTATIONS = PARAMETER__ANNOTATIONS;

  /**
   * The feature id for the '<em><b>Modifier</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FORMAL_PARAMETER__MODIFIER = PARAMETER__MODIFIER;

  /**
   * The feature id for the '<em><b>Vardecl</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FORMAL_PARAMETER__VARDECL = PARAMETER__VARDECL;

  /**
   * The number of structural features of the '<em>Formal Parameter</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FORMAL_PARAMETER_FEATURE_COUNT = PARAMETER_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link de.jevopi.mitra2.mitra.impl.ReturnParameterImpl <em>Return Parameter</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.jevopi.mitra2.mitra.impl.ReturnParameterImpl
   * @see de.jevopi.mitra2.mitra.impl.MitraPackageImpl#getReturnParameter()
   * @generated
   */
  int RETURN_PARAMETER = 15;

  /**
   * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RETURN_PARAMETER__ANNOTATIONS = PARAMETER__ANNOTATIONS;

  /**
   * The feature id for the '<em><b>Modifier</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RETURN_PARAMETER__MODIFIER = PARAMETER__MODIFIER;

  /**
   * The feature id for the '<em><b>Vardecl</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RETURN_PARAMETER__VARDECL = PARAMETER__VARDECL;

  /**
   * The number of structural features of the '<em>Return Parameter</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RETURN_PARAMETER_FEATURE_COUNT = PARAMETER_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link de.jevopi.mitra2.mitra.impl.TypeImpl <em>Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.jevopi.mitra2.mitra.impl.TypeImpl
   * @see de.jevopi.mitra2.mitra.impl.MitraPackageImpl#getType()
   * @generated
   */
  int TYPE = 16;

  /**
   * The number of structural features of the '<em>Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link de.jevopi.mitra2.mitra.impl.ReferenceTypeImpl <em>Reference Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.jevopi.mitra2.mitra.impl.ReferenceTypeImpl
   * @see de.jevopi.mitra2.mitra.impl.MitraPackageImpl#getReferenceType()
   * @generated
   */
  int REFERENCE_TYPE = 17;

  /**
   * The feature id for the '<em><b>Metamodel Declaration</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REFERENCE_TYPE__METAMODEL_DECLARATION = TYPE_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>EClassifier</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REFERENCE_TYPE__ECLASSIFIER = TYPE_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Reference Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REFERENCE_TYPE_FEATURE_COUNT = TYPE_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link de.jevopi.mitra2.mitra.impl.PrimitiveTypeImpl <em>Primitive Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.jevopi.mitra2.mitra.impl.PrimitiveTypeImpl
   * @see de.jevopi.mitra2.mitra.impl.MitraPackageImpl#getPrimitiveType()
   * @generated
   */
  int PRIMITIVE_TYPE = 18;

  /**
   * The feature id for the '<em><b>Primitive Type</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRIMITIVE_TYPE__PRIMITIVE_TYPE = TYPE_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Primitive Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRIMITIVE_TYPE_FEATURE_COUNT = TYPE_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link de.jevopi.mitra2.mitra.impl.CollectionTypeImpl <em>Collection Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.jevopi.mitra2.mitra.impl.CollectionTypeImpl
   * @see de.jevopi.mitra2.mitra.impl.MitraPackageImpl#getCollectionType()
   * @generated
   */
  int COLLECTION_TYPE = 19;

  /**
   * The feature id for the '<em><b>Collection Type</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COLLECTION_TYPE__COLLECTION_TYPE = TYPE_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Type Par</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COLLECTION_TYPE__TYPE_PAR = TYPE_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Collection Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COLLECTION_TYPE_FEATURE_COUNT = TYPE_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link de.jevopi.mitra2.mitra.impl.BlockStatementImpl <em>Block Statement</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.jevopi.mitra2.mitra.impl.BlockStatementImpl
   * @see de.jevopi.mitra2.mitra.impl.MitraPackageImpl#getBlockStatement()
   * @generated
   */
  int BLOCK_STATEMENT = 21;

  /**
   * The number of structural features of the '<em>Block Statement</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BLOCK_STATEMENT_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link de.jevopi.mitra2.mitra.impl.StatementImpl <em>Statement</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.jevopi.mitra2.mitra.impl.StatementImpl
   * @see de.jevopi.mitra2.mitra.impl.MitraPackageImpl#getStatement()
   * @generated
   */
  int STATEMENT = 22;

  /**
   * The number of structural features of the '<em>Statement</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATEMENT_FEATURE_COUNT = BLOCK_STATEMENT_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link de.jevopi.mitra2.mitra.impl.BlockImpl <em>Block</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.jevopi.mitra2.mitra.impl.BlockImpl
   * @see de.jevopi.mitra2.mitra.impl.MitraPackageImpl#getBlock()
   * @generated
   */
  int BLOCK = 20;

  /**
   * The feature id for the '<em><b>Statements</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BLOCK__STATEMENTS = STATEMENT_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Block</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BLOCK_FEATURE_COUNT = STATEMENT_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link de.jevopi.mitra2.mitra.impl.LocalVariableDeclarationStatementImpl <em>Local Variable Declaration Statement</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.jevopi.mitra2.mitra.impl.LocalVariableDeclarationStatementImpl
   * @see de.jevopi.mitra2.mitra.impl.MitraPackageImpl#getLocalVariableDeclarationStatement()
   * @generated
   */
  int LOCAL_VARIABLE_DECLARATION_STATEMENT = 23;

  /**
   * The feature id for the '<em><b>Local Variable Declaration</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LOCAL_VARIABLE_DECLARATION_STATEMENT__LOCAL_VARIABLE_DECLARATION = BLOCK_STATEMENT_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Local Variable Declaration Statement</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LOCAL_VARIABLE_DECLARATION_STATEMENT_FEATURE_COUNT = BLOCK_STATEMENT_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link de.jevopi.mitra2.mitra.impl.LocalVariableDeclarationImpl <em>Local Variable Declaration</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.jevopi.mitra2.mitra.impl.LocalVariableDeclarationImpl
   * @see de.jevopi.mitra2.mitra.impl.MitraPackageImpl#getLocalVariableDeclaration()
   * @generated
   */
  int LOCAL_VARIABLE_DECLARATION = 24;

  /**
   * The feature id for the '<em><b>Vardecl</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LOCAL_VARIABLE_DECLARATION__VARDECL = 0;

  /**
   * The feature id for the '<em><b>Expression</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LOCAL_VARIABLE_DECLARATION__EXPRESSION = 1;

  /**
   * The number of structural features of the '<em>Local Variable Declaration</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LOCAL_VARIABLE_DECLARATION_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link de.jevopi.mitra2.mitra.impl.VarDeclarationImpl <em>Var Declaration</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.jevopi.mitra2.mitra.impl.VarDeclarationImpl
   * @see de.jevopi.mitra2.mitra.impl.MitraPackageImpl#getVarDeclaration()
   * @generated
   */
  int VAR_DECLARATION = 25;

  /**
   * The feature id for the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VAR_DECLARATION__TYPE = 0;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VAR_DECLARATION__NAME = 1;

  /**
   * The number of structural features of the '<em>Var Declaration</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VAR_DECLARATION_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link de.jevopi.mitra2.mitra.impl.TypedVarDeclarationImpl <em>Typed Var Declaration</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.jevopi.mitra2.mitra.impl.TypedVarDeclarationImpl
   * @see de.jevopi.mitra2.mitra.impl.MitraPackageImpl#getTypedVarDeclaration()
   * @generated
   */
  int TYPED_VAR_DECLARATION = 26;

  /**
   * The feature id for the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPED_VAR_DECLARATION__TYPE = VAR_DECLARATION__TYPE;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPED_VAR_DECLARATION__NAME = VAR_DECLARATION__NAME;

  /**
   * The number of structural features of the '<em>Typed Var Declaration</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPED_VAR_DECLARATION_FEATURE_COUNT = VAR_DECLARATION_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link de.jevopi.mitra2.mitra.impl.InferredVarDeclarationImpl <em>Inferred Var Declaration</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.jevopi.mitra2.mitra.impl.InferredVarDeclarationImpl
   * @see de.jevopi.mitra2.mitra.impl.MitraPackageImpl#getInferredVarDeclaration()
   * @generated
   */
  int INFERRED_VAR_DECLARATION = 27;

  /**
   * The feature id for the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INFERRED_VAR_DECLARATION__TYPE = VAR_DECLARATION__TYPE;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INFERRED_VAR_DECLARATION__NAME = VAR_DECLARATION__NAME;

  /**
   * The number of structural features of the '<em>Inferred Var Declaration</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INFERRED_VAR_DECLARATION_FEATURE_COUNT = VAR_DECLARATION_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link de.jevopi.mitra2.mitra.impl.ExpressionStatementImpl <em>Expression Statement</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.jevopi.mitra2.mitra.impl.ExpressionStatementImpl
   * @see de.jevopi.mitra2.mitra.impl.MitraPackageImpl#getExpressionStatement()
   * @generated
   */
  int EXPRESSION_STATEMENT = 28;

  /**
   * The feature id for the '<em><b>Statement Expression</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPRESSION_STATEMENT__STATEMENT_EXPRESSION = STATEMENT_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Expression Statement</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPRESSION_STATEMENT_FEATURE_COUNT = STATEMENT_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link de.jevopi.mitra2.mitra.impl.StatementExpressionImpl <em>Statement Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.jevopi.mitra2.mitra.impl.StatementExpressionImpl
   * @see de.jevopi.mitra2.mitra.impl.MitraPackageImpl#getStatementExpression()
   * @generated
   */
  int STATEMENT_EXPRESSION = 29;

  /**
   * The number of structural features of the '<em>Statement Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATEMENT_EXPRESSION_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link de.jevopi.mitra2.mitra.impl.EmptyStatementImpl <em>Empty Statement</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.jevopi.mitra2.mitra.impl.EmptyStatementImpl
   * @see de.jevopi.mitra2.mitra.impl.MitraPackageImpl#getEmptyStatement()
   * @generated
   */
  int EMPTY_STATEMENT = 30;

  /**
   * The number of structural features of the '<em>Empty Statement</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EMPTY_STATEMENT_FEATURE_COUNT = STATEMENT_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link de.jevopi.mitra2.mitra.impl.ReturnStatementImpl <em>Return Statement</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.jevopi.mitra2.mitra.impl.ReturnStatementImpl
   * @see de.jevopi.mitra2.mitra.impl.MitraPackageImpl#getReturnStatement()
   * @generated
   */
  int RETURN_STATEMENT = 31;

  /**
   * The feature id for the '<em><b>Expression</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RETURN_STATEMENT__EXPRESSION = STATEMENT_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Return Statement</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RETURN_STATEMENT_FEATURE_COUNT = STATEMENT_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link de.jevopi.mitra2.mitra.impl.IfStatementImpl <em>If Statement</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.jevopi.mitra2.mitra.impl.IfStatementImpl
   * @see de.jevopi.mitra2.mitra.impl.MitraPackageImpl#getIfStatement()
   * @generated
   */
  int IF_STATEMENT = 32;

  /**
   * The feature id for the '<em><b>Expression</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IF_STATEMENT__EXPRESSION = STATEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>True Statement</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IF_STATEMENT__TRUE_STATEMENT = STATEMENT_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Else Statement</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IF_STATEMENT__ELSE_STATEMENT = STATEMENT_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>If Statement</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IF_STATEMENT_FEATURE_COUNT = STATEMENT_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link de.jevopi.mitra2.mitra.impl.WhileStatementImpl <em>While Statement</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.jevopi.mitra2.mitra.impl.WhileStatementImpl
   * @see de.jevopi.mitra2.mitra.impl.MitraPackageImpl#getWhileStatement()
   * @generated
   */
  int WHILE_STATEMENT = 33;

  /**
   * The feature id for the '<em><b>Expression</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int WHILE_STATEMENT__EXPRESSION = STATEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Statement</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int WHILE_STATEMENT__STATEMENT = STATEMENT_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>While Statement</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int WHILE_STATEMENT_FEATURE_COUNT = STATEMENT_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link de.jevopi.mitra2.mitra.impl.DoStatementImpl <em>Do Statement</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.jevopi.mitra2.mitra.impl.DoStatementImpl
   * @see de.jevopi.mitra2.mitra.impl.MitraPackageImpl#getDoStatement()
   * @generated
   */
  int DO_STATEMENT = 34;

  /**
   * The feature id for the '<em><b>Statement</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DO_STATEMENT__STATEMENT = STATEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Expression</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DO_STATEMENT__EXPRESSION = STATEMENT_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Do Statement</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DO_STATEMENT_FEATURE_COUNT = STATEMENT_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link de.jevopi.mitra2.mitra.impl.ForInitImpl <em>For Init</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.jevopi.mitra2.mitra.impl.ForInitImpl
   * @see de.jevopi.mitra2.mitra.impl.MitraPackageImpl#getForInit()
   * @generated
   */
  int FOR_INIT = 35;

  /**
   * The feature id for the '<em><b>Statement Expressions</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FOR_INIT__STATEMENT_EXPRESSIONS = 0;

  /**
   * The feature id for the '<em><b>Var Declarations</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FOR_INIT__VAR_DECLARATIONS = 1;

  /**
   * The number of structural features of the '<em>For Init</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FOR_INIT_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link de.jevopi.mitra2.mitra.impl.ForUpdateImpl <em>For Update</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.jevopi.mitra2.mitra.impl.ForUpdateImpl
   * @see de.jevopi.mitra2.mitra.impl.MitraPackageImpl#getForUpdate()
   * @generated
   */
  int FOR_UPDATE = 36;

  /**
   * The feature id for the '<em><b>Statement Expression</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FOR_UPDATE__STATEMENT_EXPRESSION = 0;

  /**
   * The number of structural features of the '<em>For Update</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FOR_UPDATE_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link de.jevopi.mitra2.mitra.impl.ForStatementImpl <em>For Statement</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.jevopi.mitra2.mitra.impl.ForStatementImpl
   * @see de.jevopi.mitra2.mitra.impl.MitraPackageImpl#getForStatement()
   * @generated
   */
  int FOR_STATEMENT = 37;

  /**
   * The feature id for the '<em><b>Loop Variable</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FOR_STATEMENT__LOOP_VARIABLE = STATEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Expression</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FOR_STATEMENT__EXPRESSION = STATEMENT_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>For Init</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FOR_STATEMENT__FOR_INIT = STATEMENT_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>For Update</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FOR_STATEMENT__FOR_UPDATE = STATEMENT_FEATURE_COUNT + 3;

  /**
   * The feature id for the '<em><b>Statement</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FOR_STATEMENT__STATEMENT = STATEMENT_FEATURE_COUNT + 4;

  /**
   * The number of structural features of the '<em>For Statement</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FOR_STATEMENT_FEATURE_COUNT = STATEMENT_FEATURE_COUNT + 5;

  /**
   * The meta object id for the '{@link de.jevopi.mitra2.mitra.impl.LoopVariableImpl <em>Loop Variable</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.jevopi.mitra2.mitra.impl.LoopVariableImpl
   * @see de.jevopi.mitra2.mitra.impl.MitraPackageImpl#getLoopVariable()
   * @generated
   */
  int LOOP_VARIABLE = 38;

  /**
   * The feature id for the '<em><b>Vardecl</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LOOP_VARIABLE__VARDECL = 0;

  /**
   * The number of structural features of the '<em>Loop Variable</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LOOP_VARIABLE_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link de.jevopi.mitra2.mitra.impl.BreakStatementImpl <em>Break Statement</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.jevopi.mitra2.mitra.impl.BreakStatementImpl
   * @see de.jevopi.mitra2.mitra.impl.MitraPackageImpl#getBreakStatement()
   * @generated
   */
  int BREAK_STATEMENT = 39;

  /**
   * The number of structural features of the '<em>Break Statement</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BREAK_STATEMENT_FEATURE_COUNT = STATEMENT_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link de.jevopi.mitra2.mitra.impl.ThrowStatementImpl <em>Throw Statement</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.jevopi.mitra2.mitra.impl.ThrowStatementImpl
   * @see de.jevopi.mitra2.mitra.impl.MitraPackageImpl#getThrowStatement()
   * @generated
   */
  int THROW_STATEMENT = 40;

  /**
   * The feature id for the '<em><b>Expression</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int THROW_STATEMENT__EXPRESSION = STATEMENT_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Throw Statement</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int THROW_STATEMENT_FEATURE_COUNT = STATEMENT_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link de.jevopi.mitra2.mitra.impl.TryStatementImpl <em>Try Statement</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.jevopi.mitra2.mitra.impl.TryStatementImpl
   * @see de.jevopi.mitra2.mitra.impl.MitraPackageImpl#getTryStatement()
   * @generated
   */
  int TRY_STATEMENT = 41;

  /**
   * The feature id for the '<em><b>Try Block</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRY_STATEMENT__TRY_BLOCK = STATEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Catches</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRY_STATEMENT__CATCHES = STATEMENT_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Finally Block</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRY_STATEMENT__FINALLY_BLOCK = STATEMENT_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Try Statement</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRY_STATEMENT_FEATURE_COUNT = STATEMENT_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link de.jevopi.mitra2.mitra.impl.CatchImpl <em>Catch</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.jevopi.mitra2.mitra.impl.CatchImpl
   * @see de.jevopi.mitra2.mitra.impl.MitraPackageImpl#getCatch()
   * @generated
   */
  int CATCH = 42;

  /**
   * The feature id for the '<em><b>Formal Parameter</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CATCH__FORMAL_PARAMETER = 0;

  /**
   * The feature id for the '<em><b>Block</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CATCH__BLOCK = 1;

  /**
   * The number of structural features of the '<em>Catch</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CATCH_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link de.jevopi.mitra2.mitra.impl.ExpressionImpl <em>Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.jevopi.mitra2.mitra.impl.ExpressionImpl
   * @see de.jevopi.mitra2.mitra.impl.MitraPackageImpl#getExpression()
   * @generated
   */
  int EXPRESSION = 43;

  /**
   * The number of structural features of the '<em>Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPRESSION_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link de.jevopi.mitra2.mitra.impl.TerminalExpressionImpl <em>Terminal Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.jevopi.mitra2.mitra.impl.TerminalExpressionImpl
   * @see de.jevopi.mitra2.mitra.impl.MitraPackageImpl#getTerminalExpression()
   * @generated
   */
  int TERMINAL_EXPRESSION = 44;

  /**
   * The number of structural features of the '<em>Terminal Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TERMINAL_EXPRESSION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link de.jevopi.mitra2.mitra.impl.LiteralImpl <em>Literal</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.jevopi.mitra2.mitra.impl.LiteralImpl
   * @see de.jevopi.mitra2.mitra.impl.MitraPackageImpl#getLiteral()
   * @generated
   */
  int LITERAL = 45;

  /**
   * The number of structural features of the '<em>Literal</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LITERAL_FEATURE_COUNT = TERMINAL_EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link de.jevopi.mitra2.mitra.impl.StringLiteralImpl <em>String Literal</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.jevopi.mitra2.mitra.impl.StringLiteralImpl
   * @see de.jevopi.mitra2.mitra.impl.MitraPackageImpl#getStringLiteral()
   * @generated
   */
  int STRING_LITERAL = 46;

  /**
   * The feature id for the '<em><b>String Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STRING_LITERAL__STRING_VALUE = LITERAL_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>String Literal</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STRING_LITERAL_FEATURE_COUNT = LITERAL_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link de.jevopi.mitra2.mitra.impl.IntLiteralImpl <em>Int Literal</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.jevopi.mitra2.mitra.impl.IntLiteralImpl
   * @see de.jevopi.mitra2.mitra.impl.MitraPackageImpl#getIntLiteral()
   * @generated
   */
  int INT_LITERAL = 47;

  /**
   * The feature id for the '<em><b>Int Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INT_LITERAL__INT_VALUE = LITERAL_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Int Literal</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INT_LITERAL_FEATURE_COUNT = LITERAL_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link de.jevopi.mitra2.mitra.impl.RealLiteralImpl <em>Real Literal</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.jevopi.mitra2.mitra.impl.RealLiteralImpl
   * @see de.jevopi.mitra2.mitra.impl.MitraPackageImpl#getRealLiteral()
   * @generated
   */
  int REAL_LITERAL = 48;

  /**
   * The feature id for the '<em><b>Float Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REAL_LITERAL__FLOAT_VALUE = LITERAL_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Real Literal</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REAL_LITERAL_FEATURE_COUNT = LITERAL_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link de.jevopi.mitra2.mitra.impl.BooleanLiteralImpl <em>Boolean Literal</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.jevopi.mitra2.mitra.impl.BooleanLiteralImpl
   * @see de.jevopi.mitra2.mitra.impl.MitraPackageImpl#getBooleanLiteral()
   * @generated
   */
  int BOOLEAN_LITERAL = 49;

  /**
   * The feature id for the '<em><b>Boolean Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BOOLEAN_LITERAL__BOOLEAN_VALUE = LITERAL_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Boolean Literal</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BOOLEAN_LITERAL_FEATURE_COUNT = LITERAL_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link de.jevopi.mitra2.mitra.impl.NullLiteralImpl <em>Null Literal</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.jevopi.mitra2.mitra.impl.NullLiteralImpl
   * @see de.jevopi.mitra2.mitra.impl.MitraPackageImpl#getNullLiteral()
   * @generated
   */
  int NULL_LITERAL = 50;

  /**
   * The number of structural features of the '<em>Null Literal</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NULL_LITERAL_FEATURE_COUNT = LITERAL_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link de.jevopi.mitra2.mitra.impl.ClassInstanceCreationExpressionImpl <em>Class Instance Creation Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.jevopi.mitra2.mitra.impl.ClassInstanceCreationExpressionImpl
   * @see de.jevopi.mitra2.mitra.impl.MitraPackageImpl#getClassInstanceCreationExpression()
   * @generated
   */
  int CLASS_INSTANCE_CREATION_EXPRESSION = 51;

  /**
   * The feature id for the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLASS_INSTANCE_CREATION_EXPRESSION__TYPE = STATEMENT_EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Arguments</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLASS_INSTANCE_CREATION_EXPRESSION__ARGUMENTS = STATEMENT_EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Class Instance Creation Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLASS_INSTANCE_CREATION_EXPRESSION_FEATURE_COUNT = STATEMENT_EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link de.jevopi.mitra2.mitra.impl.RuleInvocationImpl <em>Rule Invocation</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.jevopi.mitra2.mitra.impl.RuleInvocationImpl
   * @see de.jevopi.mitra2.mitra.impl.MitraPackageImpl#getRuleInvocation()
   * @generated
   */
  int RULE_INVOCATION = 52;

  /**
   * The feature id for the '<em><b>Rule Declaration</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RULE_INVOCATION__RULE_DECLARATION = STATEMENT_EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Arguments</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RULE_INVOCATION__ARGUMENTS = STATEMENT_EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Rule Invocation</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RULE_INVOCATION_FEATURE_COUNT = STATEMENT_EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link de.jevopi.mitra2.mitra.impl.RuleInvocationSuperImpl <em>Rule Invocation Super</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.jevopi.mitra2.mitra.impl.RuleInvocationSuperImpl
   * @see de.jevopi.mitra2.mitra.impl.MitraPackageImpl#getRuleInvocationSuper()
   * @generated
   */
  int RULE_INVOCATION_SUPER = 53;

  /**
   * The number of structural features of the '<em>Rule Invocation Super</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RULE_INVOCATION_SUPER_FEATURE_COUNT = STATEMENT_EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link de.jevopi.mitra2.mitra.impl.FeatureImpl <em>Feature</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.jevopi.mitra2.mitra.impl.FeatureImpl
   * @see de.jevopi.mitra2.mitra.impl.MitraPackageImpl#getFeature()
   * @generated
   */
  int FEATURE = 54;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FEATURE__NAME = 0;

  /**
   * The number of structural features of the '<em>Feature</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FEATURE_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link de.jevopi.mitra2.mitra.impl.MethodInvocationImpl <em>Method Invocation</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.jevopi.mitra2.mitra.impl.MethodInvocationImpl
   * @see de.jevopi.mitra2.mitra.impl.MitraPackageImpl#getMethodInvocation()
   * @generated
   */
  int METHOD_INVOCATION = 55;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int METHOD_INVOCATION__NAME = FEATURE__NAME;

  /**
   * The feature id for the '<em><b>Arguments</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int METHOD_INVOCATION__ARGUMENTS = FEATURE_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Method Invocation</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int METHOD_INVOCATION_FEATURE_COUNT = FEATURE_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link de.jevopi.mitra2.mitra.impl.FeatureMethodInvocationImpl <em>Feature Method Invocation</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.jevopi.mitra2.mitra.impl.FeatureMethodInvocationImpl
   * @see de.jevopi.mitra2.mitra.impl.MitraPackageImpl#getFeatureMethodInvocation()
   * @generated
   */
  int FEATURE_METHOD_INVOCATION = 56;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FEATURE_METHOD_INVOCATION__NAME = METHOD_INVOCATION__NAME;

  /**
   * The feature id for the '<em><b>Arguments</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FEATURE_METHOD_INVOCATION__ARGUMENTS = METHOD_INVOCATION__ARGUMENTS;

  /**
   * The feature id for the '<em><b>Expression</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FEATURE_METHOD_INVOCATION__EXPRESSION = METHOD_INVOCATION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Feature Method Invocation</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FEATURE_METHOD_INVOCATION_FEATURE_COUNT = METHOD_INVOCATION_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link de.jevopi.mitra2.mitra.impl.NativeOperationInvocationImpl <em>Native Operation Invocation</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.jevopi.mitra2.mitra.impl.NativeOperationInvocationImpl
   * @see de.jevopi.mitra2.mitra.impl.MitraPackageImpl#getNativeOperationInvocation()
   * @generated
   */
  int NATIVE_OPERATION_INVOCATION = 57;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NATIVE_OPERATION_INVOCATION__NAME = METHOD_INVOCATION__NAME;

  /**
   * The feature id for the '<em><b>Arguments</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NATIVE_OPERATION_INVOCATION__ARGUMENTS = METHOD_INVOCATION__ARGUMENTS;

  /**
   * The number of structural features of the '<em>Native Operation Invocation</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NATIVE_OPERATION_INVOCATION_FEATURE_COUNT = METHOD_INVOCATION_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link de.jevopi.mitra2.mitra.impl.MetamodelFeatureImpl <em>Metamodel Feature</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.jevopi.mitra2.mitra.impl.MetamodelFeatureImpl
   * @see de.jevopi.mitra2.mitra.impl.MitraPackageImpl#getMetamodelFeature()
   * @generated
   */
  int METAMODEL_FEATURE = 58;

  /**
   * The number of structural features of the '<em>Metamodel Feature</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int METAMODEL_FEATURE_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link de.jevopi.mitra2.mitra.impl.FeatureFieldImpl <em>Feature Field</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.jevopi.mitra2.mitra.impl.FeatureFieldImpl
   * @see de.jevopi.mitra2.mitra.impl.MitraPackageImpl#getFeatureField()
   * @generated
   */
  int FEATURE_FIELD = 59;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FEATURE_FIELD__NAME = FEATURE__NAME;

  /**
   * The feature id for the '<em><b>Expression</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FEATURE_FIELD__EXPRESSION = FEATURE_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Feature Field</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FEATURE_FIELD_FEATURE_COUNT = FEATURE_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link de.jevopi.mitra2.mitra.impl.VariableAccessImpl <em>Variable Access</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.jevopi.mitra2.mitra.impl.VariableAccessImpl
   * @see de.jevopi.mitra2.mitra.impl.MitraPackageImpl#getVariableAccess()
   * @generated
   */
  int VARIABLE_ACCESS = 60;

  /**
   * The feature id for the '<em><b>Prefix Operator</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VARIABLE_ACCESS__PREFIX_OPERATOR = STATEMENT_EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Variable</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VARIABLE_ACCESS__VARIABLE = STATEMENT_EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Features</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VARIABLE_ACCESS__FEATURES = STATEMENT_EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Default</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VARIABLE_ACCESS__DEFAULT = STATEMENT_EXPRESSION_FEATURE_COUNT + 3;

  /**
   * The feature id for the '<em><b>Postfix Operator</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VARIABLE_ACCESS__POSTFIX_OPERATOR = STATEMENT_EXPRESSION_FEATURE_COUNT + 4;

  /**
   * The number of structural features of the '<em>Variable Access</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VARIABLE_ACCESS_FEATURE_COUNT = STATEMENT_EXPRESSION_FEATURE_COUNT + 5;

  /**
   * The meta object id for the '{@link de.jevopi.mitra2.mitra.impl.StaticAccessImpl <em>Static Access</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.jevopi.mitra2.mitra.impl.StaticAccessImpl
   * @see de.jevopi.mitra2.mitra.impl.MitraPackageImpl#getStaticAccess()
   * @generated
   */
  int STATIC_ACCESS = 61;

  /**
   * The feature id for the '<em><b>Expression</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATIC_ACCESS__EXPRESSION = STATEMENT_EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATIC_ACCESS__TYPE = STATEMENT_EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Features</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATIC_ACCESS__FEATURES = STATEMENT_EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Static Access</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATIC_ACCESS_FEATURE_COUNT = STATEMENT_EXPRESSION_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link de.jevopi.mitra2.mitra.impl.AnnotationsDefinitionImpl <em>Annotations Definition</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.jevopi.mitra2.mitra.impl.AnnotationsDefinitionImpl
   * @see de.jevopi.mitra2.mitra.impl.MitraPackageImpl#getAnnotationsDefinition()
   * @generated
   */
  int ANNOTATIONS_DEFINITION = 62;

  /**
   * The feature id for the '<em><b>Annotation Decls</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ANNOTATIONS_DEFINITION__ANNOTATION_DECLS = 0;

  /**
   * The number of structural features of the '<em>Annotations Definition</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ANNOTATIONS_DEFINITION_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link de.jevopi.mitra2.mitra.impl.AnnotationDeclImpl <em>Annotation Decl</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.jevopi.mitra2.mitra.impl.AnnotationDeclImpl
   * @see de.jevopi.mitra2.mitra.impl.MitraPackageImpl#getAnnotationDecl()
   * @generated
   */
  int ANNOTATION_DECL = 63;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ANNOTATION_DECL__NAME = 0;

  /**
   * The feature id for the '<em><b>Targets</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ANNOTATION_DECL__TARGETS = 1;

  /**
   * The feature id for the '<em><b>Valuetype</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ANNOTATION_DECL__VALUETYPE = 2;

  /**
   * The feature id for the '<em><b>Many</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ANNOTATION_DECL__MANY = 3;

  /**
   * The feature id for the '<em><b>Required</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ANNOTATION_DECL__REQUIRED = 4;

  /**
   * The feature id for the '<em><b>Default</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ANNOTATION_DECL__DEFAULT = 5;

  /**
   * The feature id for the '<em><b>Property Decls</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ANNOTATION_DECL__PROPERTY_DECLS = 6;

  /**
   * The number of structural features of the '<em>Annotation Decl</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ANNOTATION_DECL_FEATURE_COUNT = 7;

  /**
   * The meta object id for the '{@link de.jevopi.mitra2.mitra.impl.AnnotationPropertyDeclImpl <em>Annotation Property Decl</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.jevopi.mitra2.mitra.impl.AnnotationPropertyDeclImpl
   * @see de.jevopi.mitra2.mitra.impl.MitraPackageImpl#getAnnotationPropertyDecl()
   * @generated
   */
  int ANNOTATION_PROPERTY_DECL = 64;

  /**
   * The feature id for the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ANNOTATION_PROPERTY_DECL__TYPE = 0;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ANNOTATION_PROPERTY_DECL__NAME = 1;

  /**
   * The feature id for the '<em><b>Required</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ANNOTATION_PROPERTY_DECL__REQUIRED = 2;

  /**
   * The feature id for the '<em><b>Default</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ANNOTATION_PROPERTY_DECL__DEFAULT = 3;

  /**
   * The number of structural features of the '<em>Annotation Property Decl</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ANNOTATION_PROPERTY_DECL_FEATURE_COUNT = 4;

  /**
   * The meta object id for the '{@link de.jevopi.mitra2.mitra.impl.AnnotationImpl <em>Annotation</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.jevopi.mitra2.mitra.impl.AnnotationImpl
   * @see de.jevopi.mitra2.mitra.impl.MitraPackageImpl#getAnnotation()
   * @generated
   */
  int ANNOTATION = 65;

  /**
   * The feature id for the '<em><b>Decl</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ANNOTATION__DECL = 0;

  /**
   * The feature id for the '<em><b>Values</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ANNOTATION__VALUES = 1;

  /**
   * The feature id for the '<em><b>Properties</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ANNOTATION__PROPERTIES = 2;

  /**
   * The number of structural features of the '<em>Annotation</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ANNOTATION_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link de.jevopi.mitra2.mitra.impl.AnnotationPropertyImpl <em>Annotation Property</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.jevopi.mitra2.mitra.impl.AnnotationPropertyImpl
   * @see de.jevopi.mitra2.mitra.impl.MitraPackageImpl#getAnnotationProperty()
   * @generated
   */
  int ANNOTATION_PROPERTY = 66;

  /**
   * The feature id for the '<em><b>Decl</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ANNOTATION_PROPERTY__DECL = 0;

  /**
   * The feature id for the '<em><b>Value</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ANNOTATION_PROPERTY__VALUE = 1;

  /**
   * The number of structural features of the '<em>Annotation Property</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ANNOTATION_PROPERTY_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link de.jevopi.mitra2.mitra.impl.AssignmentImpl <em>Assignment</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.jevopi.mitra2.mitra.impl.AssignmentImpl
   * @see de.jevopi.mitra2.mitra.impl.MitraPackageImpl#getAssignment()
   * @generated
   */
  int ASSIGNMENT = 67;

  /**
   * The feature id for the '<em><b>Lhs</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSIGNMENT__LHS = STATEMENT_EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Operator</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSIGNMENT__OPERATOR = STATEMENT_EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Expression</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSIGNMENT__EXPRESSION = STATEMENT_EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Assignment</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSIGNMENT_FEATURE_COUNT = STATEMENT_EXPRESSION_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link de.jevopi.mitra2.mitra.impl.IteratorExpressionImpl <em>Iterator Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.jevopi.mitra2.mitra.impl.IteratorExpressionImpl
   * @see de.jevopi.mitra2.mitra.impl.MitraPackageImpl#getIteratorExpression()
   * @generated
   */
  int ITERATOR_EXPRESSION = 68;

  /**
   * The feature id for the '<em><b>Variable</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ITERATOR_EXPRESSION__VARIABLE = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Expression</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ITERATOR_EXPRESSION__EXPRESSION = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Iterator Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ITERATOR_EXPRESSION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link de.jevopi.mitra2.mitra.impl.BooleanExpressionImpl <em>Boolean Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.jevopi.mitra2.mitra.impl.BooleanExpressionImpl
   * @see de.jevopi.mitra2.mitra.impl.MitraPackageImpl#getBooleanExpression()
   * @generated
   */
  int BOOLEAN_EXPRESSION = 69;

  /**
   * The feature id for the '<em><b>Lhs</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BOOLEAN_EXPRESSION__LHS = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Op</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BOOLEAN_EXPRESSION__OP = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Rhs</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BOOLEAN_EXPRESSION__RHS = EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Boolean Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BOOLEAN_EXPRESSION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link de.jevopi.mitra2.mitra.impl.EqualityExpressionImpl <em>Equality Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.jevopi.mitra2.mitra.impl.EqualityExpressionImpl
   * @see de.jevopi.mitra2.mitra.impl.MitraPackageImpl#getEqualityExpression()
   * @generated
   */
  int EQUALITY_EXPRESSION = 70;

  /**
   * The feature id for the '<em><b>Lhs</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EQUALITY_EXPRESSION__LHS = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Op</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EQUALITY_EXPRESSION__OP = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Rhs</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EQUALITY_EXPRESSION__RHS = EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Equality Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EQUALITY_EXPRESSION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link de.jevopi.mitra2.mitra.impl.RelationalExpressionImpl <em>Relational Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.jevopi.mitra2.mitra.impl.RelationalExpressionImpl
   * @see de.jevopi.mitra2.mitra.impl.MitraPackageImpl#getRelationalExpression()
   * @generated
   */
  int RELATIONAL_EXPRESSION = 71;

  /**
   * The feature id for the '<em><b>Lhs</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RELATIONAL_EXPRESSION__LHS = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Op</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RELATIONAL_EXPRESSION__OP = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Rhs</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RELATIONAL_EXPRESSION__RHS = EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Relational Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RELATIONAL_EXPRESSION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link de.jevopi.mitra2.mitra.impl.MathExpressionImpl <em>Math Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.jevopi.mitra2.mitra.impl.MathExpressionImpl
   * @see de.jevopi.mitra2.mitra.impl.MitraPackageImpl#getMathExpression()
   * @generated
   */
  int MATH_EXPRESSION = 72;

  /**
   * The feature id for the '<em><b>Lhs</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MATH_EXPRESSION__LHS = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Op</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MATH_EXPRESSION__OP = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Rhs</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MATH_EXPRESSION__RHS = EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Math Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MATH_EXPRESSION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link de.jevopi.mitra2.mitra.impl.UnaryCastExpressionImpl <em>Unary Cast Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.jevopi.mitra2.mitra.impl.UnaryCastExpressionImpl
   * @see de.jevopi.mitra2.mitra.impl.MitraPackageImpl#getUnaryCastExpression()
   * @generated
   */
  int UNARY_CAST_EXPRESSION = 73;

  /**
   * The feature id for the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UNARY_CAST_EXPRESSION__TYPE = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Expression</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UNARY_CAST_EXPRESSION__EXPRESSION = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Unary Cast Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UNARY_CAST_EXPRESSION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link de.jevopi.mitra2.mitra.impl.UnaryBooleanExpressionImpl <em>Unary Boolean Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.jevopi.mitra2.mitra.impl.UnaryBooleanExpressionImpl
   * @see de.jevopi.mitra2.mitra.impl.MitraPackageImpl#getUnaryBooleanExpression()
   * @generated
   */
  int UNARY_BOOLEAN_EXPRESSION = 74;

  /**
   * The feature id for the '<em><b>Expression</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UNARY_BOOLEAN_EXPRESSION__EXPRESSION = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Unary Boolean Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UNARY_BOOLEAN_EXPRESSION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link de.jevopi.mitra2.mitra.impl.UnaryMathExpressionImpl <em>Unary Math Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.jevopi.mitra2.mitra.impl.UnaryMathExpressionImpl
   * @see de.jevopi.mitra2.mitra.impl.MitraPackageImpl#getUnaryMathExpression()
   * @generated
   */
  int UNARY_MATH_EXPRESSION = 75;

  /**
   * The feature id for the '<em><b>Op</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UNARY_MATH_EXPRESSION__OP = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Expression</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UNARY_MATH_EXPRESSION__EXPRESSION = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Unary Math Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UNARY_MATH_EXPRESSION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link de.jevopi.mitra2.mitra.impl.InstanceOfExpressionImpl <em>Instance Of Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.jevopi.mitra2.mitra.impl.InstanceOfExpressionImpl
   * @see de.jevopi.mitra2.mitra.impl.MitraPackageImpl#getInstanceOfExpression()
   * @generated
   */
  int INSTANCE_OF_EXPRESSION = 76;

  /**
   * The feature id for the '<em><b>Expression</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INSTANCE_OF_EXPRESSION__EXPRESSION = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INSTANCE_OF_EXPRESSION__TYPE = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Instance Of Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INSTANCE_OF_EXPRESSION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link de.jevopi.mitra2.mitra.VisibilityModifier <em>Visibility Modifier</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.jevopi.mitra2.mitra.VisibilityModifier
   * @see de.jevopi.mitra2.mitra.impl.MitraPackageImpl#getVisibilityModifier()
   * @generated
   */
  int VISIBILITY_MODIFIER = 77;

  /**
   * The meta object id for the '{@link de.jevopi.mitra2.mitra.ExecutionModifier <em>Execution Modifier</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.jevopi.mitra2.mitra.ExecutionModifier
   * @see de.jevopi.mitra2.mitra.impl.MitraPackageImpl#getExecutionModifier()
   * @generated
   */
  int EXECUTION_MODIFIER = 78;

  /**
   * The meta object id for the '{@link de.jevopi.mitra2.mitra.ParameterModifier <em>Parameter Modifier</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.jevopi.mitra2.mitra.ParameterModifier
   * @see de.jevopi.mitra2.mitra.impl.MitraPackageImpl#getParameterModifier()
   * @generated
   */
  int PARAMETER_MODIFIER = 79;

  /**
   * The meta object id for the '{@link de.jevopi.mitra2.mitra.PrimitiveTypeSpec <em>Primitive Type Spec</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.jevopi.mitra2.mitra.PrimitiveTypeSpec
   * @see de.jevopi.mitra2.mitra.impl.MitraPackageImpl#getPrimitiveTypeSpec()
   * @generated
   */
  int PRIMITIVE_TYPE_SPEC = 80;

  /**
   * The meta object id for the '{@link de.jevopi.mitra2.mitra.CollectionTypeSpec <em>Collection Type Spec</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.jevopi.mitra2.mitra.CollectionTypeSpec
   * @see de.jevopi.mitra2.mitra.impl.MitraPackageImpl#getCollectionTypeSpec()
   * @generated
   */
  int COLLECTION_TYPE_SPEC = 81;

  /**
   * The meta object id for the '{@link de.jevopi.mitra2.mitra.BooleanOperator <em>Boolean Operator</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.jevopi.mitra2.mitra.BooleanOperator
   * @see de.jevopi.mitra2.mitra.impl.MitraPackageImpl#getBooleanOperator()
   * @generated
   */
  int BOOLEAN_OPERATOR = 82;

  /**
   * The meta object id for the '{@link de.jevopi.mitra2.mitra.EqualityOperator <em>Equality Operator</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.jevopi.mitra2.mitra.EqualityOperator
   * @see de.jevopi.mitra2.mitra.impl.MitraPackageImpl#getEqualityOperator()
   * @generated
   */
  int EQUALITY_OPERATOR = 83;

  /**
   * The meta object id for the '{@link de.jevopi.mitra2.mitra.RelationalOperator <em>Relational Operator</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.jevopi.mitra2.mitra.RelationalOperator
   * @see de.jevopi.mitra2.mitra.impl.MitraPackageImpl#getRelationalOperator()
   * @generated
   */
  int RELATIONAL_OPERATOR = 84;

  /**
   * The meta object id for the '{@link de.jevopi.mitra2.mitra.MathOperator <em>Math Operator</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.jevopi.mitra2.mitra.MathOperator
   * @see de.jevopi.mitra2.mitra.impl.MitraPackageImpl#getMathOperator()
   * @generated
   */
  int MATH_OPERATOR = 85;

  /**
   * The meta object id for the '{@link de.jevopi.mitra2.mitra.UnaryMathOperator <em>Unary Math Operator</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.jevopi.mitra2.mitra.UnaryMathOperator
   * @see de.jevopi.mitra2.mitra.impl.MitraPackageImpl#getUnaryMathOperator()
   * @generated
   */
  int UNARY_MATH_OPERATOR = 86;

  /**
   * The meta object id for the '{@link de.jevopi.mitra2.mitra.AssignmentOperator <em>Assignment Operator</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.jevopi.mitra2.mitra.AssignmentOperator
   * @see de.jevopi.mitra2.mitra.impl.MitraPackageImpl#getAssignmentOperator()
   * @generated
   */
  int ASSIGNMENT_OPERATOR = 87;

  /**
   * The meta object id for the '{@link de.jevopi.mitra2.mitra.PPOperator <em>PP Operator</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.jevopi.mitra2.mitra.PPOperator
   * @see de.jevopi.mitra2.mitra.impl.MitraPackageImpl#getPPOperator()
   * @generated
   */
  int PP_OPERATOR = 88;

  /**
   * The meta object id for the '{@link de.jevopi.mitra2.mitra.AnnotationTargetSpec <em>Annotation Target Spec</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.jevopi.mitra2.mitra.AnnotationTargetSpec
   * @see de.jevopi.mitra2.mitra.impl.MitraPackageImpl#getAnnotationTargetSpec()
   * @generated
   */
  int ANNOTATION_TARGET_SPEC = 89;


  /**
   * Returns the meta object for class '{@link de.jevopi.mitra2.mitra.Module <em>Module</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Module</em>'.
   * @see de.jevopi.mitra2.mitra.Module
   * @generated
   */
  EClass getModule();

  /**
   * Returns the meta object for the attribute '{@link de.jevopi.mitra2.mitra.Module#getPackageName <em>Package Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Package Name</em>'.
   * @see de.jevopi.mitra2.mitra.Module#getPackageName()
   * @see #getModule()
   * @generated
   */
  EAttribute getModule_PackageName();

  /**
   * Returns the meta object for the attribute '{@link de.jevopi.mitra2.mitra.Module#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see de.jevopi.mitra2.mitra.Module#getName()
   * @see #getModule()
   * @generated
   */
  EAttribute getModule_Name();

  /**
   * Returns the meta object for the containment reference list '{@link de.jevopi.mitra2.mitra.Module#getImports <em>Imports</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Imports</em>'.
   * @see de.jevopi.mitra2.mitra.Module#getImports()
   * @see #getModule()
   * @generated
   */
  EReference getModule_Imports();

  /**
   * Returns the meta object for the containment reference list '{@link de.jevopi.mitra2.mitra.Module#getMetamodelDeclarations <em>Metamodel Declarations</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Metamodel Declarations</em>'.
   * @see de.jevopi.mitra2.mitra.Module#getMetamodelDeclarations()
   * @see #getModule()
   * @generated
   */
  EReference getModule_MetamodelDeclarations();

  /**
   * Returns the meta object for the containment reference list '{@link de.jevopi.mitra2.mitra.Module#getAnnotationDefinitions <em>Annotation Definitions</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Annotation Definitions</em>'.
   * @see de.jevopi.mitra2.mitra.Module#getAnnotationDefinitions()
   * @see #getModule()
   * @generated
   */
  EReference getModule_AnnotationDefinitions();

  /**
   * Returns the meta object for the containment reference list '{@link de.jevopi.mitra2.mitra.Module#getRuleDeclarations <em>Rule Declarations</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Rule Declarations</em>'.
   * @see de.jevopi.mitra2.mitra.Module#getRuleDeclarations()
   * @see #getModule()
   * @generated
   */
  EReference getModule_RuleDeclarations();

  /**
   * Returns the meta object for class '{@link de.jevopi.mitra2.mitra.ModuleReference <em>Module Reference</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Module Reference</em>'.
   * @see de.jevopi.mitra2.mitra.ModuleReference
   * @generated
   */
  EClass getModuleReference();

  /**
   * Returns the meta object for the reference '{@link de.jevopi.mitra2.mitra.ModuleReference#getModule <em>Module</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Module</em>'.
   * @see de.jevopi.mitra2.mitra.ModuleReference#getModule()
   * @see #getModuleReference()
   * @generated
   */
  EReference getModuleReference_Module();

  /**
   * Returns the meta object for class '{@link de.jevopi.mitra2.mitra.MetamodelDeclaration <em>Metamodel Declaration</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Metamodel Declaration</em>'.
   * @see de.jevopi.mitra2.mitra.MetamodelDeclaration
   * @generated
   */
  EClass getMetamodelDeclaration();

  /**
   * Returns the meta object for the attribute '{@link de.jevopi.mitra2.mitra.MetamodelDeclaration#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Type</em>'.
   * @see de.jevopi.mitra2.mitra.MetamodelDeclaration#getType()
   * @see #getMetamodelDeclaration()
   * @generated
   */
  EAttribute getMetamodelDeclaration_Type();

  /**
   * Returns the meta object for the attribute '{@link de.jevopi.mitra2.mitra.MetamodelDeclaration#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see de.jevopi.mitra2.mitra.MetamodelDeclaration#getName()
   * @see #getMetamodelDeclaration()
   * @generated
   */
  EAttribute getMetamodelDeclaration_Name();

  /**
   * Returns the meta object for the containment reference list '{@link de.jevopi.mitra2.mitra.MetamodelDeclaration#getProperties <em>Properties</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Properties</em>'.
   * @see de.jevopi.mitra2.mitra.MetamodelDeclaration#getProperties()
   * @see #getMetamodelDeclaration()
   * @generated
   */
  EReference getMetamodelDeclaration_Properties();

  /**
   * Returns the meta object for the attribute list '{@link de.jevopi.mitra2.mitra.MetamodelDeclaration#getReplaces <em>Replaces</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Replaces</em>'.
   * @see de.jevopi.mitra2.mitra.MetamodelDeclaration#getReplaces()
   * @see #getMetamodelDeclaration()
   * @generated
   */
  EAttribute getMetamodelDeclaration_Replaces();

  /**
   * Returns the meta object for class '{@link de.jevopi.mitra2.mitra.Property <em>Property</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Property</em>'.
   * @see de.jevopi.mitra2.mitra.Property
   * @generated
   */
  EClass getProperty();

  /**
   * Returns the meta object for the attribute '{@link de.jevopi.mitra2.mitra.Property#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see de.jevopi.mitra2.mitra.Property#getName()
   * @see #getProperty()
   * @generated
   */
  EAttribute getProperty_Name();

  /**
   * Returns the meta object for the attribute '{@link de.jevopi.mitra2.mitra.Property#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see de.jevopi.mitra2.mitra.Property#getValue()
   * @see #getProperty()
   * @generated
   */
  EAttribute getProperty_Value();

  /**
   * Returns the meta object for class '{@link de.jevopi.mitra2.mitra.RuleDeclaration <em>Rule Declaration</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Rule Declaration</em>'.
   * @see de.jevopi.mitra2.mitra.RuleDeclaration
   * @generated
   */
  EClass getRuleDeclaration();

  /**
   * Returns the meta object for the containment reference list '{@link de.jevopi.mitra2.mitra.RuleDeclaration#getAnnotations <em>Annotations</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Annotations</em>'.
   * @see de.jevopi.mitra2.mitra.RuleDeclaration#getAnnotations()
   * @see #getRuleDeclaration()
   * @generated
   */
  EReference getRuleDeclaration_Annotations();

  /**
   * Returns the meta object for the attribute '{@link de.jevopi.mitra2.mitra.RuleDeclaration#getVisibility <em>Visibility</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Visibility</em>'.
   * @see de.jevopi.mitra2.mitra.RuleDeclaration#getVisibility()
   * @see #getRuleDeclaration()
   * @generated
   */
  EAttribute getRuleDeclaration_Visibility();

  /**
   * Returns the meta object for the attribute '{@link de.jevopi.mitra2.mitra.RuleDeclaration#getExec <em>Exec</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Exec</em>'.
   * @see de.jevopi.mitra2.mitra.RuleDeclaration#getExec()
   * @see #getRuleDeclaration()
   * @generated
   */
  EAttribute getRuleDeclaration_Exec();

  /**
   * Returns the meta object for the attribute '{@link de.jevopi.mitra2.mitra.RuleDeclaration#isTraced <em>Traced</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Traced</em>'.
   * @see de.jevopi.mitra2.mitra.RuleDeclaration#isTraced()
   * @see #getRuleDeclaration()
   * @generated
   */
  EAttribute getRuleDeclaration_Traced();

  /**
   * Returns the meta object for the attribute '{@link de.jevopi.mitra2.mitra.RuleDeclaration#isStealth <em>Stealth</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Stealth</em>'.
   * @see de.jevopi.mitra2.mitra.RuleDeclaration#isStealth()
   * @see #getRuleDeclaration()
   * @generated
   */
  EAttribute getRuleDeclaration_Stealth();

  /**
   * Returns the meta object for the attribute '{@link de.jevopi.mitra2.mitra.RuleDeclaration#isVirtual <em>Virtual</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Virtual</em>'.
   * @see de.jevopi.mitra2.mitra.RuleDeclaration#isVirtual()
   * @see #getRuleDeclaration()
   * @generated
   */
  EAttribute getRuleDeclaration_Virtual();

  /**
   * Returns the meta object for the attribute '{@link de.jevopi.mitra2.mitra.RuleDeclaration#isMulti <em>Multi</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Multi</em>'.
   * @see de.jevopi.mitra2.mitra.RuleDeclaration#isMulti()
   * @see #getRuleDeclaration()
   * @generated
   */
  EAttribute getRuleDeclaration_Multi();

  /**
   * Returns the meta object for the attribute '{@link de.jevopi.mitra2.mitra.RuleDeclaration#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see de.jevopi.mitra2.mitra.RuleDeclaration#getName()
   * @see #getRuleDeclaration()
   * @generated
   */
  EAttribute getRuleDeclaration_Name();

  /**
   * Returns the meta object for the containment reference list '{@link de.jevopi.mitra2.mitra.RuleDeclaration#getFormalParameters <em>Formal Parameters</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Formal Parameters</em>'.
   * @see de.jevopi.mitra2.mitra.RuleDeclaration#getFormalParameters()
   * @see #getRuleDeclaration()
   * @generated
   */
  EReference getRuleDeclaration_FormalParameters();

  /**
   * Returns the meta object for the containment reference list '{@link de.jevopi.mitra2.mitra.RuleDeclaration#getReturnParameters <em>Return Parameters</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Return Parameters</em>'.
   * @see de.jevopi.mitra2.mitra.RuleDeclaration#getReturnParameters()
   * @see #getRuleDeclaration()
   * @generated
   */
  EReference getRuleDeclaration_ReturnParameters();

  /**
   * Returns the meta object for the containment reference list '{@link de.jevopi.mitra2.mitra.RuleDeclaration#getImplementedRules <em>Implemented Rules</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Implemented Rules</em>'.
   * @see de.jevopi.mitra2.mitra.RuleDeclaration#getImplementedRules()
   * @see #getRuleDeclaration()
   * @generated
   */
  EReference getRuleDeclaration_ImplementedRules();

  /**
   * Returns the meta object for the containment reference '{@link de.jevopi.mitra2.mitra.RuleDeclaration#getOverriddenRule <em>Overridden Rule</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Overridden Rule</em>'.
   * @see de.jevopi.mitra2.mitra.RuleDeclaration#getOverriddenRule()
   * @see #getRuleDeclaration()
   * @generated
   */
  EReference getRuleDeclaration_OverriddenRule();

  /**
   * Returns the meta object for the containment reference list '{@link de.jevopi.mitra2.mitra.RuleDeclaration#getExcludingRules <em>Excluding Rules</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Excluding Rules</em>'.
   * @see de.jevopi.mitra2.mitra.RuleDeclaration#getExcludingRules()
   * @see #getRuleDeclaration()
   * @generated
   */
  EReference getRuleDeclaration_ExcludingRules();

  /**
   * Returns the meta object for the containment reference '{@link de.jevopi.mitra2.mitra.RuleDeclaration#getTrigger <em>Trigger</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Trigger</em>'.
   * @see de.jevopi.mitra2.mitra.RuleDeclaration#getTrigger()
   * @see #getRuleDeclaration()
   * @generated
   */
  EReference getRuleDeclaration_Trigger();

  /**
   * Returns the meta object for the containment reference '{@link de.jevopi.mitra2.mitra.RuleDeclaration#getJavaSpec <em>Java Spec</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Java Spec</em>'.
   * @see de.jevopi.mitra2.mitra.RuleDeclaration#getJavaSpec()
   * @see #getRuleDeclaration()
   * @generated
   */
  EReference getRuleDeclaration_JavaSpec();

  /**
   * Returns the meta object for the containment reference '{@link de.jevopi.mitra2.mitra.RuleDeclaration#getBody <em>Body</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Body</em>'.
   * @see de.jevopi.mitra2.mitra.RuleDeclaration#getBody()
   * @see #getRuleDeclaration()
   * @generated
   */
  EReference getRuleDeclaration_Body();

  /**
   * Returns the meta object for class '{@link de.jevopi.mitra2.mitra.RuleReference <em>Rule Reference</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Rule Reference</em>'.
   * @see de.jevopi.mitra2.mitra.RuleReference
   * @generated
   */
  EClass getRuleReference();

  /**
   * Returns the meta object for the reference '{@link de.jevopi.mitra2.mitra.RuleReference#getRuleDeclaration <em>Rule Declaration</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Rule Declaration</em>'.
   * @see de.jevopi.mitra2.mitra.RuleReference#getRuleDeclaration()
   * @see #getRuleReference()
   * @generated
   */
  EReference getRuleReference_RuleDeclaration();

  /**
   * Returns the meta object for class '{@link de.jevopi.mitra2.mitra.SimpleRuleReference <em>Simple Rule Reference</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Simple Rule Reference</em>'.
   * @see de.jevopi.mitra2.mitra.SimpleRuleReference
   * @generated
   */
  EClass getSimpleRuleReference();

  /**
   * Returns the meta object for the containment reference list '{@link de.jevopi.mitra2.mitra.SimpleRuleReference#getParameterReferences <em>Parameter References</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Parameter References</em>'.
   * @see de.jevopi.mitra2.mitra.SimpleRuleReference#getParameterReferences()
   * @see #getSimpleRuleReference()
   * @generated
   */
  EReference getSimpleRuleReference_ParameterReferences();

  /**
   * Returns the meta object for the containment reference list '{@link de.jevopi.mitra2.mitra.SimpleRuleReference#getReturnReferences <em>Return References</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Return References</em>'.
   * @see de.jevopi.mitra2.mitra.SimpleRuleReference#getReturnReferences()
   * @see #getSimpleRuleReference()
   * @generated
   */
  EReference getSimpleRuleReference_ReturnReferences();

  /**
   * Returns the meta object for class '{@link de.jevopi.mitra2.mitra.QualifiedRuleReference <em>Qualified Rule Reference</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Qualified Rule Reference</em>'.
   * @see de.jevopi.mitra2.mitra.QualifiedRuleReference
   * @generated
   */
  EClass getQualifiedRuleReference();

  /**
   * Returns the meta object for the containment reference list '{@link de.jevopi.mitra2.mitra.QualifiedRuleReference#getParameterReferences <em>Parameter References</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Parameter References</em>'.
   * @see de.jevopi.mitra2.mitra.QualifiedRuleReference#getParameterReferences()
   * @see #getQualifiedRuleReference()
   * @generated
   */
  EReference getQualifiedRuleReference_ParameterReferences();

  /**
   * Returns the meta object for the containment reference list '{@link de.jevopi.mitra2.mitra.QualifiedRuleReference#getReturnReferences <em>Return References</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Return References</em>'.
   * @see de.jevopi.mitra2.mitra.QualifiedRuleReference#getReturnReferences()
   * @see #getQualifiedRuleReference()
   * @generated
   */
  EReference getQualifiedRuleReference_ReturnReferences();

  /**
   * Returns the meta object for class '{@link de.jevopi.mitra2.mitra.ParameterReference <em>Parameter Reference</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Parameter Reference</em>'.
   * @see de.jevopi.mitra2.mitra.ParameterReference
   * @generated
   */
  EClass getParameterReference();

  /**
   * Returns the meta object for class '{@link de.jevopi.mitra2.mitra.SimpleParameterReference <em>Simple Parameter Reference</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Simple Parameter Reference</em>'.
   * @see de.jevopi.mitra2.mitra.SimpleParameterReference
   * @generated
   */
  EClass getSimpleParameterReference();

  /**
   * Returns the meta object for the containment reference '{@link de.jevopi.mitra2.mitra.SimpleParameterReference#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Type</em>'.
   * @see de.jevopi.mitra2.mitra.SimpleParameterReference#getType()
   * @see #getSimpleParameterReference()
   * @generated
   */
  EReference getSimpleParameterReference_Type();

  /**
   * Returns the meta object for the attribute '{@link de.jevopi.mitra2.mitra.SimpleParameterReference#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see de.jevopi.mitra2.mitra.SimpleParameterReference#getName()
   * @see #getSimpleParameterReference()
   * @generated
   */
  EAttribute getSimpleParameterReference_Name();

  /**
   * Returns the meta object for class '{@link de.jevopi.mitra2.mitra.QualifiedParameterReference <em>Qualified Parameter Reference</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Qualified Parameter Reference</em>'.
   * @see de.jevopi.mitra2.mitra.QualifiedParameterReference
   * @generated
   */
  EClass getQualifiedParameterReference();

  /**
   * Returns the meta object for the containment reference '{@link de.jevopi.mitra2.mitra.QualifiedParameterReference#getVardecl <em>Vardecl</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Vardecl</em>'.
   * @see de.jevopi.mitra2.mitra.QualifiedParameterReference#getVardecl()
   * @see #getQualifiedParameterReference()
   * @generated
   */
  EReference getQualifiedParameterReference_Vardecl();

  /**
   * Returns the meta object for class '{@link de.jevopi.mitra2.mitra.Trigger <em>Trigger</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Trigger</em>'.
   * @see de.jevopi.mitra2.mitra.Trigger
   * @generated
   */
  EClass getTrigger();

  /**
   * Returns the meta object for the containment reference list '{@link de.jevopi.mitra2.mitra.Trigger#getTriggerRules <em>Trigger Rules</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Trigger Rules</em>'.
   * @see de.jevopi.mitra2.mitra.Trigger#getTriggerRules()
   * @see #getTrigger()
   * @generated
   */
  EReference getTrigger_TriggerRules();

  /**
   * Returns the meta object for the containment reference '{@link de.jevopi.mitra2.mitra.Trigger#getWith <em>With</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>With</em>'.
   * @see de.jevopi.mitra2.mitra.Trigger#getWith()
   * @see #getTrigger()
   * @generated
   */
  EReference getTrigger_With();

  /**
   * Returns the meta object for the containment reference '{@link de.jevopi.mitra2.mitra.Trigger#getWhen <em>When</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>When</em>'.
   * @see de.jevopi.mitra2.mitra.Trigger#getWhen()
   * @see #getTrigger()
   * @generated
   */
  EReference getTrigger_When();

  /**
   * Returns the meta object for class '{@link de.jevopi.mitra2.mitra.JavaSpec <em>Java Spec</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Java Spec</em>'.
   * @see de.jevopi.mitra2.mitra.JavaSpec
   * @generated
   */
  EClass getJavaSpec();

  /**
   * Returns the meta object for the containment reference list '{@link de.jevopi.mitra2.mitra.JavaSpec#getProperties <em>Properties</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Properties</em>'.
   * @see de.jevopi.mitra2.mitra.JavaSpec#getProperties()
   * @see #getJavaSpec()
   * @generated
   */
  EReference getJavaSpec_Properties();

  /**
   * Returns the meta object for class '{@link de.jevopi.mitra2.mitra.Parameter <em>Parameter</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Parameter</em>'.
   * @see de.jevopi.mitra2.mitra.Parameter
   * @generated
   */
  EClass getParameter();

  /**
   * Returns the meta object for the containment reference list '{@link de.jevopi.mitra2.mitra.Parameter#getAnnotations <em>Annotations</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Annotations</em>'.
   * @see de.jevopi.mitra2.mitra.Parameter#getAnnotations()
   * @see #getParameter()
   * @generated
   */
  EReference getParameter_Annotations();

  /**
   * Returns the meta object for the attribute '{@link de.jevopi.mitra2.mitra.Parameter#getModifier <em>Modifier</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Modifier</em>'.
   * @see de.jevopi.mitra2.mitra.Parameter#getModifier()
   * @see #getParameter()
   * @generated
   */
  EAttribute getParameter_Modifier();

  /**
   * Returns the meta object for the containment reference '{@link de.jevopi.mitra2.mitra.Parameter#getVardecl <em>Vardecl</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Vardecl</em>'.
   * @see de.jevopi.mitra2.mitra.Parameter#getVardecl()
   * @see #getParameter()
   * @generated
   */
  EReference getParameter_Vardecl();

  /**
   * Returns the meta object for class '{@link de.jevopi.mitra2.mitra.FormalParameter <em>Formal Parameter</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Formal Parameter</em>'.
   * @see de.jevopi.mitra2.mitra.FormalParameter
   * @generated
   */
  EClass getFormalParameter();

  /**
   * Returns the meta object for class '{@link de.jevopi.mitra2.mitra.ReturnParameter <em>Return Parameter</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Return Parameter</em>'.
   * @see de.jevopi.mitra2.mitra.ReturnParameter
   * @generated
   */
  EClass getReturnParameter();

  /**
   * Returns the meta object for class '{@link de.jevopi.mitra2.mitra.Type <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Type</em>'.
   * @see de.jevopi.mitra2.mitra.Type
   * @generated
   */
  EClass getType();

  /**
   * Returns the meta object for class '{@link de.jevopi.mitra2.mitra.ReferenceType <em>Reference Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Reference Type</em>'.
   * @see de.jevopi.mitra2.mitra.ReferenceType
   * @generated
   */
  EClass getReferenceType();

  /**
   * Returns the meta object for the reference '{@link de.jevopi.mitra2.mitra.ReferenceType#getMetamodelDeclaration <em>Metamodel Declaration</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Metamodel Declaration</em>'.
   * @see de.jevopi.mitra2.mitra.ReferenceType#getMetamodelDeclaration()
   * @see #getReferenceType()
   * @generated
   */
  EReference getReferenceType_MetamodelDeclaration();

  /**
   * Returns the meta object for the reference '{@link de.jevopi.mitra2.mitra.ReferenceType#getEClassifier <em>EClassifier</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>EClassifier</em>'.
   * @see de.jevopi.mitra2.mitra.ReferenceType#getEClassifier()
   * @see #getReferenceType()
   * @generated
   */
  EReference getReferenceType_EClassifier();

  /**
   * Returns the meta object for class '{@link de.jevopi.mitra2.mitra.PrimitiveType <em>Primitive Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Primitive Type</em>'.
   * @see de.jevopi.mitra2.mitra.PrimitiveType
   * @generated
   */
  EClass getPrimitiveType();

  /**
   * Returns the meta object for the attribute '{@link de.jevopi.mitra2.mitra.PrimitiveType#getPrimitiveType <em>Primitive Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Primitive Type</em>'.
   * @see de.jevopi.mitra2.mitra.PrimitiveType#getPrimitiveType()
   * @see #getPrimitiveType()
   * @generated
   */
  EAttribute getPrimitiveType_PrimitiveType();

  /**
   * Returns the meta object for class '{@link de.jevopi.mitra2.mitra.CollectionType <em>Collection Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Collection Type</em>'.
   * @see de.jevopi.mitra2.mitra.CollectionType
   * @generated
   */
  EClass getCollectionType();

  /**
   * Returns the meta object for the attribute '{@link de.jevopi.mitra2.mitra.CollectionType#getCollectionType <em>Collection Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Collection Type</em>'.
   * @see de.jevopi.mitra2.mitra.CollectionType#getCollectionType()
   * @see #getCollectionType()
   * @generated
   */
  EAttribute getCollectionType_CollectionType();

  /**
   * Returns the meta object for the containment reference '{@link de.jevopi.mitra2.mitra.CollectionType#getTypePar <em>Type Par</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Type Par</em>'.
   * @see de.jevopi.mitra2.mitra.CollectionType#getTypePar()
   * @see #getCollectionType()
   * @generated
   */
  EReference getCollectionType_TypePar();

  /**
   * Returns the meta object for class '{@link de.jevopi.mitra2.mitra.Block <em>Block</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Block</em>'.
   * @see de.jevopi.mitra2.mitra.Block
   * @generated
   */
  EClass getBlock();

  /**
   * Returns the meta object for the containment reference list '{@link de.jevopi.mitra2.mitra.Block#getStatements <em>Statements</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Statements</em>'.
   * @see de.jevopi.mitra2.mitra.Block#getStatements()
   * @see #getBlock()
   * @generated
   */
  EReference getBlock_Statements();

  /**
   * Returns the meta object for class '{@link de.jevopi.mitra2.mitra.BlockStatement <em>Block Statement</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Block Statement</em>'.
   * @see de.jevopi.mitra2.mitra.BlockStatement
   * @generated
   */
  EClass getBlockStatement();

  /**
   * Returns the meta object for class '{@link de.jevopi.mitra2.mitra.Statement <em>Statement</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Statement</em>'.
   * @see de.jevopi.mitra2.mitra.Statement
   * @generated
   */
  EClass getStatement();

  /**
   * Returns the meta object for class '{@link de.jevopi.mitra2.mitra.LocalVariableDeclarationStatement <em>Local Variable Declaration Statement</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Local Variable Declaration Statement</em>'.
   * @see de.jevopi.mitra2.mitra.LocalVariableDeclarationStatement
   * @generated
   */
  EClass getLocalVariableDeclarationStatement();

  /**
   * Returns the meta object for the containment reference '{@link de.jevopi.mitra2.mitra.LocalVariableDeclarationStatement#getLocalVariableDeclaration <em>Local Variable Declaration</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Local Variable Declaration</em>'.
   * @see de.jevopi.mitra2.mitra.LocalVariableDeclarationStatement#getLocalVariableDeclaration()
   * @see #getLocalVariableDeclarationStatement()
   * @generated
   */
  EReference getLocalVariableDeclarationStatement_LocalVariableDeclaration();

  /**
   * Returns the meta object for class '{@link de.jevopi.mitra2.mitra.LocalVariableDeclaration <em>Local Variable Declaration</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Local Variable Declaration</em>'.
   * @see de.jevopi.mitra2.mitra.LocalVariableDeclaration
   * @generated
   */
  EClass getLocalVariableDeclaration();

  /**
   * Returns the meta object for the containment reference '{@link de.jevopi.mitra2.mitra.LocalVariableDeclaration#getVardecl <em>Vardecl</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Vardecl</em>'.
   * @see de.jevopi.mitra2.mitra.LocalVariableDeclaration#getVardecl()
   * @see #getLocalVariableDeclaration()
   * @generated
   */
  EReference getLocalVariableDeclaration_Vardecl();

  /**
   * Returns the meta object for the containment reference '{@link de.jevopi.mitra2.mitra.LocalVariableDeclaration#getExpression <em>Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Expression</em>'.
   * @see de.jevopi.mitra2.mitra.LocalVariableDeclaration#getExpression()
   * @see #getLocalVariableDeclaration()
   * @generated
   */
  EReference getLocalVariableDeclaration_Expression();

  /**
   * Returns the meta object for class '{@link de.jevopi.mitra2.mitra.VarDeclaration <em>Var Declaration</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Var Declaration</em>'.
   * @see de.jevopi.mitra2.mitra.VarDeclaration
   * @generated
   */
  EClass getVarDeclaration();

  /**
   * Returns the meta object for the containment reference '{@link de.jevopi.mitra2.mitra.VarDeclaration#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Type</em>'.
   * @see de.jevopi.mitra2.mitra.VarDeclaration#getType()
   * @see #getVarDeclaration()
   * @generated
   */
  EReference getVarDeclaration_Type();

  /**
   * Returns the meta object for the attribute '{@link de.jevopi.mitra2.mitra.VarDeclaration#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see de.jevopi.mitra2.mitra.VarDeclaration#getName()
   * @see #getVarDeclaration()
   * @generated
   */
  EAttribute getVarDeclaration_Name();

  /**
   * Returns the meta object for class '{@link de.jevopi.mitra2.mitra.TypedVarDeclaration <em>Typed Var Declaration</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Typed Var Declaration</em>'.
   * @see de.jevopi.mitra2.mitra.TypedVarDeclaration
   * @generated
   */
  EClass getTypedVarDeclaration();

  /**
   * Returns the meta object for class '{@link de.jevopi.mitra2.mitra.InferredVarDeclaration <em>Inferred Var Declaration</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Inferred Var Declaration</em>'.
   * @see de.jevopi.mitra2.mitra.InferredVarDeclaration
   * @generated
   */
  EClass getInferredVarDeclaration();

  /**
   * Returns the meta object for class '{@link de.jevopi.mitra2.mitra.ExpressionStatement <em>Expression Statement</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Expression Statement</em>'.
   * @see de.jevopi.mitra2.mitra.ExpressionStatement
   * @generated
   */
  EClass getExpressionStatement();

  /**
   * Returns the meta object for the containment reference '{@link de.jevopi.mitra2.mitra.ExpressionStatement#getStatementExpression <em>Statement Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Statement Expression</em>'.
   * @see de.jevopi.mitra2.mitra.ExpressionStatement#getStatementExpression()
   * @see #getExpressionStatement()
   * @generated
   */
  EReference getExpressionStatement_StatementExpression();

  /**
   * Returns the meta object for class '{@link de.jevopi.mitra2.mitra.StatementExpression <em>Statement Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Statement Expression</em>'.
   * @see de.jevopi.mitra2.mitra.StatementExpression
   * @generated
   */
  EClass getStatementExpression();

  /**
   * Returns the meta object for class '{@link de.jevopi.mitra2.mitra.EmptyStatement <em>Empty Statement</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Empty Statement</em>'.
   * @see de.jevopi.mitra2.mitra.EmptyStatement
   * @generated
   */
  EClass getEmptyStatement();

  /**
   * Returns the meta object for class '{@link de.jevopi.mitra2.mitra.ReturnStatement <em>Return Statement</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Return Statement</em>'.
   * @see de.jevopi.mitra2.mitra.ReturnStatement
   * @generated
   */
  EClass getReturnStatement();

  /**
   * Returns the meta object for the containment reference '{@link de.jevopi.mitra2.mitra.ReturnStatement#getExpression <em>Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Expression</em>'.
   * @see de.jevopi.mitra2.mitra.ReturnStatement#getExpression()
   * @see #getReturnStatement()
   * @generated
   */
  EReference getReturnStatement_Expression();

  /**
   * Returns the meta object for class '{@link de.jevopi.mitra2.mitra.IfStatement <em>If Statement</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>If Statement</em>'.
   * @see de.jevopi.mitra2.mitra.IfStatement
   * @generated
   */
  EClass getIfStatement();

  /**
   * Returns the meta object for the containment reference '{@link de.jevopi.mitra2.mitra.IfStatement#getExpression <em>Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Expression</em>'.
   * @see de.jevopi.mitra2.mitra.IfStatement#getExpression()
   * @see #getIfStatement()
   * @generated
   */
  EReference getIfStatement_Expression();

  /**
   * Returns the meta object for the containment reference '{@link de.jevopi.mitra2.mitra.IfStatement#getTrueStatement <em>True Statement</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>True Statement</em>'.
   * @see de.jevopi.mitra2.mitra.IfStatement#getTrueStatement()
   * @see #getIfStatement()
   * @generated
   */
  EReference getIfStatement_TrueStatement();

  /**
   * Returns the meta object for the containment reference '{@link de.jevopi.mitra2.mitra.IfStatement#getElseStatement <em>Else Statement</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Else Statement</em>'.
   * @see de.jevopi.mitra2.mitra.IfStatement#getElseStatement()
   * @see #getIfStatement()
   * @generated
   */
  EReference getIfStatement_ElseStatement();

  /**
   * Returns the meta object for class '{@link de.jevopi.mitra2.mitra.WhileStatement <em>While Statement</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>While Statement</em>'.
   * @see de.jevopi.mitra2.mitra.WhileStatement
   * @generated
   */
  EClass getWhileStatement();

  /**
   * Returns the meta object for the containment reference '{@link de.jevopi.mitra2.mitra.WhileStatement#getExpression <em>Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Expression</em>'.
   * @see de.jevopi.mitra2.mitra.WhileStatement#getExpression()
   * @see #getWhileStatement()
   * @generated
   */
  EReference getWhileStatement_Expression();

  /**
   * Returns the meta object for the containment reference '{@link de.jevopi.mitra2.mitra.WhileStatement#getStatement <em>Statement</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Statement</em>'.
   * @see de.jevopi.mitra2.mitra.WhileStatement#getStatement()
   * @see #getWhileStatement()
   * @generated
   */
  EReference getWhileStatement_Statement();

  /**
   * Returns the meta object for class '{@link de.jevopi.mitra2.mitra.DoStatement <em>Do Statement</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Do Statement</em>'.
   * @see de.jevopi.mitra2.mitra.DoStatement
   * @generated
   */
  EClass getDoStatement();

  /**
   * Returns the meta object for the containment reference '{@link de.jevopi.mitra2.mitra.DoStatement#getStatement <em>Statement</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Statement</em>'.
   * @see de.jevopi.mitra2.mitra.DoStatement#getStatement()
   * @see #getDoStatement()
   * @generated
   */
  EReference getDoStatement_Statement();

  /**
   * Returns the meta object for the containment reference '{@link de.jevopi.mitra2.mitra.DoStatement#getExpression <em>Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Expression</em>'.
   * @see de.jevopi.mitra2.mitra.DoStatement#getExpression()
   * @see #getDoStatement()
   * @generated
   */
  EReference getDoStatement_Expression();

  /**
   * Returns the meta object for class '{@link de.jevopi.mitra2.mitra.ForInit <em>For Init</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>For Init</em>'.
   * @see de.jevopi.mitra2.mitra.ForInit
   * @generated
   */
  EClass getForInit();

  /**
   * Returns the meta object for the containment reference list '{@link de.jevopi.mitra2.mitra.ForInit#getStatementExpressions <em>Statement Expressions</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Statement Expressions</em>'.
   * @see de.jevopi.mitra2.mitra.ForInit#getStatementExpressions()
   * @see #getForInit()
   * @generated
   */
  EReference getForInit_StatementExpressions();

  /**
   * Returns the meta object for the containment reference list '{@link de.jevopi.mitra2.mitra.ForInit#getVarDeclarations <em>Var Declarations</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Var Declarations</em>'.
   * @see de.jevopi.mitra2.mitra.ForInit#getVarDeclarations()
   * @see #getForInit()
   * @generated
   */
  EReference getForInit_VarDeclarations();

  /**
   * Returns the meta object for class '{@link de.jevopi.mitra2.mitra.ForUpdate <em>For Update</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>For Update</em>'.
   * @see de.jevopi.mitra2.mitra.ForUpdate
   * @generated
   */
  EClass getForUpdate();

  /**
   * Returns the meta object for the containment reference list '{@link de.jevopi.mitra2.mitra.ForUpdate#getStatementExpression <em>Statement Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Statement Expression</em>'.
   * @see de.jevopi.mitra2.mitra.ForUpdate#getStatementExpression()
   * @see #getForUpdate()
   * @generated
   */
  EReference getForUpdate_StatementExpression();

  /**
   * Returns the meta object for class '{@link de.jevopi.mitra2.mitra.ForStatement <em>For Statement</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>For Statement</em>'.
   * @see de.jevopi.mitra2.mitra.ForStatement
   * @generated
   */
  EClass getForStatement();

  /**
   * Returns the meta object for the containment reference '{@link de.jevopi.mitra2.mitra.ForStatement#getLoopVariable <em>Loop Variable</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Loop Variable</em>'.
   * @see de.jevopi.mitra2.mitra.ForStatement#getLoopVariable()
   * @see #getForStatement()
   * @generated
   */
  EReference getForStatement_LoopVariable();

  /**
   * Returns the meta object for the containment reference '{@link de.jevopi.mitra2.mitra.ForStatement#getExpression <em>Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Expression</em>'.
   * @see de.jevopi.mitra2.mitra.ForStatement#getExpression()
   * @see #getForStatement()
   * @generated
   */
  EReference getForStatement_Expression();

  /**
   * Returns the meta object for the containment reference '{@link de.jevopi.mitra2.mitra.ForStatement#getForInit <em>For Init</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>For Init</em>'.
   * @see de.jevopi.mitra2.mitra.ForStatement#getForInit()
   * @see #getForStatement()
   * @generated
   */
  EReference getForStatement_ForInit();

  /**
   * Returns the meta object for the containment reference '{@link de.jevopi.mitra2.mitra.ForStatement#getForUpdate <em>For Update</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>For Update</em>'.
   * @see de.jevopi.mitra2.mitra.ForStatement#getForUpdate()
   * @see #getForStatement()
   * @generated
   */
  EReference getForStatement_ForUpdate();

  /**
   * Returns the meta object for the containment reference '{@link de.jevopi.mitra2.mitra.ForStatement#getStatement <em>Statement</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Statement</em>'.
   * @see de.jevopi.mitra2.mitra.ForStatement#getStatement()
   * @see #getForStatement()
   * @generated
   */
  EReference getForStatement_Statement();

  /**
   * Returns the meta object for class '{@link de.jevopi.mitra2.mitra.LoopVariable <em>Loop Variable</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Loop Variable</em>'.
   * @see de.jevopi.mitra2.mitra.LoopVariable
   * @generated
   */
  EClass getLoopVariable();

  /**
   * Returns the meta object for the containment reference '{@link de.jevopi.mitra2.mitra.LoopVariable#getVardecl <em>Vardecl</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Vardecl</em>'.
   * @see de.jevopi.mitra2.mitra.LoopVariable#getVardecl()
   * @see #getLoopVariable()
   * @generated
   */
  EReference getLoopVariable_Vardecl();

  /**
   * Returns the meta object for class '{@link de.jevopi.mitra2.mitra.BreakStatement <em>Break Statement</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Break Statement</em>'.
   * @see de.jevopi.mitra2.mitra.BreakStatement
   * @generated
   */
  EClass getBreakStatement();

  /**
   * Returns the meta object for class '{@link de.jevopi.mitra2.mitra.ThrowStatement <em>Throw Statement</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Throw Statement</em>'.
   * @see de.jevopi.mitra2.mitra.ThrowStatement
   * @generated
   */
  EClass getThrowStatement();

  /**
   * Returns the meta object for the containment reference '{@link de.jevopi.mitra2.mitra.ThrowStatement#getExpression <em>Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Expression</em>'.
   * @see de.jevopi.mitra2.mitra.ThrowStatement#getExpression()
   * @see #getThrowStatement()
   * @generated
   */
  EReference getThrowStatement_Expression();

  /**
   * Returns the meta object for class '{@link de.jevopi.mitra2.mitra.TryStatement <em>Try Statement</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Try Statement</em>'.
   * @see de.jevopi.mitra2.mitra.TryStatement
   * @generated
   */
  EClass getTryStatement();

  /**
   * Returns the meta object for the containment reference '{@link de.jevopi.mitra2.mitra.TryStatement#getTryBlock <em>Try Block</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Try Block</em>'.
   * @see de.jevopi.mitra2.mitra.TryStatement#getTryBlock()
   * @see #getTryStatement()
   * @generated
   */
  EReference getTryStatement_TryBlock();

  /**
   * Returns the meta object for the containment reference list '{@link de.jevopi.mitra2.mitra.TryStatement#getCatches <em>Catches</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Catches</em>'.
   * @see de.jevopi.mitra2.mitra.TryStatement#getCatches()
   * @see #getTryStatement()
   * @generated
   */
  EReference getTryStatement_Catches();

  /**
   * Returns the meta object for the containment reference '{@link de.jevopi.mitra2.mitra.TryStatement#getFinallyBlock <em>Finally Block</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Finally Block</em>'.
   * @see de.jevopi.mitra2.mitra.TryStatement#getFinallyBlock()
   * @see #getTryStatement()
   * @generated
   */
  EReference getTryStatement_FinallyBlock();

  /**
   * Returns the meta object for class '{@link de.jevopi.mitra2.mitra.Catch <em>Catch</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Catch</em>'.
   * @see de.jevopi.mitra2.mitra.Catch
   * @generated
   */
  EClass getCatch();

  /**
   * Returns the meta object for the containment reference '{@link de.jevopi.mitra2.mitra.Catch#getFormalParameter <em>Formal Parameter</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Formal Parameter</em>'.
   * @see de.jevopi.mitra2.mitra.Catch#getFormalParameter()
   * @see #getCatch()
   * @generated
   */
  EReference getCatch_FormalParameter();

  /**
   * Returns the meta object for the containment reference '{@link de.jevopi.mitra2.mitra.Catch#getBlock <em>Block</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Block</em>'.
   * @see de.jevopi.mitra2.mitra.Catch#getBlock()
   * @see #getCatch()
   * @generated
   */
  EReference getCatch_Block();

  /**
   * Returns the meta object for class '{@link de.jevopi.mitra2.mitra.Expression <em>Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Expression</em>'.
   * @see de.jevopi.mitra2.mitra.Expression
   * @generated
   */
  EClass getExpression();

  /**
   * Returns the meta object for class '{@link de.jevopi.mitra2.mitra.TerminalExpression <em>Terminal Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Terminal Expression</em>'.
   * @see de.jevopi.mitra2.mitra.TerminalExpression
   * @generated
   */
  EClass getTerminalExpression();

  /**
   * Returns the meta object for class '{@link de.jevopi.mitra2.mitra.Literal <em>Literal</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Literal</em>'.
   * @see de.jevopi.mitra2.mitra.Literal
   * @generated
   */
  EClass getLiteral();

  /**
   * Returns the meta object for class '{@link de.jevopi.mitra2.mitra.StringLiteral <em>String Literal</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>String Literal</em>'.
   * @see de.jevopi.mitra2.mitra.StringLiteral
   * @generated
   */
  EClass getStringLiteral();

  /**
   * Returns the meta object for the attribute '{@link de.jevopi.mitra2.mitra.StringLiteral#getStringValue <em>String Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>String Value</em>'.
   * @see de.jevopi.mitra2.mitra.StringLiteral#getStringValue()
   * @see #getStringLiteral()
   * @generated
   */
  EAttribute getStringLiteral_StringValue();

  /**
   * Returns the meta object for class '{@link de.jevopi.mitra2.mitra.IntLiteral <em>Int Literal</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Int Literal</em>'.
   * @see de.jevopi.mitra2.mitra.IntLiteral
   * @generated
   */
  EClass getIntLiteral();

  /**
   * Returns the meta object for the attribute '{@link de.jevopi.mitra2.mitra.IntLiteral#getIntValue <em>Int Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Int Value</em>'.
   * @see de.jevopi.mitra2.mitra.IntLiteral#getIntValue()
   * @see #getIntLiteral()
   * @generated
   */
  EAttribute getIntLiteral_IntValue();

  /**
   * Returns the meta object for class '{@link de.jevopi.mitra2.mitra.RealLiteral <em>Real Literal</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Real Literal</em>'.
   * @see de.jevopi.mitra2.mitra.RealLiteral
   * @generated
   */
  EClass getRealLiteral();

  /**
   * Returns the meta object for the attribute '{@link de.jevopi.mitra2.mitra.RealLiteral#getFloatValue <em>Float Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Float Value</em>'.
   * @see de.jevopi.mitra2.mitra.RealLiteral#getFloatValue()
   * @see #getRealLiteral()
   * @generated
   */
  EAttribute getRealLiteral_FloatValue();

  /**
   * Returns the meta object for class '{@link de.jevopi.mitra2.mitra.BooleanLiteral <em>Boolean Literal</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Boolean Literal</em>'.
   * @see de.jevopi.mitra2.mitra.BooleanLiteral
   * @generated
   */
  EClass getBooleanLiteral();

  /**
   * Returns the meta object for the attribute '{@link de.jevopi.mitra2.mitra.BooleanLiteral#isBooleanValue <em>Boolean Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Boolean Value</em>'.
   * @see de.jevopi.mitra2.mitra.BooleanLiteral#isBooleanValue()
   * @see #getBooleanLiteral()
   * @generated
   */
  EAttribute getBooleanLiteral_BooleanValue();

  /**
   * Returns the meta object for class '{@link de.jevopi.mitra2.mitra.NullLiteral <em>Null Literal</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Null Literal</em>'.
   * @see de.jevopi.mitra2.mitra.NullLiteral
   * @generated
   */
  EClass getNullLiteral();

  /**
   * Returns the meta object for class '{@link de.jevopi.mitra2.mitra.ClassInstanceCreationExpression <em>Class Instance Creation Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Class Instance Creation Expression</em>'.
   * @see de.jevopi.mitra2.mitra.ClassInstanceCreationExpression
   * @generated
   */
  EClass getClassInstanceCreationExpression();

  /**
   * Returns the meta object for the containment reference '{@link de.jevopi.mitra2.mitra.ClassInstanceCreationExpression#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Type</em>'.
   * @see de.jevopi.mitra2.mitra.ClassInstanceCreationExpression#getType()
   * @see #getClassInstanceCreationExpression()
   * @generated
   */
  EReference getClassInstanceCreationExpression_Type();

  /**
   * Returns the meta object for the containment reference list '{@link de.jevopi.mitra2.mitra.ClassInstanceCreationExpression#getArguments <em>Arguments</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Arguments</em>'.
   * @see de.jevopi.mitra2.mitra.ClassInstanceCreationExpression#getArguments()
   * @see #getClassInstanceCreationExpression()
   * @generated
   */
  EReference getClassInstanceCreationExpression_Arguments();

  /**
   * Returns the meta object for class '{@link de.jevopi.mitra2.mitra.RuleInvocation <em>Rule Invocation</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Rule Invocation</em>'.
   * @see de.jevopi.mitra2.mitra.RuleInvocation
   * @generated
   */
  EClass getRuleInvocation();

  /**
   * Returns the meta object for the reference '{@link de.jevopi.mitra2.mitra.RuleInvocation#getRuleDeclaration <em>Rule Declaration</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Rule Declaration</em>'.
   * @see de.jevopi.mitra2.mitra.RuleInvocation#getRuleDeclaration()
   * @see #getRuleInvocation()
   * @generated
   */
  EReference getRuleInvocation_RuleDeclaration();

  /**
   * Returns the meta object for the containment reference list '{@link de.jevopi.mitra2.mitra.RuleInvocation#getArguments <em>Arguments</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Arguments</em>'.
   * @see de.jevopi.mitra2.mitra.RuleInvocation#getArguments()
   * @see #getRuleInvocation()
   * @generated
   */
  EReference getRuleInvocation_Arguments();

  /**
   * Returns the meta object for class '{@link de.jevopi.mitra2.mitra.RuleInvocationSuper <em>Rule Invocation Super</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Rule Invocation Super</em>'.
   * @see de.jevopi.mitra2.mitra.RuleInvocationSuper
   * @generated
   */
  EClass getRuleInvocationSuper();

  /**
   * Returns the meta object for class '{@link de.jevopi.mitra2.mitra.Feature <em>Feature</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Feature</em>'.
   * @see de.jevopi.mitra2.mitra.Feature
   * @generated
   */
  EClass getFeature();

  /**
   * Returns the meta object for the attribute '{@link de.jevopi.mitra2.mitra.Feature#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see de.jevopi.mitra2.mitra.Feature#getName()
   * @see #getFeature()
   * @generated
   */
  EAttribute getFeature_Name();

  /**
   * Returns the meta object for class '{@link de.jevopi.mitra2.mitra.MethodInvocation <em>Method Invocation</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Method Invocation</em>'.
   * @see de.jevopi.mitra2.mitra.MethodInvocation
   * @generated
   */
  EClass getMethodInvocation();

  /**
   * Returns the meta object for the containment reference list '{@link de.jevopi.mitra2.mitra.MethodInvocation#getArguments <em>Arguments</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Arguments</em>'.
   * @see de.jevopi.mitra2.mitra.MethodInvocation#getArguments()
   * @see #getMethodInvocation()
   * @generated
   */
  EReference getMethodInvocation_Arguments();

  /**
   * Returns the meta object for class '{@link de.jevopi.mitra2.mitra.FeatureMethodInvocation <em>Feature Method Invocation</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Feature Method Invocation</em>'.
   * @see de.jevopi.mitra2.mitra.FeatureMethodInvocation
   * @generated
   */
  EClass getFeatureMethodInvocation();

  /**
   * Returns the meta object for the containment reference '{@link de.jevopi.mitra2.mitra.FeatureMethodInvocation#getExpression <em>Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Expression</em>'.
   * @see de.jevopi.mitra2.mitra.FeatureMethodInvocation#getExpression()
   * @see #getFeatureMethodInvocation()
   * @generated
   */
  EReference getFeatureMethodInvocation_Expression();

  /**
   * Returns the meta object for class '{@link de.jevopi.mitra2.mitra.NativeOperationInvocation <em>Native Operation Invocation</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Native Operation Invocation</em>'.
   * @see de.jevopi.mitra2.mitra.NativeOperationInvocation
   * @generated
   */
  EClass getNativeOperationInvocation();

  /**
   * Returns the meta object for class '{@link de.jevopi.mitra2.mitra.MetamodelFeature <em>Metamodel Feature</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Metamodel Feature</em>'.
   * @see de.jevopi.mitra2.mitra.MetamodelFeature
   * @generated
   */
  EClass getMetamodelFeature();

  /**
   * Returns the meta object for class '{@link de.jevopi.mitra2.mitra.FeatureField <em>Feature Field</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Feature Field</em>'.
   * @see de.jevopi.mitra2.mitra.FeatureField
   * @generated
   */
  EClass getFeatureField();

  /**
   * Returns the meta object for the containment reference '{@link de.jevopi.mitra2.mitra.FeatureField#getExpression <em>Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Expression</em>'.
   * @see de.jevopi.mitra2.mitra.FeatureField#getExpression()
   * @see #getFeatureField()
   * @generated
   */
  EReference getFeatureField_Expression();

  /**
   * Returns the meta object for class '{@link de.jevopi.mitra2.mitra.VariableAccess <em>Variable Access</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Variable Access</em>'.
   * @see de.jevopi.mitra2.mitra.VariableAccess
   * @generated
   */
  EClass getVariableAccess();

  /**
   * Returns the meta object for the attribute '{@link de.jevopi.mitra2.mitra.VariableAccess#getPrefixOperator <em>Prefix Operator</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Prefix Operator</em>'.
   * @see de.jevopi.mitra2.mitra.VariableAccess#getPrefixOperator()
   * @see #getVariableAccess()
   * @generated
   */
  EAttribute getVariableAccess_PrefixOperator();

  /**
   * Returns the meta object for the reference '{@link de.jevopi.mitra2.mitra.VariableAccess#getVariable <em>Variable</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Variable</em>'.
   * @see de.jevopi.mitra2.mitra.VariableAccess#getVariable()
   * @see #getVariableAccess()
   * @generated
   */
  EReference getVariableAccess_Variable();

  /**
   * Returns the meta object for the containment reference list '{@link de.jevopi.mitra2.mitra.VariableAccess#getFeatures <em>Features</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Features</em>'.
   * @see de.jevopi.mitra2.mitra.VariableAccess#getFeatures()
   * @see #getVariableAccess()
   * @generated
   */
  EReference getVariableAccess_Features();

  /**
   * Returns the meta object for the containment reference '{@link de.jevopi.mitra2.mitra.VariableAccess#getDefault <em>Default</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Default</em>'.
   * @see de.jevopi.mitra2.mitra.VariableAccess#getDefault()
   * @see #getVariableAccess()
   * @generated
   */
  EReference getVariableAccess_Default();

  /**
   * Returns the meta object for the attribute '{@link de.jevopi.mitra2.mitra.VariableAccess#getPostfixOperator <em>Postfix Operator</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Postfix Operator</em>'.
   * @see de.jevopi.mitra2.mitra.VariableAccess#getPostfixOperator()
   * @see #getVariableAccess()
   * @generated
   */
  EAttribute getVariableAccess_PostfixOperator();

  /**
   * Returns the meta object for class '{@link de.jevopi.mitra2.mitra.StaticAccess <em>Static Access</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Static Access</em>'.
   * @see de.jevopi.mitra2.mitra.StaticAccess
   * @generated
   */
  EClass getStaticAccess();

  /**
   * Returns the meta object for the containment reference '{@link de.jevopi.mitra2.mitra.StaticAccess#getExpression <em>Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Expression</em>'.
   * @see de.jevopi.mitra2.mitra.StaticAccess#getExpression()
   * @see #getStaticAccess()
   * @generated
   */
  EReference getStaticAccess_Expression();

  /**
   * Returns the meta object for the containment reference '{@link de.jevopi.mitra2.mitra.StaticAccess#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Type</em>'.
   * @see de.jevopi.mitra2.mitra.StaticAccess#getType()
   * @see #getStaticAccess()
   * @generated
   */
  EReference getStaticAccess_Type();

  /**
   * Returns the meta object for the containment reference list '{@link de.jevopi.mitra2.mitra.StaticAccess#getFeatures <em>Features</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Features</em>'.
   * @see de.jevopi.mitra2.mitra.StaticAccess#getFeatures()
   * @see #getStaticAccess()
   * @generated
   */
  EReference getStaticAccess_Features();

  /**
   * Returns the meta object for class '{@link de.jevopi.mitra2.mitra.AnnotationsDefinition <em>Annotations Definition</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Annotations Definition</em>'.
   * @see de.jevopi.mitra2.mitra.AnnotationsDefinition
   * @generated
   */
  EClass getAnnotationsDefinition();

  /**
   * Returns the meta object for the containment reference list '{@link de.jevopi.mitra2.mitra.AnnotationsDefinition#getAnnotationDecls <em>Annotation Decls</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Annotation Decls</em>'.
   * @see de.jevopi.mitra2.mitra.AnnotationsDefinition#getAnnotationDecls()
   * @see #getAnnotationsDefinition()
   * @generated
   */
  EReference getAnnotationsDefinition_AnnotationDecls();

  /**
   * Returns the meta object for class '{@link de.jevopi.mitra2.mitra.AnnotationDecl <em>Annotation Decl</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Annotation Decl</em>'.
   * @see de.jevopi.mitra2.mitra.AnnotationDecl
   * @generated
   */
  EClass getAnnotationDecl();

  /**
   * Returns the meta object for the attribute '{@link de.jevopi.mitra2.mitra.AnnotationDecl#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see de.jevopi.mitra2.mitra.AnnotationDecl#getName()
   * @see #getAnnotationDecl()
   * @generated
   */
  EAttribute getAnnotationDecl_Name();

  /**
   * Returns the meta object for the attribute list '{@link de.jevopi.mitra2.mitra.AnnotationDecl#getTargets <em>Targets</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Targets</em>'.
   * @see de.jevopi.mitra2.mitra.AnnotationDecl#getTargets()
   * @see #getAnnotationDecl()
   * @generated
   */
  EAttribute getAnnotationDecl_Targets();

  /**
   * Returns the meta object for the containment reference '{@link de.jevopi.mitra2.mitra.AnnotationDecl#getValuetype <em>Valuetype</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Valuetype</em>'.
   * @see de.jevopi.mitra2.mitra.AnnotationDecl#getValuetype()
   * @see #getAnnotationDecl()
   * @generated
   */
  EReference getAnnotationDecl_Valuetype();

  /**
   * Returns the meta object for the attribute '{@link de.jevopi.mitra2.mitra.AnnotationDecl#isMany <em>Many</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Many</em>'.
   * @see de.jevopi.mitra2.mitra.AnnotationDecl#isMany()
   * @see #getAnnotationDecl()
   * @generated
   */
  EAttribute getAnnotationDecl_Many();

  /**
   * Returns the meta object for the attribute '{@link de.jevopi.mitra2.mitra.AnnotationDecl#isRequired <em>Required</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Required</em>'.
   * @see de.jevopi.mitra2.mitra.AnnotationDecl#isRequired()
   * @see #getAnnotationDecl()
   * @generated
   */
  EAttribute getAnnotationDecl_Required();

  /**
   * Returns the meta object for the containment reference '{@link de.jevopi.mitra2.mitra.AnnotationDecl#getDefault <em>Default</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Default</em>'.
   * @see de.jevopi.mitra2.mitra.AnnotationDecl#getDefault()
   * @see #getAnnotationDecl()
   * @generated
   */
  EReference getAnnotationDecl_Default();

  /**
   * Returns the meta object for the containment reference list '{@link de.jevopi.mitra2.mitra.AnnotationDecl#getPropertyDecls <em>Property Decls</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Property Decls</em>'.
   * @see de.jevopi.mitra2.mitra.AnnotationDecl#getPropertyDecls()
   * @see #getAnnotationDecl()
   * @generated
   */
  EReference getAnnotationDecl_PropertyDecls();

  /**
   * Returns the meta object for class '{@link de.jevopi.mitra2.mitra.AnnotationPropertyDecl <em>Annotation Property Decl</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Annotation Property Decl</em>'.
   * @see de.jevopi.mitra2.mitra.AnnotationPropertyDecl
   * @generated
   */
  EClass getAnnotationPropertyDecl();

  /**
   * Returns the meta object for the containment reference '{@link de.jevopi.mitra2.mitra.AnnotationPropertyDecl#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Type</em>'.
   * @see de.jevopi.mitra2.mitra.AnnotationPropertyDecl#getType()
   * @see #getAnnotationPropertyDecl()
   * @generated
   */
  EReference getAnnotationPropertyDecl_Type();

  /**
   * Returns the meta object for the attribute '{@link de.jevopi.mitra2.mitra.AnnotationPropertyDecl#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see de.jevopi.mitra2.mitra.AnnotationPropertyDecl#getName()
   * @see #getAnnotationPropertyDecl()
   * @generated
   */
  EAttribute getAnnotationPropertyDecl_Name();

  /**
   * Returns the meta object for the attribute '{@link de.jevopi.mitra2.mitra.AnnotationPropertyDecl#isRequired <em>Required</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Required</em>'.
   * @see de.jevopi.mitra2.mitra.AnnotationPropertyDecl#isRequired()
   * @see #getAnnotationPropertyDecl()
   * @generated
   */
  EAttribute getAnnotationPropertyDecl_Required();

  /**
   * Returns the meta object for the containment reference '{@link de.jevopi.mitra2.mitra.AnnotationPropertyDecl#getDefault <em>Default</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Default</em>'.
   * @see de.jevopi.mitra2.mitra.AnnotationPropertyDecl#getDefault()
   * @see #getAnnotationPropertyDecl()
   * @generated
   */
  EReference getAnnotationPropertyDecl_Default();

  /**
   * Returns the meta object for class '{@link de.jevopi.mitra2.mitra.Annotation <em>Annotation</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Annotation</em>'.
   * @see de.jevopi.mitra2.mitra.Annotation
   * @generated
   */
  EClass getAnnotation();

  /**
   * Returns the meta object for the reference '{@link de.jevopi.mitra2.mitra.Annotation#getDecl <em>Decl</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Decl</em>'.
   * @see de.jevopi.mitra2.mitra.Annotation#getDecl()
   * @see #getAnnotation()
   * @generated
   */
  EReference getAnnotation_Decl();

  /**
   * Returns the meta object for the containment reference list '{@link de.jevopi.mitra2.mitra.Annotation#getValues <em>Values</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Values</em>'.
   * @see de.jevopi.mitra2.mitra.Annotation#getValues()
   * @see #getAnnotation()
   * @generated
   */
  EReference getAnnotation_Values();

  /**
   * Returns the meta object for the containment reference list '{@link de.jevopi.mitra2.mitra.Annotation#getProperties <em>Properties</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Properties</em>'.
   * @see de.jevopi.mitra2.mitra.Annotation#getProperties()
   * @see #getAnnotation()
   * @generated
   */
  EReference getAnnotation_Properties();

  /**
   * Returns the meta object for class '{@link de.jevopi.mitra2.mitra.AnnotationProperty <em>Annotation Property</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Annotation Property</em>'.
   * @see de.jevopi.mitra2.mitra.AnnotationProperty
   * @generated
   */
  EClass getAnnotationProperty();

  /**
   * Returns the meta object for the reference '{@link de.jevopi.mitra2.mitra.AnnotationProperty#getDecl <em>Decl</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Decl</em>'.
   * @see de.jevopi.mitra2.mitra.AnnotationProperty#getDecl()
   * @see #getAnnotationProperty()
   * @generated
   */
  EReference getAnnotationProperty_Decl();

  /**
   * Returns the meta object for the containment reference '{@link de.jevopi.mitra2.mitra.AnnotationProperty#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Value</em>'.
   * @see de.jevopi.mitra2.mitra.AnnotationProperty#getValue()
   * @see #getAnnotationProperty()
   * @generated
   */
  EReference getAnnotationProperty_Value();

  /**
   * Returns the meta object for class '{@link de.jevopi.mitra2.mitra.Assignment <em>Assignment</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Assignment</em>'.
   * @see de.jevopi.mitra2.mitra.Assignment
   * @generated
   */
  EClass getAssignment();

  /**
   * Returns the meta object for the containment reference list '{@link de.jevopi.mitra2.mitra.Assignment#getLhs <em>Lhs</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Lhs</em>'.
   * @see de.jevopi.mitra2.mitra.Assignment#getLhs()
   * @see #getAssignment()
   * @generated
   */
  EReference getAssignment_Lhs();

  /**
   * Returns the meta object for the attribute '{@link de.jevopi.mitra2.mitra.Assignment#getOperator <em>Operator</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Operator</em>'.
   * @see de.jevopi.mitra2.mitra.Assignment#getOperator()
   * @see #getAssignment()
   * @generated
   */
  EAttribute getAssignment_Operator();

  /**
   * Returns the meta object for the containment reference '{@link de.jevopi.mitra2.mitra.Assignment#getExpression <em>Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Expression</em>'.
   * @see de.jevopi.mitra2.mitra.Assignment#getExpression()
   * @see #getAssignment()
   * @generated
   */
  EReference getAssignment_Expression();

  /**
   * Returns the meta object for class '{@link de.jevopi.mitra2.mitra.IteratorExpression <em>Iterator Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Iterator Expression</em>'.
   * @see de.jevopi.mitra2.mitra.IteratorExpression
   * @generated
   */
  EClass getIteratorExpression();

  /**
   * Returns the meta object for the containment reference '{@link de.jevopi.mitra2.mitra.IteratorExpression#getVariable <em>Variable</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Variable</em>'.
   * @see de.jevopi.mitra2.mitra.IteratorExpression#getVariable()
   * @see #getIteratorExpression()
   * @generated
   */
  EReference getIteratorExpression_Variable();

  /**
   * Returns the meta object for the containment reference '{@link de.jevopi.mitra2.mitra.IteratorExpression#getExpression <em>Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Expression</em>'.
   * @see de.jevopi.mitra2.mitra.IteratorExpression#getExpression()
   * @see #getIteratorExpression()
   * @generated
   */
  EReference getIteratorExpression_Expression();

  /**
   * Returns the meta object for class '{@link de.jevopi.mitra2.mitra.BooleanExpression <em>Boolean Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Boolean Expression</em>'.
   * @see de.jevopi.mitra2.mitra.BooleanExpression
   * @generated
   */
  EClass getBooleanExpression();

  /**
   * Returns the meta object for the containment reference '{@link de.jevopi.mitra2.mitra.BooleanExpression#getLhs <em>Lhs</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Lhs</em>'.
   * @see de.jevopi.mitra2.mitra.BooleanExpression#getLhs()
   * @see #getBooleanExpression()
   * @generated
   */
  EReference getBooleanExpression_Lhs();

  /**
   * Returns the meta object for the attribute '{@link de.jevopi.mitra2.mitra.BooleanExpression#getOp <em>Op</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Op</em>'.
   * @see de.jevopi.mitra2.mitra.BooleanExpression#getOp()
   * @see #getBooleanExpression()
   * @generated
   */
  EAttribute getBooleanExpression_Op();

  /**
   * Returns the meta object for the containment reference '{@link de.jevopi.mitra2.mitra.BooleanExpression#getRhs <em>Rhs</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Rhs</em>'.
   * @see de.jevopi.mitra2.mitra.BooleanExpression#getRhs()
   * @see #getBooleanExpression()
   * @generated
   */
  EReference getBooleanExpression_Rhs();

  /**
   * Returns the meta object for class '{@link de.jevopi.mitra2.mitra.EqualityExpression <em>Equality Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Equality Expression</em>'.
   * @see de.jevopi.mitra2.mitra.EqualityExpression
   * @generated
   */
  EClass getEqualityExpression();

  /**
   * Returns the meta object for the containment reference '{@link de.jevopi.mitra2.mitra.EqualityExpression#getLhs <em>Lhs</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Lhs</em>'.
   * @see de.jevopi.mitra2.mitra.EqualityExpression#getLhs()
   * @see #getEqualityExpression()
   * @generated
   */
  EReference getEqualityExpression_Lhs();

  /**
   * Returns the meta object for the attribute '{@link de.jevopi.mitra2.mitra.EqualityExpression#getOp <em>Op</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Op</em>'.
   * @see de.jevopi.mitra2.mitra.EqualityExpression#getOp()
   * @see #getEqualityExpression()
   * @generated
   */
  EAttribute getEqualityExpression_Op();

  /**
   * Returns the meta object for the containment reference '{@link de.jevopi.mitra2.mitra.EqualityExpression#getRhs <em>Rhs</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Rhs</em>'.
   * @see de.jevopi.mitra2.mitra.EqualityExpression#getRhs()
   * @see #getEqualityExpression()
   * @generated
   */
  EReference getEqualityExpression_Rhs();

  /**
   * Returns the meta object for class '{@link de.jevopi.mitra2.mitra.RelationalExpression <em>Relational Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Relational Expression</em>'.
   * @see de.jevopi.mitra2.mitra.RelationalExpression
   * @generated
   */
  EClass getRelationalExpression();

  /**
   * Returns the meta object for the containment reference '{@link de.jevopi.mitra2.mitra.RelationalExpression#getLhs <em>Lhs</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Lhs</em>'.
   * @see de.jevopi.mitra2.mitra.RelationalExpression#getLhs()
   * @see #getRelationalExpression()
   * @generated
   */
  EReference getRelationalExpression_Lhs();

  /**
   * Returns the meta object for the attribute '{@link de.jevopi.mitra2.mitra.RelationalExpression#getOp <em>Op</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Op</em>'.
   * @see de.jevopi.mitra2.mitra.RelationalExpression#getOp()
   * @see #getRelationalExpression()
   * @generated
   */
  EAttribute getRelationalExpression_Op();

  /**
   * Returns the meta object for the containment reference '{@link de.jevopi.mitra2.mitra.RelationalExpression#getRhs <em>Rhs</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Rhs</em>'.
   * @see de.jevopi.mitra2.mitra.RelationalExpression#getRhs()
   * @see #getRelationalExpression()
   * @generated
   */
  EReference getRelationalExpression_Rhs();

  /**
   * Returns the meta object for class '{@link de.jevopi.mitra2.mitra.MathExpression <em>Math Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Math Expression</em>'.
   * @see de.jevopi.mitra2.mitra.MathExpression
   * @generated
   */
  EClass getMathExpression();

  /**
   * Returns the meta object for the containment reference '{@link de.jevopi.mitra2.mitra.MathExpression#getLhs <em>Lhs</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Lhs</em>'.
   * @see de.jevopi.mitra2.mitra.MathExpression#getLhs()
   * @see #getMathExpression()
   * @generated
   */
  EReference getMathExpression_Lhs();

  /**
   * Returns the meta object for the attribute '{@link de.jevopi.mitra2.mitra.MathExpression#getOp <em>Op</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Op</em>'.
   * @see de.jevopi.mitra2.mitra.MathExpression#getOp()
   * @see #getMathExpression()
   * @generated
   */
  EAttribute getMathExpression_Op();

  /**
   * Returns the meta object for the containment reference '{@link de.jevopi.mitra2.mitra.MathExpression#getRhs <em>Rhs</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Rhs</em>'.
   * @see de.jevopi.mitra2.mitra.MathExpression#getRhs()
   * @see #getMathExpression()
   * @generated
   */
  EReference getMathExpression_Rhs();

  /**
   * Returns the meta object for class '{@link de.jevopi.mitra2.mitra.UnaryCastExpression <em>Unary Cast Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Unary Cast Expression</em>'.
   * @see de.jevopi.mitra2.mitra.UnaryCastExpression
   * @generated
   */
  EClass getUnaryCastExpression();

  /**
   * Returns the meta object for the containment reference '{@link de.jevopi.mitra2.mitra.UnaryCastExpression#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Type</em>'.
   * @see de.jevopi.mitra2.mitra.UnaryCastExpression#getType()
   * @see #getUnaryCastExpression()
   * @generated
   */
  EReference getUnaryCastExpression_Type();

  /**
   * Returns the meta object for the containment reference '{@link de.jevopi.mitra2.mitra.UnaryCastExpression#getExpression <em>Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Expression</em>'.
   * @see de.jevopi.mitra2.mitra.UnaryCastExpression#getExpression()
   * @see #getUnaryCastExpression()
   * @generated
   */
  EReference getUnaryCastExpression_Expression();

  /**
   * Returns the meta object for class '{@link de.jevopi.mitra2.mitra.UnaryBooleanExpression <em>Unary Boolean Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Unary Boolean Expression</em>'.
   * @see de.jevopi.mitra2.mitra.UnaryBooleanExpression
   * @generated
   */
  EClass getUnaryBooleanExpression();

  /**
   * Returns the meta object for the containment reference '{@link de.jevopi.mitra2.mitra.UnaryBooleanExpression#getExpression <em>Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Expression</em>'.
   * @see de.jevopi.mitra2.mitra.UnaryBooleanExpression#getExpression()
   * @see #getUnaryBooleanExpression()
   * @generated
   */
  EReference getUnaryBooleanExpression_Expression();

  /**
   * Returns the meta object for class '{@link de.jevopi.mitra2.mitra.UnaryMathExpression <em>Unary Math Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Unary Math Expression</em>'.
   * @see de.jevopi.mitra2.mitra.UnaryMathExpression
   * @generated
   */
  EClass getUnaryMathExpression();

  /**
   * Returns the meta object for the attribute '{@link de.jevopi.mitra2.mitra.UnaryMathExpression#getOp <em>Op</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Op</em>'.
   * @see de.jevopi.mitra2.mitra.UnaryMathExpression#getOp()
   * @see #getUnaryMathExpression()
   * @generated
   */
  EAttribute getUnaryMathExpression_Op();

  /**
   * Returns the meta object for the containment reference '{@link de.jevopi.mitra2.mitra.UnaryMathExpression#getExpression <em>Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Expression</em>'.
   * @see de.jevopi.mitra2.mitra.UnaryMathExpression#getExpression()
   * @see #getUnaryMathExpression()
   * @generated
   */
  EReference getUnaryMathExpression_Expression();

  /**
   * Returns the meta object for class '{@link de.jevopi.mitra2.mitra.InstanceOfExpression <em>Instance Of Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Instance Of Expression</em>'.
   * @see de.jevopi.mitra2.mitra.InstanceOfExpression
   * @generated
   */
  EClass getInstanceOfExpression();

  /**
   * Returns the meta object for the containment reference '{@link de.jevopi.mitra2.mitra.InstanceOfExpression#getExpression <em>Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Expression</em>'.
   * @see de.jevopi.mitra2.mitra.InstanceOfExpression#getExpression()
   * @see #getInstanceOfExpression()
   * @generated
   */
  EReference getInstanceOfExpression_Expression();

  /**
   * Returns the meta object for the containment reference '{@link de.jevopi.mitra2.mitra.InstanceOfExpression#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Type</em>'.
   * @see de.jevopi.mitra2.mitra.InstanceOfExpression#getType()
   * @see #getInstanceOfExpression()
   * @generated
   */
  EReference getInstanceOfExpression_Type();

  /**
   * Returns the meta object for enum '{@link de.jevopi.mitra2.mitra.VisibilityModifier <em>Visibility Modifier</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Visibility Modifier</em>'.
   * @see de.jevopi.mitra2.mitra.VisibilityModifier
   * @generated
   */
  EEnum getVisibilityModifier();

  /**
   * Returns the meta object for enum '{@link de.jevopi.mitra2.mitra.ExecutionModifier <em>Execution Modifier</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Execution Modifier</em>'.
   * @see de.jevopi.mitra2.mitra.ExecutionModifier
   * @generated
   */
  EEnum getExecutionModifier();

  /**
   * Returns the meta object for enum '{@link de.jevopi.mitra2.mitra.ParameterModifier <em>Parameter Modifier</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Parameter Modifier</em>'.
   * @see de.jevopi.mitra2.mitra.ParameterModifier
   * @generated
   */
  EEnum getParameterModifier();

  /**
   * Returns the meta object for enum '{@link de.jevopi.mitra2.mitra.PrimitiveTypeSpec <em>Primitive Type Spec</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Primitive Type Spec</em>'.
   * @see de.jevopi.mitra2.mitra.PrimitiveTypeSpec
   * @generated
   */
  EEnum getPrimitiveTypeSpec();

  /**
   * Returns the meta object for enum '{@link de.jevopi.mitra2.mitra.CollectionTypeSpec <em>Collection Type Spec</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Collection Type Spec</em>'.
   * @see de.jevopi.mitra2.mitra.CollectionTypeSpec
   * @generated
   */
  EEnum getCollectionTypeSpec();

  /**
   * Returns the meta object for enum '{@link de.jevopi.mitra2.mitra.BooleanOperator <em>Boolean Operator</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Boolean Operator</em>'.
   * @see de.jevopi.mitra2.mitra.BooleanOperator
   * @generated
   */
  EEnum getBooleanOperator();

  /**
   * Returns the meta object for enum '{@link de.jevopi.mitra2.mitra.EqualityOperator <em>Equality Operator</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Equality Operator</em>'.
   * @see de.jevopi.mitra2.mitra.EqualityOperator
   * @generated
   */
  EEnum getEqualityOperator();

  /**
   * Returns the meta object for enum '{@link de.jevopi.mitra2.mitra.RelationalOperator <em>Relational Operator</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Relational Operator</em>'.
   * @see de.jevopi.mitra2.mitra.RelationalOperator
   * @generated
   */
  EEnum getRelationalOperator();

  /**
   * Returns the meta object for enum '{@link de.jevopi.mitra2.mitra.MathOperator <em>Math Operator</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Math Operator</em>'.
   * @see de.jevopi.mitra2.mitra.MathOperator
   * @generated
   */
  EEnum getMathOperator();

  /**
   * Returns the meta object for enum '{@link de.jevopi.mitra2.mitra.UnaryMathOperator <em>Unary Math Operator</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Unary Math Operator</em>'.
   * @see de.jevopi.mitra2.mitra.UnaryMathOperator
   * @generated
   */
  EEnum getUnaryMathOperator();

  /**
   * Returns the meta object for enum '{@link de.jevopi.mitra2.mitra.AssignmentOperator <em>Assignment Operator</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Assignment Operator</em>'.
   * @see de.jevopi.mitra2.mitra.AssignmentOperator
   * @generated
   */
  EEnum getAssignmentOperator();

  /**
   * Returns the meta object for enum '{@link de.jevopi.mitra2.mitra.PPOperator <em>PP Operator</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>PP Operator</em>'.
   * @see de.jevopi.mitra2.mitra.PPOperator
   * @generated
   */
  EEnum getPPOperator();

  /**
   * Returns the meta object for enum '{@link de.jevopi.mitra2.mitra.AnnotationTargetSpec <em>Annotation Target Spec</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Annotation Target Spec</em>'.
   * @see de.jevopi.mitra2.mitra.AnnotationTargetSpec
   * @generated
   */
  EEnum getAnnotationTargetSpec();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  MitraFactory getMitraFactory();

  /**
   * <!-- begin-user-doc -->
   * Defines literals for the meta objects that represent
   * <ul>
   *   <li>each class,</li>
   *   <li>each feature of each class,</li>
   *   <li>each enum,</li>
   *   <li>and each data type</li>
   * </ul>
   * <!-- end-user-doc -->
   * @generated
   */
  interface Literals
  {
    /**
     * The meta object literal for the '{@link de.jevopi.mitra2.mitra.impl.ModuleImpl <em>Module</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.jevopi.mitra2.mitra.impl.ModuleImpl
     * @see de.jevopi.mitra2.mitra.impl.MitraPackageImpl#getModule()
     * @generated
     */
    EClass MODULE = eINSTANCE.getModule();

    /**
     * The meta object literal for the '<em><b>Package Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MODULE__PACKAGE_NAME = eINSTANCE.getModule_PackageName();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MODULE__NAME = eINSTANCE.getModule_Name();

    /**
     * The meta object literal for the '<em><b>Imports</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MODULE__IMPORTS = eINSTANCE.getModule_Imports();

    /**
     * The meta object literal for the '<em><b>Metamodel Declarations</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MODULE__METAMODEL_DECLARATIONS = eINSTANCE.getModule_MetamodelDeclarations();

    /**
     * The meta object literal for the '<em><b>Annotation Definitions</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MODULE__ANNOTATION_DEFINITIONS = eINSTANCE.getModule_AnnotationDefinitions();

    /**
     * The meta object literal for the '<em><b>Rule Declarations</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MODULE__RULE_DECLARATIONS = eINSTANCE.getModule_RuleDeclarations();

    /**
     * The meta object literal for the '{@link de.jevopi.mitra2.mitra.impl.ModuleReferenceImpl <em>Module Reference</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.jevopi.mitra2.mitra.impl.ModuleReferenceImpl
     * @see de.jevopi.mitra2.mitra.impl.MitraPackageImpl#getModuleReference()
     * @generated
     */
    EClass MODULE_REFERENCE = eINSTANCE.getModuleReference();

    /**
     * The meta object literal for the '<em><b>Module</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MODULE_REFERENCE__MODULE = eINSTANCE.getModuleReference_Module();

    /**
     * The meta object literal for the '{@link de.jevopi.mitra2.mitra.impl.MetamodelDeclarationImpl <em>Metamodel Declaration</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.jevopi.mitra2.mitra.impl.MetamodelDeclarationImpl
     * @see de.jevopi.mitra2.mitra.impl.MitraPackageImpl#getMetamodelDeclaration()
     * @generated
     */
    EClass METAMODEL_DECLARATION = eINSTANCE.getMetamodelDeclaration();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute METAMODEL_DECLARATION__TYPE = eINSTANCE.getMetamodelDeclaration_Type();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute METAMODEL_DECLARATION__NAME = eINSTANCE.getMetamodelDeclaration_Name();

    /**
     * The meta object literal for the '<em><b>Properties</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference METAMODEL_DECLARATION__PROPERTIES = eINSTANCE.getMetamodelDeclaration_Properties();

    /**
     * The meta object literal for the '<em><b>Replaces</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute METAMODEL_DECLARATION__REPLACES = eINSTANCE.getMetamodelDeclaration_Replaces();

    /**
     * The meta object literal for the '{@link de.jevopi.mitra2.mitra.impl.PropertyImpl <em>Property</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.jevopi.mitra2.mitra.impl.PropertyImpl
     * @see de.jevopi.mitra2.mitra.impl.MitraPackageImpl#getProperty()
     * @generated
     */
    EClass PROPERTY = eINSTANCE.getProperty();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute PROPERTY__NAME = eINSTANCE.getProperty_Name();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute PROPERTY__VALUE = eINSTANCE.getProperty_Value();

    /**
     * The meta object literal for the '{@link de.jevopi.mitra2.mitra.impl.RuleDeclarationImpl <em>Rule Declaration</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.jevopi.mitra2.mitra.impl.RuleDeclarationImpl
     * @see de.jevopi.mitra2.mitra.impl.MitraPackageImpl#getRuleDeclaration()
     * @generated
     */
    EClass RULE_DECLARATION = eINSTANCE.getRuleDeclaration();

    /**
     * The meta object literal for the '<em><b>Annotations</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference RULE_DECLARATION__ANNOTATIONS = eINSTANCE.getRuleDeclaration_Annotations();

    /**
     * The meta object literal for the '<em><b>Visibility</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute RULE_DECLARATION__VISIBILITY = eINSTANCE.getRuleDeclaration_Visibility();

    /**
     * The meta object literal for the '<em><b>Exec</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute RULE_DECLARATION__EXEC = eINSTANCE.getRuleDeclaration_Exec();

    /**
     * The meta object literal for the '<em><b>Traced</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute RULE_DECLARATION__TRACED = eINSTANCE.getRuleDeclaration_Traced();

    /**
     * The meta object literal for the '<em><b>Stealth</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute RULE_DECLARATION__STEALTH = eINSTANCE.getRuleDeclaration_Stealth();

    /**
     * The meta object literal for the '<em><b>Virtual</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute RULE_DECLARATION__VIRTUAL = eINSTANCE.getRuleDeclaration_Virtual();

    /**
     * The meta object literal for the '<em><b>Multi</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute RULE_DECLARATION__MULTI = eINSTANCE.getRuleDeclaration_Multi();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute RULE_DECLARATION__NAME = eINSTANCE.getRuleDeclaration_Name();

    /**
     * The meta object literal for the '<em><b>Formal Parameters</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference RULE_DECLARATION__FORMAL_PARAMETERS = eINSTANCE.getRuleDeclaration_FormalParameters();

    /**
     * The meta object literal for the '<em><b>Return Parameters</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference RULE_DECLARATION__RETURN_PARAMETERS = eINSTANCE.getRuleDeclaration_ReturnParameters();

    /**
     * The meta object literal for the '<em><b>Implemented Rules</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference RULE_DECLARATION__IMPLEMENTED_RULES = eINSTANCE.getRuleDeclaration_ImplementedRules();

    /**
     * The meta object literal for the '<em><b>Overridden Rule</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference RULE_DECLARATION__OVERRIDDEN_RULE = eINSTANCE.getRuleDeclaration_OverriddenRule();

    /**
     * The meta object literal for the '<em><b>Excluding Rules</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference RULE_DECLARATION__EXCLUDING_RULES = eINSTANCE.getRuleDeclaration_ExcludingRules();

    /**
     * The meta object literal for the '<em><b>Trigger</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference RULE_DECLARATION__TRIGGER = eINSTANCE.getRuleDeclaration_Trigger();

    /**
     * The meta object literal for the '<em><b>Java Spec</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference RULE_DECLARATION__JAVA_SPEC = eINSTANCE.getRuleDeclaration_JavaSpec();

    /**
     * The meta object literal for the '<em><b>Body</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference RULE_DECLARATION__BODY = eINSTANCE.getRuleDeclaration_Body();

    /**
     * The meta object literal for the '{@link de.jevopi.mitra2.mitra.impl.RuleReferenceImpl <em>Rule Reference</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.jevopi.mitra2.mitra.impl.RuleReferenceImpl
     * @see de.jevopi.mitra2.mitra.impl.MitraPackageImpl#getRuleReference()
     * @generated
     */
    EClass RULE_REFERENCE = eINSTANCE.getRuleReference();

    /**
     * The meta object literal for the '<em><b>Rule Declaration</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference RULE_REFERENCE__RULE_DECLARATION = eINSTANCE.getRuleReference_RuleDeclaration();

    /**
     * The meta object literal for the '{@link de.jevopi.mitra2.mitra.impl.SimpleRuleReferenceImpl <em>Simple Rule Reference</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.jevopi.mitra2.mitra.impl.SimpleRuleReferenceImpl
     * @see de.jevopi.mitra2.mitra.impl.MitraPackageImpl#getSimpleRuleReference()
     * @generated
     */
    EClass SIMPLE_RULE_REFERENCE = eINSTANCE.getSimpleRuleReference();

    /**
     * The meta object literal for the '<em><b>Parameter References</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SIMPLE_RULE_REFERENCE__PARAMETER_REFERENCES = eINSTANCE.getSimpleRuleReference_ParameterReferences();

    /**
     * The meta object literal for the '<em><b>Return References</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SIMPLE_RULE_REFERENCE__RETURN_REFERENCES = eINSTANCE.getSimpleRuleReference_ReturnReferences();

    /**
     * The meta object literal for the '{@link de.jevopi.mitra2.mitra.impl.QualifiedRuleReferenceImpl <em>Qualified Rule Reference</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.jevopi.mitra2.mitra.impl.QualifiedRuleReferenceImpl
     * @see de.jevopi.mitra2.mitra.impl.MitraPackageImpl#getQualifiedRuleReference()
     * @generated
     */
    EClass QUALIFIED_RULE_REFERENCE = eINSTANCE.getQualifiedRuleReference();

    /**
     * The meta object literal for the '<em><b>Parameter References</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference QUALIFIED_RULE_REFERENCE__PARAMETER_REFERENCES = eINSTANCE.getQualifiedRuleReference_ParameterReferences();

    /**
     * The meta object literal for the '<em><b>Return References</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference QUALIFIED_RULE_REFERENCE__RETURN_REFERENCES = eINSTANCE.getQualifiedRuleReference_ReturnReferences();

    /**
     * The meta object literal for the '{@link de.jevopi.mitra2.mitra.impl.ParameterReferenceImpl <em>Parameter Reference</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.jevopi.mitra2.mitra.impl.ParameterReferenceImpl
     * @see de.jevopi.mitra2.mitra.impl.MitraPackageImpl#getParameterReference()
     * @generated
     */
    EClass PARAMETER_REFERENCE = eINSTANCE.getParameterReference();

    /**
     * The meta object literal for the '{@link de.jevopi.mitra2.mitra.impl.SimpleParameterReferenceImpl <em>Simple Parameter Reference</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.jevopi.mitra2.mitra.impl.SimpleParameterReferenceImpl
     * @see de.jevopi.mitra2.mitra.impl.MitraPackageImpl#getSimpleParameterReference()
     * @generated
     */
    EClass SIMPLE_PARAMETER_REFERENCE = eINSTANCE.getSimpleParameterReference();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SIMPLE_PARAMETER_REFERENCE__TYPE = eINSTANCE.getSimpleParameterReference_Type();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute SIMPLE_PARAMETER_REFERENCE__NAME = eINSTANCE.getSimpleParameterReference_Name();

    /**
     * The meta object literal for the '{@link de.jevopi.mitra2.mitra.impl.QualifiedParameterReferenceImpl <em>Qualified Parameter Reference</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.jevopi.mitra2.mitra.impl.QualifiedParameterReferenceImpl
     * @see de.jevopi.mitra2.mitra.impl.MitraPackageImpl#getQualifiedParameterReference()
     * @generated
     */
    EClass QUALIFIED_PARAMETER_REFERENCE = eINSTANCE.getQualifiedParameterReference();

    /**
     * The meta object literal for the '<em><b>Vardecl</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference QUALIFIED_PARAMETER_REFERENCE__VARDECL = eINSTANCE.getQualifiedParameterReference_Vardecl();

    /**
     * The meta object literal for the '{@link de.jevopi.mitra2.mitra.impl.TriggerImpl <em>Trigger</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.jevopi.mitra2.mitra.impl.TriggerImpl
     * @see de.jevopi.mitra2.mitra.impl.MitraPackageImpl#getTrigger()
     * @generated
     */
    EClass TRIGGER = eINSTANCE.getTrigger();

    /**
     * The meta object literal for the '<em><b>Trigger Rules</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TRIGGER__TRIGGER_RULES = eINSTANCE.getTrigger_TriggerRules();

    /**
     * The meta object literal for the '<em><b>With</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TRIGGER__WITH = eINSTANCE.getTrigger_With();

    /**
     * The meta object literal for the '<em><b>When</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TRIGGER__WHEN = eINSTANCE.getTrigger_When();

    /**
     * The meta object literal for the '{@link de.jevopi.mitra2.mitra.impl.JavaSpecImpl <em>Java Spec</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.jevopi.mitra2.mitra.impl.JavaSpecImpl
     * @see de.jevopi.mitra2.mitra.impl.MitraPackageImpl#getJavaSpec()
     * @generated
     */
    EClass JAVA_SPEC = eINSTANCE.getJavaSpec();

    /**
     * The meta object literal for the '<em><b>Properties</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference JAVA_SPEC__PROPERTIES = eINSTANCE.getJavaSpec_Properties();

    /**
     * The meta object literal for the '{@link de.jevopi.mitra2.mitra.impl.ParameterImpl <em>Parameter</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.jevopi.mitra2.mitra.impl.ParameterImpl
     * @see de.jevopi.mitra2.mitra.impl.MitraPackageImpl#getParameter()
     * @generated
     */
    EClass PARAMETER = eINSTANCE.getParameter();

    /**
     * The meta object literal for the '<em><b>Annotations</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PARAMETER__ANNOTATIONS = eINSTANCE.getParameter_Annotations();

    /**
     * The meta object literal for the '<em><b>Modifier</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute PARAMETER__MODIFIER = eINSTANCE.getParameter_Modifier();

    /**
     * The meta object literal for the '<em><b>Vardecl</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PARAMETER__VARDECL = eINSTANCE.getParameter_Vardecl();

    /**
     * The meta object literal for the '{@link de.jevopi.mitra2.mitra.impl.FormalParameterImpl <em>Formal Parameter</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.jevopi.mitra2.mitra.impl.FormalParameterImpl
     * @see de.jevopi.mitra2.mitra.impl.MitraPackageImpl#getFormalParameter()
     * @generated
     */
    EClass FORMAL_PARAMETER = eINSTANCE.getFormalParameter();

    /**
     * The meta object literal for the '{@link de.jevopi.mitra2.mitra.impl.ReturnParameterImpl <em>Return Parameter</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.jevopi.mitra2.mitra.impl.ReturnParameterImpl
     * @see de.jevopi.mitra2.mitra.impl.MitraPackageImpl#getReturnParameter()
     * @generated
     */
    EClass RETURN_PARAMETER = eINSTANCE.getReturnParameter();

    /**
     * The meta object literal for the '{@link de.jevopi.mitra2.mitra.impl.TypeImpl <em>Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.jevopi.mitra2.mitra.impl.TypeImpl
     * @see de.jevopi.mitra2.mitra.impl.MitraPackageImpl#getType()
     * @generated
     */
    EClass TYPE = eINSTANCE.getType();

    /**
     * The meta object literal for the '{@link de.jevopi.mitra2.mitra.impl.ReferenceTypeImpl <em>Reference Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.jevopi.mitra2.mitra.impl.ReferenceTypeImpl
     * @see de.jevopi.mitra2.mitra.impl.MitraPackageImpl#getReferenceType()
     * @generated
     */
    EClass REFERENCE_TYPE = eINSTANCE.getReferenceType();

    /**
     * The meta object literal for the '<em><b>Metamodel Declaration</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference REFERENCE_TYPE__METAMODEL_DECLARATION = eINSTANCE.getReferenceType_MetamodelDeclaration();

    /**
     * The meta object literal for the '<em><b>EClassifier</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference REFERENCE_TYPE__ECLASSIFIER = eINSTANCE.getReferenceType_EClassifier();

    /**
     * The meta object literal for the '{@link de.jevopi.mitra2.mitra.impl.PrimitiveTypeImpl <em>Primitive Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.jevopi.mitra2.mitra.impl.PrimitiveTypeImpl
     * @see de.jevopi.mitra2.mitra.impl.MitraPackageImpl#getPrimitiveType()
     * @generated
     */
    EClass PRIMITIVE_TYPE = eINSTANCE.getPrimitiveType();

    /**
     * The meta object literal for the '<em><b>Primitive Type</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute PRIMITIVE_TYPE__PRIMITIVE_TYPE = eINSTANCE.getPrimitiveType_PrimitiveType();

    /**
     * The meta object literal for the '{@link de.jevopi.mitra2.mitra.impl.CollectionTypeImpl <em>Collection Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.jevopi.mitra2.mitra.impl.CollectionTypeImpl
     * @see de.jevopi.mitra2.mitra.impl.MitraPackageImpl#getCollectionType()
     * @generated
     */
    EClass COLLECTION_TYPE = eINSTANCE.getCollectionType();

    /**
     * The meta object literal for the '<em><b>Collection Type</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute COLLECTION_TYPE__COLLECTION_TYPE = eINSTANCE.getCollectionType_CollectionType();

    /**
     * The meta object literal for the '<em><b>Type Par</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference COLLECTION_TYPE__TYPE_PAR = eINSTANCE.getCollectionType_TypePar();

    /**
     * The meta object literal for the '{@link de.jevopi.mitra2.mitra.impl.BlockImpl <em>Block</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.jevopi.mitra2.mitra.impl.BlockImpl
     * @see de.jevopi.mitra2.mitra.impl.MitraPackageImpl#getBlock()
     * @generated
     */
    EClass BLOCK = eINSTANCE.getBlock();

    /**
     * The meta object literal for the '<em><b>Statements</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference BLOCK__STATEMENTS = eINSTANCE.getBlock_Statements();

    /**
     * The meta object literal for the '{@link de.jevopi.mitra2.mitra.impl.BlockStatementImpl <em>Block Statement</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.jevopi.mitra2.mitra.impl.BlockStatementImpl
     * @see de.jevopi.mitra2.mitra.impl.MitraPackageImpl#getBlockStatement()
     * @generated
     */
    EClass BLOCK_STATEMENT = eINSTANCE.getBlockStatement();

    /**
     * The meta object literal for the '{@link de.jevopi.mitra2.mitra.impl.StatementImpl <em>Statement</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.jevopi.mitra2.mitra.impl.StatementImpl
     * @see de.jevopi.mitra2.mitra.impl.MitraPackageImpl#getStatement()
     * @generated
     */
    EClass STATEMENT = eINSTANCE.getStatement();

    /**
     * The meta object literal for the '{@link de.jevopi.mitra2.mitra.impl.LocalVariableDeclarationStatementImpl <em>Local Variable Declaration Statement</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.jevopi.mitra2.mitra.impl.LocalVariableDeclarationStatementImpl
     * @see de.jevopi.mitra2.mitra.impl.MitraPackageImpl#getLocalVariableDeclarationStatement()
     * @generated
     */
    EClass LOCAL_VARIABLE_DECLARATION_STATEMENT = eINSTANCE.getLocalVariableDeclarationStatement();

    /**
     * The meta object literal for the '<em><b>Local Variable Declaration</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference LOCAL_VARIABLE_DECLARATION_STATEMENT__LOCAL_VARIABLE_DECLARATION = eINSTANCE.getLocalVariableDeclarationStatement_LocalVariableDeclaration();

    /**
     * The meta object literal for the '{@link de.jevopi.mitra2.mitra.impl.LocalVariableDeclarationImpl <em>Local Variable Declaration</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.jevopi.mitra2.mitra.impl.LocalVariableDeclarationImpl
     * @see de.jevopi.mitra2.mitra.impl.MitraPackageImpl#getLocalVariableDeclaration()
     * @generated
     */
    EClass LOCAL_VARIABLE_DECLARATION = eINSTANCE.getLocalVariableDeclaration();

    /**
     * The meta object literal for the '<em><b>Vardecl</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference LOCAL_VARIABLE_DECLARATION__VARDECL = eINSTANCE.getLocalVariableDeclaration_Vardecl();

    /**
     * The meta object literal for the '<em><b>Expression</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference LOCAL_VARIABLE_DECLARATION__EXPRESSION = eINSTANCE.getLocalVariableDeclaration_Expression();

    /**
     * The meta object literal for the '{@link de.jevopi.mitra2.mitra.impl.VarDeclarationImpl <em>Var Declaration</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.jevopi.mitra2.mitra.impl.VarDeclarationImpl
     * @see de.jevopi.mitra2.mitra.impl.MitraPackageImpl#getVarDeclaration()
     * @generated
     */
    EClass VAR_DECLARATION = eINSTANCE.getVarDeclaration();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference VAR_DECLARATION__TYPE = eINSTANCE.getVarDeclaration_Type();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute VAR_DECLARATION__NAME = eINSTANCE.getVarDeclaration_Name();

    /**
     * The meta object literal for the '{@link de.jevopi.mitra2.mitra.impl.TypedVarDeclarationImpl <em>Typed Var Declaration</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.jevopi.mitra2.mitra.impl.TypedVarDeclarationImpl
     * @see de.jevopi.mitra2.mitra.impl.MitraPackageImpl#getTypedVarDeclaration()
     * @generated
     */
    EClass TYPED_VAR_DECLARATION = eINSTANCE.getTypedVarDeclaration();

    /**
     * The meta object literal for the '{@link de.jevopi.mitra2.mitra.impl.InferredVarDeclarationImpl <em>Inferred Var Declaration</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.jevopi.mitra2.mitra.impl.InferredVarDeclarationImpl
     * @see de.jevopi.mitra2.mitra.impl.MitraPackageImpl#getInferredVarDeclaration()
     * @generated
     */
    EClass INFERRED_VAR_DECLARATION = eINSTANCE.getInferredVarDeclaration();

    /**
     * The meta object literal for the '{@link de.jevopi.mitra2.mitra.impl.ExpressionStatementImpl <em>Expression Statement</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.jevopi.mitra2.mitra.impl.ExpressionStatementImpl
     * @see de.jevopi.mitra2.mitra.impl.MitraPackageImpl#getExpressionStatement()
     * @generated
     */
    EClass EXPRESSION_STATEMENT = eINSTANCE.getExpressionStatement();

    /**
     * The meta object literal for the '<em><b>Statement Expression</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference EXPRESSION_STATEMENT__STATEMENT_EXPRESSION = eINSTANCE.getExpressionStatement_StatementExpression();

    /**
     * The meta object literal for the '{@link de.jevopi.mitra2.mitra.impl.StatementExpressionImpl <em>Statement Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.jevopi.mitra2.mitra.impl.StatementExpressionImpl
     * @see de.jevopi.mitra2.mitra.impl.MitraPackageImpl#getStatementExpression()
     * @generated
     */
    EClass STATEMENT_EXPRESSION = eINSTANCE.getStatementExpression();

    /**
     * The meta object literal for the '{@link de.jevopi.mitra2.mitra.impl.EmptyStatementImpl <em>Empty Statement</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.jevopi.mitra2.mitra.impl.EmptyStatementImpl
     * @see de.jevopi.mitra2.mitra.impl.MitraPackageImpl#getEmptyStatement()
     * @generated
     */
    EClass EMPTY_STATEMENT = eINSTANCE.getEmptyStatement();

    /**
     * The meta object literal for the '{@link de.jevopi.mitra2.mitra.impl.ReturnStatementImpl <em>Return Statement</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.jevopi.mitra2.mitra.impl.ReturnStatementImpl
     * @see de.jevopi.mitra2.mitra.impl.MitraPackageImpl#getReturnStatement()
     * @generated
     */
    EClass RETURN_STATEMENT = eINSTANCE.getReturnStatement();

    /**
     * The meta object literal for the '<em><b>Expression</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference RETURN_STATEMENT__EXPRESSION = eINSTANCE.getReturnStatement_Expression();

    /**
     * The meta object literal for the '{@link de.jevopi.mitra2.mitra.impl.IfStatementImpl <em>If Statement</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.jevopi.mitra2.mitra.impl.IfStatementImpl
     * @see de.jevopi.mitra2.mitra.impl.MitraPackageImpl#getIfStatement()
     * @generated
     */
    EClass IF_STATEMENT = eINSTANCE.getIfStatement();

    /**
     * The meta object literal for the '<em><b>Expression</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference IF_STATEMENT__EXPRESSION = eINSTANCE.getIfStatement_Expression();

    /**
     * The meta object literal for the '<em><b>True Statement</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference IF_STATEMENT__TRUE_STATEMENT = eINSTANCE.getIfStatement_TrueStatement();

    /**
     * The meta object literal for the '<em><b>Else Statement</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference IF_STATEMENT__ELSE_STATEMENT = eINSTANCE.getIfStatement_ElseStatement();

    /**
     * The meta object literal for the '{@link de.jevopi.mitra2.mitra.impl.WhileStatementImpl <em>While Statement</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.jevopi.mitra2.mitra.impl.WhileStatementImpl
     * @see de.jevopi.mitra2.mitra.impl.MitraPackageImpl#getWhileStatement()
     * @generated
     */
    EClass WHILE_STATEMENT = eINSTANCE.getWhileStatement();

    /**
     * The meta object literal for the '<em><b>Expression</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference WHILE_STATEMENT__EXPRESSION = eINSTANCE.getWhileStatement_Expression();

    /**
     * The meta object literal for the '<em><b>Statement</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference WHILE_STATEMENT__STATEMENT = eINSTANCE.getWhileStatement_Statement();

    /**
     * The meta object literal for the '{@link de.jevopi.mitra2.mitra.impl.DoStatementImpl <em>Do Statement</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.jevopi.mitra2.mitra.impl.DoStatementImpl
     * @see de.jevopi.mitra2.mitra.impl.MitraPackageImpl#getDoStatement()
     * @generated
     */
    EClass DO_STATEMENT = eINSTANCE.getDoStatement();

    /**
     * The meta object literal for the '<em><b>Statement</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference DO_STATEMENT__STATEMENT = eINSTANCE.getDoStatement_Statement();

    /**
     * The meta object literal for the '<em><b>Expression</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference DO_STATEMENT__EXPRESSION = eINSTANCE.getDoStatement_Expression();

    /**
     * The meta object literal for the '{@link de.jevopi.mitra2.mitra.impl.ForInitImpl <em>For Init</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.jevopi.mitra2.mitra.impl.ForInitImpl
     * @see de.jevopi.mitra2.mitra.impl.MitraPackageImpl#getForInit()
     * @generated
     */
    EClass FOR_INIT = eINSTANCE.getForInit();

    /**
     * The meta object literal for the '<em><b>Statement Expressions</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FOR_INIT__STATEMENT_EXPRESSIONS = eINSTANCE.getForInit_StatementExpressions();

    /**
     * The meta object literal for the '<em><b>Var Declarations</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FOR_INIT__VAR_DECLARATIONS = eINSTANCE.getForInit_VarDeclarations();

    /**
     * The meta object literal for the '{@link de.jevopi.mitra2.mitra.impl.ForUpdateImpl <em>For Update</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.jevopi.mitra2.mitra.impl.ForUpdateImpl
     * @see de.jevopi.mitra2.mitra.impl.MitraPackageImpl#getForUpdate()
     * @generated
     */
    EClass FOR_UPDATE = eINSTANCE.getForUpdate();

    /**
     * The meta object literal for the '<em><b>Statement Expression</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FOR_UPDATE__STATEMENT_EXPRESSION = eINSTANCE.getForUpdate_StatementExpression();

    /**
     * The meta object literal for the '{@link de.jevopi.mitra2.mitra.impl.ForStatementImpl <em>For Statement</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.jevopi.mitra2.mitra.impl.ForStatementImpl
     * @see de.jevopi.mitra2.mitra.impl.MitraPackageImpl#getForStatement()
     * @generated
     */
    EClass FOR_STATEMENT = eINSTANCE.getForStatement();

    /**
     * The meta object literal for the '<em><b>Loop Variable</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FOR_STATEMENT__LOOP_VARIABLE = eINSTANCE.getForStatement_LoopVariable();

    /**
     * The meta object literal for the '<em><b>Expression</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FOR_STATEMENT__EXPRESSION = eINSTANCE.getForStatement_Expression();

    /**
     * The meta object literal for the '<em><b>For Init</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FOR_STATEMENT__FOR_INIT = eINSTANCE.getForStatement_ForInit();

    /**
     * The meta object literal for the '<em><b>For Update</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FOR_STATEMENT__FOR_UPDATE = eINSTANCE.getForStatement_ForUpdate();

    /**
     * The meta object literal for the '<em><b>Statement</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FOR_STATEMENT__STATEMENT = eINSTANCE.getForStatement_Statement();

    /**
     * The meta object literal for the '{@link de.jevopi.mitra2.mitra.impl.LoopVariableImpl <em>Loop Variable</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.jevopi.mitra2.mitra.impl.LoopVariableImpl
     * @see de.jevopi.mitra2.mitra.impl.MitraPackageImpl#getLoopVariable()
     * @generated
     */
    EClass LOOP_VARIABLE = eINSTANCE.getLoopVariable();

    /**
     * The meta object literal for the '<em><b>Vardecl</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference LOOP_VARIABLE__VARDECL = eINSTANCE.getLoopVariable_Vardecl();

    /**
     * The meta object literal for the '{@link de.jevopi.mitra2.mitra.impl.BreakStatementImpl <em>Break Statement</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.jevopi.mitra2.mitra.impl.BreakStatementImpl
     * @see de.jevopi.mitra2.mitra.impl.MitraPackageImpl#getBreakStatement()
     * @generated
     */
    EClass BREAK_STATEMENT = eINSTANCE.getBreakStatement();

    /**
     * The meta object literal for the '{@link de.jevopi.mitra2.mitra.impl.ThrowStatementImpl <em>Throw Statement</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.jevopi.mitra2.mitra.impl.ThrowStatementImpl
     * @see de.jevopi.mitra2.mitra.impl.MitraPackageImpl#getThrowStatement()
     * @generated
     */
    EClass THROW_STATEMENT = eINSTANCE.getThrowStatement();

    /**
     * The meta object literal for the '<em><b>Expression</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference THROW_STATEMENT__EXPRESSION = eINSTANCE.getThrowStatement_Expression();

    /**
     * The meta object literal for the '{@link de.jevopi.mitra2.mitra.impl.TryStatementImpl <em>Try Statement</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.jevopi.mitra2.mitra.impl.TryStatementImpl
     * @see de.jevopi.mitra2.mitra.impl.MitraPackageImpl#getTryStatement()
     * @generated
     */
    EClass TRY_STATEMENT = eINSTANCE.getTryStatement();

    /**
     * The meta object literal for the '<em><b>Try Block</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TRY_STATEMENT__TRY_BLOCK = eINSTANCE.getTryStatement_TryBlock();

    /**
     * The meta object literal for the '<em><b>Catches</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TRY_STATEMENT__CATCHES = eINSTANCE.getTryStatement_Catches();

    /**
     * The meta object literal for the '<em><b>Finally Block</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TRY_STATEMENT__FINALLY_BLOCK = eINSTANCE.getTryStatement_FinallyBlock();

    /**
     * The meta object literal for the '{@link de.jevopi.mitra2.mitra.impl.CatchImpl <em>Catch</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.jevopi.mitra2.mitra.impl.CatchImpl
     * @see de.jevopi.mitra2.mitra.impl.MitraPackageImpl#getCatch()
     * @generated
     */
    EClass CATCH = eINSTANCE.getCatch();

    /**
     * The meta object literal for the '<em><b>Formal Parameter</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CATCH__FORMAL_PARAMETER = eINSTANCE.getCatch_FormalParameter();

    /**
     * The meta object literal for the '<em><b>Block</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CATCH__BLOCK = eINSTANCE.getCatch_Block();

    /**
     * The meta object literal for the '{@link de.jevopi.mitra2.mitra.impl.ExpressionImpl <em>Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.jevopi.mitra2.mitra.impl.ExpressionImpl
     * @see de.jevopi.mitra2.mitra.impl.MitraPackageImpl#getExpression()
     * @generated
     */
    EClass EXPRESSION = eINSTANCE.getExpression();

    /**
     * The meta object literal for the '{@link de.jevopi.mitra2.mitra.impl.TerminalExpressionImpl <em>Terminal Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.jevopi.mitra2.mitra.impl.TerminalExpressionImpl
     * @see de.jevopi.mitra2.mitra.impl.MitraPackageImpl#getTerminalExpression()
     * @generated
     */
    EClass TERMINAL_EXPRESSION = eINSTANCE.getTerminalExpression();

    /**
     * The meta object literal for the '{@link de.jevopi.mitra2.mitra.impl.LiteralImpl <em>Literal</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.jevopi.mitra2.mitra.impl.LiteralImpl
     * @see de.jevopi.mitra2.mitra.impl.MitraPackageImpl#getLiteral()
     * @generated
     */
    EClass LITERAL = eINSTANCE.getLiteral();

    /**
     * The meta object literal for the '{@link de.jevopi.mitra2.mitra.impl.StringLiteralImpl <em>String Literal</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.jevopi.mitra2.mitra.impl.StringLiteralImpl
     * @see de.jevopi.mitra2.mitra.impl.MitraPackageImpl#getStringLiteral()
     * @generated
     */
    EClass STRING_LITERAL = eINSTANCE.getStringLiteral();

    /**
     * The meta object literal for the '<em><b>String Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute STRING_LITERAL__STRING_VALUE = eINSTANCE.getStringLiteral_StringValue();

    /**
     * The meta object literal for the '{@link de.jevopi.mitra2.mitra.impl.IntLiteralImpl <em>Int Literal</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.jevopi.mitra2.mitra.impl.IntLiteralImpl
     * @see de.jevopi.mitra2.mitra.impl.MitraPackageImpl#getIntLiteral()
     * @generated
     */
    EClass INT_LITERAL = eINSTANCE.getIntLiteral();

    /**
     * The meta object literal for the '<em><b>Int Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute INT_LITERAL__INT_VALUE = eINSTANCE.getIntLiteral_IntValue();

    /**
     * The meta object literal for the '{@link de.jevopi.mitra2.mitra.impl.RealLiteralImpl <em>Real Literal</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.jevopi.mitra2.mitra.impl.RealLiteralImpl
     * @see de.jevopi.mitra2.mitra.impl.MitraPackageImpl#getRealLiteral()
     * @generated
     */
    EClass REAL_LITERAL = eINSTANCE.getRealLiteral();

    /**
     * The meta object literal for the '<em><b>Float Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute REAL_LITERAL__FLOAT_VALUE = eINSTANCE.getRealLiteral_FloatValue();

    /**
     * The meta object literal for the '{@link de.jevopi.mitra2.mitra.impl.BooleanLiteralImpl <em>Boolean Literal</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.jevopi.mitra2.mitra.impl.BooleanLiteralImpl
     * @see de.jevopi.mitra2.mitra.impl.MitraPackageImpl#getBooleanLiteral()
     * @generated
     */
    EClass BOOLEAN_LITERAL = eINSTANCE.getBooleanLiteral();

    /**
     * The meta object literal for the '<em><b>Boolean Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute BOOLEAN_LITERAL__BOOLEAN_VALUE = eINSTANCE.getBooleanLiteral_BooleanValue();

    /**
     * The meta object literal for the '{@link de.jevopi.mitra2.mitra.impl.NullLiteralImpl <em>Null Literal</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.jevopi.mitra2.mitra.impl.NullLiteralImpl
     * @see de.jevopi.mitra2.mitra.impl.MitraPackageImpl#getNullLiteral()
     * @generated
     */
    EClass NULL_LITERAL = eINSTANCE.getNullLiteral();

    /**
     * The meta object literal for the '{@link de.jevopi.mitra2.mitra.impl.ClassInstanceCreationExpressionImpl <em>Class Instance Creation Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.jevopi.mitra2.mitra.impl.ClassInstanceCreationExpressionImpl
     * @see de.jevopi.mitra2.mitra.impl.MitraPackageImpl#getClassInstanceCreationExpression()
     * @generated
     */
    EClass CLASS_INSTANCE_CREATION_EXPRESSION = eINSTANCE.getClassInstanceCreationExpression();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CLASS_INSTANCE_CREATION_EXPRESSION__TYPE = eINSTANCE.getClassInstanceCreationExpression_Type();

    /**
     * The meta object literal for the '<em><b>Arguments</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CLASS_INSTANCE_CREATION_EXPRESSION__ARGUMENTS = eINSTANCE.getClassInstanceCreationExpression_Arguments();

    /**
     * The meta object literal for the '{@link de.jevopi.mitra2.mitra.impl.RuleInvocationImpl <em>Rule Invocation</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.jevopi.mitra2.mitra.impl.RuleInvocationImpl
     * @see de.jevopi.mitra2.mitra.impl.MitraPackageImpl#getRuleInvocation()
     * @generated
     */
    EClass RULE_INVOCATION = eINSTANCE.getRuleInvocation();

    /**
     * The meta object literal for the '<em><b>Rule Declaration</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference RULE_INVOCATION__RULE_DECLARATION = eINSTANCE.getRuleInvocation_RuleDeclaration();

    /**
     * The meta object literal for the '<em><b>Arguments</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference RULE_INVOCATION__ARGUMENTS = eINSTANCE.getRuleInvocation_Arguments();

    /**
     * The meta object literal for the '{@link de.jevopi.mitra2.mitra.impl.RuleInvocationSuperImpl <em>Rule Invocation Super</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.jevopi.mitra2.mitra.impl.RuleInvocationSuperImpl
     * @see de.jevopi.mitra2.mitra.impl.MitraPackageImpl#getRuleInvocationSuper()
     * @generated
     */
    EClass RULE_INVOCATION_SUPER = eINSTANCE.getRuleInvocationSuper();

    /**
     * The meta object literal for the '{@link de.jevopi.mitra2.mitra.impl.FeatureImpl <em>Feature</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.jevopi.mitra2.mitra.impl.FeatureImpl
     * @see de.jevopi.mitra2.mitra.impl.MitraPackageImpl#getFeature()
     * @generated
     */
    EClass FEATURE = eINSTANCE.getFeature();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute FEATURE__NAME = eINSTANCE.getFeature_Name();

    /**
     * The meta object literal for the '{@link de.jevopi.mitra2.mitra.impl.MethodInvocationImpl <em>Method Invocation</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.jevopi.mitra2.mitra.impl.MethodInvocationImpl
     * @see de.jevopi.mitra2.mitra.impl.MitraPackageImpl#getMethodInvocation()
     * @generated
     */
    EClass METHOD_INVOCATION = eINSTANCE.getMethodInvocation();

    /**
     * The meta object literal for the '<em><b>Arguments</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference METHOD_INVOCATION__ARGUMENTS = eINSTANCE.getMethodInvocation_Arguments();

    /**
     * The meta object literal for the '{@link de.jevopi.mitra2.mitra.impl.FeatureMethodInvocationImpl <em>Feature Method Invocation</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.jevopi.mitra2.mitra.impl.FeatureMethodInvocationImpl
     * @see de.jevopi.mitra2.mitra.impl.MitraPackageImpl#getFeatureMethodInvocation()
     * @generated
     */
    EClass FEATURE_METHOD_INVOCATION = eINSTANCE.getFeatureMethodInvocation();

    /**
     * The meta object literal for the '<em><b>Expression</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FEATURE_METHOD_INVOCATION__EXPRESSION = eINSTANCE.getFeatureMethodInvocation_Expression();

    /**
     * The meta object literal for the '{@link de.jevopi.mitra2.mitra.impl.NativeOperationInvocationImpl <em>Native Operation Invocation</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.jevopi.mitra2.mitra.impl.NativeOperationInvocationImpl
     * @see de.jevopi.mitra2.mitra.impl.MitraPackageImpl#getNativeOperationInvocation()
     * @generated
     */
    EClass NATIVE_OPERATION_INVOCATION = eINSTANCE.getNativeOperationInvocation();

    /**
     * The meta object literal for the '{@link de.jevopi.mitra2.mitra.impl.MetamodelFeatureImpl <em>Metamodel Feature</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.jevopi.mitra2.mitra.impl.MetamodelFeatureImpl
     * @see de.jevopi.mitra2.mitra.impl.MitraPackageImpl#getMetamodelFeature()
     * @generated
     */
    EClass METAMODEL_FEATURE = eINSTANCE.getMetamodelFeature();

    /**
     * The meta object literal for the '{@link de.jevopi.mitra2.mitra.impl.FeatureFieldImpl <em>Feature Field</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.jevopi.mitra2.mitra.impl.FeatureFieldImpl
     * @see de.jevopi.mitra2.mitra.impl.MitraPackageImpl#getFeatureField()
     * @generated
     */
    EClass FEATURE_FIELD = eINSTANCE.getFeatureField();

    /**
     * The meta object literal for the '<em><b>Expression</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FEATURE_FIELD__EXPRESSION = eINSTANCE.getFeatureField_Expression();

    /**
     * The meta object literal for the '{@link de.jevopi.mitra2.mitra.impl.VariableAccessImpl <em>Variable Access</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.jevopi.mitra2.mitra.impl.VariableAccessImpl
     * @see de.jevopi.mitra2.mitra.impl.MitraPackageImpl#getVariableAccess()
     * @generated
     */
    EClass VARIABLE_ACCESS = eINSTANCE.getVariableAccess();

    /**
     * The meta object literal for the '<em><b>Prefix Operator</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute VARIABLE_ACCESS__PREFIX_OPERATOR = eINSTANCE.getVariableAccess_PrefixOperator();

    /**
     * The meta object literal for the '<em><b>Variable</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference VARIABLE_ACCESS__VARIABLE = eINSTANCE.getVariableAccess_Variable();

    /**
     * The meta object literal for the '<em><b>Features</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference VARIABLE_ACCESS__FEATURES = eINSTANCE.getVariableAccess_Features();

    /**
     * The meta object literal for the '<em><b>Default</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference VARIABLE_ACCESS__DEFAULT = eINSTANCE.getVariableAccess_Default();

    /**
     * The meta object literal for the '<em><b>Postfix Operator</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute VARIABLE_ACCESS__POSTFIX_OPERATOR = eINSTANCE.getVariableAccess_PostfixOperator();

    /**
     * The meta object literal for the '{@link de.jevopi.mitra2.mitra.impl.StaticAccessImpl <em>Static Access</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.jevopi.mitra2.mitra.impl.StaticAccessImpl
     * @see de.jevopi.mitra2.mitra.impl.MitraPackageImpl#getStaticAccess()
     * @generated
     */
    EClass STATIC_ACCESS = eINSTANCE.getStaticAccess();

    /**
     * The meta object literal for the '<em><b>Expression</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference STATIC_ACCESS__EXPRESSION = eINSTANCE.getStaticAccess_Expression();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference STATIC_ACCESS__TYPE = eINSTANCE.getStaticAccess_Type();

    /**
     * The meta object literal for the '<em><b>Features</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference STATIC_ACCESS__FEATURES = eINSTANCE.getStaticAccess_Features();

    /**
     * The meta object literal for the '{@link de.jevopi.mitra2.mitra.impl.AnnotationsDefinitionImpl <em>Annotations Definition</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.jevopi.mitra2.mitra.impl.AnnotationsDefinitionImpl
     * @see de.jevopi.mitra2.mitra.impl.MitraPackageImpl#getAnnotationsDefinition()
     * @generated
     */
    EClass ANNOTATIONS_DEFINITION = eINSTANCE.getAnnotationsDefinition();

    /**
     * The meta object literal for the '<em><b>Annotation Decls</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ANNOTATIONS_DEFINITION__ANNOTATION_DECLS = eINSTANCE.getAnnotationsDefinition_AnnotationDecls();

    /**
     * The meta object literal for the '{@link de.jevopi.mitra2.mitra.impl.AnnotationDeclImpl <em>Annotation Decl</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.jevopi.mitra2.mitra.impl.AnnotationDeclImpl
     * @see de.jevopi.mitra2.mitra.impl.MitraPackageImpl#getAnnotationDecl()
     * @generated
     */
    EClass ANNOTATION_DECL = eINSTANCE.getAnnotationDecl();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ANNOTATION_DECL__NAME = eINSTANCE.getAnnotationDecl_Name();

    /**
     * The meta object literal for the '<em><b>Targets</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ANNOTATION_DECL__TARGETS = eINSTANCE.getAnnotationDecl_Targets();

    /**
     * The meta object literal for the '<em><b>Valuetype</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ANNOTATION_DECL__VALUETYPE = eINSTANCE.getAnnotationDecl_Valuetype();

    /**
     * The meta object literal for the '<em><b>Many</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ANNOTATION_DECL__MANY = eINSTANCE.getAnnotationDecl_Many();

    /**
     * The meta object literal for the '<em><b>Required</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ANNOTATION_DECL__REQUIRED = eINSTANCE.getAnnotationDecl_Required();

    /**
     * The meta object literal for the '<em><b>Default</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ANNOTATION_DECL__DEFAULT = eINSTANCE.getAnnotationDecl_Default();

    /**
     * The meta object literal for the '<em><b>Property Decls</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ANNOTATION_DECL__PROPERTY_DECLS = eINSTANCE.getAnnotationDecl_PropertyDecls();

    /**
     * The meta object literal for the '{@link de.jevopi.mitra2.mitra.impl.AnnotationPropertyDeclImpl <em>Annotation Property Decl</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.jevopi.mitra2.mitra.impl.AnnotationPropertyDeclImpl
     * @see de.jevopi.mitra2.mitra.impl.MitraPackageImpl#getAnnotationPropertyDecl()
     * @generated
     */
    EClass ANNOTATION_PROPERTY_DECL = eINSTANCE.getAnnotationPropertyDecl();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ANNOTATION_PROPERTY_DECL__TYPE = eINSTANCE.getAnnotationPropertyDecl_Type();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ANNOTATION_PROPERTY_DECL__NAME = eINSTANCE.getAnnotationPropertyDecl_Name();

    /**
     * The meta object literal for the '<em><b>Required</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ANNOTATION_PROPERTY_DECL__REQUIRED = eINSTANCE.getAnnotationPropertyDecl_Required();

    /**
     * The meta object literal for the '<em><b>Default</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ANNOTATION_PROPERTY_DECL__DEFAULT = eINSTANCE.getAnnotationPropertyDecl_Default();

    /**
     * The meta object literal for the '{@link de.jevopi.mitra2.mitra.impl.AnnotationImpl <em>Annotation</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.jevopi.mitra2.mitra.impl.AnnotationImpl
     * @see de.jevopi.mitra2.mitra.impl.MitraPackageImpl#getAnnotation()
     * @generated
     */
    EClass ANNOTATION = eINSTANCE.getAnnotation();

    /**
     * The meta object literal for the '<em><b>Decl</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ANNOTATION__DECL = eINSTANCE.getAnnotation_Decl();

    /**
     * The meta object literal for the '<em><b>Values</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ANNOTATION__VALUES = eINSTANCE.getAnnotation_Values();

    /**
     * The meta object literal for the '<em><b>Properties</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ANNOTATION__PROPERTIES = eINSTANCE.getAnnotation_Properties();

    /**
     * The meta object literal for the '{@link de.jevopi.mitra2.mitra.impl.AnnotationPropertyImpl <em>Annotation Property</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.jevopi.mitra2.mitra.impl.AnnotationPropertyImpl
     * @see de.jevopi.mitra2.mitra.impl.MitraPackageImpl#getAnnotationProperty()
     * @generated
     */
    EClass ANNOTATION_PROPERTY = eINSTANCE.getAnnotationProperty();

    /**
     * The meta object literal for the '<em><b>Decl</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ANNOTATION_PROPERTY__DECL = eINSTANCE.getAnnotationProperty_Decl();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ANNOTATION_PROPERTY__VALUE = eINSTANCE.getAnnotationProperty_Value();

    /**
     * The meta object literal for the '{@link de.jevopi.mitra2.mitra.impl.AssignmentImpl <em>Assignment</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.jevopi.mitra2.mitra.impl.AssignmentImpl
     * @see de.jevopi.mitra2.mitra.impl.MitraPackageImpl#getAssignment()
     * @generated
     */
    EClass ASSIGNMENT = eINSTANCE.getAssignment();

    /**
     * The meta object literal for the '<em><b>Lhs</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ASSIGNMENT__LHS = eINSTANCE.getAssignment_Lhs();

    /**
     * The meta object literal for the '<em><b>Operator</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ASSIGNMENT__OPERATOR = eINSTANCE.getAssignment_Operator();

    /**
     * The meta object literal for the '<em><b>Expression</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ASSIGNMENT__EXPRESSION = eINSTANCE.getAssignment_Expression();

    /**
     * The meta object literal for the '{@link de.jevopi.mitra2.mitra.impl.IteratorExpressionImpl <em>Iterator Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.jevopi.mitra2.mitra.impl.IteratorExpressionImpl
     * @see de.jevopi.mitra2.mitra.impl.MitraPackageImpl#getIteratorExpression()
     * @generated
     */
    EClass ITERATOR_EXPRESSION = eINSTANCE.getIteratorExpression();

    /**
     * The meta object literal for the '<em><b>Variable</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ITERATOR_EXPRESSION__VARIABLE = eINSTANCE.getIteratorExpression_Variable();

    /**
     * The meta object literal for the '<em><b>Expression</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ITERATOR_EXPRESSION__EXPRESSION = eINSTANCE.getIteratorExpression_Expression();

    /**
     * The meta object literal for the '{@link de.jevopi.mitra2.mitra.impl.BooleanExpressionImpl <em>Boolean Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.jevopi.mitra2.mitra.impl.BooleanExpressionImpl
     * @see de.jevopi.mitra2.mitra.impl.MitraPackageImpl#getBooleanExpression()
     * @generated
     */
    EClass BOOLEAN_EXPRESSION = eINSTANCE.getBooleanExpression();

    /**
     * The meta object literal for the '<em><b>Lhs</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference BOOLEAN_EXPRESSION__LHS = eINSTANCE.getBooleanExpression_Lhs();

    /**
     * The meta object literal for the '<em><b>Op</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute BOOLEAN_EXPRESSION__OP = eINSTANCE.getBooleanExpression_Op();

    /**
     * The meta object literal for the '<em><b>Rhs</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference BOOLEAN_EXPRESSION__RHS = eINSTANCE.getBooleanExpression_Rhs();

    /**
     * The meta object literal for the '{@link de.jevopi.mitra2.mitra.impl.EqualityExpressionImpl <em>Equality Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.jevopi.mitra2.mitra.impl.EqualityExpressionImpl
     * @see de.jevopi.mitra2.mitra.impl.MitraPackageImpl#getEqualityExpression()
     * @generated
     */
    EClass EQUALITY_EXPRESSION = eINSTANCE.getEqualityExpression();

    /**
     * The meta object literal for the '<em><b>Lhs</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference EQUALITY_EXPRESSION__LHS = eINSTANCE.getEqualityExpression_Lhs();

    /**
     * The meta object literal for the '<em><b>Op</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute EQUALITY_EXPRESSION__OP = eINSTANCE.getEqualityExpression_Op();

    /**
     * The meta object literal for the '<em><b>Rhs</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference EQUALITY_EXPRESSION__RHS = eINSTANCE.getEqualityExpression_Rhs();

    /**
     * The meta object literal for the '{@link de.jevopi.mitra2.mitra.impl.RelationalExpressionImpl <em>Relational Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.jevopi.mitra2.mitra.impl.RelationalExpressionImpl
     * @see de.jevopi.mitra2.mitra.impl.MitraPackageImpl#getRelationalExpression()
     * @generated
     */
    EClass RELATIONAL_EXPRESSION = eINSTANCE.getRelationalExpression();

    /**
     * The meta object literal for the '<em><b>Lhs</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference RELATIONAL_EXPRESSION__LHS = eINSTANCE.getRelationalExpression_Lhs();

    /**
     * The meta object literal for the '<em><b>Op</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute RELATIONAL_EXPRESSION__OP = eINSTANCE.getRelationalExpression_Op();

    /**
     * The meta object literal for the '<em><b>Rhs</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference RELATIONAL_EXPRESSION__RHS = eINSTANCE.getRelationalExpression_Rhs();

    /**
     * The meta object literal for the '{@link de.jevopi.mitra2.mitra.impl.MathExpressionImpl <em>Math Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.jevopi.mitra2.mitra.impl.MathExpressionImpl
     * @see de.jevopi.mitra2.mitra.impl.MitraPackageImpl#getMathExpression()
     * @generated
     */
    EClass MATH_EXPRESSION = eINSTANCE.getMathExpression();

    /**
     * The meta object literal for the '<em><b>Lhs</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MATH_EXPRESSION__LHS = eINSTANCE.getMathExpression_Lhs();

    /**
     * The meta object literal for the '<em><b>Op</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MATH_EXPRESSION__OP = eINSTANCE.getMathExpression_Op();

    /**
     * The meta object literal for the '<em><b>Rhs</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MATH_EXPRESSION__RHS = eINSTANCE.getMathExpression_Rhs();

    /**
     * The meta object literal for the '{@link de.jevopi.mitra2.mitra.impl.UnaryCastExpressionImpl <em>Unary Cast Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.jevopi.mitra2.mitra.impl.UnaryCastExpressionImpl
     * @see de.jevopi.mitra2.mitra.impl.MitraPackageImpl#getUnaryCastExpression()
     * @generated
     */
    EClass UNARY_CAST_EXPRESSION = eINSTANCE.getUnaryCastExpression();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference UNARY_CAST_EXPRESSION__TYPE = eINSTANCE.getUnaryCastExpression_Type();

    /**
     * The meta object literal for the '<em><b>Expression</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference UNARY_CAST_EXPRESSION__EXPRESSION = eINSTANCE.getUnaryCastExpression_Expression();

    /**
     * The meta object literal for the '{@link de.jevopi.mitra2.mitra.impl.UnaryBooleanExpressionImpl <em>Unary Boolean Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.jevopi.mitra2.mitra.impl.UnaryBooleanExpressionImpl
     * @see de.jevopi.mitra2.mitra.impl.MitraPackageImpl#getUnaryBooleanExpression()
     * @generated
     */
    EClass UNARY_BOOLEAN_EXPRESSION = eINSTANCE.getUnaryBooleanExpression();

    /**
     * The meta object literal for the '<em><b>Expression</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference UNARY_BOOLEAN_EXPRESSION__EXPRESSION = eINSTANCE.getUnaryBooleanExpression_Expression();

    /**
     * The meta object literal for the '{@link de.jevopi.mitra2.mitra.impl.UnaryMathExpressionImpl <em>Unary Math Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.jevopi.mitra2.mitra.impl.UnaryMathExpressionImpl
     * @see de.jevopi.mitra2.mitra.impl.MitraPackageImpl#getUnaryMathExpression()
     * @generated
     */
    EClass UNARY_MATH_EXPRESSION = eINSTANCE.getUnaryMathExpression();

    /**
     * The meta object literal for the '<em><b>Op</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute UNARY_MATH_EXPRESSION__OP = eINSTANCE.getUnaryMathExpression_Op();

    /**
     * The meta object literal for the '<em><b>Expression</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference UNARY_MATH_EXPRESSION__EXPRESSION = eINSTANCE.getUnaryMathExpression_Expression();

    /**
     * The meta object literal for the '{@link de.jevopi.mitra2.mitra.impl.InstanceOfExpressionImpl <em>Instance Of Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.jevopi.mitra2.mitra.impl.InstanceOfExpressionImpl
     * @see de.jevopi.mitra2.mitra.impl.MitraPackageImpl#getInstanceOfExpression()
     * @generated
     */
    EClass INSTANCE_OF_EXPRESSION = eINSTANCE.getInstanceOfExpression();

    /**
     * The meta object literal for the '<em><b>Expression</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference INSTANCE_OF_EXPRESSION__EXPRESSION = eINSTANCE.getInstanceOfExpression_Expression();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference INSTANCE_OF_EXPRESSION__TYPE = eINSTANCE.getInstanceOfExpression_Type();

    /**
     * The meta object literal for the '{@link de.jevopi.mitra2.mitra.VisibilityModifier <em>Visibility Modifier</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.jevopi.mitra2.mitra.VisibilityModifier
     * @see de.jevopi.mitra2.mitra.impl.MitraPackageImpl#getVisibilityModifier()
     * @generated
     */
    EEnum VISIBILITY_MODIFIER = eINSTANCE.getVisibilityModifier();

    /**
     * The meta object literal for the '{@link de.jevopi.mitra2.mitra.ExecutionModifier <em>Execution Modifier</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.jevopi.mitra2.mitra.ExecutionModifier
     * @see de.jevopi.mitra2.mitra.impl.MitraPackageImpl#getExecutionModifier()
     * @generated
     */
    EEnum EXECUTION_MODIFIER = eINSTANCE.getExecutionModifier();

    /**
     * The meta object literal for the '{@link de.jevopi.mitra2.mitra.ParameterModifier <em>Parameter Modifier</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.jevopi.mitra2.mitra.ParameterModifier
     * @see de.jevopi.mitra2.mitra.impl.MitraPackageImpl#getParameterModifier()
     * @generated
     */
    EEnum PARAMETER_MODIFIER = eINSTANCE.getParameterModifier();

    /**
     * The meta object literal for the '{@link de.jevopi.mitra2.mitra.PrimitiveTypeSpec <em>Primitive Type Spec</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.jevopi.mitra2.mitra.PrimitiveTypeSpec
     * @see de.jevopi.mitra2.mitra.impl.MitraPackageImpl#getPrimitiveTypeSpec()
     * @generated
     */
    EEnum PRIMITIVE_TYPE_SPEC = eINSTANCE.getPrimitiveTypeSpec();

    /**
     * The meta object literal for the '{@link de.jevopi.mitra2.mitra.CollectionTypeSpec <em>Collection Type Spec</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.jevopi.mitra2.mitra.CollectionTypeSpec
     * @see de.jevopi.mitra2.mitra.impl.MitraPackageImpl#getCollectionTypeSpec()
     * @generated
     */
    EEnum COLLECTION_TYPE_SPEC = eINSTANCE.getCollectionTypeSpec();

    /**
     * The meta object literal for the '{@link de.jevopi.mitra2.mitra.BooleanOperator <em>Boolean Operator</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.jevopi.mitra2.mitra.BooleanOperator
     * @see de.jevopi.mitra2.mitra.impl.MitraPackageImpl#getBooleanOperator()
     * @generated
     */
    EEnum BOOLEAN_OPERATOR = eINSTANCE.getBooleanOperator();

    /**
     * The meta object literal for the '{@link de.jevopi.mitra2.mitra.EqualityOperator <em>Equality Operator</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.jevopi.mitra2.mitra.EqualityOperator
     * @see de.jevopi.mitra2.mitra.impl.MitraPackageImpl#getEqualityOperator()
     * @generated
     */
    EEnum EQUALITY_OPERATOR = eINSTANCE.getEqualityOperator();

    /**
     * The meta object literal for the '{@link de.jevopi.mitra2.mitra.RelationalOperator <em>Relational Operator</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.jevopi.mitra2.mitra.RelationalOperator
     * @see de.jevopi.mitra2.mitra.impl.MitraPackageImpl#getRelationalOperator()
     * @generated
     */
    EEnum RELATIONAL_OPERATOR = eINSTANCE.getRelationalOperator();

    /**
     * The meta object literal for the '{@link de.jevopi.mitra2.mitra.MathOperator <em>Math Operator</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.jevopi.mitra2.mitra.MathOperator
     * @see de.jevopi.mitra2.mitra.impl.MitraPackageImpl#getMathOperator()
     * @generated
     */
    EEnum MATH_OPERATOR = eINSTANCE.getMathOperator();

    /**
     * The meta object literal for the '{@link de.jevopi.mitra2.mitra.UnaryMathOperator <em>Unary Math Operator</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.jevopi.mitra2.mitra.UnaryMathOperator
     * @see de.jevopi.mitra2.mitra.impl.MitraPackageImpl#getUnaryMathOperator()
     * @generated
     */
    EEnum UNARY_MATH_OPERATOR = eINSTANCE.getUnaryMathOperator();

    /**
     * The meta object literal for the '{@link de.jevopi.mitra2.mitra.AssignmentOperator <em>Assignment Operator</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.jevopi.mitra2.mitra.AssignmentOperator
     * @see de.jevopi.mitra2.mitra.impl.MitraPackageImpl#getAssignmentOperator()
     * @generated
     */
    EEnum ASSIGNMENT_OPERATOR = eINSTANCE.getAssignmentOperator();

    /**
     * The meta object literal for the '{@link de.jevopi.mitra2.mitra.PPOperator <em>PP Operator</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.jevopi.mitra2.mitra.PPOperator
     * @see de.jevopi.mitra2.mitra.impl.MitraPackageImpl#getPPOperator()
     * @generated
     */
    EEnum PP_OPERATOR = eINSTANCE.getPPOperator();

    /**
     * The meta object literal for the '{@link de.jevopi.mitra2.mitra.AnnotationTargetSpec <em>Annotation Target Spec</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.jevopi.mitra2.mitra.AnnotationTargetSpec
     * @see de.jevopi.mitra2.mitra.impl.MitraPackageImpl#getAnnotationTargetSpec()
     * @generated
     */
    EEnum ANNOTATION_TARGET_SPEC = eINSTANCE.getAnnotationTargetSpec();

  }

} //MitraPackage
