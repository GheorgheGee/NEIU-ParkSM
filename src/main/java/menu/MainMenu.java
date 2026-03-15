package menu;

import java.sql.SQLException;
import java.util.*;

public class MainMenu {

    private final Scanner input = new Scanner(System.in);
    private final StudentMenu studentMenu = new StudentMenu();

    private final EmployeeMenu employeeMenu = new EmployeeMenu();

    private final VehicleMenu vehicleMenu = new VehicleMenu();
    private final VehiclePermitRecordsMenu vehiclePermitRecords = new VehiclePermitRecordsMenu();
    private final ParkingLotsMenu parkingLot = new ParkingLotsMenu();
    private final ParkingEventMenu parkingEvent = new ParkingEventMenu();

    public void start() throws SQLException {
        System.out.println("\nWelcome to NEIU Parking DBMS!");

        int choice = 0;
        while (choice != 7) {
            System.out.println("\nChoose one of the following: ");
            System.out.println("\n1. Student Records ");
            System.out.println("2. Employee Records ");
            System.out.println("3. Vehicle Records ");
            System.out.println("4. Vehicle Permit Records ");
            System.out.println("5. Parking lots ");
            System.out.println("6. Parking logs and events");
            System.out.println("7. Exit");
            choice = Integer.parseInt(String.valueOf(input.nextInt()));
            input.nextLine();

            switch (choice) {
                case 1 -> studentMenu.showMenu();
                case 2 -> employeeMenu.showMenu();
                case 3 -> vehicleMenu.showMenu();
                case 4 -> vehiclePermitRecords.showMenu();
                case 5 -> parkingLot.showMenu();
                case 6 -> parkingEvent.showMenu();
                case 7 -> System.out.println("\nLogging off ");
                default -> System.out.println("Invalid choice");

            }
        }
    }
}

