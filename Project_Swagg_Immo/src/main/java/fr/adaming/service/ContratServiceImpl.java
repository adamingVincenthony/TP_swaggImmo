package fr.adaming.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IContratDao;
import fr.adaming.dao.BienDaoImpl;
import fr.adaming.dao.ClientDaoImpl;
import fr.adaming.dao.ContratDaoImpl;
import fr.adaming.dao.IBienDao;
import fr.adaming.dao.IClientDao;
import fr.adaming.entity.Bien;
import fr.adaming.entity.Client;
import fr.adaming.entity.Contrat;

@Service
@Transactional
public class ContratServiceImpl implements IContratService{

	@Autowired
	private IContratDao contratDao = new ContratDaoImpl();
	private IClientDao clientDao = new ClientDaoImpl();
	private IBienDao bienDao = new BienDaoImpl();
	
	
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
	public Contrat addContrat(Contrat contrat) {
		
		return contratDao.addContrat(contrat);
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

	/**
	 * méthode d'attribution d'un bien loué ou vendu à un client
	 */
	@Override
	public void attribuer(int idContrat, int idClient, int idBien) {
		
		/**
		 * récupération des objets client, contrat, bien à partir de leur id spécifié en argument de la méthode
		 */
		
		/**
		 * objectif : ajouter à un contrat créé les références du client et de l'objet loué ou acheté
		 * au client l'id du contrat modifié, au bien l'id du contrat modifié
		 */
		Client client = clientDao.getByIdClient(idClient);
		List<Contrat> listeContrat = client.getListeContrat();
		Bien bien = bienDao.getByIdBien(idBien);
		Contrat contrat = contratDao.getByIdContrat(idContrat);
		
		/**
		 * attribution du bien au contrat
		 */
		contrat.setBien(bien);
		/**
		 * attribution du client au contrat
		 */
		contrat.setClient(client);
		
		/**
		 * attribution du contrat au bien
		 */
		bien.setContrat(contrat);
		
		/**
		 * ajout du contrat à la liste récupérée
		 */
		listeContrat.add(contrat);
		
		/**
		 * attribution de la liste de contrat mise à jour au client
		 */
		client.setListeContrat(listeContrat);
		
		/**
		 * appel de la méthode d'attribution de la Dao
		 */
		contratDao.attribuer(contrat, client, bien);
	}

}
