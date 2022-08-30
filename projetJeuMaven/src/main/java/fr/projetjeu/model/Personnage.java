package fr.projetjeu.model;

public class Personnage {
	private int id;
	private String nom;
	private String prenom;

	private float poids;
	private float argent;
	private float energie;
	private float faim;
	private float force;
	private boolean isCovided;
	private boolean isAlive;

	private Humeur humeur;
	private Competences competences;

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

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public float getPoids() {
		return poids;
	}

	public void setPoids(float poids) {
		this.poids = poids;
	}

	public float getArgent() {
		return argent;
	}

	public void setArgent(float argent) {
		this.argent = argent;
	}

	public float getEnergie() {
		return energie;
	}

	public void setEnergie(float energie) {
		this.energie = energie;
	}

	public float getFaim() {
		return faim;
	}

	public void setFaim(float faim) {
		this.faim = faim;
	}

	public float getForce() {
		return force;
	}

	public void setForce(float force) {
		this.force = force;
	}

	public boolean isCovided() {
		return isCovided;
	}

	public void setCovided(boolean isCovided) {
		this.isCovided = isCovided;
	}

	public Humeur getHumeur() {
		return humeur;
	}

	public void setHumeur(Humeur humeur) {
		this.humeur = humeur;
	}

	public Competences getCompetences() {
		return competences;
	}

	public void setCompetences(Competences competences) {
		this.competences = competences;
	}

	public boolean isAlive() {
		return isAlive;
	}

	public void setAlive(boolean isAlive) {
		this.isAlive = isAlive;
	}

}
