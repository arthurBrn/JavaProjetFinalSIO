package modele.dao;

import java.sql.ResultSet;
import modele.specialite;

public class SpecialiteDao {

		
		//METHODE RECHERCHER 
		public static specialite rechercher(int codeSpe, String nomSpe){
			specialite uneSpecialite = null;
			ResultSet reqSelection = ConnexionMySql.execReqSelection("SELECT CODESPE, SPE_NOMSPE FROM specialites WHERE CODESPE ='" + codeSpe + "'");
			try {
				if (reqSelection.next()) {
					uneSpecialite = new specialite(reqSelection.getInt(1), reqSelection.getString(2));	
					
					
				};
				}
			catch(Exception e) {
				System.out.println("erreur reqSelection.next() pour la requête - SELECT * FROM visite WHERE REFERENCE ='"+codeSpe+"'");
				e.printStackTrace();
				}
			ConnexionMySql.fermerConnexionBd();
			return uneSpecialite;
		}
		

	
}
