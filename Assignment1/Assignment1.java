/* Assignment 1 - Datastructuren
 * Authors: Cornelis Boon - 10561145, Tim Groot - 10165673
 * Emails: cornelis.boon@student.uva.nl, tim.groot@student.uva.nl
 * Date: 09-02-2015
 * File: Assignment1.java
 * 
 * Class description: Main class for this assignment.
 * It times the mutations (population and depopulation) 
 * of 4 implementations of the List interface:
 * Stack, Vector, ArrayList and LinkedList;
 * and 2 implementations of the Queue interface:
 * LinkedList and PriorityQueue;
 * 
 * Timing takes place by  subtracting the number of milliseconds since 
 * the UNIX epoch before and after the required operations have taken place. 
 * Hence the accuracy of the benchmarks is platform dependent and may be 
 * influenced by other processes running on the host machine.
 */


/* Question: How will the implementation of removeElement() affect 
 * the performance of different ADT's? 
 * 
 * Answer: Since removing elements from an array can be 
 * implemented in different ways, this method affects 
 * the performance of the data structures. 
 * 
 * In our implementation, we simply pop the first element from the array. 
 * This means very little for the performance of, for example, lists and stacks. 
 * If we decide to remove the n-th  element from the same array, lists and queues, 
 * for example, could differ a lot in performance. 
 * 
 * The lists would take longer to process here, since the list iterates 
 * all the way up to that n-th element. It all depends on the properties
 * of the abstract data structures and how well they handle aspects or removal.
 */

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
        lists.add(new ArrayList<Integer>());
        lists.add(new LinkedList<Integer>());
        lists.add(new Stack<Integer>());
        lists.add(new Vector<Integer> ());
        
        queues = new ArrayList<Queue<Integer>>();
        queues.add(new LinkedList<Integer>());
        queues.add(new PriorityQueue<Integer>());
    }
    
    public static void main(String[] args) {
    /* Main method of the program. */
        Assignment1 init = new Assignment1();
        int[] mutations;
        if(args.length == 0) {
            init.benchmark();
        }
        else if(args.length >= 1) { 
            /* If any arguments, parse arguments */
            if(args[0].equals("-s")) {
                /* Check for a seed  */                      
                
                if(args.length == 1) {
                    errorExit("No seed provided");
                }
                try {
                    long seed = Long.parseLong(args[1]);
                    if(args.length == 2) {
                        init.benchmark(seed);
                    }
                    else {
                        /* Parse mutations */
                        mutations = new int[args.length-2];
                        String[] mutationcopy = new String[args.length-2];
                        System.arraycopy(args, 2, mutationcopy, 0, args.length-2);
                        int i = 0;
                        for(String mutation : mutationcopy) {
                            mutations[i] = Integer.parseInt(mutation);
                            i++;
                        }
                        init.benchmark(seed, mutations);
                    }
                } 
                catch(NumberFormatException e) {
                    errorExit("NumberFormatException: " + e.getMessage());
                }
            }
            else {
                /* If no seed, just parse mutations */
                mutations = new int[args.length];
                int i = 0;
                try {
                    for(String arg : args) {
                        mutations[i] = Integer.parseInt(arg);
                        i++;
                    }
                    init.benchmark(0, mutations);
                }
                catch(NumberFormatException e) {
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
        for(List<Integer> list : accessor.lists) {
            ListTimer timer = new ListTimer(list);
            System.out.println(list.getClass().getSimpleName() + ": " 
                                + timer.time() + "ms");
        }
        for(Queue<Integer> queue : accessor.queues) {
            QueueTimer timer = new QueueTimer(queue);
            System.out.println(queue.getClass().getSimpleName() + ": " 
                                + timer.time() + "ms");
        }
    }   
    
    public void benchmark(long elemGenSeed) {
    /* Performs benchmark using the given seed to populate the data structures
     * and with mutations as in CollectionTimer.DEFAULT_MUTATIONS.
     */
        Assignment1 accessor = new Assignment1();
        for(List<Integer> list : accessor.lists) {
            ListTimer timer = new ListTimer(list, elemGenSeed);
            System.out.println(list.getClass().getSimpleName() + ": " 
                                + timer.time() + "ms");
        }
        for(Queue<Integer> queue : accessor.queues) {
            QueueTimer timer = new QueueTimer(queue, elemGenSeed);
            System.out.println(queue.getClass().getSimpleName() + ": " 
                                + timer.time() + "ms");
        }
    }
    
    public void benchmark(long elemGenSeed, int[] mutations) {
    /* Performs benchmark by applying the specified mutations and 
     * using the given seed to populate the data structures.
     */
        Assignment1 accessor = new Assignment1();
        for(List<Integer> list : accessor.lists) {
            ListTimer timer = new ListTimer(list, elemGenSeed);
            long time = timer.time(mutations);
            if (time == -1) {
                errorExit("Insufficient elements to extract");
            }
            System.out.println(list.getClass().getSimpleName() + ": " 
                                + time + "ms");
        }
        for(Queue<Integer> queue : accessor.queues) {
            QueueTimer timer = new QueueTimer(queue, elemGenSeed);
            long time = timer.time(mutations);
            if (time == -1) {
                errorExit("Insufficient elements to extract");
            }    
            System.out.println(queue.getClass().getSimpleName() + ": " 
                                + time + "ms");
        }
    }
    
    private static void errorExit(String msg) {
    /* Print a message to stderr and exit with value 1. */
        System.err.println(msg);
        System.exit(1);
    }
}
