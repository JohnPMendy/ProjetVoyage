
--DROP DATABASE projet;
--CREATE DATABASE projet;

CREATE TABLE personnage( 
  per_id SERIAL PRIMARY KEY,
  per_nom VARCHAR(50) not null,
  per_prenom VARCHAR(50) NOT NULL,
  per_poids FLOAT NOT NULL,
  per_argent FLOAT NOT NULL,
  per_energie FLOAT NOT NULL,
  per_humeur INT NOT NULL,

  per_competences INT NOT NULL,

  per_faim FLOAT NOT NULL,
  per_force FLOAT NOT NULL,
  per_covid BOOLEAN NOT NULL,
  per_vivant BOOLEAN NOT NULL
 );

CREATE TABLE competence(
  com_id SERIAL PRIMARY KEY,
  com_nom VARCHAR(50) NOT NULL,
  com_des VARCHAR(500) 
);

CREATE TABLE partie(
  par_id SERIAL PRIMARY KEY,
  par_personnage_id INT NOT NULL,
  par_event_id INT NOT NULL,
  par_date DATE NOT NULL,
  par_heure TIME NOT NULL,
  par_environnement_id INT NOT NULL,
  par_inventaire_id INT NOT NULL
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
  env_nom VARCHAR(100) NOT NULL,
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
    obj_type INT NOT NULL,

);

CREATE TABLE boutique(
   btq_id SERIAL primary key,
   btq_nom VARCHAR(100) NOT NULL,
   btq_type INT NOT NULL
 );

CREATE TABLE objetBoutique(
   objbtq_id SERIAL primary key,
   objBtq_obj_id INT NULL,
   objBtq_btq_id INT NULL,
   qte_boutique INT NULL
);

CREATE TABLE objetInventaire(
   objinv_id SERIAL primary key,
   objinv_obj_id INT NULL,
   objinv_inv_id INT NULL,
   qte_inventaire INT NULL
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

ALTER TABLE objetBoutique
    ADD CONSTRAINT FK_ObjBtq_boutique
        FOREIGN KEY(objbtq_btq_id)
        REFERENCES boutique(btq_id)
            ON UPDATE CASCADE
            ON DELETE CASCADE;

ALTER TABLE objetBoutique
    ADD CONSTRAINT FK_ObjBtq_objet
        FOREIGN KEY(objbtq_obj_id)
        REFERENCES objet(obj_id)
            ON UPDATE CASCADE
            ON DELETE CASCADE;

ALTER TABLE objetInventaire
    ADD CONSTRAINT FK_Objinv_inventaire
        FOREIGN KEY(objinv_inv_id)
        REFERENCES inventaire(inv_id)
            ON UPDATE CASCADE
            ON DELETE CASCADE;

ALTER TABLE objetInventaire
    ADD CONSTRAINT FK_Objinv_objet
        FOREIGN KEY(objinv_obj_id)
        REFERENCES objet(obj_id)
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
  CHECK (env_type_meteo BETWEEN 0 AND 4);

  ALTER TABLE environnement
  ADD CONSTRAINT chk_environnement
  CHECK (env_type_environnement BETWEEN 0 AND 4);
          
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

INSERT INTO competence(com_nom, com_des) VALUES ('Négociation', 'Permet de négocier des prix lors des achats');

INSERT INTO objet (obj_nom,obj_type_alimentaire,obj_prix,obj_type)VALUES('Eau' , 1 , 1.0 , 1);   
INSERT INTO objet (obj_nom,obj_type_alimentaire,obj_prix,obj_type)VALUES('Boisson gazeuse', 1 , 1.5 , 1);
INSERT INTO objet (obj_nom,obj_type_alimentaire,obj_prix,obj_type)VALUES('Jus', 1 , 2.0 , 1 );
INSERT INTO objet (obj_nom,obj_type_alimentaire,obj_prix,obj_type)VALUES('Boisson chaude' , 1 , 1.5 , 1);

INSERT INTO objet (obj_nom,obj_type_alimentaire,obj_prix,obj_type)VALUES('jacket impermeable' , 0 , 60 , 4);

INSERT INTO boutique (btq_nom,btq_type)VALUES('Carrefour' , 1 );
INSERT INTO boutique (btq_nom,btq_type)VALUES('Decathlon' , 2 );

INSERT INTO inventaire (inv_partie_id)VALUES(1);
INSERT INTO inventaire (inv_partie_id)VALUES(2);


INSERT INTO objetBoutique(objBtq_obj_id , objBtq_btq_id,qte_boutique) VALUES(1,1,200); --l'objet d'id 1 est dans la boutique d'id 1 avec la quantite 2
INSERT INTO objetBoutique(objBtq_obj_id , objBtq_btq_id,qte_boutique) VALUES(5,2,20);

INSERT INTO objetInventaire(objinv_obj_id ,objinv_inv_id,qte_inventaire) VALUES(1,1,2);
INSERT INTO objetInventaire(objinv_obj_id ,objinv_inv_id,qte_inventaire) VALUES(5,2,1);

insert into personnage (per_nom,per_prenom,per_poids,per_argent,per_energie, per_humeur, per_faim, per_force,per_covid, per_vivant)
values ('Lemaire','Pascal',0,0,0,1,0,0,false,true)


