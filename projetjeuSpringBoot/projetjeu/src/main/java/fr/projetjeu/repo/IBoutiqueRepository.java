package fr.projetjeu.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import fr.projetjeu.model.Boutique;

public interface IBoutiqueRepository extends JpaRepository<Boutique,Integer>  {
	 
		@Query("select b from Boutique b left join fetch b.objets where b.id=?1")
		public Optional<Boutique>findByIdFetchingObjets(Integer id);
}
