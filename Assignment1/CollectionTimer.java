/* Assignment 1 - Datastructuren
 * Authors: Cornelis Boon - 10561145, Tim Groot - %NUMMER%
 * Emails: cornelis.boon@student.uva.nl, tim.groot@student.uva.nl
 * Date: 09-02-2015
 * File: CollectionTimer.java
 * Class description: 
 * 
 */

import java.lang.*;
import java.util.*;



public abstract class CollectionTimer extends Object {
    /*  Abstract class that is to be extended by classes that wish 
     * to time the performance of some data structure. 
     */

    public static final int[] DEFAULT_MUTATIONS = {10000, -10000};
    /* Default sequence of inserts and deletions that is used to time the
    * data structure: 10000 insertions followed by their removal.
    */

    private Random elemGen;
    /* Generator of objects that inserted into the data structure. */
      
    public CollectionTimer() {
        /* Default constructor. */
        elemGen = new Random(0);
    }

    public CollectionTimer(long elemGenSeed) {
    /* Constructor that creates a CollectionTimer instance 
    * with a random object generator with the specified seed.
    */    
        elemGen = new Random(elemGenSeed);
    }

    public abstract void addElement(Integer elem);
    /* Adds the given object to the data structure.*/

    public abstract void removeElement();
    /* Removes some object from the data structure. */

    public abstract int getSize();
    /* Determines the size of the data structure that is being timed. */

    public abstract boolean isEmpty();
    /* Tests wheter the data structure that is being timed is empty. */    

    public void insert(int amount) {
    /* Inserts a specified number of Integer objects into the data structure. */
        for(int i = 0; i < amount; i++) {
            addElement(elemGen.nextInt());
        }
    }

    public boolean extract(int amount) {
    /* Removes a specified number of objects from the data structure. */
        try {
            for(int i = amount; i < 0; i ++) {
									removeElement();
            }
				} catch (RuntimeException e) {
						return false;
				} 
				return true;
    }

    public long time() {
    /* Times a sequence of operations on the underlying data structure. */
        return time(DEFAULT_MUTATIONS);
    }

    public long time(int[] mutations) {
    /*Times a specified sequence of operations on the underlying data structure.*/
        long start = System.currentTimeMillis();
        for(int op : mutations) {
            if(op > 0) {
                insert(op);
            } else {
								boolean succes = extract(op);
								if(! succes) {
									return -1;
								}
            }
        }
        long stop = System.currentTimeMillis();
        return (stop-start);
    }

}
