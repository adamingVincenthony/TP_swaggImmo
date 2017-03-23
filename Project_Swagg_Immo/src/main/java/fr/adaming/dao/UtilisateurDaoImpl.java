package fr.adaming.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.adaming.entity.Utilisateur;
/**
 * methodes permettant de gérer les utilisateurs(conseillers immobilier) dans la bdd
 * @author inti0210
 *
 */
@Repository
public class UtilisateurDaoImpl implements IUtilisateurDao{

	@Autowired
	private SessionFactory sf;

	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}
	
	@Override
	public Utilisateur addUtilisateur(Utilisateur u) {
		
		return (Utilisateur) sf.getCurrentSession().save(u);
	}

	@Override
	public List<Utilisateur> findAllUtilisateurs() {
		String req="SELECT u from Utilisateur u";
		return sf.getCurrentSession().createQuery(req).list();
	}

	@Override
	public Utilisateur getByIdUtilisateur(int id_u) {
		return (Utilisateur) sf.getCurrentSession().get(Utilisateur.class, id_u);
	}

	@Override
	public Utilisateur updateUtilisateur(Utilisateur u) {
		return (Utilisateur) sf.getCurrentSession().merge(u);
	}

	@Override
	public void deleteUtilisateur(Utilisateur u) {
		sf.getCurrentSession().delete(u);
	}
	
}
