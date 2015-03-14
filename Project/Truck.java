public class Truck extends Vehicle {

	public int x3;
	public int y3;

	Truck(char name, int orientation, int y1, int  x1, int y2, int x2, int y3, int x3) {
		super(name, orientation, y1, x1, y2, x2);
		this.x3 = x3;
		this.y3 = y3;
	}

	protected void move(int moves, Board board){
		if(moves > 0){
			board.board[y1][x1] = null;
			if(orientation == 0) {
				x1++;
				x2++;
				x3++;
			} else {
				y1++;
				y2++;
				y3++;
			}
			board.board[y3][x3] = board.board[y2][x2];
		} else {
			board.board[y3][x3] = null;
			if(orientation == 0) {
				x1--;
				x2--;
				x3--;
			} else {
				y1--;
				y2--;
				y3--;
			}
			board.board[y1][x1] = board.board[y2][x2];
		}
	}
	protected boolean legalMove(int moves, Board board) {
		/* Horizontal moves */
		if(orientation == 0) {
			if(moves > 0 && (x3 + moves) < board.getSize()) {
				return clearRoad(1, board);
			} else if (moves < 0 && (x1 + moves) >= 0) {
				return clearRoad(-1, board);
			} else{
				return false;
			}

		/* Vertical moves */	
		} else {

			if((moves > 0) && (y3 + moves) < board.getSize()) {
				 return clearRoad(1, board);
			}else if (moves < 0 && (y1 + moves) >= 0) {
				return clearRoad(-1, board);
			} else {
				return false;
			}
		}
	}

	protected boolean clearRoad(int move, Board board) {
		if(orientation == 0) {
			if((move > 0 && board.board[y1][(x3 + move)] == null) || (move < 0 && board.board[y1][(x1 + move)] == null)) {
				return true;
			} else {
				return false;
			}
		} else {
			if((move > 0 && board.board[y3+move][x1] == null) || (move < 0 && board.board[(y1 + move)][x1] == null)) {
				return true;
			} else {
				return false;
			}
		}
	}
}