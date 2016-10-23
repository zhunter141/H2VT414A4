package cs414.a4;


public class Account {
	private int curBalance;
	private Player curOwner ; 
			
			
	public Account(Player p){

		setOwner(p);
		setDefaultBalance();
	}
	public void setOwner(Player p ){		
		curOwner = p;
	
	}
			
	public void setDefaultBalance(){
		curBalance = 1500;
	}
	
	//-
	public void takeOutBalance(int due){
		curBalance = curBalance-due;
	}
	//+
	public void addInBalance(int due){
		curBalance = curBalance+due;
	}
	public int getBalance(){
		return curBalance;
	}
	
	public Player getOwnerOfTheAccount(){
		return curOwner;
	}

}
