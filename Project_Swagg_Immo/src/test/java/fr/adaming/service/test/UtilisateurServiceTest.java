package fr.adaming.service.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.map.ser.StdSerializers.UtilDateSerializer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.entity.Bien;
import fr.adaming.entity.BienAAcheter;
import fr.adaming.entity.BienALouer;
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
	
	
	/**
	 * Test : attribuer bien/client
	 */
	@Test
	@Transactional
	public void testAttribuerClientBien(){
		
		Client client1 = new Client(1000, "toto");

		BienALouer bien1 = new BienALouer(1000, 1000, 1000, "maison", "meuble");
		BienALouer bien2 = new BienALouer(1000, 1000, 1000, "appart", "meuble");
		BienALouer bien3 = new BienALouer(1000, 1000, 1000, "entrepot", "meuble");
		
		bienService.addBienBAL(bien1);
		bienService.addBienBAL(bien2);
		bienService.addBienBAL(bien3);
		
		clientService.addClient(client1);
		int taille;
		
		if(bien1.getClientInteret() == null){
			 taille = 0;
		}else{
			taille = bien1.getClientInteret().size();
		}
	
		utilisateurService.attribuer(client1.getId(), bien1.getId());
		utilisateurService.attribuer(client1.getId(), bien2.getId());
		utilisateurService.attribuer(client1.getId(), bien3.getId());
		
		int tailleRetour = bien1.getClientInteret().size();

		assertEquals(taille+1, tailleRetour);
		
	}
	
//	/**
//	 * Test : attribuer bien/utilisateur
//	 */
//	@Test
//	@Transactional
//	public void testAttribuerResponsableBien(){
//		
//		Utilisateur user1 = new Utilisateur("root","root");
//		
//		BienALouer bien = new BienALouer(1000, 1000, 1000, "maison", "meuble");
//		bienService.addBienBAL(bien);
//		
//		utilisateurService.attribuerBienResponsable(user1.getId(),bien.getId());
//		
//		String nomTrouve = bien.getResponsable().getNom();
//		
//		assertEquals(user1.getNom(),nomTrouve);
//		assertNotNull(user1.getListeBien());
//	}
}

	
	
