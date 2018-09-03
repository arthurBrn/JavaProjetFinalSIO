package modele.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import modele.Localite;
import modele.visiteur;
import modele.dao.ConnexionMySql;
/*
 * 
 * 
 * str8
	localite
 * 
 * */


public class visiteurDao {
	
	
	
	
	public static visiteur rechercher(String matricule){
		visiteur unVisiteur= new visiteur(matricule, matricule, matricule, matricule, matricule, matricule, matricule, matricule, null);
		Localite uneLocalite= null;
		ResultSet reqSelection = ConnexionMySql.execReqSelection("SELECT MATRICULE, VISITEUR_LOGIN, VISITEUR_MDP, VISITEUR_DATEENTREE, CODE_PERSONNE, PERS_NOM, PERS_PRENOM, PERS_ADRESSE, localite.LOC_CODEPOSTAL, localite.LOC_VILLE"
				+ " FROM visiteur, personne, localite"
				+ " WHERE visiteur.MATRICULE = personne.CODE_PERSONNE"
				+ " AND personne.LOC_CODEPOSTAL = localite.LOC_CODEPOSTAL" 
				+ " AND MATRICULE ='"+matricule+"'");
		try {
			if (reqSelection.next()) {
				uneLocalite = LocaliteDao.rechercher(reqSelection.getString(1), reqSelection.getString(2));
				unVisiteur= new visiteur(reqSelection.getString(1), reqSelection.getString(2), 
						reqSelection.getString(3), 
						reqSelection.getString(4),
						reqSelection.getString(5), reqSelection.getString(6), reqSelection.getString(7),reqSelection.getString(8), uneLocalite);	
			};// utilisé des setters + clair 
			
			
			}
		catch(Exception e) {
			System.out.println("erreur reqSelection.next() pour la requête - SELECT * FROM visiteur WHERE MATRICULE ='"+matricule+"'");
			e.printStackTrace();
			}
		ConnexionMySql.fermerConnexionBd();
		return unVisiteur;
	}
	
	public static ArrayList<visiteur> retournerCollectionDesVisiteurs(){
		ArrayList<visiteur> collectionDesVisiteurs = new ArrayList<visiteur>();
		ResultSet reqSelection = ConnexionMySql.execReqSelection("select MATRICULE from visiteur");
		try{
		while (reqSelection.next()) {
			String matricule = reqSelection.getString(1);
		    collectionDesVisiteurs.add(visiteurDao.rechercher(matricule));
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
			System.out.println("erreur retournerCollectionDesVisiteurs()");
		}
		return collectionDesVisiteurs;
	}
	
	public static HashMap<String,visiteur> retournerDictionnaireDesVisiteurs(){
		HashMap<String, visiteur> diccoDesVisiteurs = new HashMap<String, visiteur>();
		ResultSet reqSelection = ConnexionMySql.execReqSelection("select MATRICULE from visiteur");
		try{
		while (reqSelection.next()) {
			String matricule = reqSelection.getString(1);
		    diccoDesVisiteurs.put(matricule, visiteurDao.rechercher(matricule));
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
			System.out.println("erreur retournerDiccoDesVisiteurs()");
		}
		return diccoDesVisiteurs;
	}

	public static int ajouterVisiteur(visiteur unVisiteur) {
		// TODO Auto-generated method stub
		return 0;
	}
}
