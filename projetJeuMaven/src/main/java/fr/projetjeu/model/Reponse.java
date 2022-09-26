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
	@JoinColumn(name = "rep_prochain_evenement_id", nullable = false)
	private Events prochainEvenementId;
	
	
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
