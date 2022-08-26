package fr.projetjeu.model;

public class Environnement {
	private int id;
	private String nom;
	private float temperature;
	private Meteo meteo;
	private TypeEnvironnement environnement;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public float getTemperature() {
		return temperature;
	}

	public void setTemperature(float temperature) {
		this.temperature = temperature;
	}

	public Meteo getMeteo() {
		switch (this.meteo) {
		case SOLEIL:
			System.out.println("Le temps est ensoleillé");
			break;
		case PLUIE:
			System.out.println("Le temps est pluvieux");
			break;
		case NEIGE:
			System.out.println("Le temps est neigeux");
			break;

		case ORAGE:
			System.out.println("Le temps est orageux");
			break;
		}
		return meteo;
	}

	public void setMeteo(Meteo meteo) {
		this.meteo = meteo;
	}

	public TypeEnvironnement getEnvironnement() {
		switch (this.environnement) {
		case VILLE:
			System.out.println("Vous êtes actuellement en ville");
			break;
		case DESERT:
			System.out.println("Vous êtes actuellement dans un désert");
			break;
		case FORET:
			System.out.println("Vous êtes actuellement dans une foret");
			break;

		case MER:
			System.out.println("Vous êtes actuellement en Mer");
			break;
		}
		return environnement;
	}

	public void setEnvironnement(TypeEnvironnement environnement) {
		this.environnement = environnement;
	}

}
