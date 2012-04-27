package de.jevopi.mitra2.debug.ui;

import java.util.Map;

public class PathTableRow {
	PathTable pathTable;
	Map<String, String> owner;
	String name;
	String[] extensions;
	
	/**
	 * @param pathTable 
	 * @param owner
	 * @param name
	 */
	public PathTableRow(PathTable pathTable, Map<String, String> owner, String name, String[] extensions) {
		this.pathTable = pathTable;
		this.owner = owner;
		this.name = name;
		this.extensions = extensions;
	}
	
	public String[] getExtensions() {
		return extensions;
	}
	
	String getPath() {
		return owner.get(name);
	}
	
	void setPath(String path) {
		String old = owner.put(name, path);
		if (!(path.equals(old)))
			pathTable.fireChange(name, path, old);
	}
	
	String get(int column) {
		return column==0 ? name : owner.get(name);
	}
}
