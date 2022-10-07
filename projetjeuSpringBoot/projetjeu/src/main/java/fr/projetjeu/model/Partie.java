package fr.projetjeu.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table(name="partie")
public class Partie {

	@JsonView(JsonViews.Common.class)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "par_id")
	private Integer id;
	
	@JsonView(JsonViews.Partie.class)
	@Column(name="par_date", nullable=false)
	private Timestamp date;
	
	@JsonView(JsonViews.Partie.class)
	@OneToOne
	@JoinColumn(name="par_personnage_id", nullable = false)
	private Personnage personnage;
	
	@JsonView(JsonViews.Partie.class)
	@ManyToOne
	@JoinColumn(name="par_event_id", nullable = false)
	private Events eventRunning;
	
	@JsonView(JsonViews.Partie.class)
	@ManyToOne
	@JoinColumn(name="par_environnement_id", nullable=false)
	private Environnement environnement;
	
	@JsonView(JsonViews.Partie.class)
	@OneToOne
	@JoinColumn(name="par_inventaire_id", nullable=false)
	private Inventaire inventaire;
	
	@ManyToOne
	@JoinColumn(name="par_compte_id",nullable=false)
	private Compte compte;


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Personnage getPersonnage() {
		return personnage;
	}

	public void setPersonnage(Personnage personnage) {
		this.personnage = personnage;
	}

	public Events getEventRunning() {
		return eventRunning;
	}

	public void setEventRunning(Events eventRunning) {
		this.eventRunning = eventRunning;
	}

	public Timestamp getDate() {
		return date;
	}

	public void setDate(Timestamp date) {
		this.date = date;
	}

	public Environnement getEnvironnement() {
		return environnement;
	}

	public void setEnvironnement(Environnement environnement) {
		this.environnement = environnement;
	}

	public Inventaire getInventaire() {
		return inventaire;
	}

	public void setInventaire(Inventaire inventaire) {
		this.inventaire = inventaire;
	}

	public Compte getCompte() {
		return compte;
	}

	public void setCompte(Compte compte) {
		this.compte = compte;
	}
	
	
	
}
