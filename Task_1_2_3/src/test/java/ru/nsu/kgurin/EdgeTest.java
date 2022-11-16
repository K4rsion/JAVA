package ru.nsu.kgurin;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Tests for edge implementation.
 */
public class EdgeTest {

    // Atomic tests
    @Test
    void getVertexToTest() {
        //actual
        Vertex<Integer> actualVertexFrom = new Vertex<>(1);
        Vertex<Integer> actualVertexTo = new Vertex<>(2);
        Edge<Integer> actualEdge = new Edge<>(actualVertexFrom, actualVertexTo, 1);

        //expected
        Vertex<Integer> expectedVertexTo = new Vertex<>(2);

        //asserts
        Assertions.assertEquals(expectedVertexTo, actualEdge.vertexTo());
    }

    @Test
    void getVertexFromTest() {
        //actual
        Vertex<Integer> actualVertexFrom = new Vertex<>(1);
        Vertex<Integer> actualVertexTo = new Vertex<>(2);
        Edge<Integer> actualEdge = new Edge<>(actualVertexFrom, actualVertexTo, 1);

        //expected
        Vertex<Integer> expectedVertexTo = new Vertex<>(1);

        //asserts
        Assertions.assertEquals(expectedVertexTo, actualEdge.vertexFrom());
    }

    @Test
    void getWeightTest() {
        //actual
        Vertex<Integer> actualVertexFrom = new Vertex<>(1);
        Vertex<Integer> actualVertexTo = new Vertex<>(2);
        Edge<Integer> actualEdge = new Edge<>(actualVertexFrom, actualVertexTo, 1);

        //asserts
        Assertions.assertEquals(1, actualEdge.weight());
    }

    @Test
    void equalsTest() {
        Vertex<Integer> v1 = new Vertex<>(1);
        Vertex<Integer> v2 = new Vertex<>(2);
        Vertex<Integer> v3 = new Vertex<>(3);
        Edge<Integer> e1 = new Edge<>(v1, v2, 1);
        Edge<Integer> e2 = new Edge<>(v1, v2, 1);
        Edge<Integer> e3 = new Edge<>(v1, v3, 1);

        Assertions.assertEquals(e1, e2);
        Assertions.assertNotEquals(e1, e3);
    }

    @Test
    void hashCodeTest() {
        Vertex<Integer> v1 = new Vertex<>(1);
        Vertex<Integer> v2 = new Vertex<>(2);
        Vertex<Integer> v3 = new Vertex<>(3);
        Edge<Integer> e1 = new Edge<>(v1, v2, 1);
        Edge<Integer> e2 = new Edge<>(v1, v2, 1);
        Edge<Integer> e3 = new Edge<>(v1, v3, 1);

        Assertions.assertEquals(e1.hashCode(), e2.hashCode());
        Assertions.assertNotEquals(e1.hashCode(), e3.hashCode());
    }
}
