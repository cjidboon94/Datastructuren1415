/* Assignment 2 - Datastructuren
 * Authors: Cornelis Boon - 10561145, Tim Groot - 10165673
 * Emails: cornelis.boon@student.uva.nl, tim.groot@student.uva.nl
 * Date: 16-02-2015
 * File: HashTableChained.java
 * 
 * Class description: Implementation of the HashTable interface.
 * Uses chaining to solve collisions. Every entry in the table has a reference
 * stored to a ChainedList object. 
 */

import java.lang.*;
import java.util.*;



public class HashTableChained implements HashTable {

	/* An array of ChainedLists containing the objects */
	ChainedList[] hashtable;
	/* Compressable object that is used to calculat the hashcode of
	 * each object stored
	 */
	Compressable function;
	/* The amount of words stored within hashtable */
	int size;
	/* Amount of slots in the hashtable */
	int length;
	
	/* Default constructor */
	public HashTableChained(int hash_size, Compressable function) {
		this.function = function;
		this.length = hash_size;
		this.hashtable = new ChainedList[hash_size];
		for( ChainedList list : hashtable) {
			list = null;
		}
		this.size = 0;
	}

	/* Handles put requests and updates the size field */
	public void put(String key, String value) {
		int index = function.calcIndex(key);
		ChainedEntry newEntry = new ChainedEntry(key, value); 
		if(hashtable[index] != null) {
			hashtable[index].put(newEntry);
		} else {
			hashtable[index] = new ChainedList(newEntry);
		}
		size++;
	}
	
	/* Handles get requests by passing them to the appropriate lists */
	public String get(String key) {
		int index = function.calcIndex(key);
		if(hashtable[index] == null){
			return null;
		}
		return hashtable[index].get(key);
	}
	/* returns the amount of words stored in the table*/
	public int size() {
		return size;
	}
	
	/* returns the total amount of slots in the table */
	public int length(){
		return length;
	}
}
