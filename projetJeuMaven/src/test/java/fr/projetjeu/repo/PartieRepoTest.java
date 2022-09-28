package fr.projetjeu.repo;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.web.WebAppConfiguration;

import fr.projetjeu.config.AppConfig;
import fr.projetjeu.model.Environnement;
import fr.projetjeu.model.Events;
import fr.projetjeu.model.Inventaire;
import fr.projetjeu.model.Partie;
import fr.projetjeu.model.Personnage;

@WebAppConfiguration
@SpringJUnitConfig(AppConfig.class)
@Sql(scripts = "classpath:/data.sql")
@ActiveProfiles("test")
public class PartieRepoTest {
	
	@Autowired
	private IPartieRepository repoPartie;
	
	@Autowired
	private IEventRepository repoEvent;

	@Autowired
	private IEnvironnementRepository repoEnvironnement;
	
	@Autowired
	private IPersonnageRepository repoPerso;
	
	@Autowired
	private IInventaireRepository repoInv;
	
	
	@Test
	public void testFindAll() {
		List<Partie> parties = this.repoPartie.findAll();

		Assertions.assertNotNull(parties);
		Assertions.assertTrue(parties.size()>0);
		Assertions.assertEquals(1, parties.get(0).getId());
	}

	@Test
	public void testFindById() {
		Optional<Partie> partie = this.repoPartie.findById(1);
		Assertions.assertNotNull(partie);
		Assertions.assertTrue(partie.isPresent());
		Assertions.assertEquals(1, partie.get().getId());
	}
	
	@Test
	public void shouldAdd() {
		Events event = repoEvent.findById(1).get();
		
		Personnage perso = repoPerso.findById(1).get();
		
		Environnement env = repoEnvironnement.findById(1).get();
		
		
		
		Partie partie = new Partie();
		partie.setPersonnage(perso);
		partie.setEnvironnement(env);
		partie.setEventRunning(event);
		partie.setInventaire(repoInv.findById(2).get());
		partie.setDate(LocalDateTime.now());
		
		
		Assertions.assertEquals(0, partie.getId());

		this.repoPartie.save(partie);

		Assertions.assertNotEquals(0, partie.getId());
	}

	@Test
	public void shouldUpdate() {
		Partie partie = this.repoPartie.findById(2).get();
		LocalDateTime partieDate = partie.getDate();

		partie.setDate(LocalDateTime.now());

		this.repoPartie.save(partie);

		partie = this.repoPartie.findById(2).get();

		Assertions.assertNotEquals(partieDate, partie.getDate());
	}

	@Test
	public void shouldDelete() {
		this.repoPartie.deleteById(2);

		Assertions.assertFalse(this.repoPartie.findById(2).isPresent());
	}

}
