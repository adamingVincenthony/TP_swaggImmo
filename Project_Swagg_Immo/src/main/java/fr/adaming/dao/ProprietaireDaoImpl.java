package fr.adaming.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.adaming.entity.Proprietaire;
/**
 * methodes permettant de gérer les proprietaires dans la bdd
 * @author inti0210
 *
 */
@Repository
public class ProprietaireDaoImpl implements IProprietaireDao{

	@Autowired
	private SessionFactory sf;

	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}
	
	@Override
	public Proprietaire addProprietaire(Proprietaire p) {
		
		return (Proprietaire) sf.getCurrentSession().save(p);
	}

	@Override
	public List<Proprietaire> findAllProprietaires() {
		String req="SELECT p from Proprietaire p";
		return sf.getCurrentSession().createQuery(req).list();
	}

	@Override
	public Proprietaire getByIdProprietaire(int id_p) {
		return (Proprietaire) sf.getCurrentSession().get(Proprietaire.class, id_p);
	}

	@Override
	public Proprietaire updateProprietaire(Proprietaire p) {
		return (Proprietaire) sf.getCurrentSession().merge(p);
	}

	@Override
	public void deleteProprietaire(Proprietaire p) {
		sf.getCurrentSession().delete(p);
	}

}
