package fr.projetjeu.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import fr.projetjeu.model.Compte;
import fr.projetjeu.model.JsonViews;
import fr.projetjeu.service.CompteService;

@RestController
@RequestMapping("/api/compte")
@CrossOrigin(origins = "*")
public class CompteRestController {
	
	@Autowired
	private CompteService srvCompte;
	
	@JsonView(JsonViews.CompteAvecParties.class)
	@GetMapping("/{id}/parties")
	public Compte findByIdFetchParties(@PathVariable("id")Long id) {
		return srvCompte.findByIdFetchParties(id);
	}

}
