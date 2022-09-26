package fr.projetjeu.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.projetjeu.model.ObjetInventaire;

public interface IObjetInventaireRepository extends JpaRepository<ObjetInventaire,Integer> {

}
