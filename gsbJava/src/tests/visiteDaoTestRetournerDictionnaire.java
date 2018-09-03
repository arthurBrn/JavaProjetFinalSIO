package tests;

import java.util.HashMap;


import modele.visite;
import modele.dao.visiteDao;

public class visiteDaoTestRetournerDictionnaire {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			
			HashMap<String,visite> unDicco = new HashMap<String,visite>();
			unDicco =	visiteDao.retournerDictionnaireDesVisites();
			if (unDicco.containsKey("v002")){
				System.out.println(unDicco.get("v002").getReference());

		}
	}

}
