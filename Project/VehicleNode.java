public class VehicleNode {
	
	protected final int orientation;
	protected final char name;
	protected final char type;
	protected final int x1;
	protected final int x2;
	protected final int x3;
	protected final int y1;
	protected final int y2;
	protected final int y3;
	
	/* Default constructor. Saves the position and the orientation of the vehicle */
	protected VehicleNode(char name, char type, int orientation,  int y1, int x1, int y2, int x2, int y3, int x3){
		this.name = name;
		this.type = type;
		this.orientation = orientation;
		this.x1 = x1;
		this.x2 = x2;
		this.x3 = x3;
		this.y1 = y1;
		this.y2 = y2;
		this.y3 = y3;
	}

	protected VehicleNode (VehicleNode previous, int move){
		this.name = previous.name;
		this.type = previous.type;
		this.orientation = previous.orientation;
		if(this.orientation == 0){
			this.x1 = previous.x1 + move;
			this.x2 = previous.x2 + move;
			this.x3 = previous.x3 + move;
			this.y1 = previous.y1;
			this.y2 = previous.y2;
			this.y3 = previous.y3;
		} else {
			this.x1 = previous.x1;
			this.x2 = previous.x2;
			this.x3 = previous.x3;
			this.y1 = previous.y1 + move;
			this.y2 = previous.y2 + move;
			this.y3 = previous.y3 +move;
		}
	}

	public char getName(){
		return name;
	}

	public int getOr(){
		return orientation;
	}

	/* Entry method that performs all checks for a move. */
	public VehicleNode mainMove(int moves, char[][] board) {
		boolean legal = true;
		if(moves > 0) {
			for(int i = moves; i > 0 && legal; i--) {
				if(!legalMove(i, board)) {
					legal = false;
					System.out.println("Here1");
				} else {
					System.out.println("Here2");
					return move(i, board);
				}
			}
		} else if (moves < 0) {
			for(int i = moves; i < 0 && legal; i++) {
				if(!legalMove(i, board)){
					legal = false;
					System.out.println("Here3");			
				} else {
					System.out.println("Here4");
					return move(i, board);
				}
			}
		}
		return null;
	}
	protected VehicleNode move(int moves, char[][] board) {
		VehicleNode newCar;
		if(moves > 0){
			board[y1][x1] = 0;
			newCar = new VehicleNode(this, 1);
			if(newCar.type == 'c'){
				board[newCar.y2][newCar.x2] = newCar.name;
			} else {
				board[newCar.y3][newCar.x3] = newCar.name;
			}
		} else {
			if(this.type == 'c'){
				board[y2][x2] = 0;
			} else {
				board[y3][x3] = 0;
			}
			newCar = new VehicleNode(this, -1);
			board[newCar.y1][newCar.x1] = newCar.name;
		}
		return newCar;

	}
	protected boolean legalMove(int moves, char[][] board) {
		/* Horizontal moves */
		if(orientation == 0) {
			if(this.type == 'c'){
				if(moves > 0 && (x2 + moves) < board.length) {
					return clearRoad(1, board);
				}
			} else if(this.type == 't'){
				if(moves > 0 && (x3 + moves) < board.length) {
					return clearRoad(1, board);
				}
			} else if (moves < 0 && (x1 + moves) >= 0) {
				return clearRoad(-1, board);
			}

		/* Vertical moves */	
		} else {
			if(this.type == 'c'){
				if((moves > 0) && (y2 + moves) < board.length) {
					return clearRoad(1, board);
				}
			} else if(this.type == 't'){
				if((moves > 0) && (y3 + moves) < board.length) {
					return clearRoad(1, board);
				}

			}else if (moves < 0 && (y1 + moves) >= 0) {
				return clearRoad(-1, board);
			}
		}
		return false;
	}

	protected boolean clearRoad(int move, char[][] board) {
		if(orientation == 0) {
			if((this.type == 't' && move > 0 && board[y1][(x3 + move)] == 0) || 
				(this.type == 'c' && move > 0 && board[y1][(x2 + move)] == 0) || 
				(move < 0 && board[y1][(x1 + move)] == 0)) {
				return true;
			} else {
				return false;
			}
		} else {
			if((this.type == 't' && move > 0 && board[y3+ move][x2 ] == 0) ||
				(this.type == 'c' && move > 0 && board[y2+move][x1] == 0) || 
				(move < 0 && board[(y1 + move)][x1] == 0)) {
				return true;
			} else {
				return false;
			}
		}
	}



	/*
	protected abstract VehicleNode move(int moves, char[][] board);

	/* Checks if a move is legal 
	 * by checking if the move coordinates are still within the board 
	 * and if the road is clear. 
	 *
	protected abstract boolean legalMove(int moves, char[][] board); 

	/* Checks if the next square is clear *
	protected abstract boolean clearRoad(int move, char[][] board);	
	*/
}
