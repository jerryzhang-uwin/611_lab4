package KitchenerAppTests;

import static org.junit.Assert.*;

import org.junit.Test;

import KitchenerApp.CMeeting;
import KitchenerApp.CTime;

public class TestCMeeting {
	
	// Regular case
	@Test
	public void testRegularMeeting() {
		CTime start = new CTime(9, 30);
		CTime end = new CTime(10, 15);
		String location = "Office Room 1";
		new CMeeting(start, end, location);
	}
	
	// Boundary value test: One hour meeting should pass
	@Test
	public void testOneHourMeeting() {
		CTime start = new CTime(9, 30);
		CTime end = new CTime(10, 30);
		String location = "Office Room 1";
		new CMeeting(start, end, location);
	}

	// Boundary value test: throws exception when start time is equal to end time
	@Test(expected = IllegalArgumentException.class)
	public void endTimeShouldNotEqualToStartTime() {
		CTime start = new CTime(14, 30);
		CTime end = new CTime(14, 30);
		String location = "Office Room 1";
		new CMeeting(start, end, location);
	}
	
	// Throws exception when end time is before start time
	@Test(expected = IllegalArgumentException.class)
	public void endTimeShouldBeAfterStartTime() {
		CTime start = new CTime(14, 30);
		CTime end = new CTime(14, 15);
		String location = "Office Room 1";
		new CMeeting(start, end, location);
	}
	
	// Throws exception when meeting is more than 1 hour
	@Test(expected = IllegalArgumentException.class)
	public void meetingShouldNotBeMoreThanOneHour() {
		CTime start = new CTime(14, 30);
		CTime end = new CTime(15, 45);
		String location = "Office Room 1";
		new CMeeting(start, end, location);
	}
	
	// Throws exception when location is empty
	@Test(expected = IllegalArgumentException.class)
	public void locationShouldNotBeEmpty() {
		CTime start = new CTime(14, 30);
		CTime end = new CTime(15, 0);
		String location = "";
		new CMeeting(start, end, location);
	}

}
