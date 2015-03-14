public class Car extends Vehicle {

	private boolean player;
	
	public Car(char name, int orientation, int y1, int x1, int y2, int x2) {
		this(name, orientation, y1, x1, y2, x2, false);
	}
	
	public Car(char name, int orientation, int y1, int  x1, int y2, int x2, boolean player) {
		super(name, orientation, y1, x1, y2, x2 );
		this.player = player;
	}

	public boolean isPlayer(){
		return player;
	}

	protected void move(int moves, Board board) {
		if(moves > 0){
			board.board[y1][x1] = null;
			if(orientation == 0) {
				x1++;
				x2++;
			} else {
				y1++;
				y2++;
			}
			board.board[y2][x2] = board.board[y1][x1];
		} else {
			board.board[y2][x2] = null;
			if(orientation == 0) {
				x1--;
				x2--;
			} else {
				y1--;
				y2--;
			}
			board.board[y1][x1] = board.board[y2][x2];
		}

	}
	protected boolean legalMove(int moves, Board board) {
		/* Horizontal moves */
		if(orientation == 0) {
			if(moves > 0 && (x2 + moves) < board.getSize()) {
				return clearRoad(1, board);
			} else if (moves < 0 && (x1 + moves) >= 0) {
				return clearRoad(-1, board);
			} else{
				return false;
			}

		/* Vertical moves */	
		} else {

			if((moves > 0) && (y2 + moves) < board.getSize()) {
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
			if((move > 0 && board.board[y1][(x2 + move)] == null) || (move < 0 && board.board[y1][(x1 + move)] == null)) {
				return true;
			} else {
				return false;
			}
		} else {
			if((move > 0 && board.board[y2+move][x1] == null) || (move < 0 && board.board[(y1 + move)][x1] == null)) {
				return true;
			} else {
				return false;
			}
		}
	}

}
