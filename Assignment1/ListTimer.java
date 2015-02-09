/* Assignment 1 - Datastructuren
 * Authors: Cornelis Boon - 10561145, Tim Groot - %NUMMER%
 * Emails: cornelis.boon@student.uva.nl, tim.groot@student.uva.nl
 * Date: 09-02-2015
 * File: ListTimer.java
 * 
 * Class description: 
 * Class that times the performance of a data structure that 
 * implements the List interface. 
 */

import java.lang.*;
import java.util.*;

public class ListTimer extends CollectionTimer {

    private List<Integer> list;
    /* The list that will be benchmarked. */

    public ListTimer(List<Integer> list) {
    /* Constructor that creates a ListTimer instance for the given list. */  
        super();
        this.list = list;
    }

    public ListTimer(List<Integer> list, Long elemGenSeed) { 
    /* Constructor that creates a ListTimer instance for 
    * that given list that will populate it with data generated 
    * using the specified seed. 
    */
        this(list, elemGenSeed.longValue());
    }

    public ListTimer(List<Integer> list, long elemGenSeed) { 
    /* Constructor that creates a ListTimer instance for 
    * that given list that will populate it with data generated 
    * using the specified seed.
    */ 
        super(elemGenSeed);
        this.list = list;
    }

    public void addElement(Integer elem) {
    /* Adds an Integer object to the list */
        list.add(elem);
    }

    public void removeElement() {
    /*Removes an object from the list*/
        if(isEmpty()) {
            throw new IndexOutOfBoundsException();
        }
        try {
            list.remove(0);
        }
        catch (UnsupportedOperationException e) {
            throw e;
        }
    }

    public int getSize() {
    /* Returns the size of the list. */    
        return list.size();
    }

    public boolean isEmpty() {
    /*Tells whether the list is empty */
        return list.isEmpty();
    }

}
