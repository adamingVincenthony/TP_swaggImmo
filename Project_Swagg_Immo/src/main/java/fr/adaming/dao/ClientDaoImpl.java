package fr.adaming.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import fr.adaming.entity.Client;
/**
 * methodes permettant de gérer les clients dans la bdd
 * @author inti0210
 *
 */
public class ClientDaoImpl implements IClientDao{

	@Autowired
	private SessionFactory sf;

	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}
	
	@Override
	public Client addClient(Client cl) {
		
		return (Client) sf.getCurrentSession().save(cl);
	}

	@Override
	public List<Client> findAllClients() {
		String req="SELECT cl from Client cl";
		return sf.getCurrentSession().createQuery(req).list();
	}

	@Override
	public Client getByIdClient(int id_cl) {
		return (Client) sf.getCurrentSession().get(Client.class, id_cl);
	}

	@Override
	public Client updateClient(Client cl) {
		return (Client) sf.getCurrentSession().merge(cl);
	}

	@Override
	public void deleteClient(Client cl) {
		sf.getCurrentSession().delete(cl);
	}
}
