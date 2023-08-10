CREATE OR REPLACE DIRECTORY ext_file_ds_2 AS 'C:\Data\Excel';

DROP VIEW COURIER_VEHICULE;
CREATE OR REPLACE VIEW COURIER_VEHICULE AS
select t.*
from TABLE(
       ExcelTable.getRows(
         ExcelTable.getFile('EXT_FILE_DS_2','9_Vehicule.xlsx')
       , 'VEHICULE'
       ,   '"id_vehicul"      number,
            "marca"          VARCHAR2(50),
            "model"       VARCHAR2(50),
            "categorie_vehicul"    VARCHAR2(3),
            "nr_inmatriculare"        VARCHAR2(10),
            "data_inmatriculare" VARCHAR2(10),
            "an_fabricatie"            number,
            "km"            number,
            "tip_motor"    VARCHAR2(3),
            "carburant"    VARCHAR2(10),
             "putere"            number,
            "probleme_tehnice"    VARCHAR2(2),
            "itp_valabil"    VARCHAR2(2),
            "asigurare_valabila"    VARCHAR2(2),
            "tip_transmisie" VARCHAR2(2),
            "istoric_accident" VARCHAR2(2),
            "pret_achizitie"  number'
       , 'A2'
       )
     ) t;
     
     SELECT * FROM COURIER_VEHICULE;