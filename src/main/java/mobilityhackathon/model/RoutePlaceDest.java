package mobilityhackathon.model;

public class RoutePlaceDest extends Place {
	
	private Time arrTime;
	private Line line;
	
	public RoutePlaceDest() {
        super();
    }
	
	public RoutePlaceDest(String name, String city, String combinedName, String id, String type, Coordinate coordinate, String serviceTypes[], Time arrTime, Line line) {
		super(name, city, combinedName, id, type, coordinate, serviceTypes);
		this.setArrTime(arrTime);
		this.setLine(line);
	}

	public Time getArrTime() {
		return arrTime;
	}

	public void setArrTime(Time arrTime) {
		this.arrTime = arrTime;
	}

	public Line getLine() {
		return line;
	}

	public void setLine(Line line) {
		this.line = line;
	}

}
