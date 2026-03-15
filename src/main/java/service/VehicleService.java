package service;
import crud.VehicleCRUD;
import model.Vehicle;

import java.sql.*;
import java.util.*;

public class VehicleService {
    private final VehicleCRUD crud = new VehicleCRUD();

    public void addVehicle(Vehicle v) throws SQLException {
        crud.insert(v);
    }
    public List<model.Vehicle> getAllVehicle() throws SQLException {
        return crud.getAll();
    }
    public boolean removeVehicle(String licensePlate ) throws SQLException {
        return crud.removeVehicle(licensePlate);
    }
}