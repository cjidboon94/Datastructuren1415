import java.util.*;

public class RushHourPlayer extends RushHour {
	
	
	public RushHourPlayer(Board puzzle){
		super(puzzle);
		//g = gui;
		//g.setBoard(puzzle);
		//g.drawBoard();
	}
	
	public int play(){
		int move = 0;
		Scanner reader = new Scanner(System.in);
		String previous = "";
		String name;
		puzzle.printBoard(move);
		System.out.println("Which vehicle would you like to move?");
		System.out.println("Or type Reset/R to restart or Quit/Q to quit)");
		while(!won(puzzle) && reader.hasNext()){
					
			//g.drawBoard();

					
				/* Reads input and processes the moves. Keeps doing so until the game has been either won, quit or restarted */
			try {
					
					/* Process first input (Vehicle or reset/quit) */
				name = reader.next();

				if(name.equalsIgnoreCase("reset") || 
					name.equalsIgnoreCase("r")) {
					reader.close();
					return 1;
				} else if(name.equals("0")){
					System.out.println("There's no zeroth object");
					continue;
				} else if(name.equalsIgnoreCase("quit") || 
					name.equalsIgnoreCase("q")){
					System.out.println("Bye");
					reader.close();
					System.exit(0);
					return 0;
				}
				Vehicle vehicle = puzzle.getVehicle(name);
				
				/* Process second input (amount of moves) */
				System.out.println("How many steps would you like to move it?");
				System.out.println("Positive value for right/down, Negative value for left/up");
				int moves = reader.nextInt();
				if(moves == 0){
					System.out.println("Why would you take no steps? Seriously. Why?");
					continue;
				}
				vehicle.mainMove(moves, puzzle);
				if(!previous.equals(name)){
					previous = name;
					move++;
				}
			/* If incorrect input is given, exception is caught and everything begins from the start */
			} catch(RuntimeException e) {
				e.printStackTrace();
				System.exit(0);
				System.out.println("Incorrect input");
				continue;
			} finally {
				puzzle.printBoard(move);
				System.out.println("Which vehicle would you like to move?");
				System.out.println("Or type Reset/R to restart or Quit/Q to quit)");
			}
			/* So long it's the same car moving, it's the same move */
			
		}
		//g.drawBoard();
		System.out.println("You won in " + move + " moves.");
		System.out.println("Good job!");
		return 0;
	}
}