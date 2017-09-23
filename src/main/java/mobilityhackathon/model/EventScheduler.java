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
        if(currentSlot.isFull()) {
            Time nextTime =  rm.getRoute(start ,end, currentSlot.arrivalDate, addMinutes(currentSlot.arrivalTime)).getFrom().getDepTime();
            System.out.println("\n\n"+nextTime+"\n\n");
            currentSlot = new Slot(nextTime);
        }
        currentSlot.increment();
        System.out.println(currentSlot.arrivalDate+ " " +currentSlot.arrivalTime+"\n\n\n");
        Time t = rm.getRoute(start ,end, currentSlot.arrivalDate, currentSlot.arrivalTime).getFrom().getDepTime();
        return t.getDate()+" "+t.getTime();
    }
    private String addMinutes(String time){
        System.out.print(time);
        int hours = Integer.getInteger(""+time.charAt(0)+time.charAt(1));
        int minutes = Integer.getInteger(""+time.charAt(3)+time.charAt(4));

        System.out.println(""+hours+minutes);
        return null;
    }
}
