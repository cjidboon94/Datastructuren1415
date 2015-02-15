import java.lang.*;
import java.util.*;

public class HashTableOpen implements HashTable {
	
	private OpenEntry[] hashtable;
	private Compressable function;
	private int size;
	
	public HashTableOpen(int hash_size, Compressable function) {
		function = new Division(hash_size);
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
		} else {
			boolean inserted = false;
			for(int i = index; i < size(); i++){
				
			}
			
		}
	}

	public String get(String key) {
		int index = function.calcIndex(key);
		return "temp";
	}
	
	public int size(){
		return size;
	}
}
