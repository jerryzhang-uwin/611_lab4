package KitchenerAppTests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import KitchenerApp.CMeeting;
import KitchenerApp.CSchedule;
import KitchenerApp.CTime;
import junit.framework.Assert;

public class TestCSchedule {

	//initial parameter for first meeting
	private CTime start_1;
	private CTime end_1;
	private String location_1;
	private CMeeting meeting_1;
	//initial parameter for second meeting 
	private CTime start_2;
	private CTime end_2;
	private String location_2;
	private CMeeting meeting_2;
	//initial parameter for third meeting (expected overlapping)
	private CTime start_3;
	private CTime end_3;
	private String location_3;
	private CMeeting meeting_3;
	//initial parameter for forth meeting (expected overlapping)
	private CTime start_4;
	private CTime end_4;
	private String location_4;
	private CMeeting meeting_4;
	//expected schedule storage
	CSchedule schedule;
	
	@Before
	public void setUp() throws Exception 
	{
		//setup an instant of first meeting
		start_1 = new CTime(9, 30);
		end_1 = new CTime(10, 15);
		location_1 = "Office Room 1";
		meeting_1 = new CMeeting(start_1,end_1,location_1);
		
		//setup an instant of second meeting 
		start_2 = new CTime(10, 30);
		end_2 = new CTime(11, 0);
		location_2 = "Office Room 1";
		meeting_2 = new CMeeting(start_2,end_2,location_2);
		
		//setup an instant of third meeting (expected overlapping)
		start_3 = new CTime(9, 40);
		end_3 = new CTime(10, 20);
		location_3 = "Office Room 2";
		meeting_3 = new CMeeting(start_3,end_3,location_3);
		
		//setup an instant of forth meeting
		start_4 = new CTime(13, 40);
		end_4 = new CTime(14, 40);
		location_4 = "Office Room 2";
		meeting_4 = new CMeeting(start_4,end_4,location_4);
		
		//setup an instant of CSchedule
		schedule = new CSchedule();
	}
	
	//Regular construct test
	@Test
	public void testConstructSchedule() 
	{
		new CSchedule();
	}
	
	//Regular adding meeting test
	@Test
	public void testAddMeeting() 
	{
		schedule.addMeeting(meeting_1);
	}
	
	//Storing Meeting test
	//Return the number of meetings
	@Test
	public void testStoreMeeting() 
	{
		schedule.addMeeting(meeting_1);
		schedule.addMeeting(meeting_2);
		schedule.addMeeting(meeting_3); //(expected overlapping)		
		//because meeting_3 is overlapping, the expected output should be 2
		assertEquals(2, schedule.getMeetingSize());
	}
		

	// Return true is meaning overlapping occurred
	@Test
	public void test_isOverlapping() 
	{
		schedule.addMeeting(meeting_1);
		schedule.addMeeting(meeting_2);
		assertEquals(true,schedule.isOverlapping(meeting_3));
		assertEquals(false,schedule.isOverlapping(meeting_4));
	}
	
	
}
