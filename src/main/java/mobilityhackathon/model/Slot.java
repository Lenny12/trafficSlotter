package mobilityhackathon.model;

import javafx.util.Pair;

/**
 * Created by melvyn on 22.09.17.
 */
public class Slot {
    private int counter;
    private final static int MAX_COUNTER = 2;
    private String startTime;
    private String destTime;
    String arrivalTime ="";
    public String arrivalDate;

    public Slot(String arrivalDate, String arrivalTime){
        this.arrivalTime = arrivalTime;
        this.arrivalDate = arrivalDate;
        counter = 0;
    }
    public Slot(Pair<String, String> dateTime){
        arrivalTime = dateTime.getValue();
        arrivalDate = dateTime.getKey();
    }
    public Slot(Time time){
        arrivalTime = time.getTime();
        arrivalDate = time.getDate();
    }

    public boolean isFull(){
        return counter >= MAX_COUNTER;
    }

    public void increment(){
        counter++;
    }

    public Pair<String, String> getDateTime(){
        return new Pair<String, String>(arrivalDate,arrivalTime);
    }
    
    public String getArrTime() {
    	return arrivalTime;
    }
	public String getDestTime() {
		return destTime;
	}
	public void setDestTime(String destTime) {
		this.destTime = destTime;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

}
