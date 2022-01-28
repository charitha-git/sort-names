package com.java.sortnames;

import static org.junit.Assert.assertEquals;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Before;
import org.junit.Test;

public class FileOperationTest {

	public FileOperation fileOps;

	@Before
	public void setUp() throws Exception {
		fileOps = new FileOperation();
	}

	@Test
	public void readNamesIntoPersonTestSuccess() throws FileNotFoundException, IOException {
		List<String> lines = Arrays.asList("BAKER, THEODORE", "SMITH, ANDREW", "KENT, MADISON", "SMITH, FREDRICK");
		Path path = Paths.get("C://files//names.txt");
		try {
			Files.write(path, lines, StandardCharsets.UTF_8);
		} catch (IOException e) {
			System.out.println("Unable to write in the new file '" + path.getFileName() + "'");
		}
		List<Name> list = fileOps.readNamesIntoNameObject(path.toFile());
		assertEquals("BAKER", list.get(0).getLastName());
		assertEquals("THEODORE", list.get(0).getFirstName());
		assertEquals("SMITH", list.get(1).getLastName());
		assertEquals("ANDREW", list.get(1).getFirstName());
		assertEquals("KENT", list.get(2).getLastName());
		assertEquals("MADISON", list.get(2).getFirstName());
		assertEquals("SMITH", list.get(3).getLastName());
		assertEquals("FREDRICK", list.get(3).getFirstName());
	}

	@Test
	public void readNameWithoutCommaNotAddedInList() throws FileNotFoundException, IOException {
		List<String> lines = Arrays.asList("BAKER, THEODORE", "SMITH ANDREW", "KENT MADISON", "SMITH, FREDRICK");
		Path path = Paths.get("C://files//names.txt");
		try {
			Files.write(path, lines, StandardCharsets.UTF_8);
		} catch (IOException e) {
			System.out.println("Unable to write in the new file '" + path.getFileName() + "'");
		}
		List<Name> list = fileOps.readNamesIntoNameObject(path.toFile());
		assertEquals("BAKER", list.get(0).getLastName());
		assertEquals("THEODORE", list.get(0).getFirstName());

		assertEquals("SMITH", list.get(1).getLastName());
		assertEquals("FREDRICK", list.get(1).getFirstName());
	}

	@Test(expected = FileNotFoundException.class)
	public void readNameIntoNamesObjectFileNotFoundExceptionFailure() throws FileNotFoundException, IOException {
		Path path = Paths.get("C://nofiles//fileNotExists.txt");
		fileOps.readNamesIntoNameObject(path.toFile());
	}

	@Test(expected = IOException.class)
	public void readNameIntoNamesObjectIOExceptionFailure() throws FileNotFoundException, IOException {
		Path path = Paths.get("/");
		fileOps.readNamesIntoNameObject(path.toFile());
	}

	@Test
	public void writeSortedNamesTestSuccess() throws IOException {
		List<String> lines = Arrays.asList("BAKER, THEODORE", "SMITH, ANDREW", "KENT, MADISON", "SMITH, FREDRICK");
		Path path = Paths.get("C://files//names.txt");
		try {
			Files.write(path, lines, StandardCharsets.UTF_8);
		} catch (IOException e) {
			System.out.println("Unable to write in the new file '" + path.getFileName() + "'");
		}
		List<Name> list = fileOps.readNamesIntoNameObject(path.toFile());
		fileOps.writeSortedNames(path.toFile(), list);
		List<Path> writtenPath = null;
		String writtenFile = null;

		try (Stream<Path> paths = Files.walk(Paths.get(path.getParent().toUri()))) {
			writtenPath = paths.filter(Files::isRegularFile)
					.filter(file -> file.getFileName().toString().equals("names-sorted.txt"))
					.collect(Collectors.toList());
		}
		if (writtenPath.size() == 1) {
			writtenFile = writtenPath.get(0).getFileName().toString();
		}
		assertEquals(writtenFile, "names-sorted.txt");
	}

	@Test(expected = Exception.class)
	public void writeSortedNamesIOExceptionFailure() throws FileNotFoundException, IOException {
		Path path = Paths.get("/");
		fileOps.writeSortedNames(path.toFile(), new ArrayList<Name>());
	}

}
