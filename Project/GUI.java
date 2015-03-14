import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class GUI extends JFrame {

	ImageIcon bluedown1, bluetop1, blueleft0, blueright0, limtop1, limmid1, limdown1, limleft0, limmid0, limright0;
	String basePath;

	//JPanel panel = new JPanel();
	JFrame frame;
	Board b;
	GUI g;

	GUI() {
		g = this;
		initGUI();
		basePath = "C:\\Users\\tim\\Desktop\\Datastructuren1415\\Project\\carpics\\";

		JButton puzzle1, puzzle2;
		JLabel title;

		frame.setLayout(new GridLayout(3,1));
		
		title = new JLabel("Select a Puzzle!", SwingConstants.CENTER);
		frame.add(title);

		puzzle1 = new JButton("Play Puzzle 1!");
		puzzle1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Thread(new Puzzle1(g)).start();
			}
		});
		frame.add(puzzle1);

		puzzle2 = new JButton("Play Puzzle 2!");
		puzzle2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Thread(new Puzzle2(g)).start();
			}
		});
		frame.add(puzzle2);	
	}
	
	public void initGUI() {
		frame = new JFrame("Rush Hour");
		//frame.setLocationRelativeTo(null);
		frame.setSize(650,650);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

	public void setBoard(Board board) {
		b = board;
		frame.setLayout(new GridLayout(b.getSize(), b.getSize()));
		readPics();
	}
	
	public void drawBoard() {
		frame.getContentPane().removeAll();

		ArrayList<Vehicle> vehiclearray = b.getVehicles();
		for(int i = 0; i < b.getSize(); i++) {
			for(int j = 0; j < b.getSize(); j++) {
				if(b.board[i][j] == null) {
					frame.add(new JButton());
				} else {
					for(int k = 0; k < vehiclearray.size(); k++) {
						Vehicle v  = vehiclearray.get(k);
						if(v.getName() == b.board[i][j].getName()){
							if (v instanceof Truck) {
								if (v.orientation == 0) {
									if (v.x1 == j){
										frame.add(new JButton(limleft0));
										//frame.add(new JButton(v.getName() + " left"));
									} else if (v.x2 == j) {
										frame.add(new JButton(limmid0));
										//frame.add(new JButton(v.getName() + " middle"));
									} else {
										frame.add(new JButton(limright0));
										//frame.add(new JButton(v.getName() + " right"));
									}
								} else {
									if (v.y1 == i) {
										frame.add(new JButton(limtop1));
										//frame.add(new JButton(v.getName() + " top"));
									} else if (v.y2 == i) {
										frame.add(new JButton(limmid1));
										//frame.add(new JButton(v.getName() + " middle"));
									} else {
										frame.add(new JButton(limdown1));
										//frame.add(new JButton(v.getName() + " bottom"));
									}
								}
							} else {
								if (v.orientation == 0) {
									if (v.x1 == j) {
										frame.add(new JButton(blueleft0));
										//frame.add(new JButton(v.getName() + " left"));
									}
									else {
										frame.add(new JButton(blueright0));
										//frame.add(new JButton(v.getName() + " right"));
									}
								} else {
									if (v.y1 == i) {
										frame.add(new JButton(bluetop1));
										//frame.add(new JButton(v.getName() + " top"));
									} else {
										frame.add(new JButton(bluedown1));
										//frame.add(new JButton(v.getName() + " bottom"));
									}
								}
							}
						}
					}
				}
			}
		}

		frame.getContentPane().validate();
		frame.getContentPane().repaint();
	}

	public void readPics() {
		bluedown1 = new ImageIcon(basePath + "bluedown1.png");
		bluetop1 = new ImageIcon(basePath + "bluetop1.png");
		blueleft0 = new ImageIcon(basePath + "blueleft0.png");
		blueright0 = new ImageIcon(basePath + "blueright0.png");

		limtop1 = new ImageIcon(basePath + "limtop1.png");
		limmid1 = new ImageIcon(basePath + "limmid1.png");
		limdown1 = new ImageIcon(basePath + "limdown1.png");
		limleft0 = new ImageIcon(basePath + "limleft0.png");
		limmid0 = new ImageIcon(basePath + "limmid0.png");
		limright0 = new ImageIcon(basePath + "limright0.png");

		Image scaled = bluedown1.getImage().getScaledInstance(frame.getHeight()/b.getSize(), 
			frame.getHeight()/b.getSize(), java.awt.Image.SCALE_SMOOTH);
		bluedown1 = new ImageIcon(scaled);
		scaled = bluetop1.getImage().getScaledInstance(frame.getHeight()/b.getSize(), 
			frame.getHeight()/b.getSize(), java.awt.Image.SCALE_SMOOTH);
		bluetop1 = new ImageIcon(scaled);

		scaled = blueleft0.getImage().getScaledInstance(frame.getHeight()/b.getSize(), 
			frame.getHeight()/b.getSize(), java.awt.Image.SCALE_SMOOTH);
		blueleft0 = new ImageIcon(scaled);
		scaled = blueright0.getImage().getScaledInstance(frame.getHeight()/b.getSize(), 
			frame.getHeight()/b.getSize(), java.awt.Image.SCALE_SMOOTH);
		blueright0 = new ImageIcon(scaled);

		scaled = limtop1.getImage().getScaledInstance(frame.getHeight()/b.getSize(), 
			frame.getHeight()/b.getSize(), java.awt.Image.SCALE_SMOOTH);
		limtop1 = new ImageIcon(scaled);
		scaled = limmid1.getImage().getScaledInstance(frame.getHeight()/b.getSize(), 
			frame.getHeight()/b.getSize(), java.awt.Image.SCALE_SMOOTH);
		limmid1 = new ImageIcon(scaled);
		scaled = limdown1.getImage().getScaledInstance(frame.getHeight()/b.getSize(), 
			frame.getHeight()/b.getSize(), java.awt.Image.SCALE_SMOOTH);
		limdown1 = new ImageIcon(scaled);

		scaled = limleft0.getImage().getScaledInstance(frame.getHeight()/b.getSize(), 
			frame.getHeight()/b.getSize(), java.awt.Image.SCALE_SMOOTH);
		limleft0 = new ImageIcon(scaled);
		scaled = limmid0.getImage().getScaledInstance(frame.getHeight()/b.getSize(), 
			frame.getHeight()/b.getSize(), java.awt.Image.SCALE_SMOOTH);
		limmid0 = new ImageIcon(scaled);
		scaled = limright0.getImage().getScaledInstance(frame.getHeight()/b.getSize(), 
			frame.getHeight()/b.getSize(), java.awt.Image.SCALE_SMOOTH);
		limright0 = new ImageIcon(scaled);

	}	

}