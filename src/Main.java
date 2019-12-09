//https://cs.plu.edu/courses/cs371/current/pa/pa04/pa04.html

public class Main {
    public static void main(String[] args){
        System.out.println("Beginning of Main.");
        EdgePriorityQueue epq = new EdgePriorityQueue();
        for (int i = 0; i < 10; i++) {
            Edge e = new Edge(1, 1, (int) Math.random() * 10);
            epq.add(e);
        }
        System.out.println("End of Main.");
    }
}
