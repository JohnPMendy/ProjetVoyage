package fr.projetjeu.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.projetjeu.model.Competence;

public interface ICompetenceRepository extends JpaRepository<Competence, Integer> {
	Optional<Competence>findByNom(String nom);

}
