package KitchenerApp;

public class CTime {
	
	private int hour;
	private int minute;
	
	public CTime(int h, int m) {
		if (h >= 0 && h <= 23) {
			this.hour = h;
		} else {
			// Invalid format, reset to 0
			h = 0;
		}
		
		if (m >= 0 && m <= 59) {
			this.minute = m;
		} else {
			// Invalid format, reset to 0
			m = 0;
		}
	}
	
	public int getHour() {
		return this.hour;
	}
	
	public int getMinute() {
		return this.minute;
	}
	
	/*
	 * LOW COUPLING - Time comparison returns only an integer for other objects to decide
	 * 					what to do with the results.
	 * HIGH COHESION - The class itself decides the relationship with other objects rather than 
	 * 					an outside class to take this responsibility.
	 */
	public int compareTo(CTime otherTime) {
		// Return the minute discrepancy for comparing purpose.
		return (this.hour * 60 + this.minute) 
				- (otherTime.hour * 60 + otherTime.minute);
	}

}
