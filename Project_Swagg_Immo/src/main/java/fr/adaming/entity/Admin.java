package fr.adaming.entity;

public class Admin {
	
	/**
	 * attributs de la classe admin
	 */
	private int idAdmin;
	private String password;
	
	/**
	 * constructeurs 
	 */
	
	public Admin(int idAdmin, String password) {
		super();
		this.idAdmin = idAdmin;
		this.password = password;
	}
	
	public Admin(String password) {
		super();
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
		return "Admin [idAdmin=" + idAdmin + ", password=" + password + "]";
	}
	
	
	
}
