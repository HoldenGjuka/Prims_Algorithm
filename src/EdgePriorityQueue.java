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
                locations.put(e1.getExternalVertex(), parentIndex);
                locations.put(e2.getExternalVertex(), index);
                filterUp(parentIndex);
            }
        }
    }

    /**
     * Retrieves the index of an edge's parent in the heap
     * @param childIndex - Index of the child Edge
     * @return - Index of the parent, -1 if the childIndex is the root
     */
    private int getParentIndex(int childIndex){
        if(childIndex == 1){ return -1; }
        return (int) (Math.floor(childIndex) / 2);
    }

    private void filterDown(int parentIndex){
        Edge parent = heap.get(parentIndex);
        int[] childrenIndices = getChildrenIndices(parentIndex);
        Edge leftChild;
        Edge rightChild;
        Edge smallestChild;
        if(childrenIndices[0] != -1 && childrenIndices[1] != -1){
            leftChild = heap.get(childrenIndices[0]);
            rightChild = heap.get(childrenIndices[1]);
            if(leftChild.getWeight() <= rightChild.getWeight() && leftChild.getWeight() < parent.getWeight()){
                Collections.swap(heap, childrenIndices[0], parentIndex);
                locations.put(parent.getExternalVertex(), childrenIndices[0]);
                locations.put(leftChild.getExternalVertex(), parentIndex);
                filterDown(childrenIndices[0]);
            } else if(rightChild.getWeight() < parent.getWeight()){
                Collections.swap(heap, childrenIndices[1], parentIndex);
                locations.put(parent.getExternalVertex(), childrenIndices[1]);
                locations.put(rightChild.getExternalVertex(), parentIndex);
                filterDown(childrenIndices[1]);
            }
        } else if(childrenIndices[0] != -1){
            leftChild = heap.get(childrenIndices[0]);
            if(leftChild.getWeight() < parent.getWeight()){
                Collections.swap(heap, childrenIndices[0], parentIndex);
                locations.put(parent.getExternalVertex(), childrenIndices[0]);
                locations.put(leftChild.getExternalVertex(), parentIndex);
                filterDown(childrenIndices[0]);
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
        Edge smallestEdge;
        if(heap.size() != 0) {
            smallestEdge = heap.get(0);
            //heap deletion algorithm
            //1. swap root and last element in the array
            Collections.swap(heap, 0, heap.size() - 1);
            locations.put(heap.get(0).getExternalVertex(), 0);
            //2. Delete the last element in the array, which used to be root
            locations.remove(heap.get(heap.size() - 1).getExternalVertex());
            heap.remove(heap.size() - 1);
            locations.remove(smallestEdge.getExternalVertex());
            //3. Filter down the new root so it's in the right spot
            if(heap.size() != 0){
                filterDown(0);
            }
            return smallestEdge;
        } else throw new NoSuchElementException();
    }

    /**
     * Retrieves the indices of the two children of a an edge in the heap.
     * @param parentIndex - Index of the parent node
     * @return - An array of 2 ints, where the first is the index of the left child and the second is the index of the
     * right child. An indice will be -1 if there is no child in that spot.
     */
    public int[] getChildrenIndices(int parentIndex){
        int[] childrenIndices = {-1, -1};
        int leftChildIndex = 2 * parentIndex;
        int rightChildIndex = leftChildIndex + 1;
        if(leftChildIndex <= heap.size() - 1){
            childrenIndices[0] = leftChildIndex;
            if(rightChildIndex <= heap.size() - 1){
                childrenIndices[1] = rightChildIndex;
            }
        }
        return childrenIndices;
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

