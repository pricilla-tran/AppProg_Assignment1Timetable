import java.util.*;
import java.text.*;

public class University {
    // main method
    public static void main(String[] args) {
        new University().use();
    }
    // fields
    private LinkedList<Subject> subjects = new LinkedList<Subject>();
    private LinkedList<Student> students = new LinkedList<Student>();

    // constructor
    public University()
    {
        Subject ap = new Subject("48024", "Applications Programming");
        ap.addActivity("Lec1", 1, "Wed", 18, 1, "CB11.00.405", 200);
        ap.addActivity("Cmp1", 1, "Wed", 19, 2, "CB11.B1.403", 2);
        ap.addActivity("Cmp1", 2, "Wed", 19, 2, "CB11.B1.401", 2);
        ap.addActivity("Cmp1", 3, "Wed", 19, 2, "CB11.B1.402", 2);
        subjects.add(ap);

        Subject wsd = new Subject("31284", "Web Services Development");
        wsd.addActivity("Lec1", 1, "Tue", 16, 1, "CB02.03.002", 160);
        wsd.addActivity("Cmp1", 1, "Tue", 9, 2, "CB11.B1.102", 30);
        wsd.addActivity("Cmp1", 2, "Tue", 9, 2, "CB11.B1.103", 30);
        wsd.addActivity("Cmp1", 3, "Tue", 14, 2, "CB11.B1.102", 30);
        wsd.addActivity("Cmp1", 4, "Tue", 14, 2, "CB11.B1.103", 30);
        subjects.add(wsd);
    }

    // use method
    public void use() {
// initialisation of choice
        char choice;
// menu pattern and read loop to read the user's entries
        while ((choice = readChoice()) != 'x') {
            switch (choice) {
                case 'a' : addStudent(); break;
                case 'r' : removeStudent(); break;
                case 'v' : viewStudent(); break;
                case 'l' : login(); break;
                default: help(); break;
            }
        }
        System.out.println("Done");
    }

    private char readChoice() {
        System.out.print("Choice (a/r/v/l/x): ");
        return In.nextChar();
    }

    // addStudent() method
    private void addStudent() {
        String number = readNumber();
        Student existingStudent = student(number);
        if (existingStudent!=null) {
            System.out.println("Student number already exists");
        }
        else {
            String name = readName();
            students.add(new Student(number,name));
        }
    }

    // lookup pattern- to check student number
    private Student student (String number) {
        for (Student student: students)
            if (student.hasNumber(number))
                return student;
        return null;
    }
    // readName() method- using read pattern
    private String readName() {
        System.out.print("Name: ");
        return In.nextLine();
    }

    // readNumber() method- using read pattern
    private String readNumber() {
        System.out.print("Number: ");
        return In.nextLine();
    }

    // removeStudent() method
    private void removeStudent() {
        String number = readNumber();
        Student existingStudent = student(number);

        if (existingStudent != null) {
            students.remove(existingStudent);
            existingStudent.unEnrolAll();
        }
        else {
            System.out.println("No such student");
        }
    }

    // viewStudent() method
    private void viewStudent() {
        // for each loop- to view and print out each student
        for (Student student: students)
            System.out.println(student.toString());
    }

    // login() method
    private void login() {
        String number = readNumber();
        Student existingStudent = student(number);
        if (existingStudent != null)
            existingStudent.use(this);
        else
            System.out.println("No such student");
    }

    // help() method
    private void help() {
        System.out.println("University menu options");
        System.out.println("a = add a student");
        System.out.println("r = remove a student");
        System.out.println("v = view all students");
        System.out.println("l = login");
        System.out.println("x = exit");
    }

    // selectSubject() method
    public Subject selectSubject() {
        System.out.println("Select a subject");
        for (Subject subject: subjects)
            System.out.println(subject);
        String number = readSubNumber();
        Subject existingSubject = subject(number);

        return existingSubject;
    }

    // readSubNumber() method- read pattern to get user's selected subject
    private String readSubNumber() {
        System.out.print("Subject number: ");
        return In.nextLine();
    }

    // lookup pattern for the Subjects
    private Subject subject(String number) {
        for (Subject subject: subjects)
            if (subject.hasSubNumber(number))
                return subject;
        return null;
    }
}
