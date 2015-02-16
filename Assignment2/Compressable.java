/* Assignment 2 - Datastructuren
 * Authors: Cornelis Boon - 10561145, Tim Groot - 10165673
 * Emails: cornelis.boon@student.uva.nl, tim.groot@student.uva.nl
 * Date: 16-02-2015
 * File: Compressable.java
 * 
 * Class description: An interface for classes that compute the hashcode
 * within a hashtable of an object. 
 */

public interface Compressable {
	/* Calculates the index given a key */
    public int calcIndex(String key);
}

