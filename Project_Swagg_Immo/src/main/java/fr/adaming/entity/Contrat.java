package fr.adaming.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
/**
 * La classe persistence Contrat qui représente l'achat ou la location 
 * d'un bien par un client
 * @author inti0302
 *
 */
@Entity
@Table(name="contrats")
@XmlRootElement
public class Contrat implements Serializable{
	
	//Attributs
	private static final long serialVersionUID = 1L;	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_contrat")
	private int id;
	@Column(name="prix_contrat")
	private float prix;
	@Column(name="date_contrat")
	private Date date;
	@Column(name="reference_contrat")
	private long reference;
	
	/* Les associations :*/
	/**
	 * Un contrat concerne un bien
	 */
	@OneToOne
	private Bien bien;
	/**
	 * Un contrat est signé par un seul client
	 */
	@ManyToOne
	private Client client;
	/**
	 * Un contrat est signé par un seul responsable (Vraiment utile ?)
	 */
	@ManyToOne
	private Utilisateur responsable;
	
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

	

	@XmlElement
	public Date getDate() {
		return date;
	}
	@XmlElement
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	@XmlElement
	public float getPrix() {
		return prix;
	}

	public void setPrix(float prix) {
		this.prix = prix;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@XmlElement
	public long getReference() {
		return reference;
	}

	public void setReference(long reference) {
		this.reference = reference;
	}

	@XmlElement
	public Bien getBien() {
		return bien;
	}

	public void setBien(Bien bien) {
		this.bien = bien;
	}
	@XmlElement
	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}
	@XmlElement
	public Utilisateur getResponsable() {
		return responsable;
	}

	public void setResponsable(Utilisateur responsable) {
		this.responsable = responsable;
	}

	@Override
	public String toString() {
		return "Contrat [id=" + id + ", prix=" + prix + ", date=" + date + ", reference=" + reference + ", bien=" + bien
				+ ", client=" + client + ", responsable=" + responsable + "]";
	}



	
	
	
	
}
