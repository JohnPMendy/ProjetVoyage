
delete from evenement;
ALTER TABLE evenement ALTER COLUMN evt_id RESTART WITH 1;

delete from reponse;
ALTER TABLE reponse ALTER COLUMN rep_id RESTART WITH 1;


delete from competence;
ALTER TABLE competence ALTER COLUMN com_id RESTART WITH 1;

DELETE FROM partie;
ALTER TABLE partie ALTER COLUMN par_id RESTART WITH 1;

DELETE FROM environnement;
ALTER TABLE environnement ALTER COLUMN env_id RESTART WITH 1;


DELETE FROM personnage;
ALTER TABLE personnage ALTER COLUMN per_id RESTART WITH 1;

DELETE FROM inventaire;
ALTER TABLE inventaire ALTER COLUMN inv_id RESTART WITH 1;

DELETE FROM objet;
ALTER TABLE objet ALTER COLUMN obj_id RESTART WITH 1;

DELETE FROM boutique;
ALTER TABLE boutique ALTER COLUMN btq_id RESTART WITH 1;

INSERT INTO evenement (evt_histoire) VALUES ('Event 1 : Locomotion?');
INSERT INTO evenement (evt_histoire) VALUES ('Event 2 : Ouverture cockpit?');
INSERT INTO evenement (evt_histoire) VALUES ('Event 5 : Sauter du bateau?');
INSERT INTO evenement (evt_histoire) VALUES ('Event 7 : A suivre... (FIN)');
INSERT INTO evenement (evt_histoire) VALUES ('Event 8 : Vous êtes mort (FIN)');