public class Assignment1 {
    
    //List of instances of datastructures that implement the List interface
    //that are to be benchmarked.
    
	ArrayList<List<Integer>> lists;
    
    //List of instances of datastructures that implement the Queue interface
    //that are to be benchmarked. 
	
    ArrayList<Queue<Integer>> queues;
    
    public Assignment1(){
        //Default constructor
        lists = new ArrayList<List<Integer>>
        lists.add( new ArrayList<Integer>())
        lists.add( new LinkedLIst<Integer>() )
        lists.add( new Stack<Integer> () )
        lists.add( new Vector<Integer> () )
        
        queues = new ArrayList<Queue<Integer>>
        queues.add(
    }
    
    public static void main(String[] args){
        
    }
    
    
    
	public void benchmark() {
    //Performs benchmark with random seed 0 to populate the data structures
    //and with mutations as in CollectionTimer.Default_Mutations.
    //The result is printed to stdout.
	
    }
    
    public void benchmark(long elemGenSeed)
    //Performs benchmark using the given seed to populate the data structures
    //and with mutations as in CollectionTimer.Default_Mutations.
    //The result is printed to stdout
    
    public void benchmark(long elemGenSeed, int[] mutations)
    //Performs benchmark by applying the specified mutations and using 
    //the given seed to populate the data structures. 
    //The result is printed to stdout
	
    private static void errorExit(String msg){
    //Print a message to stderr and exit with value 1.
    
    //Parameters: msg - the error message;
    } 
}
