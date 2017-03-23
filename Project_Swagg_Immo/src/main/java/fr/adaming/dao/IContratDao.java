package fr.adaming.dao;

import java.util.List;

import fr.adaming.entity.Contrat;

public interface IContratDao {

	public Contrat addContrat(Contrat p);
	public List<Contrat> findAllContrats();
	public Contrat getByIdContrat(int id_p);
	public Contrat updateContrat(Contrat p);
	public void deleteContrat(Contrat p);
}
