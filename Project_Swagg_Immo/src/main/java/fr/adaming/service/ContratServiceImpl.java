package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IContratDao;
import fr.adaming.dao.ContratDaoImpl;
import fr.adaming.entity.Contrat;

@Service
@Transactional
public class ContratServiceImpl implements IContratService{

	@Autowired
	private IContratDao contratDao = new ContratDaoImpl();
	
	
	/**
	 * setter
	 * @param contratDao
	 */
	public void setContratDao(IContratDao contratDao) {
		this.contratDao = contratDao;
	}

	/**
	 * Ajoute un contrat en appelant la methode associée de la dao
	 */
	@Override
	public void addContrat(Contrat contrat) {
		
		contratDao.addContrat(contrat);
	}
	
	/**
	 * Recupere une liste de contrat
	 */
	@Override
	public List<Contrat> findAllContrat() {
		return contratDao.findAllContrats();
	}

	
	/**
	 * Supprime un contrat
	 */
	@Override
	public void deleteContrat(int id) {
		Contrat contrat = contratDao.getByIdContrat(id);
		contratDao.deleteContrat(contrat);
		
	}

	/**
	 * Modifie un contrat
	 */
	@Override
	public void updateContrat(Contrat contrat) {
		contratDao.updateContrat(contrat);
		
	}

	/**
	 * Recupere un contrat par son Id
	 */
	@Override
	public Contrat getByIdContrat(int id) {
		return contratDao.getByIdContrat(id);
	}

}
