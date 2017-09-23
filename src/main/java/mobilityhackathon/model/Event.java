package mobilityhackathon.model;

public class Event {
	
	private String id;
	private String name;
	private String adress;
	private Time startTime;
	
	public Event(String id, String name, String adress, Time startTime) {
		this.setId(id);
		this.setName(name);
		this.setAdress(adress);
		this.setStartTime(startTime);
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public Time getStartTime() {
		return startTime;
	}

	public void setStartTime(Time startTime) {
		this.startTime = startTime;
	}

}
