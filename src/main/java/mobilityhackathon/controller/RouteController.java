package mobilityhackathon.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import mobilityhackathon.model.Event;
import mobilityhackathon.model.Time;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class RouteController {
	
	@GetMapping("/eventList")
    public Event[] greeting() {
        return getTestEventList();
    }
	
	@PostMapping("/getRoute")
	@ResponseBody
    public String saveFeatures(@RequestBody String event) {
		//System.out.println(features.getType());
		System.out.println(event);
		return "[{\"color\":\"red\",\"startTime\":\"18:20\",\"arrTime\":\"18:30\",\"start\":\"Jungfernstieg\",\"dest\":\"Berliner Tor\"}"+
				",{\"color\":\"green\",\"startTime\":\"18:10\",\"arrTime\":\"18:20\",\"start\":\"Jungfernstieg\",\"dest\":\"Berliner Tor\"}]";
    }
	
	private Event[] getTestEventList() { 
		List<Event> eventList = new ArrayList<Event>();
		eventList.add(new Event("HeleneFischerHamburg2017", "Helene Fischer 2017", "Berliner Tor", new Time("24.09.2017", "18:00")));
		eventList.add(new Event("FernsehgartenHamburg2017", "Fernsehgarten 2017", "Hauptbahnhof", new Time("24.09.2017", "19:00")));
		eventList.add(new Event("Show123Hamburg2017", "Show 2017", "Berliner Tor", new Time("25.09.2017", "18:00")));
		eventList.add(new Event("EventHamburg2017", "Event 2017", "Berliner Tor", new Time("25.09.2017", "19:00")));
		eventList.add(new Event("MobilityHackathonHamburg2017", "Mobility Hackathon 2017", "Barmbek", new Time("25.09.2017", "19:00")));
		return eventList.toArray(new Event[eventList.size()]);
	}

}
