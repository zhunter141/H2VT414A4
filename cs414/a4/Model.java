package cs414.a4;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;


public class Model {
	
	private Player[] players;
	private Token[] allTokens;
	private Board board;
	private Bank monopolyBank;
	private Dice dice;
	private int counter;
	private int iterator;
	private Player currPlayer;
	private String msg;
	private View view;
	
	public Model(){
		// initialize game objects
		board = new Board();
		dice = new Dice();
		monopolyBank = new Bank();
		board.initialize();
		msg = "";
		players = new Player[4];
		allTokens = new Token[4];
		iterator = 0;
		counter = 0;
		createTokens();
	}
	private void createTokens(){
		Token t1 =new Token("A",board.getStart());
		Token t2 =new Token("B",board.getStart());
		Token t3 =new Token("C",board.getStart());
		Token t4 =new Token("D",board.getStart());
		allTokens[0] = t1;		
		allTokens[1] = t2;
		allTokens[2] = t3;
		allTokens[3] = t4;
	}
	
	//Our "View" class
	public void addView(View v){
		view = v;
	}

	
	Player getCurrPlayer(){
		return currPlayer;
	}
	
	// Respond to Controller button presses
	
	public void startGame(){
		// Start the game by setting the current player
		currPlayer = players[0];
		msg = currPlayer.getName();
	}
	
	public void rollDice(){
		// Determine who is the current Player
		currPlayer = players[iterator%counter];
		int steps = dice.roll();
		msg = ""+currPlayer.getName()+" rolled: "+steps;
		view.update();
		move(steps);
	}
	
	private void move(int steps){
		// Tell the board to Move the player's token 
			board.move(steps,currPlayer.getToken());
			Square currLoc = currPlayer.getToken().getLoc();
			msg=""+currPlayer.getName()+" is now on: "+currLoc.getName()
			+'\n'+"My properties: "+ currPlayer.getMyDeeds().toString()+'\n'
			+"My money: "+ monopolyBank.getBalance(currPlayer);
			view.update();
		/*
		//Refactor later maybe
		//Do nothing because the player can click the button"Buy a deed"

		Square newSqr = currPlayer.getToken().getLoc();


		if(newSqr instanceof Utility){
			    Utility utility = (Utility)newSqr;
			
			
			    if(newSqr.getOwner() == null){
				//Do nothing because the player can click the button"Buy a deed"	
				}
				//pay rent
				else{
					int cost = utility.getRentCost();

					if(monopolyBank.payDue(currPlayer, cost) == true){}
					else{
						msg = "No enough money to pay rent/taxes";
					}
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

					if(monopolyBank.payDue(currPlayer, cost) == true){}
					else{
						msg = "No enough money to pay rent/taxes";

					}
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
				
				if(monopolyBank.payDue(currPlayer, cost) == true){}
				else{
					msg = "No enough money to pay rent/taxes";

				}
				monopolyBank.withdrawl(railRoad.getOwner(), cost);
			}


		}
		else{
			
		}
		*/
		// Tell the view to update itself since the state of the model has changed!
	}
	
	public void endTurn(){
		iterator++;
		currPlayer = players[iterator%counter];
		msg="It is now: "+currPlayer.getName()+" turn.";
		view.update();
	}
	
	public void addPlayerThroughButton(String name){
		// Add player to game
		Player p = new Player(counter,name,allTokens[counter]);
		players[counter] = p;
		counter++;
		monopolyBank.addClientANDAccount(p);
		
		if (view != null){
			msg = "Added Player";
			view.update();
		}
	}
	
	void sellDeedThroughButton(Square d){
		// In this method, deed is a utility, railroad, deed
		//Pay attention on choose deed
		//removeDeeds()
		currPlayer.removeDeed(d);
		
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
		
		msg = ""+"My properties: "+ currPlayer.getMyDeeds().toString()+'\n'
				+"My money: "+ monopolyBank.getBalance(currPlayer);
		
		if (view != null)    {
		      view.update();
		}
	}
	
	void buyDeedThroughButton(){
		Square cursqr = currPlayer.getToken().getLoc();
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
			 
			if(monopolyBank.payDue(currPlayer, cost) == false){
				msg = "No enough money to pay price";

			}
			monopolyBank.withdrawl(cursqr.getOwner(), cost);
			
			currPlayer.addDeed(sqrCopy);
			cursqr.setOwner(currPlayer);
		}
		
		msg = ""+"My properties: "+ currPlayer.getMyDeeds().toString()+'\n'
				+"My money: "+ monopolyBank.getBalance(currPlayer);
		if (view != null)    {
		      view.update();
		}
	}
	
	//get status aka give status to view/others
	
	 public Player[] getPlayers(){

		 return players;
	 }
	 public Token[] getTokens(){
		 return allTokens;
	 }

	 public HashSet<Square> getDeeds(){
		 return currPlayer.getMyDeeds();
	 }
	 
	 public Board getBoard(){
		 return board;
	 }
	 
	 public String getMsg(){
		 return msg;
	 }

}
