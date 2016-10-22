package cs414.a4test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import cs414.a4.*;

public class UtilityTest {
	
	private Utility myUtil;
	private final static String COLOR = "RED";
	private final static String NAME = "XCEL";
	private int cost = 20;
	private Token myToken;
	
	@Before
	public void setUp(){
		myUtil = new Utility(COLOR,NAME,cost);
		myToken = new Token("boot");
		Player bank = new Player(101,"bank",myToken);
	}
	@After
	public void tearDown(){
		myUtil = null;
	}
	
	@Test
	public void testConstructorColor() {
		assertEquals("RED",myUtil.getColor());	
	}
	
	@Test
	public void testConstructorNm() {
		assertEquals("XCEL",myUtil.getName());	
	}
	
	@Test
	public void testConstructorCost() {
		assertEquals(20, myUtil.getCost());	
	}

}
