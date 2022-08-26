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
  evt_histoire VARCHAR(2000) NOT NULL
);

CREATE TABLE reponse (
  rep_id SERIAL PRIMARY KEY,
  rep_texte  VARCHAR(200),
  rep_evenement_id INT NULL,
  rep_prochain_evenement_id INT NULL
);


CREATE TABLE environnement(
  env_id SERIAL PRIMARY KEY,
  env_temperature FLOAT,
  env_type_environnement INT NOT NULL,
  env_type_meteo INT NOT NULL
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

ALTER TABLE environnement
  ADD CONSTRAINT chk_meteo
  CHECK (env_type_meteo [0-4]);

  ALTER TABLE environnement
  ADD CONSTRAINT chk_environnement
  CHECK (env_type_environnement [0-4]);
          
--Exemples pour faire des tests (Questions/Reponses)
INSERT INTO evenement (evt_histoire) VALUES ('Event 1 : Locomotion?');
INSERT INTO evenement (evt_histoire) VALUES ('Event 2 : Ouverture cockpit?');
INSERT INTO evenement (evt_histoire) VALUES ('Event 3 : Vous êtes mort (FIN)');
INSERT INTO evenement (evt_histoire) VALUES ('Event 4 : A suivre... (FIN)');
INSERT INTO evenement (evt_histoire) VALUES ('Event 5 : Sauter du bateau?');
INSERT INTO evenement (evt_histoire) VALUES ('Event 6 : Vous êtes mort (FIN)');
INSERT INTO evenement (evt_histoire) VALUES ('Event 7 : A suivre... (FIN)');
INSERT INTO evenement (evt_histoire) VALUES ('Event 8 : Vous êtes mort (FIN)');

INSERT INTO reponse (rep_texte, rep_evenement_id, rep_prochain_evenement_id) VALUES ('R1 : Avion', 1, 2 );
INSERT INTO reponse (rep_texte, rep_evenement_id, rep_prochain_evenement_id) VALUES ('R2 : Bateau', 1, 5 );
INSERT INTO reponse (rep_texte, rep_evenement_id, rep_prochain_evenement_id) VALUES ('R3 : Nage', 1, 8 );
INSERT INTO reponse (rep_texte, rep_evenement_id, rep_prochain_evenement_id) VALUES ('R1 : Oui', 2, 3 );
INSERT INTO reponse (rep_texte, rep_evenement_id, rep_prochain_evenement_id) VALUES ('R2 : Non', 2, 4 );
INSERT INTO reponse (rep_texte, rep_evenement_id, rep_prochain_evenement_id) VALUES ('R1 : Oui', 5, 6 );
INSERT INTO reponse (rep_texte, rep_evenement_id, rep_prochain_evenement_id) VALUES ('R2 : Non', 5, 7 );
