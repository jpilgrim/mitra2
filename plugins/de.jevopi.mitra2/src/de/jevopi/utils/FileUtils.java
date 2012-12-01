/*******************************************************************************
 * Copyright (c) 2012 Jens von Pilgrim
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Jens von Pilgrim - initial API and implementation
 ******************************************************************************/

package de.jevopi.utils;

import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.URI;

/**
 * @author Jens von Pilgrim (developer@jevopi.de)
 * @since Jan 27, 2012
 */
public class FileUtils {
	
	public final static FileFilter FILTER_DIRECTORIES = new FileFilter() {
		
		@Override
		public boolean accept(File i_pathname) {
			return i_pathname.isDirectory() && ! i_pathname.isHidden();
		}
	};
	

	public static List<String> collectPathNames(File baseFolder, FileFilter filter, boolean recursive) {
		List<String> list = new ArrayList<String>();
		doCollect(baseFolder, filter, recursive, list, "");
		return list;
	}
	
	
	private static void doCollect(File i_baseFolder, FileFilter i_filter,
			boolean i_recursive, List<String> o_list, String prefix) {
		if (i_baseFolder.exists() && i_baseFolder.isDirectory()) {
			for(File f: i_baseFolder.listFiles(i_filter)) {
				o_list.add(prefix+f.getName());
			}
		}
		if (i_recursive) {
			prefix += i_baseFolder.getName() + File.separator;
			for(File dir: i_baseFolder.listFiles(FILTER_DIRECTORIES)) {
				doCollect(dir, i_filter, i_recursive, o_list, prefix);
			}
		}
	}
	
	
	public static String toOS(String path) {
		return URI.createFileURI(path).toFileString();
	}
	
}
