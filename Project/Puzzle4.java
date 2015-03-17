//Refer to Puzzle1.java for comments

public class Puzzle4 implements Runnable {

	GUI gui;

	public Puzzle4(GUI g) {
		gui = g;
	}

	public void run() {
		begin();
	}
	
	public void begin() {
		RushHour RH = new RushHour(setup(),gui);
		while(RH.play() == 1){
			System.out.println("Restarting");
			RH = new RushHour(setup(),gui);
		}
	}

	public static Board setup() {
		//Do setup
		Board puzzle = new Board(9);

		puzzle.board[4][1] = new Car('1', 0, 4, 1, 4, 2, true);
		puzzle.board[4][2] = puzzle.board[4][1];
		puzzle.addVehicle(0, puzzle.board[4][1]);

		puzzle.board[0][0] = new Car('A', 1, 0, 0, 1, 0);
		puzzle.board[1][0] = puzzle.board[0][0];
		puzzle.addVehicle(1, puzzle.board[0][0]);
		
		puzzle.board[0][1] = new Truck('B', 0, 0, 1, 0, 2, 0, 3);
		puzzle.board[0][2] = puzzle.board[0][1];
		puzzle.board[0][3] = puzzle.board[0][1];
		puzzle.addVehicle(2, puzzle.board[0][1]);

		puzzle.board[0][5] = new Truck('C', 1, 0, 5, 1, 5, 2, 5);
		puzzle.board[1][5] = puzzle.board[0][5];
		puzzle.board[2][5] = puzzle.board[0][5];
		puzzle.addVehicle(3, puzzle.board[0][5]);

		puzzle.board[1][3] = new Truck('D', 1, 1, 3, 2, 3, 3, 3);
		puzzle.board[2][3] = puzzle.board[1][3];
		puzzle.board[3][3] = puzzle.board[1][3];
		puzzle.addVehicle(4, puzzle.board[1][3]);

		puzzle.board[1][6] = new Truck('E', 0, 1, 6, 1, 7, 1, 8);
		puzzle.board[1][7] = puzzle.board[1][6];
		puzzle.board[1][8] = puzzle.board[1][6];
		puzzle.addVehicle(5, puzzle.board[1][6]);

		puzzle.board[2][8] = new Truck('F', 1, 2, 8, 3, 8, 4, 8);
		puzzle.board[3][8] = puzzle.board[2][8];
		puzzle.board[4][8] = puzzle.board[2][8];
		puzzle.addVehicle(6, puzzle.board[2][8]);

		puzzle.board[3][0] = new Car('G', 0, 3, 0, 3, 1);
		puzzle.board[3][1] = puzzle.board[3][0];
		puzzle.addVehicle(7, puzzle.board[3][0]);

		puzzle.board[3][5] = new Truck('H', 0, 3, 5, 3, 6, 3, 7);
		puzzle.board[3][6] = puzzle.board[3][5];
		puzzle.board[3][7] = puzzle.board[3][5];
		puzzle.addVehicle(8, puzzle.board[3][5]);

		puzzle.board[4][0] = new Car('I', 1, 4, 0, 5, 0);
		puzzle.board[5][0] = puzzle.board[4][0];
		puzzle.addVehicle(9, puzzle.board[4][0]);

		puzzle.board[4][3] = new Car('J', 1, 4, 3, 5, 3);
		puzzle.board[5][3] = puzzle.board[4][3];
		puzzle.addVehicle(10, puzzle.board[4][3]);

		puzzle.board[5][2] = new Truck('K', 1, 5, 2, 6, 2, 7, 2);
		puzzle.board[6][2] = puzzle.board[5][2];
		puzzle.board[7][2] = puzzle.board[5][2];
		puzzle.addVehicle(11, puzzle.board[5][2]);

		puzzle.board[5][5] = new Truck('L', 0, 5, 5, 5, 6, 5, 7);
		puzzle.board[5][6] = puzzle.board[5][5];
		puzzle.board[5][7] = puzzle.board[5][5];
		puzzle.addVehicle(12, puzzle.board[5][5]);

		puzzle.board[5][8] = new Truck('M', 1, 5, 8, 6, 8, 7, 8);
		puzzle.board[6][8] = puzzle.board[5][8];
		puzzle.board[7][8] = puzzle.board[5][8];
		puzzle.addVehicle(13, puzzle.board[5][8]);

		puzzle.board[6][0] = new Car('N', 0, 6, 0, 6, 1);
		puzzle.board[6][1] = puzzle.board[6][0];
		puzzle.addVehicle(14, puzzle.board[6][0]);

		puzzle.board[6][3] = new Car('O', 1, 6, 3, 7, 3);
		puzzle.board[7][3] = puzzle.board[6][3];
		puzzle.addVehicle(15, puzzle.board[6][3]);

		puzzle.board[6][4] = new Car('P', 0, 6, 4, 6, 5);
		puzzle.board[6][5] = puzzle.board[6][4];
		puzzle.addVehicle(16, puzzle.board[6][4]);

		puzzle.board[7][0] = new Car('Q', 1, 7, 0, 8, 0);
		puzzle.board[8][0] = puzzle.board[7][0];
		puzzle.addVehicle(17, puzzle.board[7][0]);

		puzzle.board[7][4] = new Car('R', 1, 7, 4, 8, 4);
		puzzle.board[8][4] = puzzle.board[7][4];
		puzzle.addVehicle(18, puzzle.board[7][4]);

		puzzle.board[8][1] = new Truck('S', 0, 8, 1, 8, 2, 8, 3);
		puzzle.board[8][2] = puzzle.board[8][1];
		puzzle.board[8][3] = puzzle.board[8][1];
		puzzle.addVehicle(19, puzzle.board[8][1]);

		puzzle.board[8][5] = new Car('T', 0, 8, 5, 8, 6);
		puzzle.board[8][6] = puzzle.board[8][5];
		puzzle.addVehicle(20, puzzle.board[8][5]);

		puzzle.board[8][7] = new Car('U', 0, 8, 7, 8, 8);
		puzzle.board[8][8] = puzzle.board[8][7];
		puzzle.addVehicle(21, puzzle.board[8][7]);

		return puzzle;
	}
	

	
}