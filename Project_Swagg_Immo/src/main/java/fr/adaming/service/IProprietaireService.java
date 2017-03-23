package fr.adaming.service;

import java.util.List;

import fr.adaming.entity.Proprietaire;

public interface IProprietaireService {
	
	public void addProprietaire(Proprietaire proprietaire);
	public List<Proprietaire> findAllProprietaire();
	public void deleteProprietaire(int id);
	public void updateProprietaire(Proprietaire proprietaire);
	public Proprietaire getByIdProprietaire(int id);
}
