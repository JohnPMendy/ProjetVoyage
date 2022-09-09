package fr.projetjeu.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.projetjeu.model.Boutique;
import fr.projetjeu.model.Objet;

public interface IBoutiqueRepository extends JpaRepository<Boutique,Integer>  {

}
