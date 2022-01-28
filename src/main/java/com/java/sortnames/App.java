package com.java.sortnames;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Console app to sort names
 *
 */
public class App {

	/**
	 * main method
	 * 
	 * @throws IOException
	 * @throws FileNotFoundException
	 */

	public static void main(String[] args) throws FileNotFoundException, IOException {
		FileOperation fileOperation = new FileOperation();
		SortNames sortNames = new SortNames(fileOperation);
		sortNames.sortNames(args);

	}

}
