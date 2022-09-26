package fr.projetjeu.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import fr.projetjeu.exception.InvalidArgsException;
import fr.projetjeu.exception.InvalidEntityException;
import fr.projetjeu.model.Environnement;
import fr.projetjeu.model.Meteo;
import fr.projetjeu.model.TypeEnvironnement;
import fr.projetjeu.repo.IEnvironnementRepository;

@ExtendWith(MockitoExtension.class)
public class EnvServiceTest {
	@Mock
	private IEnvironnementRepository repoEnv;

	@InjectMocks
	private EnvironnementService srvEnv= new EnvironnementService();
	
	
	@Test
	public void shouldReturnProduitById() throws Exception {
		Mockito.when(this.repoEnv.findById(1)).thenReturn(Optional.of(new Environnement()));
		
		Assertions.assertNotNull(this.srvEnv.findById(1));
		
		Mockito.verify(this.repoEnv, Mockito.times(1)).findById(1);
	}
	
	@Test
	public void shouldThrowExceptionOnFindById() {
		Assertions.assertThrows(InvalidArgsException.class, () -> this.srvEnv.findById(0));
		
		Mockito.verify(this.repoEnv, Mockito.never()).findById(0);
	}
	
	
	@Test
	public void shouldThrowExceptionOnSaveWhenNullOrEmptyNom() {
		Environnement env = new Environnement();
		env.setMeteo(Meteo.NEIGE);
		env.setEnvironnement(TypeEnvironnement.FORET);
		env.setNom("Test env");
		env.setTemperature(37.2f);

		env.setNom(null);
		Assertions.assertThrows(InvalidEntityException.class, () -> srvEnv.save(env));

		env.setNom("");
		Assertions.assertThrows(InvalidEntityException.class, () -> srvEnv.save(env));

		Mockito.verify(this.repoEnv, Mockito.never()).save(Mockito.any());
	}

	@Test
	public void shouldThrowExceptionOnSaveWhenNullOrEmptyMeteo() {
		Environnement env = new Environnement();
		env.setMeteo(Meteo.NEIGE);
		env.setEnvironnement(TypeEnvironnement.FORET);
		env.setNom("Test env");
		env.setTemperature(37.2f);

		env.setMeteo(null);
		Assertions.assertThrows(InvalidEntityException.class, () -> srvEnv.save(env));

		Mockito.verify(this.repoEnv, Mockito.never()).save(Mockito.any());
	}

	@Test
	public void shouldThrowExceptionOnSaveWhenNullOrEmptyTypeEnvironnement() {
		Environnement env = new Environnement();
		env.setMeteo(Meteo.NEIGE);
		env.setEnvironnement(TypeEnvironnement.FORET);
		env.setNom("Test env");
		env.setTemperature(37.2f);

		env.setEnvironnement(null);
		Assertions.assertThrows(InvalidEntityException.class, () -> srvEnv.save(env));

		Mockito.verify(this.repoEnv, Mockito.never()).save(Mockito.any());
	}

	@Test
	public void shouldSave() {
		Environnement env = new Environnement();
		env.setMeteo(Meteo.NEIGE);
		env.setEnvironnement(TypeEnvironnement.FORET);
		env.setNom("Test env");
		env.setTemperature(37.2f);

		Assertions.assertDoesNotThrow(() -> srvEnv.save(env));

		Mockito.verify(this.repoEnv, Mockito.times(1)).save(Mockito.any());
	}
	
	@Test
	public void shouldReturnList() {
		List<Environnement> laListe = new ArrayList<>();
		
		laListe.add(new Environnement());
		
		Mockito.when(this.repoEnv.findAll()).thenReturn(laListe);
		Assertions.assertEquals(this.srvEnv.findAll(), laListe);
		Mockito.verify(this.repoEnv, Mockito.times(1)).findAll();
	}
	
	@Test
	public void shouldReturnListIfNull() {
		Mockito.when(this.repoEnv.findAll()).thenReturn(null);
		Assertions.assertNotNull(this.srvEnv.findAll());
		Mockito.verify(this.repoEnv, Mockito.times(1)).findAll();
	}
	
	@Test
	public void shouldDeleteById() throws Exception {
		this.repoEnv.deleteById(1);
		Mockito.verify(this.repoEnv, Mockito.times(1)).deleteById(1);
	}
	
	@Test
	public void shouldThrowExceptionOnDeleteById() {
		Assertions.assertThrows(InvalidArgsException.class, () -> this.srvEnv.deleteById(0));
		
		Mockito.verify(this.repoEnv, Mockito.never()).deleteById(0);
	}
	
}
