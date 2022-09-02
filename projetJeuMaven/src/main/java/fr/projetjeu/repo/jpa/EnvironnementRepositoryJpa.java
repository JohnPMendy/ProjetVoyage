package fr.projetjeu.repo.jpa;

import fr.projetjeu.model.Environnement;
import fr.projetjeu.repo.IEnvironnementRepository;

public class EnvironnementRepositoryJpa extends AbstractRepositoryJpa<Environnement> implements IEnvironnementRepository {

	public EnvironnementRepositoryJpa() {
		super(Environnement.class);
		// TODO Auto-generated constructor stub
	}
	
}
