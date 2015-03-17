/*
 * Project - Datastructuren - RushHour
 * Authors: Cornelis Boon - 10561145, Tim Groot - 10165673
 * Emails: cornelis.boon@student.uva.nl, tim.groot@student.uva.nl
 * Date: 17-03-2015
 * File: RushHour.java
 * 
 * Class description: This class runs the playable aspect of the game.
 * Essentially has one loop where it handles the input and passes it on
 * onto the relevant vehicle/class
 */




import java.util.Scanner;

public class RushHour {
	
	/* The board on which is played*/
	private Board puzzle;
	/* A reference to the gui */
	private GUI g;
	
	/*Default constructor*/
	public RushHour(Board puzzle, GUI gui) {
		this.puzzle = puzzle;
		g = gui;
		g.setBoard(puzzle);
		g.drawBoard();
	}
	

	public int play() {

		int move = 0;
		Scanner reader = new Scanner(System.in);
		String previous = "";
		String name;

		/*The main loop with which the game is played in the terminal starts here.
		This continues untill the game is won, or the reader detects a 'quit' command.*/
		while(!won()) {
			printBoard(move);
			g.drawBoard();
				try {
					System.out.println("Which vehicle would you like to move? (Or type QUIT to quit)");
					name = reader.next();
					if(name.equals("0")){
						System.out.println("There's no zero'th object");
						continue; 

					} else if(name.equalsIgnoreCase("quit")) {
						System.out.println("Thank you for playing!");
						reader.close();
						System.exit(0);
						return 0;
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
			if(!previous.equals(name)) {
				previous = name;
				move++;
			}
		}
		reader.close();
		g.drawBoard();
		System.out.println("You won in " + move + " moves.");
		System.out.println("Good job!");
		return 0;
	}

	private boolean won() { 
	/*The goal car must reach the most right side of its starting lane. Position is always horizontal*/
		return ( 	puzzle.board[Math.round((float)puzzle.getSize()/2)-1][puzzle.getSize()-1] != null && 
					puzzle.board[Math.round((float)puzzle.getSize()/2)-1][puzzle.getSize()-1].equals(puzzle.getVehicle("1"))); 
	}

	/* Traverses the board and prints it out*/
	private void printBoard(int move) {	
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
	
	public Board getBoard() {
		return puzzle;
	}
}