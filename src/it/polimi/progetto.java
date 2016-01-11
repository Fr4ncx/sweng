package it.polimi;
import java.util.Date;
import java.util.Vector;

public class progetto {
	private Integer id;
	private String nome;
	private String descrizione;
	private amministratore amministratore;
	private Vector<utente> utenti;
	private Vector<attivit‡> attivit‡;
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
		this.attivit‡=null;
		this.stato=false;
		this.data=data;*/
	}
	
	/* Funzione per startare il progetto
	 * 
	*/
	public void startProject(){
		if(attivit‡.size()>0)
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
	 * Get attivit‡
	 */
	public Vector<attivit‡> getAttivit‡(){		
		return this.attivit‡;
	}
	
	/* Aggiunta/rimozione utente
	 * 
	 */
	public void addUtente(Vector<utente> Utentidaaggiungere){
		for (int k=0;k<Utentidaaggiungere.size();k++){
			if (this.utenti.indexOf(Utentidaaggiungere.get(k))!=-1){
				this.utenti.add(Utentidaaggiungere.get(k));
			}
		}
	}
	public int removeUtente(utente utente){
		//se l'indice all'interno del vector di quell'utente Ë -1 (ovvero non Ë presente) allora non cancella nulla
		//altrimenti cancella l'utente desiderato
		if (this.utenti.indexOf(utente)==-1){
			return 1;
		}else{
			this.utenti.remove(this.utenti.indexOf(utente));
			return 0;
		}
	}
	
	//aggiunta/rimozione attivit‡
	public int addAttivit‡(attivit‡ nuovaAttivit‡){
		if (nuovaAttivit‡!=null){
			if (this.attivit‡.add(nuovaAttivit‡)){
				return 0;
			}else{
				return 1;
			}
		}else{
			return 2;
		}
	}
	public int removeAttivit‡(attivit‡ attivitaToRemove){
		if (this.attivit‡.indexOf(attivitaToRemove)==-1){
			return 1;
		}else{
			this.attivit‡.remove(this.attivit‡.indexOf(attivitaToRemove));
			return 0;
		}
	}
	
	public int modifyAttivit‡(attivit‡ attivit‡DaModificare, String Titolo, String Descrizione, String Testo, Vector<utente> nuoviResponsabili){
		if (this.attivit‡.indexOf(attivit‡DaModificare)==-1){
			return 1;
		}else{
			this.attivit‡.get(this.attivit‡.indexOf(attivit‡DaModificare)).addResponsabili(nuoviResponsabili);
			this.attivit‡.get(this.attivit‡.indexOf(attivit‡DaModificare)).setNome(Titolo);
			this.attivit‡.get(this.attivit‡.indexOf(attivit‡DaModificare)).setDescrizione(Descrizione);
			this.attivit‡.get(this.attivit‡.indexOf(attivit‡DaModificare)).setTesto(Testo);
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
	//completa l'attivit‡ SE E SOLO SE le precedenti sono tutte completate
	public int completeActivity(attivit‡ activityToComplete){
		if (this.attivit‡.indexOf(activityToComplete)==-1){
			return 1;
		}else{
			
			for (int i=0;i<(this.attivit‡.indexOf(activityToComplete)-1);i++){
				if (!(this.attivit‡.get(i).getCompletato())){
					return 2;
				}
			}
			this.attivit‡.get(this.attivit‡.indexOf(activityToComplete)).setCompletato();
			return 0;
		}
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}
}
