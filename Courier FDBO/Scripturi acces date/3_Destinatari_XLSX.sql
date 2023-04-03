CREATE OR REPLACE DIRECTORY ext_file_ds_2 AS 'C:\Data\Excel';

DROP VIEW COURIER_DESTINATARI;
CREATE OR REPLACE VIEW COURIER_DESTINATARI AS
select t.*
from TABLE(
       ExcelTable.getRows(
         ExcelTable.getFile('EXT_FILE_DS_2','3_Destinatari.xlsx')
       , 'DESTINATARI'
       ,   '"id_destinatar"      number,
            "nume"          VARCHAR2(50),
            "prenume"       VARCHAR2(50),
            "cod_postal"    number,
            "adresa"        VARCHAR2(100),
            "nr_telefon"            number'
       , 'A2'
       )
     ) t;
     
     SELECT * FROM COURIER_DESTINATARI;