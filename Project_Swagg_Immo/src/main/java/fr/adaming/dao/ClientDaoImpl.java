package fr.adaming.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import fr.adaming.entity.Client;

public class ClientDaoImpl implements IClientDao{

	@Autowired
	private SessionFactory sf;

	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}
	
	@Override
	public Client addClient(Client p) {
		
		return (Client) sf.getCurrentSession().save(p);
	}

	@Override
	public List<Client> findAllClients() {
		String req="SELECT p from Client p";
		return sf.getCurrentSession().createQuery(req).list();
	}

	@Override
	public Client getByIdClient(int id_p) {
		return (Client) sf.getCurrentSession().get(Client.class, id_p);
	}

	@Override
	public Client updateClient(Client p) {
		return (Client) sf.getCurrentSession().merge(p);
	}

	@Override
	public void deleteClient(Client p) {
		sf.getCurrentSession().delete(p);
	}
}
