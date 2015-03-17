/*
 * Project - Datastructuren - RushHour
 * Authors: Cornelis Boon - 10561145, Tim Groot - 10165673
 * Emails: cornelis.boon@student.uva.nl, tim.groot@student.uva.nl
 * Date: 17-03-2015
 * File: Puzzle1.java
 * 
 * Class description: The first puzzle. Sets the game up and passes on control to
 * RushHour
 */


public class Puzzle1 implements Runnable {
	/*the GUI interface is ran in another thread than the
	game that plays throught the terminal. Since we need
	multithreading for this, this class implements the runnable interface
	*/

	GUI gui;

	public Puzzle1(GUI g) {
		gui = g;
	}

	public void run() {
		begin();
	}
	
	/*Initializes the RushHour object and starts the actual game*/
	public void begin() {
		RushHour RH = new RushHour(setup(),gui);
		RH.play();
	}

	/*Initializes the board */
	public static Board setup() {
		Board puzzle = new Board(6); 

		puzzle.board[2][3] = new Car('1', 0, 2, 3, 2, 4, true);
		puzzle.board[2][4] = puzzle.board[2][3]; 
		puzzle.addVehicle(0, puzzle.board[2][3]);
		
		puzzle.board[0][2] = new Truck('A', 1, 0, 2, 1, 2, 2, 2);
		puzzle.board[1][2] = puzzle.board[0][2];
		puzzle.board[2][2] = puzzle.board[0][2];
		puzzle.addVehicle(1, puzzle.board[0][2]);
		
		puzzle.board[0][3] = new Car('B', 0, 0, 3, 0, 4);
		puzzle.board[0][4] = puzzle.board[0][3];
		puzzle.addVehicle(2, puzzle.board[0][3]);

		puzzle.board[0][5] = new Truck('C', 1, 0, 5, 1, 5, 2, 5);
		puzzle.board[1][5] = puzzle.board[0][5];
		puzzle.board[2][5] = puzzle.board[0][5];
		puzzle.addVehicle(3, puzzle.board[0][5]);
		
		puzzle.board[4][0] = new Car('D', 1, 4, 0, 5, 0);
		puzzle.board[5][0] = puzzle.board[4][0];
		puzzle.addVehicle(4, puzzle.board[4][0]);
		
		puzzle.board[4][1] = new Car('E', 0, 4, 1, 4, 2);
		puzzle.board[4][2] = puzzle.board[4][1];
		puzzle.addVehicle(5, puzzle.board[4][1]);
		
		puzzle.board[3][3] = new Truck('F', 1, 3, 3, 4, 3, 5, 3);
		puzzle.board[4][3] = puzzle.board[3][3];
		puzzle.board[5][3] = puzzle.board[3][3];
		puzzle.addVehicle(6, puzzle.board[3][3]);
		
		puzzle.board[3][4] = new Car('G', 0, 3, 4, 3, 5);
		puzzle.board[3][5] = puzzle.board[3][4];
		puzzle.addVehicle(7, puzzle.board[3][4]);
		
		puzzle.board[5][4] = new Car('H', 0, 5, 4, 5, 5);
		puzzle.board[5][5] = puzzle.board[5][4];
		puzzle.addVehicle(8, puzzle.board[5][4]);

		return puzzle;
	}
}