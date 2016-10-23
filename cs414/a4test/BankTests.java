package cs414.a4test;

import static org.junit.Assert.*;

import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;
import cs414.a4.*;


public class BankTests {
	private Square sqrStart ;
	private Bank myBank = new Bank();
	private Token token1 ;
	private Token token2 ;
	private Player p1 = new Player(1,"Alice",token1);
	private Player p2 = new Player(2,"Tom",token2);

	@Before
	public void setUp(){
		myBank.addClientANDAccount(p1);
		myBank.addClientANDAccount(p2);


	}
	@Test
	public void testaddClientANDAccountWithDefault() {
		HashMap bankAccounts = myBank.getAccountListForTest();
		Account a1 = new Account(p1);
		assertEquals(1500,bankAccounts.get(p1));
		
		

	}
	@Test
	public void testaddClientANDAccount(){
		HashMap bankAccounts = myBank.getAccountListForTest();
		int total =0;

		myBank.payDue(p1, 89);
		
		myBank.withdrawl(p2, 99);
		
		//total = (int) bankAccounts.get(p2)+;
		assertEquals(3010,bankAccounts.get(p2));
		assertEquals(1500,bankAccounts.get(p1));


		
	}
	
	
	

}
