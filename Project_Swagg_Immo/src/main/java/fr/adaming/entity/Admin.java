package fr.adaming.entity;

import java.io.Serializable;

public class Admin implements Serializable {
	
	/**
	 * attributs de la classe admin
	 */
	private static final long serialVersionUID = 1L;
	private int idAdmin;
	private String nom;
	private String password;
	
	/**
	 * constructeurs 
	 */
	
	public Admin(int idAdmin, String password) {
		super();
		this.idAdmin = idAdmin;
		this.password = password;
	}
	
	public Admin(String nom, String password) {
		super();
		this.nom = nom;
		this.password = password;
	}

	public Admin() {
		super();
	}


	/**
	 * get et set
	 * @return
	 */
	public int getIdAdmin() {
		return idAdmin;
	}

	public void setIdAdmin(int idAdmin) {
		this.idAdmin = idAdmin;
	}
	
	
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
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
		return "Admin [idAdmin=" + idAdmin + ", nom=" + nom + ", password=" + password + "]";
	}
	
	
	
	
}
