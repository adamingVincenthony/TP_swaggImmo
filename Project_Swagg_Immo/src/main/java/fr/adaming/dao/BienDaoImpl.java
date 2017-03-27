package fr.adaming.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
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
public class BienDaoImpl<T extends Bien> implements IBienDao<T>{

	@Autowired
	private SessionFactory sf;

	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}
	
	@Override
	public Bien addBien(T b) {
		Date date = new Date();
		b.setDateSoumission(date);
		b.setStatut("Disponible");
		sf.getCurrentSession().save(b);
		return b ;
	}

	@Override
	public List<Bien> findAllBiens() {
		String req="SELECT b from Bien b";
		Session s = sf.getCurrentSession();
		Query query = s.createQuery(req);
		return query.list();
	}

	@Override
	public Bien getByIdBien(int id_b) {
		Session s = sf.getCurrentSession();
		return (Bien) s.get(Bien.class, id_b);
	}

	@Override
	public Bien updateBien(Bien b) {
		Session s = sf.getCurrentSession();
		s.merge(b);
		return b;
	}

	@Override
	public void deleteBien(T b) {
		Session s = sf.getCurrentSession();
		s.delete(b);
	}

}
