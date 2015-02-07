import java.lang.*;
import java.util.*;
import java.lang.Integer;

public class QueueTimer extends CollectionTimer {
    /* Class that times the performance of a data structure 
     * that implements the Queue interface. 
     */
    
    private Queue<Integer> queue;
    /* The queue that will be benchmarked */
    
    public QueueTimer( Queue<Integer> queue){
    /* Constructor that creates a QueueTimer instance for the given queue */
        super();
        this.queue = queue;
    }
    
    public QueueTimer( Queue<Integer> queue, Long elemGenSeed){
    /*Constructor that creates a QueueTimer instance for the given queue
     *that will populate it with a data generated using the specified seed.
     */
        this(queue, (long) elemGenSeed);
    }
    
    public QueueTimer( Queue<Integer> queue, long elemGenSeed){
    /* Constructor that creates a QueueTimer instance for the given queue
     * that will populate it with a data generated using the specified seed.
     */
        super(elemGenSeed);
        
        this.queue = queue;
     
    }
    
	public void addElement(Integer elem) {
    /* Adds an Integer object to the queue.*/
		
        queue.add(elem);
	}

	public void removeElement() {
    /* Removes an object from the queue. */
   		
        if( getSize() == 0){
			throw new NoSuchElementException();
		} 
        queue.poll();
	}

	public int getSize() {
    /* Returns the size of the queue. */
		
        return queue.size();
	}

	public boolean isEmpty() {
    /* Tells whether the queue is empty. */
		
        return queue.isEmpty();
	}
}
