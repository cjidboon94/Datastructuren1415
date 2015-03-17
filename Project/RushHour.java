import java.util.*;

public abstract class RushHour {
	
	protected Board puzzle;
	//private GUI g;
	
	public RushHour(Board puzzle){
		this.puzzle = puzzle;
		//g = gui;
		//g.setBoard(puzzle);
		//g.drawBoard();
	}
	
	public abstract int play();

	protected boolean won(Board puzzle){ 
		return ( 	puzzle.board[Math.round((float)puzzle.getSize()/2)][puzzle.getSize()-1] == 'p'); 
	}
}