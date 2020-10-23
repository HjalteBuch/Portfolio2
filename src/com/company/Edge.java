package com.company;

public class Edge {
    private Vertex fromVertex;
    private Vertex toVertex;
    private int distance;

    public Edge(Vertex from, Vertex to, int distance) {
        this.fromVertex = from;
        this.toVertex = to;
        this.distance = distance;
        from.addEdge(this);
    }

    public Vertex getFromVertex() {
        return fromVertex;
    }

    public Vertex getToVertex() {
        return toVertex;
    }

    public int getDistance() {
        return distance;
    }
}
