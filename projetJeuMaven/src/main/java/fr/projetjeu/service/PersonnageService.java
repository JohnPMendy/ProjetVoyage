package fr.projetjeu.service;

import java.util.ArrayList;
import java.util.List;

import fr.projetjeu.exception.EntityNotFoundException;
import fr.projetjeu.exception.InvalidArgsException;
import fr.projetjeu.exception.InvalidEntityException;
import fr.projetjeu.model.Competence;
import fr.projetjeu.model.Environnement;
import fr.projetjeu.model.Personnage;
import fr.projetjeu.repo.IPersonnageRepository;
import fr.projetjeu.repo.jpa.PersonnageRepositoryJpa;

public class PersonnageService {
	private IPersonnageRepository repoPersonnage = new PersonnageRepositoryJpa();
	
	
	public List<Personnage> findAll() {
		List<Personnage> persos = this.repoPersonnage.findAll();
		
		if (persos == null) {
			return new ArrayList<>();
		}
		
		return persos;
	}
	
	public Personnage findById(int id) {
		if (id<=0) {
			throw new InvalidArgsException("id");
		}
		Personnage perso= this.repoPersonnage.findById(id);
		
		if(perso==null) {
			throw new EntityNotFoundException();
		}
		return perso;
		
	}
	
	public void save(Personnage perso) {
		if (perso.getNom() == null || perso.getNom().isBlank()) {
			throw new InvalidEntityException("nom");
		}
		
		if (perso.getCompetences() == null) {
			throw new InvalidEntityException("competences");
		}
		
		if (perso.getHumeur() == null) {
			throw new InvalidEntityException("humeur");
		}
	
		
		repoPersonnage.save(perso);
	}

}
