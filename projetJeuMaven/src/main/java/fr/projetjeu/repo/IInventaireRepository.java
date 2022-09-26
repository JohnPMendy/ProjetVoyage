package fr.projetjeu.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.projetjeu.model.Inventaire;

public interface IInventaireRepository extends JpaRepository<Inventaire,Integer> {

}
