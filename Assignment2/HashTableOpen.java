/* Assignment 2 - Datastructuren
 * Authors: Cornelis Boon - 10561145, Tim Groot - 10165673
 * Emails: cornelis.boon@student.uva.nl, tim.groot@student.uva.nl
 * Date: 16-02-2015
 * File: HashTableOpen.java
 * 
 * Class description: An implementation of the hashtable interface.
 * Uses linear probing to solve collisions.
 */


import java.lang.*;
import java.util.*;

public class HashTableOpen implements HashTable {
	
	/* The table of entries */
	private OpenEntry[] hashtable;
	/* The object that handles the computation of the index */
	private Compressable function;
	/* The amount of words stored in the table */
	private int size;
	/* The amount of slots */
	private int length;
	
	
	/* Default constructor */
	public HashTableOpen(int hash_size, Compressable function) {
		this.function = function;
		this.length = hash_size;
		hashtable = new OpenEntry[hash_size];
		for (OpenEntry entry : hashtable) {
			entry = null;
		}
		size = 0;
	}
	
	/* Handles put requests and stores the key and value in an OpenEntry object 
	 * If the table seems to be small, resize is called.
	 */
	public void put(String key, String value) {
		int index = function.calcIndex(key);
		if (hashtable[index] == null) {
			hashtable[index] = new OpenEntry(key, value);
		} else if( !insert(index, key, value)) {
			 resize(key, value);
			
		}
		size++;
	}
	
	/* Handles get requests */
	public String get(String key) {
		
		int index = function.calcIndex(key);
		if(hashtable[index] != null &&
			hashtable[index].getKey().equals(key)) {
				return key;
		} else if(find(index, key)) {
			return key;
		}
		return null;
	}
	
	/* Returns the amount of words in the table */
	public int size() {
		return size;
	}
	
	/*Returns the total amount of the slots */
	public int length(){
		return hashtable.length;
	}
	
	
	/* Tries to insert the key-value pair into the table. If it fails, returns false */
	private boolean insert(int index, String key, String value) {
		for(int i = index; i < hashtable.length; i++) {
			if(hashtable[i] == null) {
				hashtable[i] = new OpenEntry(key, value);
				return true;
			}
		}
		for(int i = 0; i < index; i++) {
			if(hashtable[i] == null) {
				hashtable[i] = new OpenEntry(key, value);
				return true;
			}
		}
		return false;
	}
	
	/* Tries to find the object that has the right key. Returns false if it can't find it */
	private boolean find(int index, String key) {
		for(int i = index; i < hashtable.length; i++) {
			if(	hashtable[i] != null && 
				hashtable[i].getKey().equals(key)) {
					return true;
			}
		}
		for(int i = 0; i < index; i++) {
			if(	hashtable[i] != null &&
				hashtable[i].getKey().equals(key)) {
					return true;
			}
		}
		return false;
	}
	
	/* Doubles the size of the table and recalculates all indexes */
	private void resize(String key, String value) {
		OpenEntry[] newArr = new OpenEntry[2*length];
		
		function = new Division(2*length);
		OpenEntry[] temp = new OpenEntry[length];
		System.arraycopy(hashtable, 0, temp, 0, length );
		hashtable = newArr;
		
		this.length *= 2;
		
		for(OpenEntry entry : hashtable) {
			entry = null;
		}
		
		/* Reinserts each object */
		for(OpenEntry entry : temp) {
			if(entry == null) {
				continue;
			}
			int index = function.calcIndex(entry.getKey());
			if(hashtable[index] == null) {	
				hashtable[index] = entry;
			} else {	
				insert(index, entry.getKey(), entry.getVal());
			}
		}
		
		/* Inserts the object that could not be inserted before */
		int index = function.calcIndex(key);
		if(hashtable[index] == null) {
			hashtable[index] = new OpenEntry(key, value);
		} else {
			insert(index, key, value);
		}
	}
}
