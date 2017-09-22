package mobilityhackathon.model;

/**
 * Created by melvyn on 22.09.17.
 */
public class LocalEvent {
    public final String startTime;
    public final String location;
    public final String name;

    public LocalEvent(String startTime, String location, String name){
        this.startTime = startTime;
        this.location = location;
        this.name = name;
    }

}
