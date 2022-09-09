package fr.projetjeu.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.projetjeu.model.Objet;

public interface IObjetRepository extends JpaRepository<Objet,Integer> {
	//public List<Objet> findAllInventaire(int id);
	//public List<Objet> findAllBoutique(int id);
}
