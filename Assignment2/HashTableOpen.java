public class HashTableOpen {
	
	String[] hashtable;
	
	public HashTableOpen(int hash_size, Compressable function) {

		hashtable = new String[hash_size];
	}

	public void put() {
	//Put word (copy) in to array, with parameters word and index

	}

	public void get() {
	//Retrieve word from array, parameters word and index

	}

	public int getSize() {
		return hashtable.length;
	}
}
