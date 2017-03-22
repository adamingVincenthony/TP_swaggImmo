package fr.adaming.entity;

import java.io.Serializable;
import java.util.List;

public class Proprietaire implements Serializable {

	/* Les attributs */
	private static final long serialVersionUID = 1L;
	private int id;
	private String nom;
	private String adresse;
	private String numeroPrive;
	private String numeroTravail;
	
	/* Les associations */
	/**
	 * Un propriétaire est associé à un ou plusieurs bien
	 */
	private List<Bien> listeBien;

	/* Les constructeurs */
	/** constructeur vide*/
	public Proprietaire() {
		super();
	}

	/** constructeur sans id */
	public Proprietaire(String nom, String adresse, String numeroPrive, String numeroTravail) {
		super();
		this.nom = nom;
		this.adresse = adresse;
		this.numeroPrive = numeroPrive;
		this.numeroTravail = numeroTravail;
	}

	/** constructeur chargé */
	public Proprietaire(int id, String nom, String adresse, String numeroPrive, String numeroTravail) {
		super();
		this.id = id;
		this.nom = nom;
		this.adresse = adresse;
		this.numeroPrive = numeroPrive;
		this.numeroTravail = numeroTravail;
	}

	/* getter et setters */
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

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getNumeroPrive() {
		return numeroPrive;
	}

	public void setNumeroPrive(String numeroPrive) {
		this.numeroPrive = numeroPrive;
	}

	public String getNumeroTravail() {
		return numeroTravail;
	}

	public void setNumeroTravail(String numeroTravail) {
		this.numeroTravail = numeroTravail;
	}

	public List<Bien> getListeBien() {
		return listeBien;
	}

	public void setListeBien(List<Bien> listeBien) {
		this.listeBien = listeBien;
	}
	
	
	
	
}
