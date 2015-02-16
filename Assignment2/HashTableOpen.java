import java.lang.*;
import java.util.*;

public class HashTableOpen implements HashTable {
	
	private OpenEntry[] hashtable;
	private Compressable function;
	private int size;
	private int test;
	private int length;
	
	public HashTableOpen(int hash_size, Compressable function) {
		this.function = function;
		this.length = hash_size;
		hashtable = new OpenEntry[hash_size];
		for( OpenEntry entry : hashtable ){
			entry = null;
		}
		size = 0;
	}

	public void put(String key, String value) {
		int index = function.calcIndex(key);
		if(hashtable[index] == null) {
			hashtable[index] = new OpenEntry(key, value);
		} else if(! insert(index, key, value)) {
			// resize(key, value);
		}
		size++;
	}
	
	public String get(String key) {
		
		int index = function.calcIndex(key);
		if((test % 4000) == 0)
			System.out.println((double)test/638285);
		if(	hashtable[index] != null &&
			hashtable[index].getKey().equals(key)) {
				test++;
				return key;
		} else if(find(index, key)) {
			test++;
			return key;
		}
		test++;
		return null;
	}
	
	public int size(){
		return size;
	}
	
	public int length(){
		return hashtable.length;
	}
	
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
	
	
	private void resize(String key, String value) {
		OpenEntry[] newArr = new OpenEntry[2*length];
		function = new Division(2*length);
		this.length *= 2;
		
		for(OpenEntry entry : newArr) {
			entry = null;
		}
		for(OpenEntry entry : hashtable) {
			if(entry == null) {
				continue;
			}
			int index = function.calcIndex(entry.getKey());
			newArr[index] = entry;
		}
		hashtable = newArr;
		int index = function.calcIndex(key);
		if(hashtable[index] == null) {
			hashtable[index] = new OpenEntry(key, value);
		} else {
			insert(index, key, value);
		}
	}
}
