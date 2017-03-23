package fr.adaming.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.adaming.entity.Visite;
/**
 * methodes permettant de gérer les visite dans la bdd
 * @author inti0210
 *
 */
@Repository
public class VisiteDaoImpl implements IVisiteDao{

	@Autowired
	private SessionFactory sf;

	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}

	@Override
	public Visite addVisite(Visite v) { 
		Session s =	sf.getCurrentSession();
		s.save(v);
		return v;
	}

	@Override
	public List<Visite> findAllVisites() {
		String req="SELECT v from Visite v";
		Session s = sf.getCurrentSession();
		Query query = s.createQuery(req);
		return 	query.list();
	}

	@Override
	public Visite getByIdVisite(int id_v) {
		Session s = sf.getCurrentSession();
		return (Visite) s.get(Visite.class, id_v);
	}

	@Override
	public Visite updateVisite(Visite v) {
		Session s  = sf.getCurrentSession();
		s.merge(v);
		return v;	
	}

	@Override
	public void deleteVisite(Visite v) {
		Session s = sf.getCurrentSession();
		s.delete(v);
	}
}
