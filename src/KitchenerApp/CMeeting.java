package KitchenerApp;

public class CMeeting {
	
	/*
	 * CREATOR - CMeeting uses and creates CTime
	 */
	private CTime startTime;
	private CTime endTime;
	private String location;
	
	public CMeeting(CTime start, CTime end, String location) {
		
		int timeRange = end.compareTo(start);
		// Performs time check
		if (timeRange <= 0 || timeRange > 60) {
			throw new IllegalArgumentException("Time Range: start - end = " + timeRange);
		} else {
			this.startTime = start;
			this.endTime = end;
		}
		// Performs location check
		if (!location.isEmpty()) {
			this.location = location;
		} else {
			throw new IllegalArgumentException("Meeting location not specified");
		}
		
	}
	
	public CTime getStartTime() {
		return this.startTime;
	}
	
	public CTime getEndTime() {
		return this.endTime;
	}
	
	public String getLocation() {
		return this.location;
	}
	
	// Comparing other meeting's start time to this meeting's end time.
	// Other meeting's start time should not be equal to or earlier than this meeting's end time.
	public int compareTo(CMeeting other) {
		/*
		 * LOW COUPLING - Meeting comparison returns only an integer for other objects to decide
		 * 					what to do with the results.
		 * HIGH COHESION - The class itself decides the relationship with other objects rather than 
		 * 					an outside class to take this responsibility.
		 */
		return other.startTime.compareTo(this.endTime);
	}
}
