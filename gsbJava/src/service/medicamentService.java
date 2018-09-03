package service;

import modele.medicament;
import modele.dao.medicamentDao;

public class medicamentService {
	public static medicament rechercherMedicament(String unCodeMedicament){
		medicament unMedicament = null;
		try{
		if (unCodeMedicament==null) {
            throw new Exception("Donn�e obligatoire : code");
        }
		unMedicament = medicamentDao.rechercher(unCodeMedicament);
		}
		catch(Exception e){
			System.out.println( e.getMessage());
		}
		return unMedicament;
	}
	
	public static int ajouterMedicament(medicament unMedicament) {
		int insertion = 0;
		try {
			if(unMedicament.getDepotLegal() == null) 
				throw new Exception("Donn�e obligatoire : Depot l�gal");
			if(unMedicament.getNomCommercial() == null) 
				throw new Exception("Donn�e obligatoire : Nom commercial");
			if(unMedicament.getComposition() == null)
				throw new Exception("Donn�e obligatoire : Composition");
			if(unMedicament.getEffets() == null)
				throw new Exception("Donn�e obligatoire : Effets");
			if(unMedicament.getContreIndication()== null)
				throw new Exception("Donn�e obligatoire : Contre indications");
			if(unMedicament.getCodeFamille() == null)
				throw new Exception("Donn�e obligatoire : Code famille");
			if(unMedicament.getLibelleFamille() == null)
				throw new Exception("Donn�e obligatoire : Libelle famille");
			
			
			if(medicamentDao.rechercher(unMedicament.getDepotLegal()) != null)
				throw new Exception("Le d�pot l�gal est d�j� utilis� pour un autre Medicament");
		insertion = medicamentDao.ajouterMedicament(unMedicament);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return insertion;
	}
}
