package fr.projetjeu.service;

import fr.projetjeu.exception.EnvironnementNotFoundException;
import fr.projetjeu.exception.InvalidArgsException;
import fr.projetjeu.model.Environnement;
import fr.projetjeu.repo.IEnvironnementRepository;
import fr.projetjeu.repo.sql.EnvironnementRepositorySql;

public class EnvironnementService {
	private IEnvironnementRepository repoEnvironnemnt = new EnvironnementRepositorySql();
	
	
	public Environnement findById(int id) {
		if (id<=0) {
			throw new InvalidArgsException();
		}
		Environnement env = this.repoEnvironnemnt.findById(id);
		
		if(env==null) {
			throw new EnvironnementNotFoundException();
		}
		return env;
		
	}
}
