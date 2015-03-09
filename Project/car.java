public class Car extends Vehicle{

	private boolean player;
	
	public Car(int orientation, int y1, int x1, int y2, int x2){
		this(orientation, x1, x2, y1, y2, false);
	}
	
	public Car(int orientation, int y1, int  x1, int y2, int x2, boolean player) {
		super(orientation, x1, x2, y1, y2);
		this.player = player;
	}

	public boolean isPlayer(){
		return player;
	}

	public void move(int moves, Board board){
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
}
