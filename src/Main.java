//https://cs.plu.edu/courses/cs371/current/pa/pa04/pa04.html

import java.util.ArrayList;

public class Main {
    public static void main(String[] args){
        System.out.println("Beginning of Main.");
        ArrayList<Edge> edges = new ArrayList<>();
        Edge e = new Edge(1, 1, 1);
        edges.add(e);
        Edge tempEdge = edges.get(0);
        tempEdge.setInternalVertex(2);
        System.out.println(edges.get(0));
        System.out.println("End of Main.");
    }
}
