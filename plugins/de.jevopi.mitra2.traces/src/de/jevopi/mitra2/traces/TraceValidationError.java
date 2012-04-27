package de.jevopi.mitra2.traces;

public class TraceValidationError {
	
	Trace trace;
	String messsage;
	/**
	 * @param trace
	 * @param messsage
	 */
	public TraceValidationError(Trace trace, String messsage) {
		this.trace = trace;
		this.messsage = messsage;
	}
	
	public Trace getTrace() {
		return trace;
	}
	
	public String getMesssage() {
		return messsage;
	}
	
	
	
}
