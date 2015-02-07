public class ListTimer extends Collectiontimer {
    
    private List<Integer> list;
    /* The list that will be benchmarked. */
    
    public ListTimer(List<Integer> list){
    /* Constructor that creates a ListTimer instance for the given list. */
    
        return ListTimer(list, 0);
    }
    
    public ListTimer(List<Integer> list, Long elemGenSeed){ 
    /* Constructor that creates a ListTimer instance for 
     * that given list that will populate it with data generated 
     * using the specified seed. 
     */
        return ListTimer(list, (long) elemGenSeed);
        
    }
    public ListTimer(List<Integer> list, long elemGenSeed){ 
    /* Constructor that creates a ListTimer instance for 
     * that given list that will populate it with data generated 
     * using the specified seed.
     */
        
        this.list = list;
    }
    
    public void addElement(Integer elem){
    /* Adds an Integer object to the list */
        
        list.add(elem);
    }
    
    public void removeElement(){
    /*Removes an object from the list*/
        
        if(list.size() == 0){
            throw new IndexOutOfBoundsException();
        }
        try{
            list.remove(0);
        }catch(UnsupportedOperationException)
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
