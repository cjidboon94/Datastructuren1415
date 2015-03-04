public class Truck extends Vehicle{

	Truck(int orientation, int x1, int  y1, int x2, int y2, int x3, int y3) {
		super(orientation, x1, y1, x2, y2);
		this.x3 = x3;
		this.y3 = y3;
	}
}
