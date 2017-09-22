package mobilityhackathon.timeslotter;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import mobilityhackathon.controller.RouteManager;
import mobilityhackathon.model.RouteRequest;

import mobilityhackathon.util.Customer;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

//@SpringBootApplication
//@ComponentScan(basePackages = {"mobilityhackathon.controller"})
public class App {
    public static void main( String[] args ) {
		System.out.println(new Customer("Langer Kamp 8"));
		RouteManager routeManager = new RouteManager();
		routeManager.getRoute("Hammerbrook", "Harburg", "23.09.2017", "12:00");
    }
    
}
