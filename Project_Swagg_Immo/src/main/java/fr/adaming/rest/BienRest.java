package fr.adaming.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fr.adaming.entity.Bien;
import fr.adaming.entity.BienAAcheter;
import fr.adaming.entity.BienALouer;
import fr.adaming.entity.TerrainAAcheter;
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
	 * méthode d'affichage de la liste des bien
	 * @return
	 */
	@GET
	@Path("/findAll")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Bien> findAllBienRest(){
		return bienService.findAllBien();
	}
	
	/**
	 * méthode de recherche par id d'un bien
	 * @param id
	 * @return
	 */
	@GET
	@Path("/get/{id_param}")
	@Produces(MediaType.APPLICATION_JSON)
	public Bien getByIdBienRest(@PathParam("id_param") int id) {
		return bienService.getByIdBien(id);
	}
	
	/**
	 * méthode d'ajout d'un bien à louer
	 * @param bien
	 */
	@POST
	@Path("/bal")
	@Consumes(MediaType.APPLICATION_JSON)
	public void addBienRest(BienALouer bien){
		bienService.addBienBAL(bien);
	}
	/**
	 * methode d'ajout d'un bien à vendre :
	 */
	@POST
	@Path("/bav")
	@Consumes(MediaType.APPLICATION_JSON)
	public void addBienVeRest(BienAAcheter bien){
		bienService.addBienBAV(bien);
	}
	/**
	 * methode d'ajout d'un terrain à vendre :
	 */
	@POST
	@Path("/ter")
	@Consumes(MediaType.APPLICATION_JSON)
	public void addTerrain(TerrainAAcheter bien){
		bienService.addTerrain(bien);
	}
	
	/**
	 * méthode de mise à jour des données d'un bien
	 * @param bien
	 */
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public void updateBienRest(Bien bien){
		bienService.updateBien(bien);
	}
	
	/**
	 * suppression d'un bien
	 * @param id
	 */
	@DELETE
	@Path("/{id_param}")
	@Produces(MediaType.APPLICATION_JSON)
	public void deleteUser(@PathParam("id_param") int id){
		bienService.deleteBien(id);
	}
	
}
