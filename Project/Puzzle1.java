public class Puzzle1 implements Runnable{

	GUI gui;

	public Puzzle1(GUI g) {
		gui = g;
	}

	public void run(){
		begin();
	}
	
	public void begin(){
		RushHour RH = new RushHour(setup(),gui);
		while(RH.play() == 1){
			System.out.println("Restarting");
			RH = new RushHour(setup(),gui);
		}
	}

	public static Board setup() {
		//Do setup
		Board puzzle = new Board(6);

		puzzle.board[2][3] = new Car('p', 0, 2, 3, 2, 4, true);
		puzzle.board[2][4] = puzzle.board[2][3];
		puzzle.addVehicle(0, puzzle.board[2][3]);
		
		puzzle.board[0][2] = new Truck('1', 1, 0, 2, 1, 2, 2, 2);
		puzzle.board[1][2] = puzzle.board[0][2];
		puzzle.board[2][2] = puzzle.board[0][2];
		puzzle.addVehicle(1, puzzle.board[0][2]);
		
		puzzle.board[0][3] = new Car('2', 0, 0, 3, 0, 4);
		puzzle.board[0][4] = puzzle.board[0][3];
		puzzle.addVehicle(2, puzzle.board[0][3]);

		puzzle.board[0][5] = new Truck('3', 1, 0, 5, 1, 5, 2, 5);
		puzzle.board[1][5] = puzzle.board[0][5];
		puzzle.board[2][5] = puzzle.board[0][5];
		puzzle.addVehicle(3, puzzle.board[0][5]);
		
		puzzle.board[4][0] = new Car('4', 1, 4, 0, 5, 0);
		puzzle.board[5][0] = puzzle.board[4][0];
		puzzle.addVehicle(4, puzzle.board[4][0]);
		
		puzzle.board[4][1] = new Car('5', 0, 4, 1, 4, 2);
		puzzle.board[4][2] = puzzle.board[4][1];
		puzzle.addVehicle(5, puzzle.board[4][1]);
		
		puzzle.board[3][3] = new Truck('6', 1, 3, 3, 4, 3, 5, 3);
		puzzle.board[4][3] = puzzle.board[3][3];
		puzzle.board[5][3] = puzzle.board[3][3];
		puzzle.addVehicle(6, puzzle.board[3][3]);
		
		puzzle.board[3][4] = new Car('7', 0, 3, 4, 3, 5);
		puzzle.board[3][5] = puzzle.board[3][4];
		puzzle.addVehicle(7, puzzle.board[3][4]);
		
		puzzle.board[5][4] = new Car('8', 0, 5, 4, 5, 5);
		puzzle.board[5][5] = puzzle.board[5][4];
		puzzle.addVehicle(8, puzzle.board[5][4]);

		return puzzle;
	}
	

	
}