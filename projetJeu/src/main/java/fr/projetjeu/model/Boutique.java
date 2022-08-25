package fr.projetjeu.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Boutique extends Events {
	private String nom;
	private TypeBoutique typeBoutique;
	static Scanner sc = new Scanner(System.in);

	public  Scanner getSc() {
		return sc;
	}

	public  void setSc(Scanner sc) {
		Boutique.sc = sc;
	}

	public String getNom() {
		return nom;
	}

	public TypeBoutique getTypeBoutique() {
		return typeBoutique;
	}

	public void setTypeBoutique(TypeBoutique typeBoutique) {
		this.typeBoutique = typeBoutique;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	/*
	 * public void achatObjets(Events e, Inventaire i, int idx,int qteAchete) { //
	 * idx c'est l'indice de l'objet a acheter de la boutique
	 * i.getListeObjetInventaire().add(e.getListeObjetEvent().get(idx)); }
	 * 
	 * public void venteObjets(Inventaire i, int idx) { // idx c'est l'indice de
	 * l'objet a vendre a la boutique i.getListeObjetInventaire().remove(idx);
	 * 
	 * }
	 */
// ca affiche precisement les objets de l'evenement :pas utilisee !!!!
	public void AffichageObjetsBoutique(Events e) {
		List<Objet> listeObjBoutique = new ArrayList<>();
		listeObjBoutique = e.getListeObjetEvent();
		int j = 1;
		for (Objet obj : listeObjBoutique) {
			System.out.println(j + "--" + obj);
			j++;
		}
	}
	
//ca affiche toutes les listes de type objets: utilisee !!
	public void AffichageObjets(List<Objet> A) {
		int j = 1;
		for (Objet obj : A) {
			System.out.println(j + "--" + obj);
			j++;
		}
	}

	public void achatObjet(Events e, Inventaire i,Personnage p) {
		//le type de la boutique depend de l'evenement 
		System.out.println("vous etes dans " + this.typeBoutique);
		System.out.println("Les articles disponibles dans cette boutique sont :");
		//AffichageObjetsBoutique(e); 
		AffichageObjets(e.getListeObjetEvent());
		System.out.println("Si vous etes interesse par un ou plusieurs articles de cette boutique tapez 1 sinon tapez 0");
		if (sc.nextInt()==0)
			return;
		else 
		System.out.println("quel est l'article que vous avez choisi ? ");
		System.out.println("N.B : Chaqu'un de nos articles correspond a un indice en chiffres 1,2,... ");
		int idx=sc.nextInt();
		System.out.println("quelle est la quantite que vous voulez ?");
		int qteAchete=sc.nextInt();
		Objet obj=e.getListeObjetEvent().get(idx-1);
		float prix=obj.getPrix()*qteAchete;
		if (p.getArgent()>=prix) // verification si le personnage a assez de sous pour acheter les produits selectionne
			{p.setArgent(p.getArgent()-prix);
			i.ajoutObjet(obj, qteAchete);}
		else {
			System.out.println("vous n'avez pas assez de sous pour acheter ces produits");
			return;
		}
	}
	public void venteObjet(Events e, Inventaire i,Personnage p) {
		System.out.println("vous etes dans " + this.typeBoutique);
		System.out.println("les articles que vous disposez sont ");
		AffichageObjets(i.getListeObjetInventaire());
		System.out.println("Quel article voulez vous vendre ?"); // a voir est ce que la boutique achete ou pas les articles
		int idx=sc.nextInt();
		System.out.println("quelle est la quantite que vous voulez vendre ?");
		int qteVendue=sc.nextInt();
		Objet obj=i.getListeObjetInventaire().get(idx-1);
		float prix=obj.getPrix()*qteVendue;
		p.setArgent(p.getArgent()+prix);
		i.supprimerObjet(obj, qteVendue);
		}

	}
		
	

