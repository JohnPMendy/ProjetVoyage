package fr.projetjeu.repo.jpa;

import fr.projetjeu.model.Inventaire;
import fr.projetjeu.repo.IInventaireRepository;

public class InventaireRepositoryJpa extends AbstractRepositoryJpa<Inventaire> implements IInventaireRepository{

	public InventaireRepositoryJpa() {
		super(Inventaire.class);
		// TODO Auto-generated constructor stub
	}
	
}

