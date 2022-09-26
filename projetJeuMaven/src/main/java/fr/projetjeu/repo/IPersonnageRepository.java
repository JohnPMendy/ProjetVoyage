package fr.projetjeu.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import fr.projetjeu.model.Personnage;


public interface IPersonnageRepository extends JpaRepository<Personnage,Integer>{
	@Query("select p from Personnage p left join fetch p.competences where p.id=?1")
	public Optional<Personnage> findByIdFetchingCompetences(Integer id);
}
