package mobilityhackathon.model;

/**
 * Created by melvyn on 22.09.17.
 */
public class Slot {
    private int counter;
    private final static int MAX_COUNTER = 10;
    String arrivalTime ="";
    public String arrivalDate;

    public Slot(String arrivalTime, String arrivalDate){
        this.arrivalTime = arrivalTime;
        this.arrivalDate = arrivalDate;
        counter = 0;
    }

    public boolean isFull(){
        return counter >= MAX_COUNTER;
    }

    public void increment(){
        counter++;
    }

}
