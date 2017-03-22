package fr.adaming.entity;

import java.io.Serializable;
import java.util.Date;

public class Contrat implements Serializable{
	private static final long serialVersionUID = 1L;
	
	//Attributs
	private int id;
	private float prix;
	private Date date;
	private long reference;
	
	/* Les associations :*/
	/**
	 * Un contrat concerne un bien
	 */
	private Bien bien;
	/**
	 * Un contrat est signé par un seul client
	 */
	private Client client;
	/**
	 * Un contrat est signé par un seul responsable (Vraiment utile ?)
	 */
	private Utilisateur utilisateur;
	
	/**
	 * ctor vide
	 */
	public Contrat() {
		super();
	}
	
	/**
	 * ctor sans id
	 * @param prix
	 * @param date
	 * @param reference
	 */
	public Contrat(float prix, Date date, long reference) {
		super();
		this.prix = prix;
		this.date = date;
		this.reference = reference;
	}
	
	/**
	 * ctor charge
	 * @param id
	 * @param prix
	 * @param date
	 * @param reference
	 */
	public Contrat(int id, float prix, Date date, long reference) {
		super();
		this.id = id;
		this.prix = prix;
		this.date = date;
		this.reference = reference;
	}

	// accesseurs

	

	public Date getDate() {
		return date;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public float getPrix() {
		return prix;
	}

	public void setPrix(float prix) {
		this.prix = prix;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public long getReference() {
		return reference;
	}

	public void setReference(long reference) {
		this.reference = reference;
	}

	
	public Bien getBien() {
		return bien;
	}

	public void setBien(Bien bien) {
		this.bien = bien;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	@Override
	public String toString() {
		return "Contrat [id=" + id + ", prix=" + prix + ", date=" + date + ", reference=" + reference + ", bien=" + bien
				+ ", client=" + client + ", utilisateur=" + utilisateur + "]";
	}

	
	
	
	
}
