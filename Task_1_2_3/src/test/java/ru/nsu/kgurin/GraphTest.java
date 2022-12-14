package ru.nsu.kgurin;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


/**
 * Tests for graph implementation.
 */
public class GraphTest {

    // Atomic tests
    @Test
    void addVertexTest() {
        //actual
        Graph<Integer> actual = new Graph<>();
        actual.addVertex(1);

        //expected
        Graph<Integer> expected = new Graph<>();
        expected.addVertex(1);

        //asserts
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void removeVertexTest() {
        //actual
        Vertex<Integer> v1 = new Vertex<>(1);
        Vertex<Integer> v2 = new Vertex<>(2);
        Graph<Integer> actual = new Graph<>();
        actual.addVertex(1);
        actual.addVertex(2);
        actual.addEdge(v1, v2, 2);
        actual.removeVertex(1);

        //expected
        Graph<Integer> expected = new Graph<>();
        expected.addVertex(2);

        //asserts
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void addEdgeTest() {
        //actual
        Vertex<Integer> v1 = new Vertex<>(1);
        Vertex<Integer> v2 = new Vertex<>(2);
        Graph<Integer> actual = new Graph<>();
        actual.addVertex(1);
        actual.addVertex(2);
        actual.addEdge(v1, v2, 2);

        //expected
        Graph<Integer> expected = new Graph<>();
        expected.addVertex(1);
        expected.addVertex(2);
        expected.addEdge(v1, v2, 2);

        //asserts
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void removeEdgeTest() {
        //actual
        Vertex<Integer> v1 = new Vertex<>(1);
        Vertex<Integer> v2 = new Vertex<>(2);
        Graph<Integer> actual = new Graph<>();
        actual.addVertex(1);
        actual.addVertex(2);
        actual.addEdge(v1, v2, 2);
        actual.removeEdge(1);

        //expected
        Graph<Integer> expected = new Graph<>();
        expected.addVertex(1);
        expected.addVertex(2);
        expected.removeEdge(1);

        //asserts
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void dijkstraTest() {
        //actual
        Vertex<Integer> a = new Vertex<>(1);
        a.setVisited(true);
        a.setDistance(0);
        Vertex<Integer> b = new Vertex<>(2);
        b.setVisited(true);
        b.setDistance(3);
        Vertex<Integer> c = new Vertex<>(3);
        c.setVisited(true);
        c.setDistance(2);
        Vertex<Integer> d = new Vertex<>(4);
        d.setVisited(true);
        d.setDistance(4);

        Graph<Integer> graph = new Graph<>();

        graph.addVertex(1);
        graph.addVertex(2);
        graph.addVertex(3);
        graph.addVertex(4);

        graph.addEdge(a, b, 4);
        graph.addEdge(a, c, 2);
        graph.addEdge(a, d, 5);
        graph.addEdge(b, d, 1);
        graph.addEdge(c, b, 1);

        List<Vertex<Integer>> actual = graph.dijkstra(1);

        //expected
        List<Vertex<Integer>> expected = Arrays.asList(a, c, b, d);

        //asserts
        Assertions.assertEquals(expected, actual);
    }

    // Representation tests
    @Test
    void matrixOfIncidenceTest() {
        // actual
        int vertexCount;
        int edgeCount;

        Integer[] vertexArray;
        int[][] weights;

        try (InputStream input =
                     getClass().getClassLoader().getResourceAsStream("matrixOfIncidence.txt")) {
            assert input != null;
            Scanner sc = new Scanner(input);

            vertexCount = sc.nextInt();
            edgeCount = sc.nextInt();

            vertexArray = new Integer[vertexCount];
            weights = new int[edgeCount][vertexCount];

            for (int i = 0; i < vertexCount; i++) {
                vertexArray[i] = sc.nextInt();
            }

            for (int i = 0; i < edgeCount; i++) {
                for (int j = 0; j < vertexCount; j++) {
                    weights[i][j] = sc.nextInt();
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        //expected
        Vertex<Integer> a = new Vertex<>(1);
        Vertex<Integer> b = new Vertex<>(2);
        Vertex<Integer> c = new Vertex<>(3);
        Vertex<Integer> d = new Vertex<>(4);

        Graph<Integer> expected = new Graph<>();

        expected.addVertex(1);
        expected.addVertex(2);
        expected.addVertex(3);
        expected.addVertex(4);

        expected.addEdge(a, b, 4);
        expected.addEdge(a, c, 2);
        expected.addEdge(a, d, 5);
        expected.addEdge(b, d, 1);
        expected.addEdge(c, b, 1);

        Graph<Integer> actual = new Graph<>(vertexArray, weights, edgeCount);

        //asserts
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void matrixOfAdjacencyTest() {
        // actual
        int vertexCount;
        Integer[] vertexArray;
        int[][] weights;

        try (InputStream input = getClass()
                .getClassLoader().getResourceAsStream("matrixOfAdjacency.txt")) {
            assert input != null;
            Scanner sc = new Scanner(input);
            vertexCount = sc.nextInt();

            vertexArray = new Integer[vertexCount];
            weights = new int[vertexCount][vertexCount];

            for (int i = 0; i < vertexCount; i++) {
                vertexArray[i] = sc.nextInt();
            }

            for (int i = 0; i < vertexCount; i++) {
                for (int j = 0; j < vertexCount; j++) {
                    weights[i][j] = sc.nextInt();
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        //expected
        Vertex<Integer> a = new Vertex<>(1);
        Vertex<Integer> b = new Vertex<>(2);
        Vertex<Integer> c = new Vertex<>(3);
        Vertex<Integer> d = new Vertex<>(4);

        Graph<Integer> expected = new Graph<>();

        expected.addVertex(1);
        expected.addVertex(2);
        expected.addVertex(3);
        expected.addVertex(4);

        expected.addEdge(a, b, 4);
        expected.addEdge(a, c, 2);
        expected.addEdge(a, d, 5);
        expected.addEdge(b, d, 1);
        expected.addEdge(c, b, 1);

        Graph<Integer> actual = new Graph<>(vertexArray, weights);

        //asserts
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void listOfAdjacencyTest() {
        // actual
        int vertexCount;
        String[] vertexArray;
        List<String>[] vertexList;
        List<Integer>[] weights;

        try (InputStream input =
                     getClass().getClassLoader().getResourceAsStream("listOfAdjacency.txt")) {
            assert input != null;
            Scanner sc = new Scanner(input);

            vertexCount = sc.nextInt();
            vertexArray = new String[vertexCount];
            vertexList = new List[vertexCount];
            weights = new List[vertexCount];

            for (int i = 0; i < vertexCount; i++) {
                vertexList[i] = new ArrayList<>();
                weights[i] = new ArrayList<>();
            }

            for (int i = 0; i < vertexCount; i++) {
                vertexArray[i] = sc.next();
            }

            for (int i = 0; i < vertexCount; i++) {
                int adjs = sc.nextInt();

                for (int j = 0; j < adjs; j++) {
                    vertexList[i].add(sc.next());
                    weights[i].add(sc.nextInt());
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        //expected
        Vertex<String> a = new Vertex<>("a");
        Vertex<String> b = new Vertex<>("b");
        Vertex<String> c = new Vertex<>("c");
        Vertex<String> d = new Vertex<>("d");

        Graph<String> expected = new Graph<>();

        expected.addVertex("a");
        expected.addVertex("b");
        expected.addVertex("c");
        expected.addVertex("d");

        expected.addEdge(a, b, 4);
        expected.addEdge(a, c, 2);
        expected.addEdge(a, d, 5);
        expected.addEdge(b, d, 1);
        expected.addEdge(c, b, 1);

        Graph<String> actual = new Graph<>(vertexArray, vertexList, weights);

        //asserts
        Assertions.assertEquals(expected, actual);
    }

    //Compound tests
    @Test
    void stringGraphTest() {
        // actual
        int vertexCount;
        String[] vertexArray;
        int[][] weights;

        try (InputStream input = getClass()
                .getClassLoader().getResourceAsStream("stringGraph.txt")) {
            assert input != null;
            Scanner sc = new Scanner(input);
            vertexCount = sc.nextInt();

            vertexArray = new String[vertexCount];
            weights = new int[vertexCount][vertexCount];

            for (int i = 0; i < vertexCount; i++) {
                vertexArray[i] = sc.next();
            }

            for (int i = 0; i < vertexCount; i++) {
                for (int j = 0; j < vertexCount; j++) {
                    weights[i][j] = sc.nextInt();
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        //expected
        Vertex<String> a = new Vertex<>("a");
        Vertex<String> b = new Vertex<>("b");
        Vertex<String> c = new Vertex<>("c");
        Vertex<String> d = new Vertex<>("d");

        Graph<String> expected = new Graph<>();

        expected.addVertex("a");
        expected.addVertex("b");
        expected.addVertex("c");
        expected.addVertex("d");

        expected.addEdge(a, b, 2);
        expected.addEdge(b, c, 3);
        expected.addEdge(c, d, 4);
        expected.addEdge(a, d, 1);

        Graph<String> actual = new Graph<>(vertexArray, weights);

        //asserts
        Assertions.assertEquals(expected, actual);

        //dijkstra
        a.setDistance(0);
        a.setVisited(true);
        b.setDistance(2);
        b.setVisited(true);
        c.setDistance(5);
        c.setVisited(true);
        d.setDistance(1);
        d.setVisited(true);
        List<Vertex<String>> expectedDijkstra = Arrays.asList(a, d, b, c);
        List<Vertex<String>> actualDijkstra = actual.dijkstra("a");
        Assertions.assertEquals(expectedDijkstra, actualDijkstra);

    }
}
