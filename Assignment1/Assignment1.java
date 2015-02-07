import java.lang.*;
import java.util.*;

public class Assignment1 extends Object {
  /* Times the mutations (population and depopulation) of various 
   * data structures provided by the Java standard library that either 
   * implement the List or Queue interface.
   */

    
	private ArrayList<List<Integer>> lists;
    /* List of instances of datastructures that implement the List interface
     * that are to be benchmarked.
     */
        
  private ArrayList<Queue<Integer>> queues;
   /* List of instances of datastructures that implement the Queue interface
    * that are to be benchmarked.
    */ 
    
  public Assignment1() {
  /* Default constructor */
    lists = new ArrayList<List<Integer>>();
    lists.add( new ArrayList<Integer>());
    lists.add( new LinkedList<Integer>());
    lists.add( new Stack<Integer>());
    lists.add( new Vector<Integer> ());
      
    queues = new ArrayList<Queue<Integer>>();
    queues.add( new LinkedList<Integer>());
    queues.add( new PriorityQueue<Integer>());
  }
    
  public static void main(String[] args) {
  /* Main method of the program. */
      if(args.length == 0) {
        Assignment1 init = new Assignment1();
        init.benchmark();
      }
      /*
      else if(args.length == 1) {
          if(args[0].contains("-")) {
              errorExit("Invalid argument");
          }
          else {
            int[] mutations = {Integer.parseInt(args[0])};
            benchmark(0, mutations);
          }
      }
      else if(args.length >= 2) {
          if(args[0].compareTo("-s")) {
              long seed = args[1];
              int[] mutations = new int[args.length-2];
          }
          
      }*/
  }
     
	public void benchmark() {
    /* Performs benchmark with random seed 0 to populate the data structures
     * and with mutations as in CollectionTimer.DEFAULT_MUTATIONS.
     */
    Assignment1 accessor = new Assignment1();
    for(List<Integer> list : accessor.lists) {
        ListTimer timer = new ListTimer(list);
        System.out.println(list.getClass().getName() + ": " + timer.time() + "ms");
    }
    for(Queue<Integer> queue : accessor.queues) {
        QueueTimer timer = new QueueTimer(queue);
        System.out.println(queue.getClass().getName() + ": " + timer.time() + "ms");
    }
  }   
    
  public void benchmark(long elemGenSeed) {
  /* Performs benchmark using the given seed to populate the data structures
   * and with mutations as in CollectionTimer.DEFAULT_MUTATIONS.
   */
  }

  public void benchmark(long elemGenSeed, int[] mutations) {
  /* Performs benchmark by applying the specified mutations and 
   * using the given seed to populate the data structures.
   */ 
  }

  private static void errorExit(String msg) {
  /* Print a message to stderr and exit with value 1. */
    System.err.println(msg);
    System.exit(1);
  }

}
