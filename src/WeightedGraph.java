import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * A class representing a weighted, undirected graph.  It uses the adjacency list representation.
 */
public class WeightedGraph {

    /** The graph as an adjacency list */
    private Map<Integer, List<Adjacency>> graph;

    /** An internal class used to represent an adjacent vertex. */
    private static class Adjacency {
        /** The adjacent vertex */
        private int vertex;
        /** The weight of the edge */
        private int weight;

        /**
         * Construct an Adjacency
         * @param v adjacent vertex
         * @param w edge weight
         */
        public Adjacency(int v, int w) {
            vertex = v;
            weight = w;
        }

        public String toString(){
            return "(" + vertex + ", " + weight + ")";
        }
    }

    /**
     * Constructs a WeightedGraph from a file.
     * @param fileName the file name (path)
     * @throws IOException if there is an IOException caused by reading the file
     */
    public WeightedGraph(String fileName) throws IOException {
        Scanner scan = new Scanner(new File(fileName));
        graph = new HashMap<>();

        int n = scan.nextInt();
        scan.nextLine();
        for( int i = 0; i < n; i++ ) {
            String line = scan.nextLine();
            String[] parts = line.split("\\s+");
            List<Adjacency> verts = new LinkedList<>();
            for( int j = 0; j < parts.length; j++ ) {
                if( !parts[j].equals("-") ) {
                    int weight = Integer.parseInt(parts[j]);
                    verts.add(new Adjacency(j, weight));
                }
            }
            graph.put(i, verts);
        }
        scan.close();
    }

    /**
     * Execute Prim's MST algorithm on this Graph.  Uses the JDK's PriorityQueue.
     * @return a list of Edges in the MST
     */
    public List<Edge> runPrimsJdk() {
        // TODO: implement this method
        return null;
    }

    /**
     * Execute Prim's MST algorithm on this Graph.  Uses EdgePriorityQueue.
     * @return a list of Edges in the MST
     */
    public List<Edge> runPrims() {
        ArrayList<Edge> mst = new ArrayList<>();
        Set<Integer> vertices = graph.keySet();
        System.out.println("Graph: " + graph.toString());
        System.out.println("Vertices: " + vertices);
        EdgePriorityQueue epq = new EdgePriorityQueue();
        int arbitraryVertex = 0;
        //get all edges connected to that edge
        List<Adjacency> adjacencies = graph.get(arbitraryVertex);
        for (int i = 0; i < adjacencies.size(); i++) {
            Adjacency a = adjacencies.get(i);
            Edge e = new Edge(a.vertex, arbitraryVertex, a.weight);
            System.out.println("Added edge to EPQ: " + e);
            epq.add(e);
        }
        Edge firstEdge = epq.remove();
        mst.add(firstEdge);
        int verticesInMST = 1;
        for (int i = verticesInMST; i < vertices.size() - 1; i++) {
            System.out.println("i = " + i);
            Edge priorEdge = mst.get(i - 1);
            int v = priorEdge.getExternalVertex();
            System.out.println("Next vertice: " + v);
            adjacencies = graph.get(v);
            for (int j = 0; j < adjacencies.size() - 1; j++) {
                Adjacency a = adjacencies.get(j);
                Edge e = new Edge(a.vertex, arbitraryVertex, a.weight);
                if(true) {
                    System.out.println("Added edge to EPQ: " + e);
                    epq.decrease(e.getExternalVertex(), v, e.getWeight());
                    epq.add(e);
                }
            }
            mst.add(epq.remove());
        }
        System.out.println("MST: " + mst);
        System.out.println("EPQ: " + epq.toString());
        return null;
    }
}
