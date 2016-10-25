package cs414.a4;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
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
	private JButton buildButton;
	private JButton endGameButton;


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
		buttonPanel.setLayout(new GridLayout(3, 3));

		// Buttons initialization
		buyButton = ctrl.getBuyButton();
		sellButton = ctrl.getSellButton();
		rollButton = ctrl.getRollDiceButton();
		endTurnButton = ctrl.getEndTurnButton();

		buildButton = ctrl.getBuildButton();
		endGameButton = ctrl.getEndGameButton();
		
		// Add buttons to buttonPanel
		buttonPanel.add(buyButton);
		buttonPanel.add(sellButton);
		buttonPanel.add(rollButton);
		buttonPanel.add(endTurnButton);
		buttonPanel.add(buildButton);
		buttonPanel.add(endGameButton);

		// Add button panel to gameMsgPanel
		gameMsgPanel.add(buttonPanel);
	}
	private void startMenu(){
		int numPlayers = 0;
		// Ensure the user enter the correct amount of players
		do {
			String str1 = JOptionPane.showInputDialog("Enter number of players (2 to 4)");
			try{
				numPlayers = Integer.parseInt(str1);				
			}catch(NumberFormatException e){
				JOptionPane.showMessageDialog(null, "Please enter an integer value.");
			}
		}while((numPlayers < 2) || (numPlayers > 4));
		
		Token[] allTokens = model.getTokens();
	    String[] players = new String [numPlayers];
	    
	    for(int i = 0; i < numPlayers; i++){
			players[i] = JOptionPane.showInputDialog("Enter the owner of "+allTokens[i].getDescription());
			//Send model the name of each player 
			model.addPlayer(players[i]);
	    }
	    //final ImageIcon icon = new ImageIcon("/Users/TJ/Downloads/IMG_6062.jpg");
	    
	    JOptionPane.showMessageDialog( null, "Total of " + numPlayers + " players! \n "+
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
		// add boardPanel to JFrame
		add(boardPanel);
	}

	// The function below is edited by tj
	public void chooseDeeds(HashSet<Square> myDeeds) {
		HashMap <String,Square> myMap = new HashMap<String, Square>();
		String labels[] = new String[myDeeds.size()];
		int i = 0;
		for(Square s: myDeeds){
			labels[i] = s.getName();
			myMap.put(labels[i], s);
			i++;
		}
		String input = (String) JOptionPane.showInputDialog(null, "Choose a deed to sell",
		        "Shop Smart", JOptionPane.QUESTION_MESSAGE, null, // Use
		                                                                        // default
		                                                                        // icon
		        labels, // Array of choices
		        labels[0]); // Initial choice
		    System.out.println("Selling deed: "+input);	     
		    //model.sellDeed(myMap.get(input));
		    modifyDeed(myMap.get(input));
	}
	
	public void modifyDeed(Square myDeed){
		String options[] = {"Sell","Build House","Build Hotel","Mortgage"};
		String decision = (String) JOptionPane.showInputDialog(null, "What would you like to do with your property?",
		        "The Choice of a Lifetime", JOptionPane.QUESTION_MESSAGE, null, // Use
		                                                                        // default
		                                                                        // icon
		        options, // Array of choices
		        options[0]); // Initial choice
		    System.out.println("Selling deed: "+decision);	
		
	}

	public void update() {
		msgTextArea.append(model.getMsg());
	}
	
	public void updateBoard(){
		System.out.println("Updating the board!");
		boardPanel.setVisible(false);
		setupBoard();
		boardPanel.setVisible(true);
	}
	
	public void disableRoll(){
		rollButton.setEnabled(false);
	}
	
	public void enableRoll(){
		rollButton.setEnabled(true);
	}
	
	public void dispose(){
		System.exit(0);
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
