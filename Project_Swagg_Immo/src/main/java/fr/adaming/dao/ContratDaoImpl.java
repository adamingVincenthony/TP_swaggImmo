package fr.adaming.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.adaming.entity.Contrat;
/**
 * methodes permettant de gérer les contrats dans la bdd
 * @author inti0210
 *
 */
@Repository
public class ContratDaoImpl implements IContratDao{

	@Autowired
	private SessionFactory sf;

	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}
	
	@Override
	public Contrat addContrat(Contrat c) {
		
		return (Contrat) sf.getCurrentSession().save(c);
	}

	@Override
	public List<Contrat> findAllContrats() {
		String req="SELECT c from Contrat c";
		Session s = sf.getCurrentSession();
		Query query = s.createQuery(req);
		return query.list();
	}

	@Override
	public Contrat getByIdContrat(int id_c) {
		Session s = sf.getCurrentSession();
		return (Contrat) s.get(Contrat.class, id_c);
	}

	@Override
	public Contrat updateContrat(Contrat c) {
		Session s = sf.getCurrentSession();
		return (Contrat) s.merge(c);
	}

	@Override
	public void deleteContrat(Contrat c) {
		Session s = sf.getCurrentSession();
		s.delete(c);
	}
}
