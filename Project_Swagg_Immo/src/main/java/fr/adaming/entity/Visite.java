package fr.adaming.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * 
 * @author Robin
 * Entitée persistente qui correspond aux visites de bien.
 * Une visite est associé à un bien, un responsable(Conseiller), un client 
 * et une date
 */
@Entity
@Table(name="visites")
@XmlRootElement
public class Visite implements Serializable {

	/* Les attributs */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_visite")
	private int id;
	@Column(name="date_visite")
	private Date date;
	
	/*Les associations */
	/**
	 * Une visite concerne un bien
	 */
	@ManyToOne
	@JoinColumn(name="bien_id_fk",referencedColumnName="id_bien")
	private Bien bien;
	/**
	 * Une visite concerne un client
	 */
	@ManyToOne
	@JoinColumn(name="client_id_fk",referencedColumnName="id_client")
	private Client client;
	/**
	 * Une visite concerne un responsable
	*/
	@ManyToOne
	@JoinColumn(name="user_id_fk",referencedColumnName="id_user")
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
	@XmlElement
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@XmlElement
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	@XmlTransient
	public Bien getBien() {
		return bien;
	}

	public void setBien(Bien bien) {
		this.bien = bien;
	}
	@XmlTransient
	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	@XmlTransient
	public Utilisateur getResponsable() {
		return responsable;
	}

	public void setResponsable(Utilisateur responsable) {
		this.responsable = responsable;
	}
	
	
	
}
