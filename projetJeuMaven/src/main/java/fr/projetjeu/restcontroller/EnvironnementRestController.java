package fr.projetjeu.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import fr.projetjeu.model.Environnement;
import fr.projetjeu.service.EnvironnementService;

@RestController
@RequestMapping("/api/environnement")
public class EnvironnementRestController {

	@Autowired
	private EnvironnementService srvEnvironnement;
	
	@GetMapping
	public List<Environnement> findAll(){
		return srvEnvironnement.findAll();
	}
	
	public Environnement findById(@PathVariable("id") Integer id) {
		try {
			return srvEnvironnement.findById(id);
		}
		catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}
	
	

}
