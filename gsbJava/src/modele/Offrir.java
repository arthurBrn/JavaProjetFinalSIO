package modele;

public class Offrir {
	protected int qteOfferte;
	protected medicament unMedicament;
	protected visite uneVisite;
	
	public Offrir(int qteOfferte, medicament unMedicament, visite uneVisite) {
		super();
		this.unMedicament = unMedicament;
		this.uneVisite = uneVisite;
		this.qteOfferte = qteOfferte;
	}
	
	public int getQteOfferte() {
		return qteOfferte;
	}
	public void setQteOfferte(int qteOfferte) {
		this.qteOfferte = qteOfferte;
	}
	
	public medicament getUnMedicament() {
		return unMedicament;
	}

	public void setUnMedicament(medicament unMedicament) {
		this.unMedicament = unMedicament;
	}

	public visite getUneVisite() {
		return uneVisite;
	}

	public void setUneVisite(visite uneVisite) {
		this.uneVisite = uneVisite;
	}

}
