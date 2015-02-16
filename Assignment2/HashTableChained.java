import java.lang.*;
import java.util.*;

public class HashTableChained implements HashTable {
	
	ChainedList[] hashtable;
	Compressable function;
	int size;
	int length;
	
	
	public HashTableChained(int hash_size, Compressable function) {
		this.function = function;
		this.length = hash_size;
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
		if(hashtable[index] == null){
			return null;
		}
		return hashtable[index].get(key);
	}
	
	public int size() {
		return size;
	}
	
	public int length(){
		return length;
	}
}
