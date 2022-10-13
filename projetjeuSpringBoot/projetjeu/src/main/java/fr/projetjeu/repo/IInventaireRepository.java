package fr.projetjeu.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import fr.projetjeu.model.Inventaire;

public interface IInventaireRepository extends JpaRepository<Inventaire,Integer> {
	@Query("select i from Inventaire i left join fetch i.objets where i.id=?1")
	public Optional<Inventaire>findByIdFetchingObjets(Integer id);
}
