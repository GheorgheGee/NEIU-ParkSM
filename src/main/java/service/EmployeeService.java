package service;

import crud.EmployeeCRUD;
import model.Employee;
import java.sql.*;
import java.util.*;

public class EmployeeService {

    private final EmployeeCRUD crud = new EmployeeCRUD();

    public void addEmployee(Employee e) throws SQLException {
        crud.insert(e);
    }

    public List<Employee> getAllEmployee() throws SQLException {
        return crud.getAll();
    }

    public void removeEmployee(int employeeID) throws SQLException {
        crud.remove(employeeID);
    }

    public void updatePhoneNumber(int employeeID, String newPhoneNumber) throws SQLException {
        crud.updatePhoneNumber(employeeID, newPhoneNumber);
    }

    public void updateEmail(int employeeID, String newEmail) throws SQLException {
        crud.updateEmail(employeeID, newEmail);
    }
}