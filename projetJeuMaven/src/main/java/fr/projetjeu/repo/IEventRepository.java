package fr.projetjeu.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import fr.projetjeu.model.Events;

public interface IEventRepository extends JpaRepository<Events, Integer> {
	
	@Query("select e from Events e left join fetch e.reponses where e.id = ?1")
	public Optional<Events> findByIdFetchingReponses(int id);
}
