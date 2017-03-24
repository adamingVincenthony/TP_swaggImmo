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
import fr.adaming.entity.Contrat;
import fr.adaming.service.IContratService;

@RunWith(SpringJUnit4ClassRunner.class) // le runner de spring
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/application-context.xml"})
public class ContratServiceTest {
	
	
	@Autowired
	IContratService contratService;
	
	Client client = new Client(1000, "toto");
	
	
	public void setContratService(IContratService contratService) {
		this.contratService = contratService;
	}

	/**
	 * Test : addContrat & findAllContrat
	 */
	@Test
	@Transactional
	public void testaddContrat(){
		List<Contrat> listeContrat = contratService.findAllContrat();
		int tailleInitiale = listeContrat.size();
		Date date = new Date();
		Contrat Contrat = new Contrat(1000, date, 1000);
		contratService.addContrat(Contrat);
		
		int resultatAttendu = tailleInitiale+1;
		
		List<Contrat> listeContrat1 = contratService.findAllContrat();
		assertEquals(resultatAttendu,listeContrat1.size());
	}
	
	/**
	 * Test : deleteContrat
	 */
	@Test
	@Transactional
	public void testDeleteContrat(){
		Date date = new Date();
		Contrat Contrat = new Contrat(1000, date, 1000);
		contratService.addContrat(Contrat);
		
		List<Contrat> listeContrat = contratService.findAllContrat();
		int tailleInitiale = listeContrat.size();
		contratService.deleteContrat(Contrat.getId());
		
		if(tailleInitiale!=0){
			int resultatAttendu = tailleInitiale-1;
			List<Contrat> listeContrat1 = contratService.findAllContrat();
			assertEquals(resultatAttendu,listeContrat1.size());
		}
	}
	
	/**
	 * Test : getByIdContrat
	 */
	@Test
	@Transactional
	public void testGetByIdContrat(){
		Date date = new Date();
		Contrat Contrat = new Contrat(1000,1000, date, 1000);
		contratService.addContrat(Contrat);
		
		Contrat ContratTrouve = contratService.getByIdContrat(Contrat.getId());
		Date resultatAttendu = ContratTrouve.getDate();
		assertEquals(resultatAttendu,Contrat.getDate());
	}
	
	/**
	 * Test : updateContrat
	 */
	@Test
	@Transactional
	public void testUpdateContrat(){
		Date date = new Date();
		Contrat Contrat = new Contrat(1000,1000, date, 1000);
		contratService.addContrat(Contrat);
		
		Contrat ContratTrouve = contratService.getByIdContrat(Contrat.getId());

		ContratTrouve.setClient(client);	
		contratService.addContrat(ContratTrouve);
		contratService.updateContrat(ContratTrouve);
		
		
		Contrat ContratTrouve2 = contratService.getByIdContrat(Contrat.getId());
		
		Date resultatAttendu = ContratTrouve2.getDate();
		assertEquals(resultatAttendu,ContratTrouve.getDate());
	}
}
