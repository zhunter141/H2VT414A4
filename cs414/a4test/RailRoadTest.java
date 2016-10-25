package cs414.a4test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import cs414.a4.*;

public class RailRoadTest {

	private Utility myRR;
	private final static String COLOR = "BLUE";
	private final static String NAME = "RTD";
	private int cost = 15;
	private Token myToken;
	
	@Before
	public void setUp(){
		myRR = new Utility(COLOR,NAME,cost);
		myToken = new Token("boot");
		Player bank = new Player(101,"bank",myToken);
	}
	@After
	public void tearDown(){
		myRR = null;
	}
	
	@Test
	public void testConstructorColor() {
		assertEquals("BLUE",myRR.getColor());	
	}
	
	@Test
	public void testConstructorNm() {
		assertEquals("RTD",myRR.getName());	
	}
	
	@Test
	public void testConstructorCost() {
		assertEquals(15, myRR.getCost());	
	}

}
