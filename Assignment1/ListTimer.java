public class ListTimer extends Collectiontimer {
    /* Class that times the performance of a data structure that 
     * implements the List interface. 
     */
    
    
    private List<Integer> list;
    /* The list that will be benchmarked. */
    
    public ListTimer(List<Integer> list){
    /* Constructor that creates a ListTimer instance for the given list. */
        
        super();
        this.list = list;
    }
    
    public ListTimer(List<Integer> list, Long elemGenSeed){ 
    /* Constructor that creates a ListTimer instance for 
     * that given list that will populate it with data generated 
     * using the specified seed. 
     */
        ListTimer(list, (long) elemGenSeed);
        
    }
    public ListTimer(List<Integer> list, long elemGenSeed){ 
    /* Constructor that creates a ListTimer instance for 
     * that given list that will populate it with data generated 
     * using the specified seed.
     */
        super(elemGenSeed);
        this.list = list;
    }
    
    public void addElement(Integer elem){
    /* Adds an Integer object to the list */
        
        list.add(elem);
    }
    
    public void removeElement(){
    /*Removes an object from the list*/
        
        if(isEmpty()){
            throw new IndexOutOfBoundsException();
        }
        try{
            list.remove(0);
        } catch (UnsupportedOperationException e){
            throw e;
        }
     }
    
    public int getSize(){
    /* Returns the size of the list. */
        
        return list.size();
    }
    
    public boolean isEmpty(){
    /*Tells whether the list is empty */
        
        return list.isEmpty();
    }
}
