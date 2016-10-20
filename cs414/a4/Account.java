package cs414.a4;


public class Account {
	private double curBalance;
	private Player curOwner ; 
			
			
	Account(Player p){
		
		setOwner(p);
	}
	public void setOwner(Player p ){
		curOwner = p;
		
	}
			
	public void setDefaultBalance(){
		curBalance = 0.0;
	}
	
	//-
	public void takeOutBalance(double due){
		curBalance = curBalance-due;
	}
	//+
	public void addInBalance(double due){
		curBalance = curBalance+due;
	}
	public double getBalance(){
		return curBalance;
	}
	
	

}
