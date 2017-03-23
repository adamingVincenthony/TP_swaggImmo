package fr.adaming.dao;

import java.util.List;

import fr.adaming.entity.Utilisateur;

public interface IUtilisateurDao {

	public Utilisateur addUtilisateur(Utilisateur u);
	public List<Utilisateur> findAllUtilisateurs();
	public Utilisateur getByIdUtilisateur(int id_u);
	public Utilisateur updateUtilisateur(Utilisateur u);
	public void deleteUtilisateur(Utilisateur u);
}
