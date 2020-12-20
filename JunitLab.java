package JDBC;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JunitLab {


	

		//STEP 1. Import required packages
		

		//public class JDBCExample {
		   // JDBC driver name and database URL
		   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
		   static final String DB_URL = "jdbc:mysql://localhost/EMR";

		   //  Database credentials
		   static final String USER = "root";
		   static final String PASS = "root";
		   
		   public static void main(String[] args) {
		   Connection conn = null;
		   Statement stmt = null;
		   try{
		      //STEP 2: Register JDBC driver
		      Class.forName("com.mysql.jdbc.Driver");

		      //STEP 3: Open a connection
		      System.out.println("Connecting to a selected database...");
		      conn = DriverManager.getConnection(DB_URL, USER, PASS);
		      System.out.println("Connected database successfully...");
		      
		      //STEP 4: Execute a query
		      System.out.println("Creating statement...");
		      stmt = conn.createStatement();
		      String sql = "SELECT max(Patient_ID) FROM patient;";
		      stmt.executeQuery(sql);

		      // Now you can extract all the records
		      // to see the remaining records
		      sql = "DELETE FROM patient " +
		                   "WHERE Patient_ID= StrMax";
		        stmt.executeUpdate(sql);

		   //   while(rs.next()){
		         //Retrieve by column name
		   // 	String  StrMax = rs.getString(1);
		    	
		        	// System.out.println(name);
//		         int id  = rs.getInt("id");
//		         int age = rs.getInt("age");
//		         String first = rs.getString("first");
		    //     String StrMax = rs.getString("last");
	//
//		         //Display values
//		         System.out.print("ID: " + id);
//		         System.out.print(", Age: " + age);
//		         System.out.print(", First: " + first);
//		         System.out.println(", Last: " + last);
		      
		     // rs.close();
		   }catch(SQLException se){
		      //Handle errors for JDBC
		      se.printStackTrace();
		   }catch(Exception e){
		      //Handle errors for Class.forName
		      e.printStackTrace();
		   }finally{
		      //finally block used to close resources
		      try{
		         if(stmt!=null)
		            conn.close();
		      }catch(SQLException se){
		      }// do nothing
		      try{
		         if(conn!=null)
		            conn.close();
		      }catch(SQLException se){
		         se.printStackTrace();
		      }//end finally try
		   }//end try
		   System.out.println("Goodbye!");
		}//end main
		}//end JDBCExample

