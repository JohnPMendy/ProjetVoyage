package fr.projetjeu.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Entity
public class ObjetInventaire {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int objInventaireId;

	@ManyToOne 
	@JoinColumn(name="inv_obj_id", nullable = false)
	private  Objet objet;

	@ManyToOne 
	@JoinColumn(name="obj_btq_id", nullable = false)
	private Inventaire inventaire;

	int quantiteInventaire;
	}

