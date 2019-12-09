import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.NoSuchElementException;

public class EdgePriorityQueue {

    private ArrayList<Edge> heap;
    private HashMap<Integer, Integer> locations;

    public EdgePriorityQueue(){
        heap = new ArrayList<>();
        Edge indexZero = new Edge(-1, -1, -1);
        heap.add(indexZero);
        locations = new HashMap<>();
    }

    public int size(){ return heap.size(); }

    public boolean isEmpty(){ return (size() == 0); }

    public void add(Edge e){
        heap.add(e);
        int insertionIndex = heap.size() - 1;
        locations.put(e.getExternalVertex(), insertionIndex);
    }

    private void filterUp(){

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
            Collections.swap(heap, 0, heap.size() - 1);
            //2. Delete the last element in the array, which used to be root
            heap.remove(heap.size() - 1);
            //update HashMap
            locations.remove(min.getExternalVertex());
            //3. Filter down the new root so it's in the right spot
            if(heap.size() != 0){

            }
            locations.remove(min);
            return min;
        } else throw new NoSuchElementException();
    }

    public boolean decrease(int extVert, int intVert, int weight){
        //complicated method?
        return false;
    }

    public int getParentIndex(int childIndex){
        return (int) (Math.floor(childIndex) / 2);
    }

    public String toString(){
        String output = "";
        for (int i = 1; i < heap.size(); i++) {
            output += heap.get(i) + " ";
        }
        return output;
    }
}

