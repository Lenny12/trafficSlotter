package mobilityhackathon.model;

public class Line {
	
	private String name;
	private String direction;
	
	public Line(String name, String direction) {
		this.setName(name);
		this.setDirection(direction);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

}
