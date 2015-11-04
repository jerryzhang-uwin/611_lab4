package KitchenerAppTests;

import static org.junit.Assert.*;

import org.junit.Test;

import KitchenerApp.CTime;

public class TestCTime {

	// Regular case
	@Test
	public void testValidHourAndMinute() {
		CTime time = new CTime(12, 45);
		assertEquals(12, time.getHour());
		assertEquals(45, time.getMinute());
	}
	
	// Negative test case : invalid hour, reset to 0
	@Test
	public void testInvalidHour() {
		CTime time = new CTime(25, 30);
		assertEquals(0, time.getHour());
	}
	
	//TODO add more test cases ...

}
