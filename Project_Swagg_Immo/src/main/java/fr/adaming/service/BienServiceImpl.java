package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IBienDao;
import fr.adaming.dao.BienDaoImpl;
import fr.adaming.entity.Bien;
import fr.adaming.entity.BienALouer;

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
		Bien bien = bienDao.getByIdBien(id);
		bienDao.deleteBien(bien);
		
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

}
