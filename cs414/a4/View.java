package cs414.a4;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.EventQueue;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

import javax.swing.*;
import javax.swing.border.Border;

@SuppressWarnings("serial")
public class View extends JFrame {
	public static final int DEFAULT_WIDTH = 900;
	public static final int DEFAULT_HEIGHT = 900;

	// Window objects
	private JButton buyButton;
	private JButton sellButton;
	private JButton endTurnButton;
	private JButton rollButton;
	// private JButton payButton;

	private JPanel buttonPanel;
	private JPanel gameMsgPanel;
	private JPanel boardPanel;

	private JTextArea msgTextArea;

	// Game objects
	private Model model;
	private Controller ctrl;

	public View() {
		setTitle("Monopoly Game");
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
	}
	
	public void setUpGUI(){
		startMenu();
		addMsgPanel();
		addButtonPanel();
		setupBoard();
		// The game can now be started!
	    model.startGame();
	}

	private void addMsgPanel() {
		// initialization
		gameMsgPanel = new JPanel();
		gameMsgPanel.setBackground(Color.cyan);
		gameMsgPanel.setLayout(new GridLayout(2,0));

		// msgTextFiled initialization 
		msgTextArea = new JTextArea(30,20);
		msgTextArea.setEditable(false);
		JScrollPane scroll = new JScrollPane (msgTextArea,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		
		// Add a textfield to the gameMsgPanel
		gameMsgPanel.add(scroll);
	
		// add gameMsgPanel to MonopolyGameFrame
		add(gameMsgPanel, BorderLayout.EAST);

	}

	
	private void addButtonPanel() {
		// setup button panel
		buttonPanel = new JPanel();
		buttonPanel.setBackground(Color.blue);
		buttonPanel.setLayout(new GridLayout(2, 2));

		// Buttons initialization
		buyButton = ctrl.getBuyButton();
		sellButton = ctrl.getSellButton();
		rollButton = ctrl.getRollDiceButton();
		endTurnButton = ctrl.getEndTurnButton();

		// Add buttons to buttonPanel
		buttonPanel.add(buyButton);
		buttonPanel.add(sellButton);
		buttonPanel.add(rollButton);
		buttonPanel.add(endTurnButton);

		// Add button panel to JFrame
		gameMsgPanel.add(buttonPanel);
	}
	private void startMenu() {
		int fn;
		// Ensure the user enter the correct amount of players
		do {
			String str1 = JOptionPane.showInputDialog("Enter number of players (2 to 4)");
			fn = Integer.parseInt(str1);

		}while((fn < 2) || (fn > 4));
	 
	    String[] players = new String [fn];
	    for(int i = 0; i < fn; i++){
			players[i] = JOptionPane.showInputDialog("Enter the owner of Token" + (i+1));
			//Send model the name of each player 
			model.addPlayer(players[i]);
	    }
	    //final ImageIcon icon = new ImageIcon("/Users/TJ/Downloads/IMG_6062.jpg");
	    
	    JOptionPane.showMessageDialog( null, "Total of " + fn + " players! \n "+
	    Arrays.toString(players),"Welcome to Monopoly Game 1.0.0", JOptionPane.INFORMATION_MESSAGE);//,icon);
	}

	public void addModel(Model model) {
		this.model = model;
	}

	public void addController(Controller ctrl) {
		this.ctrl = ctrl;
	}

	private void setupBoard() {
		boardPanel = new JPanel();
		boardPanel.setLayout(new GridLayout(11,11));
		
		ArrayList<Square> listOfSquares = model.getBoard().getSquares();
		
		for(int i=0;i<listOfSquares.size();i++){
			Square s = listOfSquares.get(i);
			SquareView aSquare = new SquareView(s);
			boardPanel.add(aSquare);
		}
		
		
		
		//Square curr = myBoard.getStart();
		
		/*

		// Set up r1
		JPanel r1 = new JPanel();
		r1.setBackground(Color.red);
		r1.setLayout(new GridLayout(0, 10));

		for (int i = 0; i < 10; i++) {
			JPanel square = new JPanel();
			square.setLayout(new GridLayout(4,0));
			square.setBackground(curr.getColor());
			square.setBorder(BorderFactory.createLineBorder(Color.black));
			// square.setSize(20, 50);
			JLabel l1 = new JLabel("" + curr.getName());
			square.add(l1);
			r1.add(square);
			curr = curr.getNext();
			/*
			if(i==1){
				JButton p1 = new JButton("p1");
				p1.setBackground(Color.red);
				p1.setOpaque(true);
				square.add(p1, 1);
			}
			
		}

		// Set up r2
		JPanel r2 = new JPanel();
		r2.setLayout(new GridLayout(0, 3));

		// Set up r2c1
		JPanel r2c1 = new JPanel();
		r2c1.setLayout(new GridLayout(10, 0));

		for (int i = 0; i < 10; i++) {
			JPanel square = new JPanel();
			square.setLayout(new GridLayout(0,3));
			square.setBackground(curr.getColor());
			square.setBorder(BorderFactory.createLineBorder(Color.black));
			JLabel l1 = new JLabel("" + curr.getName());
			square.add(l1);
			r2c1.add(square);
			curr = curr.getNext();
		}

		JPanel r2c2 = new JPanel();
		r2.setBackground(Color.yellow);

		// Set up r3
		JPanel r3 = new JPanel();
		r3.setLayout(new GridLayout(0, 10));
		r3.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);

		for (int i = 0; i < 10; i++) {
			JPanel square = new JPanel();
			square.setLayout(new GridBagLayout());
			square.setBackground(curr.getColor());
			square.setBorder(BorderFactory.createLineBorder(Color.black));
			JLabel l1 = new JLabel("" + curr.getName());
			square.add(l1);
			r3.add(square);
			curr = curr.getNext();
		}

		JPanel r2c3 = new JPanel();
		r2.setBackground(Color.blue);
		r2c3.setLayout(new GridLayout(10, 0));

		for (int i = 0; i < 10; i++) {
			JPanel square = new JPanel();
			square.setLayout(new GridBagLayout());
			square.setBackground(curr.getColor());
			square.setBorder(BorderFactory.createLineBorder(Color.black));
			JLabel l1 = new JLabel("" + curr.getName());
			square.add(l1);
			r2c3.add(square);
			curr = curr.getNext();
		}
		// add cols to r2
		r2.add(r2c3);
		r2.add(r2c2);
		r2.add(r2c1);

		// add all rows to boardPanel
		boardPanel.add(r1);
		boardPanel.add(r2);
		boardPanel.add(r3);
		*/
		// add boardPanel to JFrame
		add(boardPanel);
	}

	public static Square chooseDeeds(HashSet<Square> myDeeds) {
		System.out.println("Player Must choose a deed to sell.");
		Square deedToSell = null;
		return deedToSell;
	}

	public void update() {
		msgTextArea.append(model.getMsg());
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				Controller ctrl = new Controller();
				Model model = new Model();
				View view = new View();

				view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				view.setLocationByPlatform(true);
				view.setSize(800, 600);

				// link everything
				view.addModel(model);
				view.addController(ctrl);
				ctrl.addModel(model);
				ctrl.addView(view);
				model.addView(view);

				// initialize view
				view.setUpGUI();
				view.setVisible(true);
			}
		});
	}

}
