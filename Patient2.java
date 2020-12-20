package JDBC;

import java.util.Scanner;
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

public class Patient2 implements Comparable<Patient2> {

	private String Name;
	private String Patient_ID;
//	private static String Address;
//	private String City;
//	private String State;
//	private static String Zip_Code;
//	private static String Date_Of_Birth;
//	private String Gender;
//	private String Social_security_Number;
//	private static String Marital_Status;
//	private String Phone;
//	private String Insurance_Provider;

	// public static void main(String[] args)
	{
		// Patient s = new Patient();

		// System.out.println("Patient Name: " + s.getName());
		// System.out.println("Patient_ID: " + s.getPatient_ID());

		// }

		Name = "Lan Nguyen";

		Patient_ID = "ID-000-127";

	}

	public Patient2(String Patient_ID, String Name, String Address, String City, String State, String Zip_Code,
			String Date_Of_Birth, String Gender, String Social_security_Number, String Marial_Status, String Phone,
			String Insurance_Provider) {
		this.Patient_ID = Patient_ID;
		this.Name = Name;
//		this.Address = Address;
//		this.City = City;
//		this.State = State;
//		this.Zip_Code = Zip_Code;
//		this.Date_Of_Birth = Date_Of_Birth;
//		this.Gender = Gender;
//		this.Social_security_Number = Social_security_Number;
//		this.Marital_Status = Marial_Status;
//		this.Phone = Phone;
//		this.Insurance_Provider = Insurance_Provider;

	}

	public Patient2(String patient_ID2, String name2) {
		// TODO Auto-generated constructor stub
	}

	public String getPatient_ID() {
		return Patient_ID;
	}

	public void setPatient_ID(String Patient_ID) {
		this.Patient_ID = Patient_ID;
	}

	public String getName() {
		return Name;
	}

	public void setName(String Name) {
		this.Name = Name;
	}

	/*public String getAddress() {
		return Address;
	}

	public void setAddress(String Address) {
		this.Address = Address;
	}

	public String getCity() {
		return City;
	}

	public void setCity(String City) {
		this.City = City;
	}

	public String getState() {
		return State;
	}

	public void setState(String State) {
		this.State = State;
	}

	public String getZip_Code() {
		return Zip_Code;
	}

	public void setZip_Code(String Zip_Code) {
		this.Zip_Code = Zip_Code;
	}

	public String getDate_Of_Birth() {
		return Date_Of_Birth;
	}

	public void setDate_Of_Birth(String Dat_Of_Birth) {
		this.Date_Of_Birth = Dat_Of_Birth;
	}

	public String getGender() {
		return Gender;
	}

	public void setGender(String Gender) {
		this.Gender = Gender;
	}

	public String getSocial_security_Number() {
		return Social_security_Number;
	}

	public void setSocial_security_Number(String Social_security_Number) {
		this.Social_security_Number = Social_security_Number;
	}

	public String getMarital_Status() {
		return Marital_Status;
	}

	public void setMarital_Status(String Marial_Status) {
		this.Marital_Status = Marial_Status;
	}

	public String getPhone() {
		return Phone;
	}

	public void setPhone(String Phone) {
		this.Phone = Phone;
	}

	public String getInsurance_Provider() {
		return Insurance_Provider;
	}

	public void setInsurance_Provider(String Insurance_Provider) {
		this.Insurance_Provider = Insurance_Provider;
	}*/
	// +Name+Address+Dat_Of_Birth+
	// Gender+Social_security_Number+Marial_Status+Phone+Insurance_Provider);

	/*public String toString1() {
		return "[PatientID:" + this.Patient_ID + "  ,Name:" + this.Name  + "  ,Address:" + this.Address + "  ,City:"
				+ this.City + "  ,State:" + this.State + "  ,Zip_Code:" + this.Zip_Code + "  ,DOB:" + this.Date_Of_Birth
				+ "  ,Gender:" + this.Gender + "  ,SS#:" + this.Social_security_Number + "  ,Marital Status:"
				+ this.Marital_Status + "  ,Phone:" + this.Phone + "  ,Insurance:" + this.Insurance_Provider + "]";
	}*/

	public String toString() {
		return "[PatientID=" + this.Patient_ID + ", Name=" + this.Name + "]";
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
			System.out.println("xConnected database successfully...");

			// STEP 4: Execute a query
			System.out.println("Creating statement...");
			stmt = conn.createStatement();

			String sql = "SELECT Patient_ID,Name/*,Address,City,State,Zip_Code,Date_Of_Birth,Gender,Social_security_Number,Marital_Status,Phone,Insurance_Provider*/ FROM Patient";
			ResultSet rs = stmt.executeQuery(sql);
			// STEP 5: Extract data from result set

			ArrayList<Patient> patient = new ArrayList<Patient>();

			while (rs.next()) {
				// Retrieve by column name

				String Patient_ID = rs.getString("Patient_ID");
				String Name = rs.getString("Name");
//				String Address = rs.getString("Address");
//				String City = rs.getString("City");
//				String State = rs.getString("State");
//				String Zipe_Code = rs.getString("Zip_Code");
//				String Dat_Of_Birth = rs.getString("Date_Of_Birth");
//				String Gender = rs.getString("Gender");
//				String Social_security_Number = rs.getString("Social_security_Number");
//				String Marial_Status = rs.getString("Marital_Status");
//				String Phone = rs.getString("Phone");
//				String Insurance_Provider = rs.getString("Insurance_Provider");

				 Patient p = new Patient(Name, Patient_ID, Name, Name, Name, Name, Name, Name, Name, Name, Name, Name);
				Patient2 p2 = new Patient2(Patient_ID, Name);
				// Display values

				System.out.print(p);

				 System.out.print("Patient_ID:\n"+ Patient_ID);
			//	 System.out.print("Name:\n"+ Name);
			//	 System.out.print("Address: " + Address);

				 patient.add(p);

				for (int i = 1; i < patient.size(); i++) {
				}

				Scanner input = new Scanner(System.in);
				System.out.println(" Enter insert or  delete or update from patient table  : ");
				String StrInput = input.nextLine();
				int input1 = 3;
		        String inputString;
		        switch (StrInput ) {
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
		            	Patient2 p21 = new Patient2(Name, Patient_ID);
		            	 System.out.println(p21);    
				 System.out.println("Enter Patient_ID would you like to update? Starting with ID-000-");
				 String StrUpdate = input.nextLine();
				 System.out.println(" Update Patient...");
				 stmt = conn.createStatement();
			      String sql1 = "UPDATE patient " +
			                   "SET Address = '2228 S 62st ' WHERE Patient_ID='" + StrUpdate+ "'";
			      stmt.executeUpdate(sql1);

break;
		            case "insert":
				// Insert Patient

				
				
				System.out. println(" Enter the Patient ID start with ID_000_ : ");
				  String Patient_ID1 = input.nextLine();
				  
				  System.out.println(" Enter the Patient Name : "); 
				  String Name1  = input.nextLine();
				  
				  System.out.println(" Enter the Patient Address : "); 
				  String  Address1 = input.nextLine();
				  System.out.println(" Enter the Patient City : "); 
				  String City1  = input.nextLine();
				  System.out.println(" Enter the Patient State : "); 
				  String State1 = input.nextLine();
				  System.out.println(" Enter the Patient Zip_Code : "); 
				  String  Zip_Code = input.nextLine();
				  
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
				  
				  System.out.println("Inserting  New Patient into the table..."
				  ); stmt = conn.createStatement();
				  
				  String sql11 = "INSERT INTO patient " +
				  "VALUES ('"+Patient_ID1+" ','"+ Name1 +" ','"+ Address1+" ','"+
				  City1+" ','"+State1+" ','"+Zip_Code+" ','"+Dat_Of_Birth1
				  +" ','"+ Gender1+" ','"+ Social_security_Number1 +" ','"+
				  Marial_Status1+" ','"+ Phone1 +" ','"+
				  Insurance_Provider1+"' )";
				  
				  System.out.println(sql11); stmt.executeUpdate(sql11);
				  System.out.println("Inserted records into the table...");
				  break;
		        }	 
				// System.out.println(" Name t: " + patient.get(i).getName());
			}

			Collections.sort(patient);
			for (int i = 0; i < patient.size(); i++)
				// System.out.println(patient.get(i));

				Collections.sort(patient, new PatientComparator());
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
		System.out.println("Goodbye!");

	}// end main

	// @Override
	public int compareTo(Patient2 p) {
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

	////
	// }

}// end JDBCExample
