package fr.adaming.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.BienDaoImpl;
import fr.adaming.dao.ClientDaoImpl;
import fr.adaming.dao.IBienDao;
import fr.adaming.dao.IClientDao;
import fr.adaming.dao.IProprietaireDao;
import fr.adaming.dao.IUtilisateurDao;
import fr.adaming.dao.ProprietaireDaoImpl;
import fr.adaming.dao.UtilisateurDaoImpl;
import fr.adaming.entity.Bien;
import fr.adaming.entity.Client;
import fr.adaming.entity.Contrat;
import fr.adaming.entity.Proprietaire;
import fr.adaming.entity.Utilisateur;
import fr.adaming.entity.Visite;

@Service
@Transactional
public class UtilisateurServiceImpl implements IUtilisateurService{

	@Autowired
	private IUtilisateurDao utilisateurDao = new UtilisateurDaoImpl();
	
	@Autowired
	private IClientDao clientDao = new ClientDaoImpl();
	
	@Autowired
	private IBienDao bienDao = new BienDaoImpl();
	
	@Autowired
	private IProprietaireDao proprietaireDao = new ProprietaireDaoImpl();
	
	/**
	 * setter
	 * @param utilisateurDao
	 */
	
	public void setUtilisateurDao(IUtilisateurDao utilisateurDao) {
		this.utilisateurDao = utilisateurDao;
	}
	
	public void setClientDao(IClientDao clientDao) {
		this.clientDao = clientDao;
	}

	public void setBienDao(IBienDao bienDao) {
		this.bienDao = bienDao;
	}

	public void setProprietaireDao(IProprietaireDao proprietaireDao) {
		this.proprietaireDao = proprietaireDao;
	}


	/**
	 * m�thodes CRUD de la couche service de la classe Utilisateur pour la gestion des utilisateurs
	 */


	/**
	 * Ajoute un utilisateur en appelant la methode associ�e de la dao
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
	 * m�thode d'attribution d'un bien � un client
	 */
	@Override
	public void attribuer(int idClient, int idBien) {
		/**
		 * r�cup�ration d'un client par son id
		 * r�cup�ration d'un bien par son id
		 */
		Client client = clientDao.getByIdClient(idClient);
		Bien bien = bienDao.getByIdBien(idBien);
		
		/**
		 * r�cup�ration des listes de biens du client et de client pour un bien
		 */
		List<Bien> listeBien = client.getListeInteret();
		if(listeBien == null){
			listeBien = new ArrayList<>();
		}
		
		
		List<Client> listeClient = bien.getClientInteret(); 
		if(listeClient == null){
			listeClient = new ArrayList<>();
		}
		
		/**
		 * mise � jour des donn�es des listes � partir des objets r�cup�r�s
		 */
		listeBien.add(bien);
		listeClient.add(client);
		
		/**
		 * attribution des listes mises � jour aux objets clients et biens
		 */
		client.setListeInteret(listeBien);
		bien.setClientInteret(listeClient);
		
		/**
		 * appel de la m�thode de la dao
		 */
		utilisateurDao.attribuer(client, bien);
		
	}

	/**
		 * m�thode d'attribution d'un bien � un responsable
		 */
		@Override
		public void attribuerBienResponsable(int idResponsable, int idBien) {
			/**
			 * r�cup�ration des objets par leur id
			 */
			Utilisateur responsable = utilisateurDao.getByIdUtilisateur(idResponsable);
			Bien bien = bienDao.getByIdBien(idBien);
			
			/**
			 * r�cup�ration de la liste de biens d'un responsable
			 */
			List<Bien> listeBien = responsable.getListeBien(); 

			/**
			 * ajout du bien � la liste r�cup�r�e
			 */
			listeBien.add(bien);
			
			/**
			 * affectation de la liste � un responsable
			 */
			responsable.setListeBien(listeBien);
		
			/**
			 * appel de la m�thode de la dao
			 */
			utilisateurDao.attribuerBienResponsable(responsable, bien);
			
		}
	
	/**
	 * m�thode d'affichage de la liste des biens d'un propri�taire dans la liste des int�r�ts
	 */
	@Override
	public List<Bien> getListeBienProprietaire(int id_p) {
		return utilisateurDao.getListeBienProprietaire(id_p);
	}
	
	/**
	 * m�thode d'affichage de la liste des visites d'un utilisateur responsable
	 */
	@Override
	public List<Visite> getListeVisite(int id_u) {
		return utilisateurDao.getListeVisite(id_u);
	}

	/**
	 * m�thode d'affichage de la liste des contrats d'un client
	 */
	public List<Contrat> getListeContratClient(int id_c) {
		return utilisateurDao.getListeContratClient(id_c);
	}

}
