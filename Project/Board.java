//Implements the board properties

import java.util.*;

public class Board { 
	private int size;
	public Vehicle[][] board; //A board is represented by a 2-dimensional array
	private ArrayList<Vehicle> vehicles; //Contains an arraylist of vehicles

	/* Creates an empty board */
	public Board(int size) {

		this.size = size;
		board = new Vehicle[size][size];
		clearBoard();
		vehicles = new ArrayList<Vehicle>();
	}
	
	private void clearBoard() {
	//Removes every vehicle object from the board (every square)

		for(Vehicle[] row : board) {
			for(Vehicle square : row) {
					square = null;
			}
		}
	}

	public Vehicle getVehicle(String name) {
		if(name.equals("1")){
			return vehicles.get(0);
		}
		int index;
		if((int)name.charAt(0) < 97){
		//Deals with cars with char names that differ from upper to
		//lower case

			index = name.charAt(0) - 'A' +1;
		} else {
			index = name.charAt(0) - 'A' - 5 ;
		}
		return vehicles.get(index);
	}

	public void addVehicle(int name, Vehicle vehicle) {
		vehicles.add(name, vehicle);
	}

	public int getSize() {
	//Return the board size
		return size;
	}

	public ArrayList<Vehicle> getVehicles() {
	//Return the arraylist of all vehicles on the board
		return vehicles;
	}
}	