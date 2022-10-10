package fr.projetjeu.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.projetjeu.exception.EntityNotFoundException;
import fr.projetjeu.exception.InvalidArgsException;
import fr.projetjeu.exception.InvalidEntityException;
import fr.projetjeu.model.ObjetBoutique;
import fr.projetjeu.repo.IObjetBoutiqueRepository;

@Service
public class ObjetBoutiqueService {
	@Autowired
	private IObjetBoutiqueRepository repoObjBtq;
	
	
	public List<ObjetBoutique> findAll() {
		List<ObjetBoutique> objetboutiques = this.repoObjBtq.findAll();
		
		if (objetboutiques == null) {
			return new ArrayList<>();
		}
		
		return objetboutiques;
	}
	
	public ObjetBoutique findById(int id) {
		if (id<=0) {
			throw new InvalidArgsException("id");
		}
		ObjetBoutique objetBoutique = this.repoObjBtq.findById(id).get();
		
		if(objetBoutique==null) {
			throw new EntityNotFoundException();
		}
		return objetBoutique;
		
	}
	
	public void save(ObjetBoutique objetBoutique) {
		if (objetBoutique.getObjet().getNom() == null||objetBoutique.getBoutique().getNom() == null) {
			throw new InvalidEntityException("nom");
		}
		
		
		repoObjBtq.save(objetBoutique);
	}
	
	public void deleteById(int id) {
		if (id<=0) {
			throw new InvalidArgsException("id");
		}
		
		repoObjBtq.deleteById(id);
	}
}


