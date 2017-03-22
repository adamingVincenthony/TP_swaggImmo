package fr.adaming.entity;

import java.io.Serializable;

public class Client implements Serializable{
	private static final long serialVersionUID = 1L;
	
	//Attributs
	private int id_client;
	private int numero;
	private String nom;
	
	/**
	 * ctor vide
	 */
	public Client() {
		super();
	}
	
	/**
	 * ctor sans id
	 * @param numero
	 * @param nom
	 */
	public Client(int numero, String nom) {
		super();
		this.numero = numero;
		this.nom = nom;
	}
	
	/**
	 * ctor charge
	 * @param id_client
	 * @param numero
	 * @param nom
	 */
	public Client(int id_client, int numero, String nom) {
		super();
		this.id_client = id_client;
		this.numero = numero;
		this.nom = nom;
	}
	
	//Accesseurs
	public int getId_client() {
		return id_client;
	}
	public void setId_client(int id_client) {
		this.id_client = id_client;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	@Override
	public String toString() {
		return "Client [id_client=" + id_client + ", numero=" + numero + ", nom=" + nom + "]";
	}

	
	
	
}
