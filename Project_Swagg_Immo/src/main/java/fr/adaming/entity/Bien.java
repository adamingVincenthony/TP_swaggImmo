package fr.adaming.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Classe définissant les caractéristiques du bien immobilier
 * @author inti0210
 */
@Entity
@Table(name="biens")
@XmlRootElement
//ajout de la strategy de génération de table
public class Bien implements Serializable{


	/* les attributs */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_bien")
	private int id;
	@Column(name="statut_bien")
	private String statut;
	@Column(name="type_bien") //que cette colone soit le discrimant dans la single table ?
	private String type;
	@Column (name="soumission_bien")
	private Date dateSoumission;
	@Column (name="dispo_bien")
	private Date dateDispo;
	@Column (name="localisation_bien")
	private String localisation;
	@Column (name="revenucad_bien")
	private long revenuCadastral;
	@Column (name="surface_bien")
	private String surface; //en declarant la surface en tant que String on peut utiliser les pareurs suivant le type de bien
	
	
	/*Déclaration des associations */
	
	/**
	 * Association avec un propriétaire : 
	 * chaque bien appartient à un propriétaire
	 */

	private Proprietaire proprietaire;
	/**
	 * Association avec un utilisateur :
	 * Chaque bien est géré par un Conseiler Clientèle
	 */
	
	private Utilisateur responsable;
	/**
	 * Association avec les clients intéressés :
	 * Chaque bien peut être le centre d'intêret de plusieurs clients
	 */

	private List<Client> clientInteret;
	/**
	 * Association avec un contrat :
	 * Un bien peut éventuellement être lié à un client via un contrat
	 */
	
	private Contrat contrat;
	
	/**
	 * Association avec une visite :
	 * Un bien peut être visité différentes fois
	 * Mais une visite ne concerne qu'un seul bien
	 */
	
	private List<Visite> listeVisite;
	
	
	/** -----------------------------------------Constructeurs -------------------------------------------*/ 
	
	/**
	 * Constructeurs vide
	 */
	public Bien() {
		super();
	}
	/**
	 * Constructeur sans id
	 * @param statut
	 * @param type
	 * @param dateSoumission
	 * @param dateDispo
	 * @param localisation
	 * @param revenuCadastral
	 * @param surface
	 */
	public Bien(String statut, String type, Date dateSoumission, Date dateDispo, String localisation,
			long revenuCadastral, String surface) {
		super();
		this.statut = statut;
		this.type = type;
		this.dateSoumission = dateSoumission;
		this.dateDispo = dateDispo;
		this.localisation = localisation;
		this.revenuCadastral = revenuCadastral;
		this.surface = surface;
	}

	/**
	 * Constructeur avec id
	 * @param id
	 * @param statut
	 * @param type
	 * @param dateSoumission
	 * @param dateDispo
	 * @param localisation
	 * @param revenuCadastral
	 * @param surface
	 */
	public Bien(int id, String statut, String type, Date dateSoumission, Date dateDispo, String localisation,
			long revenuCadastral, String surface) {
		super();
		this.id = id;
		this.statut = statut;
		this.type = type;
		this.dateSoumission = dateSoumission;
		this.dateDispo = dateDispo;
		this.localisation = localisation;
		this.revenuCadastral = revenuCadastral;
		this.surface = surface;
	}
	
	/** -------------------------------Getters et setters-----------------------------------------------*/
	
	@XmlElement
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@XmlElement
	public String getStatut() {
		return statut;
	}
	public void setStatut(String statut) {
		this.statut = statut;
	}
	@XmlElement
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	@XmlElement
	public Date getDateSoumission() {
		return dateSoumission;
	}
	public void setDateSoumission(Date dateSoumission) {
		this.dateSoumission = dateSoumission;
	}
	@XmlElement
	public Date getDateDispo() {
		return dateDispo;
	}
	public void setDateDispo(Date dateDispo) {
		this.dateDispo = dateDispo;
	}
	@XmlElement
	public String getLocalisation() {
		return localisation;
	}
	public void setLocalisation(String localisation) {
		this.localisation = localisation;
	}
	@XmlElement
	public String getSurface() {
		return surface;
	}
	public void setSurface(String surface) {
		this.surface = surface;
	}
	@XmlElement
	public Proprietaire getProprietaire() {
		return proprietaire;
	}
	public void setProprietaire(Proprietaire proprietaire) {
		this.proprietaire = proprietaire;
	}
	@XmlElement
	public long getRevenuCadastral() {
		return revenuCadastral;
	}
	public void setRevenuCadastral(long revenuCadastral) {
		this.revenuCadastral = revenuCadastral;
	}
	@XmlElement
	public Utilisateur getResponsable() {
		return responsable;
	}
	public void setResponsable(Utilisateur responsable) {
		this.responsable = responsable;
	}
	@XmlElement
	public List<Client> getClientInteret() {
		return clientInteret;
	}
	public void setClientInteret(List<Client> clientInteret) {
		this.clientInteret = clientInteret;
	}
	@XmlElement
	public Contrat getContrat() {
		return contrat;
	}
	public void setContrat(Contrat contrat) {
		this.contrat = contrat;
	}
	
	@XmlElement
	public List<Visite> getListeVisite() {
		return listeVisite;
	}
	public void setListeVisite(List<Visite> listeVisite) {
		this.listeVisite = listeVisite;
	}
	/**--------------------------------------------------Autres méthodes------------------------------------*/
	
	@Override
	public String toString() {
		return "Bien [id=" + id + ", statut=" + statut + ", type=" + type + ", dateSoumission=" + dateSoumission
				+ ", dateDispo=" + dateDispo + ", localisation=" + localisation + ", revenuCadastral=" + revenuCadastral
				+ ", surface=" + surface + "]";
	}
	
	
	
	
	
}
