package modele.dao;

import java.sql.ResultSet;

import java.util.ArrayList;

import modele.Offrir;
import modele.medicament;
import modele.visite;

public class OffrirDao {

	/**
	 * 
	 * @param offre
	 * @return 1 si la requete s'est déroulé
	 */
	public static int modifier(Offrir offre) {
		String requete = "UPDATE offrir SET Reference = '" + offre.getUneVisite().getReference() + "', "
				+ " MED_DEPOTLEGAL = '" + offre.getUnMedicament().getDepotLegal() + "', "
				+ " qteofferte = " + offre.getQteOfferte()
				+ " WHERE REFERENCE = '" + offre.getUneVisite().getReference() + "'"
				+ " AND MED_DEPOTLEGAL = '" + offre.getUnMedicament().getDepotLegal() + "'";

		return ConnexionMySql.execReqMaj(requete);
	}

	/**
	 * 
	 * @param offre
	 * @return
	 */
	public static int ajouter(Offrir offre) {
		String requete = "INSERT INTO offrir VALUES("
				+ "'" + offre.getUneVisite().getReference() + "', "
				+ "'" + offre.getUnMedicament().getDepotLegal() + "', "
				+ offre.getQteOfferte()
				+ ")";

		return ConnexionMySql.execReqMaj(requete);
	}

	/**
	 * 
	 * @param reference
	 * @param depotLegal
	 * @return l'offre correspondante, null si rien n'est trouvé
	 */
	public static Offrir rechercherOffre(visite reference, medicament depotLegal) {
		Offrir offre = null;

		ResultSet resultat = ConnexionMySql.execReqSelection("SELECT *"
				+ " FROM offrir "
				+ " WHERE REFERENCE = '" + reference + "'"
				+ " AND MED_DEPOTLEGAL = '" + depotLegal + "'");

		try {
			if (resultat.next()) {
				offre = new Offrir(resultat.getInt(1), depotLegal, reference);
			}
			resultat.close();
		} catch (Exception e) {
			System.out.println("Aucune offre ne correspond a la reference et au depot legal");
			e.printStackTrace();
		}

		return offre;
	}

	/**
	 * 
	 * @param reference
	 * @return la liste des offres correspondant a la reference
	 */
	public static ArrayList<Offrir> rechercherReference(visite reference) {
		ArrayList<Offrir> offres = new ArrayList<Offrir>();

		ResultSet resultats = ConnexionMySql.execReqSelection("SELECT MED_DEPOTLEGAL, qteofferte"
				+ "FROM offrir"
				+ "WHERE REFERENCE = '" + reference + "'");

		try {
			while (resultats.next()) {
				offres.add(new Offrir(reference, resultats.getString(1), resultats.getInt(2)));
			}
			resultats.close();
		} catch (Exception e) {
			System.out.println("Aucune offre ne correspond a cette reference");
			e.printStackTrace();
		}

		return offres;
	}

	/**
	 * 
	 * @param depotLegak
	 * @return la liste des offres correspondant au depot legal
	 */
	public static ArrayList<Offrir> rechercherDepotLegal(String depotLegal) {
		ArrayList<Offrir> offres = new ArrayList<Offrir>();

		ResultSet resultats = ConnexionMySql.execReqSelection("SELECT REFERENCE, qteoffetrte"
				+ "FROM offrir"
				+ "WHERE MED_DEPOTLEGAL = '" + depotLegal + "'");

		try {
			while (resultats.next()) {
				offres.add(new Offrir(resultats.getString(1), depotLegal, resultats.getInt(2)));
			}
			resultats.close();
		} catch (Exception e) {
			System.out.println("Aucune offre ne correspond a ce depot legal");
			e.printStackTrace();
		}

		return offres;
	}

}
