package crud;

import db.DBConnection;
import model.Vehicle;

import java.util.*;
import java.sql.*;

public class VehicleCRUD {
    public void insert(Vehicle v) throws SQLException {
        String sql = "INSERT INTO Vehicle (licensePlate, make, model, year, studentID, employeeID ) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, v.getLicensePlate());
            ps.setString(2, v.getMake());
            ps.setString(3, v.getModel());
            ps.setInt(4, v.getYear());

            if (v.getStudentId() != null) {
                ps.setInt(5, v.getStudentId());
            }  else {
                ps.setNull(5, Types.INTEGER);
            }

            if (v.getEmployeeID() != null) {
                ps.setInt(6, v.getEmployeeID());
            } else {
                ps.setNull(6, Types.INTEGER);
            }

            ps.executeUpdate();
        }
    }
    public List<Vehicle> getAll() throws SQLException {

        List<Vehicle> list = new ArrayList<>();
        String sql = "SELECT * FROM Vehicle";

        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Vehicle v = new Vehicle(
                        rs.getString("licensePlate"),
                        rs.getString("make"),
                        rs.getString("model"),
                        rs.getInt("year"),
                        rs.getInt("studentID"),
                        rs.getInt("employeeID"));
                list.add(v);
            }
        } return list;
    }
    public boolean removeVehicle(String licensePlate) {

        String checkPermitSQL = "SELECT COUNT(*) FROM VehiclePermit WHERE licensePlate = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement psCheck = conn.prepareStatement(checkPermitSQL)) {

            psCheck.setString(1, licensePlate);
            ResultSet rs = psCheck.executeQuery();

            if (rs.next() && rs.getInt(1) > 0) {
                System.out.println("Cannot remove vehicle. It has active permits. Remove the permit(s) first.");
                return false;
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

        String deleteVehicleSQL = "DELETE FROM Vehicle WHERE licensePlate = ?";

        try (Connection conn = DBConnection.getConnection()) {
            conn.setAutoCommit(false);

            try (PreparedStatement psVehicle = conn.prepareStatement(deleteVehicleSQL)) {

                psVehicle.setString(1, licensePlate);
                int affected = psVehicle.executeUpdate();

                conn.commit();
                return affected > 0;

            } catch (SQLException e) {
                conn.rollback();
                e.printStackTrace();
                return false;
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
