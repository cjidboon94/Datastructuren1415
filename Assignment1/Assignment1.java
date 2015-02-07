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
    
    public Assignment1(){
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
    
    public static void main(String[] args){
    /* Main method of the program. */
        Assignment1 init = new Assignment1();
        int[] mutations;
        if(args.length == 0){
            init.benchmark();
        }
        else if (args.length >= 1){
            if(args[0].equals("-s")){
                if(args.length == 1){
                    errorExit("No seed provided");
                }
                try{
                    long seed = Long.parseLong(args[1]);
                    if(args.length == 2){
                        init.benchmark(seed);
                    }
                    else {
                        mutations = new int[args.length-2];
                        String[] mutationcopy = new String[args.length-2];
                        System.arraycopy(args, 2, mutationcopy, 0, args.length-2);
                        int i = 0;
                        for(String mutation : mutationcopy){
                            mutations[i] = Integer.parseInt(mutation);
                            i++;
                        }
                        init.benchmark(seed, mutations);
                    }
                } catch(NumberFormatException e) {
                    errorExit("NumberFormatException: " + e.getMessage());
                }
            }
            else{
                mutations = new int[args.length];
                int i = 0;
                try{
                    for(String arg : args){
                        mutations[i] = Integer.parseInt(arg);
                        i++;
                    }
                    init.benchmark(0, mutations);
                }catch(NumberFormatException e) {
                    errorExit("NumberFormatException: " + e.getMessage());
                }
            }
        }
    }
     
	public void benchmark() {
    /* Performs benchmark with random seed 0 to populate the data structures
     * and with mutations as in CollectionTimer.DEFAULT_MUTATIONS.
     */
        Assignment1 accessor = new Assignment1();
        for(List<Integer> list : accessor.lists){
            ListTimer timer = new ListTimer(list);
            try {
                System.out.println(list.getClass().getName() + ": " + timer.time() + "ms");
            } catch(RuntimeException e) {
                errorExit("RuntimeException: " + e.getMessage());
            }
        }
        for(Queue<Integer> queue : accessor.queues){
            QueueTimer timer = new QueueTimer(queue);
            try {
                System.out.println(queue.getClass().getName() + ": " + timer.time() + "ms");
             } catch(RuntimeException e) {
                errorExit("RuntimeException: " + e.getMessage());
            }
        }
    }   
    
    public void benchmark(long elemGenSeed){
    /* Performs benchmark using the given seed to populate the data structures
     * and with mutations as in CollectionTimer.DEFAULT_MUTATIONS.
     */
        Assignment1 accessor = new Assignment1();
        for(List<Integer> list : accessor.lists){
            ListTimer timer = new ListTimer(list, elemGenSeed);
            try{
                System.out.println(list.getClass().getName() + ": " + timer.time() + "ms");
            } catch(RuntimeException e) {
                errorExit("RuntimeException: " + e.getMessage());
            }
        }
        for(Queue<Integer> queue : accessor.queues){
            QueueTimer timer = new QueueTimer(queue, elemGenSeed);
            try{
                System.out.println(queue.getClass().getName() + ": " + timer.time() + "ms");
            } catch(RuntimeException e){
                errorExit("RuntimeException: " + e.getMessage());
            }
        }
    }
    
    public void benchmark(long elemGenSeed, int[] mutations){
    /* Performs benchmark by applying the specified mutations and 
     * using the given seed to populate the data structures.
     */
        Assignment1 accessor = new Assignment1();
        for(List<Integer> list : accessor.lists){
            ListTimer timer = new ListTimer(list, elemGenSeed);
            try{
                System.out.println(list.getClass().getName() + ": " + timer.time(mutations) + "ms");
            } catch(RuntimeException e){
                errorExit("RuntimeException: " + e.getMessage());
            }
        }
        for(Queue<Integer> queue : accessor.queues){
            QueueTimer timer = new QueueTimer(queue, elemGenSeed);
            try{
                System.out.println(queue.getClass().getName() + ": " + timer.time(mutations) + "ms");
            } catch(RuntimeException e){
                errorExit("RuntimeException: " + e.getMessage());
            }
        }
    }
    
    private static void errorExit(String msg){
    /* Print a message to stderr and exit with value 1. */
        System.err.println(msg);
        System.exit(1);
    } 
}
