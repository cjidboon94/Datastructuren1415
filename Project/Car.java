/*
 * Project - Datastructuren - RushHour
 * Authors: Cornelis Boon - 10561145, Tim Groot - 10165673
 * Emails: cornelis.boon@student.uva.nl, tim.groot@student.uva.nl
 * Date: 17-03-2015
 * File: Car.java
 * 
 * Class description: Subclass of vehicle. Has an additional boolean to check
 * if it is 'player' car.
 */
public class Car extends Vehicle {

	private boolean player;
	
	/* Default constructor */
	public Car(char name, int orientation, int y1, int x1, int y2, int x2) {
		this(name, orientation, y1, x1, y2, x2, false);
	}
	/* Second constructor that is used to also create the 'player' car */
	public Car(char name, int orientation, int y1, int  x1, int y2, int x2, boolean player) {
		super(name, orientation, y1, x1, y2, x2 );
		this.player = player;
	}

	/* Returns true if this is the players car, otherwise false */
	public boolean isPlayer(){
		return player;
	}

	/* Moves the car over the board */
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
	/* Checks if move is legal */
	protected boolean legalMove(int moves, Board board) {
		// Horizontal moves
		if(orientation == 0) {
			if(moves > 0 && (x2 + moves) < board.getSize()) {
				return clearRoad(1, board);
			} else if (moves < 0 && (x1 + moves) >= 0) {
				return clearRoad(-1, board);
			} else{
				return false;
			}

		//Vertical moves
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

	/* Checks if road is clear */
	protected boolean clearRoad(int move, Board board) {
		if(orientation == 0) {
			if((move > 0 && board.board[y1][(x2 + move)] == null) || 
				(move < 0 && board.board[y1][(x1 + move)] == null)) {
				return true;
			} else {
				return false;
			}
		} else {
			if((move > 0 && board.board[y2+move][x1] == null) || 
				(move < 0 && board.board[(y1 + move)][x1] == null)) {
				return true;
			} else {
				return false;
			}
		}
	}

}
