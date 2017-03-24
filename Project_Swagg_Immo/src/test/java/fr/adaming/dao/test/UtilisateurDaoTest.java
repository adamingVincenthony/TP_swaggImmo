package fr.adaming.dao.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IUtilisateurDao;
import fr.adaming.entity.Bien;
import fr.adaming.entity.BienAAcheter;
import fr.adaming.entity.BienALouer;
import fr.adaming.entity.Client;
import fr.adaming.entity.Utilisateur;

@RunWith(SpringJUnit4ClassRunner.class) // le runner de spring
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/application-context.xml"})
public class UtilisateurDaoTest {

	@Autowired
	IUtilisateurDao utilisateurDao;
	
	
	/**
	 * Test : addUtilisateur & findAllUtilisateur
	 */
	@Test
	@Transactional
	public void testaddutilisateur(){
		List<Utilisateur> listeProprio = utilisateurDao.findAllUtilisateurs();
		int tailleInitiale = listeProprio.size();
		Utilisateur propio = new Utilisateur("root", "root");
		utilisateurDao.addUtilisateur(propio);
		
		int resultatAttendu = tailleInitiale+1;
		
		List<Utilisateur> listeProprio1 = utilisateurDao.findAllUtilisateurs();
		assertEquals(resultatAttendu,listeProprio1.size());
	}
	
	/**
	 * Test : deleteUtilisateur
	 */
	@Test
	@Transactional
	public void testDeleteutilisateur(){
		Utilisateur propio = new Utilisateur("root", "root");
		utilisateurDao.addUtilisateur(propio);
		
		List<Utilisateur> listeProprio = utilisateurDao.findAllUtilisateurs();
		int tailleInitiale = listeProprio.size();
		utilisateurDao.deleteUtilisateur(propio);
		
		if(tailleInitiale!=0){
			int resultatAttendu = tailleInitiale-1;
			List<Utilisateur> listeProprio1 = utilisateurDao.findAllUtilisateurs();
			assertEquals(resultatAttendu,listeProprio1.size());
		}
	}
	
	/**
	 * Test : getByIdUtilisateur
	 */
	@Test
	@Transactional
	public void testGetByIdutilisateur(){
		Utilisateur propio = new Utilisateur(900,"root", "root");
		utilisateurDao.addUtilisateur(propio);
		
		Utilisateur proprioTrouve = utilisateurDao.getByIdUtilisateur(propio.getId());
		String resultatAttendu = proprioTrouve.getNom();
		assertEquals(resultatAttendu,propio.getNom());
	}
	
	/**
	 * Test : updateUtilisateur
	 */
	@Test
	@Transactional
	public void testUpdateutilisateur(){
		Utilisateur propio = new Utilisateur(900,"root", "root");
		utilisateurDao.addUtilisateur(propio);
		
		Utilisateur proprioTrouve = utilisateurDao.getByIdUtilisateur(propio.getId());
		proprioTrouve.setNom("tata");	
		utilisateurDao.addUtilisateur(proprioTrouve);
		utilisateurDao.updateUtilisateur(proprioTrouve);
		
		Utilisateur proprioTrouve2 = utilisateurDao.getByIdUtilisateur(propio.getId());
		
		String resultatAttendu = proprioTrouve2.getNom();
		assertEquals(resultatAttendu,proprioTrouve.getNom());
	}
	


}
