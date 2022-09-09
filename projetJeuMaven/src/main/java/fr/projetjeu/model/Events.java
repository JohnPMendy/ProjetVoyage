
package fr.projetjeu.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "evenement")
public class Events {

	// Variables (SQL)

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "evt_id")
	private int id;

	@Column(name = "evt_histoire", length = 2000, nullable = true)
	private String histoire = "";

	@OneToMany(mappedBy = "evenementId")
	private List<Reponse> reponses;

	@OneToOne(mappedBy = "prochainEvenementId")
	private Reponse reponse;

	// Parties utilisant l'event
	@OneToMany(mappedBy = "eventRunning")
	private List<Partie> parties;

	// Getters et setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
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
