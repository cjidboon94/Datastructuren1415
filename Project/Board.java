/*
 * Project - Datastructuren - RushHour
 * Authors: Cornelis Boon - 10561145, Tim Groot - 10165673
 * Emails: cornelis.boon@student.uva.nl, tim.groot@student.uva.nl
 * Date: 17-03-2015
 * File: Board.java
 * 
 * Class description: This class keeps track of the vehicles and initializes the board.
 * It also keeps track of the state of the game.
 */

import java.util.ArrayList;

public class Board { 
	private int size;
	/*A board is represented by a 2-dimensional array*/
	public Vehicle[][] board; 
	/*The list of of vehicles. For easy access*/
	private ArrayList<Vehicle> vehicles; 

	/* Default constructor. Creates an empty board */
	public Board(int size) {

		this.size = size;
		board = new Vehicle[size][size];
		clearBoard();
		vehicles = new ArrayList<Vehicle>();
	}
	
	/* Clears the board */
	private void clearBoard() {
		for(Vehicle[] row : board) {
			for(Vehicle square : row) {
					square = null;
			}
		}
	}

	/* Returns the requested vehicle.*/
	public Vehicle getVehicle(String name) {
		if(name.equals("1")){
			return vehicles.get(0);
		}
		int index;
		/* Does some ascii magic to compute the index of the vehicle */
		if((int)name.charAt(0) < 97){
			index = name.charAt(0) - 'A' +1;
		} else {
			index = name.charAt(0) - 'A' - 5 ;
		}
		return vehicles.get(index);
	}

	/* Adds a vehicle to the arraylist */
	public void addVehicle(int name, Vehicle vehicle) {
		vehicles.add(name, vehicle);
	}

	/* Returns the size of the board */
	public int getSize() {
		return size;
	}

	/* Returns the full arraylist of vehicles */
	public ArrayList<Vehicle> getVehicles() {
		return vehicles;
	}
}	