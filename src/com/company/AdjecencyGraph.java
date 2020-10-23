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

    public void MSTprims(){
        PriorityQueue<Vertex> townDistances = new PriorityQueue<>();

        for(int v = 0; v < vertices.size(); v++){
            vertices.get(v).distance = Integer.MAX_VALUE;
            vertices.get(v).predecessor = null;
            vertices.get(v).isInList = true;
            townDistances.offer(vertices.get(v));
        }
        Vertex startVertex = townDistances.poll();
        startVertex.distance = 0;
        townDistances.offer(startVertex);

        // ordenlige måde at gøre det på, men Haslev når ikke at tilføje nogle værdier da de andre bliver fjernet fra listen først.
            //hvis vi tilføjer elementerne igen, vil det altid være den samme vertex som vil køre igen og igen, (eskildstrup)
        /*while(!townDistances.isEmpty()){
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
        }*/

        //Forsøg på at gøre det på en anden måde, men er ikke helt sikker på dette virker.
        //kan kun forestille mig dette skaber andre problemer, men kan ikke lige se hvad det skulle være...
            //måske gøre dette efter vi har kørt det ovenstående loop færdigt, så vi kun køre med de resterende Vertexes som har værdier == MAX.VALUE?
        for(int v = 0; v < vertices.size(); v++){
            Vertex MSTVertex = vertices.get(v);
            for(int e = 0; e < MSTVertex.getEdges().size(); e++){
                Edge MSTEdge = MSTVertex.getEdges().get(e);
                Vertex toVertex = MSTEdge.getToVertex();
                if(MSTEdge.getDistance() < toVertex.distance){
                    toVertex.distance = MSTEdge.getDistance();
                    toVertex.predecessor = MSTVertex;
                }
            }
        }

        System.out.println("This is the cheapest route from town to town: ");
        String predecessor;
        for (int i = 0; i < vertices.size(); i++){

            if (vertices.get(i).predecessor == null){
                predecessor = "null";
            }else{
                predecessor = vertices.get(i).predecessor.getName();
            }
                System.out.println("    " + i + ") From: " + predecessor + " To: " + vertices.get(i).getName() + " With a distance of: " + vertices.get(i).distance);

        }
        System.out.println("\n Amount of towns: " + vertices.size());
    }
}