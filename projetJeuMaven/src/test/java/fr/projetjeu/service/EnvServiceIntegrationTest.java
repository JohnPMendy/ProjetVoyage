package fr.projetjeu.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import fr.projetjeu.config.AppConfig;
import fr.projetjeu.exception.EntityNotFoundException;

@SpringJUnitConfig(AppConfig.class)
@Sql(scripts = "classpath:/data.sql")
@ActiveProfiles("test")
public class EnvServiceIntegrationTest {
	@Autowired
	private EnvironnementService srvEnvironnement;
	
	@Test
	public void shouldReturnFournisseurById() throws Exception {
		Assertions.assertNotNull(this.srvEnvironnement.findById(1));
	}
	
	@Test
	public void shouldThrowExceptionOnFindById() {
		Assertions.assertThrows(EntityNotFoundException.class, () -> this.srvEnvironnement.findById(10));
	}


}
