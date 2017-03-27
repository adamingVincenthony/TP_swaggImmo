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
	 * Ajoute un bien en appelant la methode associée de la dao
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
	 * Modifie un bien
	 */
	@Override
	public void updateBien(Bien bien) {
		bienDao.updateBien(bien);
		
	}

	/**
	 * Recupere un bien par son Id
	 */
	@Override
	public Bien getByIdBien(int id) {
		return bienDao.getByIdBien(id);
	}

	/**
	 * Service pour ajouter un bien à vendre
	 * Appel la méthode générique pour ajouter un bien
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void addBienBAV(BienAAcheter bien) {
		bien.setObjectif("Vente");
		bienDao.addBien(bien);
		
	}

	/**
	 * Service pour ajouter un terrain à vendre
	 * Appel la méthode générique pour un ajouter un bien à la bdd
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void addTerrain(TerrainAAcheter bien) {
		//Set le type du bien en Terrain
		bien.setObjectif("Vente");
		bien.setType("Terrain");
		bienDao.addBien(bien);
		
	}

}
