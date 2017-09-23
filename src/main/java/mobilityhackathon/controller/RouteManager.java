package mobilityhackathon.controller;

import java.nio.charset.Charset;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

//import org.apache.tomcat.util.codec.binary.Base64;
import org.codehaus.jackson.annotate.JsonMethod;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import mobilityhackathon.model.Place;
import mobilityhackathon.model.PlaceWrapper;
import mobilityhackathon.model.RouteRequest;
import mobilityhackathon.model.RouteWrapper;
import mobilityhackathon.model.RouteWrapperWrapper;
import mobilityhackathon.model.Time;

public class RouteManager {
	
	public void getRoute(String start, String dest, String date, String time) {
		RouteRequest routeRequest = new RouteRequest(cnRequest(start), cnRequest(dest), new Time(date, time));
		ObjectMapper mapper = new ObjectMapper();
		mapper.setVisibility(PropertyAccessor.FIELD, Visibility.ANY);
		String jsonBody = "";
		try {
			jsonBody = mapper.writeValueAsString(routeRequest);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(jsonBody);
		routeRequest(jsonBody);
	}
	
	private void routeRequest(String body) {
		RestTemplate restTemplate = new RestTemplate();
		
		HttpEntity<String> request = new HttpEntity<String>(body, getHeader(body, "H4m$urgH13okt"));
    	ResponseEntity<RouteWrapperWrapper> response = restTemplate
    	  .exchange("https://api-hack.geofox.de/gti/public/getRoute", HttpMethod.POST, request, RouteWrapperWrapper.class);
    	  
    	RouteWrapper routeWrapper = response.getBody().getSchedules()[0];
    	System.out.println(routeWrapper.getScheduleElements()[0].getFrom().getDepTime().getTime());
	}
	
	private Place cnRequest(String station) {
		RestTemplate restTemplate = new RestTemplate();
		
		String body = "{\"version\":16,\"theName\":{\"name\":\""+station+"\",\"type\":\"STATION\"},\"maxList\":1,\"coordinateType\":\"EPSG_4326\" }";
		System.out.println(body);
		HttpEntity<String> request = new HttpEntity<String>(body, getHeader(body, "H4m$urgH13okt"));
    	ResponseEntity<PlaceWrapper> response = restTemplate
    	  .exchange("https://api-hack.geofox.de/gti/public/checkName", HttpMethod.POST, request, PlaceWrapper.class);
    	  
    	return response.getBody().getPlace();
	}
	
	private HttpHeaders getHeader(String msg, String pw) {

//    	SecretKeySpec key;
//    	byte[] bytes = null;
//		try {
//			key = new SecretKeySpec((pw).getBytes("UTF-8"), "HmacSHA1");
//			Mac mac = Mac.getInstance("HmacSHA1");
//	    	mac.init(key);
//
//	    	bytes = mac.doFinal(msg.getBytes("UTF-8"));
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		
//		String sha1Key = "";
//		if (bytes != null) {
//			sha1Key = new String(Base64.encodeBase64(bytes));
//		}
//		System.out.println(sha1Key);
		
		final Charset passwordEncoding = Charset.forName("UTF-8"); 
		final String algorithm = "HmacSHA1"; 
		byte[] key = pw.getBytes(passwordEncoding); 
		SecretKeySpec keySpec = new SecretKeySpec(key, algorithm); 
		Mac mac;
		byte[] signature = null;
		try {
			mac = Mac.getInstance(algorithm);
			mac.init(keySpec); 
			signature = mac.doFinal(msg.getBytes()); 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		String sha1Key = Base64.getEncoder().encodeToString(signature); 
		System.out.println(sha1Key);
		
		HttpHeaders header = new HttpHeaders();
		header.set("Accept", "application/json");
		header.set("Content-Type", "application/json");
    	//header.setContentType(MediaType.APPLICATION_JSON);
    	header.set("geofox-auth-user", "mobi-hack");
    	header.set("geofox-auth-signature", sha1Key);
    	header.set("geofox-auth-type", "HmacSHA1");
    	return header;
    }

}
