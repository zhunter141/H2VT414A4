package cs414.a4test;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import cs414.a4.*;

public class AccountTests {
	private Player p1 ;
	private Account a1 ;
	private Bank myBank = new Bank();
	@Before
	public void setUp(){
		p1 = null;
		

	}
	
	
	@Test
	public void testsetOwner() {
		myBank.addClientANDAccount(p1);
		assertEquals();
	}

}
