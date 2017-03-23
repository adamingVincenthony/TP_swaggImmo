package fr.adaming.dao;

import java.util.List;

import fr.adaming.entity.Bien;
import fr.adaming.entity.Client;
import fr.adaming.entity.Utilisateur;


public interface IUtilisateurDao {

	/**
	 * m�thodes abstraites de l'interface Utilisateur de la Dao pour la gestion des utilisateurs
	 * @param u
	 * @return
	 */
	public Utilisateur addUtilisateur(Utilisateur u);
	public List<Utilisateur> findAllUtilisateurs();
	public Utilisateur getByIdUtilisateur(int id_u);
	public Utilisateur updateUtilisateur(Utilisateur u);
	public void deleteUtilisateur(Utilisateur u);
	public void attribuer(Client client, Bien bien);
}
