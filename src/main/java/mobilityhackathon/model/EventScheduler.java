package mobilityhackathon.model;

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
        if(currentSlot.isFull())
            currentSlot = new Slot(rm.nextArrivalDateTime(currentSlot.getDateTime()));

        currentSlot.increment();
        System.out.println(currentSlot.arrivalDate+ " " +currentSlot.arrivalTime);
        Time t = rm.getRoute(start ,end, currentSlot.arrivalDate, currentSlot.arrivalTime).getFrom().getDepTime();
        return t.getDate()+" "+t.getTime();
    }
}
