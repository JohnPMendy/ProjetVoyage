package fr.projetjeu.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "objetInventaire")
public class ObjetInventaire {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "objinv_id")
	private Integer objInventaireId;

	@ManyToOne
	@JoinColumn(name = "objinv_obj_id", nullable = false)
	private Objet objet;

	@ManyToOne
	@JoinColumn(name = "objinv_inv_id", nullable = false)
	private Inventaire inventaire;

	@Column(name = "qte_inventaire", nullable = false)
	int quantiteInventaire;

	public Integer getObjInventaireId() {
		return objInventaireId;
	}

	public void setObjInventaireId(Integer objInventaireId) {
		this.objInventaireId = objInventaireId;
	}

	public Objet getObjet() {
		return objet;
	}

	public void setObjet(Objet objet) {
		this.objet = objet;
	}

	public Inventaire getInventaire() {
		return inventaire;
	}

	public void setInventaire(Inventaire inventaire) {
		this.inventaire = inventaire;
	}

	public int getQuantiteInventaire() {
		return quantiteInventaire;
	}

	public void setQuantiteInventaire(int quantiteInventaire) {
		this.quantiteInventaire = quantiteInventaire;
	}

}
