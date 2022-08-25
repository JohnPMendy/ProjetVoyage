package fr.projetjeu.model;

public class Reponse {
	private int id =0;
	private String texte;
	private int evenementId;
	private int prochainEvenementId;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTexte() {
		return texte;
	}
	public void setTexte(String texte) {
		this.texte = texte;
	}
	public int getEvenementId() {
		return evenementId;
	}
	public void setEvenementId(int evenementId) {
		this.evenementId = evenementId;
	}
	public int getProchainEvenementId() {
		return prochainEvenementId;
	}
	public void setProchainEvenementId(int prochainEvenementId) {
		this.prochainEvenementId = prochainEvenementId;
	}
	
	
}
