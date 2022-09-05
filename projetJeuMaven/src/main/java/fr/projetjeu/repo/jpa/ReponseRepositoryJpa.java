package fr.projetjeu.repo.jpa;

import java.util.List;

import fr.projetjeu.model.Reponse;
import fr.projetjeu.repo.IReponseRepository;

public class ReponseRepositoryJpa extends AbstractRepositoryJpa<Reponse> implements IReponseRepository{

	public ReponseRepositoryJpa() {
		super(Reponse.class);
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Reponse> findByEvenementId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
