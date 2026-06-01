import java.util.TreeMap;

public class CampusFlowUniversity_C02 {

    public static void main(String[] args) {

        TreeMap<Integer, String> bPlusTree = new TreeMap<>();

        // Insert campus resources
        bPlusTree.put(101, "Computer Lab");
        bPlusTree.put(102, "Seminar Hall");
        bPlusTree.put(103, "Library");
        bPlusTree.put(104, "Physics Lab");
        bPlusTree.put(105, "Classroom A");
        bPlusTree.put(106, "Classroom B");

        System.out.println("Original Campus Resources:");

        for (Integer key : bPlusTree.keySet()) {
            System.out.println("Resource ID " + key + " = "
                    + bPlusTree.get(key));
        }

        System.out.println("\nB+ Tree Leaf Nodes:");

        for (Integer key : bPlusTree.keySet()) {
            System.out.println("Key = " + key);
        }

        System.out.println("\nTotal Campus Resources = "
                + bPlusTree.size());

        // Search existing resource
        int searchId = 104;

        System.out.println("\nSearching Resource "
                + searchId + "...");

        if (bPlusTree.containsKey(searchId)) {
            System.out.println("\nResource Found:");
            System.out.println("Resource ID " + searchId
                    + " = " + bPlusTree.get(searchId));
        } else {
            System.out.println("\nResource Not Found");
        }

        // Search non-existing resource
        searchId = 110;

        System.out.println("\nSearching Resource "
                + searchId + "...");

        if (bPlusTree.containsKey(searchId)) {
            System.out.println("\nResource Found:");
            System.out.println("Resource ID " + searchId
                    + " = " + bPlusTree.get(searchId));
        } else {
            System.out.println("\nResource Not Found");
        }

        System.out.println(
                "\nB+ Tree Indexing Completed Successfully.");
    }
}