public final class TruckNode extends VehicleNode {

	private final int x3;
	private final int y3;


	public static TruckNode move(TruckNode previous, int move){
		return new TruckNode(previous, move);
	}

	private TruckNode(TruckNode previous, int move){
		super(previous, move);
		if(this.orientation == 0){
			this.x3 = previous.x3 + move;
			this.y3 = previous.y3;
		} else {
			this.x3 = previous.x3;
			this.y3 = previous.y3 + move;
		}
	}

	public TruckNode(char name, int orientation, int y1, int  x1, int y2, int x2, int y3, int x3) {
		super(name,  orientation, y1, x1, y2, x2);
		this.x3 = x3;
		this.y3 = y3;
	}

	protected VehicleNode move(int moves, char[][] board){
		TruckNode newTruck;
		if(moves > 0){
			board[y1][x1] = 0;
			newTruck  = move(this, moves);
			board[newTruck.y3][newTruck.x3] = newTruck.name;
		} else {
			board[y3][x3] = 0;
			newTruck = move(this, moves);
			board[newTruck.y1][newTruck.x1] = newTruck.name;
		}
		return newTruck;
	}
	protected boolean legalMove(int moves, char[][] board) {
		/* Horizontal moves */
		if(orientation == 0) {
			if(moves > 0 && (x3 + moves) < board.length) {
				return clearRoad(1, board);
			} else if (moves < 0 && (x1 + moves) >= 0) {
				return clearRoad(-1, board);
			} else{
				return false;
			}

		/* Vertical moves */	
		} else {

			if((moves > 0) && (y3 + moves) < board.length) {
				 return clearRoad(1, board);
			}else if (moves < 0 && (y1 + moves) >= 0) {
				return clearRoad(-1, board);
			} else {
				return false;
			}
		}
	}

	protected boolean clearRoad(int move, char[][] board) {
		if(orientation == 0) {
			if((move > 0 && board[y1][(x3 + move)] == 0) || 
				(move < 0 && board[y1][(x1 + move)] == 0)) {
				return true;
			} else {
				return false;
			}
		} else {
			if((move > 0 && board[y3+move][x1] == 0) || 
				(move < 0 && board[(y1 + move)][x1] == 0)) {
				return true;
			} else {
				return false;
			}
		}
	}
}