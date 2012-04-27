package de.jevopi.mitra2.api;


public class MultiReturn implements IMultiReturn {

	final String[] parameterNames;
	final Object[] returnValuesByIndex;

	/**
	 * 
	 */
	public MultiReturn(String... parameterNames) {
		this.parameterNames = new String[parameterNames.length];
		System.arraycopy(parameterNames, 0, this.parameterNames, 0,
				parameterNames.length);
		this.returnValuesByIndex = new Object[parameterNames.length];
	}

	public void set(int index, Object value) {
		returnValuesByIndex[index] = value;
	}

	public void set(String name, Object value) {
		for (int i = 0; i < parameterNames.length; i++) {
			if (parameterNames[i].equals(name)) {
				returnValuesByIndex[i] = value;
				return;
			}
		}
		throw new IllegalArgumentException("Unknown parameter " + name);

	}

	@Override
	public int size() {
		return returnValuesByIndex.length;
	}

	@Override
	public Object get(int index) {
		return returnValuesByIndex[index];
	}

	@Override
	public Object get(String returnParameterName) {
		for (int i = 0; i < parameterNames.length; i++) {
			if (parameterNames[i].equals(returnParameterName)) {
				return returnValuesByIndex[i];
			}
		}
		throw new IllegalArgumentException("Unknown parameter "
			+ returnParameterName);
	}

}
