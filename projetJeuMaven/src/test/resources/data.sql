DELETE FROM environnement;
ALTER TABLE environnement ALTER COLUMN env_id RESTART WITH 1;

INSERT INTO environnement(env_nom,env_temperature,env_type_meteo,env_type_environnement)

VALUES 
('N1',25,1,1),
('N2',27,2,2);