package fr.adaming.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.adaming.entity.Bien;
import fr.adaming.entity.Client;
import fr.adaming.entity.Contrat;
import fr.adaming.entity.Proprietaire;
import fr.adaming.entity.Utilisateur;
import fr.adaming.entity.Visite;

/**
 * methodes permettant de g�rer les utilisateurs(conseillers immobilier) dans la bdd
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
	
	/**
	 * m�thodes de gestion CRUD des utilisateurs
	 */
	@Override
	public Utilisateur addUtilisateur(Utilisateur u) {
		
		Session s = sf.getCurrentSession();
		s.save(u);
		return u;
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
	Utilisateur responsable = (Utilisateur) s.get(Utilisateur.class, id_u);
	return responsable;
	}

	@Override
	public Utilisateur updateUtilisateur(Utilisateur u) { 
		Session s = sf.getCurrentSession();
		s.merge(u);
		return u;
	}

	@Override
	public void deleteUtilisateur(Utilisateur u) {
		Session s = sf.getCurrentSession();
		s .delete(u);
	}

	/**
	 * m�thode d'attribution d'un bien � un client dans la liste des int�r�ts
	 */
	@Override
	public void attribuer(Client client, Bien bien) {
		Session s = sf.getCurrentSession();
		s.merge(client);
		s.merge(bien);
	}
	
	/**
	 * m�thode d'attribution d'un bien � un responsable dans la liste des int�r�ts
	 */
	@Override
	public void attribuerBienResponsable(Utilisateur responsable, Bien bien) {
		Session s = sf.getCurrentSession();
		s.merge(responsable);
		s.merge(bien);
	}


	/**
	 * m�thode pour afficher la liste des biens d'un proprietaire
	 */
	@Override
	public List<Bien> getListeBienProprietaire(int id_p) {
		Session s = sf.getCurrentSession();
		Proprietaire proprietaire = (Proprietaire) s.get(Proprietaire.class, id_p);
		return proprietaire.getListeBien();
	}

	/**
	 * m�thode pour afficher la liste des visites d'un utilisateur responsable
	 */
	@Override
	public List<Visite> getListeVisite(int id_u) {
		Session s = sf.getCurrentSession();
		Utilisateur responsable = (Utilisateur) s.get(Utilisateur.class, id_u);
		return responsable.getListeVisite();
	}
	
	/**
	 * m�thode pour afficher la liste des contrats d'un client
	 */
	@Override
	public List<Contrat> getListeContratClient(int id_c) {
		Session s = sf.getCurrentSession();
		Client client = (Client) s.get(Client.class, id_c);
		return client.getListeContrat();
	}
	
}
