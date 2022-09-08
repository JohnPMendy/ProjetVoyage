package fr.projetjeu.repo;

import java.util.List;
import java.util.Optional;

import fr.projetjeu.model.Objet;

public interface IObjetRepository extends IRepository<Objet> {
	public List<Objet> findAllInventaire(int id);
	public List<Objet> findAllBoutique(int id);
}
