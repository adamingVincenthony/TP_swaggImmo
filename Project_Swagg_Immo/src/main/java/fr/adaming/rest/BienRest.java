package fr.adaming.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fr.adaming.entity.Bien;
import fr.adaming.entity.BienAAcheter;
import fr.adaming.entity.BienALouer;
import fr.adaming.entity.Proprietaire;
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
	@Path("/liste")
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
	@Path("/upter")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public void updateTerRest(TerrainAAcheter bien){
		System.out.println("-----------------------L'id du bien transferée est bien :"+bien.getId());
		TerrainAAcheter oldbien = (TerrainAAcheter) bienService.getByIdBien(bien.getId());
		oldbien.setDateDispo(bien.getDateDispo());
		oldbien.setProprietaire(bien.getProprietaire());
		oldbien.setStatut(bien.getStatut());
		oldbien.setPrixAchat(bien.getPrixAchat());
		bienService.updateBienTer(oldbien);
	}
	
	/**
	 * méthode de mise à jour des données d'un bien
	 * @param bien
	 */
	@PUT
	@Path("/upbav")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public void updateBavRest(BienAAcheter bien){
		System.out.println("-----------------------L'id du bien transferée est bien :"+bien.getId());
		BienAAcheter oldbien = (BienAAcheter) bienService.getByIdBien(bien.getId());
		oldbien.setDateDispo(bien.getDateDispo());
		oldbien.setProprietaire(bien.getProprietaire());
		oldbien.setStatut(bien.getStatut());
		oldbien.setPrixAchat(bien.getPrixAchat());
		oldbien.setEtatBien(bien.getEtatBien());
		bienService.updateBienBav(oldbien);
	}
	
	@PUT
	@Path("/upbal")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public void updateBalRest(BienALouer bien){
		System.out.println("-----------------------L'id du bien transferée est bien :"+bien.getId());
		BienALouer oldbien = (BienALouer) bienService.getByIdBien(bien.getId());
		oldbien.setDateDispo(bien.getDateDispo());
		oldbien.setProprietaire(bien.getProprietaire());
		oldbien.setStatut(bien.getStatut());
		oldbien.setAmeublement(bien.getAmeublement());
		oldbien.setTypeBail(bien.getTypeBail());
		oldbien.setLoyerMensuel(bien.getLoyerMensuel());
		oldbien.setLoyerCharge(bien.getLoyerCharge());
		oldbien.setMontantCaution(bien.getMontantCaution());
		bienService.updateBienBal(oldbien);
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
