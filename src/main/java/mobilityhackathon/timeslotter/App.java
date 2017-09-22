package mobilityhackathon.timeslotter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpEntity;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@ComponentScan(basePackages = {"mobilityhackathon.controller"})
public class App 
{
    public static void main( String[] args )
    {
    	SpringApplication.run(App.class, args);
    	
    	RestTemplate restTemplate = new RestTemplate();
    	HttpEntity<Foo> request = new HttpEntity<>(new Foo("bar"));
    	ResponseEntity<Foo> response = restTemplate
    	  .exchange(fooResourceUrl, HttpMethod.POST, request, Foo.class);
    	  
    	assertThat(response.getStatusCode(), is(HttpStatus.CREATED));
    	  
    	Foo foo = response.getBody();
    }
}
