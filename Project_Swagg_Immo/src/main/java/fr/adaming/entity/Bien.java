package fr.adaming.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * Classe définissant les caractéristiques du bien immobilier
 * @author inti0210
 *
 */
public class Bien implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String statut;
	private String type;
	private Date dateSoumission;
	private Date dateDispo;
	private String localisation;
	private long revenuCadastral;
	private String surface; //en declarant la surface en tant que String on peut utiliser les pareurs suivant le type de bien
	
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
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getStatut() {
		return statut;
	}
	public void setStatut(String statut) {
		this.statut = statut;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Date getDateSoumission() {
		return dateSoumission;
	}
	public void setDateSoumission(Date dateSoumission) {
		this.dateSoumission = dateSoumission;
	}
	public Date getDateDispo() {
		return dateDispo;
	}
	public void setDateDispo(Date dateDispo) {
		this.dateDispo = dateDispo;
	}
	public String getLocalisation() {
		return localisation;
	}
	public void setLocalisation(String localisation) {
		this.localisation = localisation;
	}
	public long getRevenucadastral() {
		return revenuCadastral;
	}
	public void setRevenucadastral(long revenuCadastral) {
		this.revenuCadastral = revenuCadastral;
	}
	public String getSurface() {
		return surface;
	}
	public void setSurface(String surface) {
		this.surface = surface;
	}
	
	/**--------------------------------------------------Autres méthodes------------------------------------*/
	
	@Override
	public String toString() {
		return "Bien [id=" + id + ", statut=" + statut + ", type=" + type + ", dateSoumission=" + dateSoumission
				+ ", dateDispo=" + dateDispo + ", localisation=" + localisation + ", revenuCadastral=" + revenuCadastral
				+ ", surface=" + surface + "]";
	}
	
	
	
	
}
