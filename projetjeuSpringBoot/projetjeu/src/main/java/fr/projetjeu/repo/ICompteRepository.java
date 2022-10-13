package fr.projetjeu.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import fr.projetjeu.model.Compte;


public interface ICompteRepository extends JpaRepository<Compte, Integer> {
	Optional<Compte> findByLogin(String login);
	
	@Query("select c from Compte c left join fetch c.parties where c.id=?1")
	public Optional<Compte> findByIdFetchingParties(Integer id);
}
