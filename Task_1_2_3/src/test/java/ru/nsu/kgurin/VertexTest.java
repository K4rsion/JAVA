package ru.nsu.kgurin;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Tests for vertex implementation.
 */
public class VertexTest {

    // Atomic tests
    @Test
    void getDistanceTest() {
        //actual
        Vertex<Integer> actualVertex = new Vertex<>(1);
        actualVertex.setDistance(1);

        //asserts
        Assertions.assertEquals(1, actualVertex.getDistance());
    }

    @Test
    void setDistanceTest() {
        //actual
        Vertex<Integer> actualVertex = new Vertex<>(1);
        actualVertex.setDistance(1);

        //asserts
        Assertions.assertEquals(1, actualVertex.getDistance());
    }

    @Test
    void getVisitedTest() {
        //actual
        Vertex<Integer> actualVertex = new Vertex<>(1);
        actualVertex.setVisited(true);

        //asserts
        Assertions.assertTrue(actualVertex.getVisited());
    }

    @Test
    void setVisitedTest() {
        //actual
        Vertex<Integer> actualVertex = new Vertex<>(1);
        actualVertex.setVisited(true);

        //asserts
        Assertions.assertTrue(actualVertex.getVisited());
    }

    @Test
    void getKeyTest() {
        //actual
        Vertex<Integer> actualVertex = new Vertex<>(1);

        //asserts
        Assertions.assertEquals(1, actualVertex.getKey());
    }

    @Test
    void equalsTest() {
        Vertex<Integer> v1 = new Vertex<>(1);
        Vertex<Integer> v2 = new Vertex<>(1);
        Vertex<Integer> v3 = new Vertex<>(2);

        Assertions.assertEquals(v1, v2);
        Assertions.assertNotEquals(v1, v3);
    }

    @Test
    void hashCodeTest() {
        Vertex<Integer> v1 = new Vertex<>(1);
        Vertex<Integer> v2 = new Vertex<>(1);
        Vertex<Integer> v3 = new Vertex<>(2);

        Assertions.assertEquals(v1.hashCode(), v2.hashCode());
        Assertions.assertNotEquals(v1.hashCode(), v3.hashCode());
    }
}
