package fr.projetjeu.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "objet")
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
	


	
	public String getNom() {
		return nom;
	}

	/*@ManyToMany
	@JoinTable(name = "boutique_objet", joinColumns = @JoinColumn(name = "btob_objet_id"), inverseJoinColumns = @JoinColumn(name = "btob_boutique_id"))
	private List<Boutique> boutiques;

	@OneToMany(mappedBy= "objet" )
	private List<ObjetBoutique> objetBoutiques;
	
	@OneToMany(mappedBy = "objet")
	private List<ObjetInventaire> objetInventaires;

	public String getNom() {
		return nom;
	}
*/
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


	public String toString() {
		return this.nom + "--Prix=" + this.prix ;
				
	}
}
