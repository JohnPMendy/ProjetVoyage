package fr.projetjeu.repo;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import fr.projetjeu.config.AppConfig;
import fr.projetjeu.model.Environnement;
import fr.projetjeu.model.Meteo;
import fr.projetjeu.model.TypeEnvironnement;

@SpringJUnitConfig(AppConfig.class)
@Sql(scripts = "classpath:/data.sql")
@ActiveProfiles("test")
public class EnvironnementRepoTest {
	
	@Autowired
	private IEnvironnementRepository repoEnvironnement;

	@Test
	public void testFindAll() {
		List<Environnement> environnements = this.repoEnvironnement.findAll();

		Assertions.assertNotNull(environnements);
		// Assertions.assertTrue(environnements.size()>0);
		Assertions.assertEquals(1, environnements.get(0).getId());
	}

	@Test
	public void testFindById() {
		Optional<Environnement> env = this.repoEnvironnement.findById(1);
		Assertions.assertNotNull(env);
		Assertions.assertTrue(env.isPresent());
		Assertions.assertEquals(1, env.get().getId());
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
		Environnement env = this.repoEnvironnement.findById(1).get();
		String envNom = env.getNom();

		env.setNom("new ref");

		this.repoEnvironnement.save(env);

		env = this.repoEnvironnement.findById(1).get();

		Assertions.assertNotEquals(envNom, env.getNom());
	}

	@Test
	public void shouldDelete() {
		this.repoEnvironnement.deleteById(2);

		Assertions.assertFalse(this.repoEnvironnement.findById(2).isPresent());
	}

}
