public class Puzzle1 {

	int[][] board = new int[6][6];

	Puzzle1() {

		board[2][3] = 99;
		board[2][4] = 99;

		board[0][2] = 1;
		board[1][2] = 1;
		board[2][2] = 1;

		board[0][3] = 2;
		board[0][4] = 2;

		board[0][5] = 3;
		board[1][5] = 3;
		board[2][5] = 3;

		board[4][0] = 4;
		board[5][0] = 4;
		
		board[4][1] = 5;
		board[4][2] = 5;

		board[3][3] = 6;
		board[4][3] = 6;
		board[5][3] = 6;
		
		board[3][4] = 7;
		board[3][5] = 7;

		board[5][4] = 8;
		board[5][5] = 8;
	}
}