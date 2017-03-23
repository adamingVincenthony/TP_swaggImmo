package fr.adaming.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.adaming.entity.Contrat;
@Repository
public class ContratDaoImpl implements IContratDao{

	@Autowired
	private SessionFactory sf;

	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}
	
	@Override
	public Contrat addContrat(Contrat p) {
		
		return (Contrat) sf.getCurrentSession().save(p);
	}

	@Override
	public List<Contrat> findAllContrats() {
		String req="SELECT p from Contrat p";
		return sf.getCurrentSession().createQuery(req).list();
	}

	@Override
	public Contrat getByIdContrat(int id_p) {
		return (Contrat) sf.getCurrentSession().get(Contrat.class, id_p);
	}

	@Override
	public Contrat updateContrat(Contrat p) {
		return (Contrat) sf.getCurrentSession().merge(p);
	}

	@Override
	public void deleteContrat(Contrat p) {
		sf.getCurrentSession().delete(p);
	}
}
