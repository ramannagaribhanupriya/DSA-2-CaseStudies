import java.util.*;

class Activity {
    int id;
    String name;
    int start;
    int finish;

    Activity(int id, String name, int start, int finish) {
        this.id = id;
        this.name = name;
        this.start = start;
        this.finish = finish;
    }
}

public class CampusFlow_C06 {

    public static void activitySelection(Activity[] activities) {

        Arrays.sort(activities, Comparator.comparingInt(a -> a.finish));

        System.out.println("\nSelected Campus Activities:\n");

        int lastFinish = -1;

        for (Activity activity : activities) {
            if (activity.start >= lastFinish) {
                System.out.println("Activity ID: " + activity.id +
                        " | Activity: " + activity.name +
                        " | Time: " + activity.start + " - " + activity.finish);
                lastFinish = activity.finish;
            }
        }
    }

    public static void main(String[] args) {

        Activity[] activities = {
                new Activity(101, "Workshop in Seminar Hall", 9, 10),
                new Activity(102, "Placement Training", 9, 12),
                new Activity(103, "Coding Contest", 10, 11),
                new Activity(104, "Faculty Meeting", 11, 12),
                new Activity(105, "Club Event", 12, 13)
        };

        System.out.println("CampusFlow - University Campus Resource Management System");
        System.out.println("Using Activity Selection Algorithm\n");

        System.out.println("Campus Activity Requests:\n");

        for (Activity activity : activities) {
            System.out.println("Activity ID: " + activity.id +
                    " | Activity: " + activity.name +
                    " | Time: " + activity.start + " - " + activity.finish);
        }

        activitySelection(activities);

        System.out.println("\nActivity Selection Completed Successfully.");
    }
}