package cs414.a4test;

import static org.junit.Assert.*;
import java.awt.Color;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import cs414.a4.*;

public class PlayerTests {
	
	private Deed myDeed;
	private Token myToken;
	private Player p1;
	private Square mySquare;
	private final static Color COLOR = Color.yellow;
	private final static String NAME = "BALTIC AVENUE";
	private final static int COST = 60;
	private final static int HOUSECOST = 100;
	private final static int HOTELCOST = 150;

	@Before
	public void setUp(){
		p1 = new Player(1,"Tim",myToken);
		myDeed = new Deed(COLOR,NAME,COST,HOUSECOST,HOTELCOST,10);
		p1.addDeed(myDeed);		
	}
	
	@Test
	public void testGetID() {
		assertEquals(1,p1.getId());
	}
	
	@Test
	public void testGetName(){
		assertEquals("Tim",p1.getName());
	}
	
	@Test
	public void testDemoveDeeds(){
		p1.removeDeed(myDeed);
		assertEquals("",p1.toString());
		//System.out.println(p1.toString());
	}
	
	
	
	

}
