package modele.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import modele.Medecin;
import modele.visite;
import modele.visiteur;
import modele.dao.ConnexionMySql;


/*On a ajouter localite � visite parce qu'on a besoin d'afficher le lieu de la visite dans liste des visites
 * Il faut modifier la base de donn�es 
 * Ajouter LOC_CODEPOSTAL en cl� �trang�re dans la table visite et donc faire une requ�te en passant par LOC_CP pour r�cup�rer la ville?
 * Ca doit pouvoir marcher!
 * 
 * */

public class visiteDao {
	
	public static int creer(visite uneVisite) {
		String requete = "INSERT INTO visite " + "VALUES(" + "'" + uneVisite.getReference() + "', " +"'" 
					+ uneVisite.getDate() + "', " + "'" + uneVisite.getCommentaire() + "', " + "'" 
					+ uneVisite.getUnVisiteur().getCodePersonne() + "', " + "'" + uneVisite.getUnMedecin().getCodePersonne() + "' ) "; 
		System.out.println(requete);
		int result = ConnexionMySql.execReqMaj(requete);
		
		return result;
	}
	
	//METHODE RECHERCHER 
	public static visite rechercher(String reference){
		visite uneVisite=null;
		visiteur unVisiteur=null;
		Medecin unMedecin = null;
		ResultSet reqSelection = ConnexionMySql.execReqSelection("SELECT distinct visite.reference, visite.visite_datevisite, visite.visite_commentaire, visiteur.matricule, medecin.codemed " 
				+ " FROM visite, visiteur, medecin " 
				+ " WHERE visite.matricule = visiteur.matricule"  
				+ " AND medecin.codemed = visite.codemed" 
				+ " AND reference ='" + reference + "'");
		try {
			if (reqSelection.next()) {
				unVisiteur = visiteurDao.rechercher(reqSelection.getString(1));
				//pb ici
				//Renvoie toutes les donn�es de medecin mais on n'en veut que une seule 
				/*
				 * On essaye ici de r�cup�rer dans unMedecin uniquement le codeMed de medecin
				 * Et de r�cup�rer dans unVisiteur uniquement le matricule de visiteur  :
				 * 
				 * Donc j'ai mis dans unMedecin la m�thode rechercher de medecinDao et en argument reqselectiongetstring(1)
				 * 		En esp�rant que getString(1) va retourner le premier string r�cup�rer dans la m�thode rechercher de medecinDao
				 * 		qui est codemed 
				 * 
				 * Dans unVisiteur on essaye aussi de r�cup�rer uniquement le code d'un visiteur soit matricule 
				 * 		J'ai donc appeler dans unVisiteur la m�thode rechercher de visiteurDao et en param�tre reqselectiongetstring(1)
				 * 		en esp�rant que getString(1) r�cup�re la premi�re valeur de la m�thode rechercher de visiteurDao soit matricule.
				 * */
				//Medecin codemed = reqSelection.getString(5);
				unMedecin = MedecinDao.rechercher(reqSelection.getString(1));
				uneVisite = new visite(reqSelection.getString(1), reqSelection.getString(2), reqSelection.getString(3), unVisiteur, unMedecin);	
				
				
			};
			}
		catch(Exception e) {
			System.out.println("erreur reqSelection.next() pour la requ�te - SELECT * FROM visite WHERE REFERENCE ='"+reference+"'");
			e.printStackTrace();
			}
		ConnexionMySql.fermerConnexionBd();
		return uneVisite;
	}
	
	
	// METHODE RETOURNER UNE COLLECTION DES VISITES 
	public static ArrayList<visite> retournerCollectionDesVisites(){
		ArrayList<visite> collectionDesVisites = new ArrayList<visite>();
		ResultSet reqSelection = ConnexionMySql.execReqSelection("SELECT REFERENCE FROM visite");
		try{
		while (reqSelection.next()) {
			String reference = reqSelection.getString(1);
		    collectionDesVisites.add(visiteDao.rechercher(reference));
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
			System.out.println("erreur retournerCollectionDesVisites()");
		}
		return collectionDesVisites;
	}
	
	
	// METHODE RETOURNER UNE DICTIONNAIRE DES VISITES
	public static HashMap<String,visite> retournerDictionnaireDesVisites(){
		HashMap<String, visite> diccoDesVisites = new HashMap<String, visite>();
		//On veut s�lectionner 
		//	reference de la table visite 
		//	codemed de la table medecin
		//	matricule de la table visiteur 
		/*
		 * On va essayer de modifier ce dictionnaire pour retourner les valeurs codeMed et lieu 
		 * */
		ResultSet reqSelection = ConnexionMySql.execReqSelection("SELECT REFERENCE FROM visite");
		try{
			while (reqSelection.next()) {
				String reference = reqSelection.getString(1);
				diccoDesVisites.put(reference, rechercher(reference));
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
			System.out.println("erreur retournerDiccoDesVisites()");
		}
		return diccoDesVisites;
	}
	
	/*
	 * M�thodes ajouter une visite
	 * Ajoute la r�f�rence de la visite 
	 * Ajoute la date de la visite 
	 * Ajoute un commentaire pr rapport � la visite
	 * Ajoute le matricule du visiteur concern�
	 * Ajoute le matricule du medecin concern�
	 * */

	
	
	
    
	
	
	
	
	//METHODE AJOUTER UNE VISITE
	public static int ajouterVisite(visite uneVisite) {
		// TODO Auto-generated method stub
		//R�cup�rer dans des variables les valeurs rentrer par l'utilisateurs par getText ou quelque chose comme ca
		/*Pr�paration requ�te
		 * On insert les m�thodes qui permettent de r�cup�rer les valeurs rentrer dans le formulaire par l'utilisatuer
		 * dans la classe JIFAjoutVisite
		 * */
		String requete = "INSERT INTO visite "+ "VALUES("+ "'" + uneVisite.getReference()+ "'," + "'" 
		 + uneVisite.getDate() + "'," + "'" 
		 + uneVisite.getCommentaire() +"'," + "'"
		 + uneVisite.getUnVisiteur().getMatricule() + "'," + "'" + uneVisite.getUnMedecin().getCodeMed() + "')";
		
		int result = ConnexionMySql.execReqMaj(requete);
		
		return result;
	}
	
	
	
	
	//METTRE A JOUR VISITE
	
	public static int MAJvisite(visite uneReference){
		
		//Pr�paration de la requ�te 
		ResultSet reqSelection = ConnexionMySql.execReqSelection("UPDATE visite ");
		
		//Il faut r�cup�rer le champ reference de la visite que l'utilisateur souhaite modifier;
		//R�cup�rer toutes les nouvelles donn�es de visite
		if(uneReference != null) {
			
		}
		
		return 1;
	}
	
	
	/*
	 * M�thode liste des visites
	 * Retourne une liste de toutes les visites : 
	 * SELECT * FROM visite  :
	 * 	REFERENCE
	 * 	DATEVISITE
	 * 	COMMENTAIRE
	 * 	MATRICULE
	 * 	CODEMED
	 * 
	 * On peut positionner ces infos comme l'a fait thomas
	 * */
	
	
	
}
