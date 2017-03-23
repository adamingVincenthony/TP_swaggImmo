package fr.adaming.service;

import java.util.List;

import fr.adaming.entity.Client;

public interface IClientService {
	
	public void addClient(Client bien);
	public List<Client> findAllClient();
	public void deleteClient(int id);
	public void updateClient(Client client);
	public Client getByIdClient(int id);
	
}