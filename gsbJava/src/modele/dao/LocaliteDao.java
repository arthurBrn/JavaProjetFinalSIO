/*
 * Créé le 22 févr. 2015
 *
 * TODO Pour changer le modèle de ce fichier généré, allez à :
 * Fenêtre - Préférences - Java - Style de code - Modèles de code
 */
package modele.dao;

import modele.Localite;
import java.sql.ResultSet;


/**
 * @author Isabelle
 * 22 févr. 2015
 * TODO Pour changer le modèle de ce commentaire de type généré, allez à :
 * Fenêtre - Préférences - Java - Style de code - Modèles de code
 */
public class LocaliteDao {
	
	public static Localite rechercher(String codePostal, String ville){
		Localite uneLocalite=null;
		ResultSet reqSelection = ConnexionMySql.execReqSelection("SELECT LOC_CODEPOSTAL, LOC_VILLE FROM localite WHERE LOC_CODEPOSTAL='"+codePostal+"'");
		try {
			if (reqSelection.next()) {
				uneLocalite = new Localite(reqSelection.getString(1), reqSelection.getString(2));	
			};
			}
		catch(Exception e) {
			System.out.println("erreur reqSelection.next() pour la requête - SELECT * FROM localite WHERE LOC_CODEPOSTAL='"+codePostal+"'");
			e.printStackTrace();
			}
		ConnexionMySql.fermerConnexionBd();
		return uneLocalite;
	}

}
