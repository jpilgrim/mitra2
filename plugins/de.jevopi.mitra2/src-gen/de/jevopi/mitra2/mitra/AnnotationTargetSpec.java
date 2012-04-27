/**
 */
package de.jevopi.mitra2.mitra;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Annotation Target Spec</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see de.jevopi.mitra2.mitra.MitraPackage#getAnnotationTargetSpec()
 * @model
 * @generated
 */
public enum AnnotationTargetSpec implements Enumerator
{
  /**
   * The '<em><b>Module</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #MODULE_VALUE
   * @generated
   * @ordered
   */
  MODULE(0, "module", "module"),

  /**
   * The '<em><b>Rule</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #RULE_VALUE
   * @generated
   * @ordered
   */
  RULE(1, "rule", "rule"),

  /**
   * The '<em><b>Parameter</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #PARAMETER_VALUE
   * @generated
   * @ordered
   */
  PARAMETER(2, "parameter", "parameter");

  /**
   * The '<em><b>Module</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>Module</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #MODULE
   * @model name="module"
   * @generated
   * @ordered
   */
  public static final int MODULE_VALUE = 0;

  /**
   * The '<em><b>Rule</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>Rule</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #RULE
   * @model name="rule"
   * @generated
   * @ordered
   */
  public static final int RULE_VALUE = 1;

  /**
   * The '<em><b>Parameter</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>Parameter</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #PARAMETER
   * @model name="parameter"
   * @generated
   * @ordered
   */
  public static final int PARAMETER_VALUE = 2;

  /**
   * An array of all the '<em><b>Annotation Target Spec</b></em>' enumerators.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private static final AnnotationTargetSpec[] VALUES_ARRAY =
    new AnnotationTargetSpec[]
    {
      MODULE,
      RULE,
      PARAMETER,
    };

  /**
   * A public read-only list of all the '<em><b>Annotation Target Spec</b></em>' enumerators.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static final List<AnnotationTargetSpec> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

  /**
   * Returns the '<em><b>Annotation Target Spec</b></em>' literal with the specified literal value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static AnnotationTargetSpec get(String literal)
  {
    for (int i = 0; i < VALUES_ARRAY.length; ++i)
    {
      AnnotationTargetSpec result = VALUES_ARRAY[i];
      if (result.toString().equals(literal))
      {
        return result;
      }
    }
    return null;
  }

  /**
   * Returns the '<em><b>Annotation Target Spec</b></em>' literal with the specified name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static AnnotationTargetSpec getByName(String name)
  {
    for (int i = 0; i < VALUES_ARRAY.length; ++i)
    {
      AnnotationTargetSpec result = VALUES_ARRAY[i];
      if (result.getName().equals(name))
      {
        return result;
      }
    }
    return null;
  }

  /**
   * Returns the '<em><b>Annotation Target Spec</b></em>' literal with the specified integer value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static AnnotationTargetSpec get(int value)
  {
    switch (value)
    {
      case MODULE_VALUE: return MODULE;
      case RULE_VALUE: return RULE;
      case PARAMETER_VALUE: return PARAMETER;
    }
    return null;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private final int value;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private final String name;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private final String literal;

  /**
   * Only this class can construct instances.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private AnnotationTargetSpec(int value, String name, String literal)
  {
    this.value = value;
    this.name = name;
    this.literal = literal;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public int getValue()
  {
    return value;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getName()
  {
    return name;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getLiteral()
  {
    return literal;
  }

  /**
   * Returns the literal value of the enumerator, which is its string representation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString()
  {
    return literal;
  }
  
} //AnnotationTargetSpec
