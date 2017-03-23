package fr.adaming.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
/**
 * classe définissant les bien à l'achat (sauf les terrains)
 * @author inti0210
 *
 */
@Entity
@Table(name="bien_aacheter")
@XmlRootElement
public class BienAAcheter {

	@Column(name="etat_aacheter")
	private String etatBien;

	/**------------------------------ Constructeurs ---------------------------------------------*/
	
	public BienAAcheter() {
		super();
	}

	public BienAAcheter(String etatBien) {
		super();
		this.etatBien = etatBien;
	}

	/**------------------------------ Getters et setters ---------------------------------------------*/
	
	public String getEtatBien() {
		return etatBien;
	}

	public void setEtatBien(String etatBien) {
		this.etatBien = etatBien;
	}

	/**------------------------------ Autres methodes ---------------------------------------------*/
	
	@Override
	public String toString() {
		return "BienAAcheter [etatBien=" + etatBien + "]";
	}
	
	
	
}
