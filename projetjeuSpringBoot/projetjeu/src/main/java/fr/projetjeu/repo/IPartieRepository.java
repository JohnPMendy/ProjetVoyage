package fr.projetjeu.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.projetjeu.model.Partie;

public interface IPartieRepository extends JpaRepository<Partie, Integer> {
	
//	@Query("select p from Partie p where p.compte_id=?1")
//	public List<Partie> findByCompteId(Integer id);

}
