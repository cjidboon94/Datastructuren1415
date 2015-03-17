//Refer to puzzle1.java for comments

public class Puzzle5 implements Runnable {

	GUI gui;

	public Puzzle5(GUI g) {
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
		Board puzzle = new Board(12);

		puzzle.board[5][2] = new Car('1', 0, 5, 2, 5, 3, true);
		puzzle.board[5][3] = puzzle.board[5][2];
		puzzle.addVehicle(0, puzzle.board[5][2]);
		
		puzzle.board[0][0] = new Car('A', 1, 0, 0, 1, 0);
		puzzle.board[1][0] = puzzle.board[0][0];
		puzzle.addVehicle(1, puzzle.board[0][0]);

		puzzle.board[0][6] = new Car('B', 1, 0, 6, 1, 6);
		puzzle.board[1][6] = puzzle.board[0][6];
		puzzle.addVehicle(2, puzzle.board[0][6]);

		puzzle.board[0][7] = new Truck('C', 0, 0, 7, 0, 8, 0, 9);
		puzzle.board[0][8] = puzzle.board[0][7];
		puzzle.board[0][9] = puzzle.board[0][7];
		puzzle.addVehicle(3, puzzle.board[0][7]);

		puzzle.board[0][10] = new Car('D', 0, 0, 10, 0, 11);
		puzzle.board[0][11] = puzzle.board[0][10];
		puzzle.addVehicle(4, puzzle.board[0][10]);

		puzzle.board[1][5] = new Car('E', 1, 1, 5, 2, 5);
		puzzle.board[2][5] = puzzle.board[1][5];
		puzzle.addVehicle(5, puzzle.board[1][5]);

		puzzle.board[1][10] = new Car('F', 1, 1, 10, 2, 10);
		puzzle.board[2][10] = puzzle.board[1][10];
		puzzle.addVehicle(6, puzzle.board[1][10]);

		puzzle.board[1][11] = new Car('G', 1, 1, 11, 2, 11);
		puzzle.board[2][11] = puzzle.board[1][11];
		puzzle.addVehicle(7, puzzle.board[1][11]);

		puzzle.board[2][0] = new Truck('H', 0, 2, 0, 2, 1, 2, 2);
		puzzle.board[2][1] = puzzle.board[2][0];
		puzzle.board[2][2] = puzzle.board[2][0];
		puzzle.addVehicle(8, puzzle.board[2][0]);

		puzzle.board[2][3] = new Car('I', 0, 2, 3, 2, 4);
		puzzle.board[2][4] = puzzle.board[2][3];
		puzzle.addVehicle(9, puzzle.board[2][3]);

		puzzle.board[2][6] = new Truck('J', 1, 2, 6, 3, 6, 4, 6);
		puzzle.board[3][6] = puzzle.board[2][6];
		puzzle.board[4][6] = puzzle.board[2][6];
		puzzle.addVehicle(10, puzzle.board[2][6]);

		puzzle.board[2][7] = new Car('K', 0, 2, 7, 2, 8);
		puzzle.board[2][8] = puzzle.board[2][7];
		puzzle.addVehicle(11, puzzle.board[2][7]);

		puzzle.board[3][0] = new Truck('L', 1, 3, 0, 4, 0, 5, 0);
		puzzle.board[4][0] = puzzle.board[3][0];
		puzzle.board[5][0] = puzzle.board[3][0];
		puzzle.addVehicle(12, puzzle.board[3][0]);

		puzzle.board[3][1] = new Truck('M', 1, 3, 1, 4, 1, 5, 1);
		puzzle.board[4][1] = puzzle.board[3][1];
		puzzle.board[5][1] = puzzle.board[3][1];
		puzzle.addVehicle(13, puzzle.board[3][1]);

		puzzle.board[3][5] = new Car('N', 1, 3, 5, 4, 5);
		puzzle.board[4][5] = puzzle.board[3][5];
		puzzle.addVehicle(14, puzzle.board[3][5]);

		puzzle.board[3][7] = new Car('O', 0, 3, 7, 3, 8);
		puzzle.board[3][8] = puzzle.board[3][7];
		puzzle.addVehicle(15, puzzle.board[3][7]);

		puzzle.board[3][9] = new Car('P', 0, 3, 9, 3, 10);
		puzzle.board[3][10] = puzzle.board[3][9];
		puzzle.addVehicle(16, puzzle.board[3][9]);

		puzzle.board[4][2] = new Truck('Q', 0, 4, 2, 4, 3, 4, 4);
		puzzle.board[4][3] = puzzle.board[4][2];
		puzzle.board[4][4] = puzzle.board[4][2];
		puzzle.addVehicle(17, puzzle.board[4][2]);

		puzzle.board[4][7] = new Truck('R', 0, 4, 7, 4, 8, 4, 9);
		puzzle.board[4][8] = puzzle.board[4][7];
		puzzle.board[4][9] = puzzle.board[4][7];
		puzzle.addVehicle(18, puzzle.board[4][7]);

		puzzle.board[5][4] = new Car('S', 1, 5, 4, 5, 5);
		puzzle.board[6][4] = puzzle.board[5][4];
		puzzle.addVehicle(19, puzzle.board[5][4]);

		puzzle.board[5][5] = new Car('T', 1, 5, 5, 6, 5);
		puzzle.board[6][5] = puzzle.board[5][5];
		puzzle.addVehicle(20, puzzle.board[5][5]);

		puzzle.board[6][0] = new Truck('U', 0, 6, 0, 6, 1, 6, 2);
		puzzle.board[6][1] = puzzle.board[6][0];
		puzzle.board[6][2] = puzzle.board[6][0];
		puzzle.addVehicle(21, puzzle.board[6][0]);

		puzzle.board[6][3] = new Car('V', 1, 6, 3, 7, 3);
		puzzle.board[7][3] = puzzle.board[6][3];
		puzzle.addVehicle(22, puzzle.board[6][3]);

		puzzle.board[6][6] = new Truck('W', 1, 6, 6, 7, 6, 8, 6);
		puzzle.board[7][6] = puzzle.board[6][6];
		puzzle.board[8][6] = puzzle.board[6][6];
		puzzle.addVehicle(23, puzzle.board[6][6]);

		puzzle.board[6][7] = new Car('X', 1, 6, 7, 7, 7);
		puzzle.board[7][7] = puzzle.board[6][7];
		puzzle.addVehicle(24, puzzle.board[6][7]);

		puzzle.board[6][9] = new Car('Y', 1, 6, 9, 7, 9);
		puzzle.board[7][9] = puzzle.board[6][9];
		puzzle.addVehicle(25, puzzle.board[6][9]);

		puzzle.board[6][10] = new Car('Z', 0, 6, 10, 6, 11);
		puzzle.board[6][11] = puzzle.board[6][10];
		puzzle.addVehicle(26, puzzle.board[6][10]);

		puzzle.board[7][0] = new Truck('a', 0, 7, 0, 7, 1, 7, 2);
		puzzle.board[7][1] = puzzle.board[7][0];
		puzzle.board[7][2] = puzzle.board[7][0];
		puzzle.addVehicle(27, puzzle.board[7][0]);

		puzzle.board[7][4] = new Car('b', 0, 7, 4, 7, 5);
		puzzle.board[7][5] = puzzle.board[7][4];
		puzzle.addVehicle(28, puzzle.board[7][4]);

		puzzle.board[7][10] = new Car('c', 0, 7, 10, 7, 11);
		puzzle.board[7][11] = puzzle.board[7][10];
		puzzle.addVehicle(29, puzzle.board[7][10]);

		puzzle.board[8][0] = new Car('d', 0, 8, 0, 8, 1);
		puzzle.board[8][1] = puzzle.board[8][0];
		puzzle.addVehicle(30, puzzle.board[8][0]);

		puzzle.board[8][2] = new Car('e', 1, 8, 2, 9, 2);
		puzzle.board[9][2] = puzzle.board[8][2];
		puzzle.addVehicle(31, puzzle.board[8][2]);

		puzzle.board[8][3] = new Truck('f', 0, 8, 3, 8, 4, 8, 5);
		puzzle.board[8][4] = puzzle.board[8][3];
		puzzle.board[8][5] = puzzle.board[8][3];
		puzzle.addVehicle(32, puzzle.board[8][3]);

		puzzle.board[8][7] = new Truck('g', 0, 8, 7, 8, 8, 8, 9);
		puzzle.board[8][8] = puzzle.board[8][7];
		puzzle.board[8][9] = puzzle.board[8][7];
		puzzle.addVehicle(33, puzzle.board[8][7]);

		puzzle.board[8][11] = new Car('h', 1, 8, 11, 9, 11);
		puzzle.board[9][11] = puzzle.board[8][11];
		puzzle.addVehicle(34, puzzle.board[8][11]);

		puzzle.board[9][3] = new Truck('i', 0, 9, 3, 9, 4, 9, 5);
		puzzle.board[9][4] = puzzle.board[9][3];
		puzzle.board[9][5] = puzzle.board[9][3];
		puzzle.addVehicle(35, puzzle.board[9][3]);

		puzzle.board[9][6] = new Truck('j', 1, 9, 6, 10, 6, 11, 6);
		puzzle.board[10][6] = puzzle.board[9][6];
		puzzle.board[11][6] = puzzle.board[9][6];
		puzzle.addVehicle(36, puzzle.board[9][6]);

		puzzle.board[9][8] = new Car('k', 0, 9, 8, 9, 9);
		puzzle.board[9][9] = puzzle.board[9][8];
		puzzle.addVehicle(37, puzzle.board[9][8]);

		puzzle.board[9][10] = new Truck('l', 1, 9, 10, 10, 10, 11, 10);
		puzzle.board[10][10] = puzzle.board[9][10];
		puzzle.board[11][10] = puzzle.board[9][10];
		puzzle.addVehicle(38, puzzle.board[9][10]);

		puzzle.board[10][9] = new Car('m', 1, 10, 9, 11, 9);
		puzzle.board[11][9] = puzzle.board[10][9];
		puzzle.addVehicle(39, puzzle.board[10][9]);

		puzzle.board[10][11] = new Car('n', 1, 10, 11, 11, 11);
		puzzle.board[11][11] = puzzle.board[10][11];
		puzzle.addVehicle(40, puzzle.board[10][11]);

		puzzle.board[11][1] = new Car('o', 0, 11, 1, 11, 2);
		puzzle.board[11][2] = puzzle.board[11][1];
		puzzle.addVehicle(41, puzzle.board[11][1]);

		puzzle.board[11][3] = new Truck('p', 0, 11, 3, 11, 4, 11, 5);
		puzzle.board[11][4] = puzzle.board[11][3];
		puzzle.board[11][5] = puzzle.board[11][3];
		puzzle.addVehicle(42, puzzle.board[11][3]);

		puzzle.board[11][7] = new Car('q', 0, 11, 7, 11, 8);
		puzzle.board[11][8] = puzzle.board[11][7];
		puzzle.addVehicle(43, puzzle.board[11][7]);

		return puzzle;
	}
	

	
}