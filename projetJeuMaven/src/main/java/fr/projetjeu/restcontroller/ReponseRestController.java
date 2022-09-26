package fr.projetjeu.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import fr.projetjeu.model.JsonViews;
import fr.projetjeu.model.Reponse;
import fr.projetjeu.service.ReponseService;

//http://localhost:8080/voyages/api/reponses/1

@RestController // controller rest pour webservice
@RequestMapping("/api/reponses")
public class ReponseRestController {
	
	@Autowired
	ReponseService repService = new ReponseService();

	@GetMapping("/{id}")
	@JsonView(JsonViews.Common.class)
	public List<Reponse> findByEvenementId(@PathVariable("id") Integer id){
		return repService.findByEvenementId(id);
	}
		
}