/* Abstract class that  */

public abstract class Vehicle {
	
	protected  int orientation;
	protected  int x1;
	protected  int x2;
	protected  int y1;
	protected  int y2;
	
	/* Default constructor. Saves the position and the orientation of the vehicle */
	public Vehicle (int orientation, int x1, int x2, int y1, int y2){
		this.orientation = orientation;
		this.x1 = x1;
		this.x2 = x2;
		this.y1 = y1;
		this.y2 = y2;
	}

	/* Entry method that performs all checks for a move. */
	public void mainMove(int moves, Board board) {
		boolean legal = true;
		if(moves > 0) {
			for(int i = 0; i < moves && legal; i++) {
				if(!legalMove(moves- i, board)) {
					legal = false;
				} else {
					move(moves, board);
				}
			}
		} else if (moves < 0) {
			for(int i = moves; i < 0 && legal; i++) {
				if(!legalMove(moves -i, board)) {
					legal = false;
				} else {
					move(moves, board);
				}
			}
		}
	}
	
	private abstract void move(int moves, Board board);

	/* Checks if a move is legal 
	 * by checking if the move coordinates are still within the board 
	 * and if the road is clear. 
	 */
	public boolean legalMove(int moves, Board board) {
		/* Horizontal moves */
		if(orientation == 0) {
			
			if(moves > 0 && (x2 + moves) < board.getSize()) {
				return clearRoad(1, board);
			} else if (moves < 0 && (x1 + moves) > 0) {
				return clearRoad(-1, board);
			} else{
				return false;
			}

		/* Vertical moves */	
		} else {
			if(moves > 0 && (y2 + moves) < board.getSize()) {
				return clearRoad(1, board);
			}else if (moves < 0 && (y1 + move) > 0) {
				return clearRoad(-1, board);
			} else {
				return false;
			}
		}
	}

	/* Checks if the next square is clear */
	private boolean clearRoad(int move, Board board) {
		if(orientation == 0) {
			if((move > 0 && board.board[y1][(x2 + move)] == null) || (move < 0 && board.board[y1][(x1 + move)] == null)) {
				return true;
			} else {
				return false;
			}
		} else {
			if((move > 0 && board.board[(y2 + move)][x1] == null) || (move < 0 && board.board[(y1 + move)][x1] == null)) {
				return true;
			} else {
				return false;
			}
		}
	}
}