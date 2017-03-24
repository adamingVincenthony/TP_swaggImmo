package fr.adaming.service.test;

import static org.junit.Assert.assertEquals;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;


import fr.adaming.entity.Client;
import fr.adaming.entity.Visite;
import fr.adaming.service.IVisiteService;


@RunWith(SpringJUnit4ClassRunner.class) // le runner de spring
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/application-context.xml"})
public class VisiteServiceTest {

	@Autowired
	IVisiteService visiteService;
	
	Client client = new Client(1000, "toto");
	
	/**
	 * setter
	 * @param visiteService
	 */
	public void setVisiteService(IVisiteService visiteService) {
		this.visiteService = visiteService;
	}

	/**
	 * Test : addVisite & findAllVisite
	 */
	@Test
	@Transactional
	public void testaddVisite(){
		List<Visite> listeVisite = visiteService.findAllVisite();
		int tailleInitiale = listeVisite.size();
		Date date = new Date();
		Visite visite = new Visite(date);
		visiteService.addVisite(visite);
		
		int resultatAttendu = tailleInitiale+1;
		
		List<Visite> listeVisite1 = visiteService.findAllVisite();
		assertEquals(resultatAttendu,listeVisite1.size());
	}
	
	/**
	 * Test : deleteVisite
	 */
	@Test
	@Transactional
	public void testDeleteVisite(){
		Date date = new Date();
		Visite visite = new Visite(date);
		visiteService.addVisite(visite);
		List<Visite> listeVisite = visiteService.findAllVisite();
		int tailleInitiale = listeVisite.size();
		visiteService.deleteVisite(visite.getId());
		
		if(tailleInitiale!=0){
			int resultatAttendu = tailleInitiale-1;
			List<Visite> listeVisite1 = visiteService.findAllVisite();
			assertEquals(resultatAttendu,listeVisite1.size());
		}
	}
	
	/**
	 * Test : getByIdVisite
	 */
	@Test
	@Transactional
	public void testGetByIdVisite(){
		Date date = new Date();
		Visite visite = new Visite(1000,date);
		visiteService.addVisite(visite);
		
		Visite VisiteTrouve = visiteService.getByIdVisite(visite.getId());
		Date resultatAttendu = VisiteTrouve.getDate();
		assertEquals(resultatAttendu,visite.getDate());
	}
	
	/**
	 * Test : updateVisite
	 */
	@Test
	@Transactional
	public void testUpdateVisite(){
		Date date = new Date();
		Visite visite =  new Visite(1000,date);
		visiteService.addVisite(visite);
		
		Visite VisiteTrouve = visiteService.getByIdVisite(visite.getId());

		VisiteTrouve.setClient(client);	
		visiteService.addVisite(VisiteTrouve);
		visiteService.updateVisite(VisiteTrouve);
		
		
		Visite VisiteTrouve2 = visiteService.getByIdVisite(visite.getId());
		
		Date resultatAttendu = VisiteTrouve2.getDate();
		assertEquals(resultatAttendu,VisiteTrouve.getDate());
	}
}
