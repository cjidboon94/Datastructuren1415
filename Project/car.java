public class Car {

	int orientation;
	int x1;
	int y1;
	int x2;
	int y2;
	boolean player;
	
	
	Car(int orientation, int x1, int x2, int y1, int y2){
		this(orientation, x1, x2, y1, y2, false);
	}
	
	
	Car(int orientation, int x1, int  x2, int y1, int y2, boolean player) {

		this.orientation = orientation;
		this.x1 = x1;
		this.x2 = x2;
		this.y1 = y1;
		this.y2 = y2;
		this.player = player;
	}


}
