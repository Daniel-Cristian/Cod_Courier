DROP TABLE coduri_postale

CREATE TABLE coduri_postale (
    cod_postal numeric(6,0) NOT NULL,
    localitate character varying(50),
    judet character varying(50) NOT NULL,
    CONSTRAINT coduripostale_pkey PRIMARY KEY (cod_postal)
);

------------------------------------------------------------
DELETE FROM coduri_postale;

INSERT INTO coduri_postale VALUES (300150,	'Timisoara',	'Timis');
INSERT INTO coduri_postale VALUES (140010,	'Alexandria',	'Teleorman');
INSERT INTO coduri_postale VALUES (100187,	'Ploiesti',	'Prahova');
INSERT INTO coduri_postale VALUES (220130,	'Drobeta-Turnu S',	'Mehedinti');
INSERT INTO coduri_postale VALUES (540449,	'Targu Mures',	'Mures');
INSERT INTO coduri_postale VALUES (620011,	'Focsani',	'Vrancea');
INSERT INTO coduri_postale VALUES (200504,	'Craiova',	'Dolj');
INSERT INTO coduri_postale VALUES (400046,	'Cluj-Napoca',	'Cluj');
INSERT INTO coduri_postale VALUES (717247,	'Catamaresti',	'Botosani');
INSERT INTO coduri_postale VALUES (120115,	'Buzau',	'Buzau');

COMMIT;