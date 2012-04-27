/**
 */
package de.jevopi.mitra2.mitra;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Local Variable Declaration Statement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.jevopi.mitra2.mitra.LocalVariableDeclarationStatement#getLocalVariableDeclaration <em>Local Variable Declaration</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.jevopi.mitra2.mitra.MitraPackage#getLocalVariableDeclarationStatement()
 * @model
 * @generated
 */
public interface LocalVariableDeclarationStatement extends BlockStatement
{
  /**
   * Returns the value of the '<em><b>Local Variable Declaration</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Local Variable Declaration</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Local Variable Declaration</em>' containment reference.
   * @see #setLocalVariableDeclaration(LocalVariableDeclaration)
   * @see de.jevopi.mitra2.mitra.MitraPackage#getLocalVariableDeclarationStatement_LocalVariableDeclaration()
   * @model containment="true"
   * @generated
   */
  LocalVariableDeclaration getLocalVariableDeclaration();

  /**
   * Sets the value of the '{@link de.jevopi.mitra2.mitra.LocalVariableDeclarationStatement#getLocalVariableDeclaration <em>Local Variable Declaration</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Local Variable Declaration</em>' containment reference.
   * @see #getLocalVariableDeclaration()
   * @generated
   */
  void setLocalVariableDeclaration(LocalVariableDeclaration value);

} // LocalVariableDeclarationStatement
