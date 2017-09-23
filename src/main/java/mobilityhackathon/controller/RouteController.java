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
import mobilityhackathon.model.LocalEvent;
import mobilityhackathon.model.Time;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class RouteController {
	
	@GetMapping("/eventList")
    public LocalEvent[] greeting() {
        return getTestEventList();
    }
	
	@PostMapping("/getRoute")
	@ResponseBody
    public String getRoute(@RequestBody String event) {
		//System.out.println(features.getType());
		System.out.println(event);
		return "[{\"color\":\"red\",\"startTime\":\"18:20\",\"arrTime\":\"18:30\",\"start\":\"Jungfernstieg\",\"dest\":\"Berliner Tor\"}"+
				",{\"color\":\"green\",\"startTime\":\"18:10\",\"arrTime\":\"18:20\",\"start\":\"Jungfernstieg\",\"dest\":\"Berliner Tor\"}]";
    }

}
