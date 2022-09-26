package fr.projetjeu.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.projetjeu.model.Environnement;

public interface IEnvironnementRepository extends JpaRepository<Environnement,Integer>  {

}
