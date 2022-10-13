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
  rep_cond_objet INT NULL,
  rep_fin BOOLEAN NULL
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
insert into "evenement" ("evt_histoire", "evt_id", "evt_meteo") values ('Event 1 : Vous êtes sur le point de partir en vacances, votre valise est supposément prête... Voulez vous vérifier son contenu à nouveau?', 1, 1);
insert into "evenement" ("evt_histoire", "evt_id", "evt_meteo") values ('Event 2 : Vous êtes a l''aéroport, on vous demande le visa.', 2, 1);
insert into "evenement" ("evt_histoire", "evt_id", "evt_meteo") values ('Event 3 : Vous êtes dans l''avion, direction Tahiti. Que voulez vous faire actuellement?', 3, 1);
insert into "evenement" ("evt_histoire", "evt_id", "evt_meteo") values ('Event 4 : Le temps passe un peu trop lentement à votre gout, que souhaitez vous faire pour remédier à cela.', 4, 1);
insert into "evenement" ("evt_histoire", "evt_id", "evt_meteo") values ('Event 6 : Vous êtes mort... à quoi vous attendiez vous?', 6, 1);
insert into "evenement" ("evt_histoire", "evt_id", "evt_meteo") values ('Event 5 : Le trajet est terminé, vous êtes à destination. Ou souhaitez vous aller en premier?', 5, 1);
insert into "evenement" ("evt_histoire", "evt_id", "evt_meteo") values ('Event 7 : Après une bonne journée de bronzage, vous souhaitez integrer une soirée hypée de la vile. Le videur vous demande un prix d''entrée de 10000 euros...', 7, 1);
insert into "evenement" ("evt_histoire", "evt_id", "evt_meteo") values ('Event 8 : Durant la séance de musculation, vous vous sentez en confiance. Souhaitez vous soulever la barre de 150kg?', 8, 1);
insert into "evenement" ("evt_histoire", "evt_id", "evt_meteo") values ('Event 9 : En tentant de soulever le poids, vous perdez l''équilibre, et la barre atterit violemment sur votre gorge... Fin de séance!!', 9, 1);
insert into "evenement" ("evt_histoire", "evt_id", "evt_meteo") values ('Event 10 : Après être rentré à l''hotel, vous passez des vacances somme toute assez classique... FIN!', 10, 1);
insert into "evenement" ("evt_histoire", "evt_id", "evt_meteo") values ('Event 11 : Le videur refuse la proposition. Jette le coquillage par terre, s''en suit une explosion brutale. En effet, le coquillage était piégé... ', 11, 1);
insert into "evenement" ("evt_histoire", "evt_id", "evt_meteo") values ('Event 12 : Après cette séance de musculation sans risque, vous décidez de passer votre temps de la même manière... sans risques et sans saveur... FIN!', 12, 1);


insert into "reponse" ("rep_argent", "rep_cond_argent", "rep_cond_covid", "rep_cond_energie", "rep_cond_faim", "rep_cond_force", "rep_cond_objet", "rep_cond_poids", "rep_covid", "rep_energie", "rep_evenement_id", "rep_faim", "rep_fin", "rep_force", "rep_id", "rep_objet", "rep_poids", "rep_prochain_evenement_id", "rep_texte", "rep_vivant") values (0, NULL, false, 5, NULL, NULL, NULL, NULL, 0, 0, 1, 5, false, 0, 1, 3, 0, 2, 'Oui, je veux vérifier la valise à nouveau', true);
insert into "reponse" ("rep_argent", "rep_cond_argent", "rep_cond_covid", "rep_cond_energie", "rep_cond_faim", "rep_cond_force", "rep_cond_objet", "rep_cond_poids", "rep_covid", "rep_energie", "rep_evenement_id", "rep_faim", "rep_fin", "rep_force", "rep_id", "rep_objet", "rep_poids", "rep_prochain_evenement_id", "rep_texte", "rep_vivant") values (0, NULL, false, NULL, NULL, NULL, NULL, NULL, 0, 0, 1, 0, false, 0, 2, NULL, 0, 2, 'Non, je suis sur que tout est en ordre!', true);
insert into "reponse" ("rep_argent", "rep_cond_argent", "rep_cond_covid", "rep_cond_energie", "rep_cond_faim", "rep_cond_force", "rep_cond_objet", "rep_cond_poids", "rep_covid", "rep_energie", "rep_evenement_id", "rep_faim", "rep_fin", "rep_force", "rep_id", "rep_objet", "rep_poids", "rep_prochain_evenement_id", "rep_texte", "rep_vivant") values (0, NULL, false, 5, NULL, NULL, NULL, 1, 2, 0, 2, 5, false, 0, 4, NULL, 0, 1, 'Retourner chez soi', true);
insert into "reponse" ("rep_argent", "rep_cond_argent", "rep_cond_covid", "rep_cond_energie", "rep_cond_faim", "rep_cond_force", "rep_cond_objet", "rep_cond_poids", "rep_covid", "rep_energie", "rep_evenement_id", "rep_faim", "rep_fin", "rep_force", "rep_id", "rep_objet", "rep_poids", "rep_prochain_evenement_id", "rep_texte", "rep_vivant") values (0, NULL, false, 5, NULL, NULL, NULL, NULL, 0, 0, 3, 5, false, 0, 5, NULL, 0, 4, 'Regarder un film', true);
insert into "reponse" ("rep_argent", "rep_cond_argent", "rep_cond_covid", "rep_cond_energie", "rep_cond_faim", "rep_cond_force", "rep_cond_objet", "rep_cond_poids", "rep_covid", "rep_energie", "rep_evenement_id", "rep_faim", "rep_fin", "rep_force", "rep_id", "rep_objet", "rep_poids", "rep_prochain_evenement_id", "rep_texte", "rep_vivant") values (0, NULL, false, NULL, NULL, NULL, NULL, NULL, 0, 10, 3, 5, false, 0, 6, NULL, 0, 4, 'Dormir', true);
insert into "reponse" ("rep_argent", "rep_cond_argent", "rep_cond_covid", "rep_cond_energie", "rep_cond_faim", "rep_cond_force", "rep_cond_objet", "rep_cond_poids", "rep_covid", "rep_energie", "rep_evenement_id", "rep_faim", "rep_fin", "rep_force", "rep_id", "rep_objet", "rep_poids", "rep_prochain_evenement_id", "rep_texte", "rep_vivant") values (0, NULL, false, NULL, NULL, NULL, 4, NULL, 0, 10, 3, -5, false, 0, 7, NULL, 1, 4, 'Manger votre dernière barre chocolaté', true);
insert into "reponse" ("rep_argent", "rep_cond_argent", "rep_cond_covid", "rep_cond_energie", "rep_cond_faim", "rep_cond_force", "rep_cond_objet", "rep_cond_poids", "rep_covid", "rep_energie", "rep_evenement_id", "rep_faim", "rep_fin", "rep_force", "rep_id", "rep_objet", "rep_poids", "rep_prochain_evenement_id", "rep_texte", "rep_vivant") values (0, NULL, false, NULL, NULL, NULL, NULL, NULL, 0, 0, 4, 0, false, 0, 8, NULL, 0, 5, 'Attendre patiemment', true);
insert into "reponse" ("rep_argent", "rep_cond_argent", "rep_cond_covid", "rep_cond_energie", "rep_cond_faim", "rep_cond_force", "rep_cond_objet", "rep_cond_poids", "rep_covid", "rep_energie", "rep_evenement_id", "rep_faim", "rep_fin", "rep_force", "rep_id", "rep_objet", "rep_poids", "rep_prochain_evenement_id", "rep_texte", "rep_vivant") values (0, NULL, false, NULL, NULL, NULL, NULL, NULL, 0, 0, 4, 0, true, 0, 9, NULL, 0, 6, 'Ouvrir le cockpit!', false);
insert into "reponse" ("rep_argent", "rep_cond_argent", "rep_cond_covid", "rep_cond_energie", "rep_cond_faim", "rep_cond_force", "rep_cond_objet", "rep_cond_poids", "rep_covid", "rep_energie", "rep_evenement_id", "rep_faim", "rep_fin", "rep_force", "rep_id", "rep_objet", "rep_poids", "rep_prochain_evenement_id", "rep_texte", "rep_vivant") values (0, NULL, false, 5, NULL, NULL, NULL, 1, 4, 0, 5, 5, false, 0, 10, 5, 0, 7, 'Aller à la plage', true);
insert into "reponse" ("rep_argent", "rep_cond_argent", "rep_cond_covid", "rep_cond_energie", "rep_cond_faim", "rep_cond_force", "rep_cond_objet", "rep_cond_poids", "rep_covid", "rep_energie", "rep_evenement_id", "rep_faim", "rep_fin", "rep_force", "rep_id", "rep_objet", "rep_poids", "rep_prochain_evenement_id", "rep_texte", "rep_vivant") values (0, 30, false, 15, NULL, NULL, NULL, NULL, 10, 0, 5, 10, false, 10, 11, NULL, 2, 8, 'Aller à salle', true);
insert into "reponse" ("rep_argent", "rep_cond_argent", "rep_cond_covid", "rep_cond_energie", "rep_cond_faim", "rep_cond_force", "rep_cond_objet", "rep_cond_poids", "rep_covid", "rep_energie", "rep_evenement_id", "rep_faim", "rep_fin", "rep_force", "rep_id", "rep_objet", "rep_poids", "rep_prochain_evenement_id", "rep_texte", "rep_vivant") values (0, NULL, false, NULL, NULL, NULL, NULL, NULL, 0, 0, 7, 0, true, 0, 12, NULL, 0, 10, 'C''est trop cher, je rentre à l''hotel.', true);
insert into "reponse" ("rep_argent", "rep_cond_argent", "rep_cond_covid", "rep_cond_energie", "rep_cond_faim", "rep_cond_force", "rep_cond_objet", "rep_cond_poids", "rep_covid", "rep_energie", "rep_evenement_id", "rep_faim", "rep_fin", "rep_force", "rep_id", "rep_objet", "rep_poids", "rep_prochain_evenement_id", "rep_texte", "rep_vivant") values (0, NULL, false, NULL, NULL, NULL, 5, NULL, 0, 0, 7, 0, true, 0, 13, NULL, 0, 11, 'Lui présenter le coquillage que vous aviez trouvé à la plage ce matin', false);
insert into "reponse" ("rep_argent", "rep_cond_argent", "rep_cond_covid", "rep_cond_energie", "rep_cond_faim", "rep_cond_force", "rep_cond_objet", "rep_cond_poids", "rep_covid", "rep_energie", "rep_evenement_id", "rep_faim", "rep_fin", "rep_force", "rep_id", "rep_objet", "rep_poids", "rep_prochain_evenement_id", "rep_texte", "rep_vivant") values (0, NULL, false, NULL, NULL, NULL, NULL, NULL, 0, 0, 8, 0, true, 0, 14, NULL, 0, 9, 'Oui, alons y!', false);
insert into "reponse" ("rep_argent", "rep_cond_argent", "rep_cond_covid", "rep_cond_energie", "rep_cond_faim", "rep_cond_force", "rep_cond_objet", "rep_cond_poids", "rep_covid", "rep_energie", "rep_evenement_id", "rep_faim", "rep_fin", "rep_force", "rep_id", "rep_objet", "rep_poids", "rep_prochain_evenement_id", "rep_texte", "rep_vivant") values (NULL, NULL, false, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 8, NULL, true, NULL, 15, NULL, NULL, 12, 'Non ca ira...', true);
insert into "reponse" ("rep_argent", "rep_cond_argent", "rep_cond_covid", "rep_cond_energie", "rep_cond_faim", "rep_cond_force", "rep_cond_objet", "rep_cond_poids", "rep_covid", "rep_energie", "rep_evenement_id", "rep_faim", "rep_fin", "rep_force", "rep_id", "rep_objet", "rep_poids", "rep_prochain_evenement_id", "rep_texte", "rep_vivant") values (0, 400, false, NULL, NULL, NULL, NULL, NULL, 0, 0, 2, 0, false, 0, 3, NULL, 0, 3, 'Présenter le visa', true);

INSERT INTO competence (com_nom, com_des) VALUES ('Négociation', 'Permet de négocier des prix lors des achats');

insert into "objet" ("obj_id", "obj_nom", "obj_prix", "obj_type", "obj_type_alimentaire") values (1, 'Eau', 1, 1, true);
insert into "objet" ("obj_id", "obj_nom", "obj_prix", "obj_type", "obj_type_alimentaire") values (2, 'Boisson gazeuse', 1.5, 1, true);
insert into "objet" ("obj_id", "obj_nom", "obj_prix", "obj_type", "obj_type_alimentaire") values (3, 'Visa', 0, 1, false);
insert into "objet" ("obj_id", "obj_nom", "obj_prix", "obj_type", "obj_type_alimentaire") values (4, 'Barre chocolaté', 1, 1, true);
insert into "objet" ("obj_id", "obj_nom", "obj_prix", "obj_type", "obj_type_alimentaire") values (5, 'Coquillage', 10000, 1, false);

INSERT INTO boutique (btq_nom,btq_type)VALUES('Carrefour' , 1 );
INSERT INTO boutique (btq_nom,btq_type)VALUES('Decathlon' , 2 );

INSERT INTO inventaire DEFAULT VALUES;
INSERT INTO inventaire DEFAULT VALUES;


INSERT INTO objet_boutique(obj_btq_obj_id , obj_btq_btq_id,qte_boutique) VALUES(1,1,200); --l'objet d'id 1 est dans la boutique d'id 1 avec la quantite 200
INSERT INTO objet_boutique(obj_btq_obj_id , obj_btq_btq_id,qte_boutique) VALUES(2,1,200);
INSERT INTO objet_boutique(obj_btq_obj_id , obj_btq_btq_id,qte_boutique) VALUES(3,1,200);
INSERT INTO objet_boutique(obj_btq_obj_id , obj_btq_btq_id,qte_boutique) VALUES(4,1,200);

INSERT INTO objet_boutique(obj_btq_obj_id , obj_btq_btq_id,qte_boutique) VALUES(5,2,20);

insert into "objet_inventaire" ("objinv_id", "objinv_inv_id", "objinv_obj_id", "qte_inventaire") values (1, 1, 4, 1);
insert into "objet_inventaire" ("objinv_id", "objinv_inv_id", "objinv_obj_id", "qte_inventaire") values (2, 1, 1, 1);


insert into personnage (per_nom,per_prenom,per_poids,per_argent,per_energie, per_humeur, per_faim, per_force,per_covid, per_vivant)
values ('Lemaire','Pascal',75,2000,10,1,10,40,false,true);


INSERT INTO environnement(env_nom,env_temperature,env_type_meteo,env_type_environnement)
VALUES 
('Env1',25,1,1),
('Env2',27,2,2);

INSERT INTO compte (login,mdp,role) VALUES('admin','$2a$10$1oGuBqgzfGzhkLX1hIXIdOUpOy5TswqdK4Y5Nn88ZZJMdAAvc1Xua','ROLE_ADMIN');
INSERT INTO compte (login,mdp,role) VALUES('user','$2a$10$tsTiy0kKXpWc9qhYRtkqA.Ku2kjdC5ma5mEUYcFAhsHhrVgoowRyO','ROLE_USER');

insert into competence(com_nom, com_des) values ('Organisation','Sait comment organiser rapidement ses affaires');
insert into competence(com_nom, com_des) values ('Linguistique','Ne connait pas de difficulté avec les langues étrangères');
insert into competence(com_nom, com_des) values ('sociabilite','Communique aisément avec les gens');
insert into competence(com_nom, com_des) values ('Orientation','Peut se retrouver facilement dans un endroit même si il ne le connait pas');
insert into competence(com_nom, com_des) values ('Connaissance sur le monde animal','Peut facilement apprivoiser les animaux sauvages');
insert into competence(com_nom, com_des) values ('culture generale','A une connaissance du monde approfondie');
insert into competence(com_nom, com_des) values ('reactivite','Réagit instantanément face à une attaque');
    
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
          
   














