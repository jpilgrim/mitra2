package de.jevopi.mitra2.engine.interpreter;

import static de.jevopi.mitra2.MitraUtils.retrieveContainingRule;

import org.eclipse.emf.ecore.EObject;

import de.jevopi.mitra2.metamodel.IMetamodel;
import de.jevopi.mitra2.metamodel.MObject;
import de.jevopi.mitra2.metamodel.MetamodelManager;
import de.jevopi.mitra2.mitra.FormalParameter;
import de.jevopi.mitra2.mitra.Parameter;
import de.jevopi.mitra2.mitra.ReturnParameter;
import de.jevopi.mitra2.traces.ParameterType;
import de.jevopi.mitra2.traces.TraceElement;
import de.jevopi.mitra2.traces.TracesFactory;

public class TracePolicy extends ExecutionPolicy {

	public TracePolicy(Interpreter host) {
		super(host);
	}

	/**
	 * @param fpar
	 * @param value
	 * @return
	 */
	public TraceElement createTraceElement(Parameter fpar, MObject value) {
		TraceElement traceElement =
			TracesFactory.eINSTANCE.createTraceElement();
		// name is only set for info purposes, cannot be used later
		// in trigger since names may be changed

		traceElement.setTypeName(value.getActualType().toString());
		if (fpar instanceof ReturnParameter) {
			traceElement.setTraceType(ParameterType.TARGET);
		} else { // FormalParameter:
			switch (((FormalParameter) fpar).getModifier()) {
			case FROM:
				traceElement.setTraceType(ParameterType.SOURCE);
				break;
			default: // case NULL:
				// TODO maybe evaluate container model to
				// automatically resolve target or source model
				traceElement.setTraceType(ParameterType.USED);
			} // end switch
		}

		IMetamodel metamodel = getMetamodel(value.getActualType());
		if (metamodel == getMetamodelManager().getPrimitiveMetamodel()) { // save value
			traceElement.setValue(value.castToString(getMetamodelManager()));
		} else { // save reference
			if (value.getValue() instanceof EObject) {
				traceElement.setElement((EObject) value.getValue());
			} else {
				warning("Value of " + fpar.getVardecl().getName()
					+ " is not an EObject, " + " storing its value as String",
						retrieveContainingRule(fpar), fpar.eContainingFeature(), -1);
				traceElement
					.setValue(value.castToString(getMetamodelManager()));
			}
		}
		return traceElement;
	}

	public MObject getTraceElementValue(TraceElement traceElement) {
		return getTraceElementValue(traceElement, getMetamodelManager());
	}

	// TODO refactor, callers should be trace policies
	public static MObject getTraceElementValue(TraceElement traceElement,
			MetamodelManager metamodelManager) {
		Object value = traceElement.getElement();
		if (value == null) value = traceElement.getValue();
		MObject result =
			metamodelManager.wrap(traceElement.getTypeName(), value);
		return result;
	}

	}
