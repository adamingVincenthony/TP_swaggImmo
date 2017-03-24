package fr.adaming.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * classe définissant tous les biens en location, elle hérite des attributs généraux des biens
 * @author inti0210
 *
 */
@Entity
@DiscriminatorValue("bien_a_louer")
@XmlRootElement
public class BienALouer extends Bien{

	
	private static final long serialVersionUID = 1L;
	
	
	@Column(name="caution_alouer")
	private double montantCaution;
	@Column(name="loyer_alouer")
	private double loyerMensuel;
	@Column(name="charge_alouer")
	private double loyerCharge;
	@Column(name="bail_alouer")
	private String typeBail;
	@Column(name="ameublement_alouer")
	private String ameublement;
	
	/**--------------------------- Constructeurs ----------------------------------------------------*/
	
	public BienALouer() {
		super();
	}

	
	public BienALouer(String type, String localisation, long revenuCadastral, String surface, Date dateSoumission, double montantCaution, double loyerMensuel, double loyerCharge,
			String typeBail, String ameublement) {
		super(type, localisation, revenuCadastral, surface, dateSoumission);
		this.montantCaution = montantCaution;
		this.loyerMensuel = loyerMensuel;
		this.loyerCharge = loyerCharge;
		this.typeBail = typeBail;
		this.ameublement = ameublement;
	}


	public BienALouer(double montantCaution, double loyerMensuel, double loyerCharge, String typeBail,
			String ameublement) {
		super();
		this.montantCaution = montantCaution;
		this.loyerMensuel = loyerMensuel;
		this.loyerCharge = loyerCharge;
		this.typeBail = typeBail;
		this.ameublement = ameublement;
	}

	/**------------------------------------ Getters et setters ----------------------------------------------------*/
	
	public double getMontantCaution() {
		return montantCaution;
	}

	public void setMontantCaution(double montantCaution) {
		this.montantCaution = montantCaution;
	}

	public double getLoyerMensuel() {
		return loyerMensuel;
	}

	public void setLoyerMensuel(double loyerMensuel) {
		this.loyerMensuel = loyerMensuel;
	}

	public double getLoyerCharge() {
		return loyerCharge;
	}

	public void setLoyerCharge(double loyerCharge) {
		this.loyerCharge = loyerCharge;
	}

	public String getTypeBail() {
		return typeBail;
	}

	public void setTypeBail(String typeBail) {
		this.typeBail = typeBail;
	}

	public String getAmeublement() {
		return ameublement;
	}

	public void setAmeublement(String ameublement) {
		this.ameublement = ameublement;
	}

	@Override
	public String toString() {
		return "BienALouer [montantCaution=" + montantCaution + ", loyerMensuel=" + loyerMensuel + ", loyerCharge="
				+ loyerCharge + ", typeBail=" + typeBail + ", ameublement=" + ameublement + "]";
	}
	
	
	
}
