
public class ChainedEntry implements Entry {
	private String key;
	private String value;
	private ChainedEntry next;
	private ChainedEntry previous;
	
	public ChainedEntry(String key, String value){
		this(key, value, null);
	}
	
	public ChainedEntry(String key, String value, ChainedEntry previous){
		this.key = key;
		this.value = value;
		this.previous = previous;
		this.next = null;
	}
	
	public String getKey(){
		return key;
	}

	public ChainedEntry getNext(){
		return next;
	}
	
	public void setNext(ChainedEntry next){
		this.next = next;
	}

	
	public ChainedEntry getPrev(){
		return previous;
	}
	
	public void setPrev(ChainedEntry prev){
		this.previous = prev;
	}	
}
