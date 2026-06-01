class ResourceNode {
    int bookingId;
    String roomId;
    String facilityName;
    String bookingDetails;
    ResourceNode left, right;

    public ResourceNode(int bookingId, String roomId,
                        String facilityName, String bookingDetails) {
        this.bookingId = bookingId;
        this.roomId = roomId;
        this.facilityName = facilityName;
        this.bookingDetails = bookingDetails;
        left = right = null;
    }
}

class CampusBST {
    ResourceNode root;

    public ResourceNode insert(ResourceNode root, int bookingId,
                               String roomId, String facilityName,
                               String bookingDetails) {

        if (root == null)
            return new ResourceNode(bookingId, roomId,
                    facilityName, bookingDetails);

        if (bookingId < root.bookingId)
            root.left = insert(root.left, bookingId, roomId,
                    facilityName, bookingDetails);
        else if (bookingId > root.bookingId)
            root.right = insert(root.right, bookingId, roomId,
                    facilityName, bookingDetails);

        return root;
    }

    public void insert(int bookingId, String roomId,
                       String facilityName, String bookingDetails) {
        root = insert(root, bookingId, roomId,
                facilityName, bookingDetails);
    }

    public void inorder(ResourceNode root) {
        if (root != null) {
            inorder(root.left);

            System.out.println("Booking ID      : " + root.bookingId);
            System.out.println("Room ID         : " + root.roomId);
            System.out.println("Facility Name   : " + root.facilityName);
            System.out.println("Booking Details : " + root.bookingDetails);
            System.out.println("--------------------------------");

            inorder(root.right);
        }
    }

    public ResourceNode search(ResourceNode root, int bookingId) {
        if (root == null || root.bookingId == bookingId)
            return root;

        if (bookingId < root.bookingId)
            return search(root.left, bookingId);

        return search(root.right, bookingId);
    }

    public ResourceNode minValue(ResourceNode node) {
        ResourceNode current = node;

        while (current.left != null)
            current = current.left;

        return current;
    }

    public ResourceNode delete(ResourceNode root, int bookingId) {

        if (root == null)
            return root;

        if (bookingId < root.bookingId)
            root.left = delete(root.left, bookingId);

        else if (bookingId > root.bookingId)
            root.right = delete(root.right, bookingId);

        else {

            if (root.left == null)
                return root.right;

            else if (root.right == null)
                return root.left;

            ResourceNode temp = minValue(root.right);

            root.bookingId = temp.bookingId;
            root.roomId = temp.roomId;
            root.facilityName = temp.facilityName;
            root.bookingDetails = temp.bookingDetails;

            root.right = delete(root.right, temp.bookingId);
        }

        return root;
    }

    public void delete(int bookingId) {
        root = delete(root, bookingId);
    }

    public int countNodes(ResourceNode root) {
        if (root == null)
            return 0;

        return 1 + countNodes(root.left)
                 + countNodes(root.right);
    }
}

public class CampusResourceManagement_C01 {
    public static void main(String[] args) {

        CampusBST bst = new CampusBST();

        bst.insert(101, "CR-201", "Classroom",
                "Data Structures Class");

        bst.insert(150, "AUD-3", "Auditorium",
                "Technical Seminar");

        bst.insert(175, "CR-105", "Classroom",
                "Faculty Meeting");

        bst.insert(205, "LAB-1", "Computer Lab",
                "Java Programming Lab");

        bst.insert(250, "LIB-2", "Library Hall",
                "Workshop Event");

        System.out.println("===== CAMPUS RESOURCE RECORDS =====");
        bst.inorder(bst.root);

        ResourceNode result = bst.search(bst.root, 205);

        if (result != null) {
            System.out.println("\nRESOURCE FOUND");
            System.out.println("Room ID       : " + result.roomId);
            System.out.println("Facility Name : " + result.facilityName);
            System.out.println("Details       : " + result.bookingDetails);
        }

        System.out.println("\nDeleting Booking ID 150...");
        bst.delete(150);

        System.out.println("\n===== UPDATED RECORDS =====");
        bst.inorder(bst.root);

        System.out.println("\nTotal Active Resources : "
                + bst.countNodes(bst.root));
    }
}