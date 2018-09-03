/*
 * Cr�� le 23 f�vr. 2015
 *
 * TODO Pour changer le mod�le de ce fichier g�n�r�, allez � :
 * Fen�tre - Pr�f�rences - Java - Style de code - Mod�les de code
 */
package service;

import modele.Medecin;
import modele.specialite;


import modele.dao.MedecinDao;

/**
 * @author Isabelle
 * 23 f�vr. 2015
 * TODO Pour changer le mod�le de ce commentaire de type g�n�r�, allez � :
 * Fen�tre - Pr�f�rences - Java - Style de code - Mod�les de code
 */
public class MedecinService {
	
	public static Medecin rechercherMedecin(String unCodeMedecin){
		Medecin unMedecin = null;
		try{
		if (unCodeMedecin==null) {
            throw new Exception("Donn�e obligatoire : code");
        }
		unMedecin = MedecinDao.rechercher(unCodeMedecin);
		}
		catch(Exception e){
			System.out.println( e.getMessage());
		}
		return unMedecin;
	}
	
	
	public static int ajouterMedecin(Medecin unMedecin) {
		int insertion = 0;
		try {
			if(unMedecin.getCodePersonne() == null) 
				throw new Exception("Donn�e obligatoire : code");
			if(unMedecin.getNomPersonne() == null) 
				throw new Exception("Donn�e obligatoire : Nom");
			if(unMedecin.getPrenomPersonne() == null)
				throw new Exception("Donn�e obligatoire : Prenom");
			if(unMedecin.getAdresse() == null)
				throw new Exception("Donn�e obligatoire : Adresse");
			if(unMedecin.getUneLocalite().getCodePostal() == null)
				throw new Exception("Donn�e obligatoire :Code Postal");
			if(unMedecin.getTelephone() == null)
				throw new Exception("Donn�e obligatoire : Telephone");
			if(unMedecin.getLaSpecialite() == null)
				throw new Exception("Donn�e obligatoire : Specialit�");
			if(unMedecin.getCodePersonne() == null)
				throw new Exception("Donn�e obligatoire : code");
			
			if(MedecinDao.rechercher(unMedecin.getCodePersonne()) != null)
				throw new Exception("Le code medecin est d�j� utilis� pour un autre Medecin");
			/*if(!ValidationUtils.isCodePostalValide(unMedecin.getLaLocalite().getCodePostal()))
				throw new Exception("Code postal n'est pas au bon format");
			if(!ValidationUtils.isTelephoneValide(unMedecin.getTelephone()))
				throw new Exception("Le T�l�phone n'est pas au bon format");*/
		insertion = MedecinDao.ajouterMedecin(unMedecin);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return insertion;
	}
}
