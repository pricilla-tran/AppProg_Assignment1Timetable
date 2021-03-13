import java.util.*;
import java.text.*;

public class Subject {
    // fields
    private String number;
    private String name;
    private LinkedList<Activity> activities = new LinkedList<Activity>();

    // constructor and initialisation of fields
    public Subject(String number, String name) {
        this.number = number;
        this.name = name;
        this.activities = activities;
    }

    // addActivity method
    public void addActivity(String group, int number, String day, int start, int duration, String room, int capacity) {
        activities.add(new Activity(this, group, number, day, start, duration, room, capacity));
    }

    public LinkedList<Activity> getActivities() {
        return activities;
    }

    // subNumber() method
    public String subNumber() {
        return number;
    }

    public boolean hasSubNumber(String number) {
        return this.number.equals(number);
    }

    public void selectActivity(Subject subject) {
        for(Activity activity : activities) {
            System.out.println(activity);
        }
    }

    // toString() method
    @Override
    public String toString() {
        return number + " " + name;
    }
}
