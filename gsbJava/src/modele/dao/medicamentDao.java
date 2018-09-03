package modele.dao;

import java.sql.ResultSet;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import modele.medicament;

public class medicamentDao {
	public static medicament rechercher(String depotLegal){
		medicament unMedicament=null;
		ResultSet reqSelection = ConnexionMySql.execReqSelection("SELECT * FROM medicament WHERE MED_DEPOTLEGAL ='"+depotLegal+"'");
		try {
			if (reqSelection.next()) {
				unMedicament= new medicament(reqSelection.getString(1), reqSelection.getString(2), reqSelection.getString(3), reqSelection.getString(4), reqSelection.getString(5), reqSelection.getString(6), reqSelection.getString(7), reqSelection.getString(8) );	
			};
			}
		catch(Exception e) {
			System.out.println("erreur reqSelection.next() pour la requête - SELECT * FROM medicament WHERE MED_DEPOTLEGAL ='"+depotLegal+"'");
			e.printStackTrace();
			}
		ConnexionMySql.fermerConnexionBd();
		return unMedicament;
	}
	
	public static ArrayList<medicament> retournerCollectionDesMedicaments(){
		ArrayList<medicament> collectionDesMedicaments = new ArrayList<medicament>();
		ResultSet reqSelection = ConnexionMySql.execReqSelection("SELECT MED_DEPOTLEGAL FROM medicament");
		try{
		while (reqSelection.next()) {
			String depotLegal = reqSelection.getString(1);
		    collectionDesMedicaments.add(medicamentDao.rechercher(depotLegal));
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
			System.out.println("erreur retournerCollectionDesMedicaments()");
		}
		return collectionDesMedicaments;
	}
	
	public static HashMap<String,medicament> retournerDictionnaireDesMedicaments(){
		HashMap<String, medicament> diccoDesMedicaments = new HashMap<String, medicament>();
		ResultSet reqSelection = ConnexionMySql.execReqSelection("SELECT MED_DEPOTLEGAL FROM medicament");
		try{
		while (reqSelection.next()) {
			String depotLegal = reqSelection.getString(1);
		    diccoDesMedicaments.put(depotLegal, medicamentDao.rechercher(depotLegal));
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
			System.out.println("erreur retournerDiccoDesMedicaments()");
		}
		return diccoDesMedicaments;
	}

	public static int ajouterMedicament(medicament unMedicament) {
		String requete = "INSERT INTO medicament " + "VALUES("+ "'" + unMedicament.getDepotLegal()+ "','"
				+ unMedicament.getNomCommercial() + "','" + unMedicament.getComposition() + "','" 
				+ unMedicament.getEffets() + "'," +"'"+ unMedicament.getContreIndication() + "','"
				+ unMedicament.getPrixEchantillon() + "','" + unMedicament.getCodeFamille()+ "','"
				+ unMedicament.getLibelleFamille() + "')";
		System.out.println(requete);
		int result = ConnexionMySql.execReqMaj(requete);
		ConnexionMySql.fermerConnexionBd();
		
		return result;
	}
}
