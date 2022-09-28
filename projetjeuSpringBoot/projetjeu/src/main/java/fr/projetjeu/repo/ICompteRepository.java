package fr.projetjeu.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.projetjeu.model.Compte;


public interface ICompteRepository extends JpaRepository<Compte, Long> {
	Optional<Compte> findByLogin(String login);
}
