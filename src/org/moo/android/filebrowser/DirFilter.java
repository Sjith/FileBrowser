package org.moo.android.filebrowser;

import java.io.File;
import java.io.FileFilter;

/**
 * Filters all File instances for directories
 * 
 * @author kalkin
 *
 */
public class DirFilter implements FileFilter {

	/**
	 * Returns only true if given File is a directory
	 * 
	 * @see java.io.FileFilter#accept(java.io.File)
	 */
	@Override
	public boolean accept(File pathname) {
		return pathname.isDirectory();
	}

}
