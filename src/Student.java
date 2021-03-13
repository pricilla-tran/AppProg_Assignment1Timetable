import java.util.*;

public class Student {
    // fields
    private University university;
    private String number;
    private String name;
    private LinkedList<Activity> activities = new LinkedList<Activity>();

    // constructor and initialisation of fields
    public Student(String number, String name) {
        this.university = university;
        this.number = number;
        this.name = name;
        this.activities = activities;
    }


    // student menu using menu pattern
    public void use(University university) {
        char choice;
        while((choice = readSChoice()) != 'x') {
            switch(choice) {
                case 'v': studView(); break;
                case 'e': studEnrol(university); break;
                case 'w': studWithdraw(); break;
                default: studHelp(); break;
            }
        }

    }

    // read pattern for student menu
    private char readSChoice() {
        System.out.print("Choice (v/e/w/x): ");
        return In.nextChar();
    }

    // hasNumber() method
    public boolean hasNumber(String number) {
        return this.number.equals(number);
    }

    // studView() method
    private void studView() {
        for (Activity activity: activities) {
            System.out.println(activity);
        }
    }

    // studEnrol() method
    private void studEnrol(University university) {
        Subject sub = university.selectSubject();
        if (sub == null) {
            System.out.println("No such subject");
        }
        else {
            System.out.println("Select an activity");
            sub.selectActivity(sub);

            String subNumber = sub.subNumber();
            Activity enrolled = null;

            String code = readCode();
            String group = code.split(":")[0];

            boolean full = true;
            boolean exists = false;

            if (noActNum(code)) {
                LinkedList<Activity> subject_activities = sub.getActivities();
                for(Activity act : subject_activities){
                    if(act.getGroup().equals(code)){
                        exists = true;
                        if(!isFull(act)){
                            enrolled = act;
                            full = false;
                            break;
                        }
                    }
                }
            }
            else{
                int number = Integer.parseInt(code.split(":")[1]);
                enrolled = activity(sub, group, number);
                if(enrolled != null){
                    exists = true;
                    if (!isFull(enrolled)){
                        full = false;
                    }
                }
            }

            if(exists){
                if(!full){
                    if (unenrol(sub, group)) {
                        Activity oldAct = getAct(sub,group);
                        activities.remove(oldAct);
                        oldAct.unEnrolStudent();
                    }
                    activities.add(enrolled);
                    enrolled.enrolStudent();
                }
                else {
                    System.out.println("No available seats");
                }
            }
            else{
                System.out.println("No such activity");
            }
        }
    }

    private boolean unenrol(Subject sub, String group) {
        for (Activity activity : activities) {
            if (activity.hasSubNum(sub.subNumber()) && activity.hasGroup(group)) {
                return true;
            }
        }
        return false;
    }

    private boolean isFull(Activity activity) {
        if (activity.getEnrolled() > activity.getCapacity()-1) {
            return true;
        }
        return false;
    }

    private boolean noActNum(String code) {
        if (code.contains(":")) {
            return false;
        }
        return true;
    }

    // studWithdraw() method
    private void studWithdraw() {
        String code = readWDCode();
        String subNumber = code.split(":")[0];
        String group = code.split(":")[1];
        Activity withdraw = withdraw(subNumber, group);
        if (withdraw == null) {
            System.out.println("Not enrolled in activity");
        }
        else {
            activities.remove(withdraw);
            withdraw.unEnrolStudent();
        }

    }

    private Activity withdraw(String subNumber, String group) {
        for (Activity activity : activities) {
            if (activity.hasSubNum(subNumber) && activity.hasGroup(group)) {
                return activity;
            }
        }
        return null;
    }


    private Activity getAct(Subject sub, String group) {
        for (Activity activity : activities) {
            if (activity.hasSubNum(sub.subNumber()) && activity.hasGroup(group)) {
                return activity;
            }
        }
        return null;
    }

    private Activity activity(Subject sub, String group, int number) {
        for (Activity activity: sub.getActivities())
            if (activity.hasSubNum(sub.subNumber()) && activity.hasGroup(group) && activity.hasActNum(number))
                return activity;
        return null;
    }

    public void unEnrolAll() {
        for (Activity activity : activities) {
            activity.unEnrolStudent();
        }
    }

    private String readCode() {
        System.out.print("Activity code (group:activity): ");
        return In.nextLine();
    }

    private String readWDCode() {
        System.out.print("Activity code (subject:group): ");
        return In.nextLine();
    }

    // studHelp() method
    private void studHelp() {
        System.out.println("Student menu options");
        System.out.println("v = view my activities");
        System.out.println("e = enrol in an activity");
        System.out.println("w = withdraw from an activity");
        System.out.println("x = exit");
    }

    // toString() method
    @Override
    public String toString() {
        return number + " " + name;
    }
}
