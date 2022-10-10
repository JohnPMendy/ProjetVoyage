package fr.projetjeu.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.projetjeu.exception.EntityNotFoundException;
import fr.projetjeu.exception.InvalidArgsException;
import fr.projetjeu.exception.InvalidEntityException;
import fr.projetjeu.model.ObjetInventaire;
import fr.projetjeu.repo.IObjetInventaireRepository;

@Service
public class ObjetInventaireService {
	@Autowired
	private IObjetInventaireRepository repoObjInv;
	
	
	public List<ObjetInventaire> findAll() {
		List<ObjetInventaire> objetInventaires = this.repoObjInv.findAll();
		
		if (objetInventaires == null) {
			return new ArrayList<>();
		}
		
		return objetInventaires;
	}
	
	public ObjetInventaire findById(int id) {
		if (id<=0) {
			throw new InvalidArgsException("id");
		}
		ObjetInventaire objetInventaire = this.repoObjInv.findById(id).get();
		
		if(objetInventaire==null) {
			throw new EntityNotFoundException();
		}
		return objetInventaire;
		
	}
	
	public void save(ObjetInventaire ObjetInventaire) {
		if (ObjetInventaire.getObjet().getNom() == null) {
			throw new InvalidEntityException("nom");
		}
		
		
		repoObjInv.save(ObjetInventaire);
	}
	
	public void deleteById(int id) {
		if (id<=0) {
			throw new InvalidArgsException("id");
		}
		
		repoObjInv.deleteById(id);
	}
}


