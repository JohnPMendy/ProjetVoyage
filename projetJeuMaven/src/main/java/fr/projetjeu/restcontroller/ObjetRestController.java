package fr.projetjeu.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.projetjeu.model.Events;
import fr.projetjeu.model.Objet;
import fr.projetjeu.service.EventsService;
import fr.projetjeu.service.ObjetService;

@RestController // controller rest pour webservice
@RequestMapping("/api/objet")
public class ObjetRestController {
	
	@Autowired
	private ObjetService srvObjet; 
	
	@GetMapping("/{id}")
	public Objet findById(@PathVariable("id") Integer id) {
		return srvObjet.findById(id);
	}
	
	
}