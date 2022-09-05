package fr.projetjeu.repo;

import java.util.UUID;

import org.junit.jupiter.api.BeforeAll;

import fr.projetjeu.model.Personnage;
import fr.projetjeu.repo.jpa.PersonnageRepositoryJpa;

public class PersonnageRepositoryTests {
	private IPersonnageRepository repoPersonnage = new PersonnageRepositoryJpa();
	
	@BeforeAll
	public static void setup() {
		// On ajoute au moins un réparateur
		IPersonnageRepository repoPersonnage = new PersonnageRepositoryJpa();
		
		Personnage perso = new Personnage();
		perso.setNom(UUID.randomUUID().toString());
		perso.setPrenom(UUID.randomUUID().toString());
		repoPersonnage.save(perso);
		

	}

}
