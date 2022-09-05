package fr.projetjeu.repo;

import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import fr.projetjeu.model.Environnement;
import fr.projetjeu.model.Meteo;
import fr.projetjeu.model.TypeEnvironnement;
import fr.projetjeu.repo.jpa.EnvironnementRepositoryJpa;

public class EnvironnementRepoTest {
	private IEnvironnementRepository repoEnvironnement = new EnvironnementRepositoryJpa();
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProjetUnit");

	@Test
	public void testFindAll() {
		List<Environnement> environnements = this.repoEnvironnement.findAll();

		Assertions.assertNotNull(environnements);
		// Assertions.assertTrue(environnements.size()>0);
		Assertions.assertEquals(1, environnements.get(0).getId());
	}

	@Test
	public void testFindById() {
		Environnement env = this.repoEnvironnement.findById(1);
		Assertions.assertNotNull(env);
		Assertions.assertEquals(1, env.getId());
	}
	
	@Test
	public void shouldAdd() {
		Environnement env = new Environnement();
		env.setMeteo(Meteo.NEIGE);
		env.setEnvironnement(TypeEnvironnement.FORET);
		env.setNom("Test env");
		env.setTemperature(37.2f);

		Assertions.assertEquals(0, env.getId());

		this.repoEnvironnement.save(env);

		Assertions.assertNotEquals(0, env.getId());
	}

	@Test
	public void shouldUpdate() {
		Environnement env = this.repoEnvironnement.findById(1);
		String envNom = env.getNom();

		env.setNom("new ref");

		this.repoEnvironnement.save(env);

		env = this.repoEnvironnement.findById(1);

		Assertions.assertNotEquals(envNom, env.getNom());
	}

	@Test
	public void shouldDelete() {
		this.repoEnvironnement.deleteById(2);

		Assertions.assertNull(this.repoEnvironnement.findById(2));
	}

}
