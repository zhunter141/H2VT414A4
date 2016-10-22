package cs414.a4test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import cs414.a4.*;

public class PlayerTests {
	
	private Deed myDeed;
	private Token myToken;
	private Player p1;
	private Square mySquare;
	private final static String COLOR = "BROWN";
	private final static String NAME = "BALTIC AVENUE";
	private final static int COST = 60;
	private final static int HOUSECOST = 100;
	private final static int HOTELCOST = 150;

	@Before
	public void setUp(){
		p1 = new Player(1,"Tim",myToken);
		myDeed = new Deed(COLOR,NAME,COST,HOUSECOST,HOTELCOST);
		//p1.addDeed(myDeed);
		
	}
	//@After
	//public void tearDown() throws Exception {
	//	p1 = null;
	//}
	
	
	@Test
	public void testGetID() {
		assertEquals(1,p1.getId());
	}
	
	@Test
	public void testGetName(){
		assertEquals("Tim",p1.getName());
	}
	/*
	@Test
	public void testGetMyDeeds(){
		assertEquals("railraod",p1.getMyDeeds());

	}
	*/

}
