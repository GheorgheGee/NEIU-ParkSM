package menu;

import model.Student;
import service.StudentService;

import java.sql.*;
import java.util.*;

public class StudentMenu {
    private final Scanner input = new Scanner(System.in);
    private final StudentService service = new StudentService();

    public void showMenu() {
        int choice = 0;

        while (choice != 5) {
            System.out.println("\nStudent Records Menu");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Update Student");
            System.out.println("4. Remove Student");
            System.out.println("5. Back to the Main Menu");

            choice = input.nextInt();
            input.nextLine();

            try {
                switch (choice) {
                    case 1 -> addStudent();
                    case 2 -> getAllStudent();
                    case 3 -> updateStudent();
                    case 4 -> removeStudent();
                    case 5 -> System.out.println("returning to Main Menu...");
                    default -> System.out.println("Invalid choice");
                }
            } catch (SQLException e) {
                System.out.println("Database error: " + e.getMessage());
            }
        }
    }
    private void addStudent() throws SQLException {
        System.out.println("Enter Student ID");
        int studentID = Integer.parseInt(input.nextLine());
        System.out.println("Enter Student First Name");
        String firstName = input.nextLine();
        System.out.println("Enter Student Last Name");
        String lastName = input.nextLine();
        System.out.println("Enter Student Phone Number");
        String phoneNumber = input.nextLine();
        System.out.println("Enter Student Email");
        String email = input.nextLine();

        Student s = new Student(studentID, firstName, lastName, phoneNumber, email);
        service.addStudent(s);

        System.out.println("Student added successfully");

    }
    private void getAllStudent() throws SQLException {
        List<Student> list = service.getAllStudents();

        if (list.isEmpty()) {
            System.out.println("No Student records found!");
            return;
        }

        TableFormatter tf = new TableFormatter(List.of(
                "StudentID", "First Name", "Last Name", "Phone Number", "Email"
        ));

        for (Student s : list) {
            tf.addRow(List.of(
                    String.valueOf(s.getStudentID()),
                    s.getFirstName(),
                    s.getLastName(),
                    s.getPhoneNumber(),
                    s.getEmail()
            ));
        }

        tf.print();

    }
    private void removeStudent() throws SQLException{
        System.out.println("Enter Student ID");
        int studentID = input.nextInt();
        input.nextLine();

        service.removeStudent(studentID);
        System.out.println("Student deleted successfully");
    }

    private void updateStudent() throws SQLException {

        int choice = 0;
        while (choice != 3) {
            System.out.println("\nUpdate Student Record ");
            System.out.println("1. Update Phone Number");
            System.out.println("2. Update Email");
            System.out.println("3. Back to Student Menu");

            choice = input.nextInt();
            input.nextLine();

            try{
                switch (choice) {
                    case 1 -> updatePhoneNumber();
                    case 2 -> updateEmail();
                    case 3 -> System.out.println("returning to Student Menu...");
                    default -> System.out.println("Invalid choice");
                }
            } catch (SQLException e) {
                System.out.println("Database error: " + e.getMessage());
            }
        }
    }
    public void updatePhoneNumber() throws SQLException {
        System.out.println("Enter Student ID");
        int studentID = input.nextInt();
        input.nextLine();

        System.out.println("Enter New Phone Number");
        String phoneNumber = input.nextLine();

        service.updatePhoneNumber(studentID, phoneNumber);
        System.out.println("Phone number updated successfully");
    }
    public void updateEmail() throws SQLException {
        System.out.println("Enter Student ID");
        int studentID = input.nextInt();
        input.nextLine();

        System.out.println("Enter New Email");
        String email = input.nextLine();

        service.updateEmail(studentID, email);
        System.out.println("Email updated successfully");
    }

}

