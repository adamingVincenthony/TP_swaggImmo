package fr.adaming.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.adaming.entity.Bien;
import fr.adaming.entity.Client;
import fr.adaming.entity.Proprietaire;
import fr.adaming.entity.Utilisateur;

/**
 * methodes permettant de gérer les utilisateurs(conseillers immobilier) dans la bdd
 * @author inti0210
 *
 */
@Repository
public class UtilisateurDaoImpl implements IUtilisateurDao {

	@Autowired
	private SessionFactory sf;

	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}
	
	@Autowired 
	private IProprietaireDao proprietaireDao;
	
	/**
	 * méthodes de gestion des utilisateurs
	 */
	@Override
	public Utilisateur addUtilisateur(Utilisateur u) {
		
		Session s = sf.getCurrentSession();
		return (Utilisateur) s.save(u);
	}

	@Override
	public List<Utilisateur> findAllUtilisateurs() {
		String req="SELECT u from Utilisateur u";
		Session s = sf.getCurrentSession();
		Query query = s.createQuery(req);
		return query.list();
	}

	@Override
	public Utilisateur getByIdUtilisateur(int id_u) {
	Session s = sf.getCurrentSession();
	return (Utilisateur) s.get(Utilisateur.class, id_u);
	}

	@Override
	public Utilisateur updateUtilisateur(Utilisateur u) { 
		Session s = sf.getCurrentSession();
		return (Utilisateur) s.merge(u);
	}

	@Override
	public void deleteUtilisateur(Utilisateur u) {
		Session s = sf.getCurrentSession();
		s .delete(u);
	}

	/**
	 * méthode d'attribution d'un bien à un client dans la liste des intérêts
	 */
	@Override
	public void attribuer(Client client, Bien bien) {
		Session s = sf.getCurrentSession();
		s.merge(client);
		s.merge(bien);
	}

	/**
	 * méthode pour afficher la liste des biens d'un proprietaire
	 */
	@Override
	public List<Bien> getListeBienProprietaire(int id_p) {
		Proprietaire proprietaire = proprietaireDao.getByIdProprietaire(id_p);
		List<Bien> listeBien = proprietaire.getListeBien();
		return listeBien;
	}
	
}
