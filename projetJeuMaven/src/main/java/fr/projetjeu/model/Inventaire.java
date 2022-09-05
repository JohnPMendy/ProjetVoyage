package fr.projetjeu.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="inventaire")
public class Inventaire {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "inv_id")
	private int id;
	
	@ManyToMany(mappedBy = "inventaires")
	private List<Objet> listeObjetInventaire = new ArrayList<>();
	
	@OneToOne(mappedBy = "inventaire")
	private Partie partie;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	

	public Partie getPartie() {
		return partie;
	}

	public void setPartie(Partie partie) {
		this.partie = partie;
	}

	public List<Objet> getListeObjetInventaire() {
		System.out.println("Voici la liste des objets disponible dans votre inventaire :");
		afficherListObjet();
		return listeObjetInventaire;
	}

	public void setListeObjetInventaire(List<Objet> listeObjetInventaire) {
		this.listeObjetInventaire = listeObjetInventaire;
	}

	public void ajoutObjet(Objet obj, int quantite) {
		// nﾃｩcessaire de vﾃｩrifier si l'objet est dﾃｩjﾃ� prﾃｩsent dans l'invetnaire, si
		// c'est le cas
		// on augmente juste la quantitﾃｩ prﾃｩsente sinon on crﾃｩe un objet
		if (this.listeObjetInventaire.contains(obj)) {
			int index = listeObjetInventaire.indexOf(obj);
			Objet objet = listeObjetInventaire.get(index);
			objet.setQuantiteInventaire(objet.getQuantiteInventaire() + quantite);
		} else {
			obj.setQuantiteInventaire(quantite);
			this.listeObjetInventaire.add(obj);
		}
		System.out.println(obj.getQuantiteInventaire() + " " + obj.getNom() + " ajoutﾃｩ ﾃ� l'inventaire ! ");
	}

	public void supprimerObjet(Objet obj, int quantite) {
		if (this.listeObjetInventaire.contains(obj)) { // vﾃｩrifier si l'objet existe dans l'inventaire
			int index = listeObjetInventaire.indexOf(obj);
			Objet objet = listeObjetInventaire.get(index);
			if (quantite == objet.getQuantiteInventaire()) { // si la quantitﾃｩ qu'on veut supprimer est ﾃｩgale a la quantitﾃｩ totale
													// de chose qu'on veut supprimer, on supprime l'objet
				this.listeObjetInventaire.remove(obj);
				System.out.println(obj.getNom() + " a ﾃｩtﾃｩ supprimﾃｩ de l'inventaire !");
			} else if (quantite < objet.getQuantiteInventaire() && quantite > 0) {
				obj.setQuantiteInventaire(obj.getQuantiteInventaire() - quantite);
				if (quantite == 1) {
					System.out.println("un exemplaire de " + obj.getNom() + " a ﾃｩtﾃｩ supprimﾃｩ de l'inventaire");
				}
				System.out.println(quantite + " exemplaires de " + obj.getNom() + " ont ﾃｩtﾃｩ supprimﾃｩs de l'inventaire");
			} else {
				System.out.println("Mauvaise quantite selectionnﾃｩ");
			}

		} else {
			System.out.println("Cet objet n'existe pas dans l'inventaire...");
		}
	}

	/// petite fonction permettant l'affichage de l'inventaire integral
	public void afficherListObjet() {
		for (Objet objet : this.listeObjetInventaire) {
			System.out.println("objet : " + objet.getNom() + " ,quantitﾃｩ : " + objet.getQuantiteInventaire()+" ,type d'objet : "+ objet.getTypeObjets()); //regarder comment recuperer le type d'objet depuis l'Enum
		}
	}

}
