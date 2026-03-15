package crud;

import db.DBConnection;
import model.Student;

import java.util.*;
import java.sql.*;

public class StudentCRUD {
    public void insert(Student s)  {
        String sql = "INSERT INTO Student (studentID, firstName, lastName, phoneNumber, email) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, s.getStudentID());
            ps.setString(2, s.getFirstName());
            ps.setString(3, s.getLastName());
            ps.setString(4, s.getPhoneNumber());
            ps.setString(5, s.getEmail());

            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public List<Student> getAll() throws SQLException {

        List<Student> list = new ArrayList<>();
        String sql = "SELECT * FROM Student";

        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Student s = new Student(
                        rs.getInt("studentID"),
                        rs.getString("firstName"),
                        rs.getString("lastName"),
                        rs.getString("phoneNumber"),
                        rs.getString("email"));
                list.add(s);
            }
        } return list;
    }
    public void remove(int studentID) throws SQLException {
        String sql = "DELETE FROM Student WHERE studentID = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, studentID);
            ps.executeUpdate();
        }

    }
    /*public void updateStudentID(int studentID, int newStudentID) throws SQLException {
        String sql = "Update Student set studentID = ? where studentID = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, newStudentID);
            ps.setInt(2, studentID);

            ps.executeUpdate();
        }
    } //For later use
    /*public void updateFirstName(int studentID, String newFirstName) throws SQLException {
        String sql = "UPDATE Student SET firstName = ? WHERE studentID = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)); {
                 ps.setString(1, newFirstName);
                 ps.setInt(2, studentID);

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
    public void updatePhoneNumber(int studentID, String newPhoneNumber) throws SQLException {
        String sql = "UPDATE Student SET phoneNumber = ? WHERE studentID = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, newPhoneNumber);
            ps.setInt(2, studentID);

            ps.executeUpdate();
        }
    }
    public void updateEmail(int studentID, String newEmail) throws SQLException {
        String sql = "UPDATE Student SET email = ? WHERE studentID = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, newEmail);
            ps.setInt(2, studentID);

            ps.executeUpdate();
        }
    }
}
