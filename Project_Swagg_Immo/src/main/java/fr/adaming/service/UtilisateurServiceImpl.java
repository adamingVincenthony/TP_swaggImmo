package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.BienDaoImpl;
import fr.adaming.dao.ClientDaoImpl;
import fr.adaming.dao.IBienDao;
import fr.adaming.dao.IClientDao;
import fr.adaming.dao.IUtilisateurDao;
import fr.adaming.dao.UtilisateurDaoImpl;
import fr.adaming.entity.Bien;
import fr.adaming.entity.Client;
import fr.adaming.entity.Utilisateur;

@Service
@Transactional
public class UtilisateurServiceImpl implements IUtilisateurService{

	@Autowired
	private IUtilisateurDao utilisateurDao = new UtilisateurDaoImpl();
	private IClientDao clientDao = new ClientDaoImpl();
	private IBienDao bienDao = new BienDaoImpl();
	
	/**
	 * setter
	 * @param utilisateurDao
	 */
	public void setUtilisateurDao(IUtilisateurDao utilisateurDao) {
		this.utilisateurDao = utilisateurDao;
	}

	/**
	 * méthodes de la couche service de la classe Utilisateur pour la gestion des utilisateurs
	 */
	
	/**
	 * Ajoute un utilisateur en appelant la methode associée de la dao
	 */
	@Override
	public void addUtilisateur(Utilisateur utilisateur) {
		
		utilisateurDao.addUtilisateur(utilisateur);
	}
	
	/**
	 * Recupere une liste de utilisateur
	 */
	@Override
	public List<Utilisateur> findAllUtilisateur() {
		return utilisateurDao.findAllUtilisateurs();
	}

	
	/**
	 * Supprime un utilisateur
	 */
	@Override
	public void deleteUtilisateur(int id) {
		Utilisateur utilisateur = utilisateurDao.getByIdUtilisateur(id);
		utilisateurDao.deleteUtilisateur(utilisateur);
		
	}

	/**
	 * Modifie un utilisateur
	 */
	@Override
	public void updateUtilisateur(Utilisateur utilisateur) {
		utilisateurDao.updateUtilisateur(utilisateur);
		
	}

	/**
	 * Recupere un utilisateur par son Id
	 */
	@Override
	public Utilisateur getByIdUtilisateur(int id) {
		return utilisateurDao.getByIdUtilisateur(id);
	}

	/**
	 * méthode d'attribution d'un client un bien
	 */
	@Override
	public void attribuer(int idClient, int idBien) {
		Client client = clientDao.getByIdClient(idClient);
		Bien bien = bienDao.getByIdBien(idBien);
		
		List<Bien> listeBien = client.getListeInteret();
		List<Client> listeClient= bien.getClientInteret();

		listeBien.add(bien);
		listeClient.add(client);
		
		client.setListeInteret(listeBien);
		bien.setClientInteret(listeClient);
		
		utilisateurDao.attribuer(client, bien);
		
	}

}
