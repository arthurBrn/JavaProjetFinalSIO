/*
 * Cr�� le 22 f�vr. 2015
 *
 * TODO Pour changer le mod�le de ce fichier g�n�r�, allez � :
 * Fen�tre - Pr�f�rences - Java - Style de code - Mod�les de code
 */
package modele.dao;

import modele.Localite;
import java.sql.ResultSet;


/**
 * @author Isabelle
 * 22 f�vr. 2015
 * TODO Pour changer le mod�le de ce commentaire de type g�n�r�, allez � :
 * Fen�tre - Pr�f�rences - Java - Style de code - Mod�les de code
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
			System.out.println("erreur reqSelection.next() pour la requ�te - SELECT * FROM localite WHERE LOC_CODEPOSTAL='"+codePostal+"'");
			e.printStackTrace();
			}
		ConnexionMySql.fermerConnexionBd();
		return uneLocalite;
	}

}
