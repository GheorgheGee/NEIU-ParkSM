package menu;

import model.VehiclePermit;
import model.views.VehiclePermitInfo;
import service.VehiclePermitService;

import java.util.*;
import java.sql.*;


public class VehiclePermitRecordsMenu {
    private final Scanner input = new Scanner(System.in);
    private final VehiclePermitService service = new VehiclePermitService();
    public void showMenu() throws SQLException {
        int choice = 0;

        while (choice != 5) {
            System.out.println("\n Vehicle Permits Menu");
            System.out.println("1. Add New Vehicle Permit");
            System.out.println("2. View all Vehicle Permit");
            System.out.println("3. Update Vehicle Permit");
            System.out.println("4. Remove Vehicle Permit");
            System.out.println("5. Back to Main Menu");

            choice = input.nextInt();
            input.nextLine();

            switch (choice) {
                case 1 -> addVehiclePermit();
                case 2 -> viewAllVehiclePermit();
                case 3 -> updateVehiclePermit();
                case 4 -> removeVehiclePermit();
                case 5 -> System.out.println("\nReturning to Main menu");
                default -> System.out.println("Invalid choice");
            }
        }
    }
    public void addVehiclePermit() {

        System.out.println("Enter Permit ID: ");
        int permitID;
        try {
            permitID = Integer.parseInt(input.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("Invalid Permit ID. Please enter a number.");
            return;
        }

        System.out.println("Enter License Plate: ");
        String licensePlate = input.nextLine().trim();
        if (licensePlate.isEmpty()) {
            System.out.println("License plate cannot be empty.");
            return;
        }

        VehiclePermit vp = new VehiclePermit(null, permitID, licensePlate);

        try {
            service.addVehiclePermit(vp);
            System.out.println("Vehicle Permit has been added!");
        } catch (SQLException ex) {
            System.out.println("SQL Error: " + ex.getMessage());
        }
    }
    public void viewAllVehiclePermit() throws SQLException {
        List<VehiclePermitInfo> list = service.getAll();

        if (list.isEmpty()) {
            System.out.println("No permit records found");
            return;
        }
        TableFormatter tf = new TableFormatter(List.of(
                "vpID", "licensePlate", "permitType", "validFrom", "validTo"));

        for (VehiclePermitInfo vp : list) {
            tf.addRow(List.of(
                    vp.getVpID(),
                    vp.getLicensePlate(),
                    vp.getPermitType(),
                    vp.getValidFrom(),
                    vp.getValidTo()
            ));
        }
        tf.print();
    }
    public void updateVehiclePermit() throws SQLException {
        System.out.println("Enter Vehicle Permit ID (vpID): ");
        int vpID = Integer.parseInt(input.nextLine());
        System.out.println("Enter New Vehicle Permit ID  (vpID): ");
        int newVpID = Integer.parseInt(input.nextLine());

        service.updateVehiclePermit(vpID, newVpID);
        System.out.println("Vehicle Permit has been updated");

    }
    public void removeVehiclePermit() throws SQLException {
        System.out.println("Enter Vehicle Permit ID (vpID): ");
        int vpID = Integer.parseInt(input.nextLine());

        service.removeVehiclePermit(vpID);
        System.out.println("Vehicle Permit has been removed");
    }
}
