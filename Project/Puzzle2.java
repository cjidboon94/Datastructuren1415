public class Puzzle2 implements Runnable {

	GUI gui;

	public Puzzle2(GUI g) {
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

		Board puzzle = new Board(6);

		puzzle.board[2][2] = new Car('1', 0, 2, 2, 2, 3, true);
		puzzle.board[2][3] = puzzle.board[2][2];
		puzzle.addVehicle(0, puzzle.board[2][3]);

		puzzle.board[0][2] = new Car('A', 0, 0, 2, 0, 3);
		puzzle.board[0][3] = puzzle.board[0][2];
		puzzle.addVehicle(1, puzzle.board[0][3]);


		puzzle.board[0][4] = new Car('B', 0, 0, 4, 0, 5);
		puzzle.board[0][5] = puzzle.board[0][4];
		puzzle.addVehicle(2, puzzle.board[0][5]);

		puzzle.board[1][1] = new Car('C', 0, 1, 1, 1, 2);
		puzzle.board[1][2] = puzzle.board[1][1];
		puzzle.addVehicle(3, puzzle.board[1][2]);

		puzzle.board[1][3] = new Car('D', 0, 1, 3, 1, 4);
		puzzle.board[1][4] = puzzle.board[1][3];
		puzzle.addVehicle(4, puzzle.board[1][3]);

		puzzle.board[1][5] = new Truck('E', 1, 1, 5, 2, 5, 3, 5);
		puzzle.board[2][5] = puzzle.board[1][5];
		puzzle.board[3][5] = puzzle.board[1][5];
		puzzle.addVehicle(5, puzzle.board[1][5]);

		puzzle.board[2][4] = new Car('F', 1, 2, 4, 3, 4);
		puzzle.board[3][4] = puzzle.board[2][4];
		puzzle.addVehicle(6, puzzle.board[2][4]);

		puzzle.board[3][0] = new Car('G', 0, 3, 0, 3, 1);
		puzzle.board[3][1] = puzzle.board[3][0];
		puzzle.addVehicle(7, puzzle.board[3][0]);

		puzzle.board[3][2] = new Car('H', 0, 3, 2, 3, 3);
		puzzle.board[3][3] = puzzle.board[3][2];
		puzzle.addVehicle(8, puzzle.board[3][2]);

		puzzle.board[4][0] = new Car('I', 1, 4, 0, 5, 0);
		puzzle.board[5][0] = puzzle.board[4][0];
		puzzle.addVehicle(9, puzzle.board[4][0]);

		puzzle.board[4][3] = new Car('J', 1, 4, 3, 5, 3);
		puzzle.board[5][3] = puzzle.board[4][3];
		puzzle.addVehicle(10, puzzle.board[4][3]);

		puzzle.board[4][4] = new Car('K', 0, 4, 4, 4, 5);
		puzzle.board[4][5] = puzzle.board[4][4];
		puzzle.addVehicle(11, puzzle.board[4][4]);

		puzzle.board[5][4] = new Car('L', 0, 5, 4, 5, 5);
		puzzle.board[5][5] = puzzle.board[5][4];
		puzzle.addVehicle(12, puzzle.board[5][5]);

		return puzzle;
	}
}
