package service;

import java.util.*;
import  java.sql.*;
import crud.VehiclePermitCRUD;
import crud.views.VehiclePermitInfoCRUD;
import model.VehiclePermit;
import model.views.VehiclePermitInfo;

public class VehiclePermitService {
    private final VehiclePermitCRUD crud = new VehiclePermitCRUD();
    private final VehiclePermitInfoCRUD viewCrud = new VehiclePermitInfoCRUD();

    public void addVehiclePermit(VehiclePermit vp) throws SQLException {
        crud.insert(vp);
    }
    public List<VehiclePermitInfo> getAll() throws SQLException {
        return viewCrud.getAll();
    }
    public void removeVehiclePermit(int vpID) throws SQLException {
        crud.remove(vpID);
    }
    public void updateVehiclePermit(int vpID, int newVpID) throws SQLException {
        crud.update(vpID, newVpID);
    }
}
