import java.util.*;

public class Activity {
    // fields
    private Subject subject;
    private String group;
    private int number;
    private String day;
    private int start;
    private int duration;
    private String room;
    private int capacity;
    private int enrolled;

    // constructors and initialisation of parameters
    public Activity (Subject subject, String group, int number, String day, int start, int duration, String room, int capacity)
    {
        this.subject = subject;
        this.group = group;
        this.number = number; // activity number
        this.day = day;
        this.start = start;
        this.duration = duration;
        this.room = room;
        this.capacity = capacity;
        enrolled = 0;
    }

    public String subNumber() {
        return subject.subNumber();
    }

    public int getEnrolled() {
        return enrolled;
    }

    public int getCapacity() {
        return capacity;
    }
    public String getGroup() {
        return group;
    }
    public boolean hasSubNum(String subNumber) {
        return this.subNumber().matches(subNumber);
    }

    public boolean hasGroup(String group) {
        return this.group.equals(group);
    }

    public boolean hasActNum(int number) {
        return this.number == number;
    }

    public void enrolStudent() {
        enrolled++;
    }

    public void unEnrolStudent() {
        enrolled--;
    }
    // toString() method
    @Override
    public String toString() {
        String a = ((start < 10 ) ? "0" : "") + start + ":00";
        return subNumber() + " " + group + " " + number + " " + day + " " + room + " " + a + " " + duration + "hrs " + enrolled + "/" + capacity;
    }
}
