package fr.projetjeu.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.projetjeu.exception.EntityNotFoundException;
import fr.projetjeu.exception.InvalidArgsException;
import fr.projetjeu.exception.InvalidEntityException;
import fr.projetjeu.model.Boutique;
import fr.projetjeu.model.Competence;
import fr.projetjeu.repo.IBoutiqueRepository;
import fr.projetjeu.repo.ICompetenceRepository;

@Service
public class BoutiqueService {


		@Autowired
		private IBoutiqueRepository repoBoutique;
		
		
		public List<Boutique> findAll() {
			List<Boutique> boutiques = this.repoBoutique.findAll();
			
			if (boutiques == null) {
				return new ArrayList<>();
			}
			
			return boutiques;
		}
		
		public Boutique findById(int id) {
			if (id<=0) {
				throw new InvalidArgsException("id");
			}
			Boutique boutique = this.repoBoutique.findById(id).get();
			
			if(boutique==null) {
				throw new EntityNotFoundException();
			}
			return boutique;
			
		}
		
		public void save(Boutique boutique) {
			if (boutique.getNom() == null || boutique.getNom().isBlank()) {
				throw new InvalidEntityException("nom");
			}
			
			
			repoBoutique.save(boutique);
		}
		public void deleteById(int id) {
			if (id<=0) {
				throw new InvalidArgsException("id");
			}
			
			repoBoutique.deleteById(id);
		}
	}


