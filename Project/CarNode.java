public final class CarNode extends VehicleNode {

	private final boolean player;
	
	/* Factory method */
	public static CarNode move(CarNode previous, int moves){
		return new CarNode(previous, moves);
	}

	/* Private constructor used by the static method */
	private CarNode(CarNode previous, int moves){
		super(previous, moves);
		this.player = previous.player;
	}

	/* Default constructor used by the puzzles */
	public CarNode(char name, int orientation, int y1, int x1, int y2, int x2) {
		this(name, orientation, y1, x1, y2, x2, false);
	}
	
	public CarNode(char name, int orientation, int y1, int  x1, int y2, int x2, 
				boolean player) {
		super(name,  orientation, y1, x1, y2, x2 );
		this.player = player;
	}

	public boolean isPlayer(){
		return player;
	}

	protected VehicleNode move(int moves, char[][] board) {
		CarNode newCar;
		if(moves > 0){
			board[y1][x1] = 0;
			newCar = move(this, 1);
			board[newCar.y2][newCar.x2] = newCar.name;
		} else {
			board[y2][x2] = 0;
			newCar = move(this, -1);
			board[newCar.y1][newCar.x1] = newCar.name;
		}
		return newCar;

	}
	protected boolean legalMove(int moves, char[][] board) {
		/* Horizontal moves */
		if(orientation == 0) {
			if(moves > 0 && (x2 + moves) < board.length) {
				return clearRoad(1, board);
			} else if (moves < 0 && (x1 + moves) >= 0) {
				return clearRoad(-1, board);
			} else{
				return false;
			}

		/* Vertical moves */	
		} else {

			if((moves > 0) && (y2 + moves) < board.length) {
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
			if((move > 0 && board[y1][(x2 + move)] == 0) || 
				(move < 0 && board[y1][(x1 + move)] == 0)) {
				return true;
			} else {
				return false;
			}
		} else {
			if((move > 0 && board[y2+move][x1] == 0) || 
				(move < 0 && board[(y1 + move)][x1] == 0)) {
				return true;
			} else {
				return false;
			}
		}
	}
}