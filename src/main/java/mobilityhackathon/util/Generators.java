package mobilityhackathon.util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by melvyn on 22.09.17.
 */
public class Generators {
    static String randomLine(String path){
        try(BufferedReader br = new BufferedReader(new FileReader(path))){
            String line = br.readLine();
            List<String> result = new ArrayList<String>();
            while(line!= null){
                line = br.readLine();
                result.add(line);
            }
            return result.get(new Random().nextInt(result.size()));

        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "nein";
    }

    static String generateFirstname(){
        return randomLine("./src/recources/firstnames.txt");
    }

    static String generateLastname(){
        return randomLine("./src/recources/lastnames.txt");
    }
    static String generateStreet(){
        return "Johann-Maier-Strasse 55";
    }
    public static List<Customer> generateCostumer(int number){
        List<Customer> result = new ArrayList<>();

        for(int i = 0; i < number; i++){
            result.add(new Customer(generateStreet()));
        }

        return  result;
    }

}