/* Assignment 2 - Datastructuren
 * Authors: Cornelis Boon - 10561145, Tim Groot - 10165673
 * Emails: cornelis.boon@student.uva.nl, tim.groot@student.uva.nl
 * Date: 16-02-2015
 * File: Division.java
 * 
 * Class description: An implementation of the Compressable interface. 
 * Computes the hashcode of an object given their key.
 */



import java.lang.*;
import java.util.*;

public class Division implements Compressable {
    int table_length;
    int initial = 11;
    int multiplier = 31;
    
    Division(int length) {
        table_length = length;
    }

    public int calcIndex(String key) {
        int index;
        
        index = Math.abs(hashCode(key)) % table_length;
        return index;
    }

    int hashCode(String key) {
        int h = initial;
        char[] val = key.toCharArray();
        int len = key.length();
   
        for (int i = 0; i < len; i++) {
            h = multiplier * h + val[i];
        }
        return h;
    }

}

