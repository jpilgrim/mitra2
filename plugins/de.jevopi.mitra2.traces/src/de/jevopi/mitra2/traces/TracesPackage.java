/**
 * (C) 2012 Jens von Pilgrim
 */
package de.jevopi.mitra2.traces;

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
 * @see de.jevopi.mitra2.traces.TracesFactory
 * @model kind="package"
 * @generated
 */
public interface TracesPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "traces";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://mitra2.jevopi.de/traces";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "de.jevopi.mitra2.traces";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	TracesPackage eINSTANCE = de.jevopi.mitra2.traces.impl.TracesPackageImpl.init();

	/**
	 * The meta object id for the '{@link de.jevopi.mitra2.traces.impl.TraceRecordImpl <em>Trace Record</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.jevopi.mitra2.traces.impl.TraceRecordImpl
	 * @see de.jevopi.mitra2.traces.impl.TracesPackageImpl#getTraceRecord()
	 * @generated
	 */
	int TRACE_RECORD = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE_RECORD__NAME = 0;

	/**
	 * The feature id for the '<em><b>Traces</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE_RECORD__TRACES = 1;

	/**
	 * The feature id for the '<em><b>Models</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE_RECORD__MODELS = 2;

	/**
	 * The number of structural features of the '<em>Trace Record</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE_RECORD_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link de.jevopi.mitra2.traces.impl.TraceImpl <em>Trace</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.jevopi.mitra2.traces.impl.TraceImpl
	 * @see de.jevopi.mitra2.traces.impl.TracesPackageImpl#getTrace()
	 * @generated
	 */
	int TRACE = 1;

	/**
	 * The feature id for the '<em><b>Timestamp</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE__TIMESTAMP = 0;

	/**
	 * The feature id for the '<em><b>Rule Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE__RULE_NAME = 1;

	/**
	 * The feature id for the '<em><b>Elements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE__ELEMENTS = 2;

	/**
	 * The feature id for the '<em><b>Rule Info</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE__RULE_INFO = 3;

	/**
	 * The number of structural features of the '<em>Trace</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link de.jevopi.mitra2.traces.impl.TraceElementImpl <em>Trace Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.jevopi.mitra2.traces.impl.TraceElementImpl
	 * @see de.jevopi.mitra2.traces.impl.TracesPackageImpl#getTraceElement()
	 * @generated
	 */
	int TRACE_ELEMENT = 2;

	/**
	 * The feature id for the '<em><b>Trace Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE_ELEMENT__TRACE_TYPE = 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE_ELEMENT__VALUE = 1;

	/**
	 * The feature id for the '<em><b>Type Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE_ELEMENT__TYPE_NAME = 2;

	/**
	 * The feature id for the '<em><b>Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE_ELEMENT__ELEMENT = 3;

	/**
	 * The number of structural features of the '<em>Trace Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE_ELEMENT_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link de.jevopi.mitra2.traces.impl.ModelImpl <em>Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.jevopi.mitra2.traces.impl.ModelImpl
	 * @see de.jevopi.mitra2.traces.impl.TracesPackageImpl#getModel()
	 * @generated
	 */
	int MODEL = 3;

	/**
	 * The feature id for the '<em><b>Uri Model</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL__URI_MODEL = 0;

	/**
	 * The feature id for the '<em><b>Model Root</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL__MODEL_ROOT = 1;

	/**
	 * The number of structural features of the '<em>Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link de.jevopi.mitra2.traces.ParameterType <em>Parameter Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.jevopi.mitra2.traces.ParameterType
	 * @see de.jevopi.mitra2.traces.impl.TracesPackageImpl#getParameterType()
	 * @generated
	 */
	int PARAMETER_TYPE = 4;


	/**
	 * Returns the meta object for class '{@link de.jevopi.mitra2.traces.TraceRecord <em>Trace Record</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Trace Record</em>'.
	 * @see de.jevopi.mitra2.traces.TraceRecord
	 * @generated
	 */
	EClass getTraceRecord();

	/**
	 * Returns the meta object for the attribute '{@link de.jevopi.mitra2.traces.TraceRecord#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see de.jevopi.mitra2.traces.TraceRecord#getName()
	 * @see #getTraceRecord()
	 * @generated
	 */
	EAttribute getTraceRecord_Name();

	/**
	 * Returns the meta object for the containment reference list '{@link de.jevopi.mitra2.traces.TraceRecord#getTraces <em>Traces</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Traces</em>'.
	 * @see de.jevopi.mitra2.traces.TraceRecord#getTraces()
	 * @see #getTraceRecord()
	 * @generated
	 */
	EReference getTraceRecord_Traces();

	/**
	 * Returns the meta object for the containment reference list '{@link de.jevopi.mitra2.traces.TraceRecord#getModels <em>Models</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Models</em>'.
	 * @see de.jevopi.mitra2.traces.TraceRecord#getModels()
	 * @see #getTraceRecord()
	 * @generated
	 */
	EReference getTraceRecord_Models();

	/**
	 * Returns the meta object for class '{@link de.jevopi.mitra2.traces.Trace <em>Trace</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Trace</em>'.
	 * @see de.jevopi.mitra2.traces.Trace
	 * @generated
	 */
	EClass getTrace();

	/**
	 * Returns the meta object for the attribute '{@link de.jevopi.mitra2.traces.Trace#getTimestamp <em>Timestamp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Timestamp</em>'.
	 * @see de.jevopi.mitra2.traces.Trace#getTimestamp()
	 * @see #getTrace()
	 * @generated
	 */
	EAttribute getTrace_Timestamp();

	/**
	 * Returns the meta object for the attribute '{@link de.jevopi.mitra2.traces.Trace#getRuleName <em>Rule Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Rule Name</em>'.
	 * @see de.jevopi.mitra2.traces.Trace#getRuleName()
	 * @see #getTrace()
	 * @generated
	 */
	EAttribute getTrace_RuleName();

	/**
	 * Returns the meta object for the containment reference list '{@link de.jevopi.mitra2.traces.Trace#getElements <em>Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Elements</em>'.
	 * @see de.jevopi.mitra2.traces.Trace#getElements()
	 * @see #getTrace()
	 * @generated
	 */
	EReference getTrace_Elements();

	/**
	 * Returns the meta object for the attribute '{@link de.jevopi.mitra2.traces.Trace#getRuleInfo <em>Rule Info</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Rule Info</em>'.
	 * @see de.jevopi.mitra2.traces.Trace#getRuleInfo()
	 * @see #getTrace()
	 * @generated
	 */
	EAttribute getTrace_RuleInfo();

	/**
	 * Returns the meta object for class '{@link de.jevopi.mitra2.traces.TraceElement <em>Trace Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Trace Element</em>'.
	 * @see de.jevopi.mitra2.traces.TraceElement
	 * @generated
	 */
	EClass getTraceElement();

	/**
	 * Returns the meta object for the attribute '{@link de.jevopi.mitra2.traces.TraceElement#getTraceType <em>Trace Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Trace Type</em>'.
	 * @see de.jevopi.mitra2.traces.TraceElement#getTraceType()
	 * @see #getTraceElement()
	 * @generated
	 */
	EAttribute getTraceElement_TraceType();

	/**
	 * Returns the meta object for the attribute '{@link de.jevopi.mitra2.traces.TraceElement#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see de.jevopi.mitra2.traces.TraceElement#getValue()
	 * @see #getTraceElement()
	 * @generated
	 */
	EAttribute getTraceElement_Value();

	/**
	 * Returns the meta object for the attribute '{@link de.jevopi.mitra2.traces.TraceElement#getTypeName <em>Type Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type Name</em>'.
	 * @see de.jevopi.mitra2.traces.TraceElement#getTypeName()
	 * @see #getTraceElement()
	 * @generated
	 */
	EAttribute getTraceElement_TypeName();

	/**
	 * Returns the meta object for the reference '{@link de.jevopi.mitra2.traces.TraceElement#getElement <em>Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Element</em>'.
	 * @see de.jevopi.mitra2.traces.TraceElement#getElement()
	 * @see #getTraceElement()
	 * @generated
	 */
	EReference getTraceElement_Element();

	/**
	 * Returns the meta object for class '{@link de.jevopi.mitra2.traces.Model <em>Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Model</em>'.
	 * @see de.jevopi.mitra2.traces.Model
	 * @generated
	 */
	EClass getModel();

	/**
	 * Returns the meta object for the attribute '{@link de.jevopi.mitra2.traces.Model#getUriModel <em>Uri Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Uri Model</em>'.
	 * @see de.jevopi.mitra2.traces.Model#getUriModel()
	 * @see #getModel()
	 * @generated
	 */
	EAttribute getModel_UriModel();

	/**
	 * Returns the meta object for the reference '{@link de.jevopi.mitra2.traces.Model#getModelRoot <em>Model Root</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Model Root</em>'.
	 * @see de.jevopi.mitra2.traces.Model#getModelRoot()
	 * @see #getModel()
	 * @generated
	 */
	EReference getModel_ModelRoot();

	/**
	 * Returns the meta object for enum '{@link de.jevopi.mitra2.traces.ParameterType <em>Parameter Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Parameter Type</em>'.
	 * @see de.jevopi.mitra2.traces.ParameterType
	 * @generated
	 */
	EEnum getParameterType();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	TracesFactory getTracesFactory();

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
	interface Literals {
		/**
		 * The meta object literal for the '{@link de.jevopi.mitra2.traces.impl.TraceRecordImpl <em>Trace Record</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.jevopi.mitra2.traces.impl.TraceRecordImpl
		 * @see de.jevopi.mitra2.traces.impl.TracesPackageImpl#getTraceRecord()
		 * @generated
		 */
		EClass TRACE_RECORD = eINSTANCE.getTraceRecord();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TRACE_RECORD__NAME = eINSTANCE.getTraceRecord_Name();

		/**
		 * The meta object literal for the '<em><b>Traces</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRACE_RECORD__TRACES = eINSTANCE.getTraceRecord_Traces();

		/**
		 * The meta object literal for the '<em><b>Models</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRACE_RECORD__MODELS = eINSTANCE.getTraceRecord_Models();

		/**
		 * The meta object literal for the '{@link de.jevopi.mitra2.traces.impl.TraceImpl <em>Trace</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.jevopi.mitra2.traces.impl.TraceImpl
		 * @see de.jevopi.mitra2.traces.impl.TracesPackageImpl#getTrace()
		 * @generated
		 */
		EClass TRACE = eINSTANCE.getTrace();

		/**
		 * The meta object literal for the '<em><b>Timestamp</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TRACE__TIMESTAMP = eINSTANCE.getTrace_Timestamp();

		/**
		 * The meta object literal for the '<em><b>Rule Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TRACE__RULE_NAME = eINSTANCE.getTrace_RuleName();

		/**
		 * The meta object literal for the '<em><b>Elements</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRACE__ELEMENTS = eINSTANCE.getTrace_Elements();

		/**
		 * The meta object literal for the '<em><b>Rule Info</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TRACE__RULE_INFO = eINSTANCE.getTrace_RuleInfo();

		/**
		 * The meta object literal for the '{@link de.jevopi.mitra2.traces.impl.TraceElementImpl <em>Trace Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.jevopi.mitra2.traces.impl.TraceElementImpl
		 * @see de.jevopi.mitra2.traces.impl.TracesPackageImpl#getTraceElement()
		 * @generated
		 */
		EClass TRACE_ELEMENT = eINSTANCE.getTraceElement();

		/**
		 * The meta object literal for the '<em><b>Trace Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TRACE_ELEMENT__TRACE_TYPE = eINSTANCE.getTraceElement_TraceType();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TRACE_ELEMENT__VALUE = eINSTANCE.getTraceElement_Value();

		/**
		 * The meta object literal for the '<em><b>Type Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TRACE_ELEMENT__TYPE_NAME = eINSTANCE.getTraceElement_TypeName();

		/**
		 * The meta object literal for the '<em><b>Element</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRACE_ELEMENT__ELEMENT = eINSTANCE.getTraceElement_Element();

		/**
		 * The meta object literal for the '{@link de.jevopi.mitra2.traces.impl.ModelImpl <em>Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.jevopi.mitra2.traces.impl.ModelImpl
		 * @see de.jevopi.mitra2.traces.impl.TracesPackageImpl#getModel()
		 * @generated
		 */
		EClass MODEL = eINSTANCE.getModel();

		/**
		 * The meta object literal for the '<em><b>Uri Model</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MODEL__URI_MODEL = eINSTANCE.getModel_UriModel();

		/**
		 * The meta object literal for the '<em><b>Model Root</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODEL__MODEL_ROOT = eINSTANCE.getModel_ModelRoot();

		/**
		 * The meta object literal for the '{@link de.jevopi.mitra2.traces.ParameterType <em>Parameter Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.jevopi.mitra2.traces.ParameterType
		 * @see de.jevopi.mitra2.traces.impl.TracesPackageImpl#getParameterType()
		 * @generated
		 */
		EEnum PARAMETER_TYPE = eINSTANCE.getParameterType();

	}

} //TracesPackage
