/* Assignment 2 - Datastructuren
 * Authors: Cornelis Boon - 10561145, Tim Groot - 10165673
 * Emails: cornelis.boon@student.uva.nl, tim.groot@student.uva.nl
 * Date: 16-02-2015
 * File: ChainedEntry.java
 * 
 * Class description: A node-like object that is used in ChainedList.
 * Contains a reference to the object in front of it and behind it.
 * As well as the key and value pair
 */
 
 
public class ChainedEntry implements Entry {
	/* Key of the key-value pair */
	private String key;
	/* Value of the key-value pair */
	private String value;
	/* Reference to the Entry ahead of it */
	private ChainedEntry next;
	/* Reference to the entry behind of it */
	private ChainedEntry previous;
	
	/* Default Constructor */
	public ChainedEntry(String key, String value){
		this(key, value, null);
	}
	
	/* Constructor that appends this object to the list. */
	public ChainedEntry(String key, String value, ChainedEntry prev){
		this.key = key;
		this.value = value;
		this.previous = prev;
		this.next = null;
	}
	
	/* Accessor function that returns the key of the entry */
	public String getKey(){
		return this.key;
	}
	
	/* Returns the object in front of it */
	public ChainedEntry getNext(){
		return this.next;
	}
	
	/* Sets a reference to the object that becomes in front of it */
	public void setNext(ChainedEntry next){
		this.next = next;
	}
	
	/* Returns the object behind it */
	public ChainedEntry getPrev(){
		return previous;
	}
	
	/* Sets a reference to the object that becomes behind of it */
	public void setPrev(ChainedEntry prev){
		this.previous = prev;
	}	
}
