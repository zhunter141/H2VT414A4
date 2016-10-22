package cs414.a4;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;


public class Model {
	
	private Player[] allPlayers = new Player[4];
	private HashSet<Token> allTokens;
	private HashSet<Deed> allDeeds;
	private Board monopolyBoard;
	private Bank monopolyBank;
	private Dice twoDices;
	private int counter = 0;
	private int iterator = 0;

	private Player curPlayer;

	
	private View view; 
	//Constructor
	public Model(){
		
	}
	
	
	
	//Our "View" class
	public void addView(View v)
	  {view = v;}

	
	Player getCurPlayer(){
		return curPlayer;
	}
	
	void rollDiceThroughButton(Dice d){
		int steps = d.roll();
		curPlayer = allPlayers[iterator%counter];


		monopolyBoard.move(steps,curPlayer.getToken());
		
		//Refactor later maybe
		
		Square newSqr = curPlayer.getToken().getLoc();
		//Is a deed
		if(newSqr instanceof Deed){
		//Do nothing because the player can click the button"Buy a deed"
		}
		//Utility or a RailRoad
		else{
			if(newSqr instanceof Utility){
				Utility utility =  (Utility)newSqr;
				monopolyBank.payDue(curPlayer, utility.getCost());
				
			}
			else{
				RailRoad railRoad =  (RailRoad)newSqr;

				monopolyBank.payDue(curPlayer, railRoad.getCost());

			}

		}
		
		
		
		
		
		
		iterator++;
		
		
		curPlayer = allPlayers[iterator%counter];

		if (view != null)    {
		      view.update();
		}
		
		
	}
	
	void addPlayerThroughButton(Player p){
		
		allPlayers[counter] = p;
		counter ++;
		
		monopolyBank.addClientANDAccount(p);
		
		if (view != null)    {
		      view.update();
		}
		
		
	}
	
	void sellDeedThroughButton(Deed d){
		
		
		
		
		
		if (view != null)    {
		      view.update();
		}
	}
	
	void buyDeedThroughButton(){
		
		
		
		
		
		if (view != null)    {
		      view.update();
		}
	}
	
	void startThroughButton(){
		
		
		
		
		
		
	}
	
	
	//get status aka give status to view/others
	
	 Player[] getPlayers(){
		 return allPlayers;
	 }
	 HashSet<Token> getTokens(){
		 return allTokens;
	 }
	 HashSet<Deed> getDeeds(){
		 return allDeeds;
	 }
	 
	 Board getBoard(){
		 return monopolyBoard;
	 }
	 
	
	
	
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
