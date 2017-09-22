package mobilityhackathon.model;

public class RouteWrapperWrapper {
	
	private RouteWrapper[] schedules;
	
	public RouteWrapperWrapper() {
        super();
    }
	
	public RouteWrapperWrapper(String returnCode, RouteWrapper[] schedules) {
		this.setSchedules(schedules);
	}

	public RouteWrapper[] getSchedules() {
		return schedules;
	}

	public void setSchedules(RouteWrapper[] schedules) {
		this.schedules = schedules;
	}

}
