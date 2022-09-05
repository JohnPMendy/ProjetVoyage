package fr.projetjeu.service;

import fr.projetjeu.exception.EntityNotValidException;
import fr.projetjeu.exception.EventNotFoundException;
import fr.projetjeu.exception.InvalidArgsException;
import fr.projetjeu.model.Events;
import fr.projetjeu.repo.IEventRepository;
import fr.projetjeu.repo.IReponseRepository;
import fr.projetjeu.repo.jpa.EventsRepositoryJpa;
import fr.projetjeu.repo.jpa.ReponseRepositoryJpa;
import fr.projetjeu.repo.sql.EventsRepositorySql;
import fr.projetjeu.repo.sql.ReponseRepositorySql;

public class EventsService {
	 IEventRepository repoEvent = new EventsRepositoryJpa();
	 IReponseRepository repoReponse = new ReponseRepositoryJpa();
	
	public Events findById(int id) {
		if (id <= 0) {
			throw new InvalidArgsException("id");
		}
		
		Events event = this.repoEvent.findById(id);
		event.setReponses(repoReponse.findByEvenementId(id));
		
		return event;
	}
	
	public void save(Events event) {
		if(event==null) {
			throw new InvalidArgsException("id");
		}
		
		if(event.getHistoire()==null||event.getHistoire().isBlank()) {
			throw new EntityNotValidException();
		}
		this.repoEvent.save(event);
	}
	

}
