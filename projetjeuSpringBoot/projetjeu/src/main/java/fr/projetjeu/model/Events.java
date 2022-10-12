
package fr.projetjeu.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table(name = "evenement")
public class Events {

	// Variables (SQL)

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "evt_id")
	@JsonView(JsonViews.Common.class)
	private Integer id;

	@Column(name = "evt_histoire", length = 2000, nullable = true)
	@JsonView(JsonViews.Events.class)
	private String histoire = "";
	
	@OneToMany(mappedBy = "evenementId")
	private List<Reponse> reponses;

	@OneToOne(mappedBy = "prochainEvenementId")
	private Reponse reponse;

	// Parties utilisants l'event
	@OneToMany(mappedBy = "eventRunning")
	private List<Partie> parties;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonView(JsonViews.Events.class)
	@JoinColumn(name = "evt_meteo", nullable = true)
	private Environnement environnementId;

	// Getters et setters
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getHistoire() {
		return histoire;
	}

	public void setHistoire(String histoire) {
		this.histoire = histoire;
	}

	public List<Reponse> getReponses() {
		return reponses;
	}

	public void setReponses(List<Reponse> reponses) {
		this.reponses = reponses;
	}

	public Reponse getReponse() {
		return reponse;
	}

	public void setReponse(Reponse reponse) {
		this.reponse = reponse;
	}

	public List<Partie> getParties() {
		return parties;
	}

	public void setParties(List<Partie> parties) {
		this.parties = parties;
	}

}
