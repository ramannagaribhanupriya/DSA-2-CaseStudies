import java.util.*;

class Edge {
    String destination;
    int weight;

    Edge(String destination, int weight) {
        this.destination = destination;
        this.weight = weight;
    }
}

public class CampusFlow_C04 {

    private Map<String, List<Edge>> graph;

    public CampusFlow_C04() {
        graph = new HashMap<>();
    }

    public void addLocation(String location) {
        graph.putIfAbsent(location, new ArrayList<>());
    }

    public void addPath(String source, String destination, int distance) {
        graph.get(source).add(new Edge(destination, distance));
        graph.get(destination).add(new Edge(source, distance));
    }

    static class Node {
        String location;
        int distance;

        Node(String location, int distance) {
            this.location = location;
            this.distance = distance;
        }
    }

    public void dijkstra(String source) {
        Map<String, Integer> distance = new HashMap<>();

        for (String location : graph.keySet()) {
            distance.put(location, Integer.MAX_VALUE);
        }

        distance.put(source, 0);

        PriorityQueue<Node> pq =
                new PriorityQueue<>(Comparator.comparingInt(n -> n.distance));

        pq.add(new Node(source, 0));

        while (!pq.isEmpty()) {
            Node current = pq.poll();

            for (Edge edge : graph.get(current.location)) {
                int newDistance = distance.get(current.location) + edge.weight;

                if (newDistance < distance.get(edge.destination)) {
                    distance.put(edge.destination, newDistance);
                    pq.add(new Node(edge.destination, newDistance));
                }
            }
        }

        System.out.println("\nShortest Distance from " + source + ":\n");

        for (String location : distance.keySet()) {
            System.out.println(source + " -> " + location +
                    " = " + distance.get(location) + " units");
        }
    }

    public static void main(String[] args) {

        CampusFlow_C04 campus = new CampusFlow_C04();

        campus.addLocation("Admin Block");
        campus.addLocation("Computer Lab");
        campus.addLocation("Library");
        campus.addLocation("Classroom A");
        campus.addLocation("Seminar Hall");
        campus.addLocation("Physics Lab");

        campus.addPath("Admin Block", "Computer Lab", 4);
        campus.addPath("Admin Block", "Library", 2);
        campus.addPath("Computer Lab", "Classroom A", 5);
        campus.addPath("Library", "Classroom A", 3);
        campus.addPath("Library", "Seminar Hall", 6);
        campus.addPath("Classroom A", "Physics Lab", 4);
        campus.addPath("Seminar Hall", "Physics Lab", 2);

        System.out.println("CampusFlow - University Campus Resource Management System");
        System.out.println("Using Dijkstra's Algorithm\n");

        System.out.println("Campus Connections:");
        System.out.println("Admin Block <-> Computer Lab = 4");
        System.out.println("Admin Block <-> Library = 2");
        System.out.println("Computer Lab <-> Classroom A = 5");
        System.out.println("Library <-> Classroom A = 3");
        System.out.println("Library <-> Seminar Hall = 6");
        System.out.println("Classroom A <-> Physics Lab = 4");
        System.out.println("Seminar Hall <-> Physics Lab = 2");

        campus.dijkstra("Admin Block");

        System.out.println("\nCampus Route Analysis Completed Successfully.");
    }
}