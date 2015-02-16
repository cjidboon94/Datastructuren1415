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
		for (OpenEntry entry : hashtable) {
			entry = null;
		}
		size = 0;
	}

	public void put(String key, String value) {
		int index = function.calcIndex(key);
		if (hashtable[index] == null) {
			hashtable[index] = new OpenEntry(key, value);
		} else if( !insert(index, key, value)) {
			 resize(key, value);
			
		}
		size++;
	}
	
	public String get(String key) {
		
		int index = function.calcIndex(key);
		if(hashtable[index] != null &&
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
	
	public int size() {
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
		OpenEntry[] temp = new OpenEntry[length];
		System.arraycopy(hashtable, 0, temp, 0, length );
		hashtable = newArr;
		
		this.length *= 2;
		
		for(OpenEntry entry : hashtable) {
			entry = null;
		}

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
		int index = function.calcIndex(key);
		if(hashtable[index] == null) {
			hashtable[index] = new OpenEntry(key, value);
		} else {
			insert(index, key, value);
		}
	}
}
