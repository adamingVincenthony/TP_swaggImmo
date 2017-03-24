package fr.adaming.dao;

import java.util.List;

import fr.adaming.entity.Bien;
import fr.adaming.entity.Client;
import fr.adaming.entity.Proprietaire;
import fr.adaming.entity.Utilisateur;
import fr.adaming.entity.Visite;


public interface IUtilisateurDao {

	/**
	 * méthodes abstraites de l'interface Utilisateur de la Dao pour la gestion des utilisateurs
	 * @param u
	 * @return
	 */
	public Utilisateur addUtilisateur(Utilisateur u);
	public List<Utilisateur> findAllUtilisateurs();
	public Utilisateur getByIdUtilisateur(int id_u);
	public Utilisateur updateUtilisateur(Utilisateur u);
	public void deleteUtilisateur(Utilisateur u);
	
/**
 * méthodes d'attribution 
 * @param client
 * @param bien
 */
	public void attribuer(Client client, Bien bien);
	public void attribuerBienResponsable(Utilisateur responsable, Bien bien);
	public List<Bien> getListeBienProprietaire(int id_p);
	public List<Visite> getListeVisite(int id_u);

}
