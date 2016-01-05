package it.polimi;

import java.util.Date;
import java.util.Vector;

public class attività {
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
	attività(Integer id,String nome,Date data,String descrizione,Vector<utente> responsabili){
		this.id=id;
		this.nome=nome;
		this.data=data;
		this.descrizione=descrizione;
		this.responsabili=responsabili;
		this.completato=false;
	}
	public String getNome(){
		return this.nome;
	}
	public String getDescrizione(){
		return this.descrizione;
	}
	public String getTesto(){
		return this.testo;
	}
	public void setNome(String nome){
		this.nome=nome;
	}
	public void setTesto(String testo){
		this.testo=testo;
	}
	public void setDescrizione(String descrizione){
		this.descrizione=descrizione;
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
	
	/* attività completata (true,false)
	 * 
	*/
	public void setCompletato(){
		this.completato=true;
	}
}
