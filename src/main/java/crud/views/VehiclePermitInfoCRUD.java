package crud.views;

import db.DBConnection;
import model.views.VehiclePermitInfo;
import java.sql.*;
import java.util.*;

public class VehiclePermitInfoCRUD {

    public List<VehiclePermitInfo> getAll() throws SQLException {
        List<VehiclePermitInfo> list = new ArrayList<>();

        String sql = "SELECT * FROM VehiclePermitInfo";

        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                VehiclePermitInfo vp = new VehiclePermitInfo();

                vp.setVpID(rs.getInt("vpID"));
                vp.setLicensePlate(rs.getString("licensePlate"));
                vp.setPermitType(rs.getString("permitType"));
                vp.setValidFrom(rs.getDate("validFrom"));
                vp.setValidTo(rs.getDate("validTo"));

                list.add(vp);
            }
        }

        return list;
    }
}
