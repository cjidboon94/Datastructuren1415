/* Abstract class that  */

public abstract class Vehicle {
	
	protected  int orientation;
	protected  final  char name;
	protected  int x1;
	protected  int x2;
	protected  int y1;
	protected  int y2;
	
	/* Default constructor. Saves the position and the orientation of the vehicle */
	public Vehicle (char name, int orientation, int y1, int x1, int y2, int x2){
		this.name = name;
		this.orientation = orientation;
		this.x1 = x1;
		this.x2 = x2;
		this.y1 = y1;
		this.y2 = y2;
	}

	public char getName(){
		return name;
	}

	/* Entry method that performs all checks for a move. */
	public void mainMove(int moves, Board board) {
		boolean legal = true;
		if(moves > 0) {
			for(int i = moves; i > 0 && legal; i--) {
				if(!legalMove(i, board)) {
					if((moves-i) == 0){
						System.out.println("That way is blocked");
					} else {
						System.out.println("Sorry. We could only move it " + (moves-i) + " steps");
					}
					legal = false;
				} else {
					move(moves, board);
				}
			}
		} else if (moves < 0) {
			for(int i = moves; i < 0 && legal; i++) {
				if(!legalMove(i, board)){
					if((moves-i) == 0){
						System.out.println("That way is blocked");
					} else {
						System.out.println("Sorry. We could only move it " + (moves-i) + " steps");
					}
					legal = false;
				
				} else {
					move(moves, board);
				}
			}
		}
	}
	
	protected abstract void move(int moves, Board board);

	/* Checks if a move is legal 
	 * by checking if the move coordinates are still within the board 
	 * and if the road is clear. 
	 */
	protected abstract boolean legalMove(int moves, Board board); 

	/* Checks if the next square is clear */
	protected abstract boolean clearRoad(int move, Board board);
}
