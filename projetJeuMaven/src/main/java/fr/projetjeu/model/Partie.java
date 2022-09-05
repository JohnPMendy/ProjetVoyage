package fr.projetjeu.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="partie")
public class Partie {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "par_id")
	private int id;
	
	@OneToOne
	@JoinColumn(name="par_personnage_id", nullable = false)
	private Personnage personnage;
	
	//@ManyToOne
	//@JoinColumn(name="par_event_id", nullable = false)
	private Events eventRunning;
	
	@Column(name="par_date", nullable=false)
	private LocalDateTime date;
	
	@ManyToOne
	@JoinColumn(name="par_environnement_id", nullable=false)
	private Environnement environnement;
	
	@OneToOne
	@JoinColumn(name="par_inventaire_id", nullable=false)
	private Inventaire inventaire;

	public int getId() {
		return id;
	}

	public void setId(int id) {
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

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
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
	
	
	
}
