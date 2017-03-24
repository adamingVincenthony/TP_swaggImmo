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

import fr.adaming.dao.IVisiteDao;
import fr.adaming.entity.Client;
import fr.adaming.entity.Visite;

@RunWith(SpringJUnit4ClassRunner.class) // le runner de spring
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/application-context.xml"})
public class VisiteDaoTest {

	@Autowired
	IVisiteDao VisiteDao;
	
	Client client = new Client(1000, "toto");
	
	/**
	 * setter
	 * @param visiteDao
	 */
	public void setVisiteDao(IVisiteDao visiteDao) {
		VisiteDao = visiteDao;
	}

	/**
	 * Test : addVisite & findAllVisite
	 */
	@Test
	@Transactional
	public void testaddVisite(){
		List<Visite> listeVisite = VisiteDao.findAllVisites();
		int tailleInitiale = listeVisite.size();
		Date date = new Date();
		Visite visite = new Visite(date);
		VisiteDao.addVisite(visite);
		
		int resultatAttendu = tailleInitiale+1;
		
		List<Visite> listeVisite1 = VisiteDao.findAllVisites();
		assertEquals(resultatAttendu,listeVisite1.size());
	}
	
	/**
	 * Test : deleteVisite
	 */
	@Test
	@Transactional
	public void testDeleteVisite(){
		Date date = new Date();
		Visite visite = new Visite(date);
		VisiteDao.addVisite(visite);
		
		List<Visite> listeVisite = VisiteDao.findAllVisites();
		int tailleInitiale = listeVisite.size();
		VisiteDao.deleteVisite(visite);
		
		if(tailleInitiale!=0){
			int resultatAttendu = tailleInitiale-1;
			List<Visite> listeVisite1 = VisiteDao.findAllVisites();
			assertEquals(resultatAttendu,listeVisite1.size());
		}
	}
	
	/**
	 * Test : getByIdVisite
	 */
	@Test
	@Transactional
	public void testGetByIdVisite(){
		Date date = new Date();
		Visite visite = new Visite(1000,date);
		VisiteDao.addVisite(visite);
		
		Visite VisiteTrouve = VisiteDao.getByIdVisite(visite.getId());
		Date resultatAttendu = VisiteTrouve.getDate();
		assertEquals(resultatAttendu,visite.getDate());
	}
	
	/**
	 * Test : updateVisite
	 */
	@Test
	@Transactional
	public void testUpdateVisite(){
		Date date = new Date();
		Visite visite =  new Visite(1000,date);
		VisiteDao.addVisite(visite);
		
		Visite VisiteTrouve = VisiteDao.getByIdVisite(visite.getId());

		VisiteTrouve.setClient(client);	
		VisiteDao.addVisite(VisiteTrouve);
		VisiteDao.updateVisite(VisiteTrouve);
		
		
		Visite VisiteTrouve2 = VisiteDao.getByIdVisite(visite.getId());
		
		Date resultatAttendu = VisiteTrouve2.getDate();
		assertEquals(resultatAttendu,VisiteTrouve.getDate());
	}
}
