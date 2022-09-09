package fr.projetjeu.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.projetjeu.model.Events;

public interface IEventRepository extends JpaRepository<Events, Integer> {

}
