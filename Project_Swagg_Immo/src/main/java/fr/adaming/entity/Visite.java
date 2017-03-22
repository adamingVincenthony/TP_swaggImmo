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


	private static final long serialVersionUID = 1L;
	private int id;
	private Date date;
	
	
	/**
	 * Les constructeurs 
	 * 1 vide
	 * 1 avec la date
	 * 1 complet
	 * 
	 */
	public Visite() {
		super();
	}
	
	public Visite(Date date) {
		super();
		this.date = date;
	}

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
	
	
}
