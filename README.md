# Megaport Coding Assessment Solution
## The Goal: Console App to sort names
1. Takes as a parameter a string that represents a text file containing a list of names.
2. Orders the names by last name followed by first name.
3. Creates a new text file called <input file name>-sorted.txt with the list of sorted
names.

## Prerequisite
+ **Installed** Java JDK 8 or later.
+ Setting your *Environment Variables* for **_java/javac_** command.

## How To Run
+ Clone this project into your working directory.
+ Type the following command:

```bash
$ javac -d output src\main\java\com\java\*.java
$ java SortNames names.txt
```

## What This Program Does
This program will read a text file that contains list of string, and then sort the given string by last name and then by first name, after that will print out sorted string to the screen and also write sorted string into the text file.