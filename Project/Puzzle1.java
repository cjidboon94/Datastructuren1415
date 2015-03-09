public class Puzzle1 extends RushHour {

	public static void main(String[] args) {
		setup();
	}

	public static void setup() {
		//Do setup
		Board puzzle = new Board(6);

		puzzle.board[2][3] = new Car(0, 2, 3, 2, 4, true);
		puzzle.board[2][4] = puzzle.board[2][3];
		
		
		puzzle.board[0][2] = new Truck(1, 0, 2, 1, 2, 2, 2);
		puzzle.board[1][2] = puzzle.board[0][2];
		puzzle.board[2][2] = puzzle.board[0][2];
		
		puzzle.board[0][3] = new Car(0, 0, 3, 0, 4);
		puzzle.board[0][4] = puzzle.board[0][3]
		
		puzzle.board[0][5] = new Truck(1, 0, 5, 1, 5, 2, 5);
		puzzle[1][5] = puzzle.board[0][5];
		puzzle[2][5] = puzzle.board[0][5];
		
		puzzle.board[4][0] = new Car(1, 4, 0, 5, 0);
		puzzle.board[5][0] = puzzle.board[4][0];
		
		puzzle.board[4][1] = new Car(0, 4, 1, 4, 2);
		puzzle.board[4][2] = puzzle.board[4][1];
		
		puzzle.board[3][3] = new Truck(1, 3, 3, 4, 3, 5, 3);
		puzzle.board[4][3] = puzzle.board[3][3]
		puzzle.board[5][3] = puzzle.board[3][3]
		
		puzzle.board[3][4] = new Car(0, 3, 4, 3, 5);
		puzzle.board[3][5] = puzzle.board[3][4];
		
		puzzle.board[5][4] = new Car(0, 5, 4, 5, 5);
		puzzle.board[5][5] = puzzle.board[5][4];
		
		//End setup
		super.play(puzzle)
	}
	
}
