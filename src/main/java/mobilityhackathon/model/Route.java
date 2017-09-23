package mobilityhackathon.model;

public class Route {
	
	private RoutePlaceStart from;
	private RoutePlaceDest to;
	
	public Route() {
        super();
    }
	
	public Route(RoutePlaceStart from, RoutePlaceDest to) {
		this.setFrom(from);
		this.setTo(to);
	}

	public RoutePlaceStart getFrom() {
		return from;
	}

	public void setFrom(RoutePlaceStart from) {
		this.from = from;
	}

	public RoutePlaceDest getTo() {
		return to;
	}

	public void setTo(RoutePlaceDest to) {
		this.to = to;
	}

}
