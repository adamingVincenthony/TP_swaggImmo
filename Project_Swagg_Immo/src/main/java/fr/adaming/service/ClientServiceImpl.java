package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IClientDao;
import fr.adaming.dao.ClientDaoImpl;
import fr.adaming.entity.Client;

@Service
@Transactional
public class ClientServiceImpl implements IClientService{

	@Autowired
	private IClientDao clientDao = new ClientDaoImpl();
	
	
	/**
	 * setter
	 * @param clientDao
	 */
	public void setClientDao(IClientDao clientDao) {
		this.clientDao = clientDao;
	}

	/**
	 * Ajoute un client en appelant la methode associ�e de la dao
	 */
	@Override
	public void addClient(Client client) {
		
		clientDao.addClient(client);
	}
	
	/**
	 * Recupere une liste de client
	 */
	@Override
	public List<Client> findAllClient() {
		return clientDao.findAllClients();
	}

	
	/**
	 * Supprime un client
	 */
	@Override
	public void deleteClient(int id) {
		Client client = clientDao.getByIdClient(id);
		clientDao.deleteClient(client);
		
	}

	/**
	 * Modifie un client
	 */
	@Override
	public void updateClient(Client client) {
		clientDao.updateClient(client);
		
	}

	/**
	 * Recupere un client par son Id
	 */
	@Override
	public Client getByIdClient(int id) {
		return clientDao.getByIdClient(id);
	}
	
	
	/**
	 * affecter un bien � un client
	 */
	
	

}