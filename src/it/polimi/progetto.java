package it.polimi;
import java.util.Date;
import java.util.Vector;

public class progetto {
	private Integer id;
	private String nome;
	private String descrizione;
	private amministratore amministratore;
	private Vector<utente> utente;
	private Vector<attivit�> attivit�;
	private boolean stato;
	private Date data;
	
	/*
	 * Costruttore
	 */
	
	/*progetto(Integer id,String nome,String descrizione,Date data,amministratore amministratore){*/
	progetto(Integer id,String nome){	
		this.id=id;
		this.nome=nome;
		/*this.descrizione=descrizione;
		this.amministratore=amministratore;
		this.attivit�=null;
		this.stato=false;
		this.data=data;*/
	}
	
	/* Funzione per startare il progetto
	 * 
	*/
	public void startProject(){
		if(attivit�.size()>0)
			this.stato=true;
	}
	/*
	 * Get stato attuale (true,false)
	 */
	public boolean getStato(){
		return this.stato;
	}
	public String getNome(){
		return this.nome;
	}
	
	/*
	 * Get attivit�
	 */
	public Vector<attivit�> getAttivit�(){		
		return this.attivit�;
	}
	
	/* Aggiunta utente
	 * 
	 */
	public void addUtente(Vector<utente> utente){
		this.utente=utente;
	}
	
}
