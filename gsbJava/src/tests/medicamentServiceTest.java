package tests;

import modele.medicament;
import service.medicamentService;

public class medicamentServiceTest {
	public static void main(String[] args) {
		medicament unMedicament = medicamentService.rechercherMedicament("URIEG6");
		System.out.println(unMedicament.getDepotLegal());
		System.out.println(unMedicament.getNomCommercial());
		System.out.println(unMedicament.getComposition());
		System.out.println(unMedicament.getEffets());
		System.out.println(unMedicament.getContreIndication());
		System.out.println(unMedicament.getCodeFamille());
		System.out.println(unMedicament.getLibelleFamille());
		
		

	}
}
