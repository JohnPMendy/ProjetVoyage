package fr.projetjeu.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.projetjeu.model.Events;
import fr.projetjeu.model.Reponse;

public interface IReponseRepository extends JpaRepository<Reponse, Integer>{
	
	public List<Reponse> findByEvenementId(Events evenement);

}
