package fr.projetjeu.repo.jpa;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import fr.projetjeu.exception.CantDeleteException;
import fr.projetjeu.model.Events;
import fr.projetjeu.model.Reponse;
import fr.projetjeu.repo.IEventRepository;
import fr.projetjeu.repo.IReponseRepository;

public class ReponseRepositoryJpa extends AbstractRepositoryJpa<Reponse> implements IReponseRepository {

	public ReponseRepositoryJpa() {
		super(Reponse.class);
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Reponse> findByEvenementId(int id) {
		// TODO Auto-generated method stub
		List<Reponse> reponses = new ArrayList<>();
		EntityManager em = emf.createEntityManager();

		try {

			em.getTransaction().begin();

			em.createQuery("SELECT r FROM Reponse r WHERE r.evenementId = ?1").setParameter(1, id).executeUpdate();

			em.getTransaction().commit();

		}

		catch (Exception e) {
			return null;
		} finally {
			em.close();
		}
		return reponses;
	}

}
