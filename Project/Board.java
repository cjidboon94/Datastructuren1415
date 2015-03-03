

public class Board {
	private int size;
	private Square[][] board;
	
	public Board(int size) {
		this.size = size;
		board = new Square[size][size];
		clearBoard();
	}
	
	
	private  void clearBoard() {
		for(int i = 0; i < size; i++){
			for(int j = 0; j < size; j++){
					board[i][j] = Square(i, j);
			}
		}
	}
}
