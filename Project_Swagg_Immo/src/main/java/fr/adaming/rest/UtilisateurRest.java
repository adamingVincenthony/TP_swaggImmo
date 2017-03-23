package fr.adaming.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fr.adaming.entity.Utilisateur;
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
	 * injection automatique du propriétaire service
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
	 * méthode d'affichage de la liste des propriétaires
	 * @return
	 */
	@GET
	@Path("/findAll")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Utilisateur> findAllUtilisateurRest(){
		return utilisateurService.findAllUtilisateurs();
	}
	
	/**
	 * méthode de recherche par id d'un propriétaire 
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
	 * méthode d'ajout d'un propriétaire 
	 * @param utilisateur
	 */
	@POST
	@Path("/add")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public void addUtilisateurRest(Utilisateur utilisateur){
		utilisateurService.addUtilisateur(utilisateur);
	}
	
	/**
	 * méthode de mise à jour des données d'un propriétaire
	 * @param utilisateur
	 */
	@PUT
	@Path("/update")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public void updateUtilisateurRest(Utilisateur utilisateur){
		utilisateurService.updateUtilisateur(utilisateur);
	}
	
	/**
	 * suppression d'un propriétaire
	 * @param id
	 */
	@DELETE
	@Path("/delete/{id_param}")
	@Produces(MediaType.APPLICATION_JSON)
	public void deleteUser(@PathParam("id_param") int id){
		utilisateurService.deleteUtilisateur(id);
	}
	
}
