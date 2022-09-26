package fr.projetjeu.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "personnage")
public class Personnage {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-increment
	@Column(name = "per_id")
	private int id;
	
	@Column(name = "per_nom", length=50, nullable = false)
	private String nom;
	
	@Column(name = "per_prenom", length=50, nullable = false)
	private String prenom;

	@Column(name = "per_poids", nullable = false)
	private float poids  =0;
	
	@Column(name = "per_argent", nullable = false)
	private float argent=0;
	
	@Column(name = "per_energie", nullable = false)
	private float energie=0;
	
	@Column(name = "per_faim", nullable = false)
	private float faim=0;
	
	@Column(name = "per_force", nullable = false)
	private float force=0;
	
	@Column(name = "per_covid", nullable = false )
	private boolean isCovided=false;
	
	@Column(name = "per_vivant", nullable = false)
	private boolean isAlive=true;

	@Enumerated(EnumType.ORDINAL)
	@Column(name="per_humeur",nullable=false)
	private Humeur humeur;
	

	@ManyToMany
	@JoinTable(
			name = "competence_personnage",
			joinColumns = @JoinColumn(name  ="comper_personnage_id"),
			inverseJoinColumns = @JoinColumn(name = "comper_competence_id")
		)
	private List<Competence> competences;

	
	@OneToOne(mappedBy  ="personnage")
	private Partie partie;
	

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



	public List<Competence> getCompetences() {
		return competences;
	}

	public void setCompetences(List<Competence> competences) {
		this.competences = competences;
	}

	public Partie getPartie() {
		return partie;
	}

	public void setPartie(Partie partie) {
		this.partie = partie;
	}

	public boolean isAlive() {
		return isAlive;
	}

	public void setAlive(boolean isAlive) {
		this.isAlive = isAlive;
	}

	
}

