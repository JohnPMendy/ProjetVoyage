package fr.projetjeu.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import fr.projetjeu.model.Events;
import fr.projetjeu.model.Reponse;

public interface IReponseRepository extends JpaRepository<Reponse, Integer> {
	
	@Query("select r from Reponse r where r.evenementId.id = ?1")
	public List<Reponse> findByEvenementId(int id);
}
