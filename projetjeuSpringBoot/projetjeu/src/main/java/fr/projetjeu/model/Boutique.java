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

import com.fasterxml.jackson.annotation.JsonView;


@Entity
@Table(name = "boutique")
public class Boutique {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "btq_id")
	@JsonView(JsonViews.Common.class)
	private Integer id;
	
	@Column(name="btq_nom", length=100)
	@JsonView(JsonViews.Common.class)
	private String nom;
	
	@Enumerated(EnumType.ORDINAL)
	@JsonView(JsonViews.Common.class)
	@Column(name="btq_type",nullable=false)
	private TypeBoutique typeBoutique;

	@JsonView(JsonViews.BoutiqueAvecObjets.class)
	@OneToMany(mappedBy = "boutique")
	private List<ObjetBoutique> objets;


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

	public TypeBoutique getTypeBoutique() {
		return typeBoutique;
	}

	public void setTypeBoutique(TypeBoutique typeBoutique) {
		this.typeBoutique = typeBoutique;
	}

	public List<ObjetBoutique> getObjets() {
		return objets;
	}

	public void setObjets(List<ObjetBoutique> objets) {
		this.objets = objets;
	}


}
