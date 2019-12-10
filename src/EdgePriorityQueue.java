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
        filterUp(insertionIndex);
    }

    private void filterUp(int index){
        Edge e1 = heap.get(index);
        if(getParentIndex(index) != -1){
            int parentIndex = getParentIndex(index);
            Edge e2 = heap.get(parentIndex);
            if(e1.getWeight() < e2.getWeight()){
                Collections.swap(heap, index, parentIndex);
                filterUp(parentIndex);
            }
        }
    }

    /**
     * Retrieves the index of an edge's parent in the heap
     * @param childIndex - Index of the child Edge
     * @return - Index of the parent, -1 if the childIndex is the root
     */
    public int getParentIndex(int childIndex){
        if(childIndex == 1){ return -1; }
        return (int) (Math.floor(childIndex) / 2);
    }

    private void filterDown(int index){
        Edge e1 = heap.get(index);
        if(getParentIndex(index) != -1){
            int parentIndex = getParentIndex(index);
            Edge e2 = heap.get(parentIndex);
            if(e1.getWeight() < e2.getWeight()){
                Collections.swap(heap, index, parentIndex);
                filterUp(parentIndex);
            }
        }
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

    /**
     * Retrieves the indices of the two children of a an edge in the heap.
     * @param parentIndex - Index of the parent node
     * @return - An array of 2 ints, where the first is the index of the left child and the second is the index of the
     * right child. An indice will be -1 if there is no child in that spot.
     */
    public int[] getChildrenIndices(int parentIndex){
        int[] children = {-1, -1};

        return children;
    }

    public boolean decrease(int extVert, int intVert, int weight){
        //complicated method?
        return false;
    }

    public String toString(){
        String output = "";
        for (int i = 1; i < heap.size(); i++) {
            output += heap.get(i) + " ";
        }
        return output;
    }
}

