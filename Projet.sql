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
  par_compte_id INT NOT NULL,
  par_personnage_id INT NOT NULL,
  par_event_id INT NOT NULL,
  par_date DATE NOT NULL,
  par_environnement_id INT NOT NULL,
  par_inventaire_id INT NOT NULL
  );

CREATE TABLE evenement(
  evt_id SERIAL PRIMARY KEY,
  evt_histoire VARCHAR(2000) NOT NULL,
  evt_meteo INT NULL
);


--DROP TABLE reponse;
CREATE TABLE reponse (
  rep_id SERIAL PRIMARY KEY,
  rep_texte  VARCHAR(200),
  rep_evenement_id INT NULL,
  rep_prochain_evenement_id INT NULL,
  rep_poids INT NULL,
  rep_argent INT NULL,
  rep_energie INT NULL,
  rep_force INT NULL,
  rep_covid INT NULL,
  rep_faim INT NULL,
  rep_vivant BOOLEAN NULL,
  rep_objet INT NULL,
  rep_cond_faim INT NULL,
  rep_cond_poids INT NULL,
  rep_cond_argent INT NULL,
  rep_cond_energie INT NULL,
  rep_cond_force INT NULL,
  rep_cond_covid BOOLEAN NULL,
  rep_cond_objet INT NULL
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
    obj_type INT NOT NULL
);

CREATE TABLE boutique(
   btq_id SERIAL primary key,
   btq_nom VARCHAR(100) NOT NULL,
   btq_type INT NOT NULL
 );

CREATE TABLE objet_boutique(
   obj_btq_id SERIAL primary key,
   obj_btq_obj_id INT NULL,
   obj_btq_btq_id INT NULL,
   qte_boutique INT NULL
);

CREATE TABLE objet_inventaire(
   objinv_id SERIAL primary key,
   objinv_obj_id INT NULL,
   objinv_inv_id INT NULL,
   qte_inventaire INT NULL
);

CREATE TABLE compte(
id SERIAL primary key,
login varchar(50) NOT NULL,
mdp varchar(255) NOT NULL,
role varchar(50) NOT NULL
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

ALTER TABLE objet_boutique
    ADD CONSTRAINT FK_obj_btq_boutique
        FOREIGN KEY(obj_btq_btq_id)
        REFERENCES boutique(btq_id)
            ON UPDATE CASCADE
            ON DELETE CASCADE;

ALTER TABLE objet_boutique
    ADD CONSTRAINT FK_obj_btq_objet
        FOREIGN KEY(obj_btq_obj_id)
        REFERENCES objet(obj_id)
            ON UPDATE CASCADE
            ON DELETE CASCADE;

ALTER TABLE objet_inventaire
    ADD CONSTRAINT FK_Objinv_inventaire
        FOREIGN KEY(objinv_inv_id)
        REFERENCES inventaire(inv_id)
            ON UPDATE CASCADE
            ON DELETE CASCADE;

ALTER TABLE objet_inventaire
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
INSERT INTO evenement (evt_histoire,evt_meteo) VALUES 
('Event 1 : Locomotion?',1),
('Event 2 : Ouverture cockpit?',2),
('Event 3 : Vous êtes mort (FIN)',1),
('Event 4 : A suivre... (FIN)',2),
('Event 5 : Sauter du bateau?',1),
('Event 6 : Vous êtes mort (FIN)',2),
('Event 7 : A suivre... (FIN)',1),
('Event 8 : Vous êtes mort (FIN)',2);

insert into "reponse" ("rep_argent", "rep_cond_argent", "rep_cond_covid", "rep_cond_energie", "rep_cond_faim", "rep_cond_force", "rep_cond_objet", "rep_cond_poids", "rep_covid", "rep_energie", "rep_evenement_id", "rep_faim", "rep_force", "rep_id", "rep_objet", "rep_poids", "rep_prochain_evenement_id", "rep_texte", "rep_vivant") values (NULL, NULL, true, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, NULL, NULL, 3, 3, NULL, 8, 'R3 : Nage', false);
insert into "reponse" ("rep_argent", "rep_cond_argent", "rep_cond_covid", "rep_cond_energie", "rep_cond_faim", "rep_cond_force", "rep_cond_objet", "rep_cond_poids", "rep_covid", "rep_energie", "rep_evenement_id", "rep_faim", "rep_force", "rep_id", "rep_objet", "rep_poids", "rep_prochain_evenement_id", "rep_texte", "rep_vivant") values (NULL, NULL, true, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 2, NULL, NULL, 4, 1, NULL, 3, 'R1 : Oui', true);
insert into "reponse" ("rep_argent", "rep_cond_argent", "rep_cond_covid", "rep_cond_energie", "rep_cond_faim", "rep_cond_force", "rep_cond_objet", "rep_cond_poids", "rep_covid", "rep_energie", "rep_evenement_id", "rep_faim", "rep_force", "rep_id", "rep_objet", "rep_poids", "rep_prochain_evenement_id", "rep_texte", "rep_vivant") values (NULL, NULL, false, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 2, NULL, NULL, 5, 3, NULL, 4, 'R2 : Non', false);
insert into "reponse" ("rep_argent", "rep_cond_argent", "rep_cond_covid", "rep_cond_energie", "rep_cond_faim", "rep_cond_force", "rep_cond_objet", "rep_cond_poids", "rep_covid", "rep_energie", "rep_evenement_id", "rep_faim", "rep_force", "rep_id", "rep_objet", "rep_poids", "rep_prochain_evenement_id", "rep_texte", "rep_vivant") values (NULL, NULL, true, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 5, NULL, NULL, 6, 2, NULL, 6, 'R1 : Oui', false);
insert into "reponse" ("rep_argent", "rep_cond_argent", "rep_cond_covid", "rep_cond_energie", "rep_cond_faim", "rep_cond_force", "rep_cond_objet", "rep_cond_poids", "rep_covid", "rep_energie", "rep_evenement_id", "rep_faim", "rep_force", "rep_id", "rep_objet", "rep_poids", "rep_prochain_evenement_id", "rep_texte", "rep_vivant") values (NULL, NULL, false, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 5, NULL, NULL, 7, 4, NULL, 7, 'R2 : Non', false);
insert into "reponse" ("rep_argent", "rep_cond_argent", "rep_cond_covid", "rep_cond_energie", "rep_cond_faim", "rep_cond_force", "rep_cond_objet", "rep_cond_poids", "rep_covid", "rep_energie", "rep_evenement_id", "rep_faim", "rep_force", "rep_id", "rep_objet", "rep_poids", "rep_prochain_evenement_id", "rep_texte", "rep_vivant") values (0, 300, true, 10, 10, 30, 1, 70, 5, 0, 1, 0, 0, 1, 1, -5, 2, 'R1 : Avion', true);
insert into "reponse" ("rep_argent", "rep_cond_argent", "rep_cond_covid", "rep_cond_energie", "rep_cond_faim", "rep_cond_force", "rep_cond_objet", "rep_cond_poids", "rep_covid", "rep_energie", "rep_evenement_id", "rep_faim", "rep_force", "rep_id", "rep_objet", "rep_poids", "rep_prochain_evenement_id", "rep_texte", "rep_vivant") values (NULL, NULL, false, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, NULL, NULL, 2, 2, NULL, 5, 'R2 : Bateau', true);

INSERT INTO competence (com_nom, com_des) VALUES ('Négociation', 'Permet de négocier des prix lors des achats');

INSERT INTO objet (obj_nom,obj_type_alimentaire,obj_prix,obj_type)VALUES('Eau' , true , 1.0 , 1);   
INSERT INTO objet (obj_nom,obj_type_alimentaire,obj_prix,obj_type)VALUES('Boisson gazeuse', true , 1.5 , 1);
INSERT INTO objet (obj_nom,obj_type_alimentaire,obj_prix,obj_type)VALUES('Jus', true , 2.0 , 1 );
INSERT INTO objet (obj_nom,obj_type_alimentaire,obj_prix,obj_type)VALUES('Boisson chaude' , true , 1.5 , 1);

INSERT INTO objet (obj_nom,obj_type_alimentaire,obj_prix,obj_type)VALUES('jacket impermeable' , false , 60 , 4);

INSERT INTO boutique (btq_nom,btq_type)VALUES('Carrefour' , 1 );
INSERT INTO boutique (btq_nom,btq_type)VALUES('Decathlon' , 2 );

INSERT INTO inventaire DEFAULT VALUES;
INSERT INTO inventaire DEFAULT VALUES;


INSERT INTO objet_boutique(obj_btq_obj_id , obj_btq_btq_id,qte_boutique) VALUES(1,1,200); --l'objet d'id 1 est dans la boutique d'id 1 avec la quantite 200
INSERT INTO objet_boutique(obj_btq_obj_id , obj_btq_btq_id,qte_boutique) VALUES(2,1,200);
INSERT INTO objet_boutique(obj_btq_obj_id , obj_btq_btq_id,qte_boutique) VALUES(3,1,200);
INSERT INTO objet_boutique(obj_btq_obj_id , obj_btq_btq_id,qte_boutique) VALUES(4,1,200);

INSERT INTO objet_boutique(obj_btq_obj_id , obj_btq_btq_id,qte_boutique) VALUES(5,2,20);

INSERT INTO objet_inventaire(objinv_obj_id ,objinv_inv_id,qte_inventaire) VALUES(1,1,2);
INSERT INTO objet_inventaire(objinv_obj_id ,objinv_inv_id,qte_inventaire) VALUES(2,1,3);
INSERT INTO objet_inventaire(objinv_obj_id ,objinv_inv_id,qte_inventaire) VALUES(5,2,1);

INSERT INTO environnement(env_nom,env_temperature,env_type_meteo,env_type_environnement)
VALUES 
('Env1',25,1,1),
('Env2',27,2,2);



INSERT INTO compte (login,mdp,role) VALUES('admin','$2a$10$1oGuBqgzfGzhkLX1hIXIdOUpOy5TswqdK4Y5Nn88ZZJMdAAvc1Xua','ROLE_ADMIN');
INSERT INTO compte (login,mdp,role) VALUES('user','$2a$10$tsTiy0kKXpWc9qhYRtkqA.Ku2kjdC5ma5mEUYcFAhsHhrVgoowRyO','ROLE_USER');

insert into personnage (per_nom,per_prenom,per_poids,per_argent,per_energie, per_humeur, per_faim, per_force,per_covid, per_vivant)
values ('Lemaire','Pascal',0,0,0,1,0,0,false,true);

INSERT INTO inventaire DEFAULT VALUES;

  INSERT INTO
  partie(par_compte_id,par_personnage_id,par_inventaire_id,par_event_id,par_environnement_id,par_date) VALUES
  (1 ,(SELECT MAX(per_id) FROM personnage),(SELECT MAX(inv_id) FROM inventaire),1,1,'2020-01-01');
    Update inventaire set inv_partie_id=(SELECT MAX(par_id) FROM partie) where inv_id=(SELECT MAX(inv_id) FROM inventaire);

     insert into personnage (per_nom,per_prenom,per_poids,per_argent,per_energie, per_humeur, per_faim, per_force,per_covid, per_vivant)
values ('Jean','Marie',0,0,0,1,0,0,false,true);

INSERT INTO inventaire DEFAULT VALUES;

  INSERT INTO
  partie(par_compte_id,par_personnage_id,par_inventaire_id,par_event_id,par_environnement_id,par_date) VALUES
  (2,(SELECT MAX(per_id) FROM personnage),(SELECT MAX(inv_id) FROM inventaire),2,1,'2020-01-01');
    Update inventaire set inv_partie_id=(SELECT MAX(par_id) FROM partie) where inv_id=(SELECT MAX(inv_id) FROM inventaire);

insert into competence(com_nom, com_des) values ('Organisation','Sait comment organiser rapidement ses affaires');
insert into competence(com_nom, com_des) values ('Linguistique','Ne connait pas de difficulté avec les langues étrangères');
insert into competence(com_nom, com_des) values ('Sociabilté','Communique aisément avec les gens');
insert into competence(com_nom, com_des) values ('Orientation','Peut se retrouver facilement dans un endroit même si il ne le connait pas');
insert into competence(com_nom, com_des) values ('Connaissance sur le monde animal','Peut facilement apprivoiser les animaux sauvages');
insert into competence(com_nom, com_des) values ('Culture générale','A une connaissance du monde approfondie');
insert into competence(com_nom, com_des) values ('Réactivité','Réagit instantanément face à une attaque');

       ALTER TABLE evenement      
            ADD CONSTRAINT FK_EvenementMeteo
      FOREIGN KEY(evt_meteo)
      REFERENCES environnement(env_id)
          ON UPDATE CASCADE
          ON DELETE CASCADE;
          
           ALTER TABLE reponse      
            ADD CONSTRAINT FK_ReponseObjet
      FOREIGN KEY(rep_objet)
      REFERENCES objet(obj_id)
          ON UPDATE CASCADE
          ON DELETE CASCADE;
          
   














