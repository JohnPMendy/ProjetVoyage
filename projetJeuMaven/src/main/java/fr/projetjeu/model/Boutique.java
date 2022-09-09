package fr.projetjeu.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


@Entity
@Table(name = "boutique")
public class Boutique {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "btq_id")
	private int id;
	
	@Column(name="btq_nom", length=100)
	private String nom;
	
	@Enumerated(EnumType.ORDINAL)
	@Column(name="btq_type",nullable=false)
	private TypeBoutique typeBoutique;
	
	@ManyToMany(mappedBy="boutiques")
	List<Objet> objets;

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

	public TypeBoutique getTypeBoutique() {
		return typeBoutique;
	}

	public void setTypeBoutique(TypeBoutique typeBoutique) {
		this.typeBoutique = typeBoutique;
	}

	public List<Objet> getObjets() {
		return objets;
	}

	public void setObjets(List<Objet> objets) {
		this.objets = objets;
	}
	

		

}
