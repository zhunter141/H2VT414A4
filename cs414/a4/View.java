package cs414.a4;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.util.HashSet;

import javax.swing.*; 

@SuppressWarnings("serial")
public class View extends JFrame{
	public static final int DEFAULT_WIDTH = 300;
	public static final int DEFAULT_HEIGHT = 200;
	
	// Window objects
	private JButton buyButton;
	private JButton sellButton;
	private JButton endTurnButton;
	private JButton rollButton;
	//private JButton payButton;
	
	private JPanel buttonPanel;
	private JPanel gameMsgPanel;
	private JPanel boardPanel;
	
	private JTextArea msgTextArea;
	
	//Game objects
	private Model model;
	private Controller ctrl;
	
	
	public View(){
		setTitle("Monopoly Game");
		setSize(DEFAULT_WIDTH,DEFAULT_HEIGHT);
	}
	
	public void setUpGUI(){
		addButtonPanel();
		addMsgPanel();
		setupBoard();
	}
	private void addButtonPanel(){
		// setup button panel
				buttonPanel = new JPanel();
				buttonPanel.setBackground(Color.blue);
				buttonPanel.setLayout(new GridLayout(2,2));
				
				// Buttons initialization
				buyButton = ctrl.getBuyButton();
				sellButton = ctrl.getSellButton();
				rollButton   = ctrl.getRollDiceButton();
				endTurnButton = ctrl.getEndTurnButton();
				
				
				// Add buttons to buttonPanel
				buttonPanel.add(buyButton);
				buttonPanel.add(sellButton);
				buttonPanel.add(rollButton);
				buttonPanel.add(endTurnButton);
				
				// Add button panel to JFrame
				add(buttonPanel,BorderLayout.SOUTH);
	}
	
	private void addMsgPanel(){
		// initialization
		gameMsgPanel = new JPanel();
		gameMsgPanel.setBackground(Color.cyan);
		gameMsgPanel.setLayout(new GridLayout(3,0));
		
		// msgTextFiled initialization 
		msgTextArea = new JTextArea(10,20);
		JPanel container = new JPanel();
		//container.setSize(20, 20);
		container.setBackground(Color.ORANGE);
		
		// Add a textfield to the gameMsgPanel
		gameMsgPanel.add(msgTextArea);
		gameMsgPanel.add(container);
		
		// add gameMsgPanel to MonopolyGameFrame
		add(gameMsgPanel, BorderLayout.EAST);
		
	}
	
	public void addModel(Model model){
		this.model = model;
	}
	
	public void addController(Controller ctrl){
		this.ctrl = ctrl;
	}
	
	
	private void setupBoard(){
		Board myBoard = model.getBoard();
		Square curr = myBoard.getStart();
		
		boardPanel = new JPanel();
		boardPanel.setBackground(Color.ORANGE);
		boardPanel.setLayout(new GridLayout(3,0));
		boardPanel.setSize(10,10);
		
		JPanel r1 = new JPanel();
		
		for(int i=0;i<10;i++){
			JButton b1 = new JButton(""+curr.getName());
			r1.add(b1);
			curr = curr.getNext();
		}
		
		JPanel r2 = new JPanel();
		r2.setLayout(new GridLayout(0,3));
		
		JPanel r2c1 = new JPanel();
		r2c1.setBackground(Color.PINK);
		r2c1.setLayout(new GridLayout(10,0));
		
		for(int i=0;i<10;i++){
			JButton b1 = new JButton("Avenue "+i);
			r2c1.add(b1);
		}
		
		JPanel r2c2 = new JPanel();
		r2.setBackground(Color.yellow);
	
		JPanel r2c3 = new JPanel();
		r2.setBackground(Color.blue);
		r2c3.setLayout(new GridLayout(10,0));
		
		for(int i=0;i<10;i++){
			JButton b1 = new JButton(""+i);
			r2c3.add(b1);
		}
		// add cols to r2
		r2.add(r2c1);
		r2.add(r2c2);
		r2.add(r2c3);
		
		JPanel r3 = new JPanel();
		
		for(int i=0;i<10;i++){
			JButton b1 = new JButton(""+i);
			r3.add(b1);
		}
		
		// add all rows to boardPanel
		boardPanel.add(r1);
		boardPanel.add(r2);
		boardPanel.add(r3);
		
		// add boardPanel to JFrame
		add(boardPanel,BorderLayout.WEST);
	}
	
	public static Square chooseDeeds(HashSet<Square> myDeeds){
		System.out.println("Player Must choose a deed to sell.");
		Square deedToSell = null;
		return deedToSell;
	}
	
	public void update(){
		String msg = model.getMsg();
		msgTextArea.append(msg+"\n");
	}
	
	public static void main(String[] args){
		EventQueue.invokeLater(new Runnable(){
			public void run(){
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
				
				// Pseudo Menu Screen
				model.addPlayerThroughButton("TJ");
				model.addPlayerThroughButton("HZ");
				model.startGame();
				
			}
		});
	}
	
}
