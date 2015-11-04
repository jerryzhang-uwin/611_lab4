package KitchenerApp;

public class CMeeting {
	
	private CTime startTime;
	private CTime endTime;
	private String location;
	
	public CMeeting(CTime start, CTime end, String location) {
		
		int timeRange = end.compareTo(start);
		// Performs time check
		if (timeRange <= 0 && timeRange > 60) {
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
}
