import java.util.*;
import java.lang.*;

public class RushHour {
	
	private Board puzzle;
	
	public RushHour(Board puzzle){
		this.puzzle = puzzle;
	}
	
	public int play(){
		int move = 0;
		Scanner reader = new Scanner(System.in);
		String previous = "";
		String name;
		while(!won()){
			printBoard(move);
				try{
					System.out.println("Which vehicle would you like to move? (Or type RESET to restart)");
					name = reader.next();
					if(name.equals("RESET")){
						return 1;
					} else if(name.equals("0")){
						System.out.println("There's no zeroth object");
						continue;
					}
					Vehicle vehicle = puzzle.getVehicle(name);
					System.out.println("How many steps would you like to move it?");
					System.out.println("Positive value for right/down, Negative value for left/up");
					int moves = reader.nextInt();
					if(moves == 0){
						System.out.println("Why would you take no steps? Seriously. Why?");
						continue;
					}
					vehicle.mainMove(moves, puzzle);
				} catch(RuntimeException e) {
					System.out.println("Incorrect input");
					continue;
				}
			if(!previous.equals(name)){
				previous = name;
				move++;
			}
		}
		reader.close();
		System.out.println("You won in " + move + " moves.");
		System.out.println("Good job!");
		return 0;
	}

	private boolean won(){ 
		return ( 	puzzle.board[2][4] != null && puzzle.board[2][5] != null && 
					puzzle.board[2][4].equals(puzzle.getVehicle("p")) &&
					puzzle.board[2][5].equals(puzzle.getVehicle("p"))); 
	}

	private void printBoard(int move){	
		System.out.println("Move:" + move);
		System.out.println();
	    for(int i = 0; i < puzzle.getSize(); i++) {
	    	for(int j = 0; j < puzzle.getSize(); j++) {
	        	if(puzzle.board[i][j] == null){
					System.out.printf("0");
				} else {
					System.out.printf(""+puzzle.board[i][j].getName());
				}
	        }
	        System.out.println();
	  	}

	  	System.out.println("");
	}
}
