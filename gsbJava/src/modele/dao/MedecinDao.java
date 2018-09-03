/*
 * Créé le 22 févr. 2015
 *
 * TODO Pour changer le modèle de ce fichier généré, allez à :
 * Fenêtre - Préférences - Java - Style de code - Modèles de code
 */
package modele.dao;

import modele.Localite;
import modele.Medecin;
import modele.specialite;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;



/**
 * @author Isabelle
 * 22 févr. 2015
 * TODO Pour changer le modèle de ce commentaire de type généré, allez à :
 * Fenêtre - Préférences - Java - Style de code - Modèles de code
 */
public class MedecinDao {
	

	
	public static Medecin rechercher(String codemed){
		Medecin unMedecin= new Medecin(codemed, codemed, codemed, null, codemed, codemed, codemed, codemed, null);
		Localite uneLocalite= null;
		specialite uneSpecialite= null;
		
		ResultSet reqSelection = ConnexionMySql.execReqSelection("SELECT CODEMED, MEDECIN_TELEPHONE, MEDECIN_POTENTIEL, specialites.CODESPE,specialites.SPE_NOMSPE , CODE_PERSONNE, PERS_NOM, PERS_PRENOM, PERS_ADRESSE, LOCALITE.LOC_CODEPOSTAL, LOCALITE.LOC_VILLE"
				+ " FROM MEDECIN, PERSONNE, LOCALITE, SPECIALITES"
				+ " WHERE MEDECIN.CODEMED = PERSONNE.CODE_PERSONNE AND PERSONNE.LOC_CODEPOSTAL = LOCALITE.LOC_CODEPOSTAL AND MEDECIN.CODESPE = specialites.CODESPE AND MEDECIN.CODEMED = '" + codemed+"'");
		try {
			if (reqSelection.next()) {
				/*
				 * On va essayer de procéder d'une manière différente mais je ne sais pas si les changement que je vais faire seront les bon : 
				 * 
				 * On va mettre dans uneSpecialite un ordre différent pour getInt et getString qui ne vont pas référer à leur position
				 * 		dans le constructeur de unMedecin mais à leur position dans le constructeur de uneSpecialite dans la méthode 
				 * 		rechercher de localiteDao
				 * 
				 * On va aussi mettre dans uneLocalite un ordre différent dans getStirng et getString pour que leurs ordres réfèrent à la position
				 * 		des valeurs que l'ont veut récupérer dans leurs constructeurs plutôt qu'a leurs position dans le constructeur 
				 * 		de unMedecin :
				 * 
				 * UneSpecialite --> On va donc mettre getInt(1) qui va référence au codespe qu'on récupère dans le constructeur de la
				 * 					 méthode rechercher de localiteDao et getString(2) qui va faire référence au nom de la spécialité 
				 * 					 qu'on récupère aussi dans la méthode rechercher de la classe specialitesDao
				 * */
				uneSpecialite = SpecialiteDao.rechercher(reqSelection.getInt(4), reqSelection.getString(5));
				uneLocalite = LocaliteDao.rechercher(reqSelection.getString(10), reqSelection.getString(11));
				unMedecin = new Medecin(reqSelection.getString(1), reqSelection.getString(2), reqSelection.getString(3), uneSpecialite, reqSelection.getString(6), reqSelection.getString(7),reqSelection.getString(8), reqSelection.getString(9),uneLocalite);	
			};
			}
		catch(Exception e) {
			System.out.println("erreur reqSelection.next() pour la méthode rechercher de MedecinDao WHERE CODEMED ='"+codemed+"'");
			e.printStackTrace();
			}
		ConnexionMySql.fermerConnexionBd();
		return unMedecin;
	}
	
	public static ArrayList<Medecin> retournerCollectionDesMedecins(){
		ArrayList<Medecin> collectionDesMedecins = new ArrayList<Medecin>();
		ResultSet reqSelection = ConnexionMySql.execReqSelection("SELECT CODEMED FROM MEDECIN");
		try{
		while (reqSelection.next()) {
			String codeMed = reqSelection.getString(1);
		    collectionDesMedecins.add(MedecinDao.rechercher(codeMed));
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
			System.out.println("erreur retournerCollectionDesMedecins()");
		}
		return collectionDesMedecins;
	}
	
	public static HashMap<String,Medecin> retournerDictionnaireDesMedecins(){
		HashMap<String, Medecin> diccoDesMedecins = new HashMap<String, Medecin>();
		ResultSet reqSelection = ConnexionMySql.execReqSelection("SELECT CODEMED FROM MEDECIN");
		try{
		while (reqSelection.next()) {
			String codeMed = reqSelection.getString(1);
		    diccoDesMedecins.put(codeMed, MedecinDao.rechercher(codeMed));
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
			System.out.println("erreur retournerDiccoDesMedecins()");
		}
		return diccoDesMedecins;
	}
	
	
	
	public static HashMap<String,Medecin> retournerDictionnaireDesMedecinsTest(String codemed){
		HashMap<String, Medecin> diccoDesMedecins = new HashMap<String, Medecin>();
		ResultSet reqSelection = ConnexionMySql.execReqSelection("SELECT CODEMED FROM MEDECIN");
		try{
		while (reqSelection.next()) {
			String codeMed = reqSelection.getString(1);
		    diccoDesMedecins.put(codeMed, MedecinDao.rechercher(codeMed));
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
			System.out.println("erreur retournerDiccoDesMedecins()");
		}
		return diccoDesMedecins;
	}
	

	public static int ajouterMedecin(Medecin unMedecin) {
		// TODO Auto-generated method stub
		return 0;
	}

}
