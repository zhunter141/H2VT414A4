package cs414.a4;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;


public class Model {
	
	private Player[] allPlayers = new Player[4];
	private HashSet<Token> allTokens;
	private HashSet<Deed> allDeeds;
	private Board board;
	private Bank monopolyBank;
	private Dice dice;
	private int counter = 0;
	private int iterator = 0;

	private Player curPlayer;

	
	private View view; 
	//Constructor
	public Model(){
		board = new Board();
		board.initialize();
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

		board.move(steps,curPlayer.getToken());

		
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
				int cost = utility.getCost();
				monopolyBank.payDue(curPlayer, cost);
				monopolyBank.withdrawl(utility.getOwner(), cost);
				
			}
			else{
				RailRoad railRoad =  (RailRoad)newSqr;
				int cost = railRoad.getCost();

				monopolyBank.payDue(curPlayer, cost);
				monopolyBank.withdrawl(railRoad.getOwner(), cost);


			}

		}
		
		
		
		
		
		
		iterator++;
		
		
		curPlayer = allPlayers[iterator%counter];

		if (view != null)    {
		      //view.update();
		}
		
		
	}
	
	void addPlayerThroughButton(Player p){
		
		allPlayers[counter] = p;
		counter ++;
		
		monopolyBank.addClientANDAccount(p);
		
		if (view != null)    {
		      //view.update();
		}
		
		
	}
	
	//Pay attention on choose deed
	void sellDeedThroughButton(Deed d){
		//removeDeeds()
		curPlayer.removeDeeds(d);
		monopolyBank.withdrawl(curPlayer, d.getCost());
		
		
		
		
		if (view != null)    {
		      //view.update();
		}
	}
	
	void buyDeedThroughButton(){
		
		
		
		
		
		if (view != null)    {
		      //view.update();
		}
	}
	
	void startThroughButton(){
		
		
		
		
		
		
	}
	
	
	//get status aka give status to view/others
	
	 public Player[] getPlayers(){

		 return allPlayers;
	 }
	 public HashSet<Token> getTokens(){
		 return allTokens;
	 }
	 public HashSet<Deed> getDeeds(){
		 return allDeeds;
	 }
	 
	 public Board getBoard(){
		 return board;
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
