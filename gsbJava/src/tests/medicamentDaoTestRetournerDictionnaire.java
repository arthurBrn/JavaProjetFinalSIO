package tests;

import java.util.HashMap;


import modele.medicament;
import modele.dao.medicamentDao;

public class medicamentDaoTestRetournerDictionnaire {

	public static void main(String[] args) {
			
			HashMap<String,medicament> unDicco = new HashMap<String,medicament>();
			unDicco =	medicamentDao.retournerDictionnaireDesMedicaments();
			if (unDicco.containsKey("m002")){
				System.out.println(unDicco.get("m002").getNomCommercial());
			

		}

	}

}
