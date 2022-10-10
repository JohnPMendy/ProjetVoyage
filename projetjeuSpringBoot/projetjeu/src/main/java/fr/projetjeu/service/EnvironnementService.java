package fr.projetjeu.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.projetjeu.exception.EntityNotFoundException;
import fr.projetjeu.exception.InvalidArgsException;
import fr.projetjeu.exception.InvalidEntityException;
import fr.projetjeu.model.Environnement;
import fr.projetjeu.repo.IEnvironnementRepository;

@Service
public class EnvironnementService {

	@Autowired
	private IEnvironnementRepository repoEnvironnement;

	public Environnement findById(Integer id) {
		if (id <= 0) {
			throw new InvalidArgsException("id");
		}
		return this.repoEnvironnement.findById(id).orElseThrow(EntityNotFoundException::new);

	}

	public List<Environnement> findAll() {
		List<Environnement> environnements = repoEnvironnement.findAll();

		if (environnements == null) {
			return new ArrayList<>();
		}

		return environnements;
	}

	public void save(Environnement environnement) {
		if (environnement.getNom() == null || environnement.getNom().isBlank()) {
			throw new InvalidEntityException("nom");
		}

		if (environnement.getEnvironnement() == null) {
			throw new InvalidEntityException("type environnement");
		}
		
		if (environnement.getMeteo() == null) {
			throw new InvalidEntityException("meteo");
		}

		repoEnvironnement.save(environnement);
	}

	public void deleteById(Integer id) {
		if (id <= 0) {
			throw new InvalidArgsException("id");
		}

		repoEnvironnement.deleteById(id);
	}
	
	public boolean existById(Integer id) {
		return repoEnvironnement.existsById(id);
	}

}
