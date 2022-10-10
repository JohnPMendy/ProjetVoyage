package fr.projetjeu.restcontroller;


import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.util.ReflectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.fasterxml.jackson.annotation.JsonView;

import fr.projetjeu.model.JsonViews;
import fr.projetjeu.model.Personnage;
import fr.projetjeu.service.PersonnageService;

@RestController
@RequestMapping("/api/personnage")
@CrossOrigin(origins = "*")
public class PersonnageRestController {
	
	@Autowired
	private PersonnageService srvPersonnage;
	
	@JsonView(JsonViews.Personnage.class)
	@GetMapping("")
	public List<Personnage> findAll(){
		return srvPersonnage.findAll();
	}
	
	@GetMapping("/{id}")
	@JsonView(JsonViews.Personnage.class)
	public Personnage findById(@PathVariable("id") Integer id) {
		try {
			return srvPersonnage.findById(id);
		}
		catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
	}
	@GetMapping("/{id}/competences")
	@JsonView(JsonViews.PersonnageAvecCompetence.class)
	public Personnage findByIdFetchCompetences(@PathVariable("id")Integer id) {
		return srvPersonnage.findByIdFetchingCompetences(id);
		
	}
	
	@PostMapping("")
	@ResponseStatus(code= HttpStatus.CREATED)
	@JsonView(JsonViews.Personnage.class)
	public Personnage personnage(@Valid @RequestBody Personnage personnage, BindingResult br) {
		if(br.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
		srvPersonnage.save(personnage);
		return personnage;
	}
	
	@ResponseStatus(code=HttpStatus.NO_CONTENT)
	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") Integer id) {
		try {
			srvPersonnage.deleteById(id);
		}
		catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}
	
	@JsonView(JsonViews.PersonnageAvecCompetence.class)
	@PutMapping("/{id}")
	public Personnage replace(@PathVariable("id")Integer id,@Valid @RequestBody Personnage personnage,BindingResult br) {
		if(br.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
		else {
			personnage.setId(id);
			srvPersonnage.save(personnage);
			return personnage;
		}
	}
	@JsonView(JsonViews.PersonnageAvecCompetence.class)
	@PatchMapping("/{id}")
	public Personnage partialEdit(@RequestBody Map<String, Object> fields,@PathVariable("id")Integer id) {
		Personnage personnage = srvPersonnage.findById(id);
		
		fields.forEach((key,value)->{
			if(key.equals("competences")) {
			}
			else {
				Field field= ReflectionUtils.findField(Personnage.class, key);
				
				ReflectionUtils.makeAccessible(field);
				ReflectionUtils.setField(field, personnage, value);
				
			
		}
	});
		
		srvPersonnage.save(personnage);
		return personnage;
	}

}
