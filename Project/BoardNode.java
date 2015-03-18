import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Arrays;

public final class BoardNode { 
	private  final int size;
	public   char[][] board;
	private  ArrayList<VehicleNode> vehicles;
	private  final char lastmoved;
	private  final int cost;
	private  final BoardNode previous;

	public static void nextStates(BoardNode currentstate, 
									PriorityQueue<BoardNode> frontier,
										ArrayList<char[][]> visited){
		
		for(VehicleNode vehicle : currentstate.vehicles){
			char[][] newBoard1 = new char[currentstate.size][currentstate.size];
			char[][] newBoard2 = new char[currentstate.size][currentstate.size];
			for(int i = 0; i < currentstate.size; i++){	
				Arrays.copyOf(currentstate.board[][i], 0, newBoard1[][i], 0, currentstate.size);
				Arrays.arraycopy(currentstate.board[][i], 0, newBoard2[][i], 0, currentstate.size);
			}
			ArrayList<VehicleNode> newVehicles1;
			ArrayList<VehicleNode> newVehicles2;
			int cost;
			BoardNode newNode;

			if(currentstate.lastmoved != vehicle.getName()){
				cost = currentstate.cost+1;
			} else {
				cost = currentstate.cost;
			}
			VehicleNode newVic1 = vehicle.mainMove(1, newBoard1);
			System.out.println("Next1");
			printBoard(newBoard1);
			if(newVic1 != null && unique(newBoard1, visited)){
				visited.add(newBoard1);
				newVehicles1 = adaptVehicleList(newVic1, currentstate.vehicles);
				newNode = new BoardNode(newBoard1, newVehicles1, 
												newVic1.getName(), cost, 
												currentstate);
				frontier.offer(newNode);
			}
			System.out.println("Next2");
			printBoard(newBoard2);
			VehicleNode newVic2 = vehicle.mainMove(-1, newBoard2);	
			if(newVic2 != null && unique(newBoard2, visited)) {
				visited.add(newBoard2);
				newVehicles2 = adaptVehicleList(newVic2, currentstate.vehicles);
				newNode = new BoardNode(newBoard2, newVehicles2, 
												newVic2.getName(), cost,
												currentstate);
				frontier.offer(newNode);
			}
		}
	}

	private static boolean unique(char[][] board, ArrayList<char[][]> visited){
		for(char[][] node : visited){
			if(Arrays.equals(board, node)){
				return false;
			}
		}
		return true;
	}

	/* Copies the old arraylist, but changes the matching old vehicle with the new one */
	private static ArrayList<VehicleNode> adaptVehicleList(
											VehicleNode newVehicle,
											ArrayList<VehicleNode> oldVehicles){

		ArrayList<VehicleNode> newVehicles = new ArrayList<VehicleNode>(oldVehicles.size());
		
		for(int i = 0; i < newVehicles.size(); i++){
			if(newVehicle.getName() == oldVehicles.get(i).getName()){
				newVehicles.add(i, newVehicle);
			} else {
					newVehicles.add(i, new VehicleNode(oldVehicles.get(i), 0));
			}
		}
		return newVehicles;
	}

	private BoardNode(char[][] newBoard, ArrayList<VehicleNode> newVehicles,
						char lastmoved, int cost, BoardNode previous){
		this.size = newBoard.length;
		this.board = newBoard;
		this.vehicles = newVehicles;
		this.lastmoved = lastmoved;
		this.cost = cost;
		this.previous = previous;
	}

	/* Creates an empty board */
	public BoardNode(int size) {
		this.size = size;
		board = new char[size][size];
		clearBoard();
		vehicles = new ArrayList<VehicleNode>();
		lastmoved = 0;
		cost = 0;
		previous = null;
	}
	

	private  void clearBoard() {
		for(char[] row : board) {
			for(char square : row) {
					square = 0;
			}
		}
	}

	public static void printBoard(char[][] board){	
		System.out.println();
	    for(int i = 0; i < board.length; i++) {
	    	for(int j = 0; j < board.length; j++) {
	        	if(board[i][j] == 0){
					System.out.printf("0");
				} else {
					System.out.printf(""+board[i][j]);
				}
	        }
	        System.out.println();
	  	}

	  	System.out.println("");
	}

	private VehicleNode getVehicle(char name){
		if(name == '1'){
			return vehicles.get(0);
		}
		int index;
		/* Does some ascii magic to compute the index of the vehicle */
		if((int)name < 97){
			index = name - 'A' +1;
		} else {
			index = name - 'A' - 5 ;
		}
		return vehicles.get(index);
	}

	public BoardNode getPrevious(){
		return previous;
	}

	public void addVehicle(int name, VehicleNode vehicle){
		vehicles.add(name, vehicle);
	}

	public char[][] getBoard(){
		return board;
	}

	public int getCost(){
		return cost;
	}

	public int getSize(){
		return size;
	}

	public ArrayList<VehicleNode> getVehicles() {
		return vehicles;
	}
}	