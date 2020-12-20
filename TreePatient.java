package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.TreeSet;

public class TreePatient {

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
					String Address = rs.getString("Address");
					String City = rs.getString("City");
					String State = rs.getString("State");
					String Zip_Code = rs.getString("Zip_Code");
					String Date_of_Birth = rs.getString("Date_of_Birth");
					String Gender = rs.getString("Gender");
					String Social_security_Number = rs.getString("Social_security_Number");
					String Marital_Status = rs.getString("Marital_Status");
					String Phone = rs.getString("Phone");
					String Insurance_Provider = rs.getString("Insurance_Provider");
					
					
					
					
					
					Patient p =new Patient(Patient_ID, Name, Address, City, State, Zip_Code, Date_of_Birth, Gender, Social_security_Number,Marital_Status, Phone,  Insurance_Provider);
					
					// Display values
				//	System.out.print("Patient_ID: " + Patient_ID);
				//	System.out.print(", Name: " + Name);

					patient.add( p);
					
				}
					//for (int i = 1; i < patient.size(); i++) {
						
					
					

			//	System.out.println(" Name t: " + patient.get(i).getName());
		//			}	
				
			//	Collections.sort(patient);
					TreeSet<Patient> treeSet= new TreeSet<Patient>(patient);
					
					for (Patient pa : treeSet)

			//	for(int i=0; i<patient.size(); i++)
			 //   System.out.println(patient.get(i));
				System.out.println(pa.getName());
				
				
					
					
					TreeSet<Patient> ID = new TreeSet<Patient>( new PatientComparator());
					
				//	Patient p =new Patient(Name, Patient_ID);
					
					
					for (Patient p1 : treeSet){
					ID.add( p1);
					}
						
					
					for (Patient p1 : ID){		
						System.out.println(p1.getPatient_ID());
						
					}
				
	
				
				
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

					
}


