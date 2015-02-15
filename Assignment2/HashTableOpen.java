import java.lang.*;
import java.util.*;

public class HashTableOpen extends Object {
	
	ChainedList[] hashtable;
	Compressable function;
	
	
	public HashTableOpen(int hash_size, String function) {
		function = new Division(hash_size);
		hashtable = new ChainedList[];
		
	}

	public void put(String key, String value) {
		int index = function.calcIndex(key);
		hashtable[index].put(key, value);
	}

	public String get(String key) {
		int index = function.calcIndex(key);
		return hashtable[index].get(key);
		
	}
}
