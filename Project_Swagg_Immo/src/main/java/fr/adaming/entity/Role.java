package fr.adaming.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "roles")
public class Role {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_r")
	private int id;
	private String rolename;
	
	public Role() {
		super();
	}
	
	public Role(String rolename) {
		super();
		this.rolename = rolename;
	}

	public Role(int id, String rolename) {
		super();
		this.id = id;
		this.rolename = rolename;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRolename() {
		return rolename;
	}

	public void setRolename(String rolename) {
		this.rolename = rolename;
	}

	
	
	
	
}
