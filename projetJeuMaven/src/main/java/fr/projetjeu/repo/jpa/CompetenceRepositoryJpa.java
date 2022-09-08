package fr.projetjeu.repo.jpa;

import fr.projetjeu.model.Competence;
import fr.projetjeu.repo.ICompetenceRepository;

public class CompetenceRepositoryJpa extends AbstractRepositoryJpa<Competence> implements ICompetenceRepository{

	public CompetenceRepositoryJpa() {
		super(Competence.class);
		// TODO Auto-generated constructor stub
	}

}
