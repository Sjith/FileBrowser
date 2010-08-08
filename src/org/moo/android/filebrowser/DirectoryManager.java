package org.moo.android.filebrowser;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

public class DirectoryManager {

	public ArrayList getDirectoryListing(File directory, String[] mFilters) {

		File[] dirs = directory.listFiles(new DirFilter());
		File[] files;
		if (mFilters != null)
			files = directory.listFiles(new FileFilter(mFilters));
		else
			files = directory.listFiles(new FileFilter());

		int dirEntries = 0;
		if (directory.getParentFile() != null)
			dirEntries = 1;

		if (dirs == null && files == null)
			return new ArrayList<File>(1);
		if (dirs != null) {
			Arrays.sort(dirs);
			dirEntries += dirs.length;
		}

		if (files != null) {
			Arrays.sort(files);
			dirEntries += files.length;
		}
		ArrayList<File> result = new ArrayList<File>(dirEntries);

		if (directory.getParentFile() != null)
			result.add(directory.getParentFile());

		for (File file : dirs) {
			result.add(file);
		}
		for (File file : files) {
			result.add(file);
		}
		return result;
	}
}
