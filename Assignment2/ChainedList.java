/* Assignment 2 - Datastructuren
 * Authors: Cornelis Boon - 10561145, Tim Groot - 10165673
 * Emails: cornelis.boon@student.uva.nl, tim.groot@student.uva.nl
 * Date: 16-02-2015
 * File: ChainedList.java
 * 
 * Class description: An implementation of a Double LinkedList-like object.
 * Handles put and get requests it gets from the hashtable.
 */

public class ChainedList {
	
	/* Head of the list */
	private ChainedEntry first;
	/* Tail of the list */
	private ChainedEntry last;
	
	/* Default constructor */
	public ChainedList() {
		this(null);
	}
	
	/* Second constructor */
	public ChainedList(ChainedEntry entry){
		first = entry;
		last = entry;
	}
	
	/* Accessor function that retrieves the head of the list */
	public ChainedEntry getFirst(){
		return first;
	}
	/* Accessor function that retrieves the tail of the list */
	private ChainedEntry getLast(){
		return last;
	}
	
	/* Mutator function that changes the tail */
	private void setLast(ChainedEntry last){
		this.last = last;
	}
	
	/* Handles get requests it receives from the table 
	 * Searches the list from both sides to the center 
	 * returns the key if it finds the object, otherwise null
	 */
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
	
	/* Handles put requests. Searches the list if such an object already exists 
	 * If it does not, it appends the object at the end of the list.*/
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
	
	/* Mutator function that appends 'later' to last and links these two objects*/
	private void setTail(ChainedEntry later) {
		getLast().setNext(later);
		later.setPrev(later);
		setLast(later);
	}
}
