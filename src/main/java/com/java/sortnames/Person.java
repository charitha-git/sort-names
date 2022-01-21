package com.java.sortnames;

public class Person {
	
	private String firstName;
	private String lastName;
	
	public Person(String fullName) {
		String[] name = fullName.split(", ");
		this.setLastName(name[0]);
		this.setFirstName(name[1]);
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

}
