import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;

public class EdgePriorityQueueTest {

    private EdgePriorityQueue epq1; //empty
    private EdgePriorityQueue epq2; //contains edges
    private Edge e;

    @Before
    public void setup(){
        ArrayList<Edge> edges = new ArrayList<>();
        epq1 = new EdgePriorityQueue();
        Edge e = new Edge(1, 1, -1);
    }

    @Test
    public void testIsEmpty01(){
        Assert.assertTrue(epq1.isEmpty());
    }

    @Test
    public void testAdd01(){
        for(int i = 1; i <= 20; i++){
            Edge newEdge = new Edge(i, i, i);
            epq1.add(newEdge);
        }
        System.out.println(epq1.toString());
    }

    @Test
    public void testAdd02(){  //adds a random set of edges to the edgelist, tests if the heap handles them properly
        ArrayList<Edge> edges = new ArrayList<>();
        for(int i = 0; i <= 20; i++){
            Edge newEdge = new Edge(i, i, i);
            edges.add(newEdge);
        }
        int[] indices = {6, 1, 8, 11, 0, 9, 2, 20, 5, 14, 3, 7, 4, 10, 17, 18, 19, 16, 15, 12, 13};
        for (int j = 0; j <= indices.length - 1; j++) {
            epq1.add(edges.get(indices[j]));
        }
        String example = "0(0, 0) 1(1, 1) 2(2, 2) 5(5, 5) 3(3, 3) 4(4, 4) 8(8, 8) 18(18, 18) 11(11, 11) 12(12, 12) 6(6, 6) " +
                "9(9, 9) 7(7, 7) 10(10, 10) 17(17, 17) 20(20, 20) 19(19, 19) 16(16, 16) 15(15, 15) 14(14, 14) 13(13, 13) ";
        Assert.assertEquals(example, epq1.toString());
    }

    @Test
    public void testAdd03(){

    }

    @Test
    public void testRemove01(){

    }

    @Test
    public void testRemove02(){

    }

    @Test
    public void testRemove03(){

    }

    @Test
    public void testDecrease01(){

    }

    @Test
    public void testDecrease02(){

    }

    @Test
    public void testDecrease03(){

    }
}