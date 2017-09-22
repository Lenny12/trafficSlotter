package mobilityhackathon.timeslotter;

import mobilityhackathon.util.Generators;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
@SpringBootApplication
@ComponentScan(basePackages = {"mobilityhackathon.controller"})
public class App 
{
    public static void main( String[] args )
    {

		System.out.println(Generators.generateCostumer(20).get(19));
    }
}
