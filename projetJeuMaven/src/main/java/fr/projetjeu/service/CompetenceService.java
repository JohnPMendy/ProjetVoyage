package fr.projetjeu.service;

import java.util.ArrayList;
import java.util.List;

import fr.projetjeu.model.Competence;
import fr.projetjeu.model.Environnement;
import fr.projetjeu.repo.ICompetenceRepository;
import fr.projetjeu.repo.IEnvironnementRepository;
import fr.projetjeu.repo.jpa.CompetenceRepositoryJpa;
import fr.projetjeu.repo.jpa.EnvironnementRepositoryJpa;

public class CompetenceService {
	private ICompetenceRepository repoCompetence = new CompetenceRepositoryJpa();
	
	
	public List<Competence> findAll() {
		List<Competence> competences = this.repoCompetence.findAll();
		
		if (competences == null) {
			return new ArrayList<>();
		}
		
		return competences;
	}
	
}
