import javax.swing.*;
import java.awt.*;

/*public class GUI {

	public static void main (String args[]) {

		JFrame window = new JFrame("WHAT IT IIIIIS");

		window.setSize(400, 400);	
		window.setVisible(true);
	}
}
*/
public class GUI extends JFrame {
	JPanel panel = new JPanel();

	public static void main (String args[]) {
		new GUI();
	}

	public GUI() {
		super("Game");
		setSize(400,400);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		

		panel.setLayout(new GridLayout(6,6));
		

		setVisible(true);
	}
}
