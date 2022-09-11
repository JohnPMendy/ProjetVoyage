package fr.projetjeu.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class ObjetBoutique {
	
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int ObjetBoutiqueId;

@ManyToOne 
@JoinColumn(name="objBtq_obj_id", nullable = false)
private  Objet objet;

@ManyToOne 
@JoinColumn(name="objBtq_btq_id", nullable = false)
private Boutique boutique;


@Column(name = "qte_boutique", nullable = false)
int quantiteBoutique;


public int getObjetBoutiqueId() {
	return ObjetBoutiqueId;
}


public void setObjetBoutiqueId(int objetBoutiqueId) {
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
