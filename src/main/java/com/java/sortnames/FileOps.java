package com.java.sortnames;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

/**
 * Interface class to define file operations
 *
 */
public interface FileOps {

	/**
	 * To read the file and add the first name and last name into name object.
	 * 
	 * @param file
	 * @return list of names
	 * @throws FileNotFoundException IOException
	 */

	public List<Name> readNamesIntoNameObject(File file) throws FileNotFoundException, IOException;

	/**
	 * To create a new file and write the sorted list into the file.
	 * 
	 * @param file
	 * @param sortedNameList
	 * @throws IOException
	 */

	public void writeSortedNames(File file, List<Name> sortedPersonList) throws IOException;

}
