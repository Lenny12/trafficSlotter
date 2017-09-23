package mobilityhackathon.controller;

import java.util.ArrayList;
import java.util.List;

import mobilityhackathon.model.EventScheduler;
import mobilityhackathon.model.LocalEvent;

public class EventManager {
	
	private List<LocalEvent> eventList;
	private List<EventScheduler> esList;
	
	public EventManager() {
		eventList = new ArrayList<LocalEvent>();
		eventList.add(new LocalEvent("24.09.2017", "18:00", "Berliner Tor", "Helene Fischer 2017"));
		eventList.add(new LocalEvent("24.09.2017", "19:00", "Hauptbahnhof", "Fernsehgarten 2017"));
		eventList.add(new LocalEvent("25.09.2017", "18:00", "Berliner Tor", "Show 2017"));
		eventList.add(new LocalEvent("25.09.2017", "19:00", "Berliner Tor", "Event 2017"));
		eventList.add(new LocalEvent("25.09.2017", "19:00", "Barmbek", "Mobility Hackathon 2017"));
		
		esList = new ArrayList<EventScheduler>();
		for (LocalEvent event : eventList) {
			esList.add(new EventScheduler(event));
		}
	}
	
	public EventScheduler getEventScheduler(String event) {
		for (EventScheduler scheduler : esList) {
			if (scheduler.getEvent().equals(event)) {
				return scheduler;
			}
		}
		return null;
	}
	
	public LocalEvent[] getTestEventList() { 
		return eventList.toArray(new LocalEvent[eventList.size()]);
	}

}
