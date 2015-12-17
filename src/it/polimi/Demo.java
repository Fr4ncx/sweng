package it.polimi;

import java.util.Date;

public class Demo {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Date d=new Date(2015-10-12);
		amministratore a1=new amministratore(-1,"Francesco","Tria","francesco.tria@ennova-research.com");
		progetto p=new progetto(5,"prova", "descrizione", d, a1);
		System.out.println(p.getStato());

	}

}
