package modele;

public class specialite {
	

	protected int codeSpe ;
	protected String nomSpe;
	/**
	 * @param codeSpe
	 * @param nomSpe
	 */
	public specialite(int codeSpe, String nomSpe) {	
		this.codeSpe = codeSpe;
		this.nomSpe = nomSpe;
	}

	
	public int getCodeSpe() {
		return codeSpe;
	}
	public void setCodeSpe(int codeSpe) {
		this.codeSpe = codeSpe;
	}
	public String getNomSpe() {
		return nomSpe;
	}
	public void setNomSpe(String nomSpe) {
		this.nomSpe = nomSpe;
	}	
}
