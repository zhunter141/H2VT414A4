package cs414.a4test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import cs414.a4.RailRoad;

@RunWith(Suite.class)
@SuiteClasses({ BoardTests.class,SquareTests.class,DeedTests.class,PlayerTests.class,TokenTests.class,BankTests.class,AccountTests.class,TokenTests.class,UtilityTest.class,RailRoad.class })
public class AllTests {

}
