/**
 */
package de.jevopi.mitra2.mitra;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Collection Type Spec</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see de.jevopi.mitra2.mitra.MitraPackage#getCollectionTypeSpec()
 * @model
 * @generated
 */
public enum CollectionTypeSpec implements Enumerator
{
  /**
   * The '<em><b>Collection</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #COLLECTION_VALUE
   * @generated
   * @ordered
   */
  COLLECTION(0, "Collection", "Collection"),

  /**
   * The '<em><b>Set</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #SET_VALUE
   * @generated
   * @ordered
   */
  SET(1, "Set", "Set"),

  /**
   * The '<em><b>Ordered Set</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #ORDERED_SET_VALUE
   * @generated
   * @ordered
   */
  ORDERED_SET(2, "OrderedSet", "OrderedSet"),

  /**
   * The '<em><b>Bag</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #BAG_VALUE
   * @generated
   * @ordered
   */
  BAG(3, "Bag", "Bag"),

  /**
   * The '<em><b>Sequence</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #SEQUENCE_VALUE
   * @generated
   * @ordered
   */
  SEQUENCE(4, "Sequence", "Sequence");

  /**
   * The '<em><b>Collection</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>Collection</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #COLLECTION
   * @model name="Collection"
   * @generated
   * @ordered
   */
  public static final int COLLECTION_VALUE = 0;

  /**
   * The '<em><b>Set</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>Set</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #SET
   * @model name="Set"
   * @generated
   * @ordered
   */
  public static final int SET_VALUE = 1;

  /**
   * The '<em><b>Ordered Set</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>Ordered Set</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #ORDERED_SET
   * @model name="OrderedSet"
   * @generated
   * @ordered
   */
  public static final int ORDERED_SET_VALUE = 2;

  /**
   * The '<em><b>Bag</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>Bag</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #BAG
   * @model name="Bag"
   * @generated
   * @ordered
   */
  public static final int BAG_VALUE = 3;

  /**
   * The '<em><b>Sequence</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>Sequence</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #SEQUENCE
   * @model name="Sequence"
   * @generated
   * @ordered
   */
  public static final int SEQUENCE_VALUE = 4;

  /**
   * An array of all the '<em><b>Collection Type Spec</b></em>' enumerators.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private static final CollectionTypeSpec[] VALUES_ARRAY =
    new CollectionTypeSpec[]
    {
      COLLECTION,
      SET,
      ORDERED_SET,
      BAG,
      SEQUENCE,
    };

  /**
   * A public read-only list of all the '<em><b>Collection Type Spec</b></em>' enumerators.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static final List<CollectionTypeSpec> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

  /**
   * Returns the '<em><b>Collection Type Spec</b></em>' literal with the specified literal value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static CollectionTypeSpec get(String literal)
  {
    for (int i = 0; i < VALUES_ARRAY.length; ++i)
    {
      CollectionTypeSpec result = VALUES_ARRAY[i];
      if (result.toString().equals(literal))
      {
        return result;
      }
    }
    return null;
  }

  /**
   * Returns the '<em><b>Collection Type Spec</b></em>' literal with the specified name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static CollectionTypeSpec getByName(String name)
  {
    for (int i = 0; i < VALUES_ARRAY.length; ++i)
    {
      CollectionTypeSpec result = VALUES_ARRAY[i];
      if (result.getName().equals(name))
      {
        return result;
      }
    }
    return null;
  }

  /**
   * Returns the '<em><b>Collection Type Spec</b></em>' literal with the specified integer value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static CollectionTypeSpec get(int value)
  {
    switch (value)
    {
      case COLLECTION_VALUE: return COLLECTION;
      case SET_VALUE: return SET;
      case ORDERED_SET_VALUE: return ORDERED_SET;
      case BAG_VALUE: return BAG;
      case SEQUENCE_VALUE: return SEQUENCE;
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
  private CollectionTypeSpec(int value, String name, String literal)
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
  
} //CollectionTypeSpec
