/* Assignment 2 - Datastructuren
 * Authors: Cornelis Boon - 10561145, Tim Groot - 10165673
 * Emails: cornelis.boon@student.uva.nl, tim.groot@student.uva.nl
 * Date: 16-02-2015
 * File: HashTable.java
 * 
 * Class description: An interface for the Hashtable ADT. 
 */

public interface HashTable {
	
	/*Makes a key-value object and stores it in the table*/
	public void put(String key, String value);
	/*Retrieves the object that has the corresponding key*/
	public String get(String key);
	/*Returns the amount of objects stored in the table*/
	public int size();
	/*Returns the amount of slots there are in the table */
	public int length();
}
