package fr.projetjeu.restcontroller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.fasterxml.jackson.annotation.JsonView;

import fr.projetjeu.model.Competence;
import fr.projetjeu.model.JsonViews;
import fr.projetjeu.service.CompetenceService;

@RestController
@RequestMapping("/api/competence")
@CrossOrigin(origins = "*")
public class CompetenceRestController {
	
	@Autowired
	private CompetenceService srvCompetence;
	
	@GetMapping("")
	@JsonView(JsonViews.Competence.class)
	public List<Competence> findAll(){
		return srvCompetence.findAll();
	}
	
	@GetMapping("/{id}")
	@JsonView(JsonViews.Competence.class)
	public Competence findById(@PathVariable("id") Integer id) {
		try {
		return srvCompetence.findById(id);
		}
		catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
	}
	
	@PostMapping("")
	@ResponseStatus(code=HttpStatus.CREATED)
	@JsonView(JsonViews.Competence.class)
	public Competence create(@Valid @RequestBody Competence competence, BindingResult br) {
		if(br.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
		srvCompetence.save(competence);
		return competence;
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") Integer id) {
		try {
			srvCompetence.deleteById(id);
		}
		catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}
	
	@JsonView(JsonViews.Competence.class)
	@PutMapping("/{id}")
	public Competence replace(@PathVariable("id") Integer id,@Valid @RequestBody Competence competence,BindingResult br) {
		if(br.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
		
		srvCompetence.findById(id);
		System.out.println("apres findbyid");
		competence.setId(id);
		srvCompetence.save(competence);
		return competence;
	}
}
