/*Creates every vehicle object for this puzzle
Since every "Puzzle#" file is very similar, refer to this
file for code comments.*/

public class Puzzle1 implements Runnable {
	/*the GUI interface is ran in another thread than the
	game that plays throught the terminal. Since we need
	multithreading for this, this class implements runnable
	and there is a public method called run.*/

	GUI gui;

	public Puzzle1(GUI g) {
		gui = g;
	}

	public void run() {
		begin();
	}
	
	//Initialize and RushHour object
	public void begin() {
		RushHour RH = new RushHour(setup(),gui);
		while(RH.play() == 1){
			System.out.println("Restarting");
			RH = new RushHour(setup(),gui);
		}
	}

	//Initialize the car and truck objects at the right board place
	public static Board setup() {
		//Do setup
		Board puzzle = new Board(6); //Create board with a given size

		//Create the car that needs to get out of the rush hour
		//Car parameters: 	name, orientation(0=horizontal,1=vertical)
		// 					the coordinates, and boolean isGoalCar

		puzzle.board[2][3] = new Car('1', 0, 2, 3, 2, 4, true);
		puzzle.board[2][4] = puzzle.board[2][3]; //connect the two parts
		puzzle.addVehicle(0, puzzle.board[2][3]);
		
		//Similarly to a car, except a truck occupies three spaces.
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