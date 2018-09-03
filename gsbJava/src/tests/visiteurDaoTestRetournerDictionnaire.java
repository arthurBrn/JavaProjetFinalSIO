package tests;

import java.util.HashMap;


import modele.visiteur;
import modele.dao.visiteurDao;

public class visiteurDaoTestRetournerDictionnaire {
public static void main(String[] args) {
		
		HashMap<String,visiteur> unDicco = new HashMap<String,visiteur>();
		unDicco =	visiteurDao.retournerDictionnaireDesVisiteurs();
		if (unDicco.containsKey("m002")){
			System.out.println(unDicco.get("m002").getNom());
		}

	}

}
