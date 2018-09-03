package modele.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import modele.Localite;
import modele.Personne;

public class PersonneDao {

	public static Personne rechercher(String codePersonne){
		Personne unePersonne =null;
		Localite uneLocalite = null;
		ResultSet reqSelection = ConnexionMySql.execReqSelection("SELECT * FROM visiteur WHERE MATRICULE ='"+codePersonne+"'");
		try {
			if (reqSelection.next()) {
				unePersonne = new Personne(reqSelection.getString(1), reqSelection.getString(2), reqSelection.getString(3), reqSelection.getString(4), uneLocalite);
				};
			
			}
		catch(Exception e) {
			System.out.println("erreur reqSelection.next() pour la requête - SELECT * FROM visiteur WHERE MATRICULE ='"+codePersonne+"'");
			e.printStackTrace();
			}
		ConnexionMySql.fermerConnexionBd();
		return unePersonne;
	}
	
	/*
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
	*/
	
}

