package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IVisiteDao;
import fr.adaming.dao.VisiteDaoImpl;
import fr.adaming.entity.Visite;

@Service
@Transactional
public class VisiteServiceImpl implements IVisiteService{

	@Autowired
	private IVisiteDao visiteDao = new VisiteDaoImpl();
	
	
	/**
	 * setter
	 * @param visiteDao
	 */
	public void setVisiteDao(IVisiteDao visiteDao) {
		this.visiteDao = visiteDao;
	}

	/**
	 * Ajoute une visite en appelant la methode associée de la dao
	 */
	@Override
	public void addVisite(Visite visite) {
		
		visiteDao.addVisite(visite);
	}
	
	/**
	 * Recupere une liste de visite
	 */
	@Override
	public List<Visite> findAllVisite() {
		return visiteDao.findAllVisites();
	}

	
	/**
	 * Supprime une visite
	 */
	@Override
	public void deleteVisite(int id) {
		Visite visite = visiteDao.getByIdVisite(id);
		visiteDao.deleteVisite(visite);
		
	}

	/**
	 * Modifie une visite
	 */
	@Override
	public void updateVisite(Visite visite) {
		visiteDao.updateVisite(visite);
		
	}

	/**
	 * Recupere une visite par son Id
	 */
	@Override
	public Visite getByIdVisite(int id) {
		return visiteDao.getByIdVisite(id);
	}

}
