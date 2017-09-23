package mobilityhackathon.model;

import java.time.LocalTime;

import mobilityhackathon.controller.RouteManager;
import mobilityhackathon.util.Customer;

/**
 * Created by melvyn on 22.09.17.
 */
public class EventScheduler {
    LocalEvent e;
    RouteManager rm;
    Slot currentSlot;

    public EventScheduler(LocalEvent e){
        this.e = e;
        rm = new RouteManager();
        currentSlot = new Slot(e.startDate, e.startTime);

    }
    public String getRecommendedTime(Customer customer){
        String start = customer.street+", "+ customer.city;
        String end = e.location;
        if(currentSlot.isFull()) {
            Time nextTime =  rm.getRoute(start ,end, currentSlot.arrivalDate, subMinutes(currentSlot.arrivalTime)).getFrom().getDepTime();
            System.out.println("\n\n"+nextTime+"\n\n");
            currentSlot = new Slot(nextTime);
        }
        currentSlot.increment();
        System.out.println(currentSlot.arrivalDate+ " " +currentSlot.arrivalTime+"\n\n\n");
        Time t = rm.getRoute(start ,end, currentSlot.arrivalDate, currentSlot.arrivalTime).getFrom().getDepTime();
        return t.getDate()+" "+t.getTime();
    }
    private String subMinutes(String time){
        System.out.print(time);
        LocalTime t = LocalTime.parse(time);
        t.minusMinutes(10);
        String newTime = t.toString();
        return newTime;
    }
}
