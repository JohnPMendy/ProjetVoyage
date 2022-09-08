package fr.projetjeu.repo;

import java.util.List;
import java.util.UUID;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import fr.projetjeu.model.Competence;
import fr.projetjeu.repo.jpa.CompetenceRepositoryJpa;

public class CompetenceRepositoryTest {
	private ICompetenceRepository repoCompetence = new CompetenceRepositoryJpa();
	
	@BeforeAll
	public static void setup() {
		// On ajoute au moins un réparateur
		ICompetenceRepository repoReparateur = new CompetenceRepositoryJpa();
		
		Competence competence = new Competence();
		competence.setNom(UUID.randomUUID().toString());
		repoReparateur.save(competence);
		
		competence = new Competence();
		competence.setNom(UUID.randomUUID().toString());
		
		repoReparateur.save(competence);
	}
	
	@Test
	public void testFindAll() {
		List<Competence> competences = this.repoCompetence.findAll();
		
		Assertions.assertNotNull(competences);
		Assertions.assertTrue(competences.size() > 0);
		Assertions.assertEquals(1, competences.get(0).getId());
	}
	
	@Test
	public void testFindById() {
		Competence competence = this.repoCompetence.findById(1);
		
		Assertions.assertNotNull(competence);
		Assertions.assertEquals(1, competence.getId());
	}
	
	@Test
	public void shouldAdd() {
		Competence competence = new Competence();
		String randomName = UUID.randomUUID().toString();
		
		competence.setNom(randomName);
		
		Assertions.assertEquals(0, competence.getId());
		
		this.repoCompetence.save(competence);

		Assertions.assertNotEquals(0, competence.getId());
	}
	
	@Test
	public void shouldUpdate() {
		Competence competence = this.repoCompetence.findById(1);
		String randomName = UUID.randomUUID().toString();
		
		competence.setNom(randomName);
		this.repoCompetence.save(competence);
		
		competence = this.repoCompetence.findById(1);
		
		Assertions.assertEquals(randomName, competence.getNom());
	}
	@Test
	public void shouldDelete() {
		this.repoCompetence.deleteById(2);
		
		Assertions.assertNull(this.repoCompetence.findById(2));
	}
	
}
