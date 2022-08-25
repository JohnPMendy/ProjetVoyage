--DROP DATABASE projet;

--CREATE DATABASE projet;


CREATE TABLE personnage( 
  per_id SERIAL PRIMARY KEY,
  per_nom VARCHAR(50),
  per_prenom VARCHAR(50),
  per_poids FLOAT,
  per_argent FLOAT,
  per_energie FLOAT,
  per_humeur VARCHAR(50),
  per_faim FLOAT,
  per_force FLOAT,
  per_covid BOOLEAN,
  per_vivant BOOLEAN
 );

CREATE TABLE partie(
  par_id SERIAL PRIMARY KEY,
  par_personnage_id INT,
  par_event_id INT,
  par_date DATE,
  par_heure TIME,
  par_environnement_id INT
  );

CREATE TABLE evenement(
  evt_id SERIAL PRIMARY KEY,
  evt_histoire VARCHAR(100)
);

Table reponse {
  rep_id int [pk,increment]
  rep_texte  VARCHAR(100)
  rep_evenement_id INT
  rep_prochain_evenement_id INT
}

CREATE TABLE environnement(
  env_id SERIAL PRIMARY KEY,
  env_temperature FLOAT,
  env_type_environnement VARCHAR(50),
  env_type_meteo VARCHAR(50)
);

CREATE TABLE inventaire(
  inv_id SERIAL PRIMARY KEY,
  inv_partie_id INT
);
		
CREATE TABLE objet(
    obj_id SERIAL primary key,
    obj_nom VARCHAR(100) NOT NULL,
    obj_type_alimentaire BOOLEAN NOT NULL,
    obj_prix FLOAT NOT NULL,
    obj_type VARCHAR(100) NOT NULL,
    obj_quantite_inventaire INT NULL,
    obj_quantite_boutique INT NULL,
    obj_boutique_id INT NULL,
    obj_inventaire_id INT NULL
);

CREATE TABLE boutique(
   btq_id SERIAL primary key,
   btq_nom VARCHAR(100) NOT NULL,
   btq_type VARCHAR(100) NOT NULL
 );


ALTER TABLE partie
    ADD CONSTRAINT FK_PartiePerso
        FOREIGN KEY (par_personnage_id)
        REFERENCES personnage (per_id)
        ON UPDATE CASCADE
        ON DELETE CASCADE;

ALTER TABLE partie
    ADD CONSTRAINT FK_PartieEvent
        FOREIGN KEY (par_event_id)
        REFERENCES evenement (evt_id)
        ON UPDATE CASCADE
        ON DELETE CASCADE;

ALTER TABLE partie
    ADD CONSTRAINT FK_PartieEnvironnement
        FOREIGN KEY (par_environnement_id)
        REFERENCES environnement (env_id)
        ON UPDATE CASCADE
        ON DELETE CASCADE;

ALTER TABLE objet
    ADD CONSTRAINT FK_ObjetBoutique
        FOREIGN KEY(obj_boutique_id)
        REFERENCES boutique(btq_id)
            ON UPDATE CASCADE
            ON DELETE CASCADE;

ALTER TABLE objet
    ADD CONSTRAINT FK_ObjetInventaire
        FOREIGN KEY(obj_inventaire_id)
        REFERENCES inventaire(inv_id)
            ON UPDATE CASCADE
            ON DELETE CASCADE;

ALTER TABLE inventaire
    ADD CONSTRAINT FK_InventairePartie
        FOREIGN KEY(inv_partie_id)
        REFERENCES partie(par_id)
            ON UPDATE CASCADE
            ON DELETE CASCADE;

ALTER TABLE reponse
    ADD CONSTRAINT FK_ReponseEvent
      FOREIGN KEY(rep_evenement_id)
      REFERENCES evenement(evt_id)
          ON UPDATE CASCADE
          ON DELETE CASCADE;

ALTER TABLE reponse
    ADD CONSTRAINT FK_ReponseProchainEvent
      FOREIGN KEY(rep_prochain_evenement_id)
      REFERENCES evenement(evt_id)
          ON UPDATE CASCADE
          ON DELETE CASCADE;

