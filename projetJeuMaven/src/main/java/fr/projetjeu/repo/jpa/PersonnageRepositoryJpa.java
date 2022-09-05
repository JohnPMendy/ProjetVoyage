package fr.projetjeu.repo.jpa;

import fr.projetjeu.model.Personnage;
import fr.projetjeu.repo.IPersonnageRepository;

public class PersonnageRepositoryJpa extends AbstractRepositoryJpa<Personnage> implements IPersonnageRepository {

	public PersonnageRepositoryJpa() {
		super(Personnage.class);
		// TODO Auto-generated constructor stub
	}

}
