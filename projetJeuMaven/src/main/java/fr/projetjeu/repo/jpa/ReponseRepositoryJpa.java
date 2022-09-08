
package fr.projetjeu.repo.jpa;

import java.util.List;

import javax.persistence.EntityManager;

import fr.projetjeu.model.Reponse;
import fr.projetjeu.repo.IReponseRepository;

public class ReponseRepositoryJpa extends AbstractRepositoryJpa<Reponse> implements IReponseRepository {

	public ReponseRepositoryJpa() {
		super(Reponse.class);
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Reponse> findByEvenementId(int id) {
		EntityManager em = emf.createEntityManager();

		try {
			return em.createQuery("select r from Reponse r where r.evenementId =" + id, Reponse.class)
					.getResultList();

		}

		catch (Exception e) {
			return null;
		} finally {
			em.close();
		}
	}

}

