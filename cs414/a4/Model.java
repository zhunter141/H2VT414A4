package cs414.a4;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;


public class Model {
	
	private Player[] allPlayers = new Player[4];
	private Token[] allTokens = new Token[4];
	private Board board;
	private Bank monopolyBank;
	private Dice dice;
	private int counter = 0;
	private int iterator = 0;
	private Player curPlayer;
	private String msg;

	
	private View view; 
	//Constructor
	public Model(){
		// initialize game objects
		board = new Board();
		dice = new Dice();
		board.initialize();
		msg = "";

		createTokens();
	}
	private void createTokens(){
		Token t1 =new Token("A",board.getStart());
		Token t2 =new Token("B",board.getStart());
		Token t3 =new Token("C",board.getStart());
		Token t4 =new Token("D",board.getStart());
		allTokens[0] = t1;		allTokens[1] = t2;
		allTokens[2] = t3;		allTokens[3] = t4;
	}
	
	
	//Our "View" class
	public void addView(View v)
	  {view = v;}

	
	Player getCurPlayer(){
		return curPlayer;
	}
	
	void rollDiceThroughButton(){
		int steps = dice.roll();
		msg = ""+steps;
		
		curPlayer = allPlayers[iterator%counter];

		board.move(steps,curPlayer.getToken());

		
		//Refactor later maybe
		//Do nothing because the player can click the button"Buy a deed"

		Square newSqr = curPlayer.getToken().getLoc();


		if(newSqr instanceof Utility){
			    Utility utility = (Utility)newSqr;
			
			
			    if(newSqr.getOwner() == null){
				//Do nothing because the player can click the button"Buy a deed"	
				}
				//pay rent
				else{
					int cost = utility.getRentCost();
					if(monopolyBank.payDue(curPlayer, cost) == true){}
					else{}
					monopolyBank.withdrawl(utility.getOwner(), cost);
				}

			
		}
		else if(newSqr instanceof Deed){
				Deed deed = (Deed)newSqr;
				
				
			    if(deed.getOwner() == null){
				//Do nothing because the player can click the button"Buy a deed"	
				}
				//pay rent
				else{
					int cost = deed.getRentCost();
					if(monopolyBank.payDue(curPlayer, cost) == true){}
					else{}
					monopolyBank.withdrawl(deed.getOwner(), cost);
				}

		}
		else if(newSqr instanceof RailRoad){
			RailRoad railRoad = (RailRoad)newSqr;
			
			
		    if(railRoad.getOwner() == null){
			//Do nothing because the player can click the button"Buy a deed"	
			}
			//pay rent
			else{
				int cost = railRoad.getRentCost();
				if(monopolyBank.payDue(curPlayer, cost) == true){}
				else{}
				monopolyBank.withdrawl(railRoad.getOwner(), cost);
			}


		}
		else{
			
		}
		
		
		iterator++;
		
		
		curPlayer = allPlayers[iterator%counter];

		if (view != null)    {
		      view.update();
		}
		
		
	}
	
	void addPlayerThroughButton(String name){
		Player p = new Player(counter,name,allTokens[counter]);
		allPlayers[counter] = p;
		counter ++;
		
		monopolyBank.addClientANDAccount(p);
		
		if (view != null){
			msg = "Added Player";
			view.update();
		}
		
		
	}
	
	// In this method, deed is a utility, railroad, deed
	//Pay attention on choose deed
	void sellDeedThroughButton(Square d){
		//removeDeeds()
		curPlayer.removeDeed(d);
		
		
		if(d instanceof Utility){
			Utility utility =  (Utility)d;
			d =  (Utility)d;

			int cost = utility.getCost();
			monopolyBank.withdrawl(utility.getOwner(), cost);
			
			
		}
		else if(d instanceof Deed){
			Deed deed =  (Deed)d;
			d =  (Deed)d;

			int cost = deed.getCost();
			monopolyBank.withdrawl(deed.getOwner(), cost);
			
		}
		else if(d instanceof RailRoad){
			RailRoad railRoad =  (RailRoad)d;
			d =  (RailRoad)d;

			int cost = railRoad.getCost();
			monopolyBank.withdrawl(railRoad.getOwner(), cost);


		}
		else{}
		

		//may go wrong because of the type
		d.setOwner(null);
		
		if (view != null)    {
		      //view.update();
		}
	}
	
	void buyDeedThroughButton(){
		Square cursqr = curPlayer.getToken().getLoc();
		Square sqrCopy = cursqr;
		int cost = 0;

		if(cursqr.isPurchasable() != true){}
		else{
			if(cursqr instanceof Utility){
				Utility utility =  (Utility)cursqr;
				cursqr =  (Utility)cursqr;
	
				cost = utility.getCost();
				
			
				
			}
			else if(cursqr instanceof Deed){
				Deed deed =  (Deed)cursqr;
				cursqr =  (Deed)cursqr;
	
				cost = deed.getCost();
				
			}
			else if(cursqr instanceof RailRoad){
				RailRoad railRoad =  (RailRoad)cursqr;
				cursqr =  (RailRoad)cursqr;
	
				cost = railRoad.getCost();
	
	
	
			}
			else{}
			 
			monopolyBank.payDue(curPlayer, cost);
			monopolyBank.withdrawl(cursqr.getOwner(), cost);
			
			curPlayer.addDeed(sqrCopy);
			cursqr.setOwner(curPlayer);
		}
		if (view != null)    {
		      view.update();
		}
	}
	
	//get status aka give status to view/others
	
	 public Player[] getPlayers(){

		 return allPlayers;
	 }
	 public Token[] getTokens(){
		 return allTokens;
	 }

	 public HashSet<Square> getDeeds(){
		 return curPlayer.getMyDeeds();
	 }
	 
	 public Board getBoard(){
		 return board;
	 }
	 
	 public String getMsg(){
		 return msg;
	 }

}
