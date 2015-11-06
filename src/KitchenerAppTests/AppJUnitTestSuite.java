package KitchenerAppTests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/*
 * Specifies the JUnit test runner as Suite.
 * Includes all the expected test modules and their test order.
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
	TestCTime.class,
	TestCMeeting.class,
	TestCSchedule.class
})

public class AppJUnitTestSuite {
	  // the class remains empty,
	  // used only as a holder for the above annotations
}
