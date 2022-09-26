package fr.projetjeu.repo;

import java.util.List;

import fr.projetjeu.model.Objet;

public interface IObjetRepository extends IRepository<Objet> {
	
	List<Objet> findAllByInventaireId(int id);
	List<Objet> findAllByBoutiqueId(int id);
}
