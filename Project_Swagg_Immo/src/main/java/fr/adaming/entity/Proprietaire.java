package fr.adaming.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name="proprietaires")
@XmlRootElement
public class Proprietaire implements Serializable {

	/* Les attributs */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_prop")
	private int id;
	@Column(name="nom_prop")
	private String nom;
	@Column(name="adresse_prop")
	private String adresse;
	@Column(name="numprive_prop")
	private String numeroPrive;
	@Column(name="numtravail_prop")
	private String numeroTravail;
	
	/* Les associations */
	/**
	 * Un propriétaire est associé à un ou plusieurs bien
	 */

	@OneToMany(mappedBy="proprietaire")
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
	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	@XmlElement
	public String getNumeroPrive() {
		return numeroPrive;
	}

	public void setNumeroPrive(String numeroPrive) {
		this.numeroPrive = numeroPrive;
	}

	@XmlElement
	public String getNumeroTravail() {
		return numeroTravail;
	}

	public void setNumeroTravail(String numeroTravail) {
		this.numeroTravail = numeroTravail;
	}

	@XmlElement
	public List<Bien> getListeBien() {
		return listeBien;
	}

	public void setListeBien(List<Bien> listeBien) {
		this.listeBien = listeBien;
	}
	
	
	
	
}
