package fr.adaming.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fr.adaming.entity.Bien;
import fr.adaming.service.IBienService;

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
 * annotations path et component du bienRest
 * @author inti0277
 *
 */
@Component
@Path("/bien")
public class BienRest<T extends Bien> {
	
	/**
	 * injection automatique du propriétaire service
	 */
	@Autowired
	private IBienService bienService;

	/**
	 * set du bienService
	 * @param bienService
	 */
	public void setBienService(IBienService bienService) {
		this.bienService = bienService;
	}
	
	
	/**
	 * méthode d'affichage de la liste des propriétaires
	 * @return
	 */
	@GET
	@Path("/findAll")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Bien> findAllBienRest(){
		return bienService.findAllBien();
	}
	
	/**
	 * méthode de recherche par id d'un propriétaire 
	 * @param id
	 * @return
	 */
	@GET
	@Path("/getById/{id_param}")
	@Produces(MediaType.APPLICATION_JSON)
	public Bien getByIdBienRest(@PathParam("id_param") int id) {
		return bienService.getByIdBien(id);
	}
	
	/**
	 * méthode d'ajout d'un propriétaire 
	 * @param bien
	 */
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public void addBienRest(T bien){
		bienService.addBien(bien);
	}
	
	/**
	 * méthode de mise à jour des données d'un propriétaire
	 * @param bien
	 */
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public void updateBienRest(T bien){
		bienService.updateBien(bien);
	}
	
	/**
	 * suppression d'un propriétaire
	 * @param id
	 */
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	public void deleteUser(@PathParam("id_param") int id){
		bienService.deleteBien(id);
	}
	
}
