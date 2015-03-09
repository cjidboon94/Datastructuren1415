public class Truck extends Vehicle{

	private int x3;
	private int y3;

	Truck(int orientation, int y1, int  x1, int y2, int x2, int y3, int x3) {
		super(orientation, x1, y1, x2, y2);
		this.x3 = x3;
		this.y3 = y3;
	}

	public void move(int moves, Board board){
		if(moves > 0){
			board.board[y1][x1] = null;
			if(orientation == 0) {
				x1++;
				x2++;
				x3++;
			} else {
				y1++;+
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
}