package fr.projet.service;

import java.util.ArrayList;
import java.util.List;

import fr.projet.exception.NegativeIdException;
import fr.projet.exception.ReponseNotFoundException;
import fr.projetjeu.model.Reponse;
import fr.projetjeu.repo.IReponseRepository;
import fr.projetjeu.repo.sql.ReponseRepositorySql;

public class ReponseService  {
	
	private IReponseRepository repositoryReponse = new ReponseRepositorySql();
	
	public void save(Reponse reponse) {
		
		this.repositoryReponse.save(reponse);
		
	}
	
	public List<Reponse> findByEvenementId(int id) throws NegativeIdException{
		List<Reponse> reponses = new ArrayList<>(); 
		
		if(id<=0) {
			throw new NegativeIdException();
		}
		else {
			reponses =this.repositoryReponse.findByEvenementId(id);
			
			if(reponses.size()==0) {
				throw new ReponseNotFoundException();
			}
		}
		
		return reponses;
		
	}

}
