package fr.adaming.service.test;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;


import fr.adaming.entity.Client;
import fr.adaming.service.IClientService;


@RunWith(SpringJUnit4ClassRunner.class) // le runner de spring
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/application-context.xml"})
public class ClientServiceTest {

	@Autowired
	IClientService clientService;
	
	
	/**
	 * Test : addclient & findAllPropietaire
	 */
	@Test
	@Transactional
	public void testaddClient(){
		List<Client> listeProprio = clientService.findAllClient();
		int tailleInitiale = listeProprio.size();
		Client propio = new Client(10, "toto");
		clientService.addClient(propio);
		
		int resultatAttendu = tailleInitiale+1;
		
		List<Client> listeProprio1 = clientService.findAllClient();
		assertEquals(resultatAttendu,listeProprio1.size());
	}
	
	/**
	 * Test : deletePropietaire
	 */
	@Test
	@Transactional
	public void testDeleteClient(){
		Client propio = new Client(10, "toto");
		clientService.addClient(propio);
		
		List<Client> listeProprio = clientService.findAllClient();
		int tailleInitiale = listeProprio.size();
		clientService.deleteClient(propio.getId());
		
		if(tailleInitiale!=0){
			int resultatAttendu = tailleInitiale-1;
			List<Client> listeProprio1 = clientService.findAllClient();
			assertEquals(resultatAttendu,listeProprio1.size());
		}
	}
	
	/**
	 * Test : getByIdPropietaire
	 */
	@Test
	@Transactional
	public void testGetByIdClient(){
		Client propio = new Client(900,10, "toto");
		clientService.addClient(propio);
		
		Client proprioTrouve = clientService.getByIdClient(propio.getId());
		String resultatAttendu = proprioTrouve.getNom();
		assertEquals(resultatAttendu,propio.getNom());
	}
	
	/**
	 * Test : updatePropietaire
	 */
	@Test
	@Transactional
	public void testUpdateClient(){
		Client propio = new Client(900,10, "toto");
		clientService.addClient(propio);
		
		Client proprioTrouve = clientService.getByIdClient(propio.getId());
		proprioTrouve.setNom("tata");	
		clientService.addClient(proprioTrouve);
		clientService.updateClient(proprioTrouve);
		
		
		Client proprioTrouve2 = clientService.getByIdClient(propio.getId());
		
		String resultatAttendu = proprioTrouve2.getNom();
		assertEquals(resultatAttendu,proprioTrouve.getNom());
	}
}
