package com.company;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class AdjecencyGraph {
    private ArrayList<Vertex> vertices;

    public AdjecencyGraph() {
        vertices = new ArrayList<>();
    }

    public void addVertex(Vertex vertex){
        vertices.add(vertex);
    }

    public void addEdge(Vertex from, Vertex to, int distance){
        Edge newEdge = new Edge(from, to, distance);
    }

    // Make sure all vertices has acces to the edges relating them
    public void makeUndirected(){
        for(int v = 0; v < vertices.size(); v++){
            Vertex currentVertex = vertices.get(v);
            for(int e = 0; e < currentVertex.getEdges().size(); e++){
                Edge currentEdge = currentVertex.getEdges().get(e);
                if(!currentEdge.getToVertex().hasEdge(currentVertex)){
                    this.addEdge(currentEdge.getToVertex(), currentVertex, currentEdge.getDistance());
                }
            }
        }
    }

    // Figure out the shortest route around to all vertices
    public void MSTprims(){
        PriorityQueue<Vertex> townDistances = new PriorityQueue<>();

        // Make every vertex be the last priority in the priorityqueue
        for(int v = 0; v < vertices.size(); v++){
            vertices.get(v).distance = Integer.MAX_VALUE;
            vertices.get(v).predecessor = null;
            vertices.get(v).isInList = true;
            townDistances.offer(vertices.get(v));
        }
        // Declare the vertex we should start from by setting distance
        Vertex startVertex = townDistances.poll();
        startVertex.distance = 0;
        townDistances.offer(startVertex);

        // Remove the shortest distance vertex and assign its edge values to the corresponding vertices
        while(!townDistances.isEmpty()){
            Vertex MSTVertex = townDistances.poll();
            MSTVertex.isInList = false;
            for(int e = 0; e < MSTVertex.getEdges().size(); e++){
                Edge MSTEdge = MSTVertex.getEdges().get(e);
                Vertex toVertex = MSTEdge.getToVertex();
                if(MSTEdge.getDistance() < toVertex.distance && toVertex.isInList){
                    townDistances.remove(toVertex);
                    toVertex.distance = MSTEdge.getDistance();
                    toVertex.predecessor = MSTVertex;
                    townDistances.offer(toVertex);
                }
            }
        }
    }

    // Print out the shortest route around all vertexes
    public void printMST(){
        int totalDistance = 0;
        System.out.println("This is the cheapest route from town to town: ");
        for(int i = 0; i < vertices.size(); i++){
            if(vertices.get(i).predecessor != null){
                System.out.println("     " + i + ") From: " + vertices.get(i).predecessor.getName() + " To: " + vertices.get(i).getName() + " With a distance of: " + vertices.get(i).distance);
                totalDistance += vertices.get(i).distance;
            }
        }
        System.out.println("\n Number of towns in total: " + vertices.size());
        System.out.println("\n Total amount of km for shortest route: " + totalDistance + ", Total cost: " + totalDistance*1000000 + "dkk");
    }
}