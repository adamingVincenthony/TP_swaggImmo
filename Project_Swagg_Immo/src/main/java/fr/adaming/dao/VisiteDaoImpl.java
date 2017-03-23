package fr.adaming.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.adaming.entity.Visite;
@Repository
public class VisiteDaoImpl implements IVisiteDao{

	@Autowired
	private SessionFactory sf;

	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}
	
	@Override
	public Visite addVisite(Visite p) {
		
		return (Visite) sf.getCurrentSession().save(p);
	}

	@Override
	public List<Visite> findAllVisites() {
		String req="SELECT p from Visite p";
		return sf.getCurrentSession().createQuery(req).list();
	}

	@Override
	public Visite getByIdVisite(int id_p) {
		return (Visite) sf.getCurrentSession().get(Visite.class, id_p);
	}

	@Override
	public Visite updateVisite(Visite p) {
		return (Visite) sf.getCurrentSession().merge(p);
	}

	@Override
	public void deleteVisite(Visite p) {
		sf.getCurrentSession().delete(p);
	}
}
