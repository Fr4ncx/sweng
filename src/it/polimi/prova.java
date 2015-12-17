package it.polimi;

public class prova {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Database db = new Database();
		db.connect();
		int id=1;
		if(db.getProject(id).size()>0){
			
		}
	}

}
