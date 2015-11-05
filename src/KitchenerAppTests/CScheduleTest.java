package KitchenerAppTests;

import static org.junit.Assert.*;

import org.junit.Test;

import KitchenerApp.CMeeting;
import KitchenerApp.CSchedule;
import KitchenerApp.CTime;

public class CScheduleTest {

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
		CTime start = new CTime(9, 30);
		CTime end = new CTime(10, 15);
		String location = "Office Room 1";
		CMeeting meeting_1=new CMeeting(start,end,location);
		CSchedule schedule_1= new CSchedule();
		schedule_1.addMeeting(meeting_1);
	}
	
	//Storing Meeting test
	//Return the number of meetings
	@Test
	public void testStoreMeeting() 
	{
		CSchedule schedule_1= new CSchedule();
		CTime start_1 = new CTime(9, 30);
		CTime end_1 = new CTime(10, 15);
		String location_1 = "Office Room 1";
		CMeeting meeting_1=new CMeeting(start_1,end_1,location_1);
		schedule_1.addMeeting(meeting_1);
		
		CTime start_2 = new CTime(10, 30);
		CTime end_2 = new CTime(11, 0);
		String location_2 = "Office Room 1";
		CMeeting meeting_2=new CMeeting(start_2,end_2,location_2);
		schedule_1.addMeeting(meeting_2);
		
		assertEquals(2, schedule_1.getMeetingSize());
	}
	
	//Exist meeting test
	//Return -2 when adding a existed meeting
	@Test
	public void testExistMeeting() 
	{
		CSchedule schedule_1= new CSchedule();
		CTime start_1 = new CTime(9, 30);
		CTime end_1 = new CTime(10, 15);
		String location_1 = "Office Room 1";
		CMeeting meeting_1=new CMeeting(start_1,end_1,location_1);
		schedule_1.addMeeting(meeting_1);
		
		CTime start_2 = new CTime(10, 30);
		CTime end_2 = new CTime(11, 0);
		String location_2 = "Office Room 1";
		CMeeting meeting_2=new CMeeting(start_2,end_2,location_2);
		schedule_1.addMeeting(meeting_2);
		
		assertEquals(-2, schedule_1.addMeeting(meeting_1));
		assertEquals(-2, schedule_1.addMeeting(meeting_2));
	}
	
	
	
/*
	// Return -1 when the adding is not success, overlapping occurred
	@Test
	public void testOverlappingMeeting() 
	{
		CSchedule schedule_1= new CSchedule();
		CTime start_1 = new CTime(9, 30);
		CTime end_1 = new CTime(10, 15);
		String location_1 = "Office Room 1";
		CMeeting meeting_1=new CMeeting(start_1,end_1,location_1);
		schedule_1.addMeeting(meeting_1);
		
		CTime start_2 = new CTime(10, 0);
		CTime end_2 = new CTime(10, 50);
		String location_2 = "Office Room 1";
		CMeeting meeting_2=new CMeeting(start_2,end_2,location_2);
		
		
		assertEquals(-1, schedule_1.addMeeting(meeting_2));
	}
	
	*/
}
