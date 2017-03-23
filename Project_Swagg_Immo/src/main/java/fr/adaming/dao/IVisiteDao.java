package fr.adaming.dao;

import java.util.List;

import fr.adaming.entity.Visite;

public interface IVisiteDao {

	public Visite addVisite(Visite p);
	public List<Visite> findAllVisites();
	public Visite getByIdVisite(int id_p);
	public Visite updateVisite(Visite p);
	public void deleteVisite(Visite p);
	
}
