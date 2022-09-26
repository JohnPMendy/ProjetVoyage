package fr.projetjeu.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import fr.projetjeu.model.Competence;
import fr.projetjeu.model.JsonViews;
import fr.projetjeu.service.CompetenceService;

@RestController
@RequestMapping("/api/competence")
public class CompetenceRestController {
	
	@Autowired
	private CompetenceService srvCompetence;
	
	@GetMapping("")
	@JsonView(JsonViews.Competence.class)
	public List<Competence> findAll(){
		return srvCompetence.findAll();
	}
}
