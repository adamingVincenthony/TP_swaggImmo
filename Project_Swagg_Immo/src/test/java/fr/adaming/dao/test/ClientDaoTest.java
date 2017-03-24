package fr.adaming.dao.test;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IClientDao;
import fr.adaming.entity.Client;


@RunWith(SpringJUnit4ClassRunner.class) // le runner de spring
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/application-context.xml"})
public class ClientDaoTest {
	
	@Autowired
	IClientDao clientDao;
	
	
	/**
	 * setter
	 * @param clientDao
	 */
	public void setClientDao(IClientDao clientDao) {
		this.clientDao = clientDao;
	}

	/**
	 * Test : addclient & findAllPropietaire
	 */
	@Test
	@Transactional
	public void testaddClient(){
		List<Client> listeProprio = clientDao.findAllClients();
		int tailleInitiale = listeProprio.size();
		Client propio = new Client(10, "toto");
		clientDao.addClient(propio);
		
		int resultatAttendu = tailleInitiale+1;
		
		List<Client> listeProprio1 = clientDao.findAllClients();
		assertEquals(resultatAttendu,listeProprio1.size());
	}
	
	/**
	 * Test : deletePropietaire
	 */
	@Test
	@Transactional
	public void testDeleteClient(){
		Client propio = new Client(10, "toto");
		clientDao.addClient(propio);
		
		List<Client> listeProprio = clientDao.findAllClients();
		int tailleInitiale = listeProprio.size();
		clientDao.deleteClient(propio);
		
		if(tailleInitiale!=0){
			int resultatAttendu = tailleInitiale-1;
			List<Client> listeProprio1 = clientDao.findAllClients();
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
		clientDao.addClient(propio);
		
		Client proprioTrouve = clientDao.getByIdClient(propio.getId());
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
		clientDao.addClient(propio);
		
		Client proprioTrouve = clientDao.getByIdClient(propio.getId());
		proprioTrouve.setNom("tata");	
		clientDao.addClient(proprioTrouve);
		clientDao.updateClient(proprioTrouve);
		
		
		Client proprioTrouve2 = clientDao.getByIdClient(propio.getId());
		
		String resultatAttendu = proprioTrouve2.getNom();
		assertEquals(resultatAttendu,proprioTrouve.getNom());
	}
}
