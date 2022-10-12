package fr.projetjeu.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.projetjeu.exception.EntityNotFoundException;
import fr.projetjeu.exception.InvalidArgsException;
import fr.projetjeu.exception.InvalidEntityException;
import fr.projetjeu.model.Competence;
import fr.projetjeu.repo.ICompetenceRepository;

@Service
public class CompetenceService {
	@Autowired
	private ICompetenceRepository repoCompetence;;
	
	
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
		Competence competence = this.repoCompetence.findById(id).get();
		
		if(competence==null) {
			throw new EntityNotFoundException();
		}
		return competence;
		
	}
	
	public Competence findByNom(String nom) {

		Competence competence = this.repoCompetence.findByNom(nom).get();
		
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
