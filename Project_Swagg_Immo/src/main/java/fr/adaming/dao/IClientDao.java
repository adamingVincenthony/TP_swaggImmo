package fr.adaming.dao;

import java.util.List;

import fr.adaming.entity.Client;

public interface IClientDao {

	public Client addClient(Client c);
	public List<Client> findAllClients();
	public Client getByIdClient(int id_c);
	public Client updateClient(Client c);
	public void deleteClient(Client c);
}
