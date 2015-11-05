package KitchenerAppTests;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import KitchenerApp.CTime;

public class TestCTime {
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	// Regular case
	@Test
	public void testValidHourAndMinute() {
		CTime time = new CTime(12, 45);
		assertEquals(12, time.getHour());
		assertEquals(45, time.getMinute());
	}
	
	// Negative test case : invalid hour and  minute,reset to 0
	@Test
	public void testInvalidHourAndMinute1() {
		CTime time = new CTime(25, 61);
		assertEquals(0, time.getHour());
		assertEquals(0, time.getMinute());
	}
	
	@Test
	public void testInvalidHourAndMinute2() {
		CTime time = new CTime(-1, -1);
		assertEquals(0, time.getHour());
		assertEquals(0, time.getMinute());
	}
	//Test about compareTo,including 3 types of results:positive,minus integer,0
	@Test
	public void testCompareTo1(){
		CTime time1=new CTime(11,22);
		CTime time2=new CTime(23,33);
		assertEquals((11*60+22)-(23*60+33),time1.compareTo(time2));
	}
	@Test
	public void testCompareTo2(){
		CTime time1=new CTime(23,49);
		CTime time2=new CTime(8,45);
		assertEquals((23*60+49)-(8*60+45),time1.compareTo(time2));
	}
	@Test
	public void testCompareTo3(){
		CTime time1=new CTime(15,55);
		CTime time2=new CTime(15,55);
		assertEquals(0,time1.compareTo(time2));
	}
	
}
