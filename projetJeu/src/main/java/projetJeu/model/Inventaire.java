package projetJeu.model;

import java.util.ArrayList;
import java.util.List;

public class Inventaire {
 private List<Objet> listeObjetInventaire =new  ArrayList<>();
 
 
 public void ajoutObjet (Objet obj, int quantite) {
	 obj.setQuantite(quantite);
	 this.listeObjetInventaire.add(obj);
 }
 
 public void supprimer (Objet obj, int quantite) {
	 obj.setQuantite(obj.getQuantite()-quantite);
	 this.listeObjetInventaire.remove(obj);
 }

 
}
