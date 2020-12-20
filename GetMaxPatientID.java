package JDBC;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class GetMaxPatientID {





	//public class JDBC {
		
		//public class JDBCExample {
			
			//STEP 1. Import required packages
			//	import java.sql.*;
		//	public class JDBC_Connector_Lab {
				

				//public class FirstExample {
				   // JDBC driver name and database URL
				   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
				   static final String DB_URL = "jdbc:mysql://localhost/EMR";

				      //  Database credentials
				      static final String USER = "root";
				      static final String PASS = "root";
				      
				    
				 //     public int getPatientCount() {
				         	  
				    	  public static void main(String[] args){  
				    		  String name =" " ; 
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
				         ResultSet rs = stmt.executeQuery(sql);
				         //STEP 5: Extract data from result set
				         while(rs.next()){
				        	  name = rs.getString(1);
				        	 System.out.println(name);
				         
				        	 
				         }
				       String sql1 =" delete from patient where Patient_ID= " + name; 
				        rs = stmt.executeQuery(sql1);
				            //Retrieve by column name
				        
				        	//	while (rs.next()) {
				         
				            		        	  
				        	
				        //	 }   
				        		      
				        		         
				        		//         int Patient_ID = rs.getInt(1);
				        		 //        return  Patient_ID;
				     //    }       
				    //     System.out.println(" max_Patient_ID : " + Patient_ID );
				        		         
				        		         
				     			//		String Name = rs.getString("Name");
				     					
				     				//	Patient p =new Patient( Patient_ID);
				     					
				     					// Display values
				     				//	System.out.print("Patient_ID: " + Patient_ID);
				     				//	System.out.print(", Name: " + Name);

				     			//		Patient_ID.Count( p);
				     					
				     	//			}
				     					//for (int i = 1; i < patient.size(); i++) {
				     						
				     					
				     					

				     			//	System.out.println(" Name t: " + patient.get(i).getName());
				     		//			}	
//			            String Patient_ID = rs.getString("Patient_ID");
//				            String Address = rs.getString("Address");
//				            String Dat_of_Birth = rs.getString("Dat_of_Birth");
//				            String Gender = rs.getString("Gender");
//
//				            //Display values
//				            System.out.print("Patient_ID: " + Patient_ID);
//				            System.out.print(", Address: " + Address);
//				            System.out.print(", Date_of_Birth: " + Dat_of_Birth);
//				            System.out.println(", Gender: " + Gender);
				      				      		         
				         rs.close();
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
				//	return 0;
				   }//end main
				   }//end JDBCExample







