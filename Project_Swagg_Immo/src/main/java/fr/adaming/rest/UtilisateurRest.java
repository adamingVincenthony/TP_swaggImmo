package fr.adaming.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fr.adaming.entity.Bien;
import fr.adaming.entity.Utilisateur;
import fr.adaming.entity.Visite;
import fr.adaming.service.IUtilisateurService;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 * annotations path et component du utilisateurRest
 * @author inti0277
 *
 */
@Component
@Path("/utilisateur")
public class UtilisateurRest {
	
	/**
	 * injection automatique du propri�taire service
	 */
	@Autowired
	private IUtilisateurService utilisateurService;

	/**
	 * set du utilisateurService
	 * @param utilisateurService
	 */
	public void setUtilisateurService(IUtilisateurService utilisateurService) {
		this.utilisateurService = utilisateurService;
	}
	
	
	/**
	 * m�thode d'affichage de la liste des propri�taires
	 * @return
	 */
	@GET
	@Path("/findAll")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Utilisateur> findAllUtilisateurRest(){
		return utilisateurService.findAllUtilisateur();
	}
	
	/**
	 * m�thode de recherche par id d'un propri�taire 
	 * @param id
	 * @return
	 */
	@GET
	@Path("/getById/{id_param}")
	@Produces(MediaType.APPLICATION_JSON)
	public Utilisateur getByIdUtilisateurRest(@PathParam("id_param") int id) {
		return utilisateurService.getByIdUtilisateur(id);
	}
	
	/**
	 * m�thode d'ajout d'un propri�taire 
	 * @param utilisateur
	 */
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public void addUtilisateurRest(Utilisateur utilisateur){
		utilisateurService.addUtilisateur(utilisateur);
	}
	
	/**
	 * m�thode de mise � jour des donn�es d'un propri�taire
	 * @param utilisateur
	 */
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public void updateUtilisateurRest(Utilisateur utilisateur){
		utilisateurService.updateUtilisateur(utilisateur);
	}
	
	/**
	 * suppression d'un propri�taire
	 * @param id
	 */
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	public void deleteUserRest(@PathParam("id_param") int id){
		utilisateurService.deleteUtilisateur(id);
	}
	
	/**
	 * attribution d'un bien � un client
	 * @param id
	 */
	@PUT
	@Path("/attribuer/{id_param_c}/{id_param_b}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public void attribuerRest(@PathParam("id_param_c") int idClient, @PathParam("id_param_b") int idBien){
		utilisateurService.attribuer(idClient, idBien);
	}
	
	/**
	 * m�thode d'affichage de la liste des biens d'un propri�taire
	 * @return
	 */
	@GET
	@Path("/getListeBien/{id_param_r}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Bien> getListeBienProprietaireRest(@PathParam("id_param_r") int id_r){
		return utilisateurService.getListeBienProprietaire(id_r);
	}
	
	/**
	 * m�thode d'affichage de la liste des visites d'un utilisateur
	 * @return
	 */
	@GET
	@Path("/getListeVisite/{id_param_u}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Visite> getListeVisiteRest(@PathParam("id_param_u") int id_u){
		return utilisateurService.getListeVisite(id_u);
	}
	
}
