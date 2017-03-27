package fr.adaming.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fr.adaming.entity.Visite;
import fr.adaming.service.IVisiteService;

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
 * annotations path et component du visiteRest
 * @author inti0277
 *
 */
@Component
@Path("/visite")
public class VisiteRest {
	
	/**
	 * injection automatique du propri�taire service
	 */
	@Autowired
	private IVisiteService visiteService;

	/**
	 * set du visiteService
	 * @param visiteService
	 */
	public void setVisiteService(IVisiteService visiteService) {
		this.visiteService = visiteService;
	}
	
	
	/**
	 * m�thode d'affichage de la liste des propri�taires
	 * @return
	 */
	@GET
	@Path("/findAll")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Visite> findAllVisiteRest(){
		return visiteService.findAllVisite();
	}
	
	/**
	 * m�thode de recherche par id d'un propri�taire 
	 * @param id
	 * @return
	 */
	@GET
	@Path("/get/{id_param}")
	@Produces(MediaType.APPLICATION_JSON)
	public Visite getByIdVisiteRest(@PathParam("id_param") int id) {
		return visiteService.getByIdVisite(id);
	}
	
	/**
	 * m�thode d'ajout d'un propri�taire 
	 * @param visite
	 */
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public void addVisiteRest(Visite visite){
		visiteService.addVisite(visite);
	}
	
	/**
	 * m�thode de mise � jour des donn�es d'un propri�taire
	 * @param visite
	 */
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public void updateVisiteRest(Visite visite){
		visiteService.updateVisite(visite);
	}
	
	/**
	 * suppression d'un propri�taire
	 * @param id
	 */
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	public void deleteUser(@PathParam("id_param") int id){
		visiteService.deleteVisite(id);
	}
	
}
