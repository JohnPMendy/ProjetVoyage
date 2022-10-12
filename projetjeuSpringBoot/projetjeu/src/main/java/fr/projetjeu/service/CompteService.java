package fr.projetjeu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.projetjeu.exception.CompteNotFoundException;
import fr.projetjeu.exception.EntityNotFoundException;
import fr.projetjeu.exception.InvalidArgsException;
import fr.projetjeu.exception.InvalidEntityException;
import fr.projetjeu.model.Compte;
import fr.projetjeu.repo.ICompteRepository;

@Service
public class CompteService {
	@Autowired
	private ICompteRepository repoCompte;
	
	public Compte findByIdFetchParties(Integer id) {
		return repoCompte.findByIdFetchingParties(id).orElseThrow(CompteNotFoundException::new);
	}

	
	public Compte findById(	Integer id) {
		if (id<=0) {
			throw new InvalidArgsException("id");
		}
		System.out.println(id);
		System.out.println(this.repoCompte.findById(id));

		Compte compte = this.repoCompte.findById(id).get();
		System.out.println();
		if(compte==null) {
			throw new EntityNotFoundException();
		}
		return compte;
		
	}
	
	
	public void save(Compte compte) {
		
		repoCompte.save(compte);	
	}

	
}
