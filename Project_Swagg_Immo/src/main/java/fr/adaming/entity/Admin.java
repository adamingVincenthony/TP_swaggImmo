package fr.adaming.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="admins")
public class Admin implements Serializable {
	
	/**
	 * attributs de la classe admin
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_admin")
	private int idAdmin;
	@Column(name="nom_admin")
	private String nom;
	@Column(name="password_admin")
	private String password;
	
	/**
	 * constructeurs 
	 */
	
	public Admin(int idAdmin, String password) {
		super();
		this.idAdmin = idAdmin;
		this.password = password;
	}
	
	public Admin(String nom, String password) {
		super();
		this.nom = nom;
		this.password = password;
	}

	public Admin() {
		super();
	}


	/**
	 * get et set
	 * @return
	 */
	public int getIdAdmin() {
		return idAdmin;
	}

	public void setIdAdmin(int idAdmin) {
		this.idAdmin = idAdmin;
	}
	
	
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}


	/**
	 * toString pour l'affichage du résultat
	 */
	@Override
	public String toString() {
		return "Admin [idAdmin=" + idAdmin + ", nom=" + nom + ", password=" + password + "]";
	}
	
	
	
	
}
