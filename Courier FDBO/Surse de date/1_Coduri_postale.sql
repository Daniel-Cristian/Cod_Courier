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
INSERT INTO coduri_postale VALUES (510003,	'Oarda',	'Alba');
INSERT INTO coduri_postale VALUES (435612,	'Rohia',	'Maramureș');
INSERT INTO coduri_postale VALUES (720001,	'Suceava',	'Suceava');
INSERT INTO coduri_postale VALUES (700934,	'Iasi',	'Iasi');
INSERT INTO coduri_postale VALUES (700950,	'Iasi',	'Iasi');
INSERT INTO coduri_postale VALUES (707020,	'Aroneanu',	'Iași');
INSERT INTO coduri_postale VALUES (80539,	'Giurgiu',	'Giurgiu');
INSERT INTO coduri_postale VALUES (530183,	'Miercurea-Ciuc',	'Harghita');
INSERT INTO coduri_postale VALUES (237260,	'Milcov',	'Olt');
INSERT INTO coduri_postale VALUES (237261,	'Ipotești',	'Olt');
INSERT INTO coduri_postale VALUES (307060,	'Biled',	'Timiș');
INSERT INTO coduri_postale VALUES (627246,	'Prahuda',	'Vrancea');
COMMIT;
