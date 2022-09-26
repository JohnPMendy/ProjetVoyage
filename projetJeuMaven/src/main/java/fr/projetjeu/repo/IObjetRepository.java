package fr.projetjeu.repo;


import org.springframework.data.jpa.repository.JpaRepository;

import fr.projetjeu.model.Objet;


public interface IObjetRepository extends JpaRepository<Objet, Integer> {


}	
