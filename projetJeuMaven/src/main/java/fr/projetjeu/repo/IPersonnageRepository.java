package fr.projetjeu.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.projetjeu.model.Personnage;

public interface IPersonnageRepository extends JpaRepository<Personnage, Integer>{

}
