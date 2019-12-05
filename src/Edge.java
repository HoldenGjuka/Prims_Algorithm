/**
 * A class representing a (potential) MST edge.  Intended for use in
 * the priority queue during execution of Prim's algorithm.  The convention
 * used here is that v1 is the vertex that is external to the MST (so far) and
 * v2 is the vertex within the MST.
 *
 * Equality is determined by all three fields, but comparison is only by weight.
 * This is so that instances can be used with the Java PriorityQueue class.
 */
public class Edge implements Comparable<Edge> {

    /** The external vertex */
    private int v1;
    /** The internal vertex */
    private int v2;
    /** The edge weight */
    private int weight;

    /**
     * Constructs an edge object with only the external vertex specified.
     * The internal vertex is set to -1 (meaning unknown) and the weight is
     * set to Integer.MAX_VALUE.
     *
     * @param v1 the external vertex
     */
    public Edge( int v1 ) {
        this.v1 = v1;
        this.v2 = -1;
        this.weight = Integer.MAX_VALUE;
    }

    /**
     * Constructs an Edge with the given values.
     * @param v1 the external vertex
     * @param v2 the internal vertex (-1 for unknown)
     * @param w the edge weight
     */
    public Edge( int v1, int v2, int w ) {
        this.v1 = v1;
        this.v2 = v2;
        weight = w;
    }

    /**
     * @return the weight of this edge
     */
    public int getWeight() { return weight; }

    /**
     * @return the external vertex
     */
    public int getExternalVertex() { return v1; }

    /**
     * Compares this Edge with another based on edge weight only.
     * @param other another Edge object
     * @return the result of the comparison
     */
    @Override
    public int compareTo( Edge other ) {
        if( this.weight < other.weight ) return -1;
        else if(this.weight > other.weight) return 1;
        return 0;
    }

    /**
     * Compares this Edge with another object.
     * @param other another Object
     * @return true if other is an Edge instance and all fields are the same.
     */
    @Override
    public boolean equals(Object other) {
        if( this == other ) return true;
        if( this.getClass() == other.getClass() ) {
            Edge e = (Edge) other;
            return e.v1 == this.v1 && e.v2 == this.v2 && this.weight == e.weight;
        }
        return false;
    }

    /**
     * @return a String representation of this Edge in the same format used by
     * the author of our text on page 321.
     */
    @Override
    public String toString() {
        return String.format("%d(%d, %d)", v1, v2, weight);
    }

    /**
     * Sets the weight of this Edge
     * @param newWeight the new weight
     */
    public void setWeight(int newWeight) {
        weight = newWeight;
    }

    /**
     * Sets the internal vertex for this Edge
     * @param v the internal vertex
     */
    public void setInternalVertex(int v) {
        this.v2 = v;
    }

}
