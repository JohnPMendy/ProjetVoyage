package fr.projetjeu.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.projetjeu.exception.EntityNotFoundException;
import fr.projetjeu.exception.InvalidArgsException;
import fr.projetjeu.model.Inventaire;
import fr.projetjeu.repo.IInventaireRepository;

@Service
public class InventaireService {


		@Autowired
		private IInventaireRepository repoinventaire;
		
		
		public List<Inventaire> findAll() {
			List<Inventaire> inventaires = this.repoinventaire.findAll();
			
			if (inventaires == null) {
				return new ArrayList<>();
			}
			
			return inventaires;
		}
		
		public Inventaire findById(int id) {
			if (id<=0) {
				throw new InvalidArgsException("id");
			}
			Inventaire inventaire = this.repoinventaire.findById(id).get();
			
			if(inventaire==null) {
				throw new EntityNotFoundException();
			}
			return inventaire;
			
		}
		
		public void save(Inventaire inventaire) {

			repoinventaire.save(inventaire);
		}
		
		public void deleteById(int id) {
			if (id<=0) {
				throw new InvalidArgsException("id");
			}
			
			repoinventaire.deleteById(id);
		}
		
		
	}


