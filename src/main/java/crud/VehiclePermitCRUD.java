package crud;

import db.DBConnection;
import model.VehiclePermit;

import java.util.*;
import java.sql.*;

public class VehiclePermitCRUD {
    public void insert(VehiclePermit vp) throws SQLException {
        String sql = "INSERT INTO VehiclePermit (permitID, licensePlate) VALUES (?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, vp.getPermitID());
            ps.setString(2, vp.getLicensePlate());

            ps.executeUpdate();
        }
    }
    public void remove(int vpID) throws SQLException {

        String sql = "DELETE FROM VehiclePermit WHERE vpID = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, vpID);
            ps.executeUpdate();
        }
    }
    public void update(int vpID, int newVpID) throws SQLException {
        String SQL = "UPDATE VehiclePermit SET vpID = ? WHERE vpID = ?";
        try (Connection conn = DBConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement(SQL)) {
            ps.setInt(1, newVpID);
            ps.setInt(2, vpID);
            ps.executeUpdate();
        }
    }

}