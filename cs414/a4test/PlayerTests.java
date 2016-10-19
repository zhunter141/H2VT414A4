import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PlayerTests {

	@Before
	public void setUp(){
		Player p1 = new Player(1,"tj","bird");
		// create a collections of deeds 
		p1.setMyDeeds("railroad");
		
	}
	
	@Test
	public void testGetID() {
		assertEquals(1,p1.getName());
	}
	@Test
	public void testGetName(){
		assertEquals("tj",p1.getName());
	}
	@Test
	public void testGetMyDeeds(){
		assertEquals("railraod",p1.getMyDeeds());

	}

}
