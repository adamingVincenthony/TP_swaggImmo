package fr.adaming.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fr.adaming.entity.Proprietaire;
import fr.adaming.service.IProprietaireService;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;


@Component
@Path("proprietaire")
public class ProprietaireRest {
	
	@Autowired
	IProprietaireService proprietaireService;

	public void setProprietaireService(IProprietaireService proprietaireService) {
		this.proprietaireService = proprietaireService;
	}
	
	@GET
	@Path("/add")
	@Produces(MediaType.APPLICATION_JSON)
	public void addProprietaireRest(Proprietaire proprietaire){
		
		proprietaireService.addProprietaire(proprietaire);;
	}
	
}
