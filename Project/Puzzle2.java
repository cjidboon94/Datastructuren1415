public class Puzzle2 extends RushHour {

	public static void main(String[] args) {
		setup();
	}

	public static void setup() {	

		Board puzzle = new Board(6);

		puzzle.board[2][2] = new Car(0, 2, 2, 2, 3, true);
		puzzle.board[2][3] = puzzle.board[2][2];

		puzzle.board[0][2] = new Car(0, 0, 2, 0, 3);
		puzzle.board[0][3] = puzzle.board[0][2];

		puzzle.board[0][4] = new Car(0, 0, 4, 0, 4);
		puzzle.board[0][5] = puzzle.board[0][4];

		puzzle.board[1][1] = new Car(0, 1, 1, 1, 2);
		puzzle.board[1][2] = puzzle.board[1][1];

		puzzle.board[1][3] = new Car(0, 1, 3, 1, 4);
		puzzle.board[1][4] = puzzle.board[1][3];

		puzzle.board[1][5] = new Truck(1, 1, 5, 2, 5 3, 5);
		puzzle.board[2][5] = puzzle.board[1][5];
		puzzle.board[3][5] = puzzle.board[1][5];

		puzzle.board[2][4] = new Car(1, 2, 4, 3, 4);
		puzzle.board[3][4] = puzzle.board[2][4];

		puzzle.board[3][0] = new Car(0, 3, 0, 3, 1);
		puzzle.board[3][1] = puzzle.board[3][0];

		puzzle.board[3][2] = new Car(0, 3, 2, 3, 3);
		puzzle.board[3][3] = puzzle.board[3][2];

		puzzle.board[4][0] = new Car(1, 4, 0, 5, 0);
		puzzle.board[5][0] = puzzle.board[4][0];

		puzzle.board[4][3] = new Car(1, 4, 3, 5, 3);
		puzzle.board[5][3] = puzzle.board[4][3];

		puzzle.board[4][4] = new Car(0, 4, 4, 4, 5);
		puzzle.board[4][5] = puzzle.board[4][4];

		puzzle.board[5][4] = new Car(0, 5, 4, 5, 5);
		puzzle.board[5][5] = puzzle.board[5][4];

		super.play(puzzle)
	}
}