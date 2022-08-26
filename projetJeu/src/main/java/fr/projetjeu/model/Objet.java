package fr.projetjeu.model;

public class Objet {
private int id;
private String nom;
private boolean typeObjetAlimentaire;
private float prix;
private TypeObjets typeObjets;
private int quantiteInventaire;
private int quantiteBoutique;
private Boutique boutique;
private Inventaire inventaire;

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


public int getQuantiteInventaire() {
	return quantiteInventaire;
}
public void setQuantiteInventaire(int quantiteInventaire) {
	this.quantiteInventaire = quantiteInventaire;
}


public int getQuantiteBoutique() {
	return quantiteBoutique;
}
public void setQuantiteBoutique(int quantiteBoutique) {
	this.quantiteBoutique = quantiteBoutique;
}


public Boutique getBoutique() {
	return boutique;
}
public void setBoutique(Boutique boutique) {
	this.boutique = boutique;
}


public Inventaire getInventaire() {
	return inventaire;
}
public void setInventaire(Inventaire inventaire) {
	this.inventaire = inventaire;
}


public String toString() {
	return this.nom +"--Prix="+ this.prix+"--Qte dans boutique="+this.quantiteBoutique +"--Qte votre inventaire="+this.quantiteInventaire;
}
}
