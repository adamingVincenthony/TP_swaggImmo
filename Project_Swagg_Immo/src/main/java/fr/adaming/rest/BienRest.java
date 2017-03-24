package fr.adaming.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fr.adaming.entity.Bien;
import fr.adaming.entity.BienALouer;
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
public class BienRest {
	
	/**
	 * injection automatique du bien service
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
	 * m�thode d'affichage de la liste des bien
	 * @return
	 */
	@GET
	@Path("/findAll")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Bien> findAllBienRest(){
		return bienService.findAllBien();
	}
	
	/**
	 * m�thode de recherche par id d'un bien
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
	 * m�thode d'ajout d'un bien � louer
	 * @param bien
	 */
	@POST
	@Path("/bal")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public void addBienRest(BienALouer bien){
		System.out.println("je rentre dans la m�thode bien � louer cr�ation");
		bienService.addBienBAL(bien);
	}
	
	/**
	 * m�thode de mise � jour des donn�es d'un bien
	 * @param bien
	 */
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public void updateBienRest(Bien bien){
		bienService.updateBien(bien);
	}
	
	/**
	 * suppression d'un propri�taire
	 * @param id
	 */
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	public void deleteUser(@PathParam("id_param") int id){
		bienService.deleteBien(id);
	}
	
}
