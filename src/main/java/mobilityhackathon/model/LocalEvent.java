package mobilityhackathon.model;

import javafx.util.Pair;

/**
 * Created by melvyn on 22.09.17.
 */
public class LocalEvent {
    public final String startTime;
    public final String startDate;
    public final String location;
    public final String name;


    public LocalEvent(String startDate, String startTime, String location, String name){
        this.startTime = startTime;
        this.startDate = startDate;
        this.location = location;
        this.name = name;
    }
    public LocalEvent(Time t, String location, String name){
       this(t.getDate(), t.getTime(), location, name);
    }
    public Pair<String, String> getDateTime(){
        return new Pair<String, String>(startDate,startTime);
    }

}
