package com.example.topcolleguesbackend.entite;

public class AjoutCollegue {

	private String matricule;

	private String pseudo;

	private String url;

	public AjoutCollegue(/* String matricule, String pseudo, String urlImage */) {
		/*
		 * this.matricule = matricule; this.pseudo = pseudo; this.urlImage =
		 * urlImage;
		 */
	}

	/**
	 * Getter
	 * 
	 * @return the matricule
	 */
	public String getMatricule() {
		return matricule;
	}

	/**
	 * Setter
	 * 
	 * @param matricule
	 *            the matricule to set
	 */
	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}

	/**
	 * Getter
	 * 
	 * @return the pseudo
	 */
	public String getPseudo() {
		return pseudo;
	}

	/**
	 * Setter
	 * 
	 * @param pseudo
	 *            the pseudo to set
	 */
	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	/**
	 * Getter
	 * 
	 * @return the urlImage
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * Setter
	 * 
	 * @param urlImage
	 *            the urlImage to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}

}
