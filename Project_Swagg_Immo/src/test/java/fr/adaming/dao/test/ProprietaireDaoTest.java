package fr.adaming.dao.test;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IProprietaireDao;
import fr.adaming.entity.Proprietaire;

@RunWith(SpringJUnit4ClassRunner.class) // le runner de spring
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/application-context.xml"})
public class ProprietaireDaoTest {

	@Autowired
	IProprietaireDao proprietaireDao;
	
	
	/**
	 * Test : addProprietaire & findAllPropietaire
	 */
	@Test
	@Transactional
	public void testaddProprietaire(){
		List<Proprietaire> listeProprio = proprietaireDao.findAllProprietaires();
		int tailleInitiale = listeProprio.size();
		Proprietaire propio = new Proprietaire("toto", "titi","1000","1000");
		proprietaireDao.addProprietaire(propio);
		
		int resultatAttendu = tailleInitiale+1;
		
		List<Proprietaire> listeProprio1 = proprietaireDao.findAllProprietaires();
		assertEquals(resultatAttendu,listeProprio1.size());
	}
	
	/**
	 * Test : deletePropietaire
	 */
	@Test
	@Transactional
	public void testDeleteProprietaire(){
		Proprietaire propio = new Proprietaire("toto", "titi","1000","1000");
		proprietaireDao.addProprietaire(propio);
		
		List<Proprietaire> listeProprio = proprietaireDao.findAllProprietaires();
		int tailleInitiale = listeProprio.size();
		proprietaireDao.deleteProprietaire(propio);
		
		if(tailleInitiale!=0){
			int resultatAttendu = tailleInitiale-1;
			List<Proprietaire> listeProprio1 = proprietaireDao.findAllProprietaires();
			assertEquals(resultatAttendu,listeProprio1.size());
		}
	}
	
	/**
	 * Test : getByIdPropietaire
	 */
	@Test
	@Transactional
	public void testGetByIdProprietaire(){
		Proprietaire propio = new Proprietaire(900,"toto", "titi","1000","1000");
		proprietaireDao.addProprietaire(propio);
		
		Proprietaire proprioTrouve = proprietaireDao.getByIdProprietaire(propio.getId());
		String resultatAttendu = proprioTrouve.getNom();
		assertEquals(resultatAttendu,propio.getNom());
	}
	
	/**
	 * Test : updatePropietaire
	 */
	@Test
	@Transactional
	public void testUpdateProprietaire(){
		Proprietaire propio = new Proprietaire(900,"toto", "titi","1000","1000");
		proprietaireDao.addProprietaire(propio);
		
		Proprietaire proprioTrouve = proprietaireDao.getByIdProprietaire(propio.getId());
		proprioTrouve.setNom("tata");	
		proprietaireDao.addProprietaire(proprioTrouve);
		proprietaireDao.updateProprietaire(proprioTrouve);
		
		
		Proprietaire proprioTrouve2 = proprietaireDao.getByIdProprietaire(propio.getId());
		
		String resultatAttendu = proprioTrouve2.getNom();
		assertEquals(resultatAttendu,proprioTrouve.getNom());
	}
	
	
	
	
	
}
