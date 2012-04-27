package de.jevopi.mitra2.traces;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;

/**
 * @author Jens von Pilgrim (developer@jevopi.de)
 * @since Mar 4, 2012
 */
public class TraceValidator {

	public List<TraceValidationError> validate(TraceRecord traceRecord) {
		List<TraceValidationError> errors =
			new ArrayList<TraceValidationError>();
		for (Trace trace : traceRecord.getTraces()) {
			for (TraceElement element : trace.getElements()) {
				if (element.getElement() != null) {
					EObject eobj = element.getElement();
					if (eobj.eResource() == null) {
						errors.add(new TraceValidationError(trace, "Element "
							+ element.getTypeName() + " (" + eobj.toString()
							+ ") is not contained in any resource."));
					}
				}
			}
		}
		return errors;
	}

	/**
	 * Remove all traces from trace record which contain elements not contained
	 * in any resources.
	 * 
	 * @param io_traceRecord
	 * @return
	 */
	public boolean removeVolatileTraces(TraceRecord io_traceRecord) {
		List<Trace> volatileTraces = new ArrayList<Trace>();
		for (Trace trace : io_traceRecord.getTraces()) {
			for (TraceElement element : trace.getElements()) {
				if (element.getElement() != null) {
					EObject eobj = element.getElement();
					if (eobj.eResource() == null) {
						volatileTraces.add(trace);
						break;
					}
				}
			}
		}
		io_traceRecord.getTraces().removeAll(volatileTraces);
		return !volatileTraces.isEmpty();
	}

	
	
}
