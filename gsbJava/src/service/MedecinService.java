/*
 * Créé le 23 févr. 2015
 *
 * TODO Pour changer le modèle de ce fichier généré, allez à :
 * Fenêtre - Préférences - Java - Style de code - Modèles de code
 */
package service;

import modele.Medecin;
import modele.specialite;


import modele.dao.MedecinDao;

/**
 * @author Isabelle
 * 23 févr. 2015
 * TODO Pour changer le modèle de ce commentaire de type généré, allez à :
 * Fenêtre - Préférences - Java - Style de code - Modèles de code
 */
public class MedecinService {
	
	public static Medecin rechercherMedecin(String unCodeMedecin){
		Medecin unMedecin = null;
		try{
		if (unCodeMedecin==null) {
            throw new Exception("Donnée obligatoire : code");
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
				throw new Exception("Donnée obligatoire : code");
			if(unMedecin.getNomPersonne() == null) 
				throw new Exception("Donnée obligatoire : Nom");
			if(unMedecin.getPrenomPersonne() == null)
				throw new Exception("Donnée obligatoire : Prenom");
			if(unMedecin.getAdresse() == null)
				throw new Exception("Donnée obligatoire : Adresse");
			if(unMedecin.getUneLocalite().getCodePostal() == null)
				throw new Exception("Donnée obligatoire :Code Postal");
			if(unMedecin.getTelephone() == null)
				throw new Exception("Donnée obligatoire : Telephone");
			if(unMedecin.getLaSpecialite() == null)
				throw new Exception("Donnée obligatoire : Specialité");
			if(unMedecin.getCodePersonne() == null)
				throw new Exception("Donnée obligatoire : code");
			
			if(MedecinDao.rechercher(unMedecin.getCodePersonne()) != null)
				throw new Exception("Le code medecin est déjà utilisé pour un autre Medecin");
			/*if(!ValidationUtils.isCodePostalValide(unMedecin.getLaLocalite().getCodePostal()))
				throw new Exception("Code postal n'est pas au bon format");
			if(!ValidationUtils.isTelephoneValide(unMedecin.getTelephone()))
				throw new Exception("Le Téléphone n'est pas au bon format");*/
		insertion = MedecinDao.ajouterMedecin(unMedecin);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return insertion;
	}
}
