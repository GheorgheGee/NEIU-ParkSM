package menu;

import model.Employee;
import service.EmployeeService;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class EmployeeMenu {

    private final Scanner input = new Scanner(System.in);
    private final EmployeeService service = new EmployeeService();

    public void showMenu() {
        int choice = 0;

        while (choice != 5) {
            System.out.println("\n Employee Records Menu");
            System.out.println("1. Add Employee");
            System.out.println("2. View All Employees");
            System.out.println("3. Update Employee");
            System.out.println("4. Remove Employee");
            System.out.println("5. Back to the Main Menu");

            choice = Integer.parseInt(input.nextLine());

            try {
                switch (choice) {
                    case 1 -> addEmployee();
                    case 2 -> getAllEmployee();
                    case 3 -> updateEmployee();
                    case 4 -> removeEmployee();
                    case 5 -> System.out.println("Returning to Main Menu...");
                    default -> System.out.println("Invalid choice");
                }
            } catch (SQLException e) {
                System.out.println("Database error: " + e.getMessage());
            }
        }
    }

    private void addEmployee() throws SQLException {
        System.out.println("Enter Employee ID");
        int employeeID = Integer.parseInt(input.nextLine());

        System.out.println("Enter Employee First Name");
        String firstName = input.nextLine();

        System.out.println("Enter Employee Last Name");
        String lastName = input.nextLine();

        System.out.println("Enter Employee Phone Number");
        String phoneNumber = input.nextLine();

        System.out.println("Enter Employee Email");
        String email = input.nextLine();

        Employee e = new Employee(employeeID, firstName, lastName, phoneNumber, email);

        service.addEmployee(e);

        System.out.println("Employee added successfully!");
    }

    private void getAllEmployee() throws SQLException {
        List<Employee> list = service.getAllEmployee();

        if (list.isEmpty()) {
            System.out.println("Employee list is empty!");
            return;
        }

        TableFormatter tf = new TableFormatter(List.of(
                "EmployeeID", "First Name", "Last Name", "Phone Number", "Email"
        ));

        for (Employee e : list) {
            tf.addRow(List.of(
                    String.valueOf(e.getEmployeeID()),
                    e.getFirstName(),
                    e.getLastName(),
                    e.getPhoneNumber(),
                    e.getEmail()
            ));
        }

        tf.print();
    }

    private void removeEmployee() throws SQLException {
        System.out.println("Enter Employee ID");
        int employeeID = Integer.parseInt(input.nextLine());

        service.removeEmployee(employeeID);
        System.out.println("Employee deleted successfully!");
    }

    private void updateEmployee() throws SQLException {

        int choice = 0;

        while (choice != 3) {
            System.out.println("\n Update Employee Record ");
            System.out.println("1. Update Phone Number");
            System.out.println("2. Update Email");
            System.out.println("3. Back to Employee Menu");

            choice = Integer.parseInt(input.nextLine());

            try {
                switch (choice) {
                    case 1 -> updatePhoneNumber();
                    case 2 -> updateEmail();
                    case 3 -> System.out.println("Returning to Employee Menu...");
                    default -> System.out.println("Invalid choice");
                }
            } catch (SQLException e) {
                System.out.println("Database error: " + e.getMessage());
            }
        }
    }

    public void updatePhoneNumber() throws SQLException {
        System.out.println("Enter Employee ID");
        int employeeID = Integer.parseInt(input.nextLine());

        System.out.println("Enter New Phone Number");
        String phoneNumber = input.nextLine();

        service.updatePhoneNumber(employeeID, phoneNumber);
        System.out.println("Phone number updated successfully!");
    }

    public void updateEmail() throws SQLException {
        System.out.println("Enter Employee ID");
        int employeeID = Integer.parseInt(input.nextLine());

        System.out.println("Enter New Email");
        String email = input.nextLine();

        service.updateEmail(employeeID, email);
        System.out.println("Email updated successfully!");
    }
}