package fr.adaming.dao;

import java.util.List;

import fr.adaming.entity.Utilisateur;

public interface IUtilisateurDao {

	public Utilisateur addUtilisateur(Utilisateur p);
	public List<Utilisateur> findAllUtilisateurs();
	public Utilisateur getByIdUtilisateur(int id_p);
	public Utilisateur updateUtilisateur(Utilisateur p);
	public void deleteUtilisateur(Utilisateur p);
}
