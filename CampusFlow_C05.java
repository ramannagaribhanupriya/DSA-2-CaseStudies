class Resource {
    int id;
    String name;
    int bookings;

    Resource(int id, String name, int bookings) {
        this.id = id;
        this.name = name;
        this.bookings = bookings;
    }
}

public class CampusFlow_C05 {

    static void heapify(Resource[] arr, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && arr[left].bookings > arr[largest].bookings)
            largest = left;

        if (right < n && arr[right].bookings > arr[largest].bookings)
            largest = right;

        if (largest != i) {
            Resource temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;

            heapify(arr, n, largest);
        }
    }

    static void heapSort(Resource[] arr) {
        int n = arr.length;

        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, n, i);

        for (int i = n - 1; i > 0; i--) {
            Resource temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            heapify(arr, i, 0);
        }
    }

    public static void main(String[] args) {

        Resource[] resources = {
            new Resource(101, "Computer Lab", 120),
            new Resource(102, "Library", 95),
            new Resource(103, "Seminar Hall", 80),
            new Resource(104, "Physics Lab", 60),
            new Resource(105, "Classroom A", 150)
        };

        System.out.println("CampusFlow - University Campus Resource Management System");
        System.out.println("Using Heap Sort\n");

        System.out.println("Before Sorting:");
        for (Resource r : resources) {
            System.out.println(r.name + " - " + r.bookings + " bookings");
        }

        heapSort(resources);

        System.out.println("\nCampus Resources Sorted by Booking Count:\n");

        for (Resource r : resources) {
            System.out.println("Resource ID: " + r.id +
                    " | Resource Name: " + r.name +
                    " | Bookings: " + r.bookings);
        }

        System.out.println("\nHeap Sort Completed Successfully.");
    }
}