package fr.adaming.service;

import java.util.List;

import fr.adaming.entity.Visite;

public interface IVisiteService {
	
	public void addVisite(Visite visite);
	public List<Visite> findAllVisite();
	public void deleteVisite(int id);
	public void updateVisite(Visite visite);
	public Visite getByIdVisite(int id);
}
