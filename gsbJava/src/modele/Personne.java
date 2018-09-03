package modele;

import modele.Localite;
public class Personne {
	

	protected String codePersonne;
	protected String nomPersonne;
	protected String prenomPersonne;
	protected String adresse;
	protected Localite uneLocalite;
	

	public Personne(String codePersonne, String nomPersonne, String prenomPersonne, String adresse, Localite uneLocalite){
		this.codePersonne = codePersonne;
		this.nomPersonne = nomPersonne;
		this.prenomPersonne = prenomPersonne;
		this.adresse = adresse;
		this.uneLocalite = uneLocalite;
	}
	
	
	public Localite getUneLocalite() {
		return uneLocalite;
	}
	
	public void setUneLocalite(Localite uneLocalite) {
		this.uneLocalite = uneLocalite;
	}
	
	
	
	
	public String getCodePersonne() {
		return codePersonne;
	}
	
	public void setCodePersonne(String codePersonne) {
		this.codePersonne = codePersonne;
	}


	public String getNomPersonne() {
		return nomPersonne;
	}


	public void setNomPersonne(String nomPersonne) {
		this.nomPersonne = nomPersonne;
	}


	public String getPrenomPersonne() {
		return prenomPersonne;
	}


	public void setPrenomPersonne(String prenomPersonne) {
		this.prenomPersonne = prenomPersonne;
	}


	public String getAdresse() {
		return adresse;
	}


	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	
	
}
