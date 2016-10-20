package cs414.a4;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridLayout;

import javax.swing.*; 

@SuppressWarnings("serial")
public class MonopolyGameView extends JFrame{
	public static final int DEFAULT_WIDTH = 300;
	public static final int DEFAULT_HEIGHT = 200;
	
	// Window objects
	JButton buyButton;
	JButton sellButton;
	JPanel buttonPanel;
	JPanel gameMsgPanel;
	JTextArea msgTextArea;
	
	//Game objects
	// MonopolyGameModel model = new MonopolyGameModel();
	
	public MonopolyGameView(){
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
				buttonPanel.add(buyButton);
				buttonPanel.add(sellButton);
				
				// Add button panel to JFrame
				add(buttonPanel,BorderLayout.SOUTH);
	}
	private void addMsgPanel(){
		// initialization
		gameMsgPanel = new JPanel();
		gameMsgPanel.setBackground(Color.cyan);
		
		// msgTextFiled initialization 
		msgTextArea = new JTextArea(20,20);
		
		// Add a textfield to the gameMsgPanel
		gameMsgPanel.add(msgTextArea);
		
		// add gameMsgPanel to MonopolyGameFrame
		add(gameMsgPanel, BorderLayout.EAST);
		
	}
	
	public static void main(String[] args){
		EventQueue.invokeLater(new Runnable(){
			public void run(){
				MonopolyGameView mgv = new MonopolyGameView();
				mgv.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				mgv.setLocationByPlatform(true);
				mgv.setSize(800, 600);
				mgv.setVisible(true);
			}
		});
	}
	
}
