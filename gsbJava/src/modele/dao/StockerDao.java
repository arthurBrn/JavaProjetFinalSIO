package modele.dao;

import java.sql.ResultSet;


import java.util.ArrayList;

import modele.Stocker;

public class StockerDao {

	/**
	 * 
	 * @param requete
	 * @return 1 si la requete s'est déroulé
	 */
	public static int modifier(Stocker stock) {
		String requete = "UPDATE stocker SET QteRestante = " + stock.getQteStock() + " WHERE Matricule = '"
				+ stock.getUnVisiteur.getMatricule() + "' AND DepotLegal = '" + stock.getUnMedicament.getDepotLegal() + "'";

		return ConnexionMySql.execReqMaj(requete);
	}

	/**
	 * 
	 * @param stock
	 * @return 1 si la requete s'est déroulé
	 */
	public static int ajouter(Stocker stock) {
		String requete = "INSERT INTO stocker VALUES('" + stock.getUnVisiteur.getMatricule() + "', '" + stock.getUnMedicament.getDepotLegal() + "', "
				+ stock.getQteStock() + ")";

		return ConnexionMySql.execReqMaj(requete);
	}

	/**
	 * 
	 * @param matricule
	 * @param depotLegal
	 * @return le stock correspondant, null si rien n'est trouvé
	 */
	public static Stocker rechercherStock(String matricule, String depotLegal) {

		Stocker stock = null;

		ResultSet resultat = ConnexionMySql.execReqSelection("SELECT QteRestante FROM stocker WHERE Matricule = '"
				+ matricule + "' AND DepotLegal = '" + depotLegal + "'");

		try {
			if (resultat.next()) {
				stock = new Stocker(matricule, depotLegal, resultat.getInt(1));
			}
			resultat.close();
		} catch (Exception e) {
			System.out.println("Aucune correspondance entre le matricule et le depot legal");
			e.printStackTrace();
		}

		return stock;
	}

	/**
	 * 
	 * @param matricule
	 * @return les stocks correspondant au matricule
	 */
	public static ArrayList<Stocker> rechercherMatricule(String matricule) {
		ArrayList<Stocker> stocks = new ArrayList<Stocker>();

		ResultSet resultats = ConnexionMySql
				.execReqSelection("SELECT DepotLegal, QteRestante FROM stocker WHERE Matricule = '" + matricule + "'");

		try {
			while (resultats.next()) {
				stocks.add(new Stocker(matricule, resultats.getString(1), resultats.getInt(2)));
			}
			resultats.close();
		} catch (Exception e) {
			System.out.println("Le matricule n'a aucun stock associé");
			e.printStackTrace();
		}

		return stocks;
	}
	/**
	 * 
	 * @param depotLegal
	 * @return les stocks correspondant au depot legal
	 */
	public static ArrayList<Stocker> rechercherDepotLegal(String depotLegal) {
		ArrayList<Stocker> stocks = new ArrayList<Stocker>();

		ResultSet resultats = ConnexionMySql
				.execReqSelection("SELECT Matricule, QteRestante FROM stocker WHERE DepotLegal = '" + depotLegal + "'");

		try {
			while (resultats.next()) {
				stocks.add(new Stocker(resultats.getString(0), depotLegal, resultats.getInt(1)));
			}
			resultats.close();
		} catch (Exception e) {
			System.out.println("Aucun stock associé au depot legal");
		}

		return stocks;
	}

}
