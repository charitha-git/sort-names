package com.java.sortnames;

import static org.junit.Assert.assertEquals;

import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.junit.Test;

public class SortNamesTest {

	@Test
	public void readNamesIntoPersonTest() {
		URL resource = getClass().getClassLoader().getResource("names.txt");
		Path path = null;
		try {
			path = Paths.get(resource.toURI());
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<Person> list =  SortNames.readNamesIntoPerson(path);
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
	public void sortPersonTest() {
		URL resource = getClass().getClassLoader().getResource("names.txt");
		Path path = null;
		try {
			path = Paths.get(resource.toURI());
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<Person> list =  SortNames.readNamesIntoPerson(path);
		List<Person> sortedPersonList =SortNames.sortPerson(list);
		
		assertEquals("BAKER", sortedPersonList.get(0).getLastName());
		assertEquals("THEODORE", sortedPersonList.get(0).getFirstName());
		assertEquals("KENT", sortedPersonList.get(1).getLastName());
		assertEquals("MADISON", sortedPersonList.get(1).getFirstName());
		assertEquals("SMITH", sortedPersonList.get(2).getLastName());
		assertEquals("ANDREW", sortedPersonList.get(2).getFirstName());
		assertEquals("SMITH", sortedPersonList.get(3).getLastName());
		assertEquals("FREDRICK", sortedPersonList.get(3).getFirstName());
	}

}
