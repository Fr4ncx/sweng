package it.polimi;
import java.util.Date;
import java.util.Vector;

public class progetto {
	private Integer id;
	private String nome;
	private String descrizione;
	private amministratore amministratore;
	private Vector<utente> utenti;
	private Vector<attivit�> attivit�;
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
	 * Get attivit�
	 */
	public Vector<attivit�> getAttivit�(){		
		return this.attivit�;
	}
	
	/* Aggiunta/rimozione utente
	 * 
	 */
	public int addUtente(utente utente){
		//restituisce un codice di errore in caso di fallimento, 0 se l'inserimento � andato a buon fine
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
		//se l'indice all'interno del vector di quell'utente � -1 (ovvero non � presente) allora non cancella nulla
		//altrimenti cancella l'utente desiderato
		if (this.utenti.indexOf(utente)==-1){
			return 1;
		}else{
			this.utenti.remove(this.utenti.indexOf(utente));
			return 0;
		}
	}
	
	//aggiunta/rimozione attivit�
	public int addAttivit�(attivit� nuovaAttivit�){
		if (nuovaAttivit�!=null){
			if (this.attivit�.add(nuovaAttivit�)){
				return 0;
			}else{
				return 1;
			}
		}else{
			return 2;
		}
	}
	public int removeAttivit�(attivit� attivitaToRemove){
		if (this.attivit�.indexOf(attivitaToRemove)==-1){
			return 1;
		}else{
			this.attivit�.remove(this.attivit�.indexOf(attivitaToRemove));
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
