package fr.adaming.service.test;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.entity.Bien;
import fr.adaming.entity.BienAAcheter;
import fr.adaming.entity.Client;
import fr.adaming.entity.Utilisateur;
import fr.adaming.service.IBienService;
import fr.adaming.service.IClientService;
import fr.adaming.service.IUtilisateurService;

@RunWith(SpringJUnit4ClassRunner.class) // le runner de spring
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/application-context.xml"})
public class UtilisateurServiceTest {

	@Autowired
	IUtilisateurService utilisateurService;
	
	@Autowired
	IClientService clientService;
	
	@Autowired
	IBienService bienService;
	
	/**
	 * Setter
	 * @param utilisateurService
	 */
	public void setUtilisateurService(IUtilisateurService utilisateurService) {
		this.utilisateurService = utilisateurService;
	}

	/**
	 * Test : addutilisateur & findAllUtilisateur
	 */
	@Test
	@Transactional
	public void testaddUtilisateur(){
		List<Utilisateur> listeProprio = utilisateurService.findAllUtilisateur();
		int tailleInitiale = listeProprio.size();
		Utilisateur propio = new Utilisateur("root", "root");
		utilisateurService.addUtilisateur(propio);
		
		int resultatAttendu = tailleInitiale+1;
		
		List<Utilisateur> listeProprio1 = utilisateurService.findAllUtilisateur();
		assertEquals(resultatAttendu,listeProprio1.size());
	}
	
	/**
	 * Test : deleteUtilisateur
	 */
	@Test
	@Transactional
	public void testDeleteUtilisateur(){
		Utilisateur propio = new Utilisateur("root", "root");
		utilisateurService.addUtilisateur(propio);
		
		List<Utilisateur> listeProprio = utilisateurService.findAllUtilisateur();
		int tailleInitiale = listeProprio.size();
		utilisateurService.deleteUtilisateur(propio.getId());
		
		if(tailleInitiale!=0){
			int resultatAttendu = tailleInitiale-1;
			List<Utilisateur> listeProprio1 = utilisateurService.findAllUtilisateur();
			assertEquals(resultatAttendu,listeProprio1.size());
		}
	}
	
	/**
	 * Test : getByIdUtilisateur
	 */
	@Test
	@Transactional
	public void testGetByIdUtilisateur(){
		Utilisateur propio = new Utilisateur(900,"root", "root");
		utilisateurService.addUtilisateur(propio);
		
		Utilisateur proprioTrouve = utilisateurService.getByIdUtilisateur(propio.getId());
		String resultatAttendu = proprioTrouve.getNom();
		assertEquals(resultatAttendu,propio.getNom());
	}
	
	/**
	 * Test : updateUtilisateur
	 */
	@Test
	@Transactional
	public void testUpdateUtilisateur(){
		Utilisateur propio = new Utilisateur(900,"root", "root");
		utilisateurService.addUtilisateur(propio);
		
		Utilisateur proprioTrouve = utilisateurService.getByIdUtilisateur(propio.getId());
		proprioTrouve.setNom("tata");	
		utilisateurService.addUtilisateur(proprioTrouve);
		utilisateurService.updateUtilisateur(proprioTrouve);
		
		Utilisateur proprioTrouve2 = utilisateurService.getByIdUtilisateur(propio.getId());
		
		String resultatAttendu = proprioTrouve2.getNom();
		assertEquals(resultatAttendu,proprioTrouve.getNom());
	}
	
	
//	/**
//	 * Test : attribuer bien/client
//	 */
//	@Test
//	@Transactional
//	public void testAttribuerClientBien(){
//		Client client1 = new Client(900, 1000, "toto");
//		Client client2 = new Client(901, 1000, "tata");
//		Client client3 = new Client(902, 1000, "titi");
//		Client client4 = new Client(903, 1000, "tete");
//		
//		Bien bien = new BienAAcheter("non-disponible");
//		
//		clientService.addClient(client1);
//		clientService.addClient(client2);
//		clientService.addClient(client3);
//		clientService.addClient(client4);
//		
//		
//		utilisateurService.attribuer(client1.getId(), bien.getId());
//		utilisateurService.attribuer(client2.getId(), bien.getId());
//		utilisateurService.attribuer(client3.getId(), bien.getId());
//		utilisateurService.attribuer(client4.getId(), bien.getId());
//		
//		int taille = bien.getClientInteret().size();
//		
//	}
}

	
	
