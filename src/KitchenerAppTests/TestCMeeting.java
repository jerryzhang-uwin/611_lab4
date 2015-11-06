package KitchenerAppTests;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import KitchenerApp.CMeeting;
import KitchenerApp.CTime;

public class TestCMeeting {
	
	public static CTime time1;
	public static CTime time2;
	public static CTime time3;
	public static CTime time4;
	public static CTime time5;
	
	public static String location;
	public static String emptyLocation;
	
	public static CMeeting meeting1;
	public static CMeeting meeting2;
	public static CMeeting meeting3;
	public static CMeeting meeting4;
	
	// Initialize all variables that will be used by tests.
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
		time1 = new CTime(9, 30);
		time2 = new CTime(10, 15);
		time3 = new CTime(10, 30);
		time4 = new CTime(11, 30);
		time5 = new CTime(12, 30);
		
		location = "Office Room 1";
		emptyLocation = "";
		
		meeting1 = new CMeeting(time1, time3, location);
		meeting2 = new CMeeting(time3, time4, location);
		meeting3 = new CMeeting(time4, time5, location);
		meeting4 = new CMeeting(time2, time3, location);
		
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		// Nothing to do.
	}
	
	// Regular case
	@Test
	public void testRegularMeeting() {
		new CMeeting(time1, time2, location);
	}
	
	// Boundary value test: One hour meeting should pass
	@Test
	public void testOneHourMeeting() {
		new CMeeting(time1, time3, location);
	}

	// Boundary value test: throws exception when start time is equal to end time
	@Test(expected = IllegalArgumentException.class)
	public void endTimeShouldNotEqualToStartTime() {
		new CMeeting(time1, time1, location);
	}
	
	// Throws exception when end time is before start time
	@Test(expected = IllegalArgumentException.class)
	public void endTimeShouldBeAfterStartTime() {
		new CMeeting(time2, time1, location);
	}
	
	// Throws exception when meeting is more than 1 hour
	@Test(expected = IllegalArgumentException.class)
	public void meetingShouldNotBeMoreThanOneHour() {
		new CMeeting(time1, time5, location);
	}
	
	// Meeting comparison tests (test if two meetings overlap or not)
	@Test
	public void testOverlapMeetings() {
		assertFalse(meeting1.compareTo(meeting2));
		assertTrue(meeting1.compareTo(meeting3));
		assertFalse(meeting1.compareTo(meeting4));
		assertTrue(meeting3.compareTo(meeting1));
	}
	
	// Throws exception when location is empty
	@Test(expected = IllegalArgumentException.class)
	public void locationShouldNotBeEmpty() {
		new CMeeting(time1, time2, emptyLocation);
	}

}
