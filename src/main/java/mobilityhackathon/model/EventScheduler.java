package mobilityhackathon.model;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import mobilityhackathon.controller.RouteManager;
import mobilityhackathon.util.Customer;
import mobilityhackathon.util.JsonUtils;

/**
 * Created by melvyn on 22.09.17.
 */
public class EventScheduler {
    LocalEvent e;
    RouteManager rm;
    JsonUtils jsonUtils;
    Slot currentSlot;
    List<Slot> slotHistory = new ArrayList<Slot>();

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
            slotHistory.add(currentSlot);
            currentSlot = new Slot(nextTime);
        }
        currentSlot.increment();
        System.out.println(currentSlot.arrivalDate+ " " +currentSlot.arrivalTime+"\n\n\n");
        Route route = rm.getRoute(start ,end, currentSlot.arrivalDate, currentSlot.arrivalTime);
        currentSlot.setDestTime(route.getFrom().getDepTime().getTime());
        currentSlot.setStartTime(route.getTo().getArrTime().getTime());
        return jsonUtils.createRecommendations(start, end, slotHistory, currentSlot.getDestTime(), currentSlot.getStartTime());
    }
    private String subMinutes(String time){
        LocalTime t = LocalTime.parse(time);
        t.minusMinutes(10);
        String newTime = t.toString();
        return newTime;
    }
}
