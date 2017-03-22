package fr.adaming.entity;

import java.io.Serializable;
import java.util.List;

public class Client implements Serializable{
	private static final long serialVersionUID = 1L;
	
	//Attributs
	private int id;
	private int numero;
	private String nom;
	
	/* Les associations */
	
	/**
	 * Un client peut-être intéressé par plusieurs bien 
	 */
	private List<Bien> listeInteret;
	/**
	 * Un client peut avoir plusieurs contrat avec l'agence
	 */
	private List<Contrat> listeContrat;
	/**
	 * Un client peut réaliser plusieures visites
	 */
	private List<Visite> listeVisite;
	
	
	/**
	 * ctor vide
	 */
	public Client() {
		super();
	}
	
	/**
	 * ctor sans id
	 * @param numero
	 * @param nom
	 */
	public Client(int numero, String nom) {
		super();
		this.numero = numero;
		this.nom = nom;
	}
	
	/**
	 * ctor charge
	 * @param id_client
	 * @param numero
	 * @param nom
	 */
	public Client(int id, int numero, String nom) {
		super();
		this.id = id;
		this.numero = numero;
		this.nom = nom;
	}
	
	//Accesseurs

	
	public int getNumero() {
		return numero;
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public List<Bien> getListeInteret() {
		return listeInteret;
	}

	public void setListeInteret(List<Bien> listeInteret) {
		this.listeInteret = listeInteret;
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

	@Override
	public String toString() {
		return "Client [id=" + id + ", numero=" + numero + ", nom=" + nom + ", listeInteret=" + listeInteret
				+ ", listeContrat=" + listeContrat + ", listeVisite=" + listeVisite + "]";
	}

	
	
	
	
}
