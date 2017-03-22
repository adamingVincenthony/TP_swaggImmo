package fr.adaming.entity;

import java.io.Serializable;
import java.util.List;

/**
 * 
 * @author Robin
 * La classe persistence Utilisateur 
 * Définie par un nom et mot de passe 
 * Peut-être associée à :
 * plusieurs biens, plusieurs visites et plusieurs contrats
 */
public class Utilisateur implements Serializable {

	/* les attributs */
	private static final long serialVersionUID = 1L;
	private int id;
	private String nom;
	private String password;
	
	/* les associations */
	/**
	 * Un utilisateur peut gérer plusieurs bien
	 */
	private List<Bien> listeBien;
	/**
	 * Un utilisateur peut avoir signé plusieurs contrats
	 */
	private List<Contrat> listeContrat;
	/**
	 * Un utilisateur peut avoir plusieures visites 
	 */
	private List<Visite> listeVisite;
	
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


	public List<Bien> getListeBien() {
		return listeBien;
	}


	public void setListeBien(List<Bien> listeBien) {
		this.listeBien = listeBien;
	}


	public List<Contrat> getListeContrat() {
		return listeContrat;
	}


	public void setListeContrat(List<Contrat> listeContrat) {
		this.listeContrat = listeContrat;
	}


	public List<Visite> getListeVisite() {
		return listeVisite;
	}


	public void setListeVisite(List<Visite> listeVisite) {
		this.listeVisite = listeVisite;
	}
	
	
	
}
