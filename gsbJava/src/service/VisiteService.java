package service;

import modele.visite;
import modele.visiteur;
import modele.Medecin;


import modele.dao.MedecinDao;
import modele.dao.visiteurDao;

import javax.swing.JFrame;
import javax.swing.JOptionPane;



public class VisiteService {
	
	public static boolean verification(String reference, String dateVisite, String commentaire, String matricule, String codemed) {
		boolean reussi = false;

		try {

			if (reference.isEmpty() || dateVisite.isEmpty() || matricule.isEmpty() || codemed.isEmpty()) {
				throw new Exception("Champs obligatoires : reference, date visite, matricule visiteur, code medecin");
			}

			
			visiteur per = visiteurDao.rechercher(matricule);
					
			if (per == null) {
				throw new Exception("Le matricule visiteur est null");
			}
			
			
			Medecin med = MedecinDao.rechercher(codemed);

			if (med == null) {
				throw new Exception("Le code Medecin est null");
			}

			

			reussi = true;

		} catch (Exception e) {
			JOptionPane.showMessageDialog(new JFrame(), e.getMessage(), "Erreur de saisis", JOptionPane.ERROR_MESSAGE);
		}

		return reussi;
	}
		
		

}
	
	


