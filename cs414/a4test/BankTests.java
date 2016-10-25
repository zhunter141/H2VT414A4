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
	public void testaddClientANDAccountWithDefault() {
		HashMap bankAccounts = myBank.getAccountListForTest();
		a1 = (Account) bankAccounts.get(p1);
		assertEquals(1500,a1.getBalance());
		
		

	}
	
	@Test
	public void testaddClientANDAccount(){
		int total =0;
		myBank.payDue(p1, 89);
		myBank.withdrawl(p2, 99);
		total = a1.getBalance()+a2.getBalance();
		
		assertEquals(3010,total);



		
	}
	@Test
	public void testPayDueFalse(){
		boolean b = myBank.payDue(p1, 1700);
		assertEquals(false,b);

		
	}
	@Test
	public void testPayDue(){
		boolean b = myBank.payDue(p1, 100);
		assertEquals(1400,a1.getBalance());		
	}
	@Test
	public void testWithdrawl(){
		myBank.withdrawl(p1, 99);
		assertEquals(1599,a1.getBalance());

	}
	@Test
	public void testGetBalance(){
		myBank.withdrawl(p1, 99);
		assertEquals(1599,myBank.getBalance(p1));

	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
