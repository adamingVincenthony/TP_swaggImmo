package fr.adaming.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @author Robin
 * Entitée persistente qui correspond aux visites de bien.
 * Une visite est associé à un bien, un responsable(Conseiller), un client 
 * et une date
 */
public class Visite implements Serializable {

	/* Les attributs */
	private static final long serialVersionUID = 1L;
	private int id;
	private Date date;
	
	/*Les associations */
	/**
	 * Une visite concerne un bien
	 */
	private Bien bien;
	/**
	 * Une visite concerne un client
	 */
	private Client client;
	/**
	 * Une visite concerne un responsable
	 */
	private Utilisateur responsable;
	
	/* Les constructeurs */
	
	/**
	 * Constructeur vide
	 */
	public Visite() {
		super();
	}
	
	/**
	 * Constructeur avec paramètre snas id
	 */
	public Visite(Date date) {
		super();
		this.date = date;
	}

	/**
	 * Constructeur chargé
	 */
	public Visite(int id, Date date) {
		super();
		this.id = id;
		this.date = date;
	}
	


	/**
	 * Getter et setters
	 * 
	 */
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
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

	public Utilisateur getResponsable() {
		return responsable;
	}

	public void setResponsable(Utilisateur responsable) {
		this.responsable = responsable;
	}
	
	
	
}
