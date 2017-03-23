package fr.adaming.dao;

import java.util.List;

import fr.adaming.entity.Client;

public interface IClientDao {

	public Client addClient(Client p);
	public List<Client> findAllClients();
	public Client getByIdClient(int id_p);
	public Client updateClient(Client p);
	public void deleteClient(Client p);
}
