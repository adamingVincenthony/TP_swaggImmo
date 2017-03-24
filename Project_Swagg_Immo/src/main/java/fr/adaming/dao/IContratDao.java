package fr.adaming.dao;

import java.util.List;

import fr.adaming.entity.Bien;
import fr.adaming.entity.Client;
import fr.adaming.entity.Contrat;
import fr.adaming.entity.Utilisateur;

public interface IContratDao {

	public Contrat addContrat(Contrat c);
	public List<Contrat> findAllContrats();
	public Contrat getByIdContrat(int id_c);
	public Contrat updateContrat(Contrat c);
	public void deleteContrat(Contrat c);
	public void attribuer(Contrat contrat, Client client, Utilisateur responsable, Bien bien);

}
