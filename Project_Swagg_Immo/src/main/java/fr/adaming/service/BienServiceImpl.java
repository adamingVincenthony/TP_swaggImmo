package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IBienDao;
import fr.adaming.dao.BienDaoImpl;
import fr.adaming.entity.Bien;
import fr.adaming.entity.BienAAcheter;
import fr.adaming.entity.BienALouer;
import fr.adaming.entity.TerrainAAcheter;

@Service
@Transactional
public class BienServiceImpl implements IBienService{

	@Autowired
	private IBienDao bienDao = new BienDaoImpl();
	
	
	/**
	 * setter
	 * @param bienDao
	 */
	public void setBienDao(IBienDao bienDao) {
		this.bienDao = bienDao;
	}

	/**
	 * Ajoute un bien en appelant la methode associ�e de la dao
	 */
	@Override
	public void addBienBAL(BienALouer bien) {
		bien.setObjectif("Location");
		bienDao.addBien(bien);
		
	}
	
	
	/**
	 * Recupere une liste de bien
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<Bien> findAllBien() {
		return bienDao.findAllBiens();
	}

	
	

	/**
	 * Supprime un bien
	 */
	@Override
	public void deleteBien(int id) {

		bienDao.deleteBien(bienDao.getByIdBien(id));
		
	}


	/**
	 * Recupere un bien par son Id
	 */
	@Override
	public Bien getByIdBien(int id) {
		return bienDao.getByIdBien(id);
	}

	/**
	 * Service pour ajouter un bien � vendre
	 * Appel la m�thode g�n�rique pour ajouter un bien
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void addBienBAV(BienAAcheter bien) {
		bien.setObjectif("Vente");
		bienDao.addBien(bien);
		
	}

	/**
	 * Service pour ajouter un terrain � vendre
	 * Appel la m�thode g�n�rique pour un ajouter un bien � la bdd
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void addTerrain(TerrainAAcheter bien) {
		//Set le type du bien en Terrain
		bien.setObjectif("Vente(terrain)");
		bien.setType("Terrain");
		bienDao.addBien(bien);
		
	}

	/**
	 * Methode pour update un Ter
	 * appel une m�thode g�n�rique
	 */
	@Override
	public void updateBienTer(TerrainAAcheter bien) {
		bienDao.updateBien(bien);
		
	}

	/**
	 * Methode pour update un bav
	 * appel une m�thode g�n�rique
	 */
	@Override
	public void updateBienBav(BienAAcheter bien) {
		bienDao.updateBien(bien);
		
	}

	@Override
	public void updateBienBal(BienALouer bien) {
		bienDao.updateBien(bien);
		
	}

}
