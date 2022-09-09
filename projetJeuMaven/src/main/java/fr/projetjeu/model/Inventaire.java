package fr.projetjeu.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "inventaire")
public class Inventaire {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "inv_id")
	private int id;


	@ManyToMany(mappedBy = "inventaires")
	private List<Objet> listeObjetInventaire = new ArrayList<>();

	@OneToOne(mappedBy = "inventaire")
	private Partie partie;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Objet> getListeObjetInventaire() {
		return listeObjetInventaire;
	}

	public void setListeObjetInventaire(List<Objet> listeObjetInventaire) {
		this.listeObjetInventaire = listeObjetInventaire;
	}

	public Partie getPartie() {
		return partie;
	}

	public void setPartie(Partie partie) {
		this.partie = partie;
	}



}
