package fr.adaming.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.adaming.entity.Client;
/**
 * methodes permettant de gérer les clients dans la bdd
 * @author inti0210
 *
 */
@Repository
public class ClientDaoImpl implements IClientDao{

	@Autowired
	private SessionFactory sf;

	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}
	
	@Override
	public Client addClient(Client cl) {
		Session s = sf.getCurrentSession();
		s.save(cl);
		return cl;
	}

	@Override
	public List<Client> findAllClients() {
		String req="SELECT cl from Client cl";
		Session s = sf.getCurrentSession();
		Query query = s.createQuery(req);
		return query.list();
	}

	@Override
	public Client getByIdClient(int id_cl) {
		Session s = sf.getCurrentSession();
		return (Client)	s.get(Client.class, id_cl);
	}

	@Override
	public Client updateClient(Client cl) {
		Session s = sf.getCurrentSession();
		s.merge(cl);
		return cl;
	}

	@Override
	public void deleteClient(Client cl) {
		Session s = sf.getCurrentSession();
		s.delete(cl);
	}
}
