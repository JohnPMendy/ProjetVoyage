package fr.projet.service;

import fr.projetjeu.model.Reponse;
import fr.projetjeu.repo.IReponseRepository;
import fr.projetjeu.repo.sql.ReponseRepositorySql;

public class ReponseService  {
	
	private IReponseRepository repositoryReponse = new ReponseRepositorySql();
	
	public void save(Reponse reponse) {
		
		this.repositoryReponse.save(reponse);
		
	}

}
