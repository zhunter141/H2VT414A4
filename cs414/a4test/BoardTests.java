/* 
 * Team cs414d
 */
package cs414.a4test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import cs414.a4.Board;
import cs414.a4.Player;

public class BoardTests {
	
	private Board board;
	private int step = 1;
	private Player currPlayer;

	
	@Before
	public void setUp() throws Exception {
		board = new Board();
	}
	@After
	public void tearDown() throws Exception {
		board = null;
	}

	@Test
	public void testInitialize() {
		board.initialize();
		assertNotEquals(null,board.getStart());
	}
	
	@Test
	public void testInitializeF() {
		assertEquals(null,board.getStart());
	}
	
}
