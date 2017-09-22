package mobilityhackathon.model;

public class Time {

	private String date;
	private String time;
	
	public Time(String date, String time) {
		this.setDate(date);
		this.setTime(time);
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	} 
	
}
