/**
 */
package de.jevopi.mitra2.mitra.impl;

import de.jevopi.mitra2.mitra.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class MitraFactoryImpl extends EFactoryImpl implements MitraFactory
{
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static MitraFactory init()
  {
    try
    {
      MitraFactory theMitraFactory = (MitraFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.jevopi.de/Mitra"); 
      if (theMitraFactory != null)
      {
        return theMitraFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new MitraFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MitraFactoryImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EObject create(EClass eClass)
  {
    switch (eClass.getClassifierID())
    {
      case MitraPackage.MODULE: return createModule();
      case MitraPackage.MODULE_REFERENCE: return createModuleReference();
      case MitraPackage.METAMODEL_DECLARATION: return createMetamodelDeclaration();
      case MitraPackage.PROPERTY: return createProperty();
      case MitraPackage.RULE_DECLARATION: return createRuleDeclaration();
      case MitraPackage.RULE_REFERENCE: return createRuleReference();
      case MitraPackage.SIMPLE_RULE_REFERENCE: return createSimpleRuleReference();
      case MitraPackage.QUALIFIED_RULE_REFERENCE: return createQualifiedRuleReference();
      case MitraPackage.PARAMETER_REFERENCE: return createParameterReference();
      case MitraPackage.SIMPLE_PARAMETER_REFERENCE: return createSimpleParameterReference();
      case MitraPackage.QUALIFIED_PARAMETER_REFERENCE: return createQualifiedParameterReference();
      case MitraPackage.TRIGGER: return createTrigger();
      case MitraPackage.JAVA_SPEC: return createJavaSpec();
      case MitraPackage.PARAMETER: return createParameter();
      case MitraPackage.FORMAL_PARAMETER: return createFormalParameter();
      case MitraPackage.RETURN_PARAMETER: return createReturnParameter();
      case MitraPackage.TYPE: return createType();
      case MitraPackage.REFERENCE_TYPE: return createReferenceType();
      case MitraPackage.PRIMITIVE_TYPE: return createPrimitiveType();
      case MitraPackage.COLLECTION_TYPE: return createCollectionType();
      case MitraPackage.BLOCK: return createBlock();
      case MitraPackage.BLOCK_STATEMENT: return createBlockStatement();
      case MitraPackage.STATEMENT: return createStatement();
      case MitraPackage.LOCAL_VARIABLE_DECLARATION_STATEMENT: return createLocalVariableDeclarationStatement();
      case MitraPackage.LOCAL_VARIABLE_DECLARATION: return createLocalVariableDeclaration();
      case MitraPackage.VAR_DECLARATION: return createVarDeclaration();
      case MitraPackage.TYPED_VAR_DECLARATION: return createTypedVarDeclaration();
      case MitraPackage.INFERRED_VAR_DECLARATION: return createInferredVarDeclaration();
      case MitraPackage.EXPRESSION_STATEMENT: return createExpressionStatement();
      case MitraPackage.STATEMENT_EXPRESSION: return createStatementExpression();
      case MitraPackage.EMPTY_STATEMENT: return createEmptyStatement();
      case MitraPackage.RETURN_STATEMENT: return createReturnStatement();
      case MitraPackage.IF_STATEMENT: return createIfStatement();
      case MitraPackage.WHILE_STATEMENT: return createWhileStatement();
      case MitraPackage.DO_STATEMENT: return createDoStatement();
      case MitraPackage.FOR_INIT: return createForInit();
      case MitraPackage.FOR_UPDATE: return createForUpdate();
      case MitraPackage.FOR_STATEMENT: return createForStatement();
      case MitraPackage.LOOP_VARIABLE: return createLoopVariable();
      case MitraPackage.BREAK_STATEMENT: return createBreakStatement();
      case MitraPackage.THROW_STATEMENT: return createThrowStatement();
      case MitraPackage.TRY_STATEMENT: return createTryStatement();
      case MitraPackage.CATCH: return createCatch();
      case MitraPackage.EXPRESSION: return createExpression();
      case MitraPackage.TERMINAL_EXPRESSION: return createTerminalExpression();
      case MitraPackage.LITERAL: return createLiteral();
      case MitraPackage.STRING_LITERAL: return createStringLiteral();
      case MitraPackage.INT_LITERAL: return createIntLiteral();
      case MitraPackage.REAL_LITERAL: return createRealLiteral();
      case MitraPackage.BOOLEAN_LITERAL: return createBooleanLiteral();
      case MitraPackage.NULL_LITERAL: return createNullLiteral();
      case MitraPackage.CLASS_INSTANCE_CREATION_EXPRESSION: return createClassInstanceCreationExpression();
      case MitraPackage.RULE_INVOCATION: return createRuleInvocation();
      case MitraPackage.RULE_INVOCATION_SUPER: return createRuleInvocationSuper();
      case MitraPackage.FEATURE: return createFeature();
      case MitraPackage.METHOD_INVOCATION: return createMethodInvocation();
      case MitraPackage.FEATURE_METHOD_INVOCATION: return createFeatureMethodInvocation();
      case MitraPackage.NATIVE_OPERATION_INVOCATION: return createNativeOperationInvocation();
      case MitraPackage.METAMODEL_FEATURE: return createMetamodelFeature();
      case MitraPackage.FEATURE_FIELD: return createFeatureField();
      case MitraPackage.VARIABLE_ACCESS: return createVariableAccess();
      case MitraPackage.STATIC_ACCESS: return createStaticAccess();
      case MitraPackage.ANNOTATIONS_DEFINITION: return createAnnotationsDefinition();
      case MitraPackage.ANNOTATION_DECL: return createAnnotationDecl();
      case MitraPackage.ANNOTATION_PROPERTY_DECL: return createAnnotationPropertyDecl();
      case MitraPackage.ANNOTATION: return createAnnotation();
      case MitraPackage.ANNOTATION_PROPERTY: return createAnnotationProperty();
      case MitraPackage.ASSIGNMENT: return createAssignment();
      case MitraPackage.ITERATOR_EXPRESSION: return createIteratorExpression();
      case MitraPackage.BOOLEAN_EXPRESSION: return createBooleanExpression();
      case MitraPackage.EQUALITY_EXPRESSION: return createEqualityExpression();
      case MitraPackage.RELATIONAL_EXPRESSION: return createRelationalExpression();
      case MitraPackage.MATH_EXPRESSION: return createMathExpression();
      case MitraPackage.UNARY_CAST_EXPRESSION: return createUnaryCastExpression();
      case MitraPackage.UNARY_BOOLEAN_EXPRESSION: return createUnaryBooleanExpression();
      case MitraPackage.UNARY_MATH_EXPRESSION: return createUnaryMathExpression();
      case MitraPackage.INSTANCE_OF_EXPRESSION: return createInstanceOfExpression();
      default:
        throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object createFromString(EDataType eDataType, String initialValue)
  {
    switch (eDataType.getClassifierID())
    {
      case MitraPackage.VISIBILITY_MODIFIER:
        return createVisibilityModifierFromString(eDataType, initialValue);
      case MitraPackage.EXECUTION_MODIFIER:
        return createExecutionModifierFromString(eDataType, initialValue);
      case MitraPackage.PARAMETER_MODIFIER:
        return createParameterModifierFromString(eDataType, initialValue);
      case MitraPackage.PRIMITIVE_TYPE_SPEC:
        return createPrimitiveTypeSpecFromString(eDataType, initialValue);
      case MitraPackage.COLLECTION_TYPE_SPEC:
        return createCollectionTypeSpecFromString(eDataType, initialValue);
      case MitraPackage.BOOLEAN_OPERATOR:
        return createBooleanOperatorFromString(eDataType, initialValue);
      case MitraPackage.EQUALITY_OPERATOR:
        return createEqualityOperatorFromString(eDataType, initialValue);
      case MitraPackage.RELATIONAL_OPERATOR:
        return createRelationalOperatorFromString(eDataType, initialValue);
      case MitraPackage.MATH_OPERATOR:
        return createMathOperatorFromString(eDataType, initialValue);
      case MitraPackage.UNARY_MATH_OPERATOR:
        return createUnaryMathOperatorFromString(eDataType, initialValue);
      case MitraPackage.ASSIGNMENT_OPERATOR:
        return createAssignmentOperatorFromString(eDataType, initialValue);
      case MitraPackage.PP_OPERATOR:
        return createPPOperatorFromString(eDataType, initialValue);
      case MitraPackage.ANNOTATION_TARGET_SPEC:
        return createAnnotationTargetSpecFromString(eDataType, initialValue);
      default:
        throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String convertToString(EDataType eDataType, Object instanceValue)
  {
    switch (eDataType.getClassifierID())
    {
      case MitraPackage.VISIBILITY_MODIFIER:
        return convertVisibilityModifierToString(eDataType, instanceValue);
      case MitraPackage.EXECUTION_MODIFIER:
        return convertExecutionModifierToString(eDataType, instanceValue);
      case MitraPackage.PARAMETER_MODIFIER:
        return convertParameterModifierToString(eDataType, instanceValue);
      case MitraPackage.PRIMITIVE_TYPE_SPEC:
        return convertPrimitiveTypeSpecToString(eDataType, instanceValue);
      case MitraPackage.COLLECTION_TYPE_SPEC:
        return convertCollectionTypeSpecToString(eDataType, instanceValue);
      case MitraPackage.BOOLEAN_OPERATOR:
        return convertBooleanOperatorToString(eDataType, instanceValue);
      case MitraPackage.EQUALITY_OPERATOR:
        return convertEqualityOperatorToString(eDataType, instanceValue);
      case MitraPackage.RELATIONAL_OPERATOR:
        return convertRelationalOperatorToString(eDataType, instanceValue);
      case MitraPackage.MATH_OPERATOR:
        return convertMathOperatorToString(eDataType, instanceValue);
      case MitraPackage.UNARY_MATH_OPERATOR:
        return convertUnaryMathOperatorToString(eDataType, instanceValue);
      case MitraPackage.ASSIGNMENT_OPERATOR:
        return convertAssignmentOperatorToString(eDataType, instanceValue);
      case MitraPackage.PP_OPERATOR:
        return convertPPOperatorToString(eDataType, instanceValue);
      case MitraPackage.ANNOTATION_TARGET_SPEC:
        return convertAnnotationTargetSpecToString(eDataType, instanceValue);
      default:
        throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Module createModule()
  {
    ModuleImpl module = new ModuleImpl();
    return module;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ModuleReference createModuleReference()
  {
    ModuleReferenceImpl moduleReference = new ModuleReferenceImpl();
    return moduleReference;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MetamodelDeclaration createMetamodelDeclaration()
  {
    MetamodelDeclarationImpl metamodelDeclaration = new MetamodelDeclarationImpl();
    return metamodelDeclaration;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Property createProperty()
  {
    PropertyImpl property = new PropertyImpl();
    return property;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RuleDeclaration createRuleDeclaration()
  {
    RuleDeclarationImpl ruleDeclaration = new RuleDeclarationImpl();
    return ruleDeclaration;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RuleReference createRuleReference()
  {
    RuleReferenceImpl ruleReference = new RuleReferenceImpl();
    return ruleReference;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SimpleRuleReference createSimpleRuleReference()
  {
    SimpleRuleReferenceImpl simpleRuleReference = new SimpleRuleReferenceImpl();
    return simpleRuleReference;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public QualifiedRuleReference createQualifiedRuleReference()
  {
    QualifiedRuleReferenceImpl qualifiedRuleReference = new QualifiedRuleReferenceImpl();
    return qualifiedRuleReference;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ParameterReference createParameterReference()
  {
    ParameterReferenceImpl parameterReference = new ParameterReferenceImpl();
    return parameterReference;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SimpleParameterReference createSimpleParameterReference()
  {
    SimpleParameterReferenceImpl simpleParameterReference = new SimpleParameterReferenceImpl();
    return simpleParameterReference;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public QualifiedParameterReference createQualifiedParameterReference()
  {
    QualifiedParameterReferenceImpl qualifiedParameterReference = new QualifiedParameterReferenceImpl();
    return qualifiedParameterReference;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Trigger createTrigger()
  {
    TriggerImpl trigger = new TriggerImpl();
    return trigger;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public JavaSpec createJavaSpec()
  {
    JavaSpecImpl javaSpec = new JavaSpecImpl();
    return javaSpec;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Parameter createParameter()
  {
    ParameterImpl parameter = new ParameterImpl();
    return parameter;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public FormalParameter createFormalParameter()
  {
    FormalParameterImpl formalParameter = new FormalParameterImpl();
    return formalParameter;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ReturnParameter createReturnParameter()
  {
    ReturnParameterImpl returnParameter = new ReturnParameterImpl();
    return returnParameter;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Type createType()
  {
    TypeImpl type = new TypeImpl();
    return type;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ReferenceType createReferenceType()
  {
    ReferenceTypeImpl referenceType = new ReferenceTypeImpl();
    return referenceType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PrimitiveType createPrimitiveType()
  {
    PrimitiveTypeImpl primitiveType = new PrimitiveTypeImpl();
    return primitiveType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public CollectionType createCollectionType()
  {
    CollectionTypeImpl collectionType = new CollectionTypeImpl();
    return collectionType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Block createBlock()
  {
    BlockImpl block = new BlockImpl();
    return block;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public BlockStatement createBlockStatement()
  {
    BlockStatementImpl blockStatement = new BlockStatementImpl();
    return blockStatement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Statement createStatement()
  {
    StatementImpl statement = new StatementImpl();
    return statement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public LocalVariableDeclarationStatement createLocalVariableDeclarationStatement()
  {
    LocalVariableDeclarationStatementImpl localVariableDeclarationStatement = new LocalVariableDeclarationStatementImpl();
    return localVariableDeclarationStatement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public LocalVariableDeclaration createLocalVariableDeclaration()
  {
    LocalVariableDeclarationImpl localVariableDeclaration = new LocalVariableDeclarationImpl();
    return localVariableDeclaration;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public VarDeclaration createVarDeclaration()
  {
    VarDeclarationImpl varDeclaration = new VarDeclarationImpl();
    return varDeclaration;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TypedVarDeclaration createTypedVarDeclaration()
  {
    TypedVarDeclarationImpl typedVarDeclaration = new TypedVarDeclarationImpl();
    return typedVarDeclaration;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public InferredVarDeclaration createInferredVarDeclaration()
  {
    InferredVarDeclarationImpl inferredVarDeclaration = new InferredVarDeclarationImpl();
    return inferredVarDeclaration;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ExpressionStatement createExpressionStatement()
  {
    ExpressionStatementImpl expressionStatement = new ExpressionStatementImpl();
    return expressionStatement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public StatementExpression createStatementExpression()
  {
    StatementExpressionImpl statementExpression = new StatementExpressionImpl();
    return statementExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EmptyStatement createEmptyStatement()
  {
    EmptyStatementImpl emptyStatement = new EmptyStatementImpl();
    return emptyStatement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ReturnStatement createReturnStatement()
  {
    ReturnStatementImpl returnStatement = new ReturnStatementImpl();
    return returnStatement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public IfStatement createIfStatement()
  {
    IfStatementImpl ifStatement = new IfStatementImpl();
    return ifStatement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public WhileStatement createWhileStatement()
  {
    WhileStatementImpl whileStatement = new WhileStatementImpl();
    return whileStatement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DoStatement createDoStatement()
  {
    DoStatementImpl doStatement = new DoStatementImpl();
    return doStatement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ForInit createForInit()
  {
    ForInitImpl forInit = new ForInitImpl();
    return forInit;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ForUpdate createForUpdate()
  {
    ForUpdateImpl forUpdate = new ForUpdateImpl();
    return forUpdate;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ForStatement createForStatement()
  {
    ForStatementImpl forStatement = new ForStatementImpl();
    return forStatement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public LoopVariable createLoopVariable()
  {
    LoopVariableImpl loopVariable = new LoopVariableImpl();
    return loopVariable;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public BreakStatement createBreakStatement()
  {
    BreakStatementImpl breakStatement = new BreakStatementImpl();
    return breakStatement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ThrowStatement createThrowStatement()
  {
    ThrowStatementImpl throwStatement = new ThrowStatementImpl();
    return throwStatement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TryStatement createTryStatement()
  {
    TryStatementImpl tryStatement = new TryStatementImpl();
    return tryStatement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Catch createCatch()
  {
    CatchImpl catch_ = new CatchImpl();
    return catch_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Expression createExpression()
  {
    ExpressionImpl expression = new ExpressionImpl();
    return expression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TerminalExpression createTerminalExpression()
  {
    TerminalExpressionImpl terminalExpression = new TerminalExpressionImpl();
    return terminalExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Literal createLiteral()
  {
    LiteralImpl literal = new LiteralImpl();
    return literal;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public StringLiteral createStringLiteral()
  {
    StringLiteralImpl stringLiteral = new StringLiteralImpl();
    return stringLiteral;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public IntLiteral createIntLiteral()
  {
    IntLiteralImpl intLiteral = new IntLiteralImpl();
    return intLiteral;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RealLiteral createRealLiteral()
  {
    RealLiteralImpl realLiteral = new RealLiteralImpl();
    return realLiteral;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public BooleanLiteral createBooleanLiteral()
  {
    BooleanLiteralImpl booleanLiteral = new BooleanLiteralImpl();
    return booleanLiteral;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NullLiteral createNullLiteral()
  {
    NullLiteralImpl nullLiteral = new NullLiteralImpl();
    return nullLiteral;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ClassInstanceCreationExpression createClassInstanceCreationExpression()
  {
    ClassInstanceCreationExpressionImpl classInstanceCreationExpression = new ClassInstanceCreationExpressionImpl();
    return classInstanceCreationExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RuleInvocation createRuleInvocation()
  {
    RuleInvocationImpl ruleInvocation = new RuleInvocationImpl();
    return ruleInvocation;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RuleInvocationSuper createRuleInvocationSuper()
  {
    RuleInvocationSuperImpl ruleInvocationSuper = new RuleInvocationSuperImpl();
    return ruleInvocationSuper;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Feature createFeature()
  {
    FeatureImpl feature = new FeatureImpl();
    return feature;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MethodInvocation createMethodInvocation()
  {
    MethodInvocationImpl methodInvocation = new MethodInvocationImpl();
    return methodInvocation;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public FeatureMethodInvocation createFeatureMethodInvocation()
  {
    FeatureMethodInvocationImpl featureMethodInvocation = new FeatureMethodInvocationImpl();
    return featureMethodInvocation;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NativeOperationInvocation createNativeOperationInvocation()
  {
    NativeOperationInvocationImpl nativeOperationInvocation = new NativeOperationInvocationImpl();
    return nativeOperationInvocation;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MetamodelFeature createMetamodelFeature()
  {
    MetamodelFeatureImpl metamodelFeature = new MetamodelFeatureImpl();
    return metamodelFeature;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public FeatureField createFeatureField()
  {
    FeatureFieldImpl featureField = new FeatureFieldImpl();
    return featureField;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public VariableAccess createVariableAccess()
  {
    VariableAccessImpl variableAccess = new VariableAccessImpl();
    return variableAccess;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public StaticAccess createStaticAccess()
  {
    StaticAccessImpl staticAccess = new StaticAccessImpl();
    return staticAccess;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AnnotationsDefinition createAnnotationsDefinition()
  {
    AnnotationsDefinitionImpl annotationsDefinition = new AnnotationsDefinitionImpl();
    return annotationsDefinition;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AnnotationDecl createAnnotationDecl()
  {
    AnnotationDeclImpl annotationDecl = new AnnotationDeclImpl();
    return annotationDecl;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AnnotationPropertyDecl createAnnotationPropertyDecl()
  {
    AnnotationPropertyDeclImpl annotationPropertyDecl = new AnnotationPropertyDeclImpl();
    return annotationPropertyDecl;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Annotation createAnnotation()
  {
    AnnotationImpl annotation = new AnnotationImpl();
    return annotation;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AnnotationProperty createAnnotationProperty()
  {
    AnnotationPropertyImpl annotationProperty = new AnnotationPropertyImpl();
    return annotationProperty;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Assignment createAssignment()
  {
    AssignmentImpl assignment = new AssignmentImpl();
    return assignment;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public IteratorExpression createIteratorExpression()
  {
    IteratorExpressionImpl iteratorExpression = new IteratorExpressionImpl();
    return iteratorExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public BooleanExpression createBooleanExpression()
  {
    BooleanExpressionImpl booleanExpression = new BooleanExpressionImpl();
    return booleanExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EqualityExpression createEqualityExpression()
  {
    EqualityExpressionImpl equalityExpression = new EqualityExpressionImpl();
    return equalityExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RelationalExpression createRelationalExpression()
  {
    RelationalExpressionImpl relationalExpression = new RelationalExpressionImpl();
    return relationalExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MathExpression createMathExpression()
  {
    MathExpressionImpl mathExpression = new MathExpressionImpl();
    return mathExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public UnaryCastExpression createUnaryCastExpression()
  {
    UnaryCastExpressionImpl unaryCastExpression = new UnaryCastExpressionImpl();
    return unaryCastExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public UnaryBooleanExpression createUnaryBooleanExpression()
  {
    UnaryBooleanExpressionImpl unaryBooleanExpression = new UnaryBooleanExpressionImpl();
    return unaryBooleanExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public UnaryMathExpression createUnaryMathExpression()
  {
    UnaryMathExpressionImpl unaryMathExpression = new UnaryMathExpressionImpl();
    return unaryMathExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public InstanceOfExpression createInstanceOfExpression()
  {
    InstanceOfExpressionImpl instanceOfExpression = new InstanceOfExpressionImpl();
    return instanceOfExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public VisibilityModifier createVisibilityModifierFromString(EDataType eDataType, String initialValue)
  {
    VisibilityModifier result = VisibilityModifier.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertVisibilityModifierToString(EDataType eDataType, Object instanceValue)
  {
    return instanceValue == null ? null : instanceValue.toString();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ExecutionModifier createExecutionModifierFromString(EDataType eDataType, String initialValue)
  {
    ExecutionModifier result = ExecutionModifier.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertExecutionModifierToString(EDataType eDataType, Object instanceValue)
  {
    return instanceValue == null ? null : instanceValue.toString();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ParameterModifier createParameterModifierFromString(EDataType eDataType, String initialValue)
  {
    ParameterModifier result = ParameterModifier.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertParameterModifierToString(EDataType eDataType, Object instanceValue)
  {
    return instanceValue == null ? null : instanceValue.toString();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PrimitiveTypeSpec createPrimitiveTypeSpecFromString(EDataType eDataType, String initialValue)
  {
    PrimitiveTypeSpec result = PrimitiveTypeSpec.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertPrimitiveTypeSpecToString(EDataType eDataType, Object instanceValue)
  {
    return instanceValue == null ? null : instanceValue.toString();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public CollectionTypeSpec createCollectionTypeSpecFromString(EDataType eDataType, String initialValue)
  {
    CollectionTypeSpec result = CollectionTypeSpec.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertCollectionTypeSpecToString(EDataType eDataType, Object instanceValue)
  {
    return instanceValue == null ? null : instanceValue.toString();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public BooleanOperator createBooleanOperatorFromString(EDataType eDataType, String initialValue)
  {
    BooleanOperator result = BooleanOperator.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertBooleanOperatorToString(EDataType eDataType, Object instanceValue)
  {
    return instanceValue == null ? null : instanceValue.toString();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EqualityOperator createEqualityOperatorFromString(EDataType eDataType, String initialValue)
  {
    EqualityOperator result = EqualityOperator.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertEqualityOperatorToString(EDataType eDataType, Object instanceValue)
  {
    return instanceValue == null ? null : instanceValue.toString();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RelationalOperator createRelationalOperatorFromString(EDataType eDataType, String initialValue)
  {
    RelationalOperator result = RelationalOperator.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertRelationalOperatorToString(EDataType eDataType, Object instanceValue)
  {
    return instanceValue == null ? null : instanceValue.toString();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MathOperator createMathOperatorFromString(EDataType eDataType, String initialValue)
  {
    MathOperator result = MathOperator.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertMathOperatorToString(EDataType eDataType, Object instanceValue)
  {
    return instanceValue == null ? null : instanceValue.toString();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public UnaryMathOperator createUnaryMathOperatorFromString(EDataType eDataType, String initialValue)
  {
    UnaryMathOperator result = UnaryMathOperator.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertUnaryMathOperatorToString(EDataType eDataType, Object instanceValue)
  {
    return instanceValue == null ? null : instanceValue.toString();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AssignmentOperator createAssignmentOperatorFromString(EDataType eDataType, String initialValue)
  {
    AssignmentOperator result = AssignmentOperator.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertAssignmentOperatorToString(EDataType eDataType, Object instanceValue)
  {
    return instanceValue == null ? null : instanceValue.toString();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PPOperator createPPOperatorFromString(EDataType eDataType, String initialValue)
  {
    PPOperator result = PPOperator.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertPPOperatorToString(EDataType eDataType, Object instanceValue)
  {
    return instanceValue == null ? null : instanceValue.toString();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AnnotationTargetSpec createAnnotationTargetSpecFromString(EDataType eDataType, String initialValue)
  {
    AnnotationTargetSpec result = AnnotationTargetSpec.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertAnnotationTargetSpecToString(EDataType eDataType, Object instanceValue)
  {
    return instanceValue == null ? null : instanceValue.toString();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MitraPackage getMitraPackage()
  {
    return (MitraPackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static MitraPackage getPackage()
  {
    return MitraPackage.eINSTANCE;
  }

} //MitraFactoryImpl
