package fr.projetjeu.restcontroller;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.util.ReflectionUtils;
import org.springframework.validation.BindingResult;
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

import fr.projetjeu.model.Environnement;
import fr.projetjeu.model.Partie;
import fr.projetjeu.service.PartieService;

@RestController
@RequestMapping("/api/partie")
public class PartieRestController {

	@Autowired
	private PartieService srvPartie;
	
	@GetMapping
	public List<Partie> findAll(){
		return srvPartie.findAll();
	}
	
	@GetMapping("/{id}")
	public Partie findById(@PathVariable("id") Integer id) {
		try {
			return srvPartie.findById(id);
		}
		catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("")
	@ResponseStatus(code=HttpStatus.CREATED)
	//requestBody permet d'instancier un fournisseur (!!pas de classe abstraite) et recupère l'objet JSON en entrée et fait conresspondre les attributs
	public Partie create(@Valid @RequestBody Partie partie,BindingResult br){
		if(br.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
		srvPartie.save(partie);
		return srvPartie.findById(partie.getId());
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(code=HttpStatus.NO_CONTENT)//code 204 mais il prévient qu'il n'y a pas de contenu à supprimer mais la requete s'est bein déroulé
	public void delete(@PathVariable("id")Integer id) {
		try {
			srvPartie.deleteById(id);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}
	
	//Pour la modification/mise à jour c'est du PutMapping
	@PutMapping("{id}")
	public Partie update(@PathVariable("id")Integer id,@Valid @RequestBody Partie partie,BindingResult br) {
		if(br.hasErrors()||srvPartie.existById(id)) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
		partie.setId(id);
		srvPartie.save(partie);
		return partie;
		
	}
	
	@PatchMapping("/{id}")
	public Partie partialUpdate(@RequestBody Map<String,Object> fields,@PathVariable("id") Integer id) {
		Partie partie=srvPartie.findById(id);
//		produit.setReference(fields.get("reference").toString()) ;
		fields.forEach((key,value)->{
			//recupère un champ d'un Produit
			Field field=ReflectionUtils.findField(Environnement.class, key);
			ReflectionUtils.makeAccessible(field); //Pour pouvoir modifier la valeur obtenue 
			ReflectionUtils.setField(field, partie, value); //on change la valeur du champ du produit
		});
		srvPartie.save(partie);
		return partie;
	}
	
}
