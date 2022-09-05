package fr.projetjeu.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="objet")
public class Objet {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "obj_id")
	private int id;
	
	@Column(name="obj_nom",length=100,nullable=false)
	private String nom;
	
	@Column(name="obj_type_alimentaire",nullable=false)
	private boolean typeObjetAlimentaire;
	
	@Column(name="obj_prix",nullable=false)
	private float prix;
	
	@Enumerated(EnumType.ORDINAL)
	@Column(name="obj_type",nullable=false)
	private TypeObjets typeObjets;
	
	@Column(name="obj_quantite_inventaire")
	private int quantiteInventaire;
	
	@Column(name="obj_quantite_boutique")
	private int quantiteBoutique;
	
	@ManyToMany
	@JoinTable(
			name = "boutique_objet",
			joinColumns = @JoinColumn(name  ="btob_objet_id"),
			inverseJoinColumns = @JoinColumn(name = "btob_boutique_id")
		)
	private List<Boutique> boutiques;
	
	@ManyToMany
	@JoinTable(
			name = "inventaire_objet",
			joinColumns = @JoinColumn(name  ="invobj_objet_id"),
			inverseJoinColumns = @JoinColumn(name = "invobj_inventaire_id")
		)
	private List<Inventaire> inventaires;

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean isTypeObjetAlimentaire() {
		return typeObjetAlimentaire;
	}

	public void setTypeObjetAlimentaire(boolean typeObjetAlimentaire) {
		this.typeObjetAlimentaire = typeObjetAlimentaire;
	}

	public float getPrix() {
		return prix;
	}

	public TypeObjets getTypeObjets() {
		return typeObjets;
	}

	public void setTypeObjets(TypeObjets typeObjets) {
		this.typeObjets = typeObjets;
	}

	public void setPrix(float prix) {
		this.prix = prix;
	}

	public int getQuantiteInventaire() {
		return quantiteInventaire;
	}

	public void setQuantiteInventaire(int quantiteInventaire) {
		this.quantiteInventaire = quantiteInventaire;
	}

	public int getQuantiteBoutique() {
		return quantiteBoutique;
	}

	public void setQuantiteBoutique(int quantiteBoutique) {
		this.quantiteBoutique = quantiteBoutique;
	}



	public List<Boutique> getBoutiques() {
		return boutiques;
	}

	public void setBoutiques(List<Boutique> boutiques) {
		this.boutiques = boutiques;
	}



	public List<Inventaire> getInventaires() {
		return inventaires;
	}

	public void setInventaires(List<Inventaire> inventaires) {
		this.inventaires = inventaires;
	}

	public String toString() {
		return this.nom + "--Prix=" + this.prix + "--Qte dans boutique=" + this.quantiteBoutique
				+ "--Qte votre inventaire=" + this.quantiteInventaire;
	}
}
