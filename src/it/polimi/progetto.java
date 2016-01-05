package it.polimi;
import java.util.Date;
import java.util.Vector;

public class progetto {
	private Integer id;
	private String nome;
	private String descrizione;
	private amministratore amministratore;
	private Vector<utente> utenti;
	private Vector<attività> attività;
	private String categoria;
	private boolean stato;
	private Date data;
	
	/*
	 * Costruttore
	 */
	
	/*progetto(Integer id,String nome,String descrizione,Date data,amministratore amministratore){*/
	progetto(Integer id,String nome,String descrizione,String categoria){	
		this.id=id;
		this.nome=nome;
		this.descrizione=descrizione;
		this.categoria=categoria;
		/*this.amministratore=amministratore;
		this.attività=null;
		this.stato=false;
		this.data=data;*/
	}
	
	/* Funzione per startare il progetto
	 * 
	*/
	public void startProject(){
		if(attività.size()>0)
			this.stato=true;
	}
	/*
	 * Get stato attuale (true,false)
	 */
	public boolean getStato(){
		return this.stato;
	}
	public Integer getId(){
		return this.id;
	}
	public String getNome(){
		return this.nome;
	}
	public String getDesc(){
		return this.descrizione;
	}
	public String getCat(){
		return this.categoria;
	}
	
	/*
	 * Get attività
	 */
	public Vector<attività> getAttività(){		
		return this.attività;
	}
	
	/* Aggiunta/rimozione utente
	 * 
	 */
	public int addUtente(utente utente){
		//restituisce un codice di errore in caso di fallimento, 0 se l'inserimento è andato a buon fine
		if (utente!=null){
			if (this.utenti.add(utente)){
				return 0;
			}else{
				return 2;
			}
		}else{
			return 1;
		}
	}
	public int removeUtente(utente utente){
		//se l'indice all'interno del vector di quell'utente è -1 (ovvero non è presente) allora non cancella nulla
		//altrimenti cancella l'utente desiderato
		if (this.utenti.indexOf(utente)==-1){
			return 1;
		}else{
			this.utenti.remove(this.utenti.indexOf(utente));
			return 0;
		}
	}
	
	//aggiunta/rimozione attività
	public int addAttività(attività nuovaAttività){
		if (nuovaAttività!=null){
			if (this.attività.add(nuovaAttività)){
				return 0;
			}else{
				return 1;
			}
		}else{
			return 2;
		}
	}
	public int removeAttività(attività attivitaToRemove){
		if (this.attività.indexOf(attivitaToRemove)==-1){
			return 1;
		}else{
			this.attività.remove(this.attività.indexOf(attivitaToRemove));
			return 0;
		}
	}
	public int setAdmin(utente adminToSet){
		//per settare l'admin, dev'essere presente nella lista degli utenti partecipanti al progetto
		if (this.utenti.indexOf(adminToSet)==-1){
			return 1;
		}else{
			if (this.amministratore.equals(adminToSet)){
				return 0;
			}else{
				return 2;
			}
		}
	}
	public void modifyNome(String nome){
		this.nome=nome;
	}
	
}
