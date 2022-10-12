package fr.projetjeu.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

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

	@Autowired
	private PasswordEncoder passwordEncoder;

	@JsonView(JsonViews.CompteAvecParties.class)
	@GetMapping("/{id}/parties")
	public Compte findByIdFetchParties(@PathVariable("id") Long id) {
		return srvCompte.findByIdFetchParties(id);
	}

	@JsonView(JsonViews.Compte.class)
	@PostMapping("")
	@ResponseStatus(code = HttpStatus.CREATED)

	public Compte create(@RequestBody Compte compte, BindingResult br) {
		if (br.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}

		compte.setMdp(passwordEncoder.encode(compte.getMdp()));
		srvCompte.save(compte);
		return srvCompte.findById(compte.getId());
	}
}
