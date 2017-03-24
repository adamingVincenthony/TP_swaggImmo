package fr.adaming.dao.test;

import static org.junit.Assert.assertEquals;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IContratDao;
import fr.adaming.entity.Client;
import fr.adaming.entity.Contrat;

@RunWith(SpringJUnit4ClassRunner.class) // le runner de spring
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/application-context.xml"})
public class ContratDaoTest {
	
	@Autowired
	IContratDao contratDao;
	
	Client client = new Client(1000, "toto");
	
	
	public void setContratDao(IContratDao contratDao) {
		this.contratDao = contratDao;
	}

	/**
	 * Test : addContrat & findAllContrat
	 */
	@Test
	@Transactional
	public void testaddContrat(){
		List<Contrat> listeContrat = contratDao.findAllContrats();
		int tailleInitiale = listeContrat.size();
		Date date = new Date();
		Contrat Contrat = new Contrat(1000, date, 1000);
		contratDao.addContrat(Contrat);
		
		int resultatAttendu = tailleInitiale+1;
		
		List<Contrat> listeContrat1 = contratDao.findAllContrats();
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
		contratDao.addContrat(Contrat);
		
		List<Contrat> listeContrat = contratDao.findAllContrats();
		int tailleInitiale = listeContrat.size();
		contratDao.deleteContrat(Contrat);
		
		if(tailleInitiale!=0){
			int resultatAttendu = tailleInitiale-1;
			List<Contrat> listeContrat1 = contratDao.findAllContrats();
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
		contratDao.addContrat(Contrat);
		
		Contrat ContratTrouve = contratDao.getByIdContrat(Contrat.getId());
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
		contratDao.addContrat(Contrat);
		
		Contrat ContratTrouve = contratDao.getByIdContrat(Contrat.getId());

		ContratTrouve.setClient(client);	
		contratDao.addContrat(ContratTrouve);
		contratDao.updateContrat(ContratTrouve);
		
		
		Contrat ContratTrouve2 = contratDao.getByIdContrat(Contrat.getId());
		
		Date resultatAttendu = ContratTrouve2.getDate();
		assertEquals(resultatAttendu,ContratTrouve.getDate());
	}
}
