package mobilityhackathon.model;

public class RoutePlaceStart extends Place {

	private Time depTime;
	private Line line;
	
	public RoutePlaceStart() {
        super();
    }
	
	public RoutePlaceStart(String name, String city, String combinedName, String id, String type, Coordinate coordinate, String serviceTypes[], Time depTime, Line line) {
		super(name, city, combinedName, id, type, coordinate, serviceTypes);
		this.setDepTime(depTime);
		this.setLine(line);
	}

	public Time getDepTime() {
		return depTime;
	}

	public void setDepTime(Time depTime) {
		this.depTime = depTime;
	}

	public Line getLine() {
		return line;
	}

	public void setLine(Line line) {
		this.line = line;
	}
	
}
