package fr.adaming.service;

import java.util.List;

import fr.adaming.entity.Contrat;

public interface IContratService {
	
	/**
	 * m�thode CRUD de la gestion des contrats
	 * @param contrat
	 * @return
	 */
	public Contrat addContrat(Contrat contrat);
	public List<Contrat> findAllContrat();
	public void deleteContrat(int id);
	public void updateContrat(Contrat contrat);
	public Contrat getByIdContrat(int id);
	
	/**
	 * m�thode d'attribution d'un contrat � un client, un bien et un responsable
	 * @param idContrat
	 * @param idClient
	 * @param idResponsable
	 * @param idBien
	 */
	public void  attribuer(int idContrat, int idClient, int idResponsable, int idBien);
}
