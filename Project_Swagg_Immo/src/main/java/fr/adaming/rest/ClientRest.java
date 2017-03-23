package fr.adaming.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fr.adaming.entity.Client;
import fr.adaming.service.IClientService;

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
 * annotations path et component du clientRest
 * @author inti0277
 *
 */
@Component
@Path("/client")
public class ClientRest {
	
	/**
	 * injection automatique du propri�taire service
	 */
	@Autowired
	private IClientService clientService;

	/**
	 * set du clientService
	 * @param clientService
	 */
	public void setClientService(IClientService clientService) {
		this.clientService = clientService;
	}
	
	
	/**
	 * m�thode d'affichage de la liste des propri�taires
	 * @return
	 */
	@GET
	@Path("/findAll")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Client> findAllClientRest(){
		return clientService.findAllClient();
	}
	
	/**
	 * m�thode de recherche par id d'un propri�taire 
	 * @param id
	 * @return
	 */
	@GET
	@Path("/getById/{id_param}")
	@Produces(MediaType.APPLICATION_JSON)
	public Client getByIdClientRest(@PathParam("id_param") int id) {
		return clientService.getByIdClient(id);
	}
	
	/**
	 * m�thode d'ajout d'un propri�taire 
	 * @param client
	 */
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public void addClientRest(Client client){
		clientService.addClient(client);
	}
	
	/**
	 * m�thode de mise � jour des donn�es d'un propri�taire
	 * @param client
	 */
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public void updateClientRest(Client client){
		clientService.updateClient(client);
	}
	
	/**
	 * suppression d'un propri�taire
	 * @param id
	 */
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	public void deleteUser(@PathParam("id_param") int id){
		clientService.deleteClient(id);
	}
	
}
