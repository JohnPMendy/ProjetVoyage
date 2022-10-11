package fr.projetjeu.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table(name = "reponse")
public class Reponse {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-increment
	@JsonView(JsonViews.Common.class)
	@Column(name = "rep_id")
	private Integer id;
	
	@Column(name = "rep_texte", nullable = false)
	@JsonView(JsonViews.Common.class)
	private String texte;
	
	
	@ManyToOne
	@JoinColumn(name="rep_evenement_id", nullable = false)
	private Events evenementId;
	

	@OneToOne
	@JsonView(JsonViews.Common.class)
	@JoinColumn(name = "rep_prochain_evenement_id", nullable = false)
	private Events prochainEvenementId;
	
	@Column(name = "rep_poids", nullable = true)
	@JsonView(JsonViews.Common.class)
	private Integer ajoutPoids;
	
	@Column(name = "rep_argent", nullable = true)
	@JsonView(JsonViews.Common.class)
	private Integer ajoutArgent;
	
	@Column(name = "rep_energie", nullable = true)
	@JsonView(JsonViews.Common.class)
	private Integer ajoutEnergie;
	
	@Column(name = "rep_force", nullable = true)
	@JsonView(JsonViews.Common.class)
	private Integer ajoutForce;
	
	@Column(name = "rep_covid", nullable = true)
	@JsonView(JsonViews.Common.class)
	private Integer ajoutCovid;
	
	@JsonView(JsonViews.Common.class)
	@Column(name = "rep_vivant", nullable = true)
	private boolean isAlive;
	
	@OneToOne
	@JsonView(JsonViews.Common.class)
	@JoinColumn(name = "rep_meteo", nullable = true)
	private Environnement environnementId;
	
	@OneToOne
	@JsonView(JsonViews.Common.class)
	@JoinColumn(name = "rep_objet", nullable = true)
	private Objet objetId;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTexte() {
		return texte;
	}
	public void setTexte(String texte) {
		this.texte = texte;
	}
	public Events getEvenementId() {
		return evenementId;
	}
	public void setEvenementId(Events evenementId) {
		this.evenementId = evenementId;
	}
	public Events getProchainEvenementId() {
		return prochainEvenementId;
	}
	public void setProchainEvenementId(Events prochainEvenementId) {
		this.prochainEvenementId = prochainEvenementId;
	}

}
