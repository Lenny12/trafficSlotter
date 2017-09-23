package mobilityhackathon.timeslotter;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import mobilityhackathon.model.EventScheduler;
import mobilityhackathon.model.LocalEvent;
import mobilityhackathon.model.Time;
import mobilityhackathon.util.Customer;
import mobilityhackathon.util.Generators;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

import mobilityhackathon.controller.RouteManager;
import mobilityhackathon.util.Customer;

@SpringBootApplication
@ComponentScan(basePackages = {"mobilityhackathon.controller"})
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
public class App {
    public static void main( String[] args ) {
    	SpringApplication.run(App.class, args);
		RouteManager routeManager = new RouteManager();
		routeManager.getRoute("Hammerbrook", "Harburg", "23.09.2017", "12:00");
		String result = "";
        EventScheduler es = new EventScheduler(new LocalEvent(new Time("28.09.2017", "13:20"),"Jungfernstieg","Helenefischer"));
        List<Customer> customers = Generators.generateCostumer(20,"Berliner Tor");
        for(Customer c : customers){
           result += es.getRecommendedTime(c)+"\n";
        }
        System.out.println(result);
    }
}
