import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class EdgePriorityQueueTest {

    private EdgePriorityQueue epq; //empty

    @Before
    public void setup(){
        ArrayList<Edge> edges = new ArrayList<>();
        epq = new EdgePriorityQueue();
    }

    @Test
    public void testIsEmpty01(){
        Assert.assertTrue(epq.isEmpty());
    }

    @Test
    public void testIsEmpty02(){
        Edge e = new Edge(1, 1, 1);
        epq.add(e);
        Assert.assertFalse(epq.isEmpty());
    }

    @Test
    public void testAdd01(){
        for(int i = 1; i <= 20; i++){
            Edge newEdge = new Edge(i, i, i);
            epq.add(newEdge);
        }
        System.out.println(epq.toString());
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
            epq.add(edges.get(indices[j]));
        }
        String example = "0(0, 0) 1(1, 1) 2(2, 2) 5(5, 5) 3(3, 3) 4(4, 4) 8(8, 8) 18(18, 18) 11(11, 11) 12(12, 12) 6(6, 6) " +
                "9(9, 9) 7(7, 7) 10(10, 10) 17(17, 17) 20(20, 20) 19(19, 19) 16(16, 16) 15(15, 15) 14(14, 14) 13(13, 13) ";
        Assert.assertEquals(example, epq.toString());
    }

    @Test
    public void testRemove01(){
        ArrayList<Edge> edges = new ArrayList<>();
        for(int i = 0; i <= 20; i++){
            Edge newEdge = new Edge(i, i, i);
            edges.add(newEdge);
        }
        int[] indices = {6, 1, 8, 11, 0, 9, 2, 20, 5, 14, 3, 7, 4, 10, 17, 18, 19, 16, 15, 12, 13};
        for (int j = 0; j <= indices.length - 1; j++) {
            epq.add(edges.get(indices[j]));
        }
        epq.remove();
        String example = "1(1, 1) 3(3, 3) 2(2, 2) 5(5, 5) 6(6, 6) 4(4, 4) 8(8, 8) 18(18, 18) 11(11, 11) 12(12, 12)" +
                " 13(13, 13) 9(9, 9) 7(7, 7) 10(10, 10) 17(17, 17) 20(20, 20) 19(19, 19) 16(16, 16) 15(15, 15) 14(14, 14) ";
        Assert.assertEquals(example, epq.toString());
    }

    @Test
    public void testRemove02(){
        ArrayList<Edge> edges = new ArrayList<>();
        for(int i = 0; i <= 20; i++){
            Edge newEdge = new Edge(i, i, i);
            edges.add(newEdge);
        }
        int[] indices = {6, 1, 8, 11, 0, 9, 2, 20, 5, 14, 3, 7, 4, 10, 17, 18, 19, 16, 15, 12, 13};
        for (int j = 0; j <= indices.length - 1; j++) {
            epq.add(edges.get(indices[j]));
        }
        epq.remove();
        epq.remove();
        String example = "2(2, 2) 3(3, 3) 4(4, 4) 5(5, 5) 6(6, 6) 7(7, 7) 8(8, 8) 18(18, 18) 11(11, 11) 12(12, 12)" +
                " 13(13, 13) 9(9, 9) 14(14, 14) 10(10, 10) 17(17, 17) 20(20, 20) 19(19, 19) 16(16, 16) 15(15, 15) ";
        System.out.println(epq.toString());
        Assert.assertEquals(example, epq.toString());
    }

    @Test
    public void testRemove03(){
        ArrayList<Edge> edges = new ArrayList<>();
        for(int i = 0; i <= 20; i++){
            Edge newEdge = new Edge(i, i, i);
            edges.add(newEdge);
        }
        int[] indices = {6, 1, 8, 11, 0, 9, 2, 20, 5, 14, 3, 7, 4, 10, 17, 18, 19, 16, 15, 12, 13};
        for (int j = 0; j <= indices.length - 1; j++) {
            epq.add(edges.get(indices[j]));
        }
        epq.remove();
        epq.remove();
        epq.remove();
        String example = "3(3, 3) 5(5, 5) 4(4, 4) 11(11, 11) 6(6, 6) 7(7, 7) 8(8, 8) 18(18, 18) 15(15, 15) 12(12, 12)" +
                " 13(13, 13) 9(9, 9) 14(14, 14) 10(10, 10) 17(17, 17) 20(20, 20) 19(19, 19) 16(16, 16) ";
        Assert.assertEquals(example, epq.toString());
    }

    @Test
    public void testDecrease01(){
        ArrayList<Edge> edges = new ArrayList<>();
        for(int i = 0; i <= 20; i++){
            Edge newEdge = new Edge(i, i, i);
            edges.add(newEdge);
        }
        epq.add(edges.get(3));
        epq.decrease(3, 3, 1);
        String example = "3(3, 1) ";
        Assert.assertEquals(example, epq.toString());
    }

    @Test
    public void testDecrease02(){
        ArrayList<Edge> edges = new ArrayList<>();
        for(int i = 0; i <= 20; i++){
            Edge newEdge = new Edge(i, i, i);
            edges.add(newEdge);
        }
        epq.add(edges.get(3));
        epq.decrease(3, 3, 4);
        String example = "3(3, 3) ";
        Assert.assertEquals(example, epq.toString());
    }

    @Test
    public void testDecrease03(){
        ArrayList<Edge> edges = new ArrayList<>();
        for(int i = 0; i <= 20; i++){
            Edge newEdge = new Edge(i, i, i);
            edges.add(newEdge);
        }
        epq.add(edges.get(3));
        epq.decrease(3, 1, 1);
        String example = "3(1, 1) ";
        Assert.assertEquals(example, epq.toString());
    }

    @Test
    public void testDecrease04(){
        ArrayList<Edge> edges = new ArrayList<>();
        for(int i = 0; i <= 20; i++){
            Edge newEdge = new Edge(i, i, i);
            edges.add(newEdge);
        }
        int[] indices = {6, 1, 8, 11, 0, 9, 2, 20, 5, 14, 3, 7, 4, 10, 17, 18, 19, 16, 15, 12, 13};
        for (int j = 0; j <= indices.length - 1; j++) {
            epq.add(edges.get(indices[j]));
        }
        epq.remove();
        epq.remove();
        epq.remove();
        epq.decrease(16, 1, 1);
        String example = "16(1, 1) 3(3, 3) 4(4, 4) 5(5, 5) 6(6, 6) 7(7, 7) 8(8, 8) 18(18, 18) 11(11, 11) 12(12, 12)" +
                " 13(13, 13) 9(9, 9) 14(14, 14) 10(10, 10) 17(17, 17) 20(20, 20) 19(19, 19) 15(15, 15) ";
        Assert.assertEquals(example, epq.toString());
    }
}