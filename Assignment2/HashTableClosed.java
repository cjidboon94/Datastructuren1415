import java.lang.*;
import java.util.*;

public class HashTableClosed implements HashTable {
	
	ChainedList[] hashtable;
	Compressable function;
	int size;
	
	
	public HashTableClosed(int hash_size, Compressable function) {
		this.function = function;
		this.hashtable = new ChainedList[hash_size];
		for( ChainedList list : hashtable) {
			list = null;
		}
		this.size = 0;
	}

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

	public String get(String key) {
		int index = function.calcIndex(key);
		return hashtable[index].get(key);
	}
	
	public int size() {
		return size;
	}
}
