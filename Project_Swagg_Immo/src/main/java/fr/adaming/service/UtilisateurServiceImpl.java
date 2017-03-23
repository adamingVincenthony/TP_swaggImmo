package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IUtilisateurDao;
import fr.adaming.entity.Utilisateur;

@Service
@Transactional
public class UtilisateurServiceImpl implements IUtilisateurService{

	@Autowired
	public IUtilisateurDao utilisateurDao;
	
	
	/**
	 * setter
	 * @param utilisateurDao
	 */
	public void setUtilisateurDao(IUtilisateurDao utilisateurDao) {
		this.utilisateurDao = utilisateurDao;
	}

	/**
	 * Ajoute un Utilisateur en appelant la methode associée de la dao
	 */
	@Override
	public Utilisateur addUtilisateur(Utilisateur u) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Recupere une liste d'utilisateurs
	 */
	@Override
	public List<Utilisateur> findAllUtilisateurs() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Recupere un utilisateur par son Id
	 */
	@Override
	public Utilisateur getByIdUtilisateur(int id_u) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Modifie un utilisateur
	 */
	@Override
	public Utilisateur updateUtilisateur(Utilisateur u) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Supprime un utilisaeur
	 */
	@Override
	public void deleteUtilisateur(Utilisateur u) {
		// TODO Auto-generated method stub
		
	}

}
