package fr.adaming.entity;

import java.io.Serializable;

/**
 * 
 * @author Robin
 * La classe persistence Utilisateur 
 * Définie par un nom et mot de passe 
 * Peut-être associée à :
 * plusieurs biens, plusieurs visites et plusieurs contrats
 */
public class Utilisateur implements Serializable {

	private static final long serialVersionUID = 1L;
	private int id;
	private String nom;
	private String password;
	
	/**
	 * ctor 
	 * 1 vide
	 * 1 avec nom et mot de passe
	 * 1 complet
	 */
	public Utilisateur() {
		super();
	}


	public Utilisateur(String nom, String password) {
		super();
		this.nom = nom;
		this.password = password;
	}


	public Utilisateur(int id, String nom, String password) {
		super();
		this.id = id;
		this.nom = nom;
		this.password = password;
	}


	/**
	 * Les getters et setters
	 */
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
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
	
	
	
}
