package cs414.a4test;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import cs414.a4.*;

public class SquareTests {
	private Square mySquare;
	private final static String COLOR = "RED";
	private final static String NAME = "GO";
	@Before
	public void setUp(){
		mySquare = new Square(COLOR,NAME);
	}
	@After
	public void tearDown(){
		mySquare = null;
	}
	@Test
	public void testConstructor1() {
		// test to see correct color has been set for this square.
		assertEquals("RED",mySquare.getColor());
	}
	@Test
	public void testConstructor2(){
		// test to see that the name of the square has been correctly set.
		assertEquals("GO",mySquare.getName());
	}

}
