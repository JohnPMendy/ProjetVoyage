package fr.projetjeu.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.projetjeu.model.Events;
import fr.projetjeu.service.EventsService;

@RestController // controller rest pour webservice
@RequestMapping("/api/events")
public class EventsRestController {
	
	@Autowired
	private EventsService evtService = new EventsService();
	
	@GetMapping("/{id}")
	public Events findById(@PathVariable("id") Integer id) {
		return evtService.findById(id);
	}
	
	
}
