package fr.projetjeu.model;

public class Objet {
private String nom;
private boolean typeObjetAlimentaire;
private TypeObjets typeObjets;
private float prix;
private int quantite;
public String getNom() {
	return nom;
}
public void setNom(String nom) {
	this.nom = nom;
}
public boolean isTypeObjetAlimentaire() {
	return typeObjetAlimentaire;
}
public void setTypeObjetAlimentaire(boolean typeObjetAlimentaire) {
	this.typeObjetAlimentaire = typeObjetAlimentaire;
}
public float getPrix() {
	return prix;
}
public void setPrix(float prix) {
	this.prix = prix;
}
public int getQuantite() {
	return quantite;
}
public void setQuantite(int quantite) {
	this.quantite = quantite;
}
public String toString() {
	return this.nom +"--Prix="+ this.prix+"--Qte="+this.quantite ;
}
}
