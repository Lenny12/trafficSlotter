package mobilityhackathon.util;

import java.util.List;

import mobilityhackathon.model.Slot;

public class JsonUtils {
	
	public String createRecommendations(String start, String dest, List<Slot> oldRecs, String arrTime, String startTime) {
		String json = "[{\"color\":\"green\",\"startTime\":\""+startTime+"\",\"arrTime\":\""+arrTime+"\",\"start\":\""+start+"\",\"dest\":\""+dest+"\"}";
		for (Slot slot : oldRecs) {
			json += ",{\"color\":\"red\",\"startTime\":\""+slot.getDestTime()+"\",\"arrTime\":\""+slot.getArrTime()+"\",\"start\":\""+start+"\",\"dest\":\""+dest+"\"}";
		}
		json += "]";
		return json;
	}

}
