import java.util.ArrayList;

public class Board { 
	private int size;
	public char[][] board;
	private ArrayList<Vehicle> vehicles;

	/* Creates an empty board */
	public Board(int size) {
		this.size = size;
		board = new char[size][size];
		clearBoard();
		vehicles = new ArrayList<Vehicle>();
	}
	
	public Board(Board other){
		this.size = other.size;
		this.board = other.board;
		this.vehicles = other.vehicles;
	}

	private  void clearBoard() {
		for(char[] row : board) {
			for(char square : row) {
					square = 0;
			}
		}
	}

	public void printBoard(int move){	
		System.out.println("Move:" + move);
		System.out.println();
	    for(int i = 0; i < size; i++) {
	    	for(int j = 0; j < size; j++) {
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

	public Vehicle getVehicle(String name){
		if(name.equals("p")){
			return vehicles.get(0);
		}
		int index = Integer.parseInt(name, 16);
		return vehicles.get(index);
	}

	public void addVehicle(int name, Vehicle vehicle){
		vehicles.add(name, vehicle);
	}

	public int getSize(){
		return size;
	}

	public ArrayList<Vehicle> getVehicles() {
		return vehicles;
	}
}	