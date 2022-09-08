package fr.projetjeu.service;

import java.util.ArrayList;
import java.util.List;

import fr.projetjeu.exception.EntityNotFoundException;
import fr.projetjeu.exception.InvalidArgsException;
import fr.projetjeu.exception.InvalidEntityException;
import fr.projetjeu.model.Competence;
import fr.projetjeu.model.Environnement;
import fr.projetjeu.repo.ICompetenceRepository;

import fr.projetjeu.repo.jpa.CompetenceRepositoryJpa;


public class CompetenceService {
	private ICompetenceRepository repoCompetence = new CompetenceRepositoryJpa();
	
	
	public List<Competence> findAll() {
		List<Competence> competences = this.repoCompetence.findAll();
		
		if (competences == null) {
			return new ArrayList<>();
		}
		
		return competences;
	}
	
	public Competence findById(int id) {
		if (id<=0) {
			throw new InvalidArgsException("id");
		}
		Competence competence = this.repoCompetence.findById(id);
		
		if(competence==null) {
			throw new EntityNotFoundException();
		}
		return competence;
		
	}
	
	public void save(Competence competence) {
		if (competence.getNom() == null || competence.getNom().isBlank()) {
			throw new InvalidEntityException("nom");
		}
		
		
		repoCompetence.save(competence);
	}
	public void deleteById(int id) {
		if (id<=0) {
			throw new InvalidArgsException("id");
		}
		
		repoCompetence.deleteById(id);
	}
}
