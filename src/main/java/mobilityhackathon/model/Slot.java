package mobilityhackathon.model;

/**
 * Created by melvyn on 22.09.17.
 */
public class Slot {
    private int counter;
    private final static int MAX_COUNTER = 10;
    String arrivalTime ="";

    public Slot(String arrivalTime){
        this.arrivalTime = arrivalTime;
        counter = 0;
    }

    public boolean isFull(){
        return counter >= MAX_COUNTER;
    }

    public void increment(){
        counter++;
    }

}
