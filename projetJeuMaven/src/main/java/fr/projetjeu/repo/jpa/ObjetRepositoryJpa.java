package fr.projetjeu.repo.jpa;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;

import fr.projetjeu.model.Objet;
import fr.projetjeu.repo.IObjetRepository;

public class ObjetRepositoryJpa extends AbstractRepositoryJpa<Objet> implements IObjetRepository {

	public ObjetRepositoryJpa() {
		super(Objet.class);
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Objet> findAllInventaire(int inventaireId) {

		EntityManager em = emf.createEntityManager();

		try {
			return em.createQuery("select o from Objet  o where p.inventaires = ?1", Objet.class).setParameter(1, inventaireId).getResultList();
		}

		catch (Exception e) {
			return null;
		}

		finally {
			em.close();
		}

	}

	@Override
	public List<Objet> findAllBoutique(int boutiqueId) {
		EntityManager em = emf.createEntityManager();

		try {
			return em.createQuery("select o from Objet  o where p.boutiques = ?1", Objet.class).setParameter(1, boutiqueId).getResultList();
		}

		catch (Exception e) {
			return null;
		}

		finally {
			em.close();
		}
	}

}
