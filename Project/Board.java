
public class Board { 
	private int size;
	private Vehicle[][] board;
	
	/* Creates an empty board */
	public Board(int size) {
		this.size = size;
		board = new Vehicle[size][size];
		clearBoard();
	}
	
	private  void clearBoard() {
		for(Vehicle[] row : board) {
			for(Vehicle square : row) {
					square = null;
			}
		}
	}
}	
	
	
	/*
	public void moveVehicle(int moves, int x, int y) {
		Vehicle temp = board[x][y].getVehicle();
		if(moves > 0) {
			for(int i = 1; i < moves ; i++) {
				move(x+i, y+i, temp);
			} 
		} else if(moves < 0) {
			for(int i = -1; i > moves; i--) {
				move(x+i, y+i, temp);
			}
		}
	}
	
	private void move() {
	
	}*/

