package modele;

public class Stocker {
	protected medicament unMedicament;
	protected visiteur unVisiteur;
	protected int qteStock;
	
	public Stocker(int qteStock, medicament unMedicament, visiteur unVisiteur) {
		super();
		this.qteStock = qteStock;
		this.unMedicament = unMedicament;
		this.unVisiteur = unVisiteur;
	}

	public int getQteStock() {
		return qteStock;
	}

	public void setQteStock(int qteStock) {
		this.qteStock = qteStock;
	}
	public medicament getUnMedicament() {
		return unMedicament;
	}

	public void setUnMedicament(medicament unMedicament) {
		this.unMedicament = unMedicament;
	}

	public visiteur getUnVisiteur() {
		return unVisiteur;
	}

	public void setUnVisiteur(visiteur unVisiteur) {
		this.unVisiteur = unVisiteur;
	}

}
