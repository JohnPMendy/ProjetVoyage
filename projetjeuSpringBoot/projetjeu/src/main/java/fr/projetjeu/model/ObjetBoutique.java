package fr.projetjeu.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;


@Entity
@Table(name = "objet_boutique")
public class ObjetBoutique {
	
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name = "objbtq_id")
@JsonView(JsonViews.Common.class)
private Integer ObjetBoutiqueId;

@ManyToOne 
@JoinColumn(name="objBtq_obj_id", nullable = false)
@JsonView(JsonViews.BoutiqueAvecObjets.class)
private  Objet objet;

@ManyToOne 
@JoinColumn(name="objBtq_btq_id", nullable = false)
//@JsonView(JsonViews.Common.class)
private Boutique boutique;


@Column(name = "qte_boutique", nullable = false)
@JsonView(JsonViews.Common.class)
int quantiteBoutique;


public Integer getObjetBoutiqueId() {
	return ObjetBoutiqueId;
}


public void setObjetBoutiqueId(Integer objetBoutiqueId) {
	ObjetBoutiqueId = objetBoutiqueId;
}


public Objet getObjet() {
	return objet;
}


public void setObjet(Objet objet) {
	this.objet = objet;
}


public Boutique getBoutique() {
	return boutique;
}


public void setBoutique(Boutique boutique) {
	this.boutique = boutique;
}


public int getQuantiteBoutique() {
	return quantiteBoutique;
}


public void setQuantiteBoutique(int quantiteBoutique) {
	this.quantiteBoutique = quantiteBoutique;
}

}
