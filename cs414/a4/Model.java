package cs414.a4;

import java.io.IOException;
import java.util.Set;

import colorCalculator.View;

public class Model {
	
	private Set<Player> allPlayers;
	private Set<Token> allTokens;
	private Board monopolyBoard;
	private Bank monopolyBank;
	private Dice twoDices;

	
	private View view; 
	//Constructor
	public Model(){
		
	}
	
	
	
	//Our "View" class
	public void addView(View v)
	  {view = v;}

	
	
	void rollDiceThroughButton(Player p,Dice d){
		int steps = d.roll();
		//need update
		monopolyBoard.move();
		
		if (view != null)    {
		      view.update();
		      }
		
	}
	
	void addPlayerThroughButton(){
		
	}
	
	void sellDeedThroughButton(){
		
	}
	
	void buyDeedThroughButton(){
		
	}
	
	void startThroughButton(){
		
	}
	
	
	//get status aka give status to view/others
	
	
	
	
	
	
	
	public static void main(String args[]) throws IOException{
	//Need throw exception?
	
	//Here Start
	Model ourGame = new Model();

	}
/*
private void startup() throws IOException{
	Player player1 = new Player();
	Player player2 = new Player();

	Board theBoard = new Board();
	
	Square startSqr = theBoard.createBoard();
	
	player1.setSqr(startSqr);
	player2.setSqr(startSqr);

	

	


	
	
}*/


}
