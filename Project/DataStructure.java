import java.util.*;
import java.lang.*;


	class Datastructure {

		public static void main(String[] args) {

			int[][] board = new int[6][6];

			board[2][3] = 99;
			board[2][4] = 99;

			board[0][2] = 1;
			board[1][2] = 1;
			board[2][2] = 1;

			board[0][3] = 2;
			board[0][4] = 2;

			board[4][0] = 4;
			board[5][0] = 4;
			
			board[0][5] = 3;
			board[1][5] = 3;
			board[2][5] = 3;


		    for(int i = 0; i < 6; i++)
		    {
		      for(int j = 0; j < 6; j++)
		      {
		         System.out.printf("%5d ", board[i][j]);
		      }
		      System.out.println();
		  	}
			
		}
	

}