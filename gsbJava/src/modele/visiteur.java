package modele;

public class visiteur extends Personne {
	protected String matricule;
	protected String login;
	protected String mdp;
	protected String dateEntree;
	
	


	
	
	public visiteur(String matricule, String login, String mdp, String dateEntree,
			String codePersonne, String nomPersonne, String prenomPersonne, String adresse, Localite uneLocalite){
		super(codePersonne, nomPersonne, prenomPersonne, adresse, uneLocalite);
		
		this.matricule = matricule;
		this.login = login;
		this.mdp = mdp;
		this.dateEntree = dateEntree;		
	}



/*	public Localite getUneLocalite() {
		return uneLocalite;
	}
	
	public void setUneLocalite() {
		this.uneLocalite = uneLocalite;
	}*/
	
	public String getMatricule() {
		return matricule;
	}
	
	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getDateEntree() {
		return dateEntree;
	}

	public void setDateEntree(String dateEntree) {
		this.dateEntree = dateEntree;
	}

	public String getNom() {
		return nomPersonne;
	}
	
}
