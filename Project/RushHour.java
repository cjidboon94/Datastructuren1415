import java.util.*;
import java.lang.*;

public class RushHour {
	
	private Board puzzle;
	
	public RushHour(Board puzzle){
		this.puzzle = puzzle;
	}
	
	public int play(){
		int move = 0;
		printBoard(move);
		Scanner reader = new Scanner(System.in);
		while(!won()){
				
				try{
					String name = reader.next();
					if(name.equals("RESET")){
						return 1;
					}
					Vehicle vehicle = puzzle.getVehicle(name);
					int moves = reader.nextInt();
					vehicle.mainMove(moves, puzzle);
				} catch(RuntimeException e) {
					System.out.println("Incorrect input");
					continue;
				}
			move++;
			printBoard(move);
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
