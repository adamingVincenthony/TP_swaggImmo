package fr.adaming.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 
 * @author Robin
 * La classe persistence Utilisateur 
 * Définie par un nom et mot de passe 
 * Peut-être associée à :
 * plusieurs biens, plusieurs visites et plusieurs contrats
 */
@Entity
@Table(name="utilisateurs")
@XmlRootElement
public class Utilisateur implements Serializable {

	/* les attributs */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_user")
	private int id;
	@Column(name="nom_user")
	private String nom;
	@Column(name="mdp_user")
	private String password;
	
	/* les associations */
	/**
	 * Un utilisateur peut gérer plusieurs bien
	 */
	@OneToMany(mappedBy="responsable")
	private List<Bien> listeBien;
	/**
	 * Un utilisateur peut avoir signé plusieurs contrats
	 */
	@OneToMany(mappedBy="responsable")
	private List<Contrat> listeContrat;
	/**
	 * Un utilisateur peut avoir plusieures visites 
	 */
	@OneToMany(mappedBy="responsable")
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
	@XmlElement
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}

	@XmlElement
	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}

	@XmlElement
	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	@XmlElement
	public List<Bien> getListeBien() {
		return listeBien;
	}


	public void setListeBien(List<Bien> listeBien) {
		this.listeBien = listeBien;
	}

	@XmlElement
	public List<Contrat> getListeContrat() {
		return listeContrat;
	}


	public void setListeContrat(List<Contrat> listeContrat) {
		this.listeContrat = listeContrat;
	}

	@XmlElement
	public List<Visite> getListeVisite() {
		return listeVisite;
	}


	public void setListeVisite(List<Visite> listeVisite) {
		this.listeVisite = listeVisite;
	}
	
	
	
}
