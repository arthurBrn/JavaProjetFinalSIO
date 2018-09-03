
package modele;

public class Medecin extends Personne{
	protected String codemed;
	protected String telephone;
	protected String potentiel;
	public static specialite laSpecialite;
	
	/**
	 * @param codeMed
	 * @param nom
	 * @param prenom
	 * @param adresse
	 * @param laLocalite
	 * @param telephone
	 * @param potentiel
	 * @param specialite
	 */
	

	
	public Medecin(String codemed, String telephone,String potentiel, specialite laSpecialite, String codePersonne, String nomPersonne, 
			String prenomPersonne, String adresse,Localite uneLocalite) {
		super(codePersonne, nomPersonne, prenomPersonne, adresse, uneLocalite);
		this.codemed = codemed;
		this.telephone = telephone;
		this.potentiel = potentiel;
		this.laSpecialite = laSpecialite;
	}

	public String getCodeMed() {
		return codemed;
	}
	
	public void setCodeMed(String codemed) {
		this.codemed = codemed;
	}
	
	public String getCodePersonne() {
		return codePersonne;
	}
	public void setCodePersonne(String codePersonne) {
		this.codePersonne = codePersonne;
	}
	public String getNomPersonne() {
		return nomPersonne;
	}
	
	public void setNomPersonne(String nomPersonne) {
		this.nomPersonne = nomPersonne;
	}
	public String getprenomPersonne() {
		return prenomPersonne;
	}
	public void setPrenomPersonne(String pernomPersonne) {
		this.prenomPersonne = prenomPersonne;
	}
	public String adresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	

	/**
	 * @return Renvoie telephone.
	 */
	public String getTelephone() {
		return telephone;
	}
	/**
	 * @param telephone telephone à définir.
	 */
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	/**
	 * @return Renvoie potentiel.
	 */
	public String getPotentiel() {
		return potentiel;
	}
	/**
	 * @param potentiel potentiel à définir.
	 */
	public void setPotentiel(String potentiel) {
		this.potentiel = potentiel;
	}
	
	
	public static specialite getLaSpecialite() {
		return laSpecialite;
	}
	public void setLaSpecialite(specialite laSpecialite) {
		this.laSpecialite = laSpecialite;
	}

}













