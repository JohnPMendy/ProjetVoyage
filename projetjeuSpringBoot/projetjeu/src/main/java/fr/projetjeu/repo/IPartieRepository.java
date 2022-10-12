package fr.projetjeu.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.projetjeu.model.Partie;

public interface IPartieRepository extends JpaRepository<Partie, Integer> {
	
@Override
default List<Partie> findAllById(Iterable<Integer> ids) {
	// TODO Auto-generated method stub
	return null;
}

}
