package fr.projetjeu.repo.jpa;

import fr.projetjeu.model.Boutique;
import fr.projetjeu.repo.IBoutiqueRepository;

public class BoutiqueRepositoryJpa extends AbstractRepositoryJpa<Boutique> implements IBoutiqueRepository{

	public BoutiqueRepositoryJpa() {
		super(Boutique.class);
		// TODO Auto-generated constructor stub
	}
	
}

