package fr.projetjeu.repo;

import java.util.List;

import fr.projetjeu.model.Reponse;

public interface IReponseRepository extends IRepository<Reponse> {
	
	public List<Reponse> findByEvenementId(int id);

}
