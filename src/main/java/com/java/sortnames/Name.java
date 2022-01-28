package com.java.sortnames;

/**
 * The name class used to set and get the lastName and firstName.
 *
 */
public class Name {

	private String firstName;
	private String lastName;

	public Name(String lastName, String firstName) {
		this.setLastName(lastName);
		this.setFirstName(firstName);
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
