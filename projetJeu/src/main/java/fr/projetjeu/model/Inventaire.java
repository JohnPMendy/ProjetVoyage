package fr.projetjeu.model;

import java.util.ArrayList;
import java.util.List;

public class Inventaire {
	private List<Objet> listeObjetInventaire = new ArrayList<>();

	public List<Objet> getListeObjetInventaire() {
		System.out.println("Voici la liste des objets disponible dans votre inventaire :");
		afficherListObjet();
		return listeObjetInventaire;
	}

	public void setListeObjetInventaire(List<Objet> listeObjetInventaire) {
		this.listeObjetInventaire = listeObjetInventaire;
	}

	public void ajoutObjet(Objet obj, int quantite) {
		// nécessaire de vérifier si l'objet est déjà présent dans l'invetnaire, si
		// c'est le cas
		// on augmente juste la quantité présente sinon on crée un objet
		if (this.listeObjetInventaire.contains(obj)) {
			int index = listeObjetInventaire.indexOf(obj);
			Objet objet = listeObjetInventaire.get(index);
			objet.setQuantite(objet.getQuantite() + quantite);
		} else {
			obj.setQuantite(quantite);
			this.listeObjetInventaire.add(obj);
		}
		System.out.println(obj.getQuantite() + "exemplaire de  " + obj.getQuantite() + " ajouté à l'inventaire ! ");
	}

	public void supprimerObjet(Objet obj, int quantite) {
		if (this.listeObjetInventaire.contains(obj)) { // vérifier si l'objet existe dans l'inventaire
			int index = listeObjetInventaire.indexOf(obj);
			Objet objet = listeObjetInventaire.get(index);
			if (quantite == objet.getQuantite()) { // si la quantité qu'on veut supprimer est égale a la quantité totale
													// de chose qu'on veut supprimer, on supprime l'objet
				this.listeObjetInventaire.remove(obj);
				System.out.println(obj.getNom() + " a été supprimé de l'inventaire !");
			} else if (quantite < objet.getQuantite() && quantite > 0) {
				obj.setQuantite(obj.getQuantite() - quantite);
				if (quantite == 1) {
					System.out.println("un exemplaire de " + obj.getNom() + " a été supprimé de l'inventaire");
				}
				System.out.println(quantite + " exemplaires de " + obj.getNom() + " ont été supprimés de l'inventaire");
			} else {
				System.out.println("Mauvaise quantite selectionné");
			}

		} else {
			System.out.println("Cet objet n'existe pas dans l'inventaire...");
		}
	}

	/// petite fonction permettant l'affichage de l'inventaire integral
	public void afficherListObjet() {
		for (Objet objet : this.listeObjetInventaire) {
			System.out.println("objet : " + objet.getNom() + " ,quantité : " + objet.getQuantite()+" ,type d'objet :"); //regarder comment recuperer le type d'objet depuis l'Enum
		}
	}

}
