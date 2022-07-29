package projetJeu.model;

public class Environnement {
	private String nom;
	private float temperature;
	private Meteo meteo;
	private TypeEnvironnement environnement;
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
		return meteo;
	}
	public void setMeteo(Meteo meteo) {
		this.meteo = meteo;
	}
	public TypeEnvironnement getEnvironnement() {
		return environnement;
	}
	public void setEnvironnement(TypeEnvironnement environnement) {
		this.environnement = environnement;
	}
	
	
	
}
