delete from reponse;
ALTER TABLE reponse ALTER COLUMN rep_id RESTART WITH 1;


delete from evenement;
ALTER TABLE evenement ALTER COLUMN evt_id RESTART WITH 1;

delete from competence;
ALTER TABLE competence ALTER COLUMN com_id RESTART WITH 1;

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
--INSERT INTO reponse (rep_texte, rep_evenement_id, rep_prochain_evenement_id) VALUES ('R4 : Licorne', 1, 8 );
INSERT INTO reponse (rep_texte, rep_evenement_id, rep_prochain_evenement_id) VALUES ('R1 : Oui', 2, 3 );
INSERT INTO reponse (rep_texte, rep_evenement_id, rep_prochain_evenement_id) VALUES ('R2 : Non', 2, 4 );
INSERT INTO reponse (rep_texte, rep_evenement_id, rep_prochain_evenement_id) VALUES ('R1 : Oui', 5, 6 );
INSERT INTO reponse (rep_texte, rep_evenement_id, rep_prochain_evenement_id) VALUES ('R2 : Non', 5, 7 );

INSERT INTO competence(com_nom, com_des) VALUES ('Négociation', 'Permet de négocier des prix lors des achats');
INSERT INTO competence(com_nom, com_des) VALUES ('Langue : anglais', 'Parle couramment anglais');
INSERT INTO personnage(per_nom, per_prenom, per_poids, per_argent, per_energie, per_humeur,per_faim,per_force,per_covid,per_vivant) 
VALUES ('un','perso',50.5,0.0,0.0,1,0.0,0.0,false, true);

-- ALTER TABLE reponse DROP CONSTRAINT FK_ReponseEvent;
-- ALTER TABLE reponse DROP CONSTRAINT FK_ReponseProchainEvent;


-- ALTER TABLE reponse
--     ADD CONSTRAINT FK_ReponseEvent
--       FOREIGN KEY(rep_evenement_id)
--       REFERENCES evenement(evt_id)
--           ON UPDATE CASCADE
--           ON DELETE CASCADE;

-- ALTER TABLE reponse
--     ADD CONSTRAINT FK_ReponseProchainEvent
--       FOREIGN KEY(rep_prochain_evenement_id)
--       REFERENCES evenement(evt_id)
--           ON UPDATE CASCADE
--           ON DELETE CASCADE;

