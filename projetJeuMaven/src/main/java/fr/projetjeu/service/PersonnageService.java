package fr.projetjeu.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.projetjeu.exception.EntityNotFoundException;
import fr.projetjeu.exception.InvalidArgsException;
import fr.projetjeu.exception.InvalidEntityException;
import fr.projetjeu.model.Personnage;
import fr.projetjeu.repo.IPersonnageRepository;
import fr.projetjeu.repo.jpa.PersonnageRepositoryJpa;

@Service
public class PersonnageService {
	@Autowired
	private IPersonnageRepository repoPersonnage;
	
	
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
		Personnage perso= this.repoPersonnage.findById(id).get();
		
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
