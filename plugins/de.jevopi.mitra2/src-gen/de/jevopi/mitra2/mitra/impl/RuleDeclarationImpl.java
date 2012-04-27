/**
 */
package de.jevopi.mitra2.mitra.impl;

import de.jevopi.mitra2.mitra.Annotation;
import de.jevopi.mitra2.mitra.Block;
import de.jevopi.mitra2.mitra.ExecutionModifier;
import de.jevopi.mitra2.mitra.FormalParameter;
import de.jevopi.mitra2.mitra.JavaSpec;
import de.jevopi.mitra2.mitra.MitraPackage;
import de.jevopi.mitra2.mitra.ReturnParameter;
import de.jevopi.mitra2.mitra.RuleDeclaration;
import de.jevopi.mitra2.mitra.SimpleRuleReference;
import de.jevopi.mitra2.mitra.Trigger;
import de.jevopi.mitra2.mitra.VisibilityModifier;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Rule Declaration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.jevopi.mitra2.mitra.impl.RuleDeclarationImpl#getAnnotations <em>Annotations</em>}</li>
 *   <li>{@link de.jevopi.mitra2.mitra.impl.RuleDeclarationImpl#getVisibility <em>Visibility</em>}</li>
 *   <li>{@link de.jevopi.mitra2.mitra.impl.RuleDeclarationImpl#getExec <em>Exec</em>}</li>
 *   <li>{@link de.jevopi.mitra2.mitra.impl.RuleDeclarationImpl#isTraced <em>Traced</em>}</li>
 *   <li>{@link de.jevopi.mitra2.mitra.impl.RuleDeclarationImpl#isStealth <em>Stealth</em>}</li>
 *   <li>{@link de.jevopi.mitra2.mitra.impl.RuleDeclarationImpl#isVirtual <em>Virtual</em>}</li>
 *   <li>{@link de.jevopi.mitra2.mitra.impl.RuleDeclarationImpl#isMulti <em>Multi</em>}</li>
 *   <li>{@link de.jevopi.mitra2.mitra.impl.RuleDeclarationImpl#getName <em>Name</em>}</li>
 *   <li>{@link de.jevopi.mitra2.mitra.impl.RuleDeclarationImpl#getFormalParameters <em>Formal Parameters</em>}</li>
 *   <li>{@link de.jevopi.mitra2.mitra.impl.RuleDeclarationImpl#getReturnParameters <em>Return Parameters</em>}</li>
 *   <li>{@link de.jevopi.mitra2.mitra.impl.RuleDeclarationImpl#getImplementedRules <em>Implemented Rules</em>}</li>
 *   <li>{@link de.jevopi.mitra2.mitra.impl.RuleDeclarationImpl#getOverriddenRule <em>Overridden Rule</em>}</li>
 *   <li>{@link de.jevopi.mitra2.mitra.impl.RuleDeclarationImpl#getExcludingRules <em>Excluding Rules</em>}</li>
 *   <li>{@link de.jevopi.mitra2.mitra.impl.RuleDeclarationImpl#getTrigger <em>Trigger</em>}</li>
 *   <li>{@link de.jevopi.mitra2.mitra.impl.RuleDeclarationImpl#getJavaSpec <em>Java Spec</em>}</li>
 *   <li>{@link de.jevopi.mitra2.mitra.impl.RuleDeclarationImpl#getBody <em>Body</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RuleDeclarationImpl extends MinimalEObjectImpl.Container implements RuleDeclaration
{
  /**
   * The cached value of the '{@link #getAnnotations() <em>Annotations</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAnnotations()
   * @generated
   * @ordered
   */
  protected EList<Annotation> annotations;

  /**
   * The default value of the '{@link #getVisibility() <em>Visibility</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getVisibility()
   * @generated
   * @ordered
   */
  protected static final VisibilityModifier VISIBILITY_EDEFAULT = VisibilityModifier.PUBLIC;

  /**
   * The cached value of the '{@link #getVisibility() <em>Visibility</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getVisibility()
   * @generated
   * @ordered
   */
  protected VisibilityModifier visibility = VISIBILITY_EDEFAULT;

  /**
   * The default value of the '{@link #getExec() <em>Exec</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getExec()
   * @generated
   * @ordered
   */
  protected static final ExecutionModifier EXEC_EDEFAULT = ExecutionModifier.CALLED;

  /**
   * The cached value of the '{@link #getExec() <em>Exec</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getExec()
   * @generated
   * @ordered
   */
  protected ExecutionModifier exec = EXEC_EDEFAULT;

  /**
   * The default value of the '{@link #isTraced() <em>Traced</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isTraced()
   * @generated
   * @ordered
   */
  protected static final boolean TRACED_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isTraced() <em>Traced</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isTraced()
   * @generated
   * @ordered
   */
  protected boolean traced = TRACED_EDEFAULT;

  /**
   * The default value of the '{@link #isStealth() <em>Stealth</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isStealth()
   * @generated
   * @ordered
   */
  protected static final boolean STEALTH_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isStealth() <em>Stealth</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isStealth()
   * @generated
   * @ordered
   */
  protected boolean stealth = STEALTH_EDEFAULT;

  /**
   * The default value of the '{@link #isVirtual() <em>Virtual</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isVirtual()
   * @generated
   * @ordered
   */
  protected static final boolean VIRTUAL_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isVirtual() <em>Virtual</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isVirtual()
   * @generated
   * @ordered
   */
  protected boolean virtual = VIRTUAL_EDEFAULT;

  /**
   * The default value of the '{@link #isMulti() <em>Multi</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isMulti()
   * @generated
   * @ordered
   */
  protected static final boolean MULTI_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isMulti() <em>Multi</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isMulti()
   * @generated
   * @ordered
   */
  protected boolean multi = MULTI_EDEFAULT;

  /**
   * The default value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected static final String NAME_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected String name = NAME_EDEFAULT;

  /**
   * The cached value of the '{@link #getFormalParameters() <em>Formal Parameters</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFormalParameters()
   * @generated
   * @ordered
   */
  protected EList<FormalParameter> formalParameters;

  /**
   * The cached value of the '{@link #getReturnParameters() <em>Return Parameters</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getReturnParameters()
   * @generated
   * @ordered
   */
  protected EList<ReturnParameter> returnParameters;

  /**
   * The cached value of the '{@link #getImplementedRules() <em>Implemented Rules</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getImplementedRules()
   * @generated
   * @ordered
   */
  protected EList<SimpleRuleReference> implementedRules;

  /**
   * The cached value of the '{@link #getOverriddenRule() <em>Overridden Rule</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOverriddenRule()
   * @generated
   * @ordered
   */
  protected SimpleRuleReference overriddenRule;

  /**
   * The cached value of the '{@link #getExcludingRules() <em>Excluding Rules</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getExcludingRules()
   * @generated
   * @ordered
   */
  protected EList<SimpleRuleReference> excludingRules;

  /**
   * The cached value of the '{@link #getTrigger() <em>Trigger</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTrigger()
   * @generated
   * @ordered
   */
  protected Trigger trigger;

  /**
   * The cached value of the '{@link #getJavaSpec() <em>Java Spec</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getJavaSpec()
   * @generated
   * @ordered
   */
  protected JavaSpec javaSpec;

  /**
   * The cached value of the '{@link #getBody() <em>Body</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getBody()
   * @generated
   * @ordered
   */
  protected Block body;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected RuleDeclarationImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return MitraPackage.Literals.RULE_DECLARATION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Annotation> getAnnotations()
  {
    if (annotations == null)
    {
      annotations = new EObjectContainmentEList<Annotation>(Annotation.class, this, MitraPackage.RULE_DECLARATION__ANNOTATIONS);
    }
    return annotations;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public VisibilityModifier getVisibility()
  {
    return visibility;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setVisibility(VisibilityModifier newVisibility)
  {
    VisibilityModifier oldVisibility = visibility;
    visibility = newVisibility == null ? VISIBILITY_EDEFAULT : newVisibility;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MitraPackage.RULE_DECLARATION__VISIBILITY, oldVisibility, visibility));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ExecutionModifier getExec()
  {
    return exec;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setExec(ExecutionModifier newExec)
  {
    ExecutionModifier oldExec = exec;
    exec = newExec == null ? EXEC_EDEFAULT : newExec;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MitraPackage.RULE_DECLARATION__EXEC, oldExec, exec));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isTraced()
  {
    return traced;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setTraced(boolean newTraced)
  {
    boolean oldTraced = traced;
    traced = newTraced;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MitraPackage.RULE_DECLARATION__TRACED, oldTraced, traced));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isStealth()
  {
    return stealth;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setStealth(boolean newStealth)
  {
    boolean oldStealth = stealth;
    stealth = newStealth;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MitraPackage.RULE_DECLARATION__STEALTH, oldStealth, stealth));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isVirtual()
  {
    return virtual;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setVirtual(boolean newVirtual)
  {
    boolean oldVirtual = virtual;
    virtual = newVirtual;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MitraPackage.RULE_DECLARATION__VIRTUAL, oldVirtual, virtual));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isMulti()
  {
    return multi;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setMulti(boolean newMulti)
  {
    boolean oldMulti = multi;
    multi = newMulti;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MitraPackage.RULE_DECLARATION__MULTI, oldMulti, multi));
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
  public void setName(String newName)
  {
    String oldName = name;
    name = newName;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MitraPackage.RULE_DECLARATION__NAME, oldName, name));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<FormalParameter> getFormalParameters()
  {
    if (formalParameters == null)
    {
      formalParameters = new EObjectContainmentEList<FormalParameter>(FormalParameter.class, this, MitraPackage.RULE_DECLARATION__FORMAL_PARAMETERS);
    }
    return formalParameters;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<ReturnParameter> getReturnParameters()
  {
    if (returnParameters == null)
    {
      returnParameters = new EObjectContainmentEList<ReturnParameter>(ReturnParameter.class, this, MitraPackage.RULE_DECLARATION__RETURN_PARAMETERS);
    }
    return returnParameters;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<SimpleRuleReference> getImplementedRules()
  {
    if (implementedRules == null)
    {
      implementedRules = new EObjectContainmentEList<SimpleRuleReference>(SimpleRuleReference.class, this, MitraPackage.RULE_DECLARATION__IMPLEMENTED_RULES);
    }
    return implementedRules;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SimpleRuleReference getOverriddenRule()
  {
    return overriddenRule;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetOverriddenRule(SimpleRuleReference newOverriddenRule, NotificationChain msgs)
  {
    SimpleRuleReference oldOverriddenRule = overriddenRule;
    overriddenRule = newOverriddenRule;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MitraPackage.RULE_DECLARATION__OVERRIDDEN_RULE, oldOverriddenRule, newOverriddenRule);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setOverriddenRule(SimpleRuleReference newOverriddenRule)
  {
    if (newOverriddenRule != overriddenRule)
    {
      NotificationChain msgs = null;
      if (overriddenRule != null)
        msgs = ((InternalEObject)overriddenRule).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MitraPackage.RULE_DECLARATION__OVERRIDDEN_RULE, null, msgs);
      if (newOverriddenRule != null)
        msgs = ((InternalEObject)newOverriddenRule).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MitraPackage.RULE_DECLARATION__OVERRIDDEN_RULE, null, msgs);
      msgs = basicSetOverriddenRule(newOverriddenRule, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MitraPackage.RULE_DECLARATION__OVERRIDDEN_RULE, newOverriddenRule, newOverriddenRule));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<SimpleRuleReference> getExcludingRules()
  {
    if (excludingRules == null)
    {
      excludingRules = new EObjectContainmentEList<SimpleRuleReference>(SimpleRuleReference.class, this, MitraPackage.RULE_DECLARATION__EXCLUDING_RULES);
    }
    return excludingRules;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Trigger getTrigger()
  {
    return trigger;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetTrigger(Trigger newTrigger, NotificationChain msgs)
  {
    Trigger oldTrigger = trigger;
    trigger = newTrigger;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MitraPackage.RULE_DECLARATION__TRIGGER, oldTrigger, newTrigger);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setTrigger(Trigger newTrigger)
  {
    if (newTrigger != trigger)
    {
      NotificationChain msgs = null;
      if (trigger != null)
        msgs = ((InternalEObject)trigger).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MitraPackage.RULE_DECLARATION__TRIGGER, null, msgs);
      if (newTrigger != null)
        msgs = ((InternalEObject)newTrigger).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MitraPackage.RULE_DECLARATION__TRIGGER, null, msgs);
      msgs = basicSetTrigger(newTrigger, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MitraPackage.RULE_DECLARATION__TRIGGER, newTrigger, newTrigger));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public JavaSpec getJavaSpec()
  {
    return javaSpec;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetJavaSpec(JavaSpec newJavaSpec, NotificationChain msgs)
  {
    JavaSpec oldJavaSpec = javaSpec;
    javaSpec = newJavaSpec;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MitraPackage.RULE_DECLARATION__JAVA_SPEC, oldJavaSpec, newJavaSpec);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setJavaSpec(JavaSpec newJavaSpec)
  {
    if (newJavaSpec != javaSpec)
    {
      NotificationChain msgs = null;
      if (javaSpec != null)
        msgs = ((InternalEObject)javaSpec).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MitraPackage.RULE_DECLARATION__JAVA_SPEC, null, msgs);
      if (newJavaSpec != null)
        msgs = ((InternalEObject)newJavaSpec).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MitraPackage.RULE_DECLARATION__JAVA_SPEC, null, msgs);
      msgs = basicSetJavaSpec(newJavaSpec, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MitraPackage.RULE_DECLARATION__JAVA_SPEC, newJavaSpec, newJavaSpec));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Block getBody()
  {
    return body;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetBody(Block newBody, NotificationChain msgs)
  {
    Block oldBody = body;
    body = newBody;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MitraPackage.RULE_DECLARATION__BODY, oldBody, newBody);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setBody(Block newBody)
  {
    if (newBody != body)
    {
      NotificationChain msgs = null;
      if (body != null)
        msgs = ((InternalEObject)body).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MitraPackage.RULE_DECLARATION__BODY, null, msgs);
      if (newBody != null)
        msgs = ((InternalEObject)newBody).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MitraPackage.RULE_DECLARATION__BODY, null, msgs);
      msgs = basicSetBody(newBody, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MitraPackage.RULE_DECLARATION__BODY, newBody, newBody));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String toString()
  {
    if (eIsProxy()) return super.toString();
    return ToString.valueOf(this);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case MitraPackage.RULE_DECLARATION__ANNOTATIONS:
        return ((InternalEList<?>)getAnnotations()).basicRemove(otherEnd, msgs);
      case MitraPackage.RULE_DECLARATION__FORMAL_PARAMETERS:
        return ((InternalEList<?>)getFormalParameters()).basicRemove(otherEnd, msgs);
      case MitraPackage.RULE_DECLARATION__RETURN_PARAMETERS:
        return ((InternalEList<?>)getReturnParameters()).basicRemove(otherEnd, msgs);
      case MitraPackage.RULE_DECLARATION__IMPLEMENTED_RULES:
        return ((InternalEList<?>)getImplementedRules()).basicRemove(otherEnd, msgs);
      case MitraPackage.RULE_DECLARATION__OVERRIDDEN_RULE:
        return basicSetOverriddenRule(null, msgs);
      case MitraPackage.RULE_DECLARATION__EXCLUDING_RULES:
        return ((InternalEList<?>)getExcludingRules()).basicRemove(otherEnd, msgs);
      case MitraPackage.RULE_DECLARATION__TRIGGER:
        return basicSetTrigger(null, msgs);
      case MitraPackage.RULE_DECLARATION__JAVA_SPEC:
        return basicSetJavaSpec(null, msgs);
      case MitraPackage.RULE_DECLARATION__BODY:
        return basicSetBody(null, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
    switch (featureID)
    {
      case MitraPackage.RULE_DECLARATION__ANNOTATIONS:
        return getAnnotations();
      case MitraPackage.RULE_DECLARATION__VISIBILITY:
        return getVisibility();
      case MitraPackage.RULE_DECLARATION__EXEC:
        return getExec();
      case MitraPackage.RULE_DECLARATION__TRACED:
        return isTraced();
      case MitraPackage.RULE_DECLARATION__STEALTH:
        return isStealth();
      case MitraPackage.RULE_DECLARATION__VIRTUAL:
        return isVirtual();
      case MitraPackage.RULE_DECLARATION__MULTI:
        return isMulti();
      case MitraPackage.RULE_DECLARATION__NAME:
        return getName();
      case MitraPackage.RULE_DECLARATION__FORMAL_PARAMETERS:
        return getFormalParameters();
      case MitraPackage.RULE_DECLARATION__RETURN_PARAMETERS:
        return getReturnParameters();
      case MitraPackage.RULE_DECLARATION__IMPLEMENTED_RULES:
        return getImplementedRules();
      case MitraPackage.RULE_DECLARATION__OVERRIDDEN_RULE:
        return getOverriddenRule();
      case MitraPackage.RULE_DECLARATION__EXCLUDING_RULES:
        return getExcludingRules();
      case MitraPackage.RULE_DECLARATION__TRIGGER:
        return getTrigger();
      case MitraPackage.RULE_DECLARATION__JAVA_SPEC:
        return getJavaSpec();
      case MitraPackage.RULE_DECLARATION__BODY:
        return getBody();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @SuppressWarnings("unchecked")
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case MitraPackage.RULE_DECLARATION__ANNOTATIONS:
        getAnnotations().clear();
        getAnnotations().addAll((Collection<? extends Annotation>)newValue);
        return;
      case MitraPackage.RULE_DECLARATION__VISIBILITY:
        setVisibility((VisibilityModifier)newValue);
        return;
      case MitraPackage.RULE_DECLARATION__EXEC:
        setExec((ExecutionModifier)newValue);
        return;
      case MitraPackage.RULE_DECLARATION__TRACED:
        setTraced((Boolean)newValue);
        return;
      case MitraPackage.RULE_DECLARATION__STEALTH:
        setStealth((Boolean)newValue);
        return;
      case MitraPackage.RULE_DECLARATION__VIRTUAL:
        setVirtual((Boolean)newValue);
        return;
      case MitraPackage.RULE_DECLARATION__MULTI:
        setMulti((Boolean)newValue);
        return;
      case MitraPackage.RULE_DECLARATION__NAME:
        setName((String)newValue);
        return;
      case MitraPackage.RULE_DECLARATION__FORMAL_PARAMETERS:
        getFormalParameters().clear();
        getFormalParameters().addAll((Collection<? extends FormalParameter>)newValue);
        return;
      case MitraPackage.RULE_DECLARATION__RETURN_PARAMETERS:
        getReturnParameters().clear();
        getReturnParameters().addAll((Collection<? extends ReturnParameter>)newValue);
        return;
      case MitraPackage.RULE_DECLARATION__IMPLEMENTED_RULES:
        getImplementedRules().clear();
        getImplementedRules().addAll((Collection<? extends SimpleRuleReference>)newValue);
        return;
      case MitraPackage.RULE_DECLARATION__OVERRIDDEN_RULE:
        setOverriddenRule((SimpleRuleReference)newValue);
        return;
      case MitraPackage.RULE_DECLARATION__EXCLUDING_RULES:
        getExcludingRules().clear();
        getExcludingRules().addAll((Collection<? extends SimpleRuleReference>)newValue);
        return;
      case MitraPackage.RULE_DECLARATION__TRIGGER:
        setTrigger((Trigger)newValue);
        return;
      case MitraPackage.RULE_DECLARATION__JAVA_SPEC:
        setJavaSpec((JavaSpec)newValue);
        return;
      case MitraPackage.RULE_DECLARATION__BODY:
        setBody((Block)newValue);
        return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eUnset(int featureID)
  {
    switch (featureID)
    {
      case MitraPackage.RULE_DECLARATION__ANNOTATIONS:
        getAnnotations().clear();
        return;
      case MitraPackage.RULE_DECLARATION__VISIBILITY:
        setVisibility(VISIBILITY_EDEFAULT);
        return;
      case MitraPackage.RULE_DECLARATION__EXEC:
        setExec(EXEC_EDEFAULT);
        return;
      case MitraPackage.RULE_DECLARATION__TRACED:
        setTraced(TRACED_EDEFAULT);
        return;
      case MitraPackage.RULE_DECLARATION__STEALTH:
        setStealth(STEALTH_EDEFAULT);
        return;
      case MitraPackage.RULE_DECLARATION__VIRTUAL:
        setVirtual(VIRTUAL_EDEFAULT);
        return;
      case MitraPackage.RULE_DECLARATION__MULTI:
        setMulti(MULTI_EDEFAULT);
        return;
      case MitraPackage.RULE_DECLARATION__NAME:
        setName(NAME_EDEFAULT);
        return;
      case MitraPackage.RULE_DECLARATION__FORMAL_PARAMETERS:
        getFormalParameters().clear();
        return;
      case MitraPackage.RULE_DECLARATION__RETURN_PARAMETERS:
        getReturnParameters().clear();
        return;
      case MitraPackage.RULE_DECLARATION__IMPLEMENTED_RULES:
        getImplementedRules().clear();
        return;
      case MitraPackage.RULE_DECLARATION__OVERRIDDEN_RULE:
        setOverriddenRule((SimpleRuleReference)null);
        return;
      case MitraPackage.RULE_DECLARATION__EXCLUDING_RULES:
        getExcludingRules().clear();
        return;
      case MitraPackage.RULE_DECLARATION__TRIGGER:
        setTrigger((Trigger)null);
        return;
      case MitraPackage.RULE_DECLARATION__JAVA_SPEC:
        setJavaSpec((JavaSpec)null);
        return;
      case MitraPackage.RULE_DECLARATION__BODY:
        setBody((Block)null);
        return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean eIsSet(int featureID)
  {
    switch (featureID)
    {
      case MitraPackage.RULE_DECLARATION__ANNOTATIONS:
        return annotations != null && !annotations.isEmpty();
      case MitraPackage.RULE_DECLARATION__VISIBILITY:
        return visibility != VISIBILITY_EDEFAULT;
      case MitraPackage.RULE_DECLARATION__EXEC:
        return exec != EXEC_EDEFAULT;
      case MitraPackage.RULE_DECLARATION__TRACED:
        return traced != TRACED_EDEFAULT;
      case MitraPackage.RULE_DECLARATION__STEALTH:
        return stealth != STEALTH_EDEFAULT;
      case MitraPackage.RULE_DECLARATION__VIRTUAL:
        return virtual != VIRTUAL_EDEFAULT;
      case MitraPackage.RULE_DECLARATION__MULTI:
        return multi != MULTI_EDEFAULT;
      case MitraPackage.RULE_DECLARATION__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case MitraPackage.RULE_DECLARATION__FORMAL_PARAMETERS:
        return formalParameters != null && !formalParameters.isEmpty();
      case MitraPackage.RULE_DECLARATION__RETURN_PARAMETERS:
        return returnParameters != null && !returnParameters.isEmpty();
      case MitraPackage.RULE_DECLARATION__IMPLEMENTED_RULES:
        return implementedRules != null && !implementedRules.isEmpty();
      case MitraPackage.RULE_DECLARATION__OVERRIDDEN_RULE:
        return overriddenRule != null;
      case MitraPackage.RULE_DECLARATION__EXCLUDING_RULES:
        return excludingRules != null && !excludingRules.isEmpty();
      case MitraPackage.RULE_DECLARATION__TRIGGER:
        return trigger != null;
      case MitraPackage.RULE_DECLARATION__JAVA_SPEC:
        return javaSpec != null;
      case MitraPackage.RULE_DECLARATION__BODY:
        return body != null;
    }
    return super.eIsSet(featureID);
  }

} //RuleDeclarationImpl
