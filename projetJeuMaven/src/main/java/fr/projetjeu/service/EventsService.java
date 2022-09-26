package fr.projetjeu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.projetjeu.exception.EntityNotValidException;
import fr.projetjeu.exception.EventNotFoundException;
import fr.projetjeu.exception.InvalidArgsException;
import fr.projetjeu.model.Events;
import fr.projetjeu.repo.IEventRepository;
import fr.projetjeu.repo.IReponseRepository;

@Service
public class EventsService {
		
	 @Autowired
	 IEventRepository repoEvent;
	 
	 @Autowired
	 IReponseRepository repoReponse;
	
	public Events findById(Integer id) {
		if (id <= 0) {
			throw new InvalidArgsException("id");
		}
		
		return repoEvent.findById(id).orElseThrow(EventNotFoundException::new);

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
