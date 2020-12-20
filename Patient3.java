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
import java.util.Scanner;

public class Patient3 implements Comparable<Patient3> {

	private static String Name;
	private static String Patient_ID;

	// public static void main(String[] args)
	{
		// Patient s = new Patient();

		// System.out.println("Patient Name: " + s.getName());
		// System.out.println("Patient_ID: " + s.getPatient_ID());

		// }

		Name = "Lan Nguyen";

		Patient_ID = "ID-000-127";

	}

	public Patient3(String Name, String Patient_ID) {
		this.Name = Name;
		this.Patient_ID = Patient_ID;

	}

	public String getName() {
		return Name;
	}

	public void setName(String Name) {
		this.Name = Name;
	}

	public static String getPatient_ID() {
		return Patient_ID;
	}

	public void setPatient_ID(String Patient_ID) {
		this.Patient_ID = Patient_ID;
	}

	public String toString() {
		return "[id=" + this.Patient_ID + ", name=" + this.Name + "]";
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
			System.out.println("Patient_ID    Name ");
			while (rs.next()) {
				// Retrieve by column name

				String Patient_ID = rs.getString("Patient_ID");
				String Name = rs.getString("Name");

				Patient3 p = new Patient3(Name, Patient_ID);

				// Display values
				System.out.println(Patient_ID + "   " + Name);

				// patient.add( p);

			}
			for (int i = 1; i < patient.size(); i++) {

				// System.out.println( getPatient_ID() +
				// patient.get(i).getName() );
			}

			Patient3 p = new Patient3(Name, Patient_ID);
			Patient2 p2 = new Patient2(Patient_ID, Name);
			// Display values

			// System.out.print(p);

			System.out.print(Patient_ID);
			System.out.print("Name:\n" + Name);
			// System.out.print("Address: " + Address);

			// patient.add(p);

			for (int i = 1; i < patient.size(); i++) {
			}

			Scanner input = new Scanner(System.in);
			System.out.println(" Enter insert or  delete or update from patient table  : ");
			String StrInput = input.nextLine();
			int input1 = 3;
			String inputString;
			switch (StrInput) {
			case "delete":
				Patient2 p1 = new Patient2(Name, Patient_ID);
				System.out.println(p1);
				// Delete patient
				System.out.println(" Enter the Patient ID would you like to delede start with ID_000_ : ");
				String StrInput1 = input.nextLine();

				System.out.println(" Delete Patient...");
				stmt = conn.createStatement();

				sql = "DELETE FROM patient " + "WHERE Patient_ID='" + StrInput1 + "'";
				System.out.println(sql);
				stmt.executeUpdate(sql);
				break;

			case "update":
				// Update Patient

				System.out.println("Enter Patient_ID would you like to update? Starting with ID-000-");
				String StrID = input.nextLine();

				System.out.println(" Enter the  updated Patient Name  or 0 to skip: ");
				String Strname = input.nextLine();

				System.out.println(" Enter the updated Address or  0 to skip: ");
				String StrAddress = input.nextLine();
				System.out.println(" Enter the updated City or 0 to skip : ");
				String StrCity = input.nextLine();
				System.out.println(" Enter the update State or 0 to skip : ");
				String StrState = input.nextLine();
				System.out.println(" Enter the updated Zip_Code or 0 to skip: ");
				String StrZCode = input.nextLine();

				System.out.println(" Enter the update DOB or 0 to skip : ");
				String StrDOB = input.nextLine();

				System.out.println(" Enter the updated Gender or 0 to skip: ");
				String StrGender = input.nextLine();

				System.out.println(" Enter the updated SS#  or 0 to skip: ");
				String StrSSN = input.nextLine();

				System.out.println(" Enter the updated Marital Status or 0 to skip : ");
				String StrMS = input.nextLine();

				System.out.println(" Enter the updated Phone# or 0 to skip: ");
				String StrPhone = input.nextLine();

				System.out.println(" Enter the updated Insurant or 0 to skip : ");
				String StrIns = input.nextLine();

				
				
			

															System.out.println("in the else block");
															stmt = conn.createStatement();
															
															
															
														 sql = "UPDATE patient "  + " SET " ;
															if( Strname.length()!= 0){
															    sql += " Name = '"+ Strname + "'," ; 
															}
															if(StrAddress.length()!=0 ){
															    sql += " Address = '" + StrAddress + "'," ;
															}
															if(StrCity.length()!=0 ){
															    sql+= " City = '" + StrCity + "'," ;
															}
															if(StrState.length()!=0 ){
															    sql += " State = '" + StrState + "'," ;
															}

															if(StrZCode.length()!=0 ){
															    sql += " Zip_Code ='" + StrZCode + "',"; 
															}
															if(StrDOB.length()!=0 ){
															    sql += " Date_of_Birth ='" + StrDOB + "',"; 
															}
															if(StrGender.length()!=0 ){
															    sql += " Gender ='" + StrGender + "',"; 
															}
															if(StrSSN.length()!=0 ){
															    sql += " Social_security_Number ='" + StrSSN + "',"; 
															}
															if(StrMS.length()!=0 ){
															    sql += " Marital_Status ='" + StrMS + "',"; 
															}
															if(StrPhone.length()!=0 ){
															    sql += " Phone ='" + StrPhone + "',"; 
															}
															if(StrIns.length()!=0 ){
															    sql += " Insurance_Provider ='" + StrIns + "'"; 
															}
															
															
															sql += " WHERE  Patient_ID ='" + StrID + "'";
															
														
														
				System.out.println(sql);
				stmt.executeUpdate(sql);

				System.out.println("Update records into the table...");

				break;

			case "insert":
				// Insert Patient

				System.out.println(" Enter the Patient ID start with ID_000_ : ");
				String Patient_ID1 = input.nextLine();

				System.out.println(" Enter the Patient Name : ");
				String Name1 = input.nextLine();

				System.out.println(" Enter the Patient Address : ");
				String Address1 = input.nextLine();
				System.out.println(" Enter the Patient City : ");
				String City1 = input.nextLine();
				System.out.println(" Enter the Patient State : ");
				String State1 = input.nextLine();
				System.out.println(" Enter the Patient Zip_Code : ");
				String Zip_Code = input.nextLine();

				System.out.println(" Enter the Patient DOB : ");
				String Dat_Of_Birth1 = input.nextLine();

				System.out.println(" Enter the Patient Gender : ");
				String Gender1 = input.nextLine();

				System.out.println(" Enter the Patient SS# : ");
				String Social_security_Number1 = input.nextLine();

				System.out.println(" Enter the Patient Marital Status : ");
				String Marial_Status1 = input.nextLine();

				System.out.println(" Enter the Patient Phone# : ");
				String Phone1 = input.nextLine();

				System.out.println(" Enter the Patient Insurant : ");
				String Insurance_Provider1 = input.nextLine();

				System.out.println("Inserting  New Patient into the table...");
				stmt = conn.createStatement();

				String sql11 = "INSERT INTO patient " + "VALUES ('" + Patient_ID1 + " ','" + Name1 + " ','" + Address1
						+ " ','" + City1 + " ','" + State1 + " ','" + Zip_Code + " ','" + Dat_Of_Birth1 + " ','"
						+ Gender1 + " ','" + Social_security_Number1 + " ','" + Marial_Status1 + " ','" + Phone1
						+ " ','" + Insurance_Provider1 + "' )";

				System.out.println(sql11);
				stmt.executeUpdate(sql11);
				System.out.println("Inserted records into the table...");
				break;
			}

			Collections.sort(patient);
			for (int i = 0; i < patient.size(); i++)
				// System.out.println(patient.get(i));

				// Collections.sort(patient, new PatientComparator());
				for (int j = 0; j < patient.size(); j++)
					// System.out.println(patient.get(j).getPatient_ID());

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
			// System.out.println("Goodbye!");

	}// end main

	// @Override
	public int compareTo(Patient3 p) {
		// TODO Auto-generated method stub

		if (getName().compareTo(p.Name) > 0)

			return 1;
		else if (getName().compareTo(p.Name) < 0)
			return -1;
		else
			return 0;

	}
	// public class PatientIDComparator implements Comparator<GeometricObject>,
	// java.io.serializable{
	// public int compare (GeometricObject p1, GeometricObject p2){
	//

	// }

}// end JDBCExample
