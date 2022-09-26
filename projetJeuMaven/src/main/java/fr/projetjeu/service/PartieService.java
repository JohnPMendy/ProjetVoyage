package fr.projetjeu.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.projetjeu.exception.EntityNotFoundException;
import fr.projetjeu.exception.InvalidArgsException;
import fr.projetjeu.exception.InvalidEntityException;
import fr.projetjeu.model.Environnement;
import fr.projetjeu.model.Partie;
import fr.projetjeu.repo.IPartieRepository;

@Service
public class PartieService {

	@Autowired
	private IPartieRepository repoPartie;


	public Partie findById(Integer id) {
		if (id <= 0) {
			throw new InvalidArgsException("id");
		}
		return this.repoPartie.findById(id).orElseThrow(EntityNotFoundException::new);

	}

	public List<Partie> findAll() {
		List<Partie> parties = repoPartie.findAll();

		if (parties == null) {
			return new ArrayList<>();
		}

		return parties;
	}

	public void save(Partie partie) {
		if (partie.getPersonnage() == null|| partie.getPersonnage().getId()<=0) {
			throw new InvalidEntityException("personnage");
		}

		if (partie.getEventRunning() == null||partie.getEventRunning().getId()<=0) {
			throw new InvalidEntityException("event");
		}
		
		if (partie.getEnvironnement() == null||partie.getEnvironnement().getId()<=0) {
			throw new InvalidEntityException("environnement");
		}
		
		if (partie.getDate() == null) {
			throw new InvalidEntityException("date");
		}
		
		if (partie.getInventaire() == null||partie.getInventaire().getId()<=0) {
			throw new InvalidEntityException("inventaire");
		}
		

		repoPartie.save(partie);
	}


	public void deleteById(Integer id) {
		if (id <= 0) {
			throw new InvalidArgsException("id");
		}

		repoPartie.deleteById(id);
	}

	public boolean existById(Integer id) {
		return repoPartie.existsById(id);
	}

}
