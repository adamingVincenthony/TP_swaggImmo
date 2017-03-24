package fr.adaming.service.test;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.entity.Proprietaire;
import fr.adaming.service.IProprietaireService;









@RunWith(SpringJUnit4ClassRunner.class) // le runner de spring
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/application-context.xml"})
public class ProprietaireServiceTest {

	@Autowired
	private IProprietaireService proprietaireService;
	
	
	/**
	 * Setter
	 * @param proprietaireService
	 */
	public void setProprietaireService(IProprietaireService proprietaireService) {
		this.proprietaireService = proprietaireService;
	}

	/**
	 * Test : addProprietaire & findAllPropietaire
	 */
	@Test
	@Transactional
	public void testaddProprietaire(){
		List<Proprietaire> listeProprio = proprietaireService.findAllProprietaire();
		int tailleInitiale = listeProprio.size();
		Proprietaire propio = new Proprietaire("toto", "titi","1000","1000");
		proprietaireService.addProprietaire(propio);
		
		int resultatAttendu = tailleInitiale+1;
		
		List<Proprietaire> listeProprio1 = proprietaireService.findAllProprietaire();
		assertEquals(resultatAttendu,listeProprio1.size());
	}
	
	/**
	 * Test : deletePropietaire
	 */
	@Test
	@Transactional
	public void testDeleteProprietaire(){
		Proprietaire propio = new Proprietaire("toto", "titi","1000","1000");
		proprietaireService.addProprietaire(propio);
		
		List<Proprietaire> listeProprio = proprietaireService.findAllProprietaire();
		int tailleInitiale = listeProprio.size();
		proprietaireService.deleteProprietaire(propio.getId());
		
		if(tailleInitiale!=0){
			int resultatAttendu = tailleInitiale-1;
			List<Proprietaire> listeProprio1 = proprietaireService.findAllProprietaire();
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
		proprietaireService.addProprietaire(propio);
		
		Proprietaire proprioTrouve = proprietaireService.getByIdProprietaire(propio.getId());
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
		proprietaireService.addProprietaire(propio);
		
		Proprietaire proprioTrouve = proprietaireService.getByIdProprietaire(propio.getId());
		proprioTrouve.setNom("tata");	
		proprietaireService.addProprietaire(proprioTrouve);
		proprietaireService.updateProprietaire(proprioTrouve);
		
		
		Proprietaire proprioTrouve2 = proprietaireService.getByIdProprietaire(propio.getId());
		
		String resultatAttendu = proprioTrouve2.getNom();
		assertEquals(resultatAttendu,proprioTrouve.getNom());
	}
}
