package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IProprietaireDao;
import fr.adaming.dao.ProprietaireDaoImpl;
import fr.adaming.entity.Proprietaire;

@Service
@Transactional
public class ProprietaireServiceImpl implements IProprietaireService{

	@Autowired
	private IProprietaireDao proprietaireDao = new ProprietaireDaoImpl();
	
	
	/**
	 * setter
	 * @param proprietaireDao
	 */
	public void setProprietaireDao(IProprietaireDao proprietaireDao) {
		this.proprietaireDao = proprietaireDao;
	}

	/**
	 * Ajoute un proprietaire en appelant la methode associée de la dao
	 */
	@Override
	public void addProprietaire(Proprietaire proprietaire) {
		
		proprietaireDao.addProprietaire(proprietaire);
	}
	
	/**
	 * Recupere une liste de proprietaire
	 */
	@Override
	public List<Proprietaire> findAllProprietaire() {
		return proprietaireDao.findAllProprietaires();
	}

	
	/**
	 * Supprime un proprietaire
	 */
	@Override
	public void deleteProprietaire(int id) {
		Proprietaire proprio = proprietaireDao.getByIdProprietaire(id);
		proprietaireDao.deleteProprietaire(proprio);
		
	}

	/**
	 * Modifie un proprietaire
	 */
	@Override
	public void updateProprietaire(Proprietaire proprietaire) {
		proprietaireDao.updateProprietaire(proprietaire);
		
	}

	/**
	 * Recupere un proprietaire par son Id
	 */
	@Override
	public Proprietaire getByIdProprietaire(int id) {
		return proprietaireDao.getByIdProprietaire(id);
	}

}
