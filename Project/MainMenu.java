//This file is the main class that needs to be ran to execute the
//program including the GUI.

public class MainMenu {

	public static void start(String[] args) {
		/*if (args.length > 2){
			System.out.println("Usage: MainMenu or MainMenu GUI");
			System.exit(1);
		}
		else if (args.length == 1){
			if (args[0].equals("GUI")){
				System.out.println("Starting GUI play mode");
			}
			else{
				System.out.println("Usage: MainMenu or MainMenu GUI");
				System.exit(1);
			}
		}*/

		GUI g = new GUI();

	}
	
	public static void main(String[] args) {
		start(args);
	}
	
}
