package fr.projetjeu.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import fr.projetjeu.model.Events;
import fr.projetjeu.model.JsonViews;
import fr.projetjeu.service.EventsService;
import fr.projetjeu.service.ReponseService;


//http://localhost:8080/voyages/api/events/1

@RestController // controller rest pour webservice
@RequestMapping("/api/events")
public class EventsRestController {
	
	@Autowired
	private EventsService evtService = new EventsService();
	
	@GetMapping("/{id}")
	@JsonView(JsonViews.EventsAvecReponses.class)
	public Events findById(@PathVariable("id") Integer id) {
		return evtService.findByIdFetchReponses(id);
	}
	
	
}
