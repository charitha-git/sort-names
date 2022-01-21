package com.java.sortnames;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SortNames {

	public static void main(String[] args) {

		// check if have the file argument
		if (args.length != 1) {
			System.err.println("Invalid command line, exactly one argument required");
			System.exit(1);
		}

		Path path = Paths.get(args[0]);
		
		if(!path.toFile().isFile()){
	    	System.err.println("Invalid argument, expected a file");
			System.exit(1);
	    }
		
		System.out.println("sort-names " + args[0]);

		// read names from the file and convert it into person Object
		List<Person> personList = readNamesIntoPerson(path);

		// Sort the person object first by lastname and then by firstname
		List<Person> sortedPersonList = sortPerson(personList);

		// write the sortednames in the new file created in the same path
		writeSortedNames(path, sortedPersonList);

	}

	public static void writeSortedNames(Path path, List<Person> sortedPersonList) {
		// Fetch the file name
		String[] fileName = path.getFileName().toString().split("\\.");
		// new file name to write after the sort
		String newFileName = path.getParent() + "\\" + fileName[0] + "-sorted." + fileName[1];
		try {
			// Creation of File Descriptor for output file
			File f = new File(newFileName);
			FileWriter fw = new FileWriter(f);
			//write the sorted names in the file
			sortedPersonList.forEach(sortedPerson -> {
				try {
					String sortedName = sortedPerson.getLastName() + ", " + sortedPerson.getFirstName();
					System.out.println(sortedName);
					fw.write(sortedName);
					fw.write("\n");
				} catch (IOException e) {
					e.printStackTrace();
				}

			});
			fw.flush();
			fw.close();
			System.out.println("Finished: created "+ fileName[0] + "-sorted." + fileName[1]);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	public static List<Person> sortPerson(List<Person> personList) {
		List<Person> sortedPersonList = personList.stream()
				.sorted(Comparator.comparing(Person::getLastName).thenComparing(Person::getFirstName))
				.collect(Collectors.toList());
		return sortedPersonList;
	}

	public static List<Person> readNamesIntoPerson(Path path) {
		List<Person> personList = new ArrayList<Person>();
		try (Stream<String> stream = Files.lines(path, StandardCharsets.UTF_8)) {
			stream.forEach(name -> {
				Person person = new Person(name);
				personList.add(person);
			});
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		return personList;
	}

}
