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
import fr.projetjeu.model.Events;
import fr.projetjeu.model.Reponse;

@SpringJUnitConfig(AppConfig.class) // Exécuter ce test avec le contexte de SPRING chargé avec la classe de config AppConfig
@Sql(scripts = "classpath:/dataClotilde.sql") // Ce script sera joué AVANT (par défaut) CHAQUE test unitaire
@ActiveProfiles("test") // On dit à SPRING qu'on va tester avec le profile "test"
public class ReponseRepositorySpringTest {
	@Autowired
	private IReponseRepository repoReponse;
	@Autowired
	private IEventRepository eventRepo;
	
	@Test
	public void testFindAll() {
		List<Reponse> reponses = this.repoReponse.findAll();
		
		Assertions.assertNotNull(reponses );
		Assertions.assertTrue(reponses.size() > 0);
		Assertions.assertEquals(1, reponses .get(0).getId());
	}
	
	@Test
	public void testFindById() {
		Optional<Reponse> reponse = this.repoReponse.findById(2);
	
		Assertions.assertNotNull(reponse);
		Assertions.assertTrue(reponse.isPresent());
		Assertions.assertEquals(2, reponse.get().getId());
	}
//	@Test
//	public void testFindByEvenementId() {
//		Events evenement = this.eventRepo.findById(1).get();
//		
//		List<Reponse> reponses = this.repoReponse.findByEvenementId(1);
//		Assertions.assertNotNull(reponses);
//		Assertions.assertTrue(reponses.size() > 0);
//		
//		//Assertions.assertEquals(1, reponses.get(0).getEvenementId().getId());		
//		
//		//Verifier si toutes les reponses viennent de l"evenement 1
//		for (Reponse r : reponses) {
//			Assertions.assertEquals(1, r.getEvenementId().getId());
//		}
//		
//		
//	}
	
	@Test
	public void shouldAdd() {
		
		Events event = new Events();
		
		event.setHistoire("event test");
		this.eventRepo.save(event);
		
		Events eventSuivant = new Events();
		event.setHistoire("reponse");
		this.eventRepo.save(eventSuivant);
		
		
		Reponse reponse = new Reponse();
		
		reponse.setTexte("R4 : Licorne");
		reponse.setEvenementId(event);
		reponse.setProchainEvenementId(eventSuivant);
		
		Assertions.assertEquals(0, reponse.getId());
		
		this.repoReponse.save(reponse);

		Assertions.assertNotEquals(0, reponse.getId());
	}
	
	@Test
	public void shouldUpdate() {
		Reponse reponse = this.repoReponse.findById(1).get();
		String randomName = UUID.randomUUID().toString();
		
		reponse.setTexte(randomName);
		this.repoReponse.save(reponse);
		
		reponse = this.repoReponse.findById(1).get();
		
		Assertions.assertEquals(randomName, reponse.getTexte());
	}
	
	@Test
	public void shouldDelete() {
		this.repoReponse.deleteById(2);
		
		Assertions.assertFalse(this.repoReponse.findById(2).isPresent());
	}
	
	
	
	
}


