package it.polimi;

import java.sql.SQLException;
import java.util.Vector;

public class prova {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		Database db = new Database();
		
		for(progetto prog : db.getProject()){
			System.out.println(prog.getNome());
		}
			
		
	}

}
