public class Puzzle1 implements Runnable {
	/*
	GUI gui;

	public Puzzle1(GUI g) {
		gui = g;
	}
*/
	public static void main(String[] args){
		RushHourAI RH = new RushHourAI(setup());
		RH.play();
	}

	public void run(){
		//main();
	}


	public static BoardNode setup() {
		//Do setup
		BoardNode puzzle = new BoardNode(6);

		puzzle.board[2][3] = '1';
		puzzle.board[2][4] = puzzle.board[2][3];
		puzzle.addVehicle(0, new VehicleNode('1', 'c', 0, 2, 3, 2, 4, -1, -1));
		
		puzzle.board[0][2] = 'A';
		puzzle.board[1][2] = puzzle.board[0][2];
		puzzle.board[2][2] = puzzle.board[0][2];
		puzzle.addVehicle(1, new VehicleNode('A', 't',1, 0, 2, 1, 2, 2, 2));
		
		puzzle.board[0][3] = 'B';
		puzzle.board[0][4] = puzzle.board[0][3];
		puzzle.addVehicle(2, new VehicleNode('B', 'c', 0, 0, 3, 0, 4, -1, -1));

		puzzle.board[0][5] = 'C';
		puzzle.board[1][5] = puzzle.board[0][5];
		puzzle.board[2][5] = puzzle.board[0][5];
		puzzle.addVehicle(3, new VehicleNode('C', 't',1, 0, 5, 1, 5, 2, 5));
		
		puzzle.board[4][0] = 'D';
		puzzle.board[5][0] = puzzle.board[4][0];
		puzzle.addVehicle(4, new VehicleNode('D', 'c', 1, 4, 0, 5, 0, -1, -1));
		
		puzzle.board[4][1] = 'E';
		puzzle.board[4][2] = puzzle.board[4][1];
		puzzle.addVehicle(5, new VehicleNode('E', 'c',0, 4, 1, 4, 2, -1, -1));
		
		puzzle.board[3][3] = 'F';
		puzzle.board[4][3] = puzzle.board[3][3];
		puzzle.board[5][3] = puzzle.board[3][3];
		puzzle.addVehicle(6, new VehicleNode('F', 't', 1, 3, 3, 4, 3, 5, 3));
		
		puzzle.board[3][4] = 'G';
		puzzle.board[3][5] = puzzle.board[3][4];
		puzzle.addVehicle(7, new VehicleNode('G', 'c', 0, 3, 4, 3, 5, -1, -1));
		
		puzzle.board[5][4] = 'H';
		puzzle.board[5][5] = puzzle.board[5][4];
		puzzle.addVehicle(8, new VehicleNode('H', 'c', 0, 5, 4, 5, 5, -1, -1));

		return puzzle;
	}
}