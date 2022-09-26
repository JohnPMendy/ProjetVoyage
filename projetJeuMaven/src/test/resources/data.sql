DELETE FROM partie;
ALTER TABLE partie ALTER COLUMN par_id RESTART WITH 1;

DELETE FROM environnement;
ALTER TABLE environnement ALTER COLUMN env_id RESTART WITH 1;

DELETE FROM evenement;
ALTER TABLE evenement ALTER COLUMN evt_id RESTART WITH 1;

DELETE FROM competence;
ALTER TABLE competence ALTER COLUMN com_id RESTART WITH 1;

DELETE FROM personnage;
ALTER TABLE personnage ALTER COLUMN per_id RESTART WITH 1;

DELETE FROM inventaire;
ALTER TABLE inventaire ALTER COLUMN inv_id RESTART WITH 1;


INSERT INTO environnement(env_nom,env_temperature,env_type_meteo,env_type_environnement)
VALUES 
('N1',25,1,1),
('N2',27,2,2);


INSERT INTO evenement(evt_histoire) VALUES 
('Event 1 : Locomotion?'),
('Event 2 : Ouverture cockpit?'),
('Event 3 : Vous êtes mort FIN');

INSERT INTO competence(com_nom, com_des) VALUES 
('Négociation', 'Permet de négocier des prix lors des achats'),
('Competence2', 'Test');


INSERT INTO personnage(per_nom,per_prenom,per_poids,per_argent,per_energie,per_humeur,per_faim,per_force,per_covid,per_vivant)
VALUES
('N1','P1',50.0,50.0,50.0,2,50.0,50.0,true,true),
('N2','P2',55.0,40.0,30.0,1,60.0,40.0,false,true);

INSERT INTO inventaire DEFAULT VALUES;
INSERT INTO inventaire DEFAULT VALUES;


INSERT INTO partie(par_personnage_id,par_event_id,par_environnement_id,par_inventaire_id,par_date)
VALUES
(1,1,1,1,'2022-09-01'),
(2,2,2,2,'2022-09-01');



