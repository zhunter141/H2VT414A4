package cs414.a4test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ BoardTests.class,SquareTests.class,DeedTests.class,PlayerTests.class,TokenTests.class })
public class AllTests {

}
