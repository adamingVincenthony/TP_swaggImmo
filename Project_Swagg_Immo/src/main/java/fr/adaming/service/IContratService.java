package fr.adaming.service;

import java.util.List;

import fr.adaming.entity.Contrat;

public interface IContratService {
	
	public void addContrat(Contrat contrat);
	public List<Contrat> findAllContrat();
	public void deleteContrat(int id);
	public void updateContrat(Contrat contrat);
	public Contrat getByIdContrat(int id);
}
