package cs414.a4;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridLayout;
import javax.swing.*; 

@SuppressWarnings("serial")
public class View extends JFrame{
	public static final int DEFAULT_WIDTH = 300;
	public static final int DEFAULT_HEIGHT = 200;
	
	// Window objects
	private JButton buyButton;
	private JButton sellButton;
	private JButton endTurnButton;
	
	private JPanel buttonPanel;
	private JPanel gameMsgPanel;
	
	private JTextArea msgTextArea;
	
	//Game objects
	private MonopolyGame model;
	private Controller ctrl;
	
	
	public View(){
		setTitle("Monopoly Game");
		setSize(DEFAULT_WIDTH,DEFAULT_HEIGHT);
		
		addButtonPanel();
		
		addMsgPanel();
	}
	
	private void addButtonPanel(){
		// setup button panel
				buttonPanel = new JPanel();
				buttonPanel.setBackground(Color.blue);
				buttonPanel.setLayout(new GridLayout(0,2));
				
				// Buttons initialization
				buyButton = new JButton("Buy");
				sellButton = new JButton("Sell");
				
				// Add buttons to buttonPanel
				JPanel container1 = new JPanel();
				JPanel container2 = new JPanel();
				
				container1.add(buyButton);
				container2.add(sellButton);
				
				buttonPanel.add(container1);
				buttonPanel.add(container2);
				
				// Add button panel to JFrame
				add(buttonPanel,BorderLayout.SOUTH);
	}
	
	private void addMsgPanel(){
		// initialization
		gameMsgPanel = new JPanel();
		gameMsgPanel.setBackground(Color.cyan);
		gameMsgPanel.setLayout(new GridLayout(2,0));
		
		// msgTextFiled initialization 
		msgTextArea = new JTextArea(20,20);
		JPanel container = new JPanel();
		container.setSize(20, 20);
		container.setBackground(Color.ORANGE);
		
		endTurnButton = new JButton("End Turn");
		container.add(endTurnButton);
		
		// Add a textfield to the gameMsgPanel
		gameMsgPanel.add(msgTextArea);
		gameMsgPanel.add(container);
		
		// add gameMsgPanel to MonopolyGameFrame
		add(gameMsgPanel, BorderLayout.EAST);
		
	}
	
	public void addModel(MonopolyGame model){
		this.model = model;
	}
	
	public void addController(Controller ctrl){
		this.ctrl = ctrl;
	}
	
	public static void main(String[] args){
		EventQueue.invokeLater(new Runnable(){
			public void run(){
				View mgv = new View();
				mgv.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				mgv.setLocationByPlatform(true);
				mgv.setSize(800, 600);
				mgv.setVisible(true);
				
				// link everything
			}
		});
	}
	
}
