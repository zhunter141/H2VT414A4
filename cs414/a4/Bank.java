package cs414.a4;

import java.util.HashMap;

public class Bank {
	//<Player,Account>
	private HashMap accountMap = new HashMap();

	private int playerTotal = 0;
	
	
	
	//Test add correctly or not
	public void addClientANDAccount(Player p){
		Account newAccount = new Account(p);
		accountMap.put(p, newAccount);
		playerTotal++;
	}
	
	//Does the account match
	//Create class Due, because the bank can't hold all data.
	public void payDue(Player p, Due d){
		Account curAccount =  (Account) accountMap.get(p);
		//box in view maybe, how we convert it
		if(willBroken(curAccount,d) == true){
			System.out.println("No enough money");
		}
		else{
			curAccount.takeOutBalance(d.getAmount());
		}
		
		
		
		
		
	}
	
	//this due is positive
	public void withdrawl(Player p,Due d){
		Account curAccount =  (Account) accountMap.get(p);
		curAccount.addInBalance(d.getAmount());

	}

	private boolean willBroken(Account curAccount,Due d) {
		double curBalance = curAccount.getBalance();
		if(curBalance-d.getAmount() < 0.0 ){
			return true;
		}
		else{
			return false;
		}		
	}
	
	
	
	
}
