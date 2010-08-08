package org.moo.android.filebrowser;

/*
 * Copyright (c) 2009, Bahtiar `kalkin-` Gadimov
 * All rights reserved.
 * 
 * Redistribution and use in source and binary forms, with or without modification, 
 * are permitted provided that the following conditions are met:
 * 
 * - Redistributions of source code must retain the above copyright notice, this list of 
 *   conditions and the following disclaimer.
 * 
 * - Redistributions in binary form must reproduce the above copyright notice, this list 
 *   of conditions and the following disclaimer in the documentation and/or other materials 
 *   provided with the distribution.
 * 
 * - Neither the name of the Moo Productions nor the names of its contributors may be used 
 *   to endorse or promote products derived from this software without specific prior written 
 *   permission.
 * 
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND ANY EXPRESS 
 * OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY 
 * AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR 
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL 
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 * DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER 
 * IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT 
 * OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
import java.io.File;

/**
 * Filters all Filter instances which are actual files
 * 
 * @author Bahtiar `kalkin-` Gadimov
 * 
 */
public class FileFilter implements java.io.FileFilter {

	protected String[] mFilters = null;
	
	protected boolean showHidden = false;

	


	/**
	 * Sets the string file filters to use
	 * 
	 * @param mFilters
	 *            string file filters
	 */
	public FileFilter(String[] mFilters) {
		this.mFilters = mFilters;
	}
	public FileFilter(String[] mFilters, boolean showHidden) {
		this.mFilters = mFilters;
		this.showHidden = showHidden;
	}
	
	public FileFilter(boolean showHidden) {
		this.showHidden = showHidden;
	}
	
	public FileFilter() {
	}

	
	/**
	 * Returns true if the given File object is an actual file. If file filters
	 * are set in the constructor, files are filtered by them
	 * 
	 * @see java.io.FileFilter#accept(java.io.File)
	 */
	@Override
	public boolean accept(File pathname) {
		if (pathname.isDirectory())
			return false;
		if (!showHidden && pathname.getName().startsWith("."))
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
