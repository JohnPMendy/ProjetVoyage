package PartieMahmoud;

public class Boutique extends Events{
private String nom;

public String getNom() {
	return nom;
}
public void setNom(String nom) {
	this.nom = nom;
}

public void achatObjets(Events e, Inventaire i,int idx) {
	//idx c'est l'indice de l'objet a acheter de la boutique
	i.getListeObjetInventaire().add(e.getListeObjetEvent().get(idx));
}
public void venteObjets(Inventaire i, int idx) {
	//idx c'est l'indice de l'objet a vendre a la boutique
	i.getListeObjetInventaire().remove(idx);
	///////////////
}
}
