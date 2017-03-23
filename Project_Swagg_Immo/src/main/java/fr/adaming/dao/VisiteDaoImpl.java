package fr.adaming.dao;

import java.util.List;

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
		
		return (Visite) sf.getCurrentSession().save(v);
	}

	@Override
	public List<Visite> findAllVisites() {
		String req="SELECT v from Visite v";
		return sf.getCurrentSession().createQuery(req).list();
	}

	@Override
	public Visite getByIdVisite(int id_v) {
		return (Visite) sf.getCurrentSession().get(Visite.class, id_v);
	}

	@Override
	public Visite updateVisite(Visite v) {
		return (Visite) sf.getCurrentSession().merge(v);
	}

	@Override
	public void deleteVisite(Visite v) {
		sf.getCurrentSession().delete(v);
	}
}
