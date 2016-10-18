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
	private Token myToken;
	
	@Before
	public void setUp(){
		mySquare = new Square(COLOR,NAME);
		myToken = new Token("boot");
		Player bank(101,"bank",myToken);
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

	@Test
	public void testIsPurchaseable(){
		// test that a regular square is not purchasable by default
		assertFalse(mySquare.isPurchasable());
	}
	@Test
	public void testGetNext(){
		// check null return value when square has no reference to another square 'next'
		assertEquals(null,mySquare.getNext());
	}
	@Test 
	public void testSetNext(){
		// check correct square is returned 
		// note equals method overridden for Square class so that two 
		// Squares are equal if the have the same name. 
		Square nextSquare = new Square("BLUE","GO TO JAIL");
		mySquare.setNext(nextSquare);
		assertEquals(nextSquare, mySquare.getNext());
	}
	@Test
	public void testGetOwner1(){
		// a default square has no owner, this method should return a null reference
		assertEquals(null,mySquare.getOwner());
	}
	
	@Test
	public void testGetOwner2(){
		/* Some squares can be considered to be owned by the bank.
		 * Such as the Luxary Tax. This way when a player lands on this
		 * square they must pay the bank.  
		 */
		mySquare.setOwner(bank);
		assertEquals(bank,mySquare.getOwner());
	}
}
