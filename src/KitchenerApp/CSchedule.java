package KitchenerApp;

import java.util.ArrayList;

public class CSchedule 
{

	private ArrayList<CMeeting> meetingList;
	
	
	public CSchedule()
	{
		this.meetingList=new ArrayList<CMeeting>();
	}
	
	
	public int addMeeting(CMeeting meeting)
	{
		// if there is no overlapping then add the meeting
		// the function is in CMeeting.java
		// if failed return -1
		if(meetingList.contains(meeting)==true)
		{
			System.out.println("The meeting already exists!");
			return -2;
		}
		this.meetingList.add(meeting);
		return 0;
		
	}

	public CMeeting getMeeting(int id)
	{
		return	meetingList.get(id);
	}
	public int getMeetingSize()
	{
		return meetingList.size();
	}
	
}