package mobilityhackathon.util;

import java.util.Random;

/**
 * Created by melvyn on 22.09.17.
 */
public class Customer {
    public final String firstname;
    public final String lastname;
    public final int age;
    public final String street;
    public final String city;

    public Customer(String firstname, String lastname, int age, String street, String city){
        this.firstname = firstname;
        this.lastname = lastname;
        this.age = age;
        this.city = city;
        this.street = street;
    }
    public Customer(String street, String city){
        this(Generators.generateFirstname(),Generators.generateLastname(),new Random().nextInt(120)+16,street,city);
    }

    public Customer(String street){
        this(street, "Hamburg");
    }

    public String toString(){
        return "Customer("+this.firstname+" "+this.lastname+")";
    }
}
