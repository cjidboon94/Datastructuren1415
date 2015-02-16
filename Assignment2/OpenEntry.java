/* Assignment 2 - Datastructuren
 * Authors: Cornelis Boon - 10561145, Tim Groot - 10165673
 * Emails: cornelis.boon@student.uva.nl, tim.groot@student.uva.nl
 * Date: 16-02-2015
 * File: OpenEntry.java
 * 
 * Class description: Implementation of the Entry interface. 
 * A simple key and value pair object. Used in the HashTableOpen class.
 */

public class OpenEntry implements Entry {
	
	/*Key of the key-value pair object*/
	private String key;
	/*Value of the key-value pair object */
	private String value;
	
	
	/*Default constructor */
	public OpenEntry(String key, String value) {
		this.key = key;
		this.value = value;
	}
	
	/*Accessor function for the key */
	public String getKey() {
		return key;
	}
	
	/*Accessor function for the key */
	public String getVal() {
		return value;
	}
}
