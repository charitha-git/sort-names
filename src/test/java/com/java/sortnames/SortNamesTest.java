package com.java.sortnames;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class SortNamesTest {

	public SortNames sortNames;

	@Before
	public void setUp() throws Exception {
		FileOperation fileOperation = new FileOperation();
		sortNames = new SortNames(fileOperation);
	}

	@Test
	public void sortNameTest() {
		List<Name> names = setUpNames();
		List<Name> sortedPersonList = sortNames.sortPerson(names);

		assertEquals("BAKER", sortedPersonList.get(0).getLastName());
		assertEquals("THEODORE", sortedPersonList.get(0).getFirstName());
		assertEquals("KENT", sortedPersonList.get(1).getLastName());
		assertEquals("MADISON", sortedPersonList.get(1).getFirstName());
		assertEquals("SMITH", sortedPersonList.get(2).getLastName());
		assertEquals("ANDREW", sortedPersonList.get(2).getFirstName());
		assertEquals("SMITH", sortedPersonList.get(3).getLastName());
		assertEquals("FREDRICK", sortedPersonList.get(3).getFirstName());
	}

	private List<Name> setUpNames() {
		List<Name> names = new ArrayList<Name>();
		names.add(new Name("BAKER", "THEODORE"));
		names.add(new Name("SMITH", "ANDREW"));
		names.add(new Name("KENT", "MADISON"));
		names.add(new Name("SMITH", "FREDRICK"));

		return names;
	}

}
