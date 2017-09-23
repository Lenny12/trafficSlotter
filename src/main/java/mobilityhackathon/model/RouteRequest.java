package mobilityhackathon.model;

public class RouteRequest {
	
	private String language = "de";
	private int version = 16;
	private String filterType = "HVV_LISTED";
	private Place start;
	private Place dest;
	private Time time;
	private boolean timeIsDeparture = false;
	private int numberOfSchedules = 3;
	
	public RouteRequest(Place start, Place dest, Time time) {
		this.start = start;
		this.dest = dest;
		this.time = time;
	}

}
