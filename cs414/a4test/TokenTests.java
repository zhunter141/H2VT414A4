package cs414.a4test;

import static org.junit.Assert.*;
import cs414.a4.*;
import org.junit.Before;
import org.junit.Test;

public class TokenTests {
	private Token t1;
	private Board b1;
	private Player p1;
	@Before
	public void setUp(){
		Token t1 = new Token("bird");
		Player p1 = new Player(1,"tj",t1);	
	}

	@Test
	public void testDescription() {
		//assertEquals("bird",t1.getDescription());
		System.out.println(t1);
	}
	@Test
	//Ensure that the board and the token has the same current location information of the player
    public void testMove(){
		//b1.initialize();
		//t1.move();
		//assertEquals(t1.getLoc(),"OLD KENT ROAD");
		//System.out.println(t1.getLoc());
		
	}

}
