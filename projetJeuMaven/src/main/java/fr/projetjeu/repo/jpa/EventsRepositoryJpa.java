package fr.projetjeu.repo.jpa;

import fr.projetjeu.model.Events;
import fr.projetjeu.repo.IEnvironnementRepository;
import fr.projetjeu.repo.IEventRepository;

public class EventsRepositoryJpa extends AbstractRepositoryJpa<Events> implements IEventRepository{

	public EventsRepositoryJpa() {
		super(Events.class);
		// TODO Auto-generated constructor stub
	}
	
}

