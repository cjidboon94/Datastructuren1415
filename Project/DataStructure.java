import java.util.*;
import java.lang.*;

class Datastructure {

	public static void main(String[] args) {

		Puzzle1 board1 = new Puzzle1();
		Puzzle2 board2 = new Puzzle2();
		
	    for(int i = 0; i < 6; i++) {
	    	for(int j = 0; j < 6; j++) {
	        	System.out.printf("%5d", board1.board[i][j]);
	        }
	        System.out.println();
	  	}

	  	System.out.println("");

	  	for(int i = 0; i < 6; i++) {
	    	for(int j = 0; j < 6; j++) {
	        	System.out.printf("%5d", board2.board[i][j]);
	        }
	        System.out.println();
	  	}

		//Car maincar = new Car(hor, [2][3], [2][4]);
	}


}