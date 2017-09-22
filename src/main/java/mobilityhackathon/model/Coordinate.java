package mobilityhackathon.model;

public class Coordinate {

	private float x;
	private float y;

	public Coordinate() {
        super();
    }
	
	public Coordinate(float x, float y) {
		this.setX(x);
		this.setY(y);
	}

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

}
