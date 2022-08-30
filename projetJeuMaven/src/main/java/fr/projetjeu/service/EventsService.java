package fr.projetjeu.service;

import fr.projetjeu.exception.EntityNotValidException;
import fr.projetjeu.exception.EventNotFoundException;
import fr.projetjeu.exception.InvalidArgsException;
import fr.projetjeu.model.Events;
import fr.projetjeu.repo.IEventRepository;
import fr.projetjeu.repo.IReponseRepository;
import fr.projetjeu.repo.sql.EventsRepositorySql;
import fr.projetjeu.repo.sql.ReponseRepositorySql;

public class EventsService {
	 IEventRepository repoEvent = new EventsRepositorySql();
	 IReponseRepository repoReponse = new ReponseRepositorySql();
	
	public Events findById(int id) {
		if (id <= 0) {
			throw new InvalidArgsException();
		}
		
		Events event = this.repoEvent.findById(id);
		event.setReponse(repoReponse.findByEvenementId(id));
		
		return event;
	}
	
	public void save(Events event) {
		if(event==null) {
			throw new InvalidArgsException();
		}
		
		if(event.getHistoire()==null||event.getHistoire().isBlank()) {
			throw new EntityNotValidException();
		}
		this.repoEvent.save(event);
	}
	

}
