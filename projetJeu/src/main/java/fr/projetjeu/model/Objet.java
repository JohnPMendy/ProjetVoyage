package fr.projetjeu.model;

public class Objet {
private int id;
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
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
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

public TypeObjets getTypeObjets() {
	return typeObjets;
}
public void setTypeObjets(TypeObjets typeObjets) {
	this.typeObjets = typeObjets;
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
