package fr.projetjeu.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="environnement")
public class Environnement {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "env_id")
	private Integer id;
	
	@Column(name="env_nom",nullable=false)
	private String nom;
	
	@Column(name="env_temperature")
	private float temperature;
	
	@Enumerated(EnumType.ORDINAL)
	@Column(name="env_type_meteo",nullable=false)
	private Meteo meteo;
	
	@Enumerated(EnumType.ORDINAL)
	@Column(name="env_type_environnement",nullable=false)
	private TypeEnvironnement environnement;
	
	@JsonIgnore
	@OneToMany(mappedBy="environnement")
	private List<Partie> parties;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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

	public List<Partie> getParties() {
		return parties;
	}

	public void setParties(List<Partie> parties) {
		this.parties = parties;
	}



}
