package modele;

import modele.Medecin;


public class visite{
	protected String reference;
	protected String date;
	protected String commentaire;
	public visiteur unVisiteur;
	public Medecin unMedecin;
	

	
	//On a fait un h�ritage de medecin vers visite, sinon impossible de r�cup�rer codeMed dans la vue JIFListeVisite;
	//On a supprimer medecin unMedecin des variables pr�sentes dans cette classe;
	//On r�cup�re le constructeur de medecin sans les attributs de personne puisque visite n'h�rite pas de personne;
	// Les modifications � faire dans la base suite � cet h�ritage : 
	/*
	 * On a fait h�rit� m�decin � visite
	 * Il faut 
	 * */
	
	/*
	 * Elements supprimer : 
	 * La localite*/
	
	public visite(String reference, String date, String commentaire,visiteur unVisiteur , Medecin unMedecin) {
		this.reference = reference;
		this.date = date;
		this.commentaire = commentaire;
		this.unMedecin = unMedecin;
		this.unVisiteur = unVisiteur;	
	}
	
	

	
	//REFERENCE 
	public String getReference() {
		return reference;
	}
	public void setReference(String reference) {
		this.reference = reference;
	}

	//DATE
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	//COMMENTAIRE 
	public String getCommentaire() {
		return commentaire;
	}

	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}
	
	//VISITEUR
	public visiteur getUnVisiteur() {
		return unVisiteur;
	}
	public void setUnVisiteur(visiteur unVisiteur) {
		this.unVisiteur = unVisiteur;
	}
	
	
	//MEDECIN
	public Medecin getUnMedecin() {
		return unMedecin;
	}
	public void setUnMedecin(Medecin unMedecin) {
		this.unMedecin = unMedecin;
	}
	
	
	/*
	 * getLaLocalite
	 * retournerMedecinPourLaVue
	 * retournerLocalitePourLaVue
	 * Sont utilis� pour la vue liste visite qui bien-s�r ne marche pas !
	 * */
	
	


	
}
















