/*
 * Cr�� le 22 f�vr. 2015
 *
 * TODO Pour changer le mod�le de ce fichier g�n�r�, allez � :
 * Fen�tre - Pr�f�rences - Java - Style de code - Mod�les de code
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
 * 22 f�vr. 2015
 * TODO Pour changer le mod�le de ce commentaire de type g�n�r�, allez � :
 * Fen�tre - Pr�f�rences - Java - Style de code - Mod�les de code
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
				 * On va essayer de proc�der d'une mani�re diff�rente mais je ne sais pas si les changement que je vais faire seront les bon : 
				 * 
				 * On va mettre dans uneSpecialite un ordre diff�rent pour getInt et getString qui ne vont pas r�f�rer � leur position
				 * 		dans le constructeur de unMedecin mais � leur position dans le constructeur de uneSpecialite dans la m�thode 
				 * 		rechercher de localiteDao
				 * 
				 * On va aussi mettre dans uneLocalite un ordre diff�rent dans getStirng et getString pour que leurs ordres r�f�rent � la position
				 * 		des valeurs que l'ont veut r�cup�rer dans leurs constructeurs plut�t qu'a leurs position dans le constructeur 
				 * 		de unMedecin :
				 * 
				 * UneSpecialite --> On va donc mettre getInt(1) qui va r�f�rence au codespe qu'on r�cup�re dans le constructeur de la
				 * 					 m�thode rechercher de localiteDao et getString(2) qui va faire r�f�rence au nom de la sp�cialit� 
				 * 					 qu'on r�cup�re aussi dans la m�thode rechercher de la classe specialitesDao
				 * */
				uneSpecialite = SpecialiteDao.rechercher(reqSelection.getInt(4), reqSelection.getString(5));
				uneLocalite = LocaliteDao.rechercher(reqSelection.getString(10), reqSelection.getString(11));
				unMedecin = new Medecin(reqSelection.getString(1), reqSelection.getString(2), reqSelection.getString(3), uneSpecialite, reqSelection.getString(6), reqSelection.getString(7),reqSelection.getString(8), reqSelection.getString(9),uneLocalite);	
			};
			}
		catch(Exception e) {
			System.out.println("erreur reqSelection.next() pour la m�thode rechercher de MedecinDao WHERE CODEMED ='"+codemed+"'");
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
