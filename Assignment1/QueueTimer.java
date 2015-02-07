public class QueueTimer extends CollectionTimer {
    /* Class that times the performance of a data structure 
     * that implements the Queue interface. 
     */
    
    
    private Queue<Integer> queue;
    /* The queue that will be benchmarked */
    
    public QueueTimer( Queue<Integer> queue){
    /* Constructor that creates a QueueTimer instance for the given queue */
        return QueueTimer(queue, 0);
    }
    
    public QueueTimer( Queue<Integer> queue, long elemGenSeed){
    /* Constructor that creates a QueueTimer instance for the given queue
     * that will populate it with a data generated using the specified seed.
     */
    }
    public QueueTimer( Queue<Integer> queue, Long elemGenSeed){
    /*Constructor that creates a QueueTimer instance for the given queue
     *that will populate it with a data generated using the specified seed.
     */
        return QueueTimer(queue, (long) elemGenSeed);
    }
    
	public void addElement(int elem) {
    /* Adds an Integer object to the queue.*/
		
        queue.add(elem);
	}

	public void removeElement {
    /* Removes an object from the queue. */
   		
        try {
			queue.remove();
		} 
		
        catch (java.util.NoSuchElementException) {
		}
	}

	public int getSize {
    /* Returns the size of the queue. */
		
        return queue.size();
	}

	public boolean isEmpty {
    /* Tells whether the queue is empty. */
		
        return queue.isEmpty();
	}

}
