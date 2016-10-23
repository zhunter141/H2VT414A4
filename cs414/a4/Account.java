package cs414.a4;


public class Account {
	private int curBalance;
	private Player curOwner ; 
			
			
	Account(Player p){

		setOwner(p);
	}
	public void setOwner(Player p ){
		curOwner = p;
		
	}
			
	public void setDefaultBalance(){
		curBalance = 0;
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
	
	

}
