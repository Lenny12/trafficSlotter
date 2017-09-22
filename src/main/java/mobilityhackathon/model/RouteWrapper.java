package mobilityhackathon.model;

public class RouteWrapper {
	
	private Route[] scheduleElements;
	
	public RouteWrapper() {
        super();
    }
	
	public RouteWrapper(Route[] scheduleElements, int routeId, Place start, Place dest, int time, int footpathTime, Tickets[] tickets) {
		this.setScheduleElements(scheduleElements);
	}

	public Route[] getScheduleElements() {
		return scheduleElements;
	}

	public void setScheduleElements(Route[] scheduleElements) {
		this.scheduleElements = scheduleElements;
	}

}
