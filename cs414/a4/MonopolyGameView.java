package cs414.a4;

import java.awt.EventQueue;

import javax.swing.*; 

@SuppressWarnings("serial")
public class MonopolyGameView extends JFrame{
	public static final int DEFAULT_WIDTH = 300;
	public static final int DEFAULT_HEIGHT = 200;
	
	public MonopolyGameView(){
		setTitle("Monopoly Game");
		setSize(DEFAULT_WIDTH,DEFAULT_HEIGHT);
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
