//https://cs.plu.edu/courses/cs371/current/pa/pa04/pa04.html

import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args){
        System.out.println("Beginning of Main.");
        WeightedGraph wg = null;
        try{
            wg = new WeightedGraph("small_5.txt");
            System.out.println("wg created");
        } catch (IOException e) {
            System.out.println("IOException in main.");
        }
        wg.runPrims();
        System.out.println("End of Main.");
    }
}
