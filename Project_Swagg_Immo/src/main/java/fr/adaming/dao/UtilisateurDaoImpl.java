package fr.adaming.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.adaming.entity.Utilisateur;
@Repository
public class UtilisateurDaoImpl implements IUtilisateurDao{

	@Autowired
	private SessionFactory sf;

	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}
	
	@Override
	public Utilisateur addUtilisateur(Utilisateur p) {
		
		return (Utilisateur) sf.getCurrentSession().save(p);
	}

	@Override
	public List<Utilisateur> findAllUtilisateurs() {
		String req="SELECT p from Utilisateur p";
		return sf.getCurrentSession().createQuery(req).list();
	}

	@Override
	public Utilisateur getByIdUtilisateur(int id_p) {
		return (Utilisateur) sf.getCurrentSession().get(Utilisateur.class, id_p);
	}

	@Override
	public Utilisateur updateUtilisateur(Utilisateur p) {
		return (Utilisateur) sf.getCurrentSession().merge(p);
	}

	@Override
	public void deleteUtilisateur(Utilisateur p) {
		sf.getCurrentSession().delete(p);
	}
	
}
