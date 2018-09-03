package service;

import modele.Medecin;

import modele.visite;
import modele.visiteur;
import modele.dao.visiteDao;
import modele.Offrir;
import modele.medicament;

public class majVisiteService {

	
	
	public static String rechercherVisite(String uneReference){
		visite uneVisite = null;
		
		try{
		if (uneReference==null) {
            throw new Exception("Donnée obligatoire : code");
        }
		uneVisite = visiteDao.rechercher(uneReference);
		}
		catch(Exception e){
			System.out.println( e.getMessage());
		}
		return uneReference;
	}
	
	
	public static int majVisite(visite uneVisite) {
		int insertion = 0;
		Medecin unMedecin = null;
		visiteur unVisiteur = null;
		Offrir unOffrir = null;
		medicament unMedicament = null;
		try {
			if(uneVisite.getReference() == null) 
				throw new Exception("Donnée obligatoire : reference");
			if(uneVisite.getDate() == null) 
				throw new Exception("Donnée obligatoire : Date");
			
			// Vérifier que le champ matricule du visiteur n'est pas null
						//Si oui lance exception "Matricule"
						if(unVisiteur.getCodePersonne() == null) //Faire un lien vers visiteur
							throw new Exception("Donnée obligatoire : Matricule");
						
						
						//Récupère codeMedecin
						if(unMedecin.getCodePersonne() == null)
							throw new Exception("Donnée obligatoire : code");
			
			if(uneVisite.getCommentaire() == null)
				throw new Exception("Donnée obligatoire : Commentaire");
			
			//Vérifier dépot légale et quantité offerte :
			
			
			if(unMedicament.getDepotLegal() == null)
				throw new Exception("Donnée obligatoire : reference");
			
			
			if(unOffrir.getQteOfferte() <= 0 )
				throw new Exception("DOnnée oblifatoire : Quantité offerte");
			
		insertion = visiteDao.ajouterVisite(uneVisite);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return insertion;
	}

}
