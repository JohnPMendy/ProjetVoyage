package fr.projetjeu.model;

public class Objet {
	private String nom;

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	private int quantite;

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}
	
	
	@Override
	public String toString() {
		return "objet : " +this.nom + "   quantité :  " + this.quantite;
	}

}
