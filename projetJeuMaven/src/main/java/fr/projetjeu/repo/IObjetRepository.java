package fr.projetjeu.repo;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import fr.projetjeu.model.Objet;


public interface IObjetRepository extends JpaRepository<Objet, Integer> {


	//public List<Objet> findAllInventaire(int id);
	//public List<Objet> findAllBoutique(int id);
	
	@Query
	("UPDATE Objet o SET o. = ?1, u.lastname = ?2 WHERE o.id = ?3")
	public void update(String firstname, String lastname, int id);
}	
