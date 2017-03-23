package fr.adaming.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.adaming.entity.Bien;
/**
 * methodes permettant de gérer les biens dans la bdd
 * @author inti0210
 *
 */
@Repository
public class BienDaoImpl implements IBienDao{

	@Autowired
	private SessionFactory sf;

	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}
	
	@Override
	public Bien addBien(Bien b) {
		
		return (Bien) sf.getCurrentSession().save(b);
	}

	@Override
	public List<Bien> findAllBiens() {
		String req="SELECT b from Bien b";
		return sf.getCurrentSession().createQuery(req).list();
	}

	@Override
	public Bien getByIdBien(int id_b) {
		return (Bien) sf.getCurrentSession().get(Bien.class, id_b);
	}

	@Override
	public Bien updateBien(Bien b) {
		return (Bien) sf.getCurrentSession().merge(b);
	}

	@Override
	public void deleteBien(Bien b) {
		sf.getCurrentSession().delete(b);
	}

}
