
public class Square {
	
	Vehicle vehicle;
	boolean empty;
	int x;
	int y;
	
	
	public Square(int x, int y){
		this(null, true, x, y);
	}
	
	public Square(Vehicle vehicle, boolean empty, int x, int y){
		this.vehicle = vehicle;
		this.empty = empty;
		this.x = x;
		this.y = y;
	}
	

}
