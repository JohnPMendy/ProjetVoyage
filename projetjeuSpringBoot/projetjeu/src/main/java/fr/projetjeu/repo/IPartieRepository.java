package fr.projetjeu.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.projetjeu.model.Partie;

public interface IPartieRepository extends JpaRepository<Partie, Integer> {

}
