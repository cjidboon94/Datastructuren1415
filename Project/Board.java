import java.util.*;

public class Board { 
	private int size;
	public Vehicle[][] board;
	private ArrayList<Vehicle> vehicles;

	/* Creates an empty board */
	public Board(int size) {
		this.size = size;
		board = new Vehicle[size][size];
		clearBoard();
		vehicles = new ArrayList<Vehicle>();
	}
	
	private  void clearBoard() {
		for(Vehicle[] row : board) {
			for(Vehicle square : row) {
					square = null;
			}
		}
	}

	public Vehicle getVehicle(String name){
		if(name.equals("1")){
			return vehicles.get(0);
		}
		int index;
		if((int)name.charAt(0) < 97){
			index = name.charAt(0) - 'A' +1;
		} else {
			index = name.charAt(0) - 'A' - 5 ;
		}
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