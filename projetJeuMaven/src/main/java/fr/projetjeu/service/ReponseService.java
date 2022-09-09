package fr.projetjeu.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.projetjeu.exception.NegativeIdException;
import fr.projetjeu.exception.ReponseNotFoundException;
import fr.projetjeu.model.Reponse;
import fr.projetjeu.repo.IReponseRepository;

@Service
public class ReponseService  {
	
	@Autowired
	private IReponseRepository repositoryReponse;;
	
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
