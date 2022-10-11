package fr.projetjeu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.projetjeu.exception.CompteNotFoundException;
import fr.projetjeu.model.Compte;
import fr.projetjeu.repo.ICompteRepository;

@Service
public class CompteService {
	@Autowired
	private ICompteRepository repoCompte;
	
	public Compte findByIdFetchParties(Long id) {
		return repoCompte.findByIdFetchingParties(id).orElseThrow(CompteNotFoundException::new);
	}

	
}
