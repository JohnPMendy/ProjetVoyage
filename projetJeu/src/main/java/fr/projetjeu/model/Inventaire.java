package fr.projetjeu.model;

import java.util.ArrayList;
import java.util.List;

public class Inventaire {
	private List<Objet> listeObjetInventaire = new ArrayList<>();

	public List<Objet> getListeObjetInventaire() {
		System.out.println("Voici la liste des objets disponible dans votre inventaire :");
		for (Objet objet : listeObjetInventaire) {
			System.out.println(objet);
		}
		return listeObjetInventaire;
	}

	public void setListeObjetInventaire(List<Objet> listeObjetInventaire) {
		this.listeObjetInventaire = listeObjetInventaire;
	}

	public void ajoutObjet(Objet obj, int quantite) {
		if (this.listeObjetInventaire.contains(obj)) {
			int index = listeObjetInventaire.indexOf(obj);
			Objet objet = listeObjetInventaire.get(index);
			objet.setQuantite(objet.getQuantite() + quantite);
		} else {
			obj.setQuantite(quantite);
			this.listeObjetInventaire.add(obj);
		}

	}

	public void supprimer(Objet obj, int quantite) {
		obj.setQuantite(obj.getQuantite() - quantite);
		this.listeObjetInventaire.remove(obj);
	}

}
