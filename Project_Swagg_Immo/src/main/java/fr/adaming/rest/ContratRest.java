package fr.adaming.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fr.adaming.entity.Contrat;
import fr.adaming.service.IContratService;

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
 * annotations path et component du contratRest
 * @author inti0277
 *
 */
@Component
@Path("/contrat")
public class ContratRest {
	
	/**
	 * injection automatique du propriétaire service
	 */
	@Autowired
	private IContratService contratService;

	/**
	 * set du contratService
	 * @param contratService
	 */
	public void setContratService(IContratService contratService) {
		this.contratService = contratService;
	}
	
	
	/**
	 * méthode d'affichage de la liste des propriétaires
	 * @return
	 */
	@GET
	@Path("/findAll")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Contrat> findAllContratRest(){
		return contratService.findAllContrat();
	}
	
	/**
	 * méthode de recherche par id d'un propriétaire 
	 * @param id
	 * @return
	 */
	@GET
	@Path("/getById/{id_param}")
	@Produces(MediaType.APPLICATION_JSON)
	public Contrat getByIdContratRest(@PathParam("id_param") int id) {
		return contratService.getByIdContrat(id);
	}
	
	/**
	 * méthode d'ajout d'un propriétaire 
	 * @param contrat
	 */
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public void addContratRest(Contrat contrat){
		contratService.addContrat(contrat);
	}
	
	/**
	 * méthode de mise à jour des données d'un propriétaire
	 * @param contrat
	 */
	@PUT
	@Path("/update")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public void updateContratRest(Contrat contrat){
		contratService.updateContrat(contrat);
	}
	
	/**
	 * suppression d'un propriétaire
	 * @param id
	 */
	@DELETE
	@Path("/delete/{id_param}")
	@Produces(MediaType.APPLICATION_JSON)
	public void deleteUser(@PathParam("id_param") int id){
		contratService.deleteContrat(id);
	}
	
	/**
	 * attribution d'un contrat à un utilisateur, bien et client
	 * @param id
	 */
	@PUT
	@Path("/attribuer/{id_param_contrat}/{id_param_utilisateur}/{id_param_bien}/{id_param_client}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public void attribuer(@PathParam("id_param_contrat") int idContrat, @PathParam("id_param_utilisateur") int idUtilisateur, @PathParam("id_param_bien") int idBien, @PathParam("id_param_client") int idClient){
		contratService.attribuer(idContrat, idUtilisateur, idBien, idClient);
	}
	
}
