
public class Square {
	
	Vehicle vehicle;
	final int x;
	final int y;

	
	public Square(int x, int y){
		this(null, x, y);
	}
	
	public Square(Vehicle vehicle, int x, int y){
		this.vehicle = vehicle;
		this.x = x;
		this.y = y;
	}
	
	public boolean isEmpty() {
		if(vehicle == null) {
			return true;
		} else {
			return false;
		}
	}
	
	public Vehicle getVehicle(){
		return vehicle;
	}
	
	public boolean putVehicle(Vehicle vehicle) {
		if(this.vehicle == null){
			this.vehicle = vehicle;
			return true;
		} 
		return false;
	}
	
	public boolean removeVehicle(){
		if(this.vehicle != null) {
			this.vehicle = null;
			return true;
		}
		return false;
	}
}
