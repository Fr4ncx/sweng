package it.polimi;
import java.sql.*;
import java.util.Vector;


public class Database {
	
	Connection conn = null;
	Statement stmt = null;
	public void connect(){
		
		
		try {
		    conn =
		       DriverManager.getConnection("jdbc:mysql://localhost/app?" +
		                                   "user=root&password=cocco");
	
		    // Do something with the Connection
	
		  
		} catch (SQLException ex) {
		    // handle any errors
		    System.out.println("SQLException: " + ex.getMessage());
		    System.out.println("SQLState: " + ex.getSQLState());
		    System.out.println("VendorError: " + ex.getErrorCode());
		}
	}
	
	public Vector<progetto> getProject(Integer id){
		 try {
			stmt = conn.createStatement();
			String sql;
			sql = "SELECT * FROM project";
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){
	         //Retrieve by column name
	         int id1  = rs.getInt("id");
	         int age = rs.getInt("age");
	         String first = rs.getString("first");
	         String last = rs.getString("last");

	         //Display values
	         System.out.print("ID: " + id1);
	      
			}
		      //STEP 6: Clean-up environment
			rs.close();
			stmt.close();
			conn.close();
		 } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		 }
		return null;
		

	}

	
}
