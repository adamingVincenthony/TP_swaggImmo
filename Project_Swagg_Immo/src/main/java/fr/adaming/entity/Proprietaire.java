package fr.adaming.entity;

import java.io.Serializable;

public class Proprietaire implements Serializable {

/**
 * attributs
 */
	private int idProprietaire;
	private String password;
	
// à ajouter avec les associations
//	private List<Bien> listeBiens;
	
	/**
	 * constructeurs
	 */
	public Proprietaire() {
		super();
	}
	
	public Proprietaire(String password) {
		super();
		this.password = password;
	}

	public Proprietaire(int idProprietaire, String password) {
		super();
		this.idProprietaire = idProprietaire;
		this.password = password;
	}
	
	
	/**
	 * get et set
	 * @return
	 */
	public int getIdProprietaire() {
		return idProprietaire;
	}
	public void setIdProprietaire(int idProprietaire) {
		this.idProprietaire = idProprietaire;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
/**
 * toString pour l'affichage du résultat
 */
	@Override
	public String toString() {
		return "Proprietaire [idProprietaire=" + idProprietaire + ", password=" + password + "]";
	}
	
	
}
