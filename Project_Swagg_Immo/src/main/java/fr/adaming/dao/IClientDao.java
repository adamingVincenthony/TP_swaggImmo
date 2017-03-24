package fr.adaming.dao;

import java.util.List;

import fr.adaming.entity.Client;

public interface IClientDao {

	/**
	 * méthode CRUD de la gestion des clients
	 */
	public Client addClient(Client c);
	public List<Client> findAllClients();
	public Client getByIdClient(int id_c);
	public Client updateClient(Client c);
	public void deleteClient(Client c);
}
