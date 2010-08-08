package org.moo.android.filebrowser;

import java.io.File;

/**
 * Filters all Filter instances which are actual files
 * 
 * @author kalkin
 *
 */
public class FileFilter implements java.io.FileFilter {

	protected String[] mFilters = null;
	
	public FileFilter(String[] mFilters)
	{
		this.mFilters = mFilters;
	}
	
	public FileFilter(){}
	
	/** 
	 * Returns true if the given File object is an actual file
	 * 
	 * @see java.io.FileFilter#accept(java.io.File)
	 */
	@Override

	public boolean accept(File pathname) {
		if (pathname.isDirectory())
			return false;
		if (mFilters != null) {
			for (String ext : mFilters) {
				if (pathname.getName().endsWith(ext)) {
					return true;
				}
			}
		} else {
			return true;
		}
		
		return false;
	}

}
