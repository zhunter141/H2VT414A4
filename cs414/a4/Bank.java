package cs414.a4;

import java.util.HashMap;

public class Bank {
	//<Player,Account>
	private HashMap<Integer, Account> accountMap = new HashMap<Integer, Account>();

	private int playerTotal = 0;
	public Bank(){
		
	}
	
	
	//Test add correctly or not
	public void addClientANDAccount(Player p){
		Account newAccount = new Account(p);
		accountMap.put(p.getId(), newAccount);
		playerTotal++;
	}
	
	//Does the account match
	//Create class Due, because the bank can't hold all data.
	public boolean payDue(Player p, int d){
		Account curAccount =  (Account) accountMap.get(p);
		//box in view maybe, how we convert it
		if(willBroken(curAccount,d) == true){
			return false;
		}
		else{
			curAccount.takeOutBalance(d);
			return true;
		}
	}
	
	//this due is positive
	public void withdrawl(Player p,int d){
		Account curAccount =  (Account) accountMap.get(p);
		curAccount.addInBalance(d);
	}

	private boolean willBroken(Account curAccount,int d) {
		int curBalance = curAccount.getBalance();
		if(curBalance-d < 0 ){
			return true;
		}
		else{
			return false;
		}		
	}
	
	public HashMap<Integer, Account> getAccountListForTest(){
		return this.accountMap;
	}
	
	public int getBalance(Player p){
		Account a =(Account) accountMap.get(p.getId());
		System.out.println(((Account) accountMap.get(p.getId())).getBalance());
		return a.getBalance();
	}
	
	
}
