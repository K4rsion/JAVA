package ru.nsu.kgurin;

import java.util.Objects;

/**
 * Edge is a basic element of a graph that connects two vertices.
 */
public record Edge<T>(Vertex<T> vertexFrom, Vertex<T> vertexTo, int weight) {}