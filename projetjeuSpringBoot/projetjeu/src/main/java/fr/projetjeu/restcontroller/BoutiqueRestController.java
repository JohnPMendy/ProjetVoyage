package fr.projetjeu.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.fasterxml.jackson.annotation.JsonView;

import fr.projetjeu.model.Boutique;
import fr.projetjeu.model.JsonViews;
import fr.projetjeu.service.BoutiqueService;
import fr.projetjeu.service.ObjetService;

@RestController // controller rest pour webservice
@RequestMapping("/api/boutique")
@CrossOrigin(origins = "*")
public class BoutiqueRestController {
	
	@Autowired
	private BoutiqueService srvBoutique; 
	
	
	@JsonView(JsonViews.Common.class)
	@GetMapping("/{id}")
	public Boutique findById(@PathVariable("id") Integer id) {
		return srvBoutique.findById(id);
	}
	
	@GetMapping("/{id}/objets")
	@JsonView(JsonViews.BoutiqueAvecObjets.class)
	public Boutique findByIdFetchObjets(@PathVariable("id") Integer id) {
		return srvBoutique.findByIdFetchObjets(id);
	}
	
	@JsonView(JsonViews.BoutiqueAvecObjets.class)
	@GetMapping("")
	public List<Boutique> findAll() {
		return srvBoutique.findAll();
	}
	
	
	@PostMapping("")
	@ResponseStatus(code=HttpStatus.CREATED)
	//requestBody permet d'instancier un fournisseur (!!pas de classe abstraite) et recupère l'objet JSON en entrée et fait conresspondre les attributs
	public Boutique create(@RequestBody Boutique boutique,BindingResult br){
		if(br.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
		srvBoutique.save(boutique);
		return srvBoutique.findById(boutique.getId());
	}
	
	
	@DeleteMapping("/{id}")
	@ResponseStatus(code=HttpStatus.NO_CONTENT)//code 204 mais il prévient qu'il n'y a pas de contenu à supprimer mais la requete s'est bein déroulé
	public void delete(@PathVariable("id")Integer id) {
		try {
			srvBoutique.deleteById(id);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}
	

	}
	