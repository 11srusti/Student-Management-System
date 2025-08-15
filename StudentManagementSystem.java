import java.util.ArrayList;
import java.util.Scanner;

class Student {
    String name;
    int rollNo;

    Student(String name, int rollNo) {
        this.name = name;
        this.rollNo = rollNo;
    }

    public String toString() {
        return "Roll No: " + rollNo + ", Name: " + name;
    }
}

public class StudentManagementSystem {

    static ArrayList<Student> students = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n--- Student Management System ---");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Search Student");
            System.out.println("4. Remove Student");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1 -> addStudent();
                case 2 -> viewStudents();
                case 3 -> searchStudent();
                case 4 -> removeStudent();
                case 5 -> System.out.println("Exiting...");
                default -> System.out.println("Invalid choice!");
            }
        } while (choice != 5);
    }

    public static void addStudent() {
        System.out.print("Enter student name: ");
        String name = sc.nextLine();
        System.out.print("Enter roll number: ");
        int rollNo = sc.nextInt();
        students.add(new Student(name, rollNo));
        System.out.println("✅ Student added successfully!");
    }

    public static void viewStudents() {
        if (students.isEmpty()) {
            System.out.println("No students found!");
        } else {
            System.out.println("\nStudent List:");
            for (Student s : students) {
                System.out.println(s);
            }
        }
    }

    public static void searchStudent() {
        System.out.print("Enter roll number to search: ");
        int rollNo = sc.nextInt();
        for (Student s : students) {
            if (s.rollNo == rollNo) {
                System.out.println("Found: " + s);
                return;
            }
        }
        System.out.println("Student not found!");
    }

    public static void removeStudent() {
        System.out.print("Enter roll number to remove: ");
        int rollNo = sc.nextInt();
        students.removeIf(s -> s.rollNo == rollNo);
        System.out.println("✅ Student removed (if existed)!");
    }
}
