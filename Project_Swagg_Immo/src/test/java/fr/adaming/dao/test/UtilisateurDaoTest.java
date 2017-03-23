//package fr.adaming.dao.test;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//
//import fr.adaming.dao.IUtilisateurDao;
//import fr.adaming.entity.Utilisateur;
//
//
//public class UtilisateurDaoTest {
//
//	@Autowired
//	IUtilisateurDao utilisateurDao;
//	
//	
//	/**
//	 * Test : addUtilisateur & findAllUtilisateur
//	 */
//	@Test
//	@Transactional
//	public void testaddutilisateur(){
//		List<Utilisateur> listeProprio = utilisateurDao.findAllUtilisateurs();
//		int tailleInitiale = listeProprio.size();
//		Utilisateur propio = new Utilisateur("root", "root");
//		utilisateurDao.addUtilisateur(propio);
//		
//		int resultatAttendu = tailleInitiale+1;
//		
//		List<Utilisateur> listeProprio1 = utilisateurDao.findAllUtilisateurs();
//		assertEquals(resultatAttendu,listeProprio1.size());
//	}
//	
//	/**
//	 * Test : deleteUtilisateur
//	 */
//	@Test
//	@Transactional
//	public void testDeleteutilisateur(){
//		Utilisateur propio = new Utilisateur("root", "root");
//		utilisateurDao.addUtilisateur(propio);
//		
//		List<Utilisateur> listeProprio = utilisateurDao.findAllUtilisateurs();
//		int tailleInitiale = listeProprio.size();
//		utilisateurDao.deleteUtilisateur(propio);
//		
//		if(tailleInitiale!=0){
//			int resultatAttendu = tailleInitiale-1;
//			List<Utilisateur> listeProprio1 = utilisateurDao.findAllUtilisateurs();
//			assertEquals(resultatAttendu,listeProprio1.size());
//		}
//	}
//	
//	/**
//	 * Test : getByIdUtilisateur
//	 */
//	@Test
//	@Transactional
//	public void testGetByIdutilisateur(){
//		Utilisateur propio = new Utilisateur(900,"root", "root");
//		utilisateurDao.addUtilisateur(propio);
//		
//		Utilisateur proprioTrouve = utilisateurDao.getByIdUtilisateur(900);
//		String resultatAttendu = proprioTrouve.getNom();
//		assertEquals(resultatAttendu,propio.getNom());
//	}
//	
//	/**
//	 * Test : updateUtilisateur
//	 */
//	@Test
//	@Transactional
//	public void testUpdateutilisateur(){
//		Utilisateur propio = new Utilisateur(900,"root", "root");
//		utilisateurDao.addUtilisateur(propio);
//		
//		Utilisateur proprioTrouve = utilisateurDao.getByIdUtilisateur(900);
//		proprioTrouve.setNom("tata");	
//		utilisateurDao.addUtilisateur(proprioTrouve);
//		utilisateurDao.updateUtilisateur(proprioTrouve);
//		
//		Utilisateur proprioTrouve2 = utilisateurDao.getByIdUtilisateur(propio.getId());
//		
//		String resultatAttendu = proprioTrouve2.getNom();
//		assertEquals(resultatAttendu,proprioTrouve.getNom());
//	}
//}
