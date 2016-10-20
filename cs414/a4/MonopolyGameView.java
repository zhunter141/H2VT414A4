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
	JPanel buttonPanel;
	
	//Game objects
	// MonopolyGameModel
	public MonopolyGameView(){
		setTitle("Monopoly Game");
		setSize(DEFAULT_WIDTH,DEFAULT_HEIGHT);
		
		// setup button panel
		buttonPanel = new JPanel();
		buttonPanel.setBackground(Color.blue);
		buttonPanel.setLayout(new GridLayout(0,2));
		
		// Buttons initialization
		buyButton = new JButton("Buy");
		
		// Add buttons to buttonPanel
		buttonPanel.add(buyButton);
		
		// Add button panel to JFrame
		add(buttonPanel,BorderLayout.SOUTH);
	}
	
	public static void main(String[] args){
		EventQueue.invokeLater(new Runnable(){
			public void run(){
				MonopolyGameView mgv = new MonopolyGameView();
				mgv.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				mgv.setLocationByPlatform(true);
				mgv.setVisible(true);
			}
		});
	}
	
}
