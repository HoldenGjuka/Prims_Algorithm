import java.util.ArrayList;
import java.util.HashMap;
import java.util.NoSuchElementException;

public class EdgePriorityQueue {

    private ArrayList<Edge> heap;
    private HashMap<Integer, Integer> locations;

    public EdgePriorityQueue(ArrayList<Edge> heap) {
        this.heap = heap;
        locations = new HashMap<>();
    }

    public int size(){ return heap.size(); }

    public boolean isEmpty(){ return (size() == 0); }

    public void add(Edge e){
        //add an edge to the heap, making sure to update the hashmap
    }

    /**
     * Removes the Edge object with the minimum weight using the standard heap deletion...
     * algorithm, and then updates the locations HashMap.
     * @return - The minimum edge object
     * @throws NoSuchElementException - If the queue is empty (there are no edges).
     */
    public Edge remove(){
        Edge min;
        if(heap.size() != 0) {
            min = heap.get(0);
            //heap deletion algorithm
            //1. swap root and last element in the array
            //2. Delete the last element in the array, which used to be root
            //3. Filter down the new root so it's in the right spot
            locations.remove(min);
            return min;
        } else throw new NoSuchElementException();
    }

    public boolean decrease(int extVert, int intVert, int weight){
        //complicated method?
        return false;
    }
}

