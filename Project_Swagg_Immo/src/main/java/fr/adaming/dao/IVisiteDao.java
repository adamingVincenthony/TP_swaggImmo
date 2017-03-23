package fr.adaming.dao;

import java.util.List;

import fr.adaming.entity.Visite;

public interface IVisiteDao {

	public Visite addVisite(Visite v);
	public List<Visite> findAllVisites();
	public Visite getByIdVisite(int id_v);
	public Visite updateVisite(Visite v);
	public void deleteVisite(Visite v);
	
}
