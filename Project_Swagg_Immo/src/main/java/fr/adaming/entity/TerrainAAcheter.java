package fr.adaming.entity;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlRootElement;
/**
 * classe définissant les bien et les terrains à l'achat et qui hérite des attributs globaux de la classe Bien
 * @author inti0210
 *
 */
@Entity
@DiscriminatorValue("terrain_a_acheter")
@XmlRootElement
public class TerrainAAcheter extends Bien{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name="prix_aacheter")
	private long prixAchat;

	/**------------------------------ Constructeurs ---------------------------------------------*/
	
	public TerrainAAcheter() {
		super();
	}

	public TerrainAAcheter(long prixAchat) {
		super();
		this.prixAchat = prixAchat;
	}

	/**---------------------------- Getters et setters----------------------------------------------------*/
	
	public long getPrixAchat() {
		return prixAchat;
	}

	public void setPrixAchat(long prixAchat) {
		this.prixAchat = prixAchat;
	}

	/**------------------------ Autres methodes ------------------------------------*/
	@Override
	public String toString() {
		return "BienAAcheterToutType [prixAchat=" + prixAchat + "]";
	}
	
	
	
}
