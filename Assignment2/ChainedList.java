
public class ChainedList extends Object {
	
	private ChainedEntry first;
	private ChainedEntry last;
	
	public ChainedList() {
		ChainedList(null);
	}
	
	public ChainedList(ChainedEntry entry){
		first = entry;
		last = entry;
	}
	
	public ChainedEntry getFirst(){
		return first;
	}
	
	public ChainedEntry getLast(){
		return last;
	}
	
	public void setLast(ChainedEntry last){
		this.last = last;
	}
	
	public String get(String key) {
		ChainedEntry head = first;
		ChainedEntry tail = last;
		
		while( 	(head.getNext() != null && head.getKey() != key) || 
				(tail.getPrev() != null && tail.getKey() != key)) {
			head = head.getNext();
			tail = tail.getPrev();
		}
		if(head != null || tail != null) {
			return key;
		} else {
			return null;
		}
		
	}
	
	public void put(String Key, String value){
		ChainedEntry newEntry = new ChainedEntry(key, value);
		
		if(getFirst() != null) {
			head = getFirst();
			tail = getLast();
			while( head.getNext() != null || tail.getPrev() ! = null) {
				if(head.getKey() == key || tail.getKey() == key) {
					return;
				}
				head = head.getNext();
				tail = tail.getPrev();
			}
			setTail(newEntry);
		} else {
			this =  new this(newEntry);
		}
	}
	
	public void setTail(ChainedEntry later) {
		getLast().setNext(later);
		later.setPrev(getLast());
		setLast(later);
	}
}
