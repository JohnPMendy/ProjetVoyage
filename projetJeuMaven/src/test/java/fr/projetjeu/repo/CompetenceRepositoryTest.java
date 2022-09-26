package fr.projetjeu.repo;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import fr.projetjeu.config.AppConfig;
import fr.projetjeu.model.Competence;

@SpringJUnitConfig(AppConfig.class) // Exécuter ce test avec le contexte de SPRING chargé avec la classe de config AppConfig
@Sql(scripts = "classpath:/dataClotilde.sql") // Ce script sera joué AVANT (par défaut) CHAQUE test unitaire
@ActiveProfiles("test") // On dit à SPRING qu'on va tester avec le profile "test"
public class CompetenceRepositoryTest {
	@Autowired
	private ICompetenceRepository repoCompetence;
	
//	@BeforeAll
//	public static void setup() {
//		// On ajoute au moins un réparateur
//		ICompetenceRepository repoReparateur = new CompetenceRepositoryJpa();
//		
//		Competence competence = new Competence();
//		competence.setNom(UUID.randomUUID().toString());
//		repoReparateur.save(competence);
//		
//		competence = new Competence();
//		competence.setNom(UUID.randomUUID().toString());
//		
//		repoReparateur.save(competence);
//	}
	
	@Test
	public void testFindAll() {
		List<Competence> competences = this.repoCompetence.findAll();
		
		Assertions.assertNotNull(competences);
		Assertions.assertTrue(competences.size() > 0);
		Assertions.assertEquals(1, competences.get(0).getId());
	}
	
	@Test
	public void testFindById() {
		Optional<Competence> competence = this.repoCompetence.findById(1);
		
		Assertions.assertNotNull(competence);
		Assertions.assertEquals(1, competence.get().getId());
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
		Competence competence = this.repoCompetence.findById(1).get();
		String randomName = UUID.randomUUID().toString();
		
		competence.setNom(randomName);
		this.repoCompetence.save(competence);
		
		competence = this.repoCompetence.findById(1).get();
		
		Assertions.assertEquals(randomName, competence.getNom());
	}
	@Test
	public void shouldDelete() {
		this.repoCompetence.deleteById(1);
		
		Assertions.assertFalse(this.repoCompetence.findById(1).isPresent());
	}
	
}
