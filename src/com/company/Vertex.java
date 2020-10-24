package com.company;

import java.util.ArrayList;

public class Vertex implements Comparable<Vertex> {
    private String name;
    private ArrayList<Edge> edges;
    public int distance;
    public Vertex predecessor;
    public boolean isInList;

    public Vertex(String name){
        this.name = name;
        edges = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public ArrayList<Edge> getEdges() {
        return edges;
    }

    public void addEdge(Edge edge){
        edges.add(edge);
    }

    @Override
    public int compareTo(Vertex v) {
        if (this.distance < v.distance){
            return -1;
        }
        if(this.distance > v.distance){
            return 1;
        }
        return 0;
    }

    @Override
    public String toString() {
        return "Vertex: " + this.getName();
    }

    public boolean hasEdge(Vertex vertex){
        for(int e = 0; e < edges.size(); e++){
            if(edges.get(e).getToVertex() == vertex){
                return true;
            }
        }
        return false;
    }
}
