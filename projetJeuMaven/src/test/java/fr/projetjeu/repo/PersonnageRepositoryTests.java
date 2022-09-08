package fr.projetjeu.repo;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import fr.projetjeu.model.Competence;
import fr.projetjeu.model.Humeur;
import fr.projetjeu.model.Personnage;
import fr.projetjeu.repo.jpa.CompetenceRepositoryJpa;
import fr.projetjeu.repo.jpa.PersonnageRepositoryJpa;

public class PersonnageRepositoryTests {
	private IPersonnageRepository repoPersonnage = new PersonnageRepositoryJpa();
	
	@BeforeAll
	public static void setup() {
		// On ajoute au moins un personnage
		IPersonnageRepository repoPersonnage = new PersonnageRepositoryJpa();
		List<Competence> competences = new ArrayList<>();
		
		ICompetenceRepository repoCompetence = new CompetenceRepositoryJpa();
		Competence competence = new Competence();
		competence.setNom(UUID.randomUUID().toString());
		repoCompetence.save(competence);
		competences.add(repoCompetence.findById(1));
		
		Personnage perso = new Personnage();
		
	
		perso.setNom(UUID.randomUUID().toString());
		perso.setPrenom(UUID.randomUUID().toString());
		perso.setHumeur(Humeur.values()[1]);
		perso.setCompetences(competences);
		repoPersonnage.save(perso);
		

	}
	@Test
	public void testFindAll() {
		List<Personnage> persos = this.repoPersonnage.findAll();
		
		Assertions.assertNotNull(persos);
		Assertions.assertTrue(persos.size() > 0);
		Assertions.assertEquals(1, persos.get(0).getId());
	}
	
	@Test
	public void testFindById() {
		Personnage perso = this.repoPersonnage.findById(1);
		
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
		
		Assertions.assertEquals(0, perso.getId());
		
		this.repoPersonnage.save(perso);

		Assertions.assertNotEquals(0, perso.getId());
	}
}
