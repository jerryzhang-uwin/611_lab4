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
		this.meetingList.add(meeting);
		return 0;
		
	}

	public CMeeting getMeeting(int id)
	{
		return	meetingList.get(id);
	}
	
}