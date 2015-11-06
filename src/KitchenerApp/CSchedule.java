package KitchenerApp;

import java.util.ArrayList;

public class CSchedule 
{
	//Array list meetingList is for storing CMeeting instant
	private ArrayList<CMeeting> meetingList;
	
	//Initialization
	public CSchedule()
	{
		this.meetingList=new ArrayList<CMeeting>();
	}
	
	//add new meeting in schedule and identify whether new meeting is overlapping by using isOverlapping method
	public void addMeeting(CMeeting meeting)
	{
		if(meetingList.isEmpty()) 
		{
			meetingList.add(meeting);
		}
		else if(isOverlapping(meeting)) System.out.println("The meeting is overlapping!");
		else meetingList.add(meeting);
	}

	public CMeeting getMeeting(int id)
	{
		return	meetingList.get(id);
	}
	
	public int getMeetingSize()
	{
		return meetingList.size();
	}
	
	//isOverlapping method is for checking whether meeting is overlapping or not
//	public boolean isOverlapping (CMeeting meeting, int index)
//	{
//		if(meeting.compareTo(meetingList.get(index))) return false;
//		else return true;
//	}
	public boolean isOverlapping (CMeeting meeting)
	{
		for(int i = 0;i<getMeetingSize();i++)
		{
			if(meeting.compareTo(meetingList.get(i))) return false;
			else if (!meeting.compareTo(meetingList.get(i))) return true;
		}
		
		return true;
	}
	
}