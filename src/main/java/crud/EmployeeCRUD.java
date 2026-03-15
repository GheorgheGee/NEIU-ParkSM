package crud;

import db.DBConnection;
import model.Employee;

import java.util.*;
import java.sql.*;

public class EmployeeCRUD {
    public void insert(Employee e) throws SQLException {
        String sql = "INSERT INTO Employee (employeeID, firstName, lastName, phoneNumber, email) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, e.getEmployeeID());
            ps.setString(2, e.getFirstName());
            ps.setString(3, e.getLastName());
            ps.setString(4, e.getPhoneNumber());
            ps.setString(5, e.getEmail());

            ps.executeUpdate();
        }
    }
    public List<Employee> getAll() throws SQLException {

        List<Employee> list = new ArrayList<>();
        String sql = "SELECT * FROM Employee";

        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Employee e = new Employee(
                        rs.getInt("employeeID"),
                        rs.getString("firstName"),
                        rs.getString("lastName"),
                        rs.getString("phoneNumber"),
                        rs.getString("email"));
                list.add(e);
            }
        } return list;
    }
    public void remove(int employeeID) throws SQLException {
        String sql = "DELETE FROM Employee WHERE employeeID = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, employeeID);
            ps.executeUpdate();
        }

    }
    /*public void updateEmployeeID(int employeeID, int newEmployeeID) throws SQLException {
        String sql = "Update Employee set employeeID = ? where employeeID = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, newEmployeeID);
            ps.setInt(2, employeeID);

            ps.executeUpdate();
        }
    } //For later use
    /*public void updateFirstName(int employeeID, String newFirstName) throws SQLException {
        String sql = "UPDATE Employee SET firstName = ? WHERE employeeID = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)); {
                 ps.setString(1, newFirstName);
                 ps.setInt(2, employeeID);

                 ps.executeUpdate();
        }
    }
    public void updateLastName(int studentID, String newLastName) throws SQLException {
        String sql = "UPDATE Student SET lastName = ? WHERE studentID = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)); {
            ps.setString(1, newLastName);
            ps.setInt(2, studentID);

            ps.executeUpdate();
        }
    } */
    public void updatePhoneNumber(int employeeID, String newPhoneNumber) throws SQLException {
        String sql = "UPDATE Employee SET phoneNumber = ? WHERE employeeID = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, newPhoneNumber);
            ps.setInt(2, employeeID);

            ps.executeUpdate();
        }
    }
    public void updateEmail(int employeeID, String newEmail) throws SQLException {
        String sql = "UPDATE Employee SET email = ? WHERE employeeID = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, newEmail);
            ps.setInt(2, employeeID);

            ps.executeUpdate();
        }
    }
}
