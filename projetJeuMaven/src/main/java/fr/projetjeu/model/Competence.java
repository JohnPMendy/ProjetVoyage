package fr.projetjeu.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="competence")
public class Competence {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "com_id")
	private int id;
	
	@Column(name="com_nom", length=50, nullable=false)
	private String nom;

		
	@Column(name="com_des", length=500)
	private String description;
	
	@ManyToMany(mappedBy="comper_competence_id")
	private List<Personnage> personnages;


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


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public List<Personnage> getPersonnages() {
		return personnages;
	}


	public void setPersonnages(List<Personnage> personnages) {
		this.personnages = personnages;
	}
	
	
}
