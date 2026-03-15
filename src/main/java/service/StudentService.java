package service;
import crud.StudentCRUD;
import model.Student;

import java.sql.*;
import java.util.*;

public class StudentService {
    private final StudentCRUD crud = new StudentCRUD();

    public void addStudent(Student s) {
        crud.insert(s);
    }
    public List<model.Student> getAllStudents() throws SQLException {
        return crud.getAll();
    }
    public void removeStudent(int studentID) throws SQLException {
        crud.remove(studentID);
    }
    public void updatePhoneNumber(int studentID, String newPhoneNumber) throws SQLException {
        crud.updatePhoneNumber(studentID, newPhoneNumber);
    }
    public void updateEmail(int studentID, String newEmail) throws SQLException {
        crud.updateEmail(studentID, newEmail);
    }
}