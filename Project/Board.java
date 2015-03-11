import java.util.*;
import java.lang.*;


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
}	