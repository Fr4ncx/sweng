package it.polimi;

import java.util.Date;
import java.util.Vector;

public class attivit� {
	private Integer id;
	private String nome;
	private Date data;
	private String descrizione;
	private String testo;
	private Vector<utente> responsabili;
	private boolean completato;
	
	/* Costruttore
	 * 
	*/
	attivit�(Integer id,String nome,Date data,String descrizione,Vector<utente> responsabili){
		this.id=id;
		this.nome=nome;
		this.data=data;
		this.descrizione=descrizione;
		this.responsabili=responsabili;
		this.completato=false;
	}
	
	/* GET/SET responsabili
	 * 
	*/
	
	public Vector<utente> getResponsabili(){
		return this.responsabili;
	}
	
	public void addResponsabili(Vector<utente> responsabili){
		for(utente responsabile : responsabili ){
			this.responsabili.add(responsabile);
		}
	}
	
	/* Allega testo
	 * 
	*/
	public void allegaTesto(String testo){
		this.testo=testo;
	}
	
	/* attivit� completata (true,false)
	 * 
	*/
	public void setCompletato(){
		this.completato=true;
	}
}
