DROP DIRECTORY ext_file_ds;
CREATE OR REPLACE DIRECTORY ext_file_ds AS 'C:\Data\CSV';
GRANT ALL ON DIRECTORY ext_file_ds TO PUBLIC;
SELECT * FROM all_directories;

DROP TABLE SOFERI;
CREATE TABLE SOFERI (
    id_sofer NUMBER,
    nume VARCHAR2(50),
    prenume VARCHAR2(50),
    varsta NUMBER(2),
gen VARCHAR2(2),
    status_marital VARCHAR2(2),
    numar_copii NUMBER(2),
    nivel_educational VARCHAR2(50),
    vechime_munca NUMBER(2),
    proprietar_casa VARCHAR2(2),
probleme_sanatate VARCHAR2(2),
    adresa VARCHAR2(100),
    mediu VARCHAR2(50),
    cod_postal NUMBER,
    km_parcursi NUMBER,
    categorie_permis VARCHAR2(3),
    scor_general NUMBER,
    salariu NUMBER
)
ORGANIZATION EXTERNAL (
  TYPE ORACLE_LOADER
  DEFAULT DIRECTORY ext_file_ds
  ACCESS PARAMETERS (
    RECORDS DELIMITED BY NEWLINE SKIP 1
    FIELDS TERMINATED BY ','
    MISSING FIELD VALUES ARE NULL
  )
  LOCATION ('7_SOFERI.csv')
)
REJECT LIMIT UNLIMITED;

SELECT * FROM SOFERI;