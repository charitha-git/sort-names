package com.java.sortnames;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * The main class to call the file operations and sort the data.
 *
 */
public class SortNames {

	private FileOps fileOperation;

	public SortNames(FileOps fileOperation) {
		this.fileOperation = fileOperation;
	}

	/**
	 * @param Pass the argument(file) from command line, sort and write to a new
	 *             file.
	 * @throws IOException
	 * @throws FileNotFoundException
	 */
	public void sortNames(String[] args) throws FileNotFoundException, IOException {

		// check if have the one argument
		if (args.length != 1) {
			System.out.println("Invalid command line, exactly one argument required");
			System.exit(1);
		}

		System.out.println("sort-names " + args[0]);

		// read names from the file and convert it into person Object
		File file = new File(args[0]);
		List<Name> nameList = fileOperation.readNamesIntoNameObject(file);

		// Sort the person object first by lastname and then by firstname
		List<Name> sortedNameList = sortPerson(nameList);

		// write the sortednames in the new file created in the same path
		fileOperation.writeSortedNames(file, sortedNameList);
	}

	/**
	 * Sort the list first by last name and then by firstName using streams.
	 * 
	 * @param nameList
	 * @return sortedNameList
	 */
	public List<Name> sortPerson(List<Name> nameList) {
		List<Name> sortedNameList = nameList.stream()
				.sorted(Comparator.comparing(Name::getLastName).thenComparing(Name::getFirstName))
				.collect(Collectors.toList());
		return sortedNameList;
	}

}
