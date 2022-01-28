package com.java.sortnames;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * This class is used to do file operations, like to read the input file, add
 * the data into the list of names and write the sorted data to a new file.
 */
public class FileOperation implements FileOps {

	public String separator = ", ";

	/**
	 * To read the file and add the first name and last name into name object.
	 * 
	 * @param file
	 * @return list of names
	 * @throws FileNotFoundException, IOException
	 */
	@Override
	public List<Name> readNamesIntoNameObject(File file) throws FileNotFoundException, IOException {
		List<Name> nameList = new ArrayList<Name>();
		String line = null;
		try {
			FileReader fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);

			while ((line = bufferedReader.readLine()) != null) {
				String[] fullName = line.split(separator);
				if (fullName.length == 2) {
					Name name = new Name(fullName[0], fullName[1]);
					nameList.add(name);
				}
			}
			bufferedReader.close();
		} catch (FileNotFoundException ex) {
			System.out.println("Unable to open file '" + file + "'");
			throw ex;
		} catch (IOException ex) {
			System.out.println("Error reading file '" + file + "'");
			throw ex;

		}
		return nameList;

	}

	/**
	 * To create a new file and write the sorted list into the file.
	 * 
	 * @param file
	 * @param sortedNameList
	 * @throws IOException
	 */
	@Override
	public void writeSortedNames(File file, List<Name> sortedNameList) throws IOException {
		String newFileName = null;
		try {
			// Fetch the file name
			String[] fileName = file.getName().toString().split("\\.");
			// new file name to write after the sort
			newFileName = file.getParent() + "\\" + fileName[0] + "-sorted." + fileName[1];

			// Creation of File Descriptor for output file
			File f = new File(newFileName);
			FileWriter fw = new FileWriter(f);
			// write the sorted names in the file
			for (Name sortedName : sortedNameList) {
				String name = sortedName.getLastName() + separator + sortedName.getFirstName();
				System.out.println(name);
				fw.write(name);
				fw.write("\n");
			}
			fw.flush();
			fw.close();
			System.out.println("Finished: created " + fileName[0] + "-sorted." + fileName[1]);
		} catch (IOException ex) {
			System.out.println("Unable to write in the new file '" + newFileName + "'");
			throw ex;
		} catch (Exception ex) {
			System.out.println("Exception occured while writing in the new file'" + newFileName + "'");
			throw ex;
		}
	}

}
