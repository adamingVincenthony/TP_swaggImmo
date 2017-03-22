package fr.adaming.entity;

import java.io.Serializable;
import java.util.Date;

public class Contrat implements Serializable{
	private static final long serialVersionUID = 1L;
	
	//Attributs
	private int id_contrat;
	private float prixContrat;
	private Date date;
	private long reference;
	
	/**
	 * ctor vide
	 */
	public Contrat() {
		super();
	}
	
	/**
	 * ctor sans id
	 * @param prixContrat
	 * @param date
	 * @param reference
	 */
	public Contrat(float prixContrat, Date date, long reference) {
		super();
		this.prixContrat = prixContrat;
		this.date = date;
		this.reference = reference;
	}
	
	/**
	 * ctor charge
	 * @param id_contrat
	 * @param prixContrat
	 * @param date
	 * @param reference
	 */
	public Contrat(int id_contrat, float prixContrat, Date date, long reference) {
		super();
		this.id_contrat = id_contrat;
		this.prixContrat = prixContrat;
		this.date = date;
		this.reference = reference;
	}

	// accesseurs
	public int getId_contrat() {
		return id_contrat;
	}

	public void setId_contrat(int id_contrat) {
		this.id_contrat = id_contrat;
	}

	public float getPrixContrat() {
		return prixContrat;
	}

	public void setPrixContrat(float prixContrat) {
		this.prixContrat = prixContrat;
	}

	public Date getDate() {
		return date;
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

	@Override
	public String toString() {
		return "Contrat [id_contrat=" + id_contrat + ", prixContrat=" + prixContrat + ", date=" + date + ", reference="
				+ reference + "]";
	}
	
	
	
}
