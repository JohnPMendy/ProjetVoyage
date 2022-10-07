package fr.projetjeu.restcontroller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import fr.projetjeu.model.Compte;
import fr.projetjeu.model.JsonViews;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*")
public class AuthRestController {

	@GetMapping("")
	@JsonView(JsonViews.Compte.class)
	public Compte authentication(@AuthenticationPrincipal Compte compte) {
		return compte;
	}
}
