package dao;
import java.sql.*;
import model.Patient;

public class HospitalDAO {
	
	    Connection getConnection() throws Exception {
	        Class.forName("org.sqlite.JDBC");
	        return DriverManager.getConnection("jdbc:sqlite:hospital.db");
	    }

	    public void createTable() throws Exception {
	        Connection con = getConnection();
	        Statement st = con.createStatement();

	        st.execute("CREATE TABLE IF NOT EXISTS Patients (" +
	                "PatientID INTEGER PRIMARY KEY, " +
	                "PatientName TEXT, " +
	                "Age INTEGER, " +
	                "Gender TEXT, " +
	                "AdmissionDate TEXT, " +
	                "Ailment TEXT, " +
	                "AssignedDoctor TEXT)");

	        con.close();
	    }

	    public void addpatient(Patient p) throws Exception {
	        Connection con = getConnection();
	        PreparedStatement ps = con.prepareStatement(
	                "INSERT INTO Patients VALUES(?,?,?,?,?,?,?)");

	        ps.setInt(1, p.getPatientID());
	        ps.setString(2, p.getPatientName());
	        ps.setInt(3, p.getAge());
	        ps.setString(4, p.getGender());
	        ps.setString(5, p.getAdmissionDate());
	        ps.setString(6, p.getAilment());
	        ps.setString(7, p.getAssignedDoctor());

	        ps.executeUpdate();
	        con.close();
	    }
	    public ResultSet getAllPatients() throws Exception {
	        Connection con = getConnection();
	        Statement st = con.createStatement();
	        return st.executeQuery("SELECT * FROM Patients");
	    }
}
