import java.lang.*
import java.util.*

public class Assignment1 extends Object {
    

    
	ArrayList<List<Integer>> lists;
    /* List of instances of datastructures that implement the List interface
     * that are to be benchmarked.
     */
        
	
    ArrayList<Queue<Integer>> queues;
    /* List of instances of datastructures that implement the Queue interface
     * that are to be benchmarked.
     */ 
    
    public Assignment1(){
        /* Default constructor */
        lists = new ArrayList<List<Integer>>();
        lists.add( new ArrayList<Integer>());
        lists.add( new LinkedList<Integer>());
        lists.add( new Stack<Integer>());
        lists.add( new Vector<Integer> ());
        
        queues = new ArrayList<Queue<Integer>>();
        queues.add(new LinkedList<Integer>());
        queues.add(new PriorityQueue<Integer>());
    }
    
    public static void main(String[] args){
    /* Main method of the program. */
    
    }
    
    
    
	public void benchmark() {
    /* Performs benchmark with random seed 0 to populate the data structures
     * and with mutations as in CollectionTimer.DEFAULT_MUTATIONS.
     */
        
    }
    
    public void benchmark(long elemGenSeed){
    /* Performs benchmark using the given seed to populate the data structures
     * and with mutations as in CollectionTimer.DEFAULT_MUTATIONS.
     */
    }
    public void benchmark(long elemGenSeed, int[] mutations){
    /* Performs benchmark by applying the specified mutations and 
     * using the given seed to populate the data structures.
     */
    
    }
    private static void errorExit(String msg){
    /* Print a message to stderr and exit with value 1. */
    
    } 
}
