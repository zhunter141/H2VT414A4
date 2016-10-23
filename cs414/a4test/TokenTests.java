package cs414.a4test;

import static org.junit.Assert.*;
import cs414.a4.*;
import org.junit.Before;
import org.junit.Test;

public class TokenTests {
	@Before
	public void setUp(){
		Token t1;
		Board b1; 
		Player p1 = new Player(1,"tj","bird");

		
	}

	@Test
	public void testDescription() {
		t1.setDescription("bird");
		assertEquals("bird",t1.getDescription());
	}
	@Test
	//Ensure that the board and the token has the same current location information of the player
    public void testMove(){
		t1.move(3);
		assertEquals(t1.currLoc, b1.square.getLoc());//both return color blue location 3
		
	}

}
