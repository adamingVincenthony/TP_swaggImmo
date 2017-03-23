package fr.adaming.service;

import java.util.List;

import fr.adaming.entity.Bien;
import fr.adaming.entity.Client;
import fr.adaming.entity.Utilisateur;

public interface IUtilisateurService {
	
	/**
	 * méthodes abstraites de l'interface Utilisateur de Service pour la gestion des utilisateurs
	 * @param u
	 */
	public void addUtilisateur(Utilisateur u);
	public List<Utilisateur> findAllUtilisateur();
	public void deleteUtilisateur(int id);
	public void updateUtilisateur(Utilisateur u);
	public Utilisateur getByIdUtilisateur(int id);

	/**
	 * attribution d'un client à un bien
	 * @param idClient
	 * @param idBien
	 */
	public void attribuer(int idClient, int idBien);
}