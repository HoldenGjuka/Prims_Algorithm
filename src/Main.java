//https://cs.plu.edu/courses/cs371/current/pa/pa04/pa04.html

import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args){
        WeightedGraph wg = null;
        try{
            wg = new WeightedGraph("small_5.txt");
        } catch (IOException e) {
            System.out.println("IOException in main.");
        }
    }
}
