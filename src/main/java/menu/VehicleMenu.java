package menu;
import model.Vehicle;
import service.VehicleService;

import java.sql.*;
import java.util.*;

public class VehicleMenu {
    private final Scanner input = new Scanner(System.in);
    private final VehicleService service = new VehicleService();

    public void showMenu() {
        int choice = 0;

        while (choice != 4) {
            System.out.println("\n Vehicle Records Menu");
            System.out.println("1. Add Vehicle");
            System.out.println("2. View All Vehicles");
            System.out.println("3. Remove Vehicle");
            System.out.println("4. Back to the Main Menu");

            choice = input.nextInt();
            input.nextLine();

            try {
                switch (choice) {
                    case 1 -> addVehicle();
                    case 2 -> getAllVehicle();
                    case 3 -> removeVehicle();
                    case 4 -> System.out.println("returning to Main Menu...");
                    default -> System.out.println("Invalid choice");
                }
            } catch (SQLException e) {
                System.out.println("Database error: " + e.getMessage());
            }
        }
    }

    public void addVehicle() throws SQLException {

        System.out.println("Enter vehicle license plate: ");
        String licensePlate = input.nextLine().trim();

        System.out.println("Enter make: ");
        String make = input.nextLine().trim();

        System.out.println("Enter model: ");
        String model = input.nextLine().trim();

        System.out.println("Enter year: ");
        int year;
        try {
            year = Integer.parseInt(input.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("Invalid year format. Please try again.");
            return;
        }

        System.out.println("Is the vehicle owned by:");
        System.out.println("1. Student");
        System.out.println("2. Employee");

        int choice;
        try {
            choice = Integer.parseInt(input.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("Invalid choice.");
            return;
        }

        Integer studentID = null;
        Integer employeeID = null;

        if (choice == 1) {
            System.out.println("Enter Student ID:");
            try {
                studentID = Integer.parseInt(input.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Invalid Student ID.");
                return;
            }

        } else if (choice == 2) {
            System.out.println("Enter Employee ID:");
            try {
                employeeID = Integer.parseInt(input.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Invalid Employee ID.");
                return;
            }

        } else {
            System.out.println("Invalid choice.");
            return;
        }

        Vehicle v = new Vehicle(licensePlate, make, model, year, studentID, employeeID);
        service.addVehicle(v);

        System.out.println("Vehicle added successfully!");
    }

    public void getAllVehicle() throws SQLException {
        List<Vehicle> list = service.getAllVehicle();

        if (list.isEmpty()) {
            System.out.println("No vehicle records found!");
            return;
        }

        TableFormatter tf = new TableFormatter(List.of(
                "License Plate", "Make", "Model", "Year", "Student ID", "EmployeeID"
        ));

        for (Vehicle v : list) {
            tf.addRow(List.of(
                    v.getLicensePlate(),
                    v.getMake(),
                    v.getModel(),
                    String.valueOf(v.getYear()),
                    v.getStudentId(),
                    v.getEmployeeID()
            ));
        }

        tf.print();
    }

    private void removeVehicle() throws SQLException {
        System.out.println("Enter License Plate: ");
        String licensePlate = input.nextLine();

        boolean result = service.removeVehicle(licensePlate);
        if (result) {
            System.out.println("Vehicle deleted successfully!");
        } else {
            System.out.println("Vehicle could not be removed");
        }
    }
}


