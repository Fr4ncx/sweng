package it.polimi;
import java.sql.*;
import java.util.Date;
import java.util.Vector;


public class Database {
	
	Connection conn = null;
	Statement stmt = null;
	Vector<progetto> progetti=new Vector<progetto>();
	Vector<attività> att=new Vector<attività>();
	 private static Database instance = null;
	/**
	 * Method connect DB
	 */
	public static Database getInstance() {
	       if(instance == null) {
	          instance = new Database();
	       }
	       return instance;
	    }
	public Database(){
		
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		    conn =
		       DriverManager.getConnection("jdbc:mysql://localhost:3308/app?" +
		                                   "user=root&password=admin");
	
		    
	
		  
		} catch (SQLException ex) {
		    // handle any errors
		    /*System.out.println("SQLException: " + ex.getMessage());
		    System.out.println("SQLState: " + ex.getSQLState());
		    System.out.println("VendorError: " + ex.getErrorCode());*/
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
	}
	
	public ResultSet executeQ(String query){
		
		ResultSet rs = null;
		
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);
	     
		 } catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		 }	
		return rs;
	}
	
	
	/*
	 * Method to verify credentials
	 */
	public boolean verifyCredentials(String name,String password) throws SQLException{
		boolean exist=false;
		
			String sql;
			sql = "SELECT * FROM utente WHERE nome='"+name+"' AND password='"+password+"'";
			
			ResultSet rs = executeQ(sql);
			
			if(rs.next()){
				exist=true;
			}else{
				exist=false;
			}
      
			rs.close();
			stmt.close();
			
		
		return exist;
	}
	
	/**
	 * Method for projects
	 * @return Vector<progetto>
	 * @throws SQLException 
	 */
	
	public Vector<progetto> getProject() throws SQLException{
		 
			String sql;
			sql = "SELECT * FROM progetto";
			ResultSet rs = executeQ(sql);
			
			while(rs.next()){
				
	         //Retrieve by column name
	         Integer id  =(Integer) rs.getInt("id");
	         String nome = rs.getString("name");   
	         String desc = rs.getString("descrizione");
	         String cat = rs.getString("categoria");
	         progetto p = new progetto(id,nome,desc,cat);
	         progetti.add(p);
			}
			
			rs.close();
			stmt.close();
			
		
		 return progetti;	
	}
	
	/**
	 * Method for delete project
	 * @return void
	 * @throws SQLException 
	 */
	public void deleteProject(Integer idprog) throws SQLException{
		String sql = "DELETE FROM progetto WHERE id="+idprog;
		try {
			stmt = conn.createStatement();
			stmt.executeUpdate(sql);
		 } catch (SQLException e) {
		 }	
		stmt.close();	
	}
	
	
	/*
	 * End method projects
	 */
	
	/**
	 * Method for activities
	 * @return Vector<attività>
	 * @throws SQLException 
	 */
	
	public Vector<attività> getActivities(Integer idprog) throws SQLException{
		 
			String sql;
			sql = "SELECT * FROM attività WHERE idprogetto="+idprog;
			ResultSet rs = executeQ(sql);
			
			while(rs.next()){
				
	          /* Aggiungere attività al vector
	          p = new progetto(id,nome);
	         progetti.add(p);*/
			}
			
			rs.close();
			stmt.close();
			
		
		 return att;	
	}
	
	/*
	 * End method projects
	 */
	
}
