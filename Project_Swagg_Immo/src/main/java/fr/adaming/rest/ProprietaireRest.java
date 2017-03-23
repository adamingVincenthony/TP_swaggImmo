package fr.adaming.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fr.adaming.entity.Proprietaire;
import fr.adaming.service.IProprietaireService;

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
 * annotations path et component du proprietaireRest
 * @author inti0277
 *
 */
@Component
@Path("/proprietaire")
public class ProprietaireRest {
	
	/**
	 * injection automatique du propriétaire service
	 */
	@Autowired
	private IProprietaireService proprietaireService;

	/**
	 * set du proprietaireService
	 * @param proprietaireService
	 */
	public void setProprietaireService(IProprietaireService proprietaireService) {
		this.proprietaireService = proprietaireService;
	}
	
	
	/**
	 * méthode d'affichage de la liste des propriétaires
	 * @return
	 */
	@GET
	@Path("/findAll")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Proprietaire> findAllProprietaireRest(){
		return proprietaireService.findAllProprietaire();
	}
	
	/**
	 * méthode de recherche par id d'un propriétaire 
	 * @param id
	 * @return
	 */
	@GET
	@Path("/getById/{id_param}")
	@Produces(MediaType.APPLICATION_JSON)
	public Proprietaire getByIdProprietaireRest(@PathParam("id_param") int id) {
		return proprietaireService.getByIdProprietaire(id);
	}
	
	/**
	 * méthode d'ajout d'un propriétaire 
	 * @param proprietaire
	 */
	@POST
	@Path("/add")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public void addProprietaireRest(Proprietaire proprietaire){
		proprietaireService.addProprietaire(proprietaire);
	}
	
	/**
	 * méthode de mise à jour des données d'un propriétaire
	 * @param proprietaire
	 */
	@PUT
	@Path("/update")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public void updateProprietaireRest(Proprietaire proprietaire){
		proprietaireService.updateProprietaire(proprietaire);
	}
	
	/**
	 * suppression d'un propriétaire
	 * @param id
	 */
	@DELETE
	@Path("/delete/{id_param}")
	@Produces(MediaType.APPLICATION_JSON)
	public void deleteUser(@PathParam("id_param") int id){
		proprietaireService.deleteProprietaire(id);
	}
	
}
