/*
The GUI class implements the Graphic User Interface that visualizes the Rush Hour game
from the terminal more beautifully. 
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;
import java.awt.Font;


//The main class, using swing's JFrame
public class GUI extends JFrame {

	//Initializes the ImageIcon variables
	ImageIcon bluedown1, bluetop1, blueleft0, blueright0, 
		limtop1, limmid1, limdown1, limleft0, limmid0, limright0,
		beigetop1, beigedown1, beigeleft0, beigeright0,
		greentop1, greendown1, greenleft0, greenright0,
		orangedown1, orangetop1, orangeleft0, orangeright0,
		purpletop1, purpledown1, purpleleft0, purpleright0,
		redtop1, reddown1, redleft0, redright0,
		tealtop1, tealdown1, tealleft0, tealright0,
		yellowtop1, yellowdown1, yellowleft0, yellowright0;

	//The base path should be altered to the path that leads to the picture directory,
	//when ran from another computer.
	String basePath;
	String[] picturearray = new String[7]; //Seven other colours to choose from
	ArrayList<carColorCombination> carcolors; 


	String chosenPuzzle = ""; // chosenpuzzle will later remember the chosen puzzle from the mid screen
	JFrame frame;
	JButton midscreen1, midscreen2;
	Board b;
	GUI g;

	GUI() {
		g = this;
		initGUI();
		basePath = "C:\\Users\\tim\\Desktop\\Datastructuren1415\\Project\\carpics\\";
		carcolors = new ArrayList<carColorCombination>();

		JButton puzzle1, puzzle2, puzzle3, puzzle4, puzzle5;
		
		JLabel title;

		//The initial graphic interface, the player is prompted to click on one of the puzzles
		frame.setLayout(new GridLayout(6,1));
		
		title = new JLabel("Select a Puzzle!", SwingConstants.CENTER);
		frame.add(title);

		puzzle1 = new JButton("Play Puzzle 1!");
		puzzle1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chosenPuzzle = "Puzzle1";
				frame.getContentPane().removeAll();
				drawOptionsMenu(g, frame, title);
				//new Thread(new Puzzle1(g)).start();
			}
		});
		frame.add(puzzle1);

		puzzle2 = new JButton("Play Puzzle 2!");
		puzzle2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chosenPuzzle = "Puzzle2";
				frame.getContentPane().removeAll();
				drawOptionsMenu(g, frame, title);
				//new Thread(new Puzzle2(g)).start();
			}
		});
		frame.add(puzzle2);	

		puzzle3 = new JButton("Play Puzzle 3!");
		puzzle3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chosenPuzzle = "Puzzle3";
				frame.getContentPane().removeAll();
				drawOptionsMenu(g, frame, title);
				//new Thread(new Puzzle3(g)).start();
			}
		});
		frame.add(puzzle3);

		puzzle4 = new JButton("Play Puzzle 4!");
		puzzle4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chosenPuzzle = "Puzzle4";
				frame.getContentPane().removeAll();
				drawOptionsMenu(g, frame, title);
				//new Thread(new Puzzle4(g)).start();
			}
		});
		frame.add(puzzle4);

		puzzle5 = new JButton("Play Puzzle 5!");
		puzzle5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chosenPuzzle = "Puzzle5";
				frame.getContentPane().removeAll();
				drawOptionsMenu(g, frame, title);
			}
		});
		frame.add(puzzle5);
	}
	
	public void initGUI() { //Initialize the size and operations of the frame
		frame = new JFrame("Rush Hour");
		//frame.setLocationRelativeTo(null);
		frame.setSize(700,700);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

	public void drawOptionsMenu(GUI g, JFrame frame, JLabel title) {
		//This menu pops up after you've chosen a puzzle
		//Gives the user the choice to either play, or use the solver

		frame.setLayout(new GridLayout(3,1));
		title = new JLabel("Do you wish to play, or watch the AI solve the puzzle?", SwingConstants.CENTER);
		frame.add(title);

		midscreen1 = new JButton("I'll play!");
		midscreen1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (chosenPuzzle == "Puzzle1") {
					frame.getContentPane().removeAll();
					new Thread(new Puzzle1(g)).start();
				}
				if (chosenPuzzle == "Puzzle2") {
					frame.getContentPane().removeAll();
					new Thread(new Puzzle2(g)).start();
				}
				if (chosenPuzzle == "Puzzle3") {
					frame.getContentPane().removeAll();
					new Thread(new Puzzle3(g)).start();
				}
				if (chosenPuzzle == "Puzzle4") {
					frame.getContentPane().removeAll();
					new Thread(new Puzzle4(g)).start();
				} 
				if (chosenPuzzle == "Puzzle5") {
					frame.getContentPane().removeAll();
					new Thread(new Puzzle5(g)).start();
				}
			}
		});
		frame.add(midscreen1);

		midscreen2 = new JButton("I think I'll let the AI solve this one for me...");
		midscreen2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Launch AI Solver");
			}
		});
		frame.add(midscreen2);	

		frame.revalidate();
		frame.repaint();
		frame.setVisible(true);

	}

	public void setBoard(Board board) {
	//Sets the board, given the puzzle size

		b = board;
		frame.setLayout(new GridLayout(b.getSize(), b.getSize()));
		readPics();
	}
	
	public void drawBoard() {
		//Draws every vehicle on the board with their tag

		frame.getContentPane().removeAll();

		ArrayList<Vehicle> vehiclearray = b.getVehicles();
		for(int i = 0; i < b.getSize(); i++) {
			for(int j = 0; j < b.getSize(); j++) {
				if(b.board[i][j] == null) {
					frame.add(new JButton());
				} else {
					for(Vehicle v : vehiclearray) {
						if(v.getName() == b.board[i][j].getName()){
							if (v instanceof Truck) { //object is a truck
								if (v.getOr() == 0) {
									if (v.x1 == j){
										JButton left = new JButton(v.getName() + "", limleft0);
										left.setHorizontalTextPosition(JButton.CENTER);
										left.setVerticalTextPosition(JButton.CENTER);
										left.setFont(new Font("Arial", Font.PLAIN, frame.getHeight()/b.getSize()/4));
										left.setForeground(Color.WHITE);
										frame.add(left);
										//frame.add(new JButton(v.getName() + " left"));
									} else if (v.x2 == j) {
										JButton mid = new JButton(v.getName() + "", limmid0);
										mid.setHorizontalTextPosition(JButton.CENTER);
										mid.setVerticalTextPosition(JButton.CENTER);
										mid.setFont(new Font("Arial", Font.PLAIN, frame.getHeight()/b.getSize()/4));
										mid.setForeground(Color.WHITE);
										frame.add(mid);
										//frame.add(new JButton(v.getName() + " middle"));
									} else {
										JButton right = new JButton(v.getName() + "", limright0);
										right.setHorizontalTextPosition(JButton.CENTER);
										right.setVerticalTextPosition(JButton.CENTER);
										right.setFont(new Font("Arial", Font.PLAIN, frame.getHeight()/b.getSize()/4));
										right.setForeground(Color.WHITE);
										frame.add(right);
										//frame.add(new JButton(v.getName() + " right"));
									}
								} else {
									if (v.y1 == i) {
										JButton top = new JButton(v.getName() + "", limtop1);
										top.setHorizontalTextPosition(JButton.CENTER);
										top.setVerticalTextPosition(JButton.CENTER);
										top.setFont(new Font("Arial", Font.PLAIN, frame.getHeight()/b.getSize()/4));
										top.setForeground(Color.WHITE);
										frame.add(top);
										//frame.add(new JButton(v.getName() + " top"));
									} else if (v.y2 == i) {
										JButton mid = new JButton(v.getName() + "", limmid1);
										mid.setHorizontalTextPosition(JButton.CENTER);
										mid.setVerticalTextPosition(JButton.CENTER);
										mid.setFont(new Font("Arial", Font.PLAIN, frame.getHeight()/b.getSize()/4));
										mid.setForeground(Color.WHITE);
										frame.add(mid);
										//frame.add(new JButton(v.getName() + " middle"));
									} else {
										JButton down = new JButton(v.getName() + "", limdown1);
										down.setHorizontalTextPosition(JButton.CENTER);
										down.setVerticalTextPosition(JButton.CENTER);
										down.setFont(new Font("Arial", Font.PLAIN, frame.getHeight()/b.getSize()/4));
										down.setForeground(Color.WHITE);
										frame.add(down);
										//frame.add(new JButton(v.getName() + " bottom"));
									}
								}
							} else { //object is a car
								int color = -1;
								for (int l = 0; l < carcolors.size(); l++) {
									carColorCombination check = carcolors.get(l);
									if (check.carName == v.getName()) {
										color = check.color;
									}
								}
								if (color == -1){
									Random r = new Random();
									int randomnumber = r.nextInt(7);
									carColorCombination c = new carColorCombination(v.getName(), randomnumber);
									carcolors.add(c);
									color = randomnumber;
								}
								if (v.getName() == '1') { //object is goal car
									if (v.x1 == j) {
										JButton left = new JButton(v.getName() + "", redleft0);
										left.setHorizontalTextPosition(JButton.CENTER);
										left.setVerticalTextPosition(JButton.CENTER);
										left.setFont(new Font("Arial", Font.PLAIN, frame.getHeight()/b.getSize()/4));
										left.setForeground(Color.WHITE);
										frame.add(left);
										//frame.add(new JButton(v.getName() + " left"));
									}
									else {
										JButton right = new JButton(v.getName() + "", redright0);
										right.setHorizontalTextPosition(JButton.CENTER);
										right.setVerticalTextPosition(JButton.CENTER);
										right.setFont(new Font("Arial", Font.PLAIN, frame.getHeight()/b.getSize()/4));
										right.setForeground(Color.WHITE);
										frame.add(right);
										//frame.add(new JButton(v.getName() + " right"));
									}
								} else { //object is another car
									if (v.getOr() == 0) {
										if (v.x1 == j) {
											JButton left = new JButton(v.getName() + "", selectColor("left0", color));
											left.setHorizontalTextPosition(JButton.CENTER);
											left.setVerticalTextPosition(JButton.CENTER);
											left.setFont(new Font("Arial", Font.PLAIN, frame.getHeight()/b.getSize()/4));
											left.setForeground(Color.WHITE);
											frame.add(left);
											//frame.add(new JButton(v.getName() + " left"));
										}
										else {
											JButton right = new JButton(v.getName() + "", selectColor("right0", color));
											right.setHorizontalTextPosition(JButton.CENTER);
											right.setVerticalTextPosition(JButton.CENTER);
											right.setFont(new Font("Arial", Font.PLAIN, frame.getHeight()/b.getSize()/4));
											right.setForeground(Color.WHITE);
											frame.add(right);
											//frame.add(new JButton(v.getName() + " right"));
										}
									} else {
										if (v.y1 == i) {
											JButton top = new JButton(v.getName() + "", selectColor("top1", color));
											top.setHorizontalTextPosition(JButton.CENTER);
											top.setVerticalTextPosition(JButton.CENTER);
											top.setFont(new Font("Arial", Font.PLAIN, frame.getHeight()/b.getSize()/4));
											top.setForeground(Color.WHITE);
											frame.add(top);
											//frame.add(new JButton(v.getName() + " top"));
										} else {
											JButton down = new JButton(v.getName() + "", selectColor("down1", color));
											down.setHorizontalTextPosition(JButton.CENTER);
											down.setVerticalTextPosition(JButton.CENTER);
											down.setFont(new Font("Arial", Font.PLAIN, frame.getHeight()/b.getSize()/4));
											down.setForeground(Color.WHITE);
											frame.add(down);
											//frame.add(new JButton(v.getName() + " bottom"));
										}
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

	private class carColorCombination {
		//This class is needed to remember which random color which car has

		char carName;
		int color;

		carColorCombination(char s1, int s2) {
			carName = s1;
			color = s2;
		}
	}

	public ImageIcon selectColor(String position, int color) {
	//Binds the randomly generate number to a color

		if (color == 0) {
			if (position.equals("left0")) {
				return beigeleft0;
			}
			if (position.equals("right0")) {
				return beigeright0;
			}
			if (position.equals("top1")) {
				return beigetop1;
			} else {
				return beigedown1;
			}
		}
		if (color == 1) {
			if (position.equals("left0")) {
				return blueleft0;
			}
			if (position.equals("right0")) {
				return blueright0;
			}
			if (position.equals("top1")) {
				return bluetop1;
			} else {
				return bluedown1;
			}
		}
		if (color == 2) {
			if (position.equals("left0")) {
				return greenleft0;
			}
			if (position.equals("right0")) {
				return greenright0;
			}
			if (position.equals("top1")) {
				return greentop1;
			} else {
				return greendown1;
			}
		}
		if (color == 3) {
			if (position.equals("left0")) {
				return orangeleft0;
			}
			if (position.equals("right0")) {
				return orangeright0;
			}
			if (position.equals("top1")) {
				return orangetop1;
			} else {
				return orangedown1;
			}
		}
		if (color == 4) {
			if (position.equals("left0")) {
				return purpleleft0;
			}
			if (position.equals("right0")) {
				return purpleright0;
			}
			if (position.equals("top1")) {
				return purpletop1;
			} else {
				return purpledown1;
			}
		}
		if (color == 5) {
			if (position.equals("left0")) {
				return tealleft0;
			}
			if (position.equals("right0")) {
				return tealright0;
			}
			if (position.equals("top1")) {
				return tealtop1;
			} else {
				return tealdown1;
			}
		} else {
			if (position.equals("left0")) {
				return yellowleft0;
			}
			if (position.equals("right0")) {
				return yellowright0;
			}
			if (position.equals("top1")) {
				return yellowtop1;
			} else {
				return yellowdown1;
			}
		}

	}

	public void readPics() {
	//PNG imports

		bluedown1 = new ImageIcon(basePath + "bluedown1.png");
		bluetop1 = new ImageIcon(basePath + "bluetop1.png");
		blueleft0 = new ImageIcon(basePath + "blueleft0.png");
		blueright0 = new ImageIcon(basePath + "blueright0.png");

		beigedown1 = new ImageIcon(basePath + "beigedown1.png");
		beigetop1 = new ImageIcon(basePath + "beigetop1.png");
		beigeleft0 = new ImageIcon(basePath + "beigeleft0.png");
		beigeright0 = new ImageIcon(basePath + "beigeright0.png");

		greendown1 = new ImageIcon(basePath + "greendown1.png");
		greentop1 = new ImageIcon(basePath + "greentop1.png");
		greenleft0 = new ImageIcon(basePath + "greenleft0.png");
		greenright0 = new ImageIcon(basePath + "greenright0.png");

		orangedown1 = new ImageIcon(basePath + "orangedown1.png");
		orangetop1 = new ImageIcon(basePath + "orangetop1.png");
		orangeleft0 = new ImageIcon(basePath + "orangeleft0.png");
		orangeright0 = new ImageIcon(basePath + "orangeright0.png");

		purpledown1 = new ImageIcon(basePath + "purpledown1.png");
		purpletop1 = new ImageIcon(basePath + "purpletop1.png");
		purpleleft0 = new ImageIcon(basePath + "purpleleft0.png");
		purpleright0 = new ImageIcon(basePath + "purpleright0.png");

		reddown1 = new ImageIcon(basePath + "reddown1.png");
		redtop1 = new ImageIcon(basePath + "redtop1.png");
		redleft0 = new ImageIcon(basePath + "redleft0.png");
		redright0 = new ImageIcon(basePath + "redright0.png");

		tealdown1 = new ImageIcon(basePath + "tealdown1.png");
		tealtop1 = new ImageIcon(basePath + "tealtop1.png");
		tealleft0 = new ImageIcon(basePath + "tealleft0.png");
		tealright0 = new ImageIcon(basePath + "tealright0.png");

		yellowdown1 = new ImageIcon(basePath + "yellowdown1.png");
		yellowtop1 = new ImageIcon(basePath + "yellowtop1.png");
		yellowleft0 = new ImageIcon(basePath + "yellowleft0.png");
		yellowright0 = new ImageIcon(basePath + "yellowright0.png");

		limtop1 = new ImageIcon(basePath + "limtop1.png");
		limmid1 = new ImageIcon(basePath + "limmid1.png");
		limdown1 = new ImageIcon(basePath + "limdown1.png");
		limleft0 = new ImageIcon(basePath + "limleft0.png");
		limmid0 = new ImageIcon(basePath + "limmid0.png");
		limright0 = new ImageIcon(basePath + "limright0.png");

		//Scales the pictures, so they fit in the buttons
		Image scaled = bluedown1.getImage().getScaledInstance(frame.getHeight()/b.getSize()-5, 
			frame.getHeight()/b.getSize()-5, java.awt.Image.SCALE_SMOOTH);
		bluedown1 = new ImageIcon(scaled);
		scaled = bluetop1.getImage().getScaledInstance(frame.getHeight()/b.getSize()-5, 
			frame.getHeight()/b.getSize()-5, java.awt.Image.SCALE_SMOOTH);
		bluetop1 = new ImageIcon(scaled);
		scaled = blueleft0.getImage().getScaledInstance(frame.getHeight()/b.getSize()-5, 
			frame.getHeight()/b.getSize()-5, java.awt.Image.SCALE_SMOOTH);
		blueleft0 = new ImageIcon(scaled);
		scaled = blueright0.getImage().getScaledInstance(frame.getHeight()/b.getSize()-5, 
			frame.getHeight()/b.getSize()-5, java.awt.Image.SCALE_SMOOTH);
		blueright0 = new ImageIcon(scaled);

		scaled = beigedown1.getImage().getScaledInstance(frame.getHeight()/b.getSize()-5, 
			frame.getHeight()/b.getSize()-5, java.awt.Image.SCALE_SMOOTH);
		beigedown1 = new ImageIcon(scaled);
		scaled = beigetop1.getImage().getScaledInstance(frame.getHeight()/b.getSize()-5, 
			frame.getHeight()/b.getSize()-5, java.awt.Image.SCALE_SMOOTH);
		beigetop1 = new ImageIcon(scaled);
		scaled = beigeleft0.getImage().getScaledInstance(frame.getHeight()/b.getSize()-5, 
			frame.getHeight()/b.getSize()-5, java.awt.Image.SCALE_SMOOTH);
		beigeleft0 = new ImageIcon(scaled);
		scaled = beigeright0.getImage().getScaledInstance(frame.getHeight()/b.getSize()-5, 
			frame.getHeight()/b.getSize()-5, java.awt.Image.SCALE_SMOOTH);
		beigeright0 = new ImageIcon(scaled);

		scaled = greendown1.getImage().getScaledInstance(frame.getHeight()/b.getSize()-5, 
			frame.getHeight()/b.getSize()-5, java.awt.Image.SCALE_SMOOTH);
		greendown1 = new ImageIcon(scaled);
		scaled = greentop1.getImage().getScaledInstance(frame.getHeight()/b.getSize()-5, 
			frame.getHeight()/b.getSize()-5, java.awt.Image.SCALE_SMOOTH);
		greentop1 = new ImageIcon(scaled);
		scaled = greenleft0.getImage().getScaledInstance(frame.getHeight()/b.getSize()-5, 
			frame.getHeight()/b.getSize()-5, java.awt.Image.SCALE_SMOOTH);
		greenleft0 = new ImageIcon(scaled);
		scaled = greenright0.getImage().getScaledInstance(frame.getHeight()/b.getSize()-5, 
			frame.getHeight()/b.getSize()-5, java.awt.Image.SCALE_SMOOTH);
		greenright0 = new ImageIcon(scaled);

		scaled = orangedown1.getImage().getScaledInstance(frame.getHeight()/b.getSize()-5, 
			frame.getHeight()/b.getSize()-5, java.awt.Image.SCALE_SMOOTH);
		orangedown1 = new ImageIcon(scaled);
		scaled = orangetop1.getImage().getScaledInstance(frame.getHeight()/b.getSize()-5, 
			frame.getHeight()/b.getSize()-5, java.awt.Image.SCALE_SMOOTH);
		orangetop1 = new ImageIcon(scaled);
		scaled = orangeleft0.getImage().getScaledInstance(frame.getHeight()/b.getSize()-5, 
			frame.getHeight()/b.getSize()-5, java.awt.Image.SCALE_SMOOTH);
		orangeleft0 = new ImageIcon(scaled);
		scaled = orangeright0.getImage().getScaledInstance(frame.getHeight()/b.getSize()-5, 
			frame.getHeight()/b.getSize()-5, java.awt.Image.SCALE_SMOOTH);
		orangeright0 = new ImageIcon(scaled);

		scaled = purpledown1.getImage().getScaledInstance(frame.getHeight()/b.getSize()-5, 
			frame.getHeight()/b.getSize()-5, java.awt.Image.SCALE_SMOOTH);
		purpledown1 = new ImageIcon(scaled);
		scaled = purpletop1.getImage().getScaledInstance(frame.getHeight()/b.getSize()-5, 
			frame.getHeight()/b.getSize()-5, java.awt.Image.SCALE_SMOOTH);
		purpletop1 = new ImageIcon(scaled);
		scaled = purpleleft0.getImage().getScaledInstance(frame.getHeight()/b.getSize()-5, 
			frame.getHeight()/b.getSize()-5, java.awt.Image.SCALE_SMOOTH);
		purpleleft0 = new ImageIcon(scaled);
		scaled = purpleright0.getImage().getScaledInstance(frame.getHeight()/b.getSize()-5, 
			frame.getHeight()/b.getSize()-5, java.awt.Image.SCALE_SMOOTH);
		purpleright0 = new ImageIcon(scaled);

		scaled = reddown1.getImage().getScaledInstance(frame.getHeight()/b.getSize()-5, 
			frame.getHeight()/b.getSize()-5, java.awt.Image.SCALE_SMOOTH);
		reddown1 = new ImageIcon(scaled);
		scaled = redtop1.getImage().getScaledInstance(frame.getHeight()/b.getSize()-5, 
			frame.getHeight()/b.getSize()-5, java.awt.Image.SCALE_SMOOTH);
		redtop1 = new ImageIcon(scaled);
		scaled = redleft0.getImage().getScaledInstance(frame.getHeight()/b.getSize()-5, 
			frame.getHeight()/b.getSize()-5, java.awt.Image.SCALE_SMOOTH);
		redleft0 = new ImageIcon(scaled);
		scaled = redright0.getImage().getScaledInstance(frame.getHeight()/b.getSize()-5, 
			frame.getHeight()/b.getSize()-5, java.awt.Image.SCALE_SMOOTH);
		redright0 = new ImageIcon(scaled);

		scaled = tealdown1.getImage().getScaledInstance(frame.getHeight()/b.getSize()-5, 
			frame.getHeight()/b.getSize()-5, java.awt.Image.SCALE_SMOOTH);
		tealdown1 = new ImageIcon(scaled);
		scaled = tealtop1.getImage().getScaledInstance(frame.getHeight()/b.getSize()-5, 
			frame.getHeight()/b.getSize()-5, java.awt.Image.SCALE_SMOOTH);
		tealtop1 = new ImageIcon(scaled);
		scaled = tealleft0.getImage().getScaledInstance(frame.getHeight()/b.getSize()-5, 
			frame.getHeight()/b.getSize()-5, java.awt.Image.SCALE_SMOOTH);
		tealleft0 = new ImageIcon(scaled);
		scaled = tealright0.getImage().getScaledInstance(frame.getHeight()/b.getSize()-5, 
			frame.getHeight()/b.getSize()-5, java.awt.Image.SCALE_SMOOTH);
		tealright0 = new ImageIcon(scaled);

		scaled = yellowdown1.getImage().getScaledInstance(frame.getHeight()/b.getSize()-5, 
			frame.getHeight()/b.getSize()-5, java.awt.Image.SCALE_SMOOTH);
		yellowdown1 = new ImageIcon(scaled);
		scaled = yellowtop1.getImage().getScaledInstance(frame.getHeight()/b.getSize()-5, 
			frame.getHeight()/b.getSize()-5, java.awt.Image.SCALE_SMOOTH);
		yellowtop1 = new ImageIcon(scaled);
		scaled = yellowleft0.getImage().getScaledInstance(frame.getHeight()/b.getSize()-5, 
			frame.getHeight()/b.getSize()-5, java.awt.Image.SCALE_SMOOTH);
		yellowleft0 = new ImageIcon(scaled);
		scaled = yellowright0.getImage().getScaledInstance(frame.getHeight()/b.getSize()-5, 
			frame.getHeight()/b.getSize()-5, java.awt.Image.SCALE_SMOOTH);
		yellowright0 = new ImageIcon(scaled);

		scaled = limtop1.getImage().getScaledInstance(frame.getHeight()/b.getSize()-5, 
			frame.getHeight()/b.getSize()-5, java.awt.Image.SCALE_SMOOTH);
		limtop1 = new ImageIcon(scaled);
		scaled = limmid1.getImage().getScaledInstance(frame.getHeight()/b.getSize()-5, 
			frame.getHeight()/b.getSize()-5, java.awt.Image.SCALE_SMOOTH);
		limmid1 = new ImageIcon(scaled);
		scaled = limdown1.getImage().getScaledInstance(frame.getHeight()/b.getSize()-5, 
			frame.getHeight()/b.getSize()-5, java.awt.Image.SCALE_SMOOTH);
		limdown1 = new ImageIcon(scaled);
		scaled = limleft0.getImage().getScaledInstance(frame.getHeight()/b.getSize()-5, 
			frame.getHeight()/b.getSize()-5, java.awt.Image.SCALE_SMOOTH);
		limleft0 = new ImageIcon(scaled);
		scaled = limmid0.getImage().getScaledInstance(frame.getHeight()/b.getSize()-5, 
			frame.getHeight()/b.getSize()-5, java.awt.Image.SCALE_SMOOTH);
		limmid0 = new ImageIcon(scaled);
		scaled = limright0.getImage().getScaledInstance(frame.getHeight()/b.getSize()-5, 
			frame.getHeight()/b.getSize()-5, java.awt.Image.SCALE_SMOOTH);
		limright0 = new ImageIcon(scaled);

		picturearray[0] = "beige";
		picturearray[1] = "blue";
		picturearray[2] = "green";
		picturearray[3] = "orange";
		picturearray[4] = "purple";
		picturearray[5] = "teal";
		picturearray[6] = "yellow";
	}	

}