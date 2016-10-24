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
	private Account currAccount;
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
		msg = "Welcome to Monopoly Game!\n";
		msg += "Turn: ";
		currPlayer = players[0];
		msg += currPlayer.getName()+", Location: " + currPlayer.getToken().getLoc().getName();
		msg += "\n Account: $"+monopolyBank.getBalance(currPlayer);
		view.update();
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
			+'\n'+"My properties: "+ currPlayer.toString()+'\n'
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

		msg="Turn: "+currPlayer.getName()+" Location: "+currPlayer.getToken().getLoc().getName();
		view.update();
	}
	
	public void addPlayerThroughButton(String name){
		// Add player to game
		Player p = new Player(counter,name,allTokens[counter]);
		players[counter] = p;
		counter++;
		monopolyBank.addClient(p);
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
		
		msg = ""+"My properties: "+ currPlayer.toString()+'\n'
				+"My money: "+ monopolyBank.getBalance(currPlayer);
		
		if (view != null)    {
		      view.update();
		}
	}
	
	void buyDeed(){
		Square myLoc = currPlayer.getToken().getLoc();
		int costOfDeed;
		
		// Check myLoc is purchasable
		if(myLoc.isPurchasable() != true){
			msg = "You cannot purchase: "+myLoc.getName()+"\n";
		}
		// The square is purchasable because it is not own by anyone
		// determine the cost of the square
		else{
			if(myLoc instanceof Utility){
				Utility util =  (Utility)myLoc;
				costOfDeed = util.getCost();
	
			}
			else if(myLoc instanceof Deed){
				Deed deed =  (Deed)myLoc;
				costOfDeed = deed.getCost();
			}
			// Square MUST be RailRoad
			else{
				RailRoad railRoad =  (RailRoad)myLoc;
				costOfDeed = railRoad.getCost();
			}
			// CHECK THE PLAYER CAN AFFORD TO PURCHASE DEED
			msg = "This is the price of "+myLoc.getName()+" $"+costOfDeed;
			
			if(monopolyBank.payDue(currPlayer, costOfDeed) == false){
				msg = "Bank: "+currPlayer.getName()+" does not have enough money!";
			}
			else{
				currPlayer.addDeed(myLoc);
				myLoc.setOwner(currPlayer);
				msg = "Successfull purchased: "+myLoc.getName()+"! \n";
				msg += "It has been added your list of deeds.\n";
				
				//msg += "\nAccount: $"+monopolyBank.getBalance(currPlayer);
			}
			

		}
		
		msg += ""+"My properties: "+ currPlayer.toString()+'\n'

				+"Account: $"+ monopolyBank.getBalance(currPlayer);
		// UPDATE THE VIEW
		if (view != null){
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
