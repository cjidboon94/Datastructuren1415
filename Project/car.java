public class Car extends Vehicle{

	boolean player;
	
	
	Car(int orientation, int x1, int x2, int y1, int y2){
		this(orientation, x1, x2, y1, y2, false);
	}
	
	
	Car(int orientation, int x1, int  x2, int y1, int y2, boolean player) {
		super(orientation, x1, x2, y1, y2);
		this.player = player;
	}


}
