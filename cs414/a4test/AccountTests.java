package cs414.a4test;
import static org.junit.Assert.*;

import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;

import cs414.a4.*;

public class AccountTests {
	private Square sqrStart ;
	private Bank myBank = new Bank();
	private Token token1 ;
	private Token token2 ;
	private Player p1 = new Player(1,"Alice",token1);
	private Player p2 = new Player(2,"Tom",token2);
	private Account a1 ;
	private Account a2 ;
	private HashMap bankAccounts ;

	
	@Before
	public void setUp(){
		myBank.addClientANDAccount(p1);
		myBank.addClientANDAccount(p2);
		bankAccounts = myBank.getAccountListForTest();
		a1 = (Account) bankAccounts.get(p1);
		a2 = (Account) bankAccounts.get(p2);
	}
	
	@Test
	public void testsetOwner() {
	assertEquals(p1,a1.getOwnerOfTheAccount());
	}
	
	@Test
	public void testsetDefaultMoney() {
	assertEquals(1500,a1.getBalance());
	}
	
	@Test
	public void testTakeOutBalance() {
	a1.takeOutBalance(120);
	assertEquals(1380,a1.getBalance());
	}
	@Test
	public void testAddInBalance() {
	a1.addInBalance(12);
	assertEquals(1512,a1.getBalance());
	}

}
