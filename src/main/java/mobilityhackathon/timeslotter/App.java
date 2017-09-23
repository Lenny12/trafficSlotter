package mobilityhackathon.timeslotter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
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
		System.out.println(new Customer("Langer Kamp 8"));
		RouteManager routeManager = new RouteManager();
		routeManager.getRoute("Hammerbrook", "Harburg", "23.09.2017", "12:00");
    }
    
}
