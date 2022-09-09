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
@JoinColumn(name="btq_obj_id", nullable = false)
private  Objet objet;

@ManyToOne 
@JoinColumn(name="obj_btq_id", nullable = false)
private Boutique boutique;


@Column(name = "qte_boutique", nullable = false)
int quantiteBoutique;
}
