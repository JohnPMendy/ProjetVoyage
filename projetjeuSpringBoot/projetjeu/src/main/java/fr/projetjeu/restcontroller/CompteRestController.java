package fr.projetjeu.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.projetjeu.model.Compte;
import fr.projetjeu.service.CompteService;

@RestController
@RequestMapping("/api/compte")
@CrossOrigin(origins = "*")
public class CompteRestController {
	
	@Autowired
	private CompteService srvCompte;
	
	@GetMapping("/{id}/parties")
	public Compte findByIdFetchParties(@PathVariable("id")Integer id) {
		return srvCompte.findByIdFetchParties(id);
	}

}
