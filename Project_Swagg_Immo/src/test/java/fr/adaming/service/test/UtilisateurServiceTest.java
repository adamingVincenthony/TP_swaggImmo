//package fr.adaming.service.test;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//
//import fr.adaming.entity.Utilisateur;
//import fr.adaming.service.IUtilisateurService;
//
//public class UtilisateurServiceTest {
//
//	@Autowired
//	IUtilisateurService utilisateurService;
//	
//	
//	/**
//	 * Test : addutilisateur & findAllUtilisateur
//	 */
//	@Test
//	@Transactional
//	public void testaddUtilisateur(){
//		List<Utilisateur> listeProprio = utilisateurService.findAllUtilisateurs();
//		int tailleInitiale = listeProprio.size();
//		Utilisateur propio = new Utilisateur("root", "root");
//		utilisateurService.addUtilisateur(propio);
//		
//		int resultatAttendu = tailleInitiale+1;
//		
//		List<Utilisateur> listeProprio1 = utilisateurService.findAllUtilisateurs();
//		assertEquals(resultatAttendu,listeProprio1.size());
//	}
//	
//	/**
//	 * Test : deleteUtilisateur
//	 */
//	@Test
//	@Transactional
//	public void testDeleteUtilisateur(){
//		Utilisateur propio = new Utilisateur("root", "root");
//		utilisateurService.addUtilisateur(propio);
//		
//		List<Utilisateur> listeProprio = utilisateurService.findAllUtilisateurs();
//		int tailleInitiale = listeProprio.size();
//		utilisateurService.deleteUtilisateur(propio);
//		
//		if(tailleInitiale!=0){
//			int resultatAttendu = tailleInitiale-1;
//			List<Utilisateur> listeProprio1 = utilisateurService.findAllUtilisateurs();
//			assertEquals(resultatAttendu,listeProprio1.size());
//		}
//	}
//	
//	/**
//	 * Test : getByIdUtilisateur
//	 */
//	@Test
//	@Transactional
//	public void testGetByIdUtilisateur(){
//		Utilisateur propio = new Utilisateur(900,"root", "root");
//		utilisateurService.addUtilisateur(propio);
//		
//		Utilisateur proprioTrouve = utilisateurService.getByIdUtilisateur(900);
//		String resultatAttendu = proprioTrouve.getNom();
//		assertEquals(resultatAttendu,propio.getNom());
//	}
//	
//	/**
//	 * Test : updateUtilisateur
//	 */
//	@Test
//	@Transactional
//	public void testUpdateUtilisateur(){
//		Utilisateur propio = new Utilisateur(900,"root", "root");
//		utilisateurService.addUtilisateur(propio);
//		
//		Utilisateur proprioTrouve = utilisateurService.getByIdUtilisateur(900);
//		proprioTrouve.setNom("tata");	
//		utilisateurService.addUtilisateur(proprioTrouve);
//		utilisateurService.updateUtilisateur(proprioTrouve);
//		
//		Utilisateur proprioTrouve2 = utilisateurService.getByIdUtilisateur(propio.getId());
//		
//		String resultatAttendu = proprioTrouve2.getNom();
//		assertEquals(resultatAttendu,proprioTrouve.getNom());
//	}
//}
