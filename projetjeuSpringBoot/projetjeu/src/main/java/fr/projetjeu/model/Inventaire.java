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
@Table(name = "inventaire")
public class Inventaire {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "inv_id")
	private Integer id;

	@OneToMany(mappedBy = "inventaire")
	private List<ObjetInventaire> objets;


	@OneToOne(mappedBy = "inventaire")
	private Partie partie;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}


	public Partie getPartie() {
		return partie;
	}

	public void setPartie(Partie partie) {
		this.partie = partie;
	}

	public List<ObjetInventaire> getObjets() {
		return objets;
	}

	public void setObjets(List<ObjetInventaire> objets) {
		this.objets = objets;
	}




}
