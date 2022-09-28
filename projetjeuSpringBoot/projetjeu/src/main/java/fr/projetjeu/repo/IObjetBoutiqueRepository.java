package fr.projetjeu.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.projetjeu.model.ObjetBoutique;

public interface IObjetBoutiqueRepository extends JpaRepository<ObjetBoutique,Integer> {

}
