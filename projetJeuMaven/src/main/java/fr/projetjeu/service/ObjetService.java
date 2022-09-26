package fr.projetjeu.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.projetjeu.exception.EntityNotFoundException;
import fr.projetjeu.exception.InvalidArgsException;
import fr.projetjeu.exception.InvalidEntityException;
import fr.projetjeu.model.Boutique;
import fr.projetjeu.model.Inventaire;
import fr.projetjeu.model.Objet;
import fr.projetjeu.model.ObjetInventaire;
import fr.projetjeu.model.Personnage;
import fr.projetjeu.repo.IInventaireRepository;
import fr.projetjeu.repo.IObjetInventaireRepository;
import fr.projetjeu.repo.IObjetRepository;

@Service
public class ObjetService  {


	@Autowired
	private IInventaireRepository repoInventaire;
	
	@Autowired
	private IObjetInventaireRepository repoObjetInventaire;

	static Scanner sc = new Scanner(System.in);

	public Scanner getSc() {
		return sc;
	}

	public void setSc(Scanner sc) {
		ObjetService.sc = sc;
	}

	@Transactional
	public void ajoutObjetInventaire(Objet obj, int quantite, Inventaire inventaire) {
		// nécessaire de vérifier si l'objet est déjà présent dans l'invetnaire, si
		// c'est le cas
		// on augmente juste la quantité présente sinon on crée un objet
		/*
		 * obj.setObjetInventaires(repoObjet.findAll().);
		 * obj.setQuantiteInventaire(obj.getQuantiteInventaire() + quantite); }
		 * repoObjet.save(obj); System.out.println(obj.getQuantiteInventaire() + " " +
		 * obj.getNom() + " ajouté dans l'inventaire ! "); }
		 */
		ObjetInventaire objetInventaire = new ObjetInventaire();
		objetInventaire.setObjet(obj);
		objetInventaire.setQuantiteInventaire(quantite);

		inventaire.getObjets().add(objetInventaire);
		repoInventaire.save(inventaire);
	}

	@Transactional
	public void supprimerObjetInventaire(Objet obj, int quantite,Inventaire inventaire ) {

	List<ObjetInventaire> objets =inventaire.getObjets();
	
      for (int i=0;i<objets.size();i++) 
    	  
      {		ObjetInventaire objet=objets.get(i);
    	  if(obj==objet.getObjet())
      	  {     if (quantite < objet.getQuantiteInventaire() && quantite>0) {
    			objet.setQuantiteInventaire(objet.getQuantiteInventaire()-quantite);
    			repoInventaire.save(inventaire);
      	  		}
      	  
      	  		else if (quantite == objet.getQuantiteInventaire())
      	  			repoObjetInventaire.deleteById(objet.getObjInventaireId());//on suprime l'element 
      	  		else 
      	  	      	System.out.println("Mauvaise quantite selectionné");
      	  }
      }
	}
    	  
    	  
    	  

/*
	@Transactional
	public void achatObjet(Boutique b, Inventaire i, Personnage p) {
		// le type de la boutique depend de l'evenement
		System.out.println("vous etes dans " + b.getTypeBoutique());
		System.out.println("Les articles disponibles dans cette boutique sont :");
		// AffichageObjetsBoutique(e);
		// AffichageObjets(repoObjet.findAllBoutique(b.getId()));
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
			this.ajoutObjetInventaire(obj, qteAchete,i);
		} else {
			System.out.println("vous n'avez pas assez de sous pour acheter ces produits");
			return;
		}
	}
*/
	
	@Transactional
	public void achatObjet(Boutique b, Inventaire i, Personnage p, Objet obj, int qteAchete ) {		
		
		float prix = obj.getPrix() * qteAchete;
		if (p.getArgent() >= prix) // verification si le personnage a assez de sous pour acheter les produits
									// selectionne
		{
			p.setArgent(p.getArgent() - prix);
			this.ajoutObjetInventaire(obj, qteAchete,i);
		} else {
			System.out.println("vous n'avez pas assez de sous pour acheter ces produits");
			return;
		}
	}

	
	
	@Transactional
	/*public void venteObjet(Boutique b, Inventaire i, Personnage p) {
		System.out.println("vous etes dans " + b.getTypeBoutique());
		System.out.println("les articles que vous disposez sont ");
		// AffichageObjets(repoObjet.findAllInventaire(i.getId()));
		System.out.println("Quel article voulez vous vendre ?"); // a voir est ce que la boutique achete ou pas les
																	// articles
		int idx = sc.nextInt();
		System.out.println("quelle est la quantite que vous voulez vendre ?");
		int qteVendue = sc.nextInt();
		Objet obj = i.getListeObjetInventaire().get(idx - 1);
		float prix = obj.getPrix() * qteVendue;
		p.setArgent(p.getArgent() + prix);
		this.supprimerObjetInventaire(obj, qteVendue,i);
	}
*/
	public void venteObjet(Inventaire inv, Personnage p,Objet obj, int qteVendue) {

		float prix = obj.getPrix() * qteVendue;
		p.setArgent(p.getArgent() + prix);
		this.supprimerObjetInventaire(obj, qteVendue,inv);
	}
	
/*public void AffichageObjets(List<Objet> A) {
for (int j = 1; j < A.size(); j++) {
System.out.println(j + "--" + A.get(j));
}
}*/
	
@Autowired
private IObjetRepository repoObjet;
	
	
	public List<Objet> findAll() {
		List<Objet> Objets = this.repoObjet.findAll();
		
		if (Objets == null) {
			return new ArrayList<>();
		}
		
		return Objets;
	}
	
	public Objet findById(int id) {
		if (id<=0) {
			throw new InvalidArgsException("id");
		}
		System.out.println(id);
		System.out.println(this.repoObjet.findById(id));

		Objet Objet = this.repoObjet.findById(id).get();
		System.out.println();
		if(Objet==null) {
			throw new EntityNotFoundException();
		}
		return Objet;
		
	}
	
	public void save(Objet objet) {
		if (objet.getNom() == null || objet.getNom().isBlank()) {
			throw new InvalidEntityException("nom");
		}
		
		
		repoObjet.save(objet);
	}
	public void deleteById(int id) {
		if (id<=0) {
			throw new InvalidArgsException("id");
		}
		
		repoObjet.deleteById(id);
	}

}
