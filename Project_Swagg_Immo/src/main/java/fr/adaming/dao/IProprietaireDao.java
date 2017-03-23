package fr.adaming.dao;

import java.util.List;

import fr.adaming.entity.Proprietaire;

public interface IProprietaireDao {
	
	public Proprietaire addProprietaire(Proprietaire p);
	public List<Proprietaire> findAllProprietaires();
	public Proprietaire getByIdProprietaire(int id_p);
	public Proprietaire updateProprietaire(Proprietaire p);
	public void deleteProprietaire(Proprietaire p);

}
