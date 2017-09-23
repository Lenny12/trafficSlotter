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
import mobilityhackathon.model.EventScheduler;
import mobilityhackathon.model.LocalEvent;
import mobilityhackathon.model.Time;
import mobilityhackathon.util.Customer;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class RouteController {
	
	private static final EventManager eventManager = new EventManager();
	
	@GetMapping("/eventList")
    public LocalEvent[] greeting() {
        return eventManager.getTestEventList();
    }
	
	@PostMapping("/getRoute")
	@ResponseBody
    public String getRoute(@RequestBody String event) {
		//System.out.println(features.getType());
		System.out.println(event);
		String[] s = event.split(",");
		System.out.println(s[1]);
		EventScheduler scheduler = eventManager.getEventScheduler(s[1]);
		return scheduler.getRecommendedTime(new Customer(s[0]));
    }

}
