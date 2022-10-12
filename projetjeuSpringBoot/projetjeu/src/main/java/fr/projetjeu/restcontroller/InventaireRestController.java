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

import fr.projetjeu.model.Inventaire;
import fr.projetjeu.service.InventaireService;


@RestController // controller rest pour webservice
@RequestMapping("/api/inventaire")
@CrossOrigin(origins = "*")
public class InventaireRestController {
	
	@Autowired
	private InventaireService srvInventaire; 
	
	@GetMapping("/{id}")
	public Inventaire findById(@PathVariable("id") Integer id) {
		return srvInventaire.findById(id);
	}
	

	@GetMapping("")
	public List<Inventaire> findAll() {
		return srvInventaire.findAll();
	}
	
	
	@PostMapping("")
	@ResponseStatus(code=HttpStatus.CREATED)
	//requestBody permet d'instancier un fournisseur (!!pas de classe abstraite) et recupère l'objet JSON en entrée et fait conresspondre les attributs
	public Inventaire create( @RequestBody Inventaire inventaire,BindingResult br){
		if(br.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
		srvInventaire.save(inventaire);
		return srvInventaire.findById(inventaire.getId());
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(code=HttpStatus.NO_CONTENT)//code 204 mais il prévient qu'il n'y a pas de contenu à supprimer mais la requete s'est bein déroulé
	public void delete(@PathVariable("id")Integer id) {
		try {
			srvInventaire.deleteById(id);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}
	

	}
	