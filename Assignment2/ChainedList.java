
public class ChainedList {
	
	private ChainedEntry first;
	private ChainedEntry last;
	
	public ChainedList() {
		this(null);
	}
	
	public ChainedList(ChainedEntry entry){
		first = entry;
		last = entry;
	}
	
	public ChainedEntry getFirst(){
		return first;
	}
	
	private ChainedEntry getLast(){
		return last;
	}
	
	private void setLast(ChainedEntry last){
		this.last = last;
	}
	
	public String get(String key) {
		ChainedEntry head = getFirst();
		ChainedEntry tail = getLast();
		
		while( 	head.getNext() != null && ! head.getKey().equals(key) &&
				tail.getPrev() != null && ! tail.getKey().equals(key)) {
					
			head = head.getNext();
			tail = tail.getPrev();
		}
		if( (head != null && head.getKey().equals(key)) ||
			(tail != null && tail.getKey().equals(key))) {
				return key;
		} else {
			return null;
		}
		
	}
	
	public void put(ChainedEntry newEntry){
		String key = newEntry.getKey();
		ChainedEntry head = getFirst();
		ChainedEntry tail = getLast();
		while( head.getNext() != null && tail.getPrev() != null) {
			if(head.getKey().equals(key) || tail.getKey().equals(key)) {
				return;
			}
			head = head.getNext();
			tail = tail.getPrev();
		}
		setTail(newEntry);
	}
	
	private void setTail(ChainedEntry later) {
		getLast().setNext(later);
		later.setPrev(later);
		setLast(later);
	}
}
