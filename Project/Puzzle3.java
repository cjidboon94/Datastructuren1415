/*
 * Project - Datastructuren - RushHour
 * Authors: Cornelis Boon - 10561145, Tim Groot - 10165673
 * Emails: cornelis.boon@student.uva.nl, tim.groot@student.uva.nl
 * Date: 17-03-2015
 * File: Puzzle3.java
 * 
 * Class description: The second puzzle. Refer to Puzzle1 for more information on 
 * the methods
 */
public class Puzzle3 implements Runnable {

	GUI gui;

	public Puzzle3(GUI g) {
		gui = g;
	}

	public void run() {
		begin();
	}
	
	public void begin() {
		RushHour RH = new RushHour(setup(),gui);
		RH.play();
		
	}

	public static Board setup() {
		
		Board puzzle = new Board(6);

		puzzle.board[2][0] = new Car('1', 0, 2, 0, 2, 1, true);
		puzzle.board[2][1] = puzzle.board[2][0];
		puzzle.addVehicle(0, puzzle.board[2][0]);

		puzzle.board[0][1] = new Car('A', 0, 0, 1, 0, 2);
		puzzle.board[0][2] = puzzle.board[0][1];
		puzzle.addVehicle(1, puzzle.board[0][1]);

		puzzle.board[1][1] = new Car('B', 0, 1, 1, 1, 2);
		puzzle.board[1][2] = puzzle.board[1][1];
		puzzle.addVehicle(2, puzzle.board[1][1]);
		
		puzzle.board[0][3] = new Truck('C', 0, 0, 3, 0, 4, 0, 5);
		puzzle.board[0][4] = puzzle.board[0][3];
		puzzle.board[0][5] = puzzle.board[0][3];
		puzzle.addVehicle(3, puzzle.board[0][3]);

		puzzle.board[1][3] = new Car('D', 1, 1, 3, 2, 3);
		puzzle.board[2][3] = puzzle.board[1][3];
		puzzle.addVehicle(4, puzzle.board[1][3]);

		puzzle.board[1][4] = new Car('E', 0, 1, 4, 1, 5);
		puzzle.board[1][5] = puzzle.board[1][4];
		puzzle.addVehicle(5, puzzle.board[1][4]);

		puzzle.board[2][2] = new Car('F', 1, 2, 2, 3, 2);
		puzzle.board[3][2] = puzzle.board[2][2];
		puzzle.addVehicle(6, puzzle.board[2][2]);

		puzzle.board[2][5] = new Car('G', 1, 2, 5, 3, 5);
		puzzle.board[3][5] = puzzle.board[2][5];
		puzzle.addVehicle(7, puzzle.board[2][5]);

		puzzle.board[3][0] = new Car('H', 0, 3, 0, 3, 1);
		puzzle.board[3][1] = puzzle.board[3][0];
		puzzle.addVehicle(8, puzzle.board[3][0]);

		puzzle.board[3][3] = new Car('I', 0, 3, 3, 3, 4);
		puzzle.board[3][4] = puzzle.board[3][3];
		puzzle.addVehicle(9, puzzle.board[3][3]);

		puzzle.board[4][0] = new Car('J', 1, 4, 0, 5, 0);
		puzzle.board[5][0] = puzzle.board[4][0];
		puzzle.addVehicle(10, puzzle.board[4][0]);

		puzzle.board[4][2] = new Car('K', 1, 4, 2, 5, 2);
		puzzle.board[5][2] = puzzle.board[4][2];
		puzzle.addVehicle(11, puzzle.board[4][2]);

		puzzle.board[4][4] = new Car('L', 0, 4, 4, 4, 5);
		puzzle.board[4][5] = puzzle.board[4][4];
		puzzle.addVehicle(12, puzzle.board[4][4]);

		return puzzle;
	}
	

	
}