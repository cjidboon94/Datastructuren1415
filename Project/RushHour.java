import java.util.*;

public class RushHour {
	
	private Board puzzle;
	private GUI g;
	
	public RushHour(Board puzzle, GUI gui){
		this.puzzle = puzzle;
		g = gui;
		g.setBoard(puzzle);
		g.drawBoard();
	}
	
	public int play(){
		int move = 0;
		Scanner reader = new Scanner(System.in);
		String previous = "";
		String name;
		while(!won()){
			printBoard(move);
			g.drawBoard();
				try {
					System.out.println("Which vehicle would you like to move? (Or type RESET/QUIT to restart or quit)");
					name = reader.next();
					if(name.equalsIgnoreCase("RESET")) {
						System.out.println("Which vehicle would you like to move?");
						System.out.println("Type Reset/R to restart and Quit/Q");
						name = reader.next().toLowerCase();
					}
					if(name.equalsIgnoreCase("reset") || name.equalsIgnoreCase("r")) {
						reader.close();
						return 1;
					/*}  else if(name.equals("0")){
						System.out.println("There's no zero'th object");
						continue; */
					} else if(name.equalsIgnoreCase("quit") || name.equalsIgnoreCase("q")){
						System.out.println("Thank you for playing!");
						reader.close();
						System.exit(0);
						return 0;
					}
					Vehicle vehicle = puzzle.getVehicle(name);
					System.out.println("How many steps would you like to move it?");
					System.out.println("Positive value for right/down, Negative value for left/up");
					int moves = reader.nextInt();
					if(moves == 0){
						System.out.println("Why would you take no steps? Seriously. Why?");
						continue;
					}
					vehicle.mainMove(moves, puzzle);
				} catch(RuntimeException e) {
					System.out.println("Incorrect input");
					continue;
				}
			if(!previous.equals(name)){
				previous = name;
				move++;
			}
		}
		reader.close();
		g.drawBoard();
		System.out.println("You won in " + move + " moves.");
		System.out.println("Good job!");
		return 0;
	}

	private boolean won(){ 
		System.out.println(Math.round((float)puzzle.getSize()/2)-1);
		return ( 	puzzle.board[Math.round((float)puzzle.getSize()/2)-1][puzzle.getSize()-1] != null && 
					puzzle.board[Math.round((float)puzzle.getSize()/2)-1][puzzle.getSize()-1].equals(puzzle.getVehicle("1"))); 
	}

	private void printBoard(int move){	
		System.out.println("Move:" + move);
		System.out.println();
	    for(int i = 0; i < puzzle.getSize(); i++) {
	    	for(int j = 0; j < puzzle.getSize(); j++) {
	        	if(puzzle.board[i][j] == null){
					System.out.printf("0");
				} else {
					System.out.printf(""+puzzle.board[i][j].getName());
				}
	        }
	        System.out.println();
	  	}

	  	System.out.println("");
	}
	
	public Board getBoard(){
		return puzzle;
	}
	
}
