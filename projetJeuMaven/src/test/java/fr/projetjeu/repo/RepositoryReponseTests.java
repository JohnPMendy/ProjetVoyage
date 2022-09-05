package fr.projetjeu.repo;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import fr.projetjeu.model.Reponse;
import fr.projetjeu.repo.jpa.ReponseRepositoryJpa;

public class RepositoryReponseTests {
	private IReponseRepository repoReponse = new ReponseRepositoryJpa();

	List<Reponse> reponses = this.repoReponse.findAll();

	@Test
	public void listShouldNotBeEmpty() {
		Assertions.assertNotNull(reponses);
		Assertions.assertTrue(reponses.size() > 0);
		Assertions.assertEquals(1, reponses.get(0).getId());
	}
}
