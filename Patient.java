package JDBC;

import java.lang.reflect.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Patient implements Comparable<Patient> {

	private String Name;
	private String Patient_ID;
	private String Address;
	private String City;
	private String State;
	private String Zip_Code;
	private String Date_of_Birth;
	private String Gender;
	private String Social_security_Number;
	private String Marital_Status;
	private String Phone;
	private String Insurance_Provider;

	// public static void main(String[] args)
	{
		//Patient s = new Patient();

//		System.out.println("Patient Name: " + s.getName());
//		System.out.println("Patient_ID: " + s.getPatient_ID());

//	}


	
	
	

		Name = "Lan Nguyen";

		Patient_ID = "ID-000-127";

	}

	public Patient(String Patient_ID, String Name, String Address, String City, String State, String Zip_Code, String Date_of_Birth, String Gender, String Social_security_Number, String Marital_Status, String Phone, String Insurance_Provider) {
		
		this.Patient_ID = Patient_ID;
		this.Name = Name;
		this.Address = Address;
		this.City = City;
		this.State = State;
		this.Zip_Code = Zip_Code;
		this.Date_of_Birth = Date_of_Birth;
		this.Gender = Gender;
		this.Social_security_Number = Social_security_Number;
		this.Marital_Status = Marital_Status;
		this.Phone = Phone;
		this.Insurance_Provider = Insurance_Provider;
		
		
		
		
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public String getCity() {
		return City;
	}

	public void setCity(String city) {
		City = city;
	}

	public String getState() {
		return State;
	}

	public void setState(String state) {
		State = state;
	}

	public String getZip_Code() {
		return Zip_Code;
	}

	public void setZip_Code(String zip_Code) {
		Zip_Code = zip_Code;
	}

	public String getDate_of_Birth() {
		return Date_of_Birth;
	}

	public void setDate_of_Birth(String date_of_Birth) {
		Date_of_Birth = date_of_Birth;
	}

	public String getGender() {
		return Gender;
	}

	public void setGender(String gender) {
		Gender = gender;
	}

	public String getSocial_security_Number() {
		return Social_security_Number;
	}

	public void setSocial_security_Number(String social_security_Number) {
		Social_security_Number = social_security_Number;
	}

	public String getMarital_Status() {
		return Marital_Status;
	}

	public void setMarital_Status(String marital_Status) {
		Marital_Status = marital_Status;
	}

	public String getPhone() {
		return Phone;
	}

	public void setPhone(String phone) {
		Phone = phone;
	}

	public String getInsurance_Provider() {
		return Insurance_Provider;
	}

	public void setInsurance_Provider(String insurance_Provider) {
		Insurance_Provider = insurance_Provider;
	}

	public String getName() {
		return Name;
	}

	public void setName(String Name) {
		this.Name = Name;
	}

	public String getPatient_ID() {
		return Patient_ID;
	}

	public void setPatient_ID(String Patient_ID) {
		this.Patient_ID = Patient_ID;
	}

	public String toString() {
        return "[id=" + this.Patient_ID + ", name=" + this.Name +  "]";
    }
	
	
	
	// public class JDBCExample {

	// STEP 1. Import required packages
	// import java.sql.*;
	// public class JDBC_Connector_Lab {

	// public class FirstExample {
	// JDBC driver name and database URL
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/EMR";

	// Database credentials
	static final String USER = "root";
	static final String PASS = "root";

	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		try {
			// STEP 2: Register JDBC driver
			Class.forName("com.mysql.jdbc.Driver");

			// STEP 3: Open a connection
			System.out.println("Connecting to a selected database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			System.out.println("Connected database successfully...");

			// STEP 4: Execute a query
			System.out.println("Creating statement...");
			stmt = conn.createStatement();

			String sql = "SELECT Patient_ID, Name FROM Patient";
			ResultSet rs = stmt.executeQuery(sql);
			// STEP 5: Extract data from result set

			ArrayList<Patient> patient = new ArrayList<Patient>();

			while (rs.next()) {
				// Retrieve by column name

				String Patient_ID = rs.getString("Patient_ID");
				String Name = rs.getString("Name");
				
				Patient p =new Patient(Name, Patient_ID, Name, Name, Name, Name, Name, Name, Name, Name, Name, Name);
				
				// Display values
			//	System.out.print("Patient_ID: " + Patient_ID);
			//	System.out.print(", Name: " + Name);

				patient.add( p);
				
			}
				for (int i = 1; i < patient.size(); i++) {
					
				
				

			System.out.println(" Name t: " + patient.get(i).getName());
				}	
			
			Collections.sort(patient);
			for(int i=0; i<patient.size(); i++)
		    System.out.println(patient.get(i));
			
			Collections.sort(patient, new PatientComparator());
			for(int j=0; j<patient.size(); j++)
		    System.out.println(patient.get(j).getPatient_ID());
			
			
			
			rs.close();
		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		} finally {
			// finally block used to close resources
			try {
				if (stmt != null)
					conn.close();
			} catch (SQLException se) {
			} // do nothing
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			} // end finally try
		} // end try
		System.out.println("Goodbye!");
		
		
		
	}// end main

	


	//@Override
	public int compareTo(Patient p) {
		// TODO Auto-generated method stub
		
		if ( getName().compareTo(p.Name)>0)
			
		return 1;
		else 
			if (getName().compareTo(p.Name)<0)
			return-1;
		else
			return 0;
	
	
		    }
//public class PatientIDComparator implements Comparator<GeometricObject>, java.io.serializable{
//	public int compare (GeometricObject p1, GeometricObject p2){
//		


//}




}// end JDBCExample




