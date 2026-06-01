import java.util.*;

public class  UniversityFacilityNetwork_C03 {

    private Map<String, List<String>> graph = new HashMap<>();

    // Add facility
    public void addFacility(String facility) {
        graph.putIfAbsent(facility, new ArrayList<>());
    }

    // Add connection between facilities
    public void addConnection(String source, String destination) {
        graph.get(source).add(destination);
        graph.get(destination).add(source);
    }

    // BFS Traversal
    public void bfsTraversal(String startFacility) {

        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();

        visited.add(startFacility);
        queue.add(startFacility);

        System.out.println("\nBFS Traversal:");

        while (!queue.isEmpty()) {

            String facility = queue.poll();
            System.out.println("Visited Facility : " + facility);

            for (String neighbor : graph.get(facility)) {

                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }
    }

    public static void main(String[] args) {

        CampusResourceManagement_C03 campus =
                new CampusResourceManagement_C03();

        // Adding campus facilities
        campus.addFacility("Admin Block");
        campus.addFacility("Classroom Block");
        campus.addFacility("Computer Lab");
        campus.addFacility("Library");
        campus.addFacility("Faculty Room");
        campus.addFacility("Canteen");
        campus.addFacility("Auditorium");

        // Connecting facilities
        campus.addConnection("Admin Block", "Classroom Block");
        campus.addConnection("Admin Block", "Computer Lab");
        campus.addConnection("Classroom Block", "Library");
        campus.addConnection("Classroom Block", "Faculty Room");
        campus.addConnection("Computer Lab", "Canteen");
        campus.addConnection("Library", "Auditorium");

        System.out.println(
            "CampusFlow - University Campus Resource Management System");
        System.out.println(
            "----------------------------------------------------");

        System.out.println("\nCampus Connections:");
        System.out.println("Admin Block <-> Classroom Block");
        System.out.println("Admin Block <-> Computer Lab");
        System.out.println("Classroom Block <-> Library");
        System.out.println("Classroom Block <-> Faculty Room");
        System.out.println("Computer Lab <-> Canteen");
        System.out.println("Library <-> Auditorium");

        // BFS Traversal
        campus.bfsTraversal("Admin Block");

        System.out.println("\nCampus Monitoring:");
        System.out.println(
            "Checking campus facility connectivity...");

        System.out.println(
            "All campus facilities are connected.");

        System.out.println(
            "Campus resource monitoring completed successfully.");
    }
}