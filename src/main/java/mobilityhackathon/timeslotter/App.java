package mobilityhackathon.timeslotter;

import mobilityhackathon.model.EventScheduler;
import mobilityhackathon.model.LocalEvent;
import mobilityhackathon.model.Time;
import mobilityhackathon.util.Customer;
import mobilityhackathon.util.Generators;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.util.List;

@SpringBootApplication
@ComponentScan(basePackages = {"mobilityhackathon.controller"})
public class App 
{
    public static void main( String[] args )
    {
        String result = "";
        EventScheduler es = new EventScheduler(new LocalEvent(new Time("28.09.2017", "13:20"),"Jungfernstieg","Helenefischer"));
        List<Customer> customers = Generators.generateCostumer(20,"Berliner Tor");
        for(Customer c : customers){
           result += es.getRecommendedTime(c)+"\n";
        }
        System.out.println(result);



    }
}
