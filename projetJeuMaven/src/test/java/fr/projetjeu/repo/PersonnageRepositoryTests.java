package fr.projetjeu.repo;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import fr.projetjeu.config.AppConfig;
import fr.projetjeu.model.Competence;
import fr.projetjeu.model.Humeur;
import fr.projetjeu.model.Personnage;
import fr.projetjeu.repo.jpa.PersonnageRepositoryJpa;

@SpringJUnitConfig(AppConfig.class) // Exécuter ce test avec le contexte de SPRING chargé avec la classe de config AppConfig
@Sql(scripts = "classpath:/dataClotilde.sql") // Ce script sera joué AVANT (par défaut) CHAQUE test unitaire
@ActiveProfiles("test") // On dit à SPRING qu'on va tester avec le profile "test"
public class PersonnageRepositoryTests {
	@Autowired
	private IPersonnageRepository repoPersonnage;
	
//	@BeforeAll
//	public static void setup() {
//		// On ajoute au moins un personnage
//		IPersonnageRepository repoPersonnage = new PersonnageRepositoryJpa();
//		List<Competence> competences = new ArrayList<>();
//		
//		ICompetenceRepository repoCompetence = new CompetenceRepositoryJpa();
//		Competence competence = new Competence();
//		competence.setNom(UUID.randomUUID().toString());
//		repoCompetence.save(competence);
//		competences.add(repoCompetence.findById(1));
//		
//		Personnage perso = new Personnage();
//		
//	
//		perso.setNom(UUID.randomUUID().toString());
//		perso.setPrenom(UUID.randomUUID().toString());
//		perso.setHumeur(Humeur.values()[1]);
//		perso.setCompetences(competences);
//		repoPersonnage.save(perso);
//		
//	}
	@Test
	public void testFindAll() {
		List<Personnage> persos = this.repoPersonnage.findAll();
		
		Assertions.assertNotNull(persos);
		Assertions.assertTrue(persos.size() > 0);
		Assertions.assertEquals(1, persos.get(0).getId());
	}
	
	@Test
	public void testFindById() {
		Personnage perso = this.repoPersonnage.findById(1).get();
		
		Assertions.assertNotNull(perso);
		Assertions.assertEquals(1, perso.getId());
	}
	@Test
	public void shouldAdd() {
		Personnage perso = new Personnage();
		String randomName = UUID.randomUUID().toString();
		perso.setNom(randomName);
		
		randomName = UUID.randomUUID().toString();
		perso.setPrenom(randomName);
		
		List<Competence> competences = new ArrayList<>();
		perso.setCompetences(competences);
		
		perso.setHumeur(Humeur.values()[1]);
		perso.setPoids(0);
		perso.setArgent(0);
		perso.setEnergie(0);
		perso.setFaim(0);
		perso.setForce(0);
		perso.setCovided(false);
		perso.setAlive(true);
		
		Assertions.assertEquals(0, perso.getId());
		
		this.repoPersonnage.save(perso);

		Assertions.assertNotEquals(0, perso.getId());
	}
	
	@Test
	public void testDeleteById() {
		this.repoPersonnage.deleteById(1);
		Assertions.assertFalse(this.repoPersonnage.findById(1).isPresent());
	}
}
