package com.dao;

import com.model.Patient;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HospitalDAO {

    private String jdbcURL =
    "jdbc:mysql://localhost:3306/HospitalDB?useSSL=false&serverTimezone=UTC";

    private String jdbcUsername = "root";

    private String jdbcPassword = "password";

    private Connection connection;

    // DATABASE CONNECTION

    public HospitalDAO() {

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            connection = DriverManager.getConnection(
                    jdbcURL,
                    jdbcUsername,
                    jdbcPassword
            );

            System.out.println("Database Connected Successfully!");

        }
        catch (Exception e) {

            System.out.println("Database Connection Error");

            e.printStackTrace();
        }
    }

    // GET NEXT PATIENT ID

    public int getNextPatientId() {

        if (connection == null)
            return 1;

        int nextId = 1;

        try {

            String sql =
            "SELECT COALESCE(MAX(PatientID),0)+1 FROM Patients";

            Statement stmt =
            connection.createStatement();

            ResultSet rs =
            stmt.executeQuery(sql);

            if (rs.next()) {

                nextId = rs.getInt(1);
            }

        }
        catch (SQLException e) {

            e.printStackTrace();
        }

        return nextId;
    }

    // ADD PATIENT

    public boolean addPatient(Patient patient) {

        if (connection == null)
            return false;

        boolean status = false;

        try {

            String sql =
            "INSERT INTO Patients " +
            "(PatientName, Age, Gender, AdmissionDate, Ailment, AssignedDoctor) " +
            "VALUES (?, ?, ?, ?, ?, ?)";

            PreparedStatement stmt =
            connection.prepareStatement(
                    sql,
                    Statement.RETURN_GENERATED_KEYS
            );

            stmt.setString(1,
                    patient.getPatientName());

            stmt.setInt(2,
                    patient.getAge());

            stmt.setString(3,
                    patient.getGender());

            stmt.setDate(4,
                    patient.getAdmissionDate());

            stmt.setString(5,
                    patient.getAilment());

            stmt.setString(6,
                    patient.getAssignedDoctor());

            int rows =
            stmt.executeUpdate();

            if (rows > 0) {

                ResultSet rs =
                stmt.getGeneratedKeys();

                if (rs.next()) {

                    patient.setPatientID(
                            rs.getInt(1));
                }

                status = true;
            }

        }
        catch (SQLException e) {

            System.out.println("Add Patient Error");

            e.printStackTrace();
        }

        return status;
    }

    // UPDATE PATIENT

    public boolean updatePatient(Patient patient) {

        if (connection == null)
            return false;

        boolean status = false;

        try {

            String sql =
            "UPDATE Patients SET " +
            "PatientName=?, " +
            "Age=?, " +
            "Gender=?, " +
            "AdmissionDate=?, " +
            "Ailment=?, " +
            "AssignedDoctor=? " +
            "WHERE PatientID=?";

            PreparedStatement stmt =
            connection.prepareStatement(sql);

            stmt.setString(1,
                    patient.getPatientName());

            stmt.setInt(2,
                    patient.getAge());

            stmt.setString(3,
                    patient.getGender());

            stmt.setDate(4,
                    patient.getAdmissionDate());

            stmt.setString(5,
                    patient.getAilment());

            stmt.setString(6,
                    patient.getAssignedDoctor());

            stmt.setInt(7,
                    patient.getPatientID());

            status =
            stmt.executeUpdate() > 0;

        }
        catch (SQLException e) {

            System.out.println("Update Error");

            e.printStackTrace();
        }

        return status;
    }

    // DELETE PATIENT

    public boolean deletePatient(int patientID) {

        if (connection == null)
            return false;

        boolean status = false;

        try {

            String sql =
            "DELETE FROM Patients WHERE PatientID=?";

            PreparedStatement stmt =
            connection.prepareStatement(sql);

            stmt.setInt(1, patientID);

            status =
            stmt.executeUpdate() > 0;

        }
        catch (SQLException e) {

            System.out.println("Delete Error");

            e.printStackTrace();
        }

        return status;
    }

    // DISPLAY ALL PATIENTS

    public List<Patient> getAllPatients() {

        List<Patient> patients =
        new ArrayList<>();

        if (connection == null)
            return patients;

        try {

            String sql =
            "SELECT * FROM Patients ORDER BY PatientID";

            Statement stmt =
            connection.createStatement();

            ResultSet rs =
            stmt.executeQuery(sql);

            while (rs.next()) {

                Patient patient =
                new Patient();

                patient.setPatientID(
                        rs.getInt("PatientID"));

                patient.setPatientName(
                        rs.getString("PatientName"));

                patient.setAge(
                        rs.getInt("Age"));

                patient.setGender(
                        rs.getString("Gender"));

                patient.setAdmissionDate(
                        rs.getDate("AdmissionDate"));

                patient.setAilment(
                        rs.getString("Ailment"));

                patient.setAssignedDoctor(
                        rs.getString("AssignedDoctor"));

                patients.add(patient);
            }

        }
        catch (SQLException e) {

            System.out.println("Display Error");

            e.printStackTrace();
        }

        return patients;
    }

    // GET PATIENT BY ID

    public Patient getPatientById(int patientID) {

        if (connection == null)
            return null;

        Patient patient = null;

        try {

            String sql =
            "SELECT * FROM Patients WHERE PatientID=?";

            PreparedStatement stmt =
            connection.prepareStatement(sql);

            stmt.setInt(1, patientID);

            ResultSet rs =
            stmt.executeQuery();

            if (rs.next()) {

                patient = new Patient();

                patient.setPatientID(
                        rs.getInt("PatientID"));

                patient.setPatientName(
                        rs.getString("PatientName"));

                patient.setAge(
                        rs.getInt("Age"));

                patient.setGender(
                        rs.getString("Gender"));

                patient.setAdmissionDate(
                        rs.getDate("AdmissionDate"));

                patient.setAilment(
                        rs.getString("Ailment"));

                patient.setAssignedDoctor(
                        rs.getString("AssignedDoctor"));
            }

        }
        catch (SQLException e) {

            System.out.println("Search Error");

            e.printStackTrace();
        }

        return patient;
    }

    // REPORT BY DATE RANGE

    public List<Patient> getPatientByDateRange(
            String startDate,
            String endDate) {

        List<Patient> patients =
        new ArrayList<>();

        try {

            String sql =
            "SELECT * FROM Patients " +
            "WHERE AdmissionDate BETWEEN ? AND ?";

            PreparedStatement stmt =
            connection.prepareStatement(sql);

            stmt.setDate(1,
                    Date.valueOf(startDate));

            stmt.setDate(2,
                    Date.valueOf(endDate));

            ResultSet rs =
            stmt.executeQuery();

            while (rs.next()) {

                Patient patient =
                new Patient();

                patient.setPatientID(
                        rs.getInt("PatientID"));

                patient.setPatientName(
                        rs.getString("PatientName"));

                patient.setAge(
                        rs.getInt("Age"));

                patient.setGender(
                        rs.getString("Gender"));

                patient.setAdmissionDate(
                        rs.getDate("AdmissionDate"));

                patient.setAilment(
                        rs.getString("Ailment"));

                patient.setAssignedDoctor(
                        rs.getString("AssignedDoctor"));

                patients.add(patient);
            }

        }
        catch (SQLException e) {

            e.printStackTrace();
        }

        return patients;
    }

    // REPORT BY AILMENT

    public List<Patient> getPatientByAilment(
            String ailment) {

        List<Patient> patients =
        new ArrayList<>();

        try {

            String sql =
            "SELECT * FROM Patients " +
            "WHERE LOWER(Ailment)=LOWER(?)";

            PreparedStatement stmt =
            connection.prepareStatement(sql);

            stmt.setString(1, ailment);

            ResultSet rs =
            stmt.executeQuery();

            while (rs.next()) {

                Patient patient =
                new Patient();

                patient.setPatientID(
                        rs.getInt("PatientID"));

                patient.setPatientName(
                        rs.getString("PatientName"));

                patient.setAge(
                        rs.getInt("Age"));

                patient.setGender(
                        rs.getString("Gender"));

                patient.setAdmissionDate(
                        rs.getDate("AdmissionDate"));

                patient.setAilment(
                        rs.getString("Ailment"));

                patient.setAssignedDoctor(
                        rs.getString("AssignedDoctor"));

                patients.add(patient);
            }

        }
        catch (SQLException e) {

            e.printStackTrace();
        }

        return patients;
    }

    // REPORT BY DOCTOR

    public List<Patient> getPatientByDoctor(
            String doctor) {

        List<Patient> patients =
        new ArrayList<>();

        try {

            String sql =
            "SELECT * FROM Patients " +
            "WHERE LOWER(AssignedDoctor)=LOWER(?)";

            PreparedStatement stmt =
            connection.prepareStatement(sql);

            stmt.setString(1, doctor);

            ResultSet rs =
            stmt.executeQuery();

            while (rs.next()) {

                Patient patient =
                new Patient();

                patient.setPatientID(
                        rs.getInt("PatientID"));

                patient.setPatientName(
                        rs.getString("PatientName"));

                patient.setAge(
                        rs.getInt("Age"));

                patient.setGender(
                        rs.getString("Gender"));

                patient.setAdmissionDate(
                        rs.getDate("AdmissionDate"));

                patient.setAilment(
                        rs.getString("Ailment"));

                patient.setAssignedDoctor(
                        rs.getString("AssignedDoctor"));

                patients.add(patient);
            }

        }
        catch (SQLException e) {

            e.printStackTrace();
        }

        return patients;
    }
}