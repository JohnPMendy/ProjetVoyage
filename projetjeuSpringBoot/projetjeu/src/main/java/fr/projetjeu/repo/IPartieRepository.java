package fr.projetjeu.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import fr.projetjeu.model.Partie;

public interface IPartieRepository extends JpaRepository<Partie, Integer> {
	
@Query(( "select p from Partie p where p.id in :ids" ))
public List<Partie> findAllById(@Param("ids")List<Integer> ids);

}
