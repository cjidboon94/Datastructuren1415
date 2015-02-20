public class Puzzle2 {

	int[][] board = new int[6][6];

	Puzzle2() {

		board[2][2] = 99;
		board[2][3] = 99;

		board[0][2] = 1;
		board[0][3] = 1;

		board[0][4] = 2;
		board[0][5] = 2;

		board[1][1] = 3;
		board[1][2] = 3;

		board[1][3] = 4;
		board[1][4] = 4;

		board[1][5] = 5;
		board[2][5] = 5;
		board[3][5] = 5;

		board[2][4] = 6;
		board[3][4] = 6;

		board[3][0] = 7;
		board[3][1] = 7;

		board[3][2] = 8;
		board[3][3] = 8;

		board[4][0] = 9;
		board[5][0] = 9;

		board[4][3] = 10;
		board[5][3] = 10;

		board[4][4] = 11;
		board[4][5] = 11;

		board[5][4] = 12;
		board[5][5] = 12;
	}
}