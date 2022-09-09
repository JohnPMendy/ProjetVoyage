package fr.projetjeu.service;

import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.projetjeu.model.Boutique;
import fr.projetjeu.model.Inventaire;
import fr.projetjeu.model.Objet;
import fr.projetjeu.model.Personnage;
import fr.projetjeu.repo.IObjetRepository;
import fr.projetjeu.repo.jpa.ObjetRepositoryJpa;


//@Service
public class ObjetService {

	@Autowired 
	private IObjetRepository repoObjet;


	static Scanner sc = new Scanner(System.in);
	
	public Scanner getSc() {
		return sc;
	}

	public void setSc(Scanner sc) {
		ObjetService.sc = sc;
	}
	
	
	
	public void ajoutObjetInventaire(Objet obj, int quantite) {
		// nécessaire de vérifier si l'objet est déjà présent dans l'invetnaire, si
		// c'est le cas
		// on augmente juste la quantité présente sinon on crée un objet

		if (obj.getId() != 0) {
			obj.setQuantiteInventaire(obj.getQuantiteInventaire() + quantite);
		}
		this.repoObjet.save(obj);
		System.out.println(obj.getQuantiteInventaire() + " " + obj.getNom() + " ajouté dans l'inventaire ! ");
	}

	public void supprimerObjetInventaire(Objet obj, int quantite) {

		if (quantite == obj.getQuantiteInventaire()) {
			obj.setQuantiteInventaire(0);
			System.out.println(obj.getNom() + " a été supprimé de l'inventaire !");

		} else if (quantite < obj.getQuantiteInventaire() && quantite > 0) {
			obj.setQuantiteInventaire(obj.getQuantiteInventaire() - quantite);
			if (quantite == 1) {
				System.out.println("un exemplaire de " + obj.getNom() + " a été supprimé de l'inventaire");
			} else {
				System.out.println(quantite + " exemplaires de " + obj.getNom() + " ont été supprimés de l'inventaire");
			}
		} else {
			System.out.println("Mauvaise quantite selectionné");
		}
	}

	
	public void achatObjet(Boutique b,Inventaire i, Personnage p) {
		// le type de la boutique depend de l'evenement
		System.out.println("vous etes dans " + b.getTypeBoutique());
		System.out.println("Les articles disponibles dans cette boutique sont :");
		// AffichageObjetsBoutique(e);
		//AffichageObjets(repoObjet.findAllBoutique(b.getId()));
		System.out
				.println("Si vous etes interesse par un ou plusieurs articles de cette boutique tapez 1 sinon tapez 0");
		if (sc.nextInt() == 0)
			return;
		else
			System.out.println("quel est l'article que vous avez choisi ? ");
		System.out.println("N.B : Chaqu'un de nos articles correspond a un indice en chiffres 1,2,... ");
		int idx = sc.nextInt();
		System.out.println("quelle est la quantite que vous voulez ?");
		int qteAchete = sc.nextInt();
		Objet obj = repoObjet.findAllBoutique(b.getId()).get(idx - 1);
		float prix = obj.getPrix() * qteAchete;
		if (p.getArgent() >= prix) // verification si le personnage a assez de sous pour acheter les produits
									// selectionne
		{
			p.setArgent(p.getArgent() - prix);
			this.ajoutObjetInventaire(obj, qteAchete);
		} else {
			System.out.println("vous n'avez pas assez de sous pour acheter ces produits");
			return;
		}
	}

	public void venteObjet( Boutique b,Inventaire i, Personnage p) {
		System.out.println("vous etes dans " + b.getTypeBoutique());
		System.out.println("les articles que vous disposez sont ");
		//AffichageObjets(repoObjet.findAllInventaire(i.getId()));
		System.out.println("Quel article voulez vous vendre ?"); // a voir est ce que la boutique achete ou pas les
																	// articles
		int idx = sc.nextInt();
		System.out.println("quelle est la quantite que vous voulez vendre ?");
		int qteVendue = sc.nextInt();
		Objet obj = i.getListeObjetInventaire().get(idx - 1);
		float prix = obj.getPrix() * qteVendue;
		p.setArgent(p.getArgent() + prix);
		this.supprimerObjetInventaire(obj, qteVendue);
	}
	
	
		
	public void AffichageObjets(List<Objet> A) {
		for (int j =1;j<A.size();j++) {
			System.out.println(j + "--" + A.get(j));
		}
	}

}
